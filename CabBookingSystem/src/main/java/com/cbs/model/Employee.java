package com.cbs.model;

import java.util.Objects;

public class Employee {
	private Integer empId;
	private String name;
	private String email;
	private Boolean managerOrNot;
	private Boolean active;
	private String dept;
	
	
	
	public Employee(Integer empId, String name, String email, String dept) {
		super();
		this.managerOrNot = false;
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.active = true;
	}
	
	
	public Employee(Integer empId, String name, String email, Boolean managerOrNot, String dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.managerOrNot = managerOrNot;
		this.active = true;
		this.dept = dept;
	}


	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getManagerOrNot() {
		return managerOrNot;
	}
	public void setManagerOrNot(Boolean managerOrNot) {
		this.managerOrNot = managerOrNot;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public int hashCode() {
		return Objects.hash( empId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return  Objects.equals(empId, other.empId);
				
	}
	
	
	
	
}
