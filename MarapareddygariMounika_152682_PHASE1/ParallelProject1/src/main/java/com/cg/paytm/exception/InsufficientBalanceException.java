package com.cg.paytm.exception;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 547095843033429431L;

	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}
