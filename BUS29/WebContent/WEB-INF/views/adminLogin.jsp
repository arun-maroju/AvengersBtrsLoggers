<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Login</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
 <link href="<c:url value="/resources/styles/adminLogin.css" />" rel="stylesheet">
  </head>
  <body>
    <div class="login_form_container">   
    <form action="adminLogin" method="POST">    
    	      <div class="login_form">
        <h2>Admin Login</h2>
        <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="text"
            placeholder="Admin-Id"
            class="input_text"
            autocomplete="off"
            name="user_name"
            id="user_name"
          />
        </div>
        <div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password"
            placeholder="Password"
            class="input_text"
            autocomplete="off"
            name="password"
            id="password"
          />
        </div>
        <div class="button_group" id="login_button">
          <button  type="submit">Submit </button> 
        </div>
         <div class="error-message">
                <%-- Display login error message here --%>
                ${errorMessage}
            </div>     
                <div class="fotter">
          <a id="btn2">Go Home -></a>

        	</div>
      </div>
    </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
    $(document).ready(function() {
        $('#btn2').click(function() {
          window.location.href = 'home';
        });
      });
</script>

  </body>
</html>