package com.flp.ems.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.flp.ems.domain.Employee;



public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public void AddEmployee(HashMap hm) 
	{
		// TODO Auto-generated method stub
     int Employee_id,Dept_id,Project_id,Rols_id;
     Long Phone_no;
     String Name,Email_id,Kin_Id,Address;
    String Date_of_birth,Date_of_Joining;
     Employee_id=(int)hm.get(1);
     Name=(String)hm.get(2);
     Kin_Id=(String)hm.get(3);
     Email_id=(String)hm.get(4);
     Phone_no=(Long)hm.get(5);
     
     Date_of_birth=(String) hm.get(7);
     Date_of_Joining=(String) hm.get(7);       
     Address=(String)hm.get(8);
     Dept_id=(int)hm.get(9);
     Project_id=(int)hm.get(10);
     Rols_id=(int)hm.get(11);
     Employee ob=new Employee();
     ob.setEmployee_id(Employee_id);
     ob.setName(Name);
     ob.setPhone_no(Phone_no);
     ob.setKin_Id(Kin_Id);
     ob.setAddress(Address);
     ob.setEmail_id(Email_id);
     ob.setProject_id(Project_id);
     ob.setRoles_id(Rols_id);
     ob.setDepartment_id(Dept_id);
     ob.setDate_of_Joining(Date_of_Joining);
     ob.setDate_of_Joining(Date_of_Joining);
     System.out.println("Employee object created successfully");
	}

	@Override
	public void ModifyEmployee(HashMap hm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void RemoveEmployee(int empid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SearchEmployee(int empid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllEmployee(int empid) {
		// TODO Auto-generated method stub

	}

	
}
