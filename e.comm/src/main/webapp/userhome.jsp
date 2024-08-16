<%@page import="org.hibernate.annotations.Check"%>
<%@page import="com.MainApp.Pojo.BuyProduct"%>
<%@page import="com.MainApp.Pojo.Cart"%>
<%@page import="com.MainApp.Pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#cartvb{
position: absolute;
top: 0px;
right: 0px
}

.cartbox{
display:none;
border:2px solid black;
position: absolute;
top: 50px;
right: 150px
}

.orderb{
position: absolute;
top: 80px;
right: 0px
}

.orderbox{
display:none;
border:2px solid black;
position: absolute;
top: 50px;
right: 150px
}

</style>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<body>


<%
String check = (String)request.getAttribute("check");
List<Product> lallp = (List<Product>)request.getAttribute("lallp");
List<Cart> lcp = (List<Cart>)request.getAttribute("lcp");
List<BuyProduct> lbp = (List<BuyProduct>)request.getAttribute("lbp");

if(check != null)
{
%>
<h1>Welcome back <%=check %></h1>
<a class="btn btn-danger" href="userlogin.jsp">Logout</a>
<%}
else
{
%>
<h1>Please login</h1>
<a class="btn btn-primary" href="userlogin.jsp">Login</a>
<%} %>

<!-- display all products -->

<%
if(lallp != null)
{
	for(Product p:lallp)
	{
%>

<div class="container row">
	<div class="col col-md-6">
		<div class="border rounded-4">
			<img style="width: 25%;" alt="loading" src="/productimg/<%=p.getPimgname() %>">
			<h3>Product Name:<%=p.getPname() %></h3>
			<p>Product Description:<%=p.getPdes() %></p>
			<h4>Product Price:<%=p.getPprice() %></h4>
			<h4>Product discount<%=p.getPdis() %></h4>
			<%
			if(check!=null)
			{
			%>
			<form action="addtocart" method="post">
			<input type="hidden" name="pname" value="<%=p.getPname()%>">
			<input type="hidden" name="uname" value="<%=check%>">
			<input type="hidden" name="adname" value="<%=p.getUname()%>">
			<button class="btn btn-sm btn-info">Add to Cart</button>
			</form>
			<%}
			else
			{
			%>
			<button class="btn btn-sm btn-info" onclick="showmsg()">Add to Cart</button>
			<%} %>
		</div>
	</div>
</div>

<%}} %>

<!-- cart button and display cart product -->

<%if(check!=null)
	{%>
<button id="cartvb" class="btn btn-info" onclick="showCart()">View Cart</button>
<%} %>


<div class="cartbox">
<button class="btn-close" onclick="closecart()"></button>
<h1 class="text-center">Cart Product</h1>
<%
if(lcp!=null)
{
	for(Cart c:lcp)
	{
%>
<div class="border mb-3">
<h1>Product name:<%=c.getPname() %></h1>
<form action="buyproduct" method="post">
<input type="hidden" name="adname" value="<%=c.getAdname()%>">
<input type="hidden" name="pname" value="<%=c.getPname()%>">
<input type="hidden" name="uname" value="<%=check%>">
<button class="btn btn-sm btn-info">Buy</button>
</form>
</div>
<%}} %>
</div>



<!-- 
display Orders
 -->
 
 <button  class="orderb btn btn-info" onclick="showorderbox()">Orders</button>
 
 
 <div class="orderbox">
 <button class="btn-close" onclick="closeorderbox()"></button>
 <h1>orders</h1>
 <%
 if(lbp!=null)
 {
	 for(BuyProduct bp:lbp)
	 {
 %>
 <h1><%=bp.getPname() %></h1>
 <%}} %>
 </div>


<script type="text/javascript">
function showmsg()
{
	alert("please login");
}

function showCart()
{
	document.getElementsByClassName("cartbox")[0].style.display="block";
}

function closecart()
{
	document.getElementsByClassName("cartbox")[0].style.display="none";
}

function closeorderbox()
{
	document.getElementsByClassName("orderbox")[0].style.display="none";
}

function showorderbox()
{
	document.getElementsByClassName("orderbox")[0].style.display="block";
}
</script>




</body>
</html>