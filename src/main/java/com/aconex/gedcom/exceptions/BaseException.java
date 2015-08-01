package com.aconex.gedcom.exceptions;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorCodes errorCode;

	public BaseException(ErrorCodes err) {
		this.errorCode = err;
	}

	public BaseException(String message, ErrorCodes code) {
		super(message);
		this.errorCode = code;
	}

	public BaseException(ErrorCodes err, Throwable cause) {
		this(err.getErrorMsg(), err, cause);
	}

	public BaseException(String message, ErrorCodes code, Throwable cause) {
		super(message, cause);
		this.errorCode = code;
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

}