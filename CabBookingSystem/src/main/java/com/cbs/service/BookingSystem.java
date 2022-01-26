package com.cbs.service;

import com.cbs.model.Cab;

public interface BookingSystem {
	void addCab(Cab newCab) throws Exception;
	Integer requestCab() throws Exception;
	Integer NoOfAvailableCabs() throws Exception;
   
}
