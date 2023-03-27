package com.pyramix.sales.customer;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.event.Event;

import com.pyramix.sales.common.GFCBaseController;

public class CustomerListInfoControl extends GFCBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4260589773260032755L;

	private static Logger log = Logger.getLogger(CustomerListInfoControl.class);
	
	public void onCreate$customerListInfoDiv(Event event) throws Exception {
		log.info("customerListInfoDiv created...");
	}
}
