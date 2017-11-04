package com.syntel.br.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		return false;
	}

	@Override
	public List<JobApplication> showAllApplicationDetails() {
		return null;
	}


}
