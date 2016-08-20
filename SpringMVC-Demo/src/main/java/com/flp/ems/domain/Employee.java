package com.flp.ems.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Cap_FLP_Employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;

    @NotEmpty(message="* Please Enter FirstName.")
	private String firstName;
	private String lastName;
	@Min(value=2000,message="*Enter a min salary of 2000")          
	private double salary;
    @Past(message="* Enter a valid past dob")
	private Date empDob;
    @Future(message ="* Enter a valid future doj ")
    private Date empDoj;
    private int departmentid;
	public  int getDepartmentid() {
		return departmentid;
	}
    public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}



	
	@NotEmpty(message="* Please Enter an email.")
	@Email(message="* Please Enter a valid email.")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(){
		this.empId=-1;
	}
	
	

	public Employee(int empId, String firstName, String lastName, double salary, Date empDob, Date empDoj,
			int departmentid, String email) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.empDob = empDob;
		this.empDoj = empDoj;
		this.departmentid = departmentid;
		this.email = email;
	}

	public int getEmpId() {
	return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public Date getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", empDob=" + empDob + ", empDoj=" + empDoj + ", departmentid=" + departmentid + ", email=" + email
				+ "]";
	}
	
	
	
	
	

}
