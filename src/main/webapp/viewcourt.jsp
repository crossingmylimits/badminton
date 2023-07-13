<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Court Info</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListCourtController">List Court</a><br><br>

<h1>Court Info</h1>
Id: <c:out value="${c.courtID}"/> <br>
Name: <c:out value="${c.courtName}"/> <br>
</body>
</html>