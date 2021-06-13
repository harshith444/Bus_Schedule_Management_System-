<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,com.wipro.bus.bean.ScheduleBean,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Schedule ID  Source  Destination  Start Time   Arrival Time</h3>

<%ArrayList<ScheduleBean> stdi = (ArrayList<ScheduleBean>)request.getAttribute("data");%>
<table>
<tr>
<% for(ScheduleBean sb:stdi){%>
	<td><%=sb.getScheduleId() %></td>
	<td><%=sb.getSource() %></td>
	<td><%=sb.getDestination() %></td>
	<td><%=sb.getStartTime() %></td>
	<td><%=sb.getArrivalTime() %></td>
</tr>
<%} %>
</table>
<a href="menu.html" >menu</a>
</body>
</html>