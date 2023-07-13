<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Courts</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="addcourt.jsp">Add Court</a><br><br>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th colspan="3">Action</th>
		</tr>
		<c:forEach items="${court}" var="c" varStatus="courtStatus">
		<tr>
        	<td><c:out value="${c.courtID}"/></td>
            <td><c:out value="${c.courtName}"/></td>      
            <td><a class="btn btn-primary" href="ViewCourtController?CourtID=<c:out value="${c.courtID}"/>">View</a></td>
            <td><a class="btn btn-primary" href="UpdateCourtController?CourtID=<c:out value="${c.courtID}"/>">Update</a></td>
            <td><button class="btn btn-danger" id="<c:out value="${c.courtID}"/>" onclick="confirmation(this.id)">Delete</button></td>    
        </tr>
        </c:forEach>
	</table>
	<script>
	function confirmation(courtID) {					  		 
		console.log(courtID);
		var r = confirm("Are you sure you want to delete?");
		if (r == true) {				 		  
			location.href = 'DeleteCourtController?CourtID=' + courtID;
			alert("Court successfully deleted");			
		} else {				  
			return false;	
		}
	}
	</script>
</body>
</html>