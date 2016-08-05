package com.flp.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.flp.ems.domain.Employee;



public class EmployeeDaoImplForDB implements IemployeeDao {
    
	@Override
	public void AddEmployee(Employee e) {
		// TODO Auto-generated method stub
		Date dobb=null,dojj=null;
		int empid=e.getEmployee_id();
		String name=e.getName();
		String kinid=e.getKin_Id();
		String emailid=e.getEmail_id();
		long ph=e.getPhone_no();
		String add=e.getAddress();
		String dob=e.getDate_of_birth();
		SimpleDateFormat d=new SimpleDateFormat("dd/mm/yyyy");
		try
		{
		dobb=d.parse(dob);
		String doj=e.getDate_of_Joining();
		dojj=d.parse(doj);
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		int did=e.getDepartment_id();
		int pid=e.getProject_id();
		int rid=e.getRoles_id();		
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("connectio failed");
			return;
	    }
		else
		{
			try{
			String query="insert into employee(employee_id,name,kin_id,email_id,phone_no,address,dept_id,proj_id,role_id,dob,doj)values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement s=conn.prepareStatement(query);
			java.sql.Date oj=new java.sql.Date(dojj.getTime());
			java.sql.Date ob=new java.sql.Date(dobb.getTime());
			s.setInt(1,empid);
			s.setString(2,name);
			s.setString(3,kinid);
			s.setString(4,emailid);
			s.setLong(5,ph);
			s.setString(6,add);
			s.setInt(7,did);
			s.setInt(8,pid);
			s.setInt(9,rid);
			s.setDate(10, ob);
			s.setDate(11, oj);
			int x=s.executeUpdate();
			if(x==0)
			{
				System.out.println("employee not  added in db");
			}
			else
			{
				System.out.println("employee added in database ");
			}
			}
			catch(SQLException p){p.printStackTrace();}
		}
	}

