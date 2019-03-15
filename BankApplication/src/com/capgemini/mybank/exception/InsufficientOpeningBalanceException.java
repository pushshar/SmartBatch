package com.capgemini.mybank.exception;

public class InsufficientOpeningBalanceException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Opening balance is not enough" ;
	}

	
}
