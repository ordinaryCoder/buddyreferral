package com.syntel.br.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.syntel.br.models.*;
import com.syntel.br.util.DBUtil;

public class JobApplicationDaoImpl implements JobApplicationDao{

	@Override
	public JobApplication showApplicationDetails(int applicationID) {
		
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		JobApplication jobApplication = null;

		System.out.println("Logger >>> inside showJobApplicationDetails Method @JobApplicationDao  ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select applicationID,jobCode,employeeID,buddyName,resume,status,isStatusFinal from JobApplication where applicationID=?");
			ps.setInt(1, applicationID);
			rs=ps.executeQuery();
			if(rs.next())
			{
				jobApplication = new JobApplication(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
		return jobApplication;
	}

	@Override
	public boolean deleteApplication(int applicationID) {
		Connection con=null;
		PreparedStatement ps =null;
		boolean isDeleted = false;
		System.out.println("Logger >>> inside delete Application method @ JobApplicationDao");
		try {
			
			con=DBUtil.getConnection();
			ps=con.prepareStatement("Delete from JobApplication where applicationID=?");
			ps.setInt(1, applicationID);
			int del = ps.executeUpdate();
			if(del == 1)
				isDeleted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
	    return isDeleted;
	}

	@Override
	public boolean editStatus(JobApplication ja) {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
//		JobApplication jobApplication = null;
		boolean isEditStatusSuccess = false;

		System.out.println("Logger >>> inside edit status Method @ JobApplicationDao");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("Update jobappplication SET status = ? where applicationID=?");
			ps.setString(1, ja.getStatus());
			ps.setInt(2, ja.getApplicationID());
			int editStatusResult = ps.executeUpdate();
			if(editStatusResult == 1)
				isEditStatusSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
	    return isEditStatusSuccess;
	}

	@Override
	public String showStatus(int applicationID) {
		//Method need not to be implemented in DAO Layer.
		//Same functionality can be achieved by showApplicationDetails(int applicationID) method 
		return null;
	}

	@Override
	public boolean addJobApplication(JobApplication ja) {
		//Method to Add a Job Application into the DB input is the Job Application Object
		boolean isJobApplicationAdded = false;
		Connection con=null;
		PreparedStatement ps =null;
		System.out.println("Logger >>> inside Add JobApplication Method @ JobApplicationDao ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into JobApplication (jobCode,employeeID,buddyName,resume,status) values (?,?,?,?,?)");
			ps.setInt(1, ja.getJobCode());
			ps.setInt(2, ja.getEmployeeID());
			ps.setString(3, ja.getBuddyName());
			ps.setString(4, ja.getResume());
			ps.setString(5, ja.getStatus());
			int resultRowCount = ps.executeUpdate();
			if(resultRowCount == 1)
				isJobApplicationAdded = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
		return isJobApplicationAdded;
	}

	@Override
	public ArrayList<JobApplication> showAllApplicationDetails(String isStatusFinal) {
		//Method returns a list of all available job openings.
		ArrayList<JobApplication> jobApplications = new ArrayList<JobApplication>(5);
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		JobApplication jobApplication = null;
		String whereQueryString = null;
		switch(isStatusFinal)
		{
		case "All":whereQueryString=null;break;
		case "true":whereQueryString="where isStatusFinal = 'true'";break;
		case "false":whereQueryString="where isStatusFinal = 'false'";break;
		}
		System.out.println("Logger >>> inside Login Method ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select applicationID,jobCode,employeeID,buddyName,resume,status,isStatusFinal from JobApplication"+whereQueryString);
			rs=ps.executeQuery();
			while(rs.next())
			{
				jobApplication = new JobApplication(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
				jobApplications.add(jobApplication);
//				System.out.println("Logger >>>  " + jobApplication);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
		return jobApplications;
		
	}


}
