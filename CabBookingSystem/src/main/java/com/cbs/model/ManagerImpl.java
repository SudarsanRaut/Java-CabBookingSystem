package com.cbs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cbs.db.Dbconnect;

public class ManagerImpl extends Employee {

	public ManagerImpl(Integer empId, String name, String email, Boolean managerOrNot, String dept) {
		super(empId, name, email, managerOrNot, dept);
		
	}
    
	
	public void accept() throws Exception{
		Connection con = Dbconnect.getConnection();
		Scanner scn = new Scanner(System.in);

		System.out.println("These are the  Cab requests that are pending!");
		System.out.println("Please approve or reject them.");
		PreparedStatement pt = con.prepareStatement("select * from request where statusId=1");
		ResultSet rs = pt.executeQuery();

		while(rs.next()) {
			System.out.println("Employee ID : " +rs.getInt(2) +" has requested an Cab with Request ID:"+rs.getInt(1));
			System.out.println("Approve or reject?\n Press y accept \n Press n to reject.");
			char m=scn.next().charAt(0);
			if(m=='y') {
				PreparedStatement pst = con.prepareStatement("update request set statusId=2 where requestId=?");
				pst.setInt(1, rs.getInt(1));
				int a = pst.executeUpdate(); //update
				System.out.println("Request Approved!");
				
			}
			else {
				PreparedStatement pst = con.prepareStatement("update request set statusId=3 where requestId=?");
				pst.setInt(1, rs.getInt(1));
				int a = pst.executeUpdate(); //update
				System.out.println("Request Rejected!");
			
			}
			return;
		}
		scn.close();
		
	}
	
	

}
