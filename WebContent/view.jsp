<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ivo.pkg.UserBean"%>    
<%ArrayList usrList = (ArrayList)request.getAttribute("usrList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Users</title>
</head>
<body>
<!--Navigation bar-->
<div id="nav-placeholder">

</div>

<script>
$(function(){
  $("#nav-placeholder").load("navbar.jsp");
});
</script>
<!--end of Navigation bar-->
<div style="margin-left: 30px;" >
<table style="width:100%">
<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Birth Date</th><th>Phone Number</th><th>E-mail Address</th></tr>
<% for(int i=0;i<usrList.size();i++){%>
	<tr>
	<%UserBean usr = (UserBean)usrList.get(i);%>
		<td><%= usr.getId()%></td>
		<td><%= usr.getFirstName()%></td>
		<td><%= usr.getLastName()%></td>
		<td><%= usr.getBirthDate()%></td>
		<td><%= usr.getPhone()%></td>
		<td><%= usr.getEmail()%></td>
		<td><form action="updateRecords" method="post"><input type="submit" name = "submit" value="edit">
		<input type="hidden" name = "usrID" value="<%= usr.getId()%>"></form></td>		
		<td><form action="deleteRecord" method="post"><input type="submit" name = "submit" value="delete">
		<input type="hidden" name = "usrID" value="<%= usr.getId()%>"></form></td>
		</tr>
<%}%>
</table>
</div>
</body>
</html>