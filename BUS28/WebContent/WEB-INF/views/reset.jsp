<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>BTRS Login From</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
 <link href="<c:url value="/resources/styles/reset.css" />" rel="stylesheet"> 
  </head>
  <body>
    <div class="login_form_container">   
    <form id="myForm" action="reset" method="post">
      <div class="login_form">
        <h2>Reset Password</h2>
         <input type="hidden" name="email" value="<%= (String) request.getAttribute("email") %>">     
        <div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password" name="password" id="password"  placeholder="Password"  class="input_text"  autocomplete="off"
          />
        </div>
         <div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password" name="confirmPassword"  id="confirmPassword" placeholder="Confirm Password" class="input_text"  autocomplete="off"
          />
        </div>
        <div class="button_group" id="login_button">
          <button type="submit">Reset</button>
        </div>           
        </div>
      </form>
    </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="<c:url value="/resources/scripts/reset.js" />"></script> 
  </body>
</html>