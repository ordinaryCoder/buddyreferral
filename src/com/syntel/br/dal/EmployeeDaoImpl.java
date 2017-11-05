package com.syntel.br.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.syntel.br.models.Employee;
import com.syntel.br.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

//private EmployeeService as = new EmployeeServiceImpl();
	
	@Override
	public boolean login(String username, String passwordHash) {
		
			boolean isLoginSuccess = false;
			boolean isSpoc = false;
			
			Connection con=null;
			PreparedStatement ps =null;
			ResultSet rs = null;
			Employee employee = null;
			
			//temporary HArdcodded Data for authentication
			int tempVarAccNo= 4;
			String tempName = "Amit";
			
			
			System.out.println("Logger >>> inside Login Method ");
			try {
				con=DBUtil.getConnection();
				ps=con.prepareStatement("select accno,name from account where accno=?");
				ps.setInt(1, tempVarAccNo);
//				ps.setString(2, passwordHash);
				rs=ps.executeQuery();
				if(rs.next())
				{
					//temporary section started
					
					int recievedAccNo = rs.getInt(1);
					String recievedName = rs.getString(2);
					
					if(tempName.equals(recievedName)){
						isLoginSuccess = true;
						isUserSpoc("Amit");
					}
				
					//temporary section ended
					
					/* employee = new Employee(rs.getString(1));
					if(passwordHash.equals(employee.getPassword()))
					{
						isLoginSuccess = true;//Login is successful
						
					}*/
					else
					{
						System.out.println("Invalid Password");
						isLoginSuccess = false;
					}
				}
				else
				{
					isLoginSuccess = false;
					System.out.println("Invalid Credentials i.e. User not found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally
			{
				DBUtil.close(con);
			}
			return isLoginSuccess;
					
	}

	@Override
	public boolean isUserSpoc(String username) {
		boolean isSpoc = false;
		if(username.equals("Amit")){
			return isSpoc = true;
		}
		return isSpoc;
	}

	@Override
	public Employee viewEmployeeDetails(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
