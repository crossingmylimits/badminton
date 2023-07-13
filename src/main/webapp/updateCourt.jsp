<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Court</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListCourtController">List Court</a><br><br>

<form action="UpdateCourtController" method="post">
    Court Name: <br>
    <input type="text" name="CourtName" value="<c:out value="${c.courtName}"/>"/><br>
    <input type="hidden" name="CourtID" value="<c:out value="${c.courtID}"/>"/><br><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

</body>
</html>