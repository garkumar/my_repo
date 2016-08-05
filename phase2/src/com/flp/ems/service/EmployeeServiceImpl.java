package com.flp.ems.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.flp.ems.dao.EmployeeDaoImplForDB;

import com.flp.ems.domain.Employee;



public class EmployeeServiceImpl implements IEmployeeService {

      
	static HashSet<String> hsh_kin=new HashSet<>();
	static HashSet<String> hsh_email=new HashSet<>();
	   
	public void AddEmployee(HashMap hm) 
	{
		// TODO Auto-generated method stub
     int Employee_id,Dept_id,Project_id,Rols_id;
     Long Phone_no;
     String Name,Email_id,Kin_Id,Address;
    String Date_of_birth,Date_of_Joining;
     //Employee_id=(int)hm.get(1);
     Name=(String)hm.get(2);
     Kin_Id=(String)hm.get(3);
     Email_id=(String)hm.get(4);
     Phone_no=(Long)hm.get(5);
     Date_of_birth=(String) hm.get(6);
     Date_of_Joining=(String) hm.get(7);       
     Address=(String)hm.get(8);
     //Dept_id=(int)hm.get(9);
     //Project_id=(int)hm.get(10);
     //Rols_id=(int)hm.get(11);
      if(hsh_kin.contains(Kin_Id))
      {
      System.out.println("Person with this Kinid already exists.. "); 
      return;
      }
      else 
      {
       hsh_kin.add(Kin_Id);
      }
  
      if(hsh_email.contains(Email_id))
      {
    	System.out.println("Person with this email_id already exists");  
    	return;
      }
      else
     {
     hsh_email.add(Email_id);
     }
     Employee ob=new Employee();
     //ob.setEmployee_id(Employee_id);
     ob.setName(Name);
     ob.setPhone_no(Phone_no);
     ob.setKin_Id(Kin_Id);
     ob.setAddress(Address);
     ob.setEmail_id(Email_id);
     //ob.setProject_id(Project_id);
     //ob.setRoles_id(Rols_id);
     //ob.setDepartment_id(Dept_id);
     ob.setDate_of_Joining(Date_of_Joining);
     ob.setDate_of_birth(Date_of_birth);
     System.out.println("Employee object created successfully");
     EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
     es.AddEmployee(ob);
	}

	@Override
	public void ModifyEmployee(HashMap hm,String prev_emailid,String prev_kinid,String prev_name) {
		// TODO Auto-generated method stub
		 int Dept_id,Project_id,Rols_id;
	     Long Phone_no;
	     String Name,Email_id,Kin_Id,Address;
	    String Date_of_birth,Date_of_Joining;
	     //Employee_id=(int)hm.get(1);
	     Name=(String)hm.get(2);
	     Kin_Id=(String)hm.get(3);
	     Email_id=(String)hm.get(4);
	     Phone_no=(Long)hm.get(5);
	     Date_of_birth=(String) hm.get(6);
	     Date_of_Joining=(String) hm.get(7);       
	     Address=(String)hm.get(8);
	     Dept_id=(int)hm.get(9);
	     Project_id=(int)hm.get(10);
	     Rols_id=(int)hm.get(11);
	     if(!(Kin_Id.equals(prev_kinid))&& !((Kin_Id).equals(0))) {	 
	     if(hsh_kin.contains(Kin_Id))
	      {
	      System.out.println("Person with this Kinid already exists.. "); 
	      return;
	      }
	      else 
	      {
	      System.out.println("Inside else of kinid");	  
	       hsh_kin.add(Kin_Id);
	      }
	     }
	     if(!(Email_id.equals(prev_emailid))&& !((Email_id).equals(0)))
	     {	 
	      if(hsh_email.contains(Email_id))
	      {
	    	System.out.println("Person with this email_id already exists");  
	    	return;
	      } 
	      else
	      {
	      hsh_email.add(Email_id);
	      }
	     }
	     Employee ob=new Employee();
	     ob.setName(Name);
	     ob.setPhone_no(Phone_no);
	     ob.setKin_Id(Kin_Id);
	     ob.setAddress(Address);
	     ob.setEmail_id(Email_id);
	    // ob.setProject_id(Project_id);
	    // ob.setRoles_id(Rols_id);
	     //ob.setDepartment_id(Dept_id);
	     ob.setDate_of_Joining(Date_of_Joining);
	     ob.setDate_of_birth(Date_of_birth);
	     EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
	     es.ModifyEmployee(ob,prev_emailid,prev_kinid,prev_name);
	     

	}

	@Override
	public void RemoveEmployee(String emailid,String kinid,String name) {
		// TODO Auto-generated method stub
		boolean a=hsh_kin.contains((Object)kinid);
		hsh_kin.remove(kinid);
		System.out.println("contains emailid"+a);
		hsh_email.remove((Object)emailid);
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.RemoveEmployee(emailid,kinid,name);
	}

	
	/*public void SearchEmployee(int empid) {
		// TODO Auto-generated method stub
		EmployeeDaoImplForList es=new EmployeeDaoImplForList();
		es.SearchEmployee(empid);
	}*/
	public void SearchEmployee1(String kinid)
	{ 
		
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();	
		System.out.println("kinid"+kinid);
		es.SearchEmployee1(kinid);
		
	}
	public void SearchEmployee2(String emailid)
	{
		
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.SearchEmployee2(emailid);
		
	}
	public void SearchEmployee3(String name)
	{
		Employee e;
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.SearchEmployee3(name);
		
	}
	public void SearchEmployee4(String kinid,String emailid)
	{
		Employee e;
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.SearchEmployee4(kinid,emailid);
		
	}
	public void SearchEmployee5(String kinid,String name)
	{
		Employee e;
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.SearchEmployee5(kinid,name);
		
	}
	public void SearchEmployee6(String emailid,String name)
	{
		
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.SearchEmployee6(emailid,name);
		return ;
	}
	public void SearchEmployee7(String kinid,String emailid,String name)
	{
		
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.SearchEmployee7(kinid,emailid,name);
		return ;
	}

	@Override
	public void getAllEmployee() {
		// TODO Auto-generated method stub
		EmployeeDaoImplForDB es=new EmployeeDaoImplForDB();
		es.getAllEmployee();
	}

	
}
