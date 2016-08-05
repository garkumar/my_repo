package com.flp.ems.domain;



import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.flp.ems.dao.EmployeeDaoImplForDB;


public class PROJECT 
{
private int Project_id, Department_id;
private String Name,Description;
private Department d;
public static HashSet hsh_proj=new HashSet();
PROJECT()
{
	int deptid;
	Department d=new Department();
	Department d1;
	/*Scanner s=new Scanner(System.in);
	System.out.println("first choose the deptid from the below list");
	System.out.println("Enter deptid 1 for proj on devops ");
	System.out.println("Enter deptid 2 for proj on Clouds");
	System.out.println("Enter deptid 3 for proj on Mainframe");
	System.out.println("Enter deptid 4 for proj on Testing");
	System.out.println("Enter deptid 5 for proj on Admjava");
	System.out.println("Enter deptid for project 1");
	deptid=s.nextInt();*/
	d1=Department.Search_dept(1);
	PROJECT p1=new PROJECT(1,"proj on devops","proj on devops",d1);
	hsh_proj.add(p1);
    System.out.println("Enter deptid for project 2");
	//deptid=s.nextInt();
	d1=Department.Search_dept(2);
	PROJECT p2=new PROJECT(2,"Clouds","Prog devloped in cloud",d1);
	hsh_proj.add(p2);
	PROJECT p3=null;
	System.out.println("Enter deptid for project 3");
	//deptid=s.nextInt();
	d1=Department.Search_dept(3);
	p3=new PROJECT(3,"Mainframe","mainframe",d1);
	hsh_proj.add(p3);
	PROJECT p4=null;
	System.out.println("Enter deptid for project 4");
	//deptid=s.nextInt();
	d1=Department.Search_dept(4);
	p4=new PROJECT(4,"Testing","testing",d1);
	hsh_proj.add(p4);
	PROJECT p5=null;
	System.out.println("Enter deptid for project 5");
	//deptid=s.nextInt();
	d1=Department.Search_dept(5);
	p5=new PROJECT(5,"Admjava","Admjava",d1);
	
	hsh_proj.add(p5);
	PROJECT p;
	Iterator it=hsh_proj.iterator();
	while(it.hasNext())
	{
		p=(PROJECT)it.next();
		System.out.println(p.getProject_id()+p.getDescription()+p.getName()+p.getD());
}}
	
PROJECT(int Project_id,String Name,String Description,Department d)
{
	setProject_id(Project_id);
	setDescription(Description);
	setName(Name);
	setD(d);
}


public int getProject_id() {
	return Project_id;
}
public void setProject_id(int project_id) {
	Project_id = project_id;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getDepartment_id() {
	return Department_id;
}
public void setDepartment_id(int department_id) {
	Department_id = department_id;
}
public Department getD() {
	return d;
}
public void setD(Department d) {
	this.d = d;
}
public static void main(String args[])
{
	PROJECT  p=new PROJECT ();
}
public static PROJECT Search_Project(int projid)
{
	Iterator it=hsh_proj.iterator();
	PROJECT p=null;
	while(it.hasNext())
	{
		p=(PROJECT)it.next();
		
		if (p.getProject_id()==projid)
			return p;
	}
	if(p==null)
		System.out.println("dept not found");
	return p;
}


}
