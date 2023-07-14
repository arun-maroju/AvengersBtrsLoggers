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
     <link href="<c:url value="/resources/styles/stylishLogin.css" />" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>  
 <script src="<c:url value="/resources/scripts/stylishLogin.js" />"></script>  
  </head>
  <body>
    <div class="login_form_container">
    <form action="login" method="post">
      <div class="login_form">
        <h2>Login</h2>
        <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="email"
            name="username"
            id="username"
            placeholder="Username/EmailId"
            class="input_text"
            autocomplete="off"
          />
        </div>
        <div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password"
            name="password"
            placeholder="Password"
            class="input_text"
            autocomplete="off"
          />
        </div>
        <div class="button_group" id="login_button">
          <button type="submit">Submit</button>
        </div>
           <div class="error-message">
                <%-- Display login error message here --%>
                ${errorMessage}
            </div>
        <div class="fotter">
          <a id="btn">Forgot Password ?</a>
          <a id="btn1">SignUp</a>
        </div>
  <div class="fotter">
          <a id="btn2">Go Home -></a>
        	</div>   
      </div>
      </form>
    </div>
  </body>
</html>