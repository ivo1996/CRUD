<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert data</title>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' });
            });
        </script>
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


<form name="People" method="post" action="insertData">
<div style="margin-left: 35px;">
<h3>Insert User</h3>
<input type="text" name="FirstName" placeholder="First Name"/><br>
<input type="text" name="LastName" placeholder="Last Name"/><br>
<input type="Date" name="BirthDate" id="datepicker" placeholder="Birth Date"/><br>
<input type="text" name="Phone" placeholder="Phone number"/><br>
<input type="text" name="Email" placeholder="E-mail address"/><br>
<input type="submit" name="submit" value="Submit"><br>
${message}</div>
</form>
</body>
</html>