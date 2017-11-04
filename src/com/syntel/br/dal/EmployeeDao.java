package com.syntel.br.dal;

import com.syntel.br.models.Employee;

public interface EmployeeDao {

boolean login(String username,String passwordHash);//To login with given credentials
boolean isUserSpoc(String username);//determine whether employee is spoc or not

Employee viewEmployeeDetails(int employeeId);//to view all employee details

//boolean viewOpenings(Employee e);
//applyBuddy(Employee e);
//viewStatus();
//boolean addEmployee();//add employee to db (deffered for this version)
//void viewSpecificDetails(Employee e);//to view specific employee detail
//boolean editEmployee();//edit employee details

}
