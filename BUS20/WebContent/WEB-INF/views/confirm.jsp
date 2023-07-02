<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.avengers.bus.models.dtoModels.*" %>
<%@ page import="com.avengers.bus.models.inputModels.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket Confirmation</title>
     <link href="<c:url value="/resources/styles/confirm.css" />" rel="stylesheet"> 
</head>
<body>
    <div class="container">
        <h1>Ticket Confirmation</h1>
        <table>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>From Station</td>
                <td>${ticket.from}</td>
            </tr>
            <tr>
                <td>To Station</td>
                <td>${ticket.to}</td>
            </tr>
            <tr>
                <td>Service No</td>
                <td>${ticket.service_no}</td>
            </tr>
            <tr>
                <td>Ticket No</td>
                <td>${ticket.ticketNo}</td>
            </tr>
            <tr>
                <td>Payment Id</td>
                <td>${ticket.payment_id}</td>
            </tr>
            <tr>
                <td>Bus Type</td>
                <td>${ticket.bus_type}</td>
            </tr>
            <tr>
                <td>Date of Journey</td>
                <td>${ticket.journey_date}</td>
            </tr>
            <tr>
                <td>Departure Time</td>
                <td>${ticket.departure_time}</td>
            </tr>
                        <tr>
                <td>Arrival Time</td>
                <td>${ticket.arrival_time}</td>
            </tr>
            <tr>
                <td>Journey Duration</td>
                <td>${ticket.duration}</td>
            </tr>           
            <tr>
                <td>Number of Passengers</td>
                <td>${ticket.numberOfPassengers}</td>
            </tr>
        </table>
        <h2 class="total-fare">Total Fare: ${ticket.totalFare}</h2>      
        <h2>Passenger Details:</h2>
        <table class="passenger-table">
            <tr><th>Passenger ID</th> <th>Name</th><th>Age</th><th>Gender</th><th>Fare</th><th>Seat ID</th> </tr>
            <c:forEach var="passenger" items="${ticket.passengers}">
                <tr> <td>${passenger.passenger_id}</td><td>${passenger.passenger_name}</td> <td>${passenger.passenger_age}</td><td>${passenger.passenger_gender}</td> <td>${passenger.seat_fare}</td><td>${passenger.seat_id}</td></tr>
            </c:forEach>
        </table>
         <div class="print-button">
            <div class="centered">
                <button onclick="printTicket()" class="buttonStyle">Print Ticket</button>
                <form method="get" action="home">
                	<button type="submit" class="buttonStyle">GO HOME</button>               
                </form>
            </div>
    </div>
    <script>
        function printTicket() {
            window.print();
        }
    </script>
    
</body>
</html>
