package com.flp.ems.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		
	}
	
	@Override
	public Employee findById(int id){
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	    return emp; 
	}
	@Override
	public Department DepartmentfindById(String id){
		int deptId=Integer.parseInt(id);
		System.out.println(deptId+"in dao");
		Department d=(Department)sessionFactory.getCurrentSession().get(Department.class, deptId);
	    return d; 
	}
	@Override
	public Project ProjectfindById(String id){
		int dept_id=Integer.parseInt(id);
		Project p=(Project)sessionFactory.getCurrentSession().get(Project.class, dept_id);
	    return p; 
	}
	@Override
	public Role RolefindById(String id){
		int ids=Integer.parseInt(id);
		Role r=(Role)sessionFactory.getCurrentSession().get(Role.class, ids);
	    return r; 
	}
	@Override
	public void updateEmployee(Employee emp){
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public List<Department> getAllDepartments() {
	//populatedept();
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

	@Override
	public List<Project> getAllProjects() {
		//populateproj();
		return sessionFactory.getCurrentSession().createQuery("from Project").list();
	}

	@Override
	public List<Role> getAllRoles() {
	//populaterole();
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}
	@Override
	public void deleteEmployee(int employeeId) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(emp!=null)
			sessionFactory.getCurrentSession().delete(emp);
		 
	}

		public void populatedept() {
		// TODO Auto-generated method stub
		Department d1=new Department(111,"ADM","Project-Efficient");
		Department d2 =new Department(222,"Cards","Time-Bound");
		Department d3=new Department(333,"InD","Development");
		Department d4=new Department(444,"Capital Market","Finance");
		sessionFactory.getCurrentSession().save(d1);
		sessionFactory.getCurrentSession().save(d2);
		sessionFactory.getCurrentSession().save(d3);
		sessionFactory.getCurrentSession().save(d4);
		
		
	}


	public void populateproj() {
		// TODO Auto-generated method stub
		Department d1=new Department(111,"ADM","Project-Efficient");
		Department d2 =new Department(222,"Cards","Time-Bound");
		Department d3=new Department(333,"InD","Development");
		Department d4=new Department(444,"Capital Market","Finance");
		Project p1=new Project(110,"Banking","Morgan Stanley",d1);
		Project p2=new Project(220,"Research","SAP Labs",d2);
		Project p3=new Project(330,"Technology","HP",d3);
		Project p4=new Project(440,"Programming","ORACLE",d4);
		sessionFactory.getCurrentSession().save(p1);
		sessionFactory.getCurrentSession().save(p2);
		sessionFactory.getCurrentSession().save(p3);
		sessionFactory.getCurrentSession().save(p4);
		
	}

    	public void populaterole() {
		
		Role r1=new Role(100,"Sub-Ordinate","Software Engineer");
		Role r2=new Role(200,"In-Charge","Snr.Software Engineer");
		Role r3=new Role(300,"Analysis","Software Analyst");
		Role r4=new Role(400,"Clients","Consultant");
		Role r5=new Role(500,"Meetings","Associate Consultant");
		sessionFactory.getCurrentSession().save(r1);
		sessionFactory.getCurrentSession().save(r2);
		sessionFactory.getCurrentSession().save(r3);
		sessionFactory.getCurrentSession().save(r4);
		sessionFactory.getCurrentSession().save(r5);
	}

}
