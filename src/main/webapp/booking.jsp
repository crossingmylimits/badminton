<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form action="AddShawlController" method="post">
    Name: <br>
    <input type="text" name="name"/><br>
    Brand: <br>
    <input type="text" name="brand"/><br>
    Color: <br>
    <input type="text" name="color"/><br>
    Material: <br>
    <select name="material">
      <option value="Chiffon">Chiffon</option>
      <option value="Cotton">Cotton</option>
      <option value="Silk">Silk</option>    
    </select><br>
    Price: <br>
    <input type="text" name="price"/><br>
    Quantity: <br>
    <input type="number" name="quantity"/><br><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
  </form>
</body>
</html>