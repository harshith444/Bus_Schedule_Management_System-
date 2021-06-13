<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="MainServlet" method="post">
Enter source: <input type="text" name="source">
Enter Destination: <input type="text" name="destination">
<input type="hidden" name="operation" value="viewSchedule">
<input type="submit" value="search Schedule">
</form>
</body>
</html>