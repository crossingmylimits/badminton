<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shawl Info</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListCustController">List Customer</a><br><br>

	<h1>Customer Info</h1>
	Cust_ID: <c:out value="${c.custID}"/> <br>
	Cust_Name: <c:out value="${c.custName}"/> <br>
	Cust_PhoneNum: <c:out value="${c.custPhoneNum}"/> <br>
	Cust_Email: <c:out value="${c.custEmail}"/> <br>
	Cust_Pass: <c:out value="${c.custPass}"/> <br>

</body>
</html>