package com.pyramix.sales.common;

public class SuppressedException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5367618742302928992L;

	/**
	 * 	ref: https://stackoverflow.com/questions/11434431/exception-without-stack-trace-in-java
	 * 	Previously: 	
	 * 		IllegalArgumentException suppresedException = new IllegalArgumentException("No Journals for this Voucher");
	 * 		suppresedException.setStackTrace(new StackTraceElement[0]);
	 * 
	 * @param errorMessage
	 */
	public SuppressedException(String errorMessage) {
		super(errorMessage);
		
		this.setStackTrace(new StackTraceElement[0]);
	}

}
