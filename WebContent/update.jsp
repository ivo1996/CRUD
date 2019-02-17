<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ivo.pkg.UserBean"%>
<%@page import="java.sql.Date"%>

<%//UserBean u = new UserBean(); %>
<%int Id = (Integer)request.getAttribute("Id"); %>
<% String FirstName = (String)request.getAttribute("FirstName"); %>
<% String LastName = (String)request.getAttribute("LastName"); %>
<% String BirthDate = (String)request.getAttribute("BirthDate"); %>
<% String Phone = (String)request.getAttribute("Phone"); %>
<% String Email = (String)request.getAttribute("Email"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
<title>Edit User</title>
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
<form name="People" method="post" action="updateServlet">
<div style="margin-left: 35px;">
<h3>Edit User</h3>
<input type="text" name="FirstName" value="<%=FirstName%>"/><br>
<input type="text" name="LastName" value="<%=LastName%>"/><br>
<input type="text" style="width: 350px" name="BirthDate" id="datepicker" placeholder="Retype or insert new date! /current date=<%=BirthDate%>/"/><br>
<input type="text" name="Phone" value="<%=Phone%>"/><br>
<input type="text" name="Email" value="<%=Email%>"/><br>
<input type="hidden" name="Id" value="<%=Id %>"/><br>
<input type="submit" name="submit" value="Update"><br>
</div>
</form>
</head>
<body>

</body>
</html>