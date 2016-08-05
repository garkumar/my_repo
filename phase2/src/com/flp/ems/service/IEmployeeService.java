package com.flp.ems.service;

import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IEmployeeService 
{
	public void AddEmployee(HashMap hm);
	public void ModifyEmployee(HashMap hm,String prev_emailid,String prev_kinid,String prev_name);
	public void SearchEmployee1(String kinid);
	public void SearchEmployee2(String emailid);
	public void SearchEmployee3(String name);
	public void SearchEmployee4(String kinid,String emailid);
	public void SearchEmployee5(String kinid,String name);
	public void SearchEmployee6(String emailid,String name);
	public void SearchEmployee7(String kinid,String emailid,String name);
	public void RemoveEmployee(String empid,String kinid,String name);
	public void getAllEmployee();

}
