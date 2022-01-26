package com.cbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.cbs.db.Dbconnect;
import com.cbs.model.Cab;

public class BookingImpl implements Booking{

	@Override
	public Set<Cab> copyOfCabs() {
		
		Set<Cab> cabs = new HashSet<>();
		 try {
			Connection con = Dbconnect.getConnection();
			PreparedStatement pst = con.prepareStatement("select cabNo, bookingStatus from cab;");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				//Creating a cab fetching details from the cab table in database
				//Using constructor to set the values of the cab object
				Cab c = new Cab(rs.getInt(1),rs.getInt(2));
				//adding cab objects to the cabs set
				cabs.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return cabs;
	}


    
}
