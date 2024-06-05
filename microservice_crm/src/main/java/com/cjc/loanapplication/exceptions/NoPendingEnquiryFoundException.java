package com.cjc.loanapplication.exceptions;

public class NoPendingEnquiryFoundException extends RuntimeException {
	
	public NoPendingEnquiryFoundException(String msg)
	{
		super(msg);
	}

}
