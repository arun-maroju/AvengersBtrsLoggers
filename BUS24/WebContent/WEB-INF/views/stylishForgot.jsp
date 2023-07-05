<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Forgot Password</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
 <link href="<c:url value="/resources/styles/stylishForgot.css" />" rel="stylesheet">
</head>
  <body>
    <div class="forgot_form_container">
    
      <div class="login_form">
        <h2>Send Email</h2>
        <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="email"
            name="to"
            id="to"
            placeholder="Username/Email-Id"
            class="input_text"
            autocomplete="off"
          />
        </div>
           <button type="submit" id="sendEmailButton">Send Email</button>
        
           <form action="validateOTP" method="post">
        
         <div id="otpContainer">
          <div class="input_group">
          <i class="fa fa-user"></i>
          
          <input type="hidden" name="email">
          <input
            type="text"
            name="otp"
            placeholder="Enter OTP"
            class="input_text"
            autocomplete="off"
          />
        </div>
  <div class="button_group">
          <button type="submit" id="otpButton">Confirm</button>
        </div>
       </div>
      </form>
      </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/scripts/stylishForgot.js" />"></script> 
</body>
</html>