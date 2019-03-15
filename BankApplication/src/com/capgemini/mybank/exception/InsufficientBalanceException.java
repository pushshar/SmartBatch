package com.capgemini.mybank.exception;

public class InsufficientBalanceException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Balance is not sufficient";
	}

}
