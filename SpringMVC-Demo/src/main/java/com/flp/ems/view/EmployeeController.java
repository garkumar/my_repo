package com.flp.ems.view;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.service.EmployeeService;

	@Controller
	public class EmployeeController {

		@Autowired
		private EmployeeService employeeService;
		
		 Employee emp;
		 @ModelAttribute("emp")
		 public Employee getEmployee()
		 {
			 return new Employee();
		 }
		@RequestMapping(value={"/employeeForm","/updateEmployee"})
		public String showEmployeeForm(ModelMap map,@RequestParam(value="id",required=false) String employeeid){
			//Map<String, Object> map=new HashMap<>();
			int id;
			if(employeeid!=null)
				id=Integer.parseInt(employeeid);
			else
				id=-1;
			if(id!=-1){
			emp=employeeService.findById(id);
			System.out.println("Employee_id inside show EmployeeForm:"+emp.getEmpId());
			map.put("emp",emp);
		}
			
			/*map.put("deps", getAllDepartments());
			map.put("pros", getAllProjects());
			map.put("role", getAllRoles());*/
			map.put("departments", employeeService.getAllDepartments());
			map.put("projects", employeeService.getAllProjects());
			map.put("roles", employeeService.getAllRoles());
			map.put("employees", employeeService.getAllEmployees());
			
			return "employee";
		}
		
		
		@RequestMapping(value="/empSave",method=RequestMethod.POST)
		public String saveEmployee(@Valid @ModelAttribute("emp")Employee employee,
				BindingResult results,ModelMap map){
			String deptid=employee.getDepartment();
			System.out.println("Deptid="+deptid);
			Department d=employeeService.DepartmentfindById(deptid);
			System.out.println("DEPARTMENT OBJECT"+d);
			employee.setDepartments(d);
			//System.out.println(employee);
			//System.out.println("Employee_id in save :"+employee.getEmpId());
			String projid=employee.getProject();
			Project p=employeeService.ProjectfindById(projid);
			employee.setProjects(p);
			String roleid=employee.getRole();
			Role r=employeeService.RolefindById(roleid);
			employee.setRoles(r);
			map.put("deps", getAllDepartments());
			map.put("pros", getAllProjects());
			map.put("role", getAllRoles());
			map.put("employees", employeeService.getAllEmployees());
			
			if(results.hasErrors()){
				return "employee";
			}else{
				if(employee.getEmpId() == -1){
					employeeService.saveEmployee(employee);
					}
				else{
					employeeService.updateEmployee(employee);
					}
				return "redirect:employeeForm";
			}
		}
		
		
		
		public List<String> getAllDepartments(){
			List<String> departs=new ArrayList<>();
			departs.add("ADM");
			departs.add("Cards");
			departs.add("InD");
			departs.add("Capital Market");
			departs.add("Support");
			departs.add("HR");
			departs.add("Training");
			return departs;
		}
		public List<String> getAllProjects(){
			List<String> projects=new ArrayList<>();
			projects.add("Morgan Stanley");
			projects.add("SAP Labs");
			projects.add("HP");
			projects.add("ORACLE");
			projects.add("PEGA");
			projects.add("Microsoft");
			projects.add("GUIDEWIRE");
			return projects;
		}
		public List<String> getAllRoles(){
			List<String> roles=new ArrayList<>();
			roles.add("Software Engineer");
			roles.add("Sr Software Engineer");
			roles.add("Software Analyst");
			roles.add("Consultant");
			roles.add("Associate Consultant");
			roles.add("Bench");
			return roles;
		}
		
		@RequestMapping("/deleteEmployee/{empId}")
		public String deleteEmployee(@PathVariable("empId") Integer employeeId){
			employeeService.deleteEmployee(employeeId);
			
			return "redirect:/employeeForm";
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
