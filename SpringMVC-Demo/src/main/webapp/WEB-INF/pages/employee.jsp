<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<style type="text/css">
.errMsg{
	color: red;
	font-size: 14px;
	font-weight: bold;
}
</style>

</head>
<body>
<form:form action="empSave" method="post" commandName="emp">
	<h2 align="center">Employee Form</h2>
	<form:input type="hidden" path="empId"/>
	<table>
		<%-- <tr>
			<td>EmployeeId:</td>
			<td>
				<form:input path="empId"/>
			</td>
		</tr> --%>
		<tr>
			<td>Employee-Name:</td>
			<td>
				<form:input path="empName"/>
			</td>
			<td>
				<form:errors cssClass="errMsg" path="empName"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Kin id:</td>
			<td>
				<form:input path="kinid"/>
			</td>
			<td>
			<td>
				<form:errors cssClass="errMsg" path="kinid"></form:errors>
			</td>
			</td>
		</tr>
		<tr>
			<td>Address:</td>
			<td>
				<form:input path="addr"/>
			</td>
			<td>
			</td>
		</tr>
		<tr>
			<td>E-Mail id:</td>
			<td>
				<form:input path="emailid"/>
			</td>
			<td>
			<td>
				<form:errors cssClass="errMsg" path="emailid"></form:errors>
			</td>
			</td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td>
				<form:input path="phone"/>
			</td>
			<td>
			</td>
		</tr>
		
		<tr>
			<td>Date of Birth:</td>
			<td>
				<form:input path="empDob"/>
			</td>
		</tr>
		<tr>
			<td>Date Of Joining:</td>
			<td>
				<form:input path="empDoj"/>
			</td>
			<td>
			</td>
		</tr>
		<tr>
			<td>Choose Department:</td>
			<td>
				<c:if test="${!empty departments }">
				<form:select path="department">
					<c:forEach var="depart" items="${departments}">
						<form:option value="${depart.deptId}"> ${depart.deptName}</form:option>
					</c:forEach>
				
				</form:select>
				</c:if>
			</td>
			
		
		</tr>
		<tr>
			<td>Choose Project:</td>
			<td>
				<c:if test="${!empty departments }">
				<form:select path="project">
					<c:forEach var="project" items="${projects}">
						<form:option value="${project.projectId}"> ${project.projectName}</form:option>
					</c:forEach>
				
				</form:select>
				</c:if>
			</td>
		</tr>
	
		<tr>
			<td>Choose Role:</td>
			<td>
				<c:if test="${!empty roles }">
				<form:select path="role">
					<c:forEach var="role" items="${roles}">
						<form:option value="${role.roleId}"> ${role.roleName}</form:option>
					</c:forEach>
				
				</form:select>
				</c:if>
			</td>
		
		</tr>
		
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" name="save" value="Save">
			</td>
			<td>
			</td>
		</tr>
	
	</table>
	
</form:form>

<c:if test="${!empty employees }">
	<table>
		<tr>
			<th>EmployeeId</th>
			<th>Employee-Name</th>
			<th>Kin id</th>
			<th>Phone</th>
			<th>E-Mail ID</th>
			<th>Address</th>
			<th>Date Of Birth</th>
			<th>Date of Joining</th>
			<th>Department</th>
			<th>Project</th>
			<th>Role</th>
			
			<th>Edit</th>
			
		</tr>
		
		<c:forEach var="employee" items="${employees}">
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.empName}</td>
			<td>${employee.kinid}</td>
			<td>${employee.phone}</td>
			<td>${employee.emailid}</td>
			<td>${employee.addr}</td>
			<td>${employee.empDob}</td>
			<td>${employee.empDoj}</td>
			<td>${employee.department}</td>
			<td>${employee.project}</td>
			<td>${employee.role}</td>
			
			<td>
				<a href="deleteEmployee/${employee.empId}">Delete</a>
				&nbsp;&nbsp;&nbsp;
				<a href="updateEmployee?id=${employee.empId}">Update</a>
			</td>
			
		</tr>
		</c:forEach>
	</table>

</c:if>



</body>
</html>