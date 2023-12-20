package com.pyramix.sales.main;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Include;

import com.pyramix.sales.common.GFCBaseController;

public class Main02Control extends GFCBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8423433052870306214L;
	
	private Include main02Include, main02Profile;
	
	private final Logger log = Logger.getLogger(Main02Control.class);
	
	public void onCreate$main02Win(Event event) throws Exception {
		log.info("main02Control created...");
		
		main02Include.setSrc("~./secure/dashboard/DashboardMain.zul");
		main02Profile.setSrc("~./secure/right/Right.zul");
	}
	
	public void onClickDashboardMenu(Event event) {
		log.info("onClickDashboardMenu..."+event.getData().toString());
		
		main02Include.setSrc("~./secure/dashboard/DashboardMain.zul");
	}

	public void onClickCustomerMenu(Event event) {
		log.info("onClickCustomerMenu..."+event.getData().toString());
		
		main02Include.setSrc("~./secure/customer/CustomerListInfo.zul");
	}
	
	public void onClickOrdersMenu(Event event) {
		log.info("onClickOrdersMenu..."+event.getData().toString());
		
		main02Include.setSrc("~./secure/orders/OrdersListInfo.zul");		
	}

	public void onClickUserProfile(Event event) {
		log.info("onClickUserProfile..."+event.getData().toString());
		
		main02Include.setSrc("~./secure/user/UserProfile.zul");		
	}
	
	public void onClickLogout(Event event) {
		log.info("onClickLogout..."+event.getData().toString());
		
		Executions.sendRedirect("/logout");
	}
}
