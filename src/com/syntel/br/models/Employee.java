											package com.syntel.br.models;

import java.io.Serializable;

public class Employee implements Serializable {
	private int employeeId;
	private String employeeName;
	private String userName;
	private String password;
	private String designation;
	private boolean isSPOC;
	
	Employee(){
	}
	
	public Employee(int employeeId, String employeeName, String userName, String password, String designation, boolean isSPOC){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.userName = userName;
		this.password = userName;
		this.designation = designation;
		this.isSPOC = isSPOC;
	}
	
	
	public Employee(String passwordHash) {
		this.password = passwordHash;
		
	}

	public int getEmpyeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public boolean getSPOC() {
		return isSPOC;
	}

	public void setSPOC(boolean isSPOC) {
		this.isSPOC = isSPOC;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmpName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Override
	public String toString() {
		return 	"Book [employeeId=" + employeeId + ", employeeName=" + employeeName + ", userName=" + userName + ","
			    + "password=" + password+ "," + "designation=" + designation +  "," + "isSPOC=" + isSPOC
				+ "]";
	}
	
}
