<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Customer</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListCustController">List Customers</a><br><br>

<form action="UpdateCustController" method="post">
    Name: <br>
    <input type="text" name="CustName" value="<c:out value="${c.custName}"/>"/><br>
    Phone Number: <br>
    <input type="text" name="CustPhoneNum" value="<c:out value="${c.custPhoneNum}"/>"/><br>
    Email: <br>
    <input type="text" name="CustEmail" value=" <c:out value="${c.custEmail}"/>"/><br>
    Password: <br>
    <input type="password" name="CustPass" value="<c:out value="${c.custPass}"/>"/><br><br>
    <input type="hidden" name="CustID" value="<c:out value="${c.custID}"/>"/><br><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

</body>
</html>
