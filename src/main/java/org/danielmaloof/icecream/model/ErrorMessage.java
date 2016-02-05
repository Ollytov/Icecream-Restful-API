package org.danielmaloof.icecream.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	/*
	 *  A model used to create Error Message Responses for when an exception is caught and thrown.
	 *  Contains variables, constructors, and getters/setters for the ErrorMessage class.
	 */
	
	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
