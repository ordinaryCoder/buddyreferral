package com.syntel.br.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJobOpening(JobOpening jo) {
		// TODO Auto-generated method stub
		return false;
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
