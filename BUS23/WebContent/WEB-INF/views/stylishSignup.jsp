<title>Sign-Up</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign-UP</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

    <link href="<c:url value="/resources/styles/stylishSignup.css" />" rel="stylesheet">
 </head>
  <body>
    <div class="signup_form_container">
  <div class="signup_form">
    <h1>Sign Up</h1>
    <div class="container">
  	<div id="otp-block">
    <div class="form-container">
 <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="email"
            name="to"
            id="to"
            placeholder="Username/Email-Id"
            class="input_text"
            autocomplete="off"
            required
          />
        </div>
      <button type="button" id="sendEmailButton" class="confirmButton">Send Email</button>
    </div>
    <div id="otpContainer">
      <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="text"
            name="otp"
            id="otp"
            placeholder="Enter OTP"
            class="input_text"
            autocomplete="off"
            required
          />
        </div>
      <input type="button" id="otpButton" class="confirmButton" value="Confirm">
    </div>
    </div>
   <div id="signupContainer">
  <form id="myForm" action="registerUser" method="POST">
   <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="text"
            name="full_name"
            id="name"
            placeholder="Full Name"
            class="input_text"
            autocomplete="off"
            required
          />
        </div>
        
        <div  class="input_group">
            <input
            type="email"
            name="email"
            id="user-email"
            placeholder="Username/Email-Id"
            class="input_text"
            autocomplete="off"
            readonly
          />
        </div>
  
            <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="text"
            name="age"
            id="age"
            placeholder="Age"
            class="input_text"
            autocomplete="off"
            required
          />
        </div>
        <p></p>
			    <label for="gender">Gender:</label>
						    <select name="gender" id="gender" class="input-field" required>
						      <option value="Male">Male</option>
						      <option value="Female">Female</option>
						      <option value="Other">Other</option>
						    </select>
<div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password"
            name="password"
            placeholder="Password"
            class="input_text"
            autocomplete="off"
            id="password" 
            required
          />
        </div>
        
         <div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password"
            nme="pwd"
            placeholder="Confirm Password"
            class="input_text"
            autocomplete="off"
            id="confirmPassword"
            required
          />
        </div>	
				<input type="checkbox" id="togglePassword" onchange="togglePasswordVisibility()">
				<label for="togglePassword">Show Password</label>				
		<button type="submit" id="signupbtn" class="confirmButton" onclick="validatePassword()">Sign Up</button>
  </form>
</div>
</div>  </div> </div>
    <script src="<c:url value="/resources/scripts/stylishSignup.js" />"></script> 
  </body>
</html>