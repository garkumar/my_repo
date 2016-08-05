package com.flp.ems.domain;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Department 
{ 
	private int Department_id;
	private String Name,Description;
	static HashSet<Department> dept=new HashSet<>();
	Department()
	{
		
		Department  d1=new Department(1,"Devops","Devlopment and operation");
		Department  d2=new Department(2,"Clouds","Prog devloped in cloud ");
		Department  d3=new Department(3,"Mainframe","mainframe");
		Department  d4=new Department(4,"Testing","testing");
		Department  d5=new Department(5,"Admjava","Admjava");
		dept.add(d1);
		dept.add(d2);
		dept.add(d3);
		dept.add(d4);
		dept.add(d5);
		Iterator it =dept.iterator();
		Department d;
		
	}
	Department(int deptid,String name,String Description)
	{
		setDepartment_id(deptid);
		setName(name);
		setDescription(Description);
	}
	
	public int getDepartment_id() {
		return Department_id;
	}
	public void setDepartment_id(int department_id) {
		Department_id = department_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public static Department Search_dept(int deptid)
	{
		Iterator it=dept.iterator();
		Department d=null;
		while(it.hasNext())
		{
			d=(Department)it.next();
			
			if (d.getDepartment_id()==deptid)
				return d;
		}
		if(d==null)
			System.out.println("dept not found");
		return d;
	}
	

}
