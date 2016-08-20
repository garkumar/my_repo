package com.flp.ems.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty(message="* Please enter a Name.")
	private String empName;
    private String phone;
	@NotEmpty(message="* Please enter a E-Mail ID.")
	@Email(message="* Please enter a valid E-Mail ID")
	private String emailid;
	@NotEmpty(message="* Please enter a Kin-ID.")
	@Column(unique = true)
	private String kinid;
	private String addr;
	@Past(message="* Please Enter a past date.")
	private Date empDob;
	private Date empDoj;
	private String department;
	private String project;
	private String role;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="departId_fk")
	private Department departments;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projectId_fk")
	private Project projects;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId_fk")
	private Role roles;
	
	
   public Employee(){
	this.empId=-1;
    }
	
	

	public Department getDepartments() {
	return departments;
}



public void setDepartments(Department departments) {
	this.departments = departments;
}



public Project getProjects() {
	return projects;
}



public void setProjects(Project projects) {
	this.projects = projects;
}



public Role getRoles() {
	return roles;
}



public void setRoles(Role roles) {
	this.roles = roles;
}



	public Employee(int empId, String empName, String phone, String emailid, String kinid, String addr, Date empDob,
		Date empDoj, String department, String project, String role, Department departments, Project projects,
		Role roles) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.phone = phone;
	this.emailid = emailid;
	this.kinid = kinid;
	this.addr = addr;
	this.empDob = empDob;
	this.empDoj = empDoj;
	this.department = department;
	this.project = project;
	this.role = role;
	this.departments = departments;
	this.projects = projects;
	this.roles = roles;
}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getKinid() {
		return kinid;
	}

	public void setKinid(String kinid) {
		this.kinid = kinid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", phone=" + phone + ", emailid=" + emailid
				+ ", kinid=" + kinid + ", addr=" + addr + ", empDob=" + empDob + ", empDoj=" + empDoj + ", department="
				+ department + ", project=" + project + ", role=" + role + ", departments=" + departments
				+ ", projects=" + projects + ", roles=" + roles + "]";
	}

	
}
