package com.syntel.br.dal;
import java.util.List;
import com.syntel.br.models.JobApplication;
public interface JobApplicationDao {
	JobApplication showApplicationDetails(int applicationID);	//retirve  the details of applicants
	boolean deleteApplication(int applicationID);//remove the record from dbms
	boolean editStatus(JobApplication js);//edit status of applicant
	String showStatus(int applicationID);//show the status of applicant
	boolean addJobApplication(JobApplication ja);//to add job application to db
	List<JobApplication> showAllApplicationDetails(String isStatusFinal);//To view all the application details

}

	