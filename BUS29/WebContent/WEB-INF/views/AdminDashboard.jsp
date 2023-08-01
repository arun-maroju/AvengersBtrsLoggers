<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
</head>
<body>
 <nav>
    <ul class="menu">
      <li><h4>AVENGERS BTRS</h4></li>
      <li><a href="#" onclick="showDashboard()">Dashboard</a></li>
      <li><a href="#" onclick="showRoutes()">Routes</a></li>
      <li><a href="#" onclick="pagiNation(${counts.serviceCount})">Services</a></li>
      <li><a href="#" onclick="showTickets()">Tickets</a></li>
      <li><a href="#" onclick="showPayments()">Payments</a></li>
      <li><a href="#" onclick="showRefunds()">Refunds</a></li>
      <li><a href="logout" id="logoutLink">Logout</a></li>

<!-- Modal Dialog -->
<div id="logoutModal" class="modal">
  <div class="modal-content">
    <h3>Are you sure you want to logout?</h3>
    <button id="logoutBtn">Logout</button>
    <button id="cancelBtn">Cancel</button>
  </div>
</div>
   </ul>
  </nav>
  <div>
 <div style="display: flex; justify-content: space-between; align-items: center;">
         </div>
         
              <div class="dashboard2" id="dashboard2">
                <h1>Welcome to the Avengers BTRS Admin Dashboard</h1>
                    <h2>Statistics</h2>
                    <div class="dashboard" id="dashboard">
                        <div class="stat-box route-count">
                            <p><strong>Number of Routes:</strong><br>${counts.routeCount}</p>
                        </div>
                        <div class="stat-box trip-count">
                            <p><strong>Number of Trips:</strong><br>${counts.tripCount}</p>
                        </div>
                        <div class="stat-box service-count">
                            <p><strong>Number of Services:</strong><br>${counts.serviceCount}</p>
                        </div>
                        <div class="stat-box bus-count">
                            <p><strong>Number of Buses:</strong><br>${counts.busCount}</p>
                        </div>
                        <div class="stat-box user-count">
                            <p><strong>Number of Users:</strong><br>${counts.userCount}</p>
                        </div>
                        <div class="stat-box collection">
                            <p><strong>Collection:</strong><br>${counts.collection}</p>
                        </div>
                        <div class="stat-box past-ticket-collection">
                            <p><strong>Collection from Past Tickets:</strong><br>${counts.pastTicketCollection}</p>
                        </div>
                        <div class="stat-box future-ticket-collection">
                            <p><strong>Collection from Future Tickets:</strong><br>${counts.futureTicketCollection}</p>
                        </div>
                    </div>
                    <canvas id="routeCollectionChart"></canvas>
                    <canvas id="tripCollectionChart"></canvas>
                     <canvas id="monthlyCollectionChart"></canvas>
                </div>
                
            </div>
        </div>
    </div>
    <div class="loader-wrapper" id="spinner">
<div class="truck-wrapper">
  <div class="truck">
    <div class="truck-container"></div>
    <div class="glases"></div>
    <div class="bonet"></div>

    <div class="base"></div>

    <div class="base-aux"></div>
    <div class="wheel-back"></div>
    <div class="wheel-front"></div>

    <div class="smoke"></div>
  </div>
</div>
</div>
     <div id="serviceList">
    <center><h2>Services</h2></center>
     <div class="filter-container">
  <div class="filter-item">
    <label for="datefilter" class="label-date">Select Date:</label>
<input type="text" name="datefilter" value="" />
  </div>
  
 <div class="navbar-service">
    <label for="serviceid" class="navbar-service-label">Select Service ID:</label>
    <select id="serviceidFilter" class="navbar-service-select">
      <option value="">Select</option>
      <!-- JavaScript code will populate options here -->
    </select>
  </div>
