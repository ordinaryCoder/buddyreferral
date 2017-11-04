package com.syntel.br.service;

import com.syntel.br.models.Employee;
import com.syntel.br.dal.*;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao EmpDao =  new EmployeeDaoImpl();
	
	@Override
	public boolean login(String username, String passwordHash) {
		boolean isloginSuccess = EmpDao.login(username, passwordHash);
		if(isloginSuccess == true){
			boolean spocCheck = isUserSpoc(username);
			return true;
		}	
		else
			return false;
	}
	
	@Override
	public Employee viewEmployeeDetails(int employeeId) {
		return null;
	}
	
	@Override
	public boolean isUserSpoc(String username) {
		boolean isSpoc = false;
		if(username.equals("Amit")){
			return isSpoc = true;
		}
		return isSpoc;
	}

}
