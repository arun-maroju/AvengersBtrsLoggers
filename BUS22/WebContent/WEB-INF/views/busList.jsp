<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.avengers.bus.models.dtoModels.*,java.util.*, java.time.LocalTime, java.time.Duration" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bus List Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/css/bootstrap.min.css">
     <link href="<c:url value="/resources/styles/busList.css" />" rel="stylesheet">
 <style>
        body {
            background-color: #fff;
        }  
         <% if(session.getAttribute("userId")!=null) {  %>
  body
  {
    background-color: white;
    margin-top: -20px;
    margin-left: -10px;
  }
#navbarLogin {
  padding-top:20px;
  margin: 0;
  width: 1431px;
}
<% } else{    %>

<%}%>
    </style>
</head>
 <% if(session.getAttribute("userId")!=null)   {%>
<jsp:include page="navbarAfterLogin.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<%} else{      %>
<jsp:include page="navbar.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<%} %>
<body> <div class="container">
        <h1 class="text-center mb-4" style="color:black">Available Services</h1>
        <% 
        List<BusSearchListDto> buses = (List<BusSearchListDto>) request.getAttribute("buses");
        for (BusSearchListDto b : buses) {
            %>  
            <form method="POST" action="layout">
            <div class="bus-block">
                <h4 class="bus-title"><span class="bold red"><%= b.getTrip_id()+""+b.getService_id() %></span></h4>
                <div class="bus-details">
                	<div>
                    <p><span class="label">Type:</span> <span class="time black"><%= b.getBsty_title() %></span></p>
                     
                    </div>
                     <div>
                        <p><span class="label ">Source:</span> <span class="time green"><%= b.getSource() %></span></p>
                        <p><span class="label ">Destination :</span> <span class="time green"><%= b.getDestination() %></span></p>
                    </div>
                    <div>
                        <p><span class="label">Departure:</span> <span class="time green"><%= b.getDepature() %></span></p>          
                        <p><span class="label">Arrival:</span> <span class="time green"><%= b.getArrival() %></span></p>
                        <span class="label ">Travel Time:</span> <span class="time red"><%= b.getDuration() %></span>
                        
                    </div>
                    <div>
                        <p><span class="label date">Date:</span> <span class="time green"><%= b.getTrip_date() %></span></p>
                        <p><span class="label ">Available Seats:</span> <span class="time green"><%= b.getAvailable_seats() %></span></p>
                    </div>
                    <div>
                        <p><span class="label date">Seat Fare:</span> <span class="time green"><%= b.getSeat_fare() %></span></p>
                        <p><span class="label ">Berth Fare:</span> <span class="time green"><%= b.getBerth_fare() %></span></p>
                    </div>          
                </div>                             
              <input type="hidden" name="service_id" value="<%= b.getService_id() %>">                
                 <input type="hidden" name="trip_id" value="<%= b.getTrip_id() %>">
                 <input type="hidden" name="source" value="<%= b.getSource() %>">
                 <input type="hidden" name="destination" value="<%= b.getDestination() %>">
                 <input type="hidden" name="trip_date" value="<%= b.getTrip_date() %>">
                <input type="hidden" name="arrival" value="<%= b.getArrival() %>">
                   <input type="hidden" name="depature" value="<%= b.getDepature() %>">                 
                 <input type="hidden" name="bsty_title" value="<%= b.getBsty_title()%>">
                 <input type="hidden" name="available_seats" value="<%= b.getAvailable_seats() %>">
				<input type="hidden" name="seat_fare" value="<%= b.getSeat_fare()%>">
                 <input type="hidden" name="berth_fare" value="<%= b.getBerth_fare() %>">       
                <button type="submit" value="show" class="btn btn-primary btn-book">View Seats</button>
            </div>
            </form>
            <% 
        } 
        %>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>