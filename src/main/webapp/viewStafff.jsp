<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Info</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListStaffController">List Staff</a><br><br>

<h1>Staff Info</h1>
Staff_ID: <c:out value="${c.staffID}"/> <br>
Staff_Name: <c:out value="${c.staffName}"/> <br>
Staff_Role: <c:out value="${c.staffRole}"/> <br>
Staff_PhoneNum: <c:out value="${c.staffPhoneNum}"/> <br>
Staff_Email: <c:out value="${c.staffEmail}"/> <br>
Staff_Pass: <c:out value="${c.staffPass}"/> <br>
Manager_ID: <c:out value="${c.managerID}"/> <br>

</body>
</html>
