package com.flp.ems.service;

import java.util.HashMap;

public interface IEmployeeService 
{
	public void AddEmployee(HashMap hm);
	public void ModifyEmployee(HashMap hm);
	public void RemoveEmployee(int empid);
	public void SearchEmployee(int empid);
	public void getAllEmployee(int empid);

}
