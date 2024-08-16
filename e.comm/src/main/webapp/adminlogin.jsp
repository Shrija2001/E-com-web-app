<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
%>
<p class=""text-center tex-danger><%=msg %></p>
<%} %>

<h1 class="text-center text-danger">Admin login</h1>

<div class="container w-50">
<form action="adlogin" method="post">

<label for="uname" class="form-label">Enter Username</label>
<input class="form-control" id="uname" name="uname">

<label for="upass" class="form-label">Enter Password</label>
<input class="form-control" id="upass" name="upass">

<button class="btn btn-success">Login</button>


</form>

<a href="adminsignup.jsp" class="btn btn-info mt-5">SignUp</a>

</div>



</body>
</html>