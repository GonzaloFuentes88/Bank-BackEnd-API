package com.gonzalo.bankapibackend.exceptions;

public class InsufficientSalaryException extends Exception{

	
	public InsufficientSalaryException() {
		super("insufficient salary to carry out the transaction - Exception");
	}
	
	public InsufficientSalaryException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
