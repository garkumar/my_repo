package com.flp.ems.view;
import java.util.Scanner;
import java.util.HashMap;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;
public class UserInteraction
{ 
  
	public  static void  AddEmployee()
	{
		Scanner s=new Scanner(System.in);
		HashMap hm=new HashMap(); 
		int Employee_id,Dept_id,Project_id,Rols_id;
		long Phone_no;
		String Name,Kin_Id,Email_id,DOB,DOJ,Address;
		System.out.println("Enter Name");
		Name=s.nextLine();
		System.out.println("Enter Kinid");
		Kin_Id=s.nextLine();
		System.out.println("Enter email_id");
		Email_id=s.nextLine();
		System.out.println("Enter DOJ");
		DOJ=s.nextLine();
		System.out.println("Enter DOB");
		DOB=s.nextLine();
		System.out.println("Enter Address");
		Address=s.nextLine();
		System.out.println("Enter Dept_id");
		Dept_id=s.nextInt();
		System.out.println("Enter Project_id");
		Project_id=s.nextInt();
		System.out.println("Enter Rols_id");
		Rols_id=s.nextInt();
		System.out.println("Enter empid");
		Employee_id=s.nextInt();
		System.out.println("Enter Phone_no");
		Phone_no=s.nextLong();
		
	   
		if(Validate.validateDateFormat(DOJ)&& Validate.validateEmailAddress(Email_id) && Validate.validateName(Name))
				{
				   System.out.println("Date of joining validated && email id validated && Phoneno && Name is validated");
			       hm.put(1,Employee_id);
				   hm.put(2,Name);
			       hm.put(3,Kin_Id);
			       hm.put(4,Email_id);
			       hm.put(5,Phone_no);
			       hm.put(6,DOJ);
			       hm.put(7,DOB);
			       hm.put(8,Address);
			       hm.put(9,Dept_id);
			       hm.put(10,Project_id);
			       hm.put(11,Rols_id);
			       EmployeeServiceImpl ies=new EmployeeServiceImpl();
			       ies.AddEmployee(hm);
				}
		else
		{
			System.out.println("Not A Valid Date");
		}
	}
   public static void ModifyEmployee()
   {
		Scanner s=new Scanner(System.in);
		HashMap hm=new HashMap(); 
		int Employee_id,Dept_id,Project_id,Rols_id;
		long Phone_no;
		String Name,Kin_Id,Email_id,DOB,DOJ,Address;
		System.out.println("Enter Name");
		Name=s.nextLine();
		System.out.println("Enter Kinid");
		Kin_Id=s.nextLine();
		System.out.println("Enter email_id");
		Email_id=s.nextLine();
		System.out.println("Enter DOJ");
		DOJ=s.nextLine();
		System.out.println("Enter DOB");
		DOB=s.nextLine();
		System.out.println("Enter Address");
		Address=s.nextLine();
		System.out.println("Enter Dept_id");
		Dept_id=s.nextInt();
		System.out.println("Enter Project_id");
		Project_id=s.nextInt();
		System.out.println("Enter Rols_id");
		Rols_id=s.nextInt();
		System.out.println("Enter Phone_no");
		Phone_no=s.nextLong();
		System.out.println("Enter empid");
		Employee_id=s.nextInt();
		if(Validate.validateDateFormat(DOJ) && Validate.validateEmailAddress(Email_id) && Validate.validatePhoneNo(Phone_no) && Validate.validateName(Name))
				{
				   System.out.println("date of joining validated");
			       hm.put(1,Employee_id);
			       hm.put(2,Name);
			       hm.put(3,Kin_Id);
			       hm.put(4,Email_id);
			       hm.put(5,Phone_no);
			       hm.put(6,DOJ);
			       hm.put(7,DOB);
			       hm.put(8,Address);
			       hm.put(9,Dept_id);
			       hm.put(10,Project_id);
			       hm.put(11,Rols_id);
			       System.out.println(hm);
			       
				}
		else
		{
			System.out.println("Not A Valid Date");
		}
	   
   }
   public static void RemoveEmployee()
   {
	  int empid;
	  Scanner s=new Scanner(System.in);
	  System.out.println("Enter the employee id");
	  empid=s.nextInt(); 
	  EmployeeServiceImpl ies=new EmployeeServiceImpl();
	  ies.RemoveEmployee(empid);
   }
   public static void SearchEmployee()
   {
	   int empid;
	   Scanner s=new Scanner(System.in);
       System.out.println("Enter the employee id");
	   empid=s.nextInt();
	   EmployeeServiceImpl ies=new EmployeeServiceImpl();
       ies.SearchEmployee(empid);
   }
   public static void getAllEmployee()
   {
	   int empid;
	   Scanner s=new Scanner(System.in);
       System.out.println("Enter the employee id");
	   empid=s.nextInt(); 
	   EmployeeServiceImpl ies=new EmployeeServiceImpl();
	   ies.getAllEmployee(empid);
   }
}
