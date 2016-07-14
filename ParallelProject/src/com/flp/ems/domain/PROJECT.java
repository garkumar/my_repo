package com.flp.ems.domain;

public class PROJECT 
{
private int Project_id, Department_id;
private String Name,Description;

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


}
