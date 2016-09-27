<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
  <title>Shopping Cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 60%;
      margin: auto;
  }
  h1{
  color:purple;
  }
  h1{
  text-align:center;
  }
  </style>
</head>
<body>
  

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
      <a class="navbar-brand" href="home"><font face="Gadget" size="50" color="sky blue"><span style=padding-left:20px><img src="<c:url value="/resources/images/logo5.png"/>" width="90" height="90">Diseños</font>
      <i><sub>Explore the interiors........</span></sub></a></i>
    
    <div class="navbar-collapse collapse"></div>
    <ul class="nav navbar-nav navbar-right">
   
     
     
      <li class="active"><a href="Home">Home</a></li>
      <li><a href="Contactus">Contact us</a></li>
      <li><a href="Products"> Product</a></li>
      <li><a href="reg"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
             
    </ul>
  </div>
</nav>
  

<div class="container">
  
    <div class="center-block">  
    
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    
   <!-- Wrapper for slides -->
    
    
    <div class="carousel-inner" role="listbox">
    
    
    
    
      <div class="item active">
         <img src="<c:url value="/resources/images/Pic1.jpg"/>" alt="Chania" width="1000" height="500">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/Pic2.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/Pic3.jpg"/>" alt="Chania" width="1000" height="500"> 
      </div>
      
      
       <div class="item">
         <img src="<c:url value="/resources/images/Pic4.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
      <div class="item">
         <img src="<c:url value="/resources/images/Pic5.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
      <div class="item">
         <img src="<c:url value="/resources/images/Pic6.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
        <div class="item">
         <img src="<c:url value="/resources/images/Pic7.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
        <div class="item">
         <img src="<c:url value="/resources/images/Pic8.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
        <div class="item">
         <img src="<c:url value="/resources/images/Pic9.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
          <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div></div></div>
  <br/>
 

<div class="container">
            
  <div class="row">
    <div class="col-sm-4">
      <a href="Products">
          
         <img src="<c:url value="/resources/images/Pic1.jpg"/>" alt="Pulpit Rock" style="width:300px;height:150px">
             </div>
    <div class="col-sm-4">
           
         <img src="<c:url value="/resources/images/Pic2.jpg"/>" alt="Moustiers Sainte Marie" style="width:300px;height:150px">
         
    </div>
    <div class="col-sm-4">
      <a href="Products">
           <img src="<c:url value="/resources/images/Pic3.jpg"/>" alt="Cinque Terre" style="width:300px;height:150px">
      </a>
    <div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  <div class="container"></div>
  <div class="navbar-text pull-left">©Diseños-Copy Rights Reserved</div>
</div>
    
  </div>
</div>
</body>
</html>