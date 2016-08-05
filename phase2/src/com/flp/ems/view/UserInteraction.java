package com.flp.ems.view;
import java.util.Scanner;
import java.util.HashMap;

import com.flp.ems.dao.EmployeeDaoImplForDB;
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
			       System.out.println("Enterrerere");
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
	    boolean result;
	    int choice;
	    EmployeeDaoImplForDB ies=new EmployeeDaoImplForDB();
		System.out.println("Enter 1 to modify by giving emailid ");
		System.out.println("Enter 3 to modify by giving name");
		System.out.println("Enter a choice");
		int ch=s.nextInt();
		System.out.println("Enter kinid");
		Kin_Id=s.next();
		System.out.println("Enter name");
		Name=s.next();
		System.out.println("Enter emailid");
		Email_id=s.next();
		prev_emailid=Email_id;
		prev_kinid=Kin_Id;
		prev_name=Name;
		if(ch==1)
		{
			
			result=ies.SearchEmployee2(Email_id);
			if(result==false)
			{
				System.out.println("employee not found so no modification");
				return ;
			}
		}
	
		else if (ch==3)
		{
			
			result=ies.SearchEmployee3(Name);
			if(result==false)
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
		  
		   
		   Employee_id=0;
		   System.out.println("Enter 1 if you want to change name else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new name");
			   Name=s.next();
		   }
		   else 
			   Name="0";
		  
			
		   System.out.println("Enter 1 if you want to change emailid else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new emailid");
			   Email_id=s.next();
		   }
		   else
			   Email_id="0";
		   System.out.println("Enter 1 if you want to change phoneno else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new phoneno");
			   Phone_no=s.nextLong();
		   }
		   else 
			   Phone_no=0;
		   System.out.println("Enter 1 if you want to change DOJ else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new DOJ");
			   DOJ=s.next();
			   if(!(Validate.validateDateFormat(DOJ)))
			   {
				   System.out.println("date wrong format");
				   return;
			   }
		   }
		   else
			   DOJ="0";
		   System.out.println("Enter 1 if you want to change DOB else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new DOB");
			   DOB=s.next();
			   if(!(Validate.validateDateFormat(DOB)))
			   {
				   System.out.println("date wrong format");
				   return;
			   }
		   }
		   else
			   DOB="0";
		   System.out.println("Enter 1 if you want to change Address else 0");
		   choice=s.nextInt();
		   if(choice==1)
		   {
			   System.out.println("Enter the new Address");
			   Address=s.next();
		   }
		   else
			   Address="0";
		    Project_id=0;
		    Dept_id=0;
		    Rols_id=0;
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
	       EmployeeServiceImpl eds=new EmployeeServiceImpl();
	       eds.ModifyEmployee(hm,prev_emailid,prev_kinid,prev_name);
		
		  
		
		
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
               
	           ies.SearchEmployee5(Kinid,name);
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
