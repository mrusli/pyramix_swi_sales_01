package com.pyramix.sales.security;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class LoginEvalControl extends GenericForwardComposer<Component> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8670823246377541657L;
	
	private static Logger log = Logger.getLogger(LoginEvalControl.class);

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		log.info("LoginEvalController : after composing the zk window component");
	}
	
	public void onCreate$loginEvalWin(Event event) throws Exception {
		log.info("LoginEvalController : Evaluating login credentials...");
		
		String username = Executions.getCurrent().getParameter("username");
		log.info("Username : "+username);
	}

}
