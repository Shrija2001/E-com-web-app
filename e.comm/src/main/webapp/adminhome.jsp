<%@page import="com.MainApp.Pojo.BuyProduct"%>
<%@page import="com.MainApp.Pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


<style type="text/css">

.addproduct{
display: none;
z-index: 1;
position: absolute;
left: 20rem;
top: 9rem;
border: 2px solid black;
border-radius:1rem;
padding: 1rem;


}

.orderbox{
position: absolute;
top: 30px;
right: 0px;
border: 2px solid red;

}
</style>

</head>
<body>

<%
String check=(String)request.getAttribute("check");
List<Product> lp=(List<Product>) request.getAttribute("lp");
List<BuyProduct> lbp=(List<BuyProduct>) request.getAttribute("lbp");
if(check!=null)
{
%>

<h1 class="text-center text-danger">hello, <%=check %></h1>
<h1 class="text-center text-danger">home page</h1>


<a class="btn btn-danger" href="adminlogin.jsp">Logout</a>

<a class="btn btn-info" onclick="showPform()">Product</a>
<!-- 
displaying products
 -->
<%
if(lp!=null)
{
	for(Product p:lp)
	{
		
%>
<div class="container w-25 border rounded p3 mb-3">

<img style="width:65% ;" alt="loading" src="/productimg/<%=p.getPimgname() %>">
<h3>Product Name:<%=p.getPname() %></h3>
<p>Product Description:<%=p.getPdes() %></p>
<h4>Product Price:<%=p.getPprice() %></h4>
<h4>Product discount<%=p.getPdis() %></h4>
<h4>Product Quantity<%=p.getPq() %></h4>
<form action="delProduct" method="post">
<input type="hidden" name="pname" value="<%=p.getPname()%>">
<input type="hidden" name="uname" value="<%=check%>">
<button class="btn btn-danger">Delete product</button>
</form>
</div>
<%}} %>

<!-- 
add product
 -->
 
<div class="addproduct w-25 bg-light" id="pbox">

<button class="btn-close btn btn-outline-danger" onclick="closePform()">&nbsp</button>

<form action="addproduct" method="post" enctype="multipart/form-data">

<label for="pname" class="form-label">Enter Product name</label>
<input class="form-control" type="text" name="pname" id="pname">


<label for="pdes" class="form-label">Enter Product description</label>
<input class="form-control" type="text" name="pdes" id="pdes">

<label for="pprice" class="form-label">Enter Product Price</label>
<input class="form-control" type="text" name="pprice" id="pprice">

<label for="pdis" class="form-label">Enter Product discount</label>
<input class="form-control" type="text" name="pdis" id="pdis">

<label for="pq" class="form-label">Enter Product Quantity</label>
<input class="form-control" type="text" name="pq" id="pq">

<label for="pimg" class="form-label">Select product image</label>
<input class="form-control" type="file" name="pimg" id="pimg">

<input type="hidden" name="uname" value="<%=check%>">

<button class="btn btn-primary">Add Product</button>


</form>
</div> 

<!-- 
show orders
 -->
<div class="orderbox">
<h1>orders</h1>
<%
if(lbp!=null)
{
	for(BuyProduct bp:lbp)
	{
%>
<h1><%=bp.getUname() %></h1>
<%}} %>
</div>








<script type="text/javascript">
function showPform()
{
	document.getElementById("pbox").style.display="block";
}

function closePform()
{
	document.getElementById("pbox").style.display="none";
}
</script>



<%}
else
{
	response.sendRedirect("adminlogin.jsp");
}
%>





</div>


</body>
</html>