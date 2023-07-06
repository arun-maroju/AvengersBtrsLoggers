<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Avengers BusBooking</title>
   <link href="<c:url value="/resources/styles/navbar.css" />" rel="stylesheet">
  
</head>
<body>
<nav>
    <ul class="menu">
      <li><h4>AVENGERS BTRS</h4></li>
      <li><a href="home">Home</a></li>
      <li><a href="login">Dashboard</a></li>
      <li><a href="about">About Us</a></li>
      <li><a href="contact">Contact Us</a></li>
      <li>
        <a href="#">Login</a>
        <ul class="submenu">
          <li><a href="login">User</a></li>
          <li><a href="adminLogin">Admin</a></li>
        </ul>
      </li>
      <li><a href="signup">SignUp</a></li>
    </ul>
  </nav>
  <div>
<footer class="footer">
  <p>
Copyright @ BTRS Ltd. All Right Reserved.</p>
</footer>
</div>
</body>
</html>