<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Staff</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListStaffController">List Staff</a><br><br>

<form action="UpdateStaffController" method="post">
    Name: <br>
    <input type="text" name="StaffName" value="<c:out value="${c.staffName}"/>"/><br>
    Role: <br>
    <input type="text" name="StaffRole" value="<c:out value="${c.staffRole}"/>"/><br>
    Phone Number: <br>
    <input type="text" name="StaffPhoneNum" value="<c:out value="${c.staffPhoneNum}"/>"/><br>
    Email: <br>
    <input type="text" name="StaffEmail" value="<c:out value="${c.staffEmail}"/>"/><br>
    Password: <br>
    <input type="password" name="StaffPass" value="<c:out value="${c.staffPass}"/>"/><br><br>
    Manager: <br>
    <input type="text" name="ManagerID" value="<c:out value="${c.managerID}"/>"/><br>
    <input type="hidden" name="StaffID" value="<c:out value="${c.staffID}"/>"/><br><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>
