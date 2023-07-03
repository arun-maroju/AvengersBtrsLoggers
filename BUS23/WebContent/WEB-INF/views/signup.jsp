<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <link href="<c:url value="/resources/styles/signup.css" />" rel="stylesheet">
</head>
<body>
  <div class="container">
  	<div id="otp-block">
    <h1>Sign Up</h1>
    <div class="form-container">
      <label for="to">Email:</label>
      <input type="email" name="to" id="to" class="input-field">
      <button type="button" id="sendEmailButton" class="confirmButton">Send Email</button>
    </div>
    <div id="otpContainer">
      <label for="otp">OTP:</label>
      <input type="text" name="otp" id="otp" class="input-field">
      <input type="button" id="otpButton" class="confirmButton" value="Confirm">
    </div>
    </div>
   <div id="signupContainer">
  <form id="myForm" action="registerUser" method="POST">
  
			    <label for="name">Full Name:</label>
			  			  <input type="text" name="full_name" id="name" class="input-field" required>
			    <label for="email">Email-Id:</label>
			   				 <input type="email" name="email" id="user-email" class="input-field" readonly>
			    
			    <label for="age">Age:</label>
			    			<input type="number" name="age" id="age" class="input-field" required>
			    <label for="gender">Gender:</label>
						    <select name="gender" id="gender" class="input-field" required>
						      <option value="Male">Male</option>
						      <option value="Female">Female</option>
						      <option value="Other">Other</option>
						    </select>
				<label for="password">Password:</label>
						<input type="password" id="password" name="password" class="input-field" required>
				
				<label for="confirmPassword">Confirm Password:</label>
						<input type="password" id="confirmPassword" class="input-field" required>
				
						<input type="checkbox" id="togglePassword" onchange="togglePasswordVisibility()">
				<label for="togglePassword">Show Password</label>
				
		<button type="submit" id="signupbtn" class="confirmButton" onclick="validatePassword()">Sign Up</button>
  </form>
</div>
  </div>
 <script src="<c:url value="/resources/scripts/signup.js" />"></script> 
</body>
</html>
