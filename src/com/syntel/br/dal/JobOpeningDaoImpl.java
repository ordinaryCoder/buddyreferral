package com.syntel.br.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.syntel.br.models.JobOpening;
import com.syntel.br.util.DBUtil;

public class JobOpeningDaoImpl implements JobOpeningDao {

	@Override
	public boolean addJobOpening(JobOpening jo) {
		boolean isJobOpeningAdded = false;
		Connection con=null;
		PreparedStatement ps =null;
		System.out.println("Logger >>> inside Add JobOpening Method @ JobOpeningDao ");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into JobOpening (skills,experience,location,spocName,email_id,rewards) values (?,?,?,?,?,?)");
			ps.setString(1, jo.getSkills());
			ps.setInt(2, jo.getExperience());
			ps.setString(3, jo.getJobLocation());
			ps.setString(4, jo.getSpocName());
			ps.setString(5, jo.getEmailID());
			ps.setInt(6, jo.getRewards());
			int resultRowCount = ps.executeUpdate();
			if(resultRowCount == 1)
				isJobOpeningAdded = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
		return isJobOpeningAdded;

	}

	@Override
	public boolean removeJobOpening(int jobCode) {
		Connection con=null;
		PreparedStatement ps =null;
		boolean isJobOpeningDeleted = false;
		System.out.println("Logger >>> inside removeJobOpening method @ JobOpeningDaoImpl");
		try {
			
			con=DBUtil.getConnection();
			ps=con.prepareStatement("Delete from JobOpening where jobCode=?");
			ps.setInt(1, jobCode);
			int del = ps.executeUpdate();
			if(del == 1)
				isJobOpeningDeleted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
	    return isJobOpeningDeleted;
	}

	@Override
	public boolean updateJobOpening(JobOpening jo) {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
//		JobApplication jobApplication = null;
		boolean isJobOpeningUpdated = false;

		System.out.println("Logger >>> inside updateJobOpening Method @ JobOpeningDao");
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("Update jobappplication SET  skills= ?,experience=?,jobLocation=?,spocName=?,emailID=?,rewards=? where jobCode=?");
			ps.setString(1, jo.getSkills());
			ps.setInt(2, jo.getExperience());
			ps.setString(3, jo.getJobLocation());
			ps.setString(4, jo.getSpocName());
			ps.setString(5, jo.getEmailID());
			ps.setInt(6, jo.getRewards());
			
			ps.setInt(7, jo.getJobCode());
			int editStatusResult = ps.executeUpdate();
			if(editStatusResult == 1)
				isJobOpeningUpdated = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBUtil.close(con);
		}
	    return isJobOpeningUpdated;
	}

	@Override
	public ArrayList<JobOpening> showJobOpenings(String isStatusFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateReward(int jobCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
