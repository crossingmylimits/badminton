 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="registerpage.jsp">Add Customer</a><br><br>
	<table border="1">
		<tr>
			<th>CustId</th>
			<th>CustName</th>
			<th>CustPhoneNum</th>
			<th>CustEmail</th>
			<th>CustPass</th>
			<th colspan="3">Action</th>
		</tr>
		<c:forEach items="${customers}" var="c" varStatus="customers">
		<tr>
			<td><c:out value="${c.custID}"/></td>
			<td><c:out value="${c.custName}"/></td>
			<td><c:out value="${c.custPhoneNum}"/></td>
			<td><c:out value="${c.custEmail}"/></td>
			<td><c:out value="${c.custPass}"/></td>
			<td><a class="btn btn-primary" href="ViewCustController?CustID=<c:out value="${c.custID}"/>">View</a></td>
			<td><a class="btn btn-primary" href="UpdateCustController?CustID=<c:out value="${c.custID}"/>">Update</a></td>
			<td><button class="btn btn-danger" id="<c:out value="${c.custID}"/>" onclick="confirmation(this.id)">Delete</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
	function confirmation(custID) {
		console.log(custID);
		var r = confirm("Are you sure you want to delete?");
		if (r) {
			location.href = 'DeleteCustController?CustID=' + custID;
			alert("Customer successfully deleted");
		} else {
			return false;
		}
	}
</script>


</body>
</html>
