package com.flp.ems.view;
import java.util.Scanner;
import java.util.HashMap;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;
public class UserInteraction
{ 
  
	public  static void  AddEmployee()
	{
		Scanner s=new Scanner(System.in);
		HashMap hm=new HashMap(); 
		int Dept_id,Project_id,Rols_id;
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
		/*System.out.println("Enter Dept_id");
		Dept_id=s.nextInt();
		System.out.println("Enter Project_id");
		Project_id=s.nextInt();
		System.out.println("Enter Rols_id");
		Rols_id=s.nextInt();*/
		System.out.println("Enter Phone_no");
		Phone_no=s.nextLong();
		
	   
		if(Validate.validateDateFormat(DOJ)&& Validate.validateEmailAddress(Email_id) && Validate.validatePhoneNo(Phone_no))
				{
				   System.out.println("Date of joining validated && email id validated && Phoneno && Name is validated");
			       //hm.put(1,Employee_id);
				   hm.put(2,Name);
			       hm.put(3,Kin_Id);
			       hm.put(4,Email_id);
			       hm.put(5,Phone_no);
			       hm.put(6,DOJ);
			       hm.put(7,DOB);
			       hm.put(8,Address);
			       //hm.put(9,Dept_id);
			       //hm.put(10,Project_id);
			       //hm.put(11,Rols_id);
			       EmployeeServiceImpl ies=new EmployeeServiceImpl();
			       ies.AddEmployee(hm);
				}
		else
		{
			System.out.println("Give correct  value");
		}
	}
   public static void ModifyEmployee()
   {

	    int Employee_id,Dept_id,Project_id,Rols_id;
		long Phone_no;
		String Name,Kin_Id,Email_id,DOB,DOJ,Address,prev_emailid,prev_kinid,prev_name;
	    Scanner s=new Scanner(System.in);
	    HashMap hm=new HashMap(); 
	    Employee e;
	    int choice;
	    EmployeeServiceImpl ies=new EmployeeServiceImpl();
		System.out.println("Enter 1 to modify by giving emailid ");
		System.out.println("Enter 2 to modify by giving kinid");
		System.out.println("Enter 3 to modify by giving name");
		System.out.println("Enter emailid");
		Email_id=s.nextLine();
		System.out.println("Enter kinid");
		Kin_Id=s.nextLine();
		System.out.println("Enter name");
		Name=s.nextLine();
		System.out.println("Enter a choice");
		int ch=s.nextInt();
		if(ch==1)
		{
			e=ies.SearchEmployee2(Email_id);
			if(e==null)
			{
				System.out.println("employee not found so no modification");
				return ;
			}
		}
		else if(ch==2)
		{
			e=ies.SearchEmployee1(Kin_Id);
			if(e==null)
			{
				System.out.println("employee not found so no modification");
				return ;
			}
			
		}
		else if (ch==3)
		{
			e=ies.SearchEmployee3(Name);
			if(e==null)
			{
				System.out.println("employee not found so no modification");
				return ;
			}
			
		}
		else
		{
			System.out.println("Invalid choice");
			return;
			
		}
		   prev_emailid=e.getEmail_id();
		   prev_kinid=e.getKin_Id();
		   prev_name=e.getName();
		   Employee_id=e.getEmployee_id();
		   Name=e.getName();
		   Kin_Id=e.getKin_Id();
		   Email_id=e.getEmail_id();
		   Phone_no=e.getPhone_no();
		   DOJ=e.getDate_of_Joining();
		   DOB=e.getDate_of_birth();
		   Address=e.getAddress();
		   Dept_id=e.getDepartment_id();
		   Project_id=e.getProject_id();
		   Rols_id=e.getRoles_id();
		   System.out.println("Do you want to change employee id");
		   System.out.println("Enter 1 if you want to change employee id else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new employeeid");
			   Employee_id=s.nextInt();
			   System.out.println("the employee id is = "+ Employee_id);
		   }	
		   System.out.println("Enter 1 if you want to change name else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new name");
			   Name=s.next();
		   }
		   System.out.println("Enter 1 if you want to change Kinid else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new Kinid");
			   Kin_Id=s.next();
		   }
		   System.out.println("Enter 1 if you want to change emailid else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new emailid");
			   Email_id=s.next();
		   }
		   System.out.println("Enter 1 if you want to change phoneno else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new phoneno");
			   Phone_no=s.nextLong();
		   }
		   System.out.println("Enter 1 if you want to change DOJ else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new DOJ");
			   DOJ=s.next();
		   }
		   System.out.println("Enter 1 if you want to change DOB else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new DOB");
			   DOB=s.next();
		   }
		   System.out.println("Enter 1 if you want to change Address else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new Address");
			   Address=s.next();
		   }
		   System.out.println("Enter 1 if you want to change ProjectId else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new Projectid");
			   Project_id=s.nextInt();
		   }
		   System.out.println("Enter 1 if you want to change DEPTId else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new Dept_id");
			   Dept_id=s.nextInt();
		   }
		   System.out.println("Enter 1 if you want to change Rols_id else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new Rols_id");
			   Dept_id=s.nextInt();
		   }
		   if(Validate.validateDateFormat(DOJ)&& Validate.validateEmailAddress(Email_id) && Validate.validatePhoneNo(Phone_no))
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
	       System.out.println("modified hash map"+hm);
	       ies.ModifyEmployee(hm,prev_emailid,prev_kinid,prev_name);
			}
		   else
			{
				System.out.println("Give correct  value");
			}
		   
		
		
   }
   public static void RemoveEmployee()
   {
	  String emailid,name,kinid;
	  Scanner s=new Scanner(System.in);
	  System.out.println("Enter the emailid");
	  emailid=s.nextLine();
	  System.out.println("Enter the kinid");
	  kinid=s.nextLine();
	  System.out.println("Enter the name");
	  name=s.nextLine();
	  EmployeeServiceImpl ies=new EmployeeServiceImpl();
	  ies.RemoveEmployee(emailid,kinid,name);
   }
   public static void SearchEmployee()
   {
	  
	   String Kinid,name,emailid;
	   int ch;
	   Scanner s=new Scanner(System.in);
	   EmployeeServiceImpl ies=new EmployeeServiceImpl();
	   System.out.println("Enter 1 to check by Kin_id");
	   System.out.println("Enter 2 to check by Emailid");
	   System.out.println("Enter 3 to check by name");
	   System.out.println("enter 4 to check by name and kin_id");
	   System.out.println("Enter 5 to check by Email_id and kin_id");
	   System.out.println("Enter 6 to check by Emailid and name");
	   System.out.println("Enter 7 to check by  kin_id,Email_idand name");
	   System.out.println("Enter the kinid");
 	   Kinid =s.nextLine();
 	   System.out.println("Enter the emailid id");
 	   emailid=s.nextLine();
 	   System.out.println("Enter the name");
 	   name=s.nextLine();
	   System.out.println("Enter the choice");
	   ch=s.nextInt();
	 
	   switch(ch)
	   {
	   case 1:
	    	  ies.SearchEmployee1(Kinid);
	    	  break;
	   case 2:	  
	    	   ies.SearchEmployee2(emailid);
	    	   break;
	   case 3:	
	            ies.SearchEmployee3(name);
	            break;
	   case 5: 
               
	           ies.SearchEmployee4(Kinid,name);
	           break;
	   case 4: 	
	   		  ies.SearchEmployee4(Kinid,emailid);
	          break;
	        
	   case 6: 
	           ies.SearchEmployee6(emailid,name);
	           break;
	   case 7: 
	           ies.SearchEmployee7(Kinid,emailid,name);
	           break;
	    default:System.out.println("Invalid Entery");       
	   }
	  
       //ies.SearchEmployee(empid);
   }
   public static void getAllEmployee()
   {
	   EmployeeServiceImpl ies=new EmployeeServiceImpl();
	   ies.getAllEmployee();
   }
}
