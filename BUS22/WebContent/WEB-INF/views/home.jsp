<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.avengers.bus.models.entityModels.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Booking System</title>
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Font Awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
 <link href="<c:url value="/resources/styles/home.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/scripts/home.js" />"></script> 
<style>
#homeBody {
  background-color: white;}
  <%if(session.getAttribute("userId")!=null)   { %>
  body {background-color: white;margin-top: -20px; margin-left: -10px;}
  #navbarLogin {padding-top:20px;margin: 0;width: 1431px;}
<%} else{%> <%}%>
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>  
</head>


 <%  if(session.getAttribute("userId")!=null)  { %>
<jsp:include page="navbarAfterLogin.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<% }
 else{      	       
%>

<jsp:include page="navbar.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>

<%} %>

<body id="homeBody">
<div class="container" id="me">
  <form method="POST" action="getBusList">
    <div class="form-group">
      <div class="row">
        <div class="col">
          <label for="fssId"><i class="fas fa-map-marker-alt"></i> From:</label>
          <select id="fssId" name="fssId" class="form-control" required>
            <option value="" disabled selected hidden>Source</option>
            <% List<Stations> slist=(List<Stations>)request.getAttribute("stationList");
              for(Stations s:slist){ %>
              <option value="<%= s.getStop_id() %>"><%= s.getStop_name()%></option>
            <% } %>
          </select>
        </div>
        
		 <div class="col1" id="swap-button">
         <button id="swapBtn" type="button" class="btn btn-secondary smaller-btn"><i class="fas fa-exchange-alt"></i></button>
       	 </div>
       	 
        <div class="col">
          <label for="tssId"><i class="fas fa-map-marker-alt"></i> To:</label>
          <select id="tssId" name="tssId" class="form-control" required>
            <option value="" disabled selected hidden>Destination</option>
            <% for(Stations s:slist){ %>
              <option value="<%= s.getStop_id() %>"><%= s.getStop_name()%></option>
            <% } %>
          </select>
        </div>	   
      </div>
    </div>

    <div class="form-group">
      <div class="row">
        <div class="col">
          <label for="travelClass"><i class="fas fa-graduation-cap"></i> Type:</label>
          <select id="travelClass" name="travelClass" class="form-control" required>
            <option value="-1">Any</option>
            <% List<BusTypes> btlist=(List<BusTypes>)request.getAttribute("busTypeList");
              for(BusTypes bt:btlist){ %>
              <option value="<%= bt.getBsty_id() %>"><%= bt.getBsty_title() %></option>
            <% } %>
          </select>
        </div>
             
        <div class="col">
          <label for="datePicker"><i class="fas fa-calendar-alt"></i> Travel Date:</label>
          <input type="date" id="datePicker" name="date" class="form-control" required>
        </div>
      </div>
    </div>

    <div class="form-group">
      <div class="button-group">
<!-- id="searchBuses" -->        <button  type="submit" class="btn btn-primary">Search Buses</button>
      </div>
    </div>
  </form>
</div>

</div>
<script>
  // Set the minimum and maximum dates for the date picker
var today = new Date();
var nextMonth = new Date();
nextMonth.setMonth(nextMonth.getMonth() + 1);
var datePicker = document.getElementById('datePicker');
datePicker.min = today.toISOString().split('T')[0];
datePicker.max = nextMonth.toISOString().split('T')[0];
</script>
</body>
</html>