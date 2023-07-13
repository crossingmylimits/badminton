<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Staff</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="registerpage.jsp">Add Staff</a><br><br>
	<table border="1">
		<tr>
			<th>StaffID</th>
			<th>StaffName</th>
			<th>StaffRole</th>
			<th>StaffPhoneNum</th>
			<th>StaffEmail</th>
			<th>StaffPass</th>
			<th>ManagerID</th>
			<th colspan="3">Action</th>
		</tr>
		<c:forEach items="${staffs}" var="c" varStatus="staffs">
		<tr>
			<td><c:out value="${c.staffID}"/></td>
			<td><c:out value="${c.staffName}"/></td>
			<td><c:out value="${c.staffRole}"/></td>
			<td><c:out value="${c.staffPhoneNum}"/></td>
			<td><c:out value="${c.staffEmail}"/></td>
			<td><c:out value="${c.staffPass}"/></td>
			<td><c:out value="${c.managerID}"/></td>
			<td><a class="btn btn-primary" href="ViewStaffController?StaffID=<c:out value="${c.staffID}"/>">View</a></td>
			<td><a class="btn btn-primary" href="UpdateStaffController?StaffID=<c:out value="${c.staffID}"/>">Update</a></td>
			<td><button class="btn btn-danger" id="<c:out value="${c.staffID}"/>" onclick="confirmation(this.id)">Delete</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
	function confirmation(staffID) {
		console.log(staffID);
		var r = confirm("Are you sure you want to delete?");
		if (r == true) {
			location.href = 'DeleteStaffController?StaffID=' + staffID;
			alert("Staff member successfully deleted");
		} else {
			return false;
		}
	}
	</script>
</body>
</html>