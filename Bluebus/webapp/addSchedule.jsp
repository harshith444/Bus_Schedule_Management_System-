<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Schedule Details</h1><br>
<form action="MainServlet" method="post">
Source: <input type="text" name="source"><br>
Destination: <input type="text" name="destination"><br>
Start Time:<input type="text" name="st"><br>
Arrival Time:<input type="text" name="at"><br>
<input type="hidden" name="operation" value="newSchedule">
<input type="submit" value="create Schedule"> <br>
</form>

</body>
</html>