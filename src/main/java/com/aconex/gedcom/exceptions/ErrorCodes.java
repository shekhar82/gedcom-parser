/**
 * 
 */
package com.aconex.gedcom.exceptions;

/**
 * @author gupsh09
 *
 */
public enum ErrorCodes {

	FILE_PARSING_EXCEPTION(0,"FILE_PARSING_EXCEPTION"), NO_XML_SERVICE_EXCEPTION(1,"NO_XML_SERVICE_EXCEPTION");
	
	private int errorCode;
	private String errorMsg;
	
	
	private ErrorCodes(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
