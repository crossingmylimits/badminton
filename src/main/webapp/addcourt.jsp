 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Court</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="ListCourtController">List Court</a><br><br>

<form action="AddCourtController" method="post">
    Name: <br>
    <input type="text" name="CourtName"/><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>