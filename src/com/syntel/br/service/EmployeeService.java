package com.syntel.br.service;

import com.syntel.br.models.Employee;

public interface EmployeeService {
	
	boolean login(String username,String passwordHash);//To login with given credentials
	boolean isUserSpoc(String username);//determine whether employee is spoc or not //NotRequired
	Employee viewEmployeeDetails(int employeeId);//to view all employee details
	
}
