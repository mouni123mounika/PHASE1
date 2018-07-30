package com.cg.paytm.exception;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 4413249244891680445L;

	public InvalidInputException(String msg) {
		super(msg);
	}

}
