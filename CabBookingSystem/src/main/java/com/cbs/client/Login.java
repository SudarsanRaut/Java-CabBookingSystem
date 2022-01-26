package com.cbs.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cbs.db.Dbconnect;
import com.cbs.model.Admin;
import com.cbs.model.EmployeeImpl;
import com.cbs.model.ManagerImpl;

public class Login {
       String email;
       String password;

	public static void main(String[] args) throws Exception {
		Connection con = Dbconnect.getConnection();
		Scanner sc = new Scanner(System.in);
		int ch;
		
		while(true) {
			System.out.println("Log in based on your position :");
			System.out.println("Press 1. Employee Login");
			System.out.println("Press 2. Manager Login");
			System.out.println("Press 3. Admin Login");
			
			
			
			ch =sc.nextInt();
			
			switch(ch) {
			case 1:
			{
				Login emp = new Login();
				
				emp.getEmailPass();
				PreparedStatement pst = con.prepareStatement("select * from employee where email=? and password=? and managerOrNot=0");
				pst.setString(1, emp.email);
				pst.setString(2, emp.password);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					Integer id = rs.getInt("empId");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String dept = rs.getString("dept");
					EmployeeImpl empi = new EmployeeImpl(id,name,email,dept);
					
					empi.requests();
				}
				else {
					
					System.out.println("Wrong  Emailid and password");
				}
				break;
			}
			case 2:
			{
				Login manager = new Login();
				
				manager.getEmailPass();
				PreparedStatement ps = con.prepareStatement("select * from employee where email=? and password=? and managerOrNot=1");
				ps.setString(1, manager.email);
				ps.setString(2, manager.password);
				ResultSet rst = ps.executeQuery();
				if(rst.next()) {
					Integer id = rst.getInt("empId");
					String name = rst.getString("name");
					String email = rst.getString("email");
					String dept = rst.getString("dept");
					ManagerImpl manage = new ManagerImpl(id,name,email,true,dept);
					try {
						
						manage.accept();
					} catch (Exception e) {
						
						System.out.println("Got an Exception. " +e);
					}
				}
				else {
					
					System.out.println("Wrong  Email or Password");
				}
				break;
			}
			case 3:
			{
				Login admin = new Login();
				
				admin.getEmailPass();
				PreparedStatement pt = con.prepareStatement("select * from employee where email=? and password=? and managerOrNot=0");
				pt.setString(1, admin.email);
				pt.setString(2, admin.password);
				ResultSet rts = pt.executeQuery();
				if(rts.next()) {
					Admin empi = new Admin();
					
					int a = empi.stat();
				}
				else {
					
					System.out.println("Wrong  Email or password");
				}
				break;
			}
			default:
			{
				
				System.out.println(" you entered a wrong choice!!");
				System.out.println(" Exiting !!!");
				System.exit(0);
			}
			}
			
		}
	}
	void getEmailPass() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email :");
		this.email = sc.nextLine();
		System.out.println("Enter Password :");
		this.password = sc.nextLine();
		
		
	}

}
