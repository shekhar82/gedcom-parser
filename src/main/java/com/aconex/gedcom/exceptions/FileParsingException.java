/**
 * 
 */
package com.aconex.gedcom.exceptions;

/**
 * @author gupsh09
 *
 */
public class FileParsingException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileParsingException()
	{
		super(ErrorCodes.FILE_PARSING_EXCEPTION);
	}
	
	public FileParsingException(String message) {
		super(message,ErrorCodes.FILE_PARSING_EXCEPTION);
	}

	public FileParsingException(Throwable cause) {
		super(ErrorCodes.FILE_PARSING_EXCEPTION.getErrorMsg(), ErrorCodes.FILE_PARSING_EXCEPTION, cause);
	}

	public FileParsingException(String message,Throwable cause) {
		super(message, ErrorCodes.FILE_PARSING_EXCEPTION,cause);
	}

	

}
