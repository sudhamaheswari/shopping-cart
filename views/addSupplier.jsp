<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add a Supplier</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Admin">Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="ManageProduct">Manage Products</a></li>
      <li><a href="ManageSupplier">Manage Suppliers</a></li>
       </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<h2>Add a Supplier</h2>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="addsupplier" value="addSupplier"></c:url>
   <form:form commandName="Supplier" method="post" action="storesupplier">
       <table class="table table-bordered" >
           
           <tr><td><form:label path="supname">Supplier Name :</form:label></td>
               <td><form:input path="supname"/>
               <font color="red"><form:errors path="supname"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="suplocation">Supplier Location:</form:label></td>
               <td><form:input path="suplocation"/>
               <font color="red"><form:errors path="suplocation"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="categoryid">Category Id :</form:label></td>
               <td><form:input path="categoryid"/>
               <font color="red"><form:errors path="categoryid"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="categoryname">Category Name :</form:label></td>
               <td><form:input path="categoryname"/>
               <font color="red"><form:errors path="categoryname"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="productid">Product Id :</form:label></td>
               <td><form:input path="productid"/>
               <font color="red"><form:errors path="productid"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="productname">Product Name :</form:label></td>
               <td><form:input path="productname"/>
               <font color="red"><form:errors path="productname"></form:errors></font></td>
           </tr>
             <td><input type="submit" value="Add Supplier" class="btn-success"/></td>
       </table>
   </form:form> 
   </div>
   	 <div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  <div class="container"></div>
  <div class="navbar-text pull-left">�Dise�os-Copy Rights Reserved</div>
</div>
   
</body>
</html>