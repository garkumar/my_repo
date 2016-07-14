package com.flp.ems.domain;
import java.sql.Date;
public class Employee 
{
private int Employee_id,Department_id,Project_id,Roles_id;
private Long Phone_no;
private String Name,Email_id,Kin_Id,Date_of_birth,Date_of_Joining,
Address;

public int getEmployee_id() {
	return Employee_id;
}
public void setEmployee_id(int employee_id) {
	Employee_id = employee_id;
}
public Long getPhone_no() {
	return Phone_no;
}
public void setPhone_no(Long phone_no) {
	Phone_no = phone_no;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail_id() {
	return Email_id;
}
public void setEmail_id(String email_id) {
	Email_id = email_id;
}
public String getKin_Id() {
	return Kin_Id;
}
public void setKin_Id(String kin_Id) {
	Kin_Id = kin_Id;
}

public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}

public int hashCode()
{
	return 2*(Department_id)+3*(Project_id);
  }
public boolean equals(Object o)
{
    if(o == null) return false;
    if(!(o instanceof Employee))
    	return false;

    Employee other = (Employee) o;
    if(! this.Kin_Id.equals(other.Kin_Id)) return false;
    if(! this.Email_id.equals(other.Email_id))   return false;

    return true;
  }
public int getDepartment_id() {
	return Department_id;
}
public void setDepartment_id(int department_id) {
	Department_id = department_id;
}
public int getRoles_id() {
	return Roles_id;
}
public void setRoles_id(int roles_id) {
	Roles_id = roles_id;
}
public int getProject_id() {
	return Project_id;
}
public void setProject_id(int project_id) {
	Project_id = project_id;
}
public String getDate_of_birth() {
	return Date_of_birth;
}
public void setDate_of_birth(String date_of_birth) {
	Date_of_birth = date_of_birth;
}
public String getDate_of_Joining() {
	return Date_of_Joining;
}
public void setDate_of_Joining(String date_of_Joining) {
	Date_of_Joining = date_of_Joining;
}


}
