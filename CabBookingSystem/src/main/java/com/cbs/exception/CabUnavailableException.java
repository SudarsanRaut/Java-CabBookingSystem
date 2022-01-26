package com.cbs.exception;

public class CabUnavailableException extends Exception{
	
	public CabUnavailableException(String str) {
		super(str);
	}

	@Override
	public String toString() {
		return "No cabs are available for booking rightnow";
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Please wait no cabs are available at this moment";
	}
	
	

}
