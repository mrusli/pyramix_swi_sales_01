package com.pyramix.sales.user;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.event.Event;

import com.pyramix.sales.common.GFCBaseController;

public class UserProfileControl extends GFCBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6698792780881879533L;

	private static Logger log = Logger.getLogger(UserProfileControl.class);
	
	public void onCreate$userProfileDiv(Event event) throws Exception {
		log.info("UserProfile Created...");
	}
}
