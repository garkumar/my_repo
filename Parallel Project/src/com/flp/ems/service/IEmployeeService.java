package com.flp.ems.service;

import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IEmployeeService 
{
	public void AddEmployee(HashMap hm);
	public void ModifyEmployee(HashMap hm,String prev_emailid,String prev_kinid,String prev_name);
	public Employee SearchEmployee1(String kinid);
	public Employee SearchEmployee2(String emailid);
	public Employee SearchEmployee3(String name);
	public Employee SearchEmployee4(String kinid,String emailid);
	public Employee SearchEmployee5(String kinid,String name);
	public Employee SearchEmployee6(String emailid,String name);
	public Employee SearchEmployee7(String kinid,String emailid,String name);
	public void RemoveEmployee(String empid,String kinid,String name);
	public void getAllEmployee();

}
