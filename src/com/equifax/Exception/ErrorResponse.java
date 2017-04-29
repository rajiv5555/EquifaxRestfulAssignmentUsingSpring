/**
 * 
 */
package com.equifax.Exception;

/**
 * @author M1027962
 *
 */
public class ErrorResponse {
	
	private int statuscode;
	
	private String message;

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int i) {
		this.statuscode = i;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