</div>
	<center>
	<table>
  <thead>
    <tr>
      <th>Service ID</th><th>Trip ID</th><th>Trip Date</th><th>Seats Available</th><th>Collection</th> <th>       </th><th>       </th>
    </tr>
  </thead>
  <tbody>
     
    <!-- Add more rows as needed -->
  </tbody>
</table>

<div id="pageNumbers">

</div>


<div>
<table>
  
    <tr>
      <th>     </th><th>     </th><th>     </th><th>    </th><th>    </th> <th>       </th><th>       </th>
    </tr>
    
  
  
     <tr>
      <td>     </td><td>     </th><td>     </th><td>    </th><td>    </td> <td>       </td><td>       </td>
    </tr>
    <tr>
      <td>     </td><td>     </th><td>     </th><td>    </th><td>    </td> <td>       </td><td>       </td>
    </tr>
    <tr>
      <td>     </td><td>     </th><td>     </th><td>    </th><td>    </td> <td>       </td><td>       </td>
    </tr>
    <!-- Add more rows as needed -->
  
</table>
</div>
	</center>
    </div>
    <div id="routeList">
    <center><h2>Routes</h2></center>
    <div class="add">
  <div class="addRouteButton">
    
<input type="button" id="addRoute" value="Add New Route" onclick='addRoute()'/>

  </div>
  
</div>
<br>
	<center>
	<table>
  <thead>
    <tr>
      <th>Route ID</th><th>Source</th> <th>Destination</th> <th>Status</th> <th>Details</th> <th>Deactivate</th><th>Activate</th>   
    </tr>
  </thead>
  <tbody>
    <!-- Add more rows as needed -->
  </tbody>
</table>
	</center>
    </div>
    <div id="busList">
    <h2>Buses</h2>
        <center>
	<table>
  <thead>
    <tr>
      <th>Bus ID</th><th>Registration Number</th><th>Bus Type Id</th><th>No of Seats</th><th>Status</th> </tr>
  </thead>
  <tbody>    
    <!-- Add more rows as needed -->
  </tbody>
</table>
	</center>
    </div> 
    <div id="ticketList">
     <center><h2>Ticket List</h2></center>
          <div class="filter-container">
  <div class="filter-item">
    <label for="ticketDatefilter" class="label-date">Select Date:</label>
<input type="text" name="ticketDatefilter" value="" />
  </div>
 <div class="navbar-service">
    <label for="ticketServiceidFilter" class="navbar-service-label">Select Service ID:</label>
    <select id="ticketServiceidFilter" class="navbar-service-select">
      <option value="">Select</option>
      <!-- JavaScript code will populate options here -->
    </select>
  </div>
</div>
 <center>
	<table>
  <thead>
    <tr>
      <th>Ticket ID</th>
      <th>Payment ID</th>
      <th>User Id</th>
      <th>Travel Date</th>
      <th>Departure</th>
      <th>Route Id</th>
      <th>Trip ID</th>
      <th>Service ID</th>
      <th>Payment Mode</th>
      <th>Total Fare</th>
      <th>Status</th>
      <th>No of Seats Booked</th>
      <th>          </th>
 </tr>
  </thead>
  <tbody>
     
    <!-- Add more rows as needed -->
  </tbody>
</table>
	
	</center>
    </div>
    <div id="paymentList">
    <center><h2>Payments</h2></center>
     <div class="filter-container">
  <div class="filter-item">
    <label for="paymentDatefilter" class="label-date">Select Date:</label>
<input type="text" name="paymentDatefilter" value="" />
  </div>
  <div class="navbar-service">
    <label for="ticketAmountFilter" class="navbar-service-label">Select Amount:</label>
    <select id="ticketAmountFilter" class="navbar-service-select">
      <option value="">Any</option>
      <option value="500">Upto 500</option>
      <option value="1000">Upto 1000</option>
      <option value="1500">Upto 1500</option>
      <option value="2000">Upto 2000</option>
      <option value="5000">Upto 5000</option>
      <option value="10000">Upto 10000</option>
      <option value="15000">Upto 15000</option>
      <option value="20000">Upto 20000</option>
      <option value="25000">Upto 25000</option>
      <!-- JavaScript code will populate options here -->
    </select>
  </div>
