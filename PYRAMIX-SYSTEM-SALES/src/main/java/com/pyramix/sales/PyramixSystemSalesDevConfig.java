package com.pyramix.sales;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.zkoss.lang.Library;
import org.zkoss.zk.ui.WebApps;

@Configuration
@Profile("dev")
public class PyramixSystemSalesDevConfig {

	private static Logger log = Logger.getLogger(PyramixSystemSalesDevConfig.class);
	
	@PostConstruct
	public void initDevelopmentProperties() throws Exception {
		log.info("**************************************************************");
		log.info("**** ZK-Springboot: development configuration active *********");
		log.info("**************************************************************");
		
		//disable various caches to avoid server restarts
		Library.setProperty("org.zkoss.zk.ZUML.cache", "false");
		Library.setProperty("org.zkoss.zk.WPD.cache", "false");
		Library.setProperty("org.zkoss.zk.WCS.cache", "false");
		Library.setProperty("org.zkoss.web.classWebResource.cache", "false");
		Library.setProperty("org.zkoss.util.label.cache", "false");
		
		// enable non minified js
		WebApps.getCurrent().getConfiguration().setDebugJS(true);

		// enable for debugging MVVM commands and binding (very verbose)
		Library.setProperty("org.zkoss.bind.DebuggerFactory.enable", "false");		
	}
	
}
