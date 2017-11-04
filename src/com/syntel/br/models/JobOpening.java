package com.syntel.br.models;

public class JobOpening {
	 private int jobCode;
	 private String skills;
	 private int experience;
	 private String jobLocation;
	 private String spocName;
	 private String emailID;
	 private int rewards;
//	 private int employeeID;
//	 private String employeeName;
	 
	  public JobOpening() {
	
		  
	}
	  
	 
	public JobOpening(int jobCode, String skills, int experience,
		String jobLocation, String spocName, String emailID, int rewards) {
	super();
	this.jobCode = jobCode;
	this.skills = skills;
	this.experience = experience;
	this.jobLocation = jobLocation;
	this.spocName = spocName;
	this.emailID = emailID;
	this.rewards = rewards;
}


	public int getJobCode() {
		return jobCode;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public int getRewards() {
		return rewards;
	}
	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getSpocName() {
		return spocName;
	}
	public void setSpocName(String spocName) {
		this.spocName = spocName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
}
