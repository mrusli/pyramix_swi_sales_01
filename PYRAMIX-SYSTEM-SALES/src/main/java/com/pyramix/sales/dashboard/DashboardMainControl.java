package com.pyramix.sales.dashboard;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.event.Event;

import com.pyramix.sales.common.GFCBaseController;

public class DashboardMainControl extends GFCBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2237596408737499849L;
	
	private static Logger log = Logger.getLogger(DashboardMainControl.class);
	
	public void onCreate$dashboardMainPanel(Event event) throws Exception {
		log.info("DashboardMainControl created...");
	}

}