	@Override
	public void ModifyEmployee(Employee e, String prev_emailid, String prev_kinid, String prev_name) {
	
	 Connection conn=getConnection();
	String emailid=e.getEmail_id();
    String kinid=e.getKin_Id();
    String name=e.getName();
    Long phoneno=e.getPhone_no();
    String dob=e.getDate_of_birth();
    String doj=e.getDate_of_Joining();
    String add=e.getAddress();
    int dept_id=e.getDepartment_id();
    int proj_id=e.getProject_id();
    int role_id=e.getRoles_id();
    Date dobb=null,dojj=null;
    try{
    if(!(emailid.equals("0")))
    {
     String s="Update  employee set email_id=? where kin_id=? ";
     PreparedStatement st=conn.prepareStatement(s);
     st.setString(1,emailid);
     st.setString(2,prev_kinid);
     int x=st.executeUpdate();
     if(x==0){System.out.println("Emailid not updated");}
     else
     {
    	 System.out.println("Emailid updated");
     }
     }
    if(!(name.equals("0")))
    {
     String s="Update  employee set name=? where kin_id=? ";
     PreparedStatement st=conn.prepareStatement(s);
     st.setString(1,name);
     st.setString(2,prev_kinid);
     int x=st.executeUpdate();
     if(x==0){System.out.println("Name not updated");}
     else
     {
    	 System.out.println("Name updated");
     }}
     if(!(dob.equals("0")))
     {
      String s="Update  employee set dob=? where kin_id=? ";
      SimpleDateFormat d=new SimpleDateFormat("dd/mm/yyyy");
		try
		{
		dobb=d.parse(dob);
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		java.sql.Date oj=new java.sql.Date(dobb.getTime());
      PreparedStatement st=conn.prepareStatement(s);
      st.setDate(1,oj);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("Date not updated");}
      else
      {
     	 System.out.println("date` updated");
      }
     }
     if(!(doj.equals("0")))
     {
      String s="Update  employee set doj=? where kin_id=? ";
      SimpleDateFormat d=new SimpleDateFormat("dd/mm/yyyy");
		try
		{
		dojj=d.parse(doj);
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		java.sql.Date oj=new java.sql.Date(dojj.getTime());
      PreparedStatement st=conn.prepareStatement(s);
      st.setDate(1,oj);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("Date not updated");}
      else
      {
     	 System.out.println("date` updated");
      }
     }
     if(!(add.equals("0")))
     {
      String s="Update  employee set address=? where kin_id=? ";
      PreparedStatement st=conn.prepareStatement(s);
      st.setString(1,add);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("address not updated");}
      else
      {
     	 System.out.println("address updated");
      }
      }
     if(!(dept_id==0))
     {
      String s="Update  employee set dept_id=? where kin_id=? ";
      PreparedStatement st=conn.prepareStatement(s);
      st.setInt(1,dept_id);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("deptid not updated");}
      else
      {
     	 System.out.println("deptid updated");
      }
      }
     if(!(role_id==0))
     {
      String s="Update  employee set role_id=? where kin_id=? ";
      PreparedStatement st=conn.prepareStatement(s);
      st.setInt(1,role_id);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("role_id not updated");}
      else
      {
     	 System.out.println("role_id updated");
      }
      }
     if(!(proj_id==0))
     {
      String s="Update  employee set proj_id=? where kin_id=? ";
      PreparedStatement st=conn.prepareStatement(s);
      st.setInt(1,proj_id);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("proj_id not updated");}
      else
      {
     	 System.out.println("proj_id updated");
      }
      }
     if(!(phoneno==0))
     {
      String s="Update  employee set phone_no=? where kin_id=? ";
      PreparedStatement st=conn.prepareStatement(s);
      st.setLong(1,phoneno);
      st.setString(2,prev_kinid);
      int x=st.executeUpdate();
      if(x==0){System.out.println("phoneno not updated");}
      else
      {
     	 System.out.println("phoneno updated");
      }
      }
    
    }catch(SQLException e1){e1.printStackTrace();}
   
    }

	@Override
	public void RemoveEmployee(String emailid, String kinid, String name) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
		 int ch;
		 boolean result;
		 System.out.println("Enter 1 to remove by emailid");
	     System.out.println("Enter 2 to remove by kinid");
	     System.out.println("Enter 3 to remove by name");
	     System.out.println("Enter your choice");
	     ch=s.nextInt();
	     if(ch==1)
	     {	 
	     try{
	    	   Connection conn=getConnection();
	    	   String s1="delete from employee where email_id= ?";
			    PreparedStatement st=conn.prepareStatement(s1);
			    st.setString(1,emailid);
			    int c=st.executeUpdate();
			    if(c==0)
			    	System.out.println("employee not found");
			    else
			    	System.out.println("employee deleted ");
			   
	    	  }
	    	  catch(SQLException e){e.printStackTrace();}
	      }
	     else if(ch==2)
	     {
	    	 try{
		    	   Connection conn=getConnection();
		    	   String s1="delete from employee where name= ?";
				    PreparedStatement st=conn.prepareStatement(s1);
				    st.setString(1,name);
				    int c=st.executeUpdate();
				    if(c==0)
				    	System.out.println("employee not found");
				    else
				    	System.out.println("employee deleted ");
				   
		    	  }
		    	  catch(SQLException e){e.printStackTrace();}
	     }
	     else if(ch==3)
	     {
	    	 try{
		    	   Connection conn=getConnection();
		    	   String s1="delete from employee where kin_id= ?";
				    PreparedStatement st=conn.prepareStatement(s1);
				    st.setString(1,kinid);
				    int c=st.executeUpdate();
				    if(c==0)
				    	System.out.println("employee not found");
				    else
				    	System.out.println("employee deleted ");
				   
		    	  }
		    	  catch(SQLException e){e.printStackTrace();}	 
	     }
	}
	

	@Override
	public boolean  SearchEmployee1(String kinid) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		boolean result=false;
		if(conn==null)
		{
			System.out.println("connection failed");
			
	    }
		else 
		{
		try{	
	     Statement s;
	     s=conn.createStatement();
		 String s1="select * from Employee where kin_id="+kinid;
		 System.out.println("Employee_id   Name  Kin_Id  Email_id  Phone_no      DOB       DOJ      ADDRESS        DEPT_ID       PROJ_ID    ROLE_ID ");		 
		 ResultSet rs=s.executeQuery(s1);
		 if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	result=false;
		    }
		    else{
		 while(rs.next())
			{
				    int employee_id=rs.getInt("employee_id");
				    String name=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
				    System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			       result=true;
			}
		 
		    }
		
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		}
	
	return result;	
	}

	@Override
	public boolean SearchEmployee2(String emailid) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("connection failed");
			
	    }
		else 
		{
		try{	
			String s1="select * from employee where email_id= ?";
		    PreparedStatement s=conn.prepareStatement(s1);
		    s.setString(1,emailid);
		    ResultSet rs=s.executeQuery();
		    while(rs.next())
		    	 if(rs==null)
				    {
				    	System.out.println("employee is not in db");
				    	result=false ;
				    }
				    else{	
			{
				    int employee_id=rs.getInt("employee_id");
				    String name=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
					System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			       result=true;  
			}
		 
		 
		}
		    }
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		}
		return result;
	}

	@Override
	public boolean SearchEmployee3(String name) {
		// TODO Auto-generated method stub
        boolean result=false;
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("connection failed");

			
	    }
		else 
		{
		try{	
			String s1="select * from employee where name= ?";
		    PreparedStatement s=conn.prepareStatement(s1);
		    s.setString(1,name);
		    ResultSet rs=s.executeQuery();
		    if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	result=false;
		    }
		    else{
		 while(rs.next())
			{
				    int employee_id=rs.getInt("employee_id");
				    String name1=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
					System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			        result=true;
			}}
		 
		 
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		}
		return result;
	}

	@Override
	public boolean SearchEmployee4(String kinid, String emailid) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("connection failed");
		
	    }
		else 
		{
		try{	
			String s1="select * from employee where kin_id=? and email_id= ?";
		    PreparedStatement s=conn.prepareStatement(s1);
		    s.setString(1,kinid);
		    s.setString(2, emailid);
		    ResultSet rs=s.executeQuery();
		    if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	result=false;
		    }
		    else{
		 while(rs.next())
			{
				    int employee_id=rs.getInt("employee_id");
				    String name=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
					System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			        result=true; 
			}
		 
	
		}}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		}
		return result;
	}

	@Override
	public boolean SearchEmployee5(String kinid, String name) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("connection failed");
			
	    }
		
		try{	
			String s1="select * from employee where kin_id=? and name=?";
		    PreparedStatement s=conn.prepareStatement(s1);
		    s.setString(1,kinid);
		    s.setString(2,name);
		    ResultSet rs=s.executeQuery();
		    if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	 result=false;
		    }
		    else{
		 while(rs.next())
			{
				    int employee_id=rs.getInt("employee_id");
				    String name1=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
					System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			        result=true;
			}
		 
		    }
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return result;
		}
		
	

	@Override
	public boolean SearchEmployee6(String emailid, String name) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		boolean result=false;
		if(conn==null)
		{
			System.out.println("connection failed");
			
	    }
		else 
		{
		try{	
			String s1="select * from employee where email_id= ? and name=?";
		    PreparedStatement s=conn.prepareStatement(s1);
		    s.setString(1,emailid);
		    s.setString(2,name);
		    ResultSet rs=s.executeQuery();
		    if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	result=false;
		    }
		    else{
		 while(rs.next())
			{
				    int employee_id=rs.getInt("employee_id");
				    String name1=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
					System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			        result=true;
			}
		    }
		 
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		}
	return result;
	}

	@Override
	public boolean SearchEmployee7(String kinid, String emailid, String name1) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		boolean result=false;
		if(conn==null)
		{
			System.out.println("connection failed");
			
	    }
		else 
		{
		try{	
			String s1="select * from employee where email_id= ? and kin_id=? and name=?";
		    PreparedStatement s=conn.prepareStatement(s1);
		    s.setString(1,emailid);
		    s.setString(2,kinid);
		    s.setString(3,name1);
		    ResultSet rs=s.executeQuery();
		    if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	result=false;
		    }
		    else{
		 while(rs.next())
			{
				    int employee_id=rs.getInt("employee_id");
				    String name=rs.getString("name");
				    String kin_id=rs.getString("kin_id");
				    String email_id=rs.getString("email_id");
				    Long phoneno=rs.getLong("phone_no");
				    Date dob=rs.getDate("dob");
				    Date doj=rs.getDate("doj");
				    String add=rs.getString("address");
				    int dept_id=rs.getInt("dept_id");
				    int proj_id=rs.getInt("proj_id");
				    int role_id=rs.getInt("role_id");
					System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
			        result=true;
			}
		 
		    }
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		}
		return result;
	}

	@Override
	public void getAllEmployee(){
		// TODO Auto-generated method stub
		
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("connectio failed");
			return;
	    }
		else
		{
		 try{
	    System.out.println("Employee_id   Name  Kin_Id  Email_id  Phone_no      DOB       DOJ      ADDRESS        DEPT_ID       PROJ_ID    ROLE_ID ");		 
		Statement st=conn.createStatement();
		String s="select * from Employee";
		ResultSet rs=st.executeQuery(s);
		System.out.println("");
		 if(rs==null)
		    {
		    	System.out.println("employee is not in db");
		    	return;
		    }
		    else{
		while(rs.next())
		{
			    int employee_id=rs.getInt("employee_id");
			    String name=rs.getString("name");
			    String kin_id=rs.getString("kin_id");
			    String email_id=rs.getString("email_id");
			    Long phoneno=rs.getLong("phone_no");
			    Date dob=rs.getDate("dob");
			    Date doj=rs.getDate("doj");
			    String add=rs.getString("address");
			    int dept_id=rs.getInt("dept_id");
			    int proj_id=rs.getInt("proj_id");
			    int role_id=rs.getInt("role_id");
				System.out.println(employee_id+"      "+name+"      "+kin_id+"      "+email_id+"      "+phoneno+"      "+dob+"      "+doj+"      "+add+"      "+dept_id+"      "+proj_id+"      "+role_id);
		}
		}}
		catch(SQLException e)
		{
			e.printStackTrace();
		}}
	}

   public Connection getConnection()
   {
	   Connection dbconnection=null;
	   try{
	   String driver="com.mysql.jdbc.Driver";
	   String url="jdbc:mysql://localhost:3306/test";
	   Class.forName(driver);
	   
	   dbconnection=DriverManager.getConnection(url);
	   System.out.println("Got db connection"+(dbconnection!=null));}
	   catch(ClassNotFoundException e1){
			System.out.println("inside class not found");
			System.out.println(e1);
		}
		catch(SQLException e2){
			System.out.println("inside sql");
			System.out.println(e2);
		}
      return dbconnection;
   }
   }

