package com.capgemini.mybank.exception;

public class InvalidAccountNumberException extends Exception {

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Account number not found";
	}

	
	}