</div>
<center>
	<table>
  <thead>
    <tr>
      <th>Ticket ID</th>
      <th>Payment ID</th>
      <th>Order ID</th>
      <th>User Id</th>
      <th>Payment Date</th>
      <th>Payment Time</th>
      <th>Payment Mode</th>
      <th>Total Fare</th>
     <!--  <th>          </th> -->
    </tr>
  </thead>
  <tbody> 
    <!-- Add more rows as needed -->
  </tbody>
</table>
	</center>
    </div>
    <div id="refundList">
    <center><h2>Refunds</h2></center>
     <div class="filter-container">
  <div class="filter-item">
    <label for="paymentDatefilter" class="label-date">Select Date:</label>
<input type="text" name="paymentDatefilter" value="" />
  </div>
  <div class="navbar-service">
    <label for="ticketAmountFilter" class="navbar-service-label">Select Amount:</label>
    <select id="ticketAmountFilter" class="navbar-service-select">
      <option value="">Any</option>
      <option value="500">Upto 500</option>
      <option value="1000">Upto 1000</option>
      <option value="1500">Upto 1500</option>
      <option value="2000">Upto 2000</option>
      <option value="5000">Upto 5000</option>
      <option value="10000">Upto 10000</option>
      <option value="15000">Upto 15000</option>
      <option value="20000">Upto 20000</option>
      <option value="25000">Upto 25000</option>
      <!-- JavaScript code will populate options here -->
    </select>
  </div>
</div>
<center>
	<table>
  <thead>
    <tr>
      <th>Ticket ID</th>
      <th>Refund ID</th>
      <th>Payment ID</th>
      <th>Order ID</th>
      <th>User Id</th>
      <th>Payment Date</th>
      <th>Payment Time</th>
      <th>Payment Mode</th>
      <th>Total Fare</th>
     <!--  <th>          </th> -->
    </tr>
  </thead>
  <tbody> 
    <!-- Add more rows as needed -->
  </tbody>
</table>
	</center>
    </div>
   <div id="popupContent" style="display: none;">
    <table>
        <tr>
            <td>Service ID:</td>
            <td id="serviceId"></td>
        </tr>
        <tr>
            <td>Source:</td>
            <td id="source"></td>
        </tr>
        <tr>
            <td>Destination:</td>
            <td id="destination"></td>
        </tr>
        <tr>
            <td>Departure:</td>
            <td id="departure"></td>
        </tr>
        <tr>
            <td>Arrival:</td>
            <td id="arrival"></td>
        </tr>
        <tr>
            <td>Trip Date:</td>
            <td id="tripDate"></td>
        </tr>
        <tr>
            <td>Bus Type:</td>
            <td id="busType"></td>
        </tr>
        <tr>
            <td>Route ID:</td>
            <td id="routeId"></td>
        </tr>
        <tr>
            <td>Collection:</td>
            <td id="collection"></td>
        </tr>
        <tr>
            <td>Seats Available:</td>
            <td id="seatsAvailable"></td>
        </tr>
        <tr>
            <td>Seats Booked:</td>
            <td id="seatsBooked"></td>
        </tr>
        <tr>
            <td>Bus Type Title:</td>
            <td id="busTypeTitle"></td>
        </tr>
        <tr>
            <td>Bus Type Description:</td>
            <td id="busTypeDescription"></td>
        </tr>
    </table>
</div>
<div id="servicePassengerPopupContent" style="display: none;">
    <p>Service ID: <span id="passengerServiceId"><input type='textbox' id='sid' disabled></span></p>         
     <table>
  <thead>
    <tr>
      <th>Booking Id</th><th>Seat No</th><th>Name</th><th>Age</th><th>Gender</th>
    </tr>
  </thead>
  <tbody id="servicePassengerTable">    
    <!-- Add more rows as needed -->
  </tbody>
