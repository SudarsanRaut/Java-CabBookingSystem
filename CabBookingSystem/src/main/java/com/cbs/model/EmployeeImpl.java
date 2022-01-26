package com.cbs.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cbs.db.Dbconnect;

public class EmployeeImpl extends Employee {

	public EmployeeImpl(Integer id, String name, String email, String dept) {
		super(id,name,email,dept);
		
	}
	
	public void requests() throws Exception {
		Connection con = Dbconnect.getConnection(); 
		Scanner scn = new Scanner(System.in);
		PreparedStatement pst;
		ResultSet rs;
	
		while(true) {
			System.out.println("Hello!!! What do you want to do?");
			System.out.println("Press 1. to add a cab request");
			System.out.println("Press 2. to view your cab details history");
			System.out.println("Press any key to log out");
			
			int ch=scn.nextInt();
			switch(ch) {
			case 1:
			{
				pst = con.prepareStatement("insert into request (empId,statusId) values(?,?)");
				pst.setInt(1,this.getEmpId());
				pst.setInt(2, 1);
				pst.execute(); 
				System.out.println("Your cab is sended");
	
				break;
			}
			case 2:
			{
				
				pst = con.prepareStatement("select * from request where empId=?");
				pst.setInt(1,this.getEmpId());
				rs = pst.executeQuery();
				while(rs.next()) {
					int stat = rs.getInt(4);
					if(stat==1)
						System.out.println("Request ID: "+rs.getInt(1)+" is Requested");
					else if(stat==2)
						System.out.println("Request ID: "+rs.getInt(1)+" is Approved by your Manager");
					else if(stat==3)
						System.out.println("Request ID: "+rs.getInt(1)+" is Rejected by your Manager");
					else
						System.out.println("Request ID: "+rs.getInt(1)+" is Booked with Booking ID: "+rs.getInt(3));
				}
				
				break;
			}
			
			default:
			{   
				System.out.println("Logging out!!!");
				return;
			}
			
			}
			
			
				
		}
		
			
			
	}
}

	

