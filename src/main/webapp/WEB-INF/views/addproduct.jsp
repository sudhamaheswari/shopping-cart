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
<title>Add a product</title>
</head>
<body>
<nav class="navbar navbar-inverse"> <!--standard navbar is created-->
  <div class="container-fluid"> <!-- .container-fluid expands to fill the available width -->
    <div class="navbar-header">
      <a class="navbar-brand" href="Admin">Home</a> <!--  for your company, product, or project name -->
    </div> <!-- tag defines a division or a section in an HTML document. -->
    <ul class="nav navbar-nav">
      <li class="active"><a href="ManageProduct">Manage Products</a></li>
   
      <li><a href="ManageSupplier">Manage Suppliers</a></li>
    </ul> <!--  tag defines an unordered (bulleted) list. -->
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> <!--span tag for styling; glypicon is for giving icon  -->
    </ul>
  </div>
</nav>
<h2>Add a Product</h2>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="addproduct" value="addproduct"></c:url>
   <form:form commandName="Product" method="post" action="storeproduct" enctype="multipart/form-data"> <!-- Generates the HTML <form> tag. It has the name attribute that
specifies the command object that the inner tags should bind to;enctype='multipart/form-data' means that no characters will be encoded. that is why this type is used while uploading files to server. So multipart/form-data is used when a form requires binary data, like the contents of a file, to be uploaded. -->
       <table class="table table-bordered" > <!-- .table-based tables look in Bootstrap. All table styles are inherited in Bootstrap 4 ;.table-bordered for borders on all sides of the table and cells  -->
      
           <tr><td><form:label path="Name">Product Name :</form:label></td> <!-- td tag contains data; <form> tag is used to create an HTML form for user input; tag defines a label for an <input> element.  -->
               <td><form:input path="Name"/>
               <font color="red"><form:errors path="Name"></form:errors></font></td>  
           </tr>  <!--  tag defines a row in an HTML table -->
           
           <tr><td><form:label path="Description">Product Description :</form:label></td>
               <td><form:input path="Description"/>
               <font color="red"><form:errors path="Description"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="Price">Product Price:</form:label></td>
               <td><form:input path="Price"/>
               <font color="red"><form:errors path="Price"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="primarymaterial">Product Primary Material :</form:label></td>
               <td><form:input path="primarymaterial"/>
               <font color="red"><form:errors path="primarymaterial"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="style">Product Style :</form:label></td>
               <td><form:input path="style"/>
               <font color="red"><form:errors path="style"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="warranty">Product Warranty :</form:label></td>
               <td><form:input path="warranty"/>
               <font color="red"><form:errors path="warranty"></form:errors></font></td>
           </tr>   
            <tr><td><form:label path="quantity">Product Quantity :</form:label></td>
               <td><form:input path="quantity"/>
               <font color="red"><form:errors path="quantity"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="capacity">Product Capacity :</form:label></td>
               <td><form:input path="capacity"/>
               <font color="red"><form:errors path="capacity"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="img">Product Image:</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>  
           </tr>
           <tr><td><form:label path="supplier">Supplier Name:</form:label></td>
               <td><select name="Supplier.id">  <!-- select tag is for dropdown with name attribute -->
   				 <option value="">---Select---</option>
   				 <c:forEach var="Supplier" items="${suppliers}">
   				 <option value="${Supplier.id}">${Supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
            </table>
            <td><input type="submit" value="Add product" class="btn btn-success"></td>  <!-- btn-success is for button style in bootstrap -->
   </form:form> 
   </div>
   	 <div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  <div class="container"></div>
  <div class="navbar-text pull-left">�Dise�os-Copy Rights Reserved</div>
</div>
   
</body>
</html>