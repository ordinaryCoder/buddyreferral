package com.syntel.br.models;

import java.io.Serializable;

public class JobApplication implements Serializable{
	private int applicationID;
	private int jobCode;
	private int employeeID;
	private String buddyName;
	private String resume;
	private String status;
	
	
	public JobApplication(){
		
	}
	
	public JobApplication(int applicationID, int jobCode, int employeeID,
			String buddyName, String resume, String status) {
		super();
		this.applicationID = applicationID;
		this.jobCode = jobCode;
		this.employeeID = employeeID;
		this.buddyName = buddyName;
		this.resume = resume;
		this.status = status;
	}
	
	
	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public String getBuddyName() {
		return buddyName;
	}
	public void setBuddyName(String buddyName) {
		this.buddyName = buddyName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	
	

	
}
