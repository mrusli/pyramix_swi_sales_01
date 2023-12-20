package com.pyramix.sales.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private final Logger log = Logger.getLogger(LoginController.class);
	
	public LoginController() {
		super();
		
		log.info("---Login request controller activated");
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required = false) String error, HttpServletRequest request) {
		if (error != null) {
			log.info("---/login detected... [ERROR] but username / password NOT matched");
		} else {
			log.info("---/login detected... returning 'login' string...");
		}
		
		log.info("IP: "+request.getRemoteAddr());
		
		return "login";
	}
	
	/**
	 * Handles the "/success" URL.
	 * 
	 * ref: https://stackoverflow.com/questions/31524426/securityconfig-2-success-url-for-different-roles
	 * 
	 * @param request
	 * @return {@link String}
	 */
	@GetMapping("/success")
	public String landing(HttpServletRequest request) {
		// UsernamePasswordAuthenticationToken [Principal=com.pyramix.sales.security.UserSecurityDetails@660b0b6e, 
		// 	Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=2412FE524E940EAB7AF5D614DC9D9559], 
		//	Granted Authorities=[ROLE_USER, ROLE_ADMIN]]

		log.info("---Login Success with "+request.toString());		
		 
		// if (request.isUserInRole("ROLE_ADMIN")) {
		//	return "redirect:/admin/MainAdmin";
		// }
		
		return "secure/main02";
	}	
		
	@GetMapping("/secure/{page}")
	public String secure(@PathVariable String page) {
		log.info("---/secure/{page} detected... returning 'secure/"+page+"'"+" string...");		
		
		return "secure/"+page;
	}
}
