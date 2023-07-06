<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket Preview</title>
 	<link href="<c:url value="/resources/styles/ticketPreview.css" />" rel="stylesheet">    
    <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
	<script src="<c:url value="/resources/scripts/ticketPreview.js" />"></script> 
</head>
<body id="preview-body">
<div id="navbarLogin"><jsp:include page="navbarAfterLogin.jsp"><jsp:param name="currentPage" value="home" /></jsp:include></div>
    <div class="preview-container">
        <h1>Ticket Preview</h1>
        <div class="container">
            <div class="left">
                <div class="ticket-details">
                    <h2>From Station&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;${ticket.from}</h2>
                    <h2>Departure Time&nbsp;:&nbsp; ${ticket.departure_time}</h2>
                    <h2>Route No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp; ${ticket.trip_no}</h2>
                    <h2>Bus Type&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp; ${ticket.bus_type}</h2>                   
                </div>
            </div>
            <div class="right">
                <div class="ticket-details">
                    <h2>To Station&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${ticket.to}</h2>
                    <h2>Arrival Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : ${ticket.arrival_time}</h2>
                    <h2>Date of Journey&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${ticket.journey_date}</h2>
                    <h2>Number of Passengers&nbsp;: ${ticket.numberOfPassengers}</h2>
                </div>
            </div>
        </div>      
        <div class="passenger-details">
            <h2>Passenger Details:</h2>
            <table>
                <tr><th>Passenger ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Seat ID</th><th>Fare</th></tr>
                <c:forEach var="passenger" items="${ticket.passengers}">
                    <tr><td>${passenger.passenger_id}</td><td>${passenger.passenger_name}</td><td>${passenger.passenger_age}</td><td>${passenger.passenger_gender}</td><td>${passenger.seat_id}</td><td>${passenger.seat_fare}</td></tr>
                </c:forEach>
            </table>
            <h2>Total Fare: ${ticket.totalFare}</h2>          
            <div class="payment-form">
                <form action="makePayment" method="get">
                <input type="hidden" id="service_no" name="service_no" value=${ticket.service_no}>
                    <br><br>
                    <input type="hidden" id="ticketNumber" name="ticketNumber" value=${ticket.ticketNo}>
                    <br><br>
                    <input type="hidden" id="amount" name="amount" value=${ticket.totalFare}>
                    <br><br>
                    
                     <c:forEach var="passenger" items="${ticket.passengers}">
                    <input type="hidden" name="seat" value="${passenger.seat_id}">
              	    </c:forEach>
                
                
                    <input type="submit" value="Make Payment" class="payment-button">
                </form>
            </div>
        </div>
    </div>
    <%int userid=(Integer)session.getAttribute("userId");%>
    <input type='hidden' id='uid' value=<%=userid %>>
</body>
</html>
