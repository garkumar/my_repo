package com.flp.ems.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IemployeeDao
{
	public void AddEmployee(Employee e);
	public void ModifyEmployee(Employee e,String prev_emailid,String prev_kinid,String prev_name);
	public void RemoveEmployee(String emailid,String kinid,String name);
	//public void SearchEmployee(int empid);
	public boolean  SearchEmployee1(String kinid);
	public boolean SearchEmployee2(String emailid);
	public boolean SearchEmployee3(String name);
	public boolean SearchEmployee4(String kinid,String emailid);
	public boolean SearchEmployee5(String kinid,String name);
	public boolean SearchEmployee6(String emailid,String name);
	public boolean SearchEmployee7(String kinid,String emailid,String name);
	public Connection getConnection()throws ClassNotFoundException,SQLException;
	public void getAllEmployee();
}