</table>   
</div>



<div id="routePopupContent" style="display: none;">
    <table>
        <tr>
            <td>Route ID:</td>
            <td id="routeNumber"></td>
        </tr>
        <tr>
            <td>Source:</td>
            <td id="routeSource"></td>
        </tr>
        <tr>
            <td>Destination:</td>
            <td id="routeDestination"></td>
        </tr>      
    </table>
</div>

<div class="overlay2"></div>
<div id="addRoutePopup" style="display: none;" class='popup2'>
<h2>Add Route</h2>
<form id="routeForm">
    <table>
        <tr>
            <td>Route ID:</td>
            <td><input type='textbox' id="routeNumberInput"></td>
        </tr>
        <tr>
            <td>Source:</td>
            <td><input type='textbox' id="routeSourceInput"></td>
        </tr>
        <tr>
            <td>Destination:</td>
            <td><input type='textbox' id="routeDestinationInput"></td>
        </tr>      
    </table>
    </form>
    <br>
    <center>
    <button id="addRouteAjax" onclick='persistRoute()'>Add</button>
    <button id="cancelAddRoute" onclick='cancelAddRoute()'>Cancel</button>
    </center>
</div>





<div id="activateNewRoute" style="display: none;" class='popup3'>
    <h2>Activate New Route</h2>
    <table>
    <tr>
    <td><label>Route Id</label></td>
    <td><input id='popRouteId' disabled></td>
    </tr>
    <tr>
    <td><label>Source</label></td>
    <td><input id='popSource' disabled></td>
    </tr><tr>
    <td><label>Destination</label></td>
    <td><input id='popDestination' disabled></td>
    </tr>
    </table>
    <form id="routeForm">
      <table>
        <thead>
          <tr>
            <th>No</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Departure</th>
            <th>Arrival</th>
            <th>Bus Type</th>
            <th>Inter Stops</th>
            <th>Route_id</th>
          </tr>
        </thead>
        <tbody id="routeTableBody">
          <tr>
            <td>1</td>
            <td><input type='text' id='source1' disabled style='width: 80px;'></td>
            <td><input type='text' id='destination1' disabled style='width: 80px;'></td>
            <td><input type='text' id='departure1' style='width: 80px;'></td>
            <td><input type='text' id='arrival1' style='width: 80px;'></td>
            <td><input type='text' id='bus_type1' style='width: 80px;'></td>
            <td><input type='number' id='inter_stops1' style='width: 80px;'></td>
            <td><input type='number' id='tableRoute_id' disabled style='width: 80px;'></td>
          </tr>
        </tbody>
      </table>
    </form>
    <br>
    <center>
      <button id='addTrip' onclick='addRow()'>Add Trip</button>
      <button id='removeTrip' disabled onclick='removeRow()'>Remove Trip</button>
      <br>
      <button id='addInterStops' onclick='addInterStops()'>Add Intermediate Stops</button>
      <br>
      <button id='cancelInterStops' onclick='cancelInterStops()'>Cancel</button>
    </center>
  </div>

<div id="interStops" style="display: none;" class='popup4'>
  <h2>Activate New Route</h2>
  <form id="interStopForm">
    <table>
      <thead>
        <tr>
          <th>Trip No</th>
          <th>Stop</th>
          <th>Stop Index</th>
          <th>Stop Time</th>
        </tr>
      </thead>
      <tbody id="interStopTableBody"></tbody>
    </table>
  </form>
  <br>
  <center>
    <button id='confirmTrips' onclick='confirmTrips()'>Activate Route</button>
    <br>
    <br>
    <button id='cancelConfirmTrips' onclick='cancelConfirmTrips()'>Cancel</button>
  </center>
</div>



<div>
<footer class="footer">
  <p>
Copyright @ BTRS Ltd. All Right Reserved.</p>
</footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
 <link href="<c:url value="/resources/styles/adminDashboard.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/scripts/adminDashboard.js" />"></script> 
</body>
</html>
