package com.syntel.br.dal;

import java.util.ArrayList;

import com.syntel.br.models.JobOpening;

public interface JobOpeningDao {

	boolean addJobOpening(JobOpening jo);//Adds a new job opening 
	boolean removeJobOpening(int jobCode);//Remove a job opening specified by the jobCode
	boolean updateJobOpening(JobOpening jo);//Updates a job opening 
	ArrayList<JobOpening> showJobOpenings(String isStatusFinal);//Returns a List of All available Job Openings based on the parameter passed
	//apply();
	Double calculateReward(int jobCode);//to get the rewards from db where input is jobcode
	
}
