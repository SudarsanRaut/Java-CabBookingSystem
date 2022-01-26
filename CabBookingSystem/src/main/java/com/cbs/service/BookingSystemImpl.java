package com.cbs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.cbs.dao.BookingImpl;
import com.cbs.db.Dbconnect;
import com.cbs.exception.CabUnavailableException;
import com.cbs.model.Cab;

public class BookingSystemImpl implements BookingSystem{
    
	private Set<Cab> cabs=new LinkedHashSet<>();
	
	
	@Override
	public void addCab(Cab newCab) throws Exception {
		BookingImpl bi = new BookingImpl();
		cabs = bi.copyOfCabs();
		
		Connection con= Dbconnect.getConnection();//getting our connection object
		
		//adding new cab to the database
		PreparedStatement pst = con.prepareStatement("insert into cab(cabNo,bookingStatus) values (?,?);");
		pst.setInt(1, newCab.getCabNo());
		pst.setInt(2, newCab.getBookingStatus());
		pst.execute(); 
		//adding new cab into cabs set
		cabs.add(newCab); 
		
		
	}

	@Override
	public Integer requestCab() throws Exception {
		BookingImpl bi = new BookingImpl();
		cabs = bi.copyOfCabs();
		if(cabs.isEmpty()) {
			try {
				throw new CabUnavailableException("No cab is avalable for booking.");
			} catch (CabUnavailableException e) {
				System.out.println(e.getMessage());
				return -1;
			}
		}
		
		for(Cab c : cabs) {
			if(c.getBookingStatus() == 0) {
				c.setBookingStatus(1);
				return c.getCabNo();
			}
		}
		
		//If all cabs are booked then it will simply return -1;
		return -1;
		
	
	}

	@Override
	public Integer NoOfAvailableCabs() throws Exception {
		Integer count = 0;
		BookingImpl bi = new BookingImpl();
		cabs = bi.copyOfCabs();
		for(Cab c: cabs) {
			if(c.getBookingStatus() == 0) {
				count++;
			}
		}
		return count;// Returning total no of available cabs
	}

}
