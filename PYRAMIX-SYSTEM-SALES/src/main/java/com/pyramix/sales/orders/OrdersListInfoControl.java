package com.pyramix.sales.orders;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.event.Event;

import com.pyramix.sales.common.GFCBaseController;

public class OrdersListInfoControl extends GFCBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1124195932527305057L;

	private static Logger log = Logger.getLogger(OrdersListInfoControl.class);
	
	public void onCreate$ordersListInfoDiv(Event event) throws Exception {
		log.info("orderListInfoDiv created...");
	}
}
