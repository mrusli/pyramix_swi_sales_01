package com.pyramix.sales.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurityConfig {
	
	@Autowired
	private UserSecurityControl userSecurityControl;	
	
	private static final String ZUL_FILES = "/zkau/web/**/*.zul";
    private static final String[] ZK_RESOURCES = {
            "/zkau/web/**/js/**",
            "/zkau/web/**/css/**",
            "/zkau/web/**/font/**",
            "/zkau/web/**/img/**"
    };
    private static final String REMOVE_DESKTOP_REGEX = "/zkau\\?dtid=.*&cmd_0=rmDesktop&.*";
    
    private final Logger log = Logger.getLogger(UserSecurityConfig.class);

    @Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		log.info("---Configure with HttpSecurity...");
		
		// ZK already sends a AJAX request with a built-in CSRF token
        // please refer to https://www.zkoss.org/wiki/ZK%20Developer's%20Reference/Security%20Tips/Cross-site%20Request%20Forgery
		httpSecurity.csrf().disable();
		
		httpSecurity.authenticationProvider(authenticationProvider());
		
		httpSecurity.authorizeRequests()
				.antMatchers(ZUL_FILES).denyAll() // block direct access to zul files
				.antMatchers(HttpMethod.GET, ZK_RESOURCES).permitAll() // allow zk resources
				.regexMatchers(HttpMethod.GET, REMOVE_DESKTOP_REGEX).permitAll() // allow desktop cleanup
				.requestMatchers(req -> "rmDesktop".equals(req.getParameter("cmd_0"))).permitAll() // allow desktop cleanup from ZATS
				.mvcMatchers("/secure/**").hasRole("USER")
				.mvcMatchers("/", "/login", "/logout").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login").permitAll()
					.defaultSuccessUrl("/success", true) // send to target URL; allows controller to process the default-target-url
					.failureUrl("/login?error=true")
			.and()
				.rememberMe()
				.key("aBcdeFghijklmNOPQRstuv12345678")
				.userDetailsService(getUserSecurityControl())
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
		
		return httpSecurity.build();
	}

    @Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(getUserSecurityControl());
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());		
		
		return authProvider;
	}

	public UserSecurityControl getUserSecurityControl() {
		return userSecurityControl;
	}

	public void setUserSecurityControl(UserSecurityControl userSecurityControl) {
		this.userSecurityControl = userSecurityControl;
	}
	
}
