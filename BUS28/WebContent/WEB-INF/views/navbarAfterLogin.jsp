<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Avengers BusBooking</title>
   <link href="<c:url value="/resources/styles/navbarAfterLogin.css" />" rel="stylesheet">
  
</head>
<body>
<nav style="padding-top:20px">
    <ul class="menu">
      <li><h4>AVENGERS BTRS</h4></li>
      <li><a href="home">Home</a></li>
      <li><a href="dashboard">Dashboard</a></li>
      <li><a href="about">About Us</a></li>
      <li><a href="contact">Contact Us</a></li>
          <li class="logout-link">    
   <a href="#" id="logoutLink"><i class="fas fa-sign-out-alt"></i> Logout</a>
</li>
<!-- Modal Dialog -->
<div id="logoutModal" class="modal">
  <div class="modal-content">
    <h3>Are you sure you want to logout?</h3>
    <button id="logoutBtn">Logout</button>
    <button id="cancelBtn">Cancel</button>
  </div>
</div> 
    </ul>
  </nav>
  <div>
<footer class="footer">
  <p>
Copyright @ BTRS Ltd. All Right Reserved.</p>
</footer>
</div>
<script type="text/javascript">
//Get the logout link and modal dialog
const logoutLink = document.getElementById('logoutLink');
const logoutModal = document.getElementById('logoutModal');
// Get the logout button and cancel button inside the modal
const logoutBtn = document.getElementById('logoutBtn');
const cancelBtn = document.getElementById('cancelBtn');
// Show the modal dialog when logout link is clicked
logoutLink.addEventListener('click', function(event) {
  event.preventDefault(); // Prevents the default link behavior
  logoutModal.style.display = 'block';
});
// Logout button clicked
logoutBtn.addEventListener('click', function() {
  window.location.href = 'logout'; // Redirect to the logout page
});
// Cancel button clicked
cancelBtn.addEventListener('click', function() {
  logoutModal.style.display = 'none'; // Hide the modal dialog
});
</script>
</body>
</html>