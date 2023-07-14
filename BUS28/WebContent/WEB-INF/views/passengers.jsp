<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.avengers.bus.models.entityModels.*" %>
<%@ page import="com.avengers.bus.models.dtoModels.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Passenger Management</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script src="<c:url value="/resources/scripts/passengers.js" />"></script> 
    <!-- Add Bootstrap CDN link here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-pzjw8f+ua6UY3Buvv+XX8mejph6vPJS5TO6E8hSW/qn2U2iKPXp8j2DqbvlVN7F2"
          crossorigin="anonymous">
   <link href="<c:url value="/resources/styles/passengers.css" />" rel="stylesheet">  
</head>
<body>
<div id="navbarLogin">
 <jsp:include page="navbarAfterLogin.jsp">
  <jsp:param name="currentPage" value="home" />
 </jsp:include>
</div>
<div id="body1">
<% int counter = (Integer) request.getAttribute("count");
    System.out.println(counter);
    String seatsData = (String) request.getAttribute("seatsData");
    System.out.println(seatsData);
    Gson gson = new Gson();
    Map<String, String> selectedSeatsData = gson.fromJson(seatsData, Map.class);
    int i = 1;%>
<div class="grid-container">
<div class="container">
    <h1 class="h1" >Passengers Details</h1>
    <form action="ticketPreview" method="POST">
        <div id="passenger-list">
            <% for (Map.Entry<String, String> entry : selectedSeatsData.entrySet()) {
                    String seatNumber = entry.getKey();
                    String genderStatus1 = entry.getValue();
                    String genderStatus = selectedSeatsData.getOrDefault(seatNumber, "Any");
                    System.out.println("The gender status in passengers.jsp is"+genderStatus);  %>
            <div class="passenger-container">
                <label>Passenger Id</label>
                <label>Seat Number</label>
                <input type="text" name="passenger_id" value="P<%= String.format("%03d", i) %>" required readonly>
                <input type="text" name="seat_number" value="<%= seatNumber %>" required readonly>
                <input type="text" name="passenger_name" placeholder="Passenger Name" required>
                <input type="text" name="passenger_age" placeholder="Passenger Age" required>
                <select name="passenger_gender" <%= genderStatus.equals("Female") ? "disabled" : "" %> required>
                    <option value="Male" <%= genderStatus.equals("Male") ? "selected" : "" %>>Male</option>
                    <option value="Female" <%= genderStatus.equals("Female") ? "selected" : "" %>>Female</option>
                    <option value="Other" <%= genderStatus.equals("Other") ? "selected" : "" %>>Other</option>
                </select>
                <input type="hidden" name="passenger_gender" value="<%= genderStatus %>"
                       <%= genderStatus.equals("Female") ? "" : "disabled" %>>
            </div><%i++;}%></div>
        <br> <% BusSearchListDto b=(BusSearchListDto) request.getAttribute("selectedBusDetails");
        System.out.println(b); %>
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
         <button type="submit" class="btn btn-primary" id="submitButton">Submit</button>
       </form>
    <p></p>
    <button onclick="goBackAndReload()" class="btn btn-secondary" id="backButton">Back</button>
</div>
<div class="table-container">
<h3>Previous passenger details</h3>
<table class="table table-striped" border='0'>
    <thead class="thead-dark">
    <tr><th>Name</th> <th>Age</th> <th>Gender</th><th>Action</th></tr></thead>
    <tbody>
    <%List<UserPassengers> userList = (List<UserPassengers>) request.getAttribute("userList");
        for (UserPassengers user : userList) {%>
    <tr><td><%= user.getPassenger_name() %></td><td><%= user.getAge() %></td><td><%= user.getGender() %></td><td>
            <div class="dropdown">
                <button class="dropbtn">Select Seat Number</button>
                <div class="dropdown-content">
                    <% for (Map.Entry<String, String> entry : selectedSeatsData.entrySet()) {
                       String seatNumber = entry.getKey();
                    %>
                    <a href="#" onclick='fillFormFields(this)'><%= seatNumber %></a>
                    <% } %>
                </div>
            </div>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</div>
</div>
<!-- Add Bootstrap JavaScript CDN link here -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-pzjw8f+ua6UY3Buvv+XX8mejph6vPJS5TO6E8hSW/qn2U2iKPXp8j2DqbvlVN7F2"
        crossorigin="anonymous"></script>
        <%BusSearchListDto bus=(BusSearchListDto) request.getAttribute("selectedBusDetails");
        		System.out.println("................\n"+bus);%>
</body>
</html>

