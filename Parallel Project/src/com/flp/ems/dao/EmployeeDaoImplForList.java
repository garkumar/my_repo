package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao
{
   static  ArrayList lst=new ArrayList();
 	@Override
	public void AddEmployee(Employee e) {
		// TODO Auto-generated method stub
 	System.out.println("enteres in add in dao layer");
 	System.out.println("empname"+e.getName());
    lst.add((Object)e);
    
	}

	@Override
	public void ModifyEmployee(Employee e,String prev_emailid,String prev_kinid,String prev_name) {
		// TODO Auto-generated method stub
		String emailid,kinid,name;
		name=e.getEmail_id();
		emailid=e.getKin_Id();
		kinid=e.getName();
		RemoveEmployee(prev_emailid,prev_kinid,prev_name);
		AddEmployee(e);
	}

	@Override
	public void RemoveEmployee(String emailid,String kinid,String name) {
		// TODO Auto-generated method stub
	 Scanner s=new Scanner(System.in);
	 int num,c=0,ch;
     Iterator it=lst.iterator();
     System.out.println("Enter 1 to remove by emailid");
     System.out.println("Enter 2 to remove by kinid");
     System.out.println("Enter 3 to remove by name");
     System.out.println("Enter your choice");
     ch=s.nextInt();
     if(ch==1)
     {	 
     while(it.hasNext())
     {
    	 Employee e=(Employee)it.next();
    	 if(e.getEmail_id().equals(emailid))
    	 {
    		it.remove();
    		c++;
    	 }
    	 
     }
    	 
     if(c>0)
    	 System.out.println("An employee with kin id "+kinid+" has been removed");
     else
    	 System.out.println("No such empid found so no modification");
	}
     else if(ch==2)
     {
    	 while(it.hasNext())
         {
        	 Employee e=(Employee)it.next();
        	 if(e.getKin_Id().equals(kinid))
        	 {
        		it.remove();
        		c++;
        	 }
         }
         if(c>0)
        	 System.out.println("An employee with kin id "+kinid+" has been removed");
         else
        	 System.out.println("No such empid found so no modification"); 
     }
     else if(ch==3)
     {
    	 while(it.hasNext())
         {
        	 Employee e=(Employee)it.next();
        	 if(e.getName().equals(name))
        	 {
        		it.remove();
        		c++;
        	 }
         }
         if(c>0)
        	 System.out.println("An employee with kin id "+kinid+" has been removed");
         else
        	 System.out.println("No such empid found so no modification"); 
     }
	}

	
	/*public void SearchEmployee(int empid) {
		// TODO Auto-generated method stub
      Iterator it=lst.iterator();
      int c=0;
      while(it.hasNext())
      {
    	  Employee e=(Employee)it.next();
    	  if(e.getEmployee_id()==empid)
    	  {
    		  c++;
    		  System.out.println("Employee id="+empid);
    		  System.out.println("Employee Name="+e.getName());
              System.out.println("KinId="+e.getKin_Id());
    		  System.out.println("Email_id="+e.getEmail_id());
    		  System.out.println("Phone_no"+e.getPhone_no());
    		  System.out.println("Date of birth="+e.getDate_of_birth());
    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
    		  System.out.println("Address="+e.getAddress());
    		  System.out.println("Department id="+e.getDepartment_id());
    		  System.out.println("Project id="+e.getProject_id());
    		  System.out.println("Roles id="+e.getRoles_id());
    	  }
      }
      if(c<0)
     	 System.out.println("No such empid found");
	}*/
	public Employee  SearchEmployee1(String kinid)
	{
		Iterator it=lst.iterator();
		System.out.println("inside sao in search employee1");
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	  System.out.println("inside dao kinid in prev="+kinid);
	    	  System.out.println("inside dao kinid using list="+kinid);
	    	  e=(Employee)it.next();
	    	  if(e.getKin_Id().equals(kinid))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    		  return e;
	    	  }
	      }
	      if(c<=0){
	     	 System.out.println("No such empid found");
	     	
	     	 }
	      return e;
		}
	
	public Employee SearchEmployee2(String emailid)
	{
		Iterator it=lst.iterator();
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	   e=(Employee)it.next();
	    	  if(e.getEmail_id().equals(emailid))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    	      return e;
	    	  }
	      }
	      if(c<=0){
	     	 System.out.println("No such empid found");}
	      return e;
	      
	}
	public Employee SearchEmployee3(String name)
	{
		Iterator it=lst.iterator();
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	  e=(Employee)it.next();
	    	  if(e.getName().equals(name))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    		  return e;
	    	  }
	      }
	      if(c<=0){
	     	 System.out.println("No such empid found");}
	      return e;
	}
	public Employee SearchEmployee4(String kinid,String emailid)
	{
		Iterator it=lst.iterator();
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	   e=(Employee)it.next();
	    	  if(e.getKin_Id().equals(kinid) && e.getEmail_id().equals(emailid))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    		  return e;
	    	  }
	      }
	      if(c<=0){
	     	 System.out.println("No such empid found");}
	      return e;
	}
	public Employee SearchEmployee5(String kinid,String name)
	{
		Iterator it=lst.iterator();
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	  e=(Employee)it.next();
	    	  if(e.getKin_Id().equals(kinid)&& e.getName().equals(name))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    		  return e;
	    	  }
	      }
	      if(c<=0){
	     	 System.out.println("No such empid found");}
	      return e;
	}
	public Employee SearchEmployee6(String emailid,String name)
	{
		Iterator it=lst.iterator();
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	   e=(Employee)it.next();
	    	  if(e.getEmail_id().equals(emailid)&& e.getName().equals(name))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    	      return e;
	    	  }
	      }
	      if(c<=0){
	     	 System.out.println("No such empid found");}
	      return e;
	}
	public Employee SearchEmployee7(String kinid,String emailid,String name)
	{
		Iterator it=lst.iterator();
	      int c=0;
	      Employee e=null;
	      while(it.hasNext())
	      {
	    	  e=(Employee)it.next();
	    	  if(e.getKin_Id().equals(kinid) && e.getEmail_id().equals(emailid) && e.getName().equals(name))
	    	  {
	    		  c++;
	    		  System.out.println("Employee id="+e.getKin_Id());
	    		  System.out.println("Employee Name="+e.getName());
	              System.out.println("KinId="+e.getKin_Id());
	    		  System.out.println("Email_id="+e.getEmail_id());
	    		  System.out.println("Phone_no"+e.getPhone_no());
	    		  System.out.println("Date of birth="+e.getDate_of_birth());
	    		  System.out.println("Date of Joining"+e.getDate_of_Joining());
	    		  System.out.println("Address="+e.getAddress());
	    		  System.out.println("Department id="+e.getDepartment_id());
	    		  System.out.println("Project id="+e.getProject_id());
	    		  System.out.println("Roles id="+e.getRoles_id());
	    	      return e;
	    	  }
	      }
	      if(c<0){
	     	 System.out.println("No such empid found");	}
	      return e;
	}

	@Override
	public void getAllEmployee() {
		// TODO Auto-generated method stub
		
		System.out.println("Employee id "+"Employee Name"+"KinId   "+"Email_id    "
		+"Phone_no   "+"Date of birth  "+"Date of Joining"+"Address  "+"Department id "+"Project id "+"Rolesid  ");
		Iterator it=lst.iterator();
		while(it.hasNext())
		{
			System.out.println("inside loop");
			Employee e=(Employee)it.next();
			System.out.println(e.getEmployee_id()+"  "+e.getName()+"  "+e.getKin_Id()+"  "+e.getEmail_id()+"  "+e.getPhone_no()+"  "
					+e.getDate_of_birth()+"  "+e.getDate_of_Joining()+"  "+e.getAddress()+"  "+e.getDepartment_id()+"  "+e.getProject_id()+"  "+e.getRoles_id());
  		
			
		}
 	}

}
