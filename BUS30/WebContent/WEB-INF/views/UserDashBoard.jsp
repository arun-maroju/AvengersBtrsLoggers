<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
  <title>User Dashboard</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
   <link href="<c:url value="/resources/styles/userDashboard.css" />" rel="stylesheet">
   <script src="<c:url value="/resources/scripts/userDashboard.js" />"></script>
</head>
<body>
  <div class="sidebar">
  <div class="user-info">
    <img src="https://img.freepik.com/free-icon/user_318-159711.jpg" alt="User Icon">
    <li><a href="#" onclick="showUserDetails()">${userCounts.name}</a></li>
  </div>
  <ul>
    <li><a href="home"><i class="fas fa-ticket-alt"></i> Book Ticket</a></li>
    <li><a href="#" onclick="showDashboard()"><i class="fas fa-chart-bar"></i>  Dashboard</a></li>
    <li><a href="#" onclick="showPassengers()"><i class="fas fa-users"></i> Passengers</a></li>
    <li class="dropdown">
      <a href="#" onmouseover="showBookingOptions()"><i class="fas fa-history"></i> Booking History</a>
      <ul class="dropdown-menu">
        <li><a href="#" onclick="showPastBooking()">Past Bookings</a></li>
        <li><a href="#" onclick="showfutureBooking()">Future Bookings</a></li>
        <li><a href="#" onclick="showcancelledBooking()">Cancelled Bookings</a></li>
        <li><a href="#" onclick="showBooking()">All</a></li>
      </ul>
    </li>
    <li><a href="#" onclick="rating()"><i class="fas fa-star"></i> Rating</a></li>  
    <li class="logout-link">    
   <a href="#" id="logoutLink"><i class="fas fa-sign-out-alt"></i> Logout</a>
</li>
<!-- Modal Dialog -->
<div id="logoutModal" class="modal">
  <div class="modal-content">
    <h3>Are you sure you want to logout?</h3>
    <button id="logoutBtn">Logout</button>
    <button id="cancelBtn">Cancel</button>
  </div>
</div>    
  </ul>
</div>
 
  
   <!-- Buffering layer -->
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
 <div class="content" id="content">
    <!-- Your dashboard content goes here -->
    <div id="dashboardHeader" style="display: flex; justify-content: space-between; align-items: center;">
      <h1>Welcome to the Avengers BTRS User Dashboard</h1>
    </div>  
     <!-- Buffering layer -->
    <div class="overlay" id="buffering-layer">
        <div class="spinner"></div>
    </div>
    
<div class="dashboard2" id="dashboard2">
  <h2>Statistics</h2>
  <div class="dashboard" id="dashboard">
    <div class="stat">
      <div class="stat-item-wrapper">
        <div class="stat-item">
          <strong>No Of Times Travel:</strong>
          <h1></h1>
          <div class="stat-value" style="background-color: #f8f8f8;">${userCounts.travelCount}</div>
        </div>
      </div>
    </div>
    <div class="stat">
      <div class="stat-item-wrapper">
        <div class="stat-item">
          <strong>No Of Tickets Booked:</strong>
          <h1></h1>
          <div class="stat-value" style="background-color: #f8f8f8;">${userCounts.bookedCount}</div>
        </div>
      </div>
    </div>
    <div class="stat">
      <div class="stat-item-wrapper">
        <div class="stat-item">
          <strong>Wallet Amount:</strong>
          <h1></h1>
          <div class="stat-value" style="background-color: #f8f8f8;">${userCounts.wallet}</div>
        </div>
      </div>
    </div>
    
       <div class="stat">
      <div class="stat-item-wrapper">
        <div class="stat-item">
          <strong>Future Trips:</strong>
          <h1></h1>
          <div class="stat-value" style="background-color: #f8f8f8;">${userCounts.futureTravelCount}</div>
        </div>
      </div>
    </div>
    <!-- Add more <div> tags here as needed -->
  </div>
</div>
<div class="user-details" id="userDetails">
     <center><h2>Profile</h2> </center> 
      <form id="userForm">
  </form>
      <!-- User details will be loaded dynamically here -->
</div>   
    <div class="passenger-details" id="passengerDetails">
     <center>
	<table>
  	<thead>
    <tr><th>Passenger name</th> <th>Age</th><th>Gender</th><th>Delete</th></tr></thead>
  <tbody>    
    <!-- Add more rows as needed -->
  </tbody>
</table>
	</center>
    </div>   
<center>
<div id="editFormContainer">
    <h2 id="formTitle"> Add Passenger Details</h2>
    <form id="editForm">
        <div class="form-group">
            <label for="editUserId">User ID:</label>
            <input type="text" id="editUserId" name="userId" value=${userId} readonly>
        </div>
        <div class="form-group">
            <label for="editName">Name:</label>
            <input type="text" id="editName" name="name" required>
        </div>
        <div class="form-group">
            <label for="editAge">Age:</label>
            <input type="number" id="editAge" name="age" required>
        </div>
        <div class="form-group">
            <label for="editGender">Gender:</label>
            <select id="editGender" name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
        </div>
        <button type="submit" onclick="submitPassengerDetails()">Submit</button>
    </form>
</div>
 </center>
<div class="ticket-details" id="ticketDetails">
	<center>
	<table>
  	<thead>
    <tr> <th>Booking ID</th><th>Travel Date</th><th>Booking Date</th><th>Payment Mode</th> <th>Total Fare</th>  <th>Status</th> <th> No Of seats Booked </th><th></th> <th></th></tr>
  </thead>
  <tbody>
    <!-- Add more rows as needed -->
  </tbody>
</table>
	</center>
    </div>  
</div>
<script type="text/javascript">
//Get the logout link and modal dialog
const logoutLink = document.getElementById('logoutLink');
const logoutModal = document.getElementById('logoutModal');
// Get the logout button and cancel button inside the modal
const logoutBtn = document.getElementById('logoutBtn');
const cancelBtn = document.getElementById('cancelBtn');
// Show the modal dialog when logout link is clicked
logoutLink.addEventListener('click', function(event) {
  event.preventDefault(); // Prevents the default link behavior
  logoutModal.style.display = 'block';
});
// Logout button clicked
logoutBtn.addEventListener('click', function() {
  window.location.href = 'logout'; // Redirect to the logout page
});
// Cancel button clicked
cancelBtn.addEventListener('click', function() {
  logoutModal.style.display = 'none'; // Hide the modal dialog
});
</script>


</body>
</html>