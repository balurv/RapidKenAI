<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
	<h3>Employees List</h3>
	<table border="1">
		<thead>
		    <tr>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Salary</th>
		      <th>Department</th>
		      <th>Position</th>
		      <th>Email</th>
		      <th>Phone Number</th>
		    </tr>
		</thead>
		<tbody>
			<c:forEach items="${employeeList}" var="employee">  
			  <tr> 
			    <td>${employee.firstName}</td> 
			    <td>${employee.lastName}</td>
			    <td>${employee.salary}</td>
			    <td>${employee.department}</td> 
			    <td>${employee.position}</td>
			    <td>${employee.email}</td>
			    <td>${employee.phoneNumber}</td>
			   </tr> 
			</c:forEach> 
		</tbody>
	</table>
			
</body>
</html>