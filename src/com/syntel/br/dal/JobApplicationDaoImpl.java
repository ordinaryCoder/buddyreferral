package com.syntel.br.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syntel.br.models.*;
import com.syntel.br.models.*;
import com.syntel.br.util.DBUtil;

public class JobApplicationDaoImpl implements JobApplicationDao{

	@Override
	public JobApplication showApplicationDetails(int applicationID) {
		
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		JobApplication jobApplication = null;

		System.out.println("Logger >>> inside Login Method ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select * from account where applicationID=?");
			ps.setInt(1, applicationID);
			rs=ps.executeQuery();
			if(rs.next())
			{
				jobApplication = new JobApplication(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
		ResultSet rs = null;
		JobApplication jobApplication = null;

		System.out.println("Logger >>> inside Login Method ");
		try {
			
			con=DBUtil.getConnection();
			ps=con.prepareStatement("Delete from account where applicationID=?");
			ps.setInt(1, applicationID);
			System.out.println("Logger >>> inside application Controiller:" + applicationID);
			int del = ps.executeUpdate();
		    String resultString = "application deleted successful : "+ applicationID ;
	
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
	    return true;
	}

	@Override
	public boolean editStatus(int applicationID) {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		JobApplication jobApplication = null;

		System.out.println("Logger >>> inside Login Method ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select * from account where accno=?");
			ps.setInt(1, applicationID);
			rs=ps.executeQuery();
			if(rs.next())
			{
				jobApplication = new JobApplication();
				System.out.println("Logger >>>  " + jobApplication);
			}
		
			ps=con.prepareStatement("Update account SET balance = ? where accno=?");
//			ps.setDouble(1, bal);
//			ps.setInt(2, accNo);
//			System.out.println("inside aCCCOUNTdAOimPL Controller:" + accNo);
			int update = ps.executeUpdate();
			
//		     resultString = "application id "+applicationID+ "changed field  : "+ amount;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
	    return true;
	}

	@Override
	public String showStatus(int applicationID) {
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
	public ArrayList<JobApplication> showAllApplicationDetails() {
		//Method returns a list of all available job openings.
		ArrayList<JobApplication> jobApplications = new ArrayList<JobApplication>(5);
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		JobApplication jobApplication = null;
		System.out.println("Logger >>> inside Login Method ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select applicationID,jobCode,employeeID,buddyName,resume,status from JobApplication");
			rs=ps.executeQuery();
			while(rs.next())
			{
				jobApplication = new JobApplication();
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
