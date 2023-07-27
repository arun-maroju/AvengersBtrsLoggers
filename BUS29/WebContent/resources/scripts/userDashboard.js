   // Show buffering layer
document.getElementById('spinner').style.display = 'none';
        function showBufferingLayer() {
            document.getElementById('spinner').style.display = 'flex';
        }

        // Hide buffering layer
        function hideBufferingLayer() {
            document.getElementById('spinner').style.display = 'none';
        } 
  
  function showDashboard() {
        var dashboardHeader = document.querySelector("#dashboardHeader h1");
            dashboardHeader.textContent = "Welcome to the Avengers BTRS User Dashboard";
      document.getElementById("dashboard2").style.display = "grid";
      document.getElementById("userDetails").style.display = "none";
      document.getElementById("ticketDetails").style.display = "none";
      document.getElementById("passengerDetails").style.display = "none";
      document.getElementById("editFormContainer").style.display = "none";
            hideBufferingLayer();
    
  } 
 
 
  function showUserDetails() {
	  	  showBufferingLayer(); // Show the spinner before form submission
	  $.ajax({
	    url: "UserList", // Replace with the actual URL of your service
	    method: "GET",
	    success: function(response) {
	      var users = JSON.parse(response);
	      var table = document.createElement("table");
	      table.style.width = "400px";
	      var form = document.getElementById("userForm");
	      form.innerHTML = ""; // Clear existing form fields

	      // Iterate over the users and populate the form
	      for (var i = 0; i < users.length; i++) {
	        var user = users[i];
	        var row = document.createElement("tr");

	        // Create label cell
	        var labelCell = document.createElement("td");
	        labelCell.textContent = "User ID:";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        // Create input cell for User ID
	        var inputCell = document.createElement("td");
	        var input = document.createElement("input");
	        input.type = "int";
	        input.value = user.user_id;
	        input.disabled = true; // Disable input field
	        input.name = "userId";
	        input.id = "userId";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Create rows and cells for other fields

	        // User Email
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "User Email:";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "email";
	        input.value = user.email;
	        input.disabled = true;
	        input.name = "userEmail";
	        input.id = "userEmail";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Password
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "Password:";
	        labelCell.style.fontWeight = "bold";
	        labelCell.style.display = "none";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "password";
	        input.value = user.password;
	        input.disabled = true;
	        input.name = "password";
	        input.id = "password";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        inputCell.style.display = "none";
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Full Name
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "User Name:";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "text";
	        input.value = user.full_name;
	        input.disabled = true;
	        input.name = "userName";
	        input.id = "userName";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Age
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "Age:";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "int";
	        input.value = user.age;
	        input.disabled = true;
	        input.name = "age";
	        input.id = "age";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Gender
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "Gender:";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "text";
	        input.value = user.gender;
	        input.disabled = true;
	        input.name = "gender";
	        input.id = "gender";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Cashback
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "Cashback:";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "double";
	        input.value = user.cashback;
	        input.disabled = true;
	        input.name = "cashback";
	        input.id = "cashback";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Wallet
	        row = document.createElement("tr");
	        labelCell = document.createElement("td");
	        labelCell.textContent = "Wallet:";
	        labelCell.style.display = "none";
	        labelCell.style.fontWeight = "bold";
	        row.appendChild(labelCell);

	        inputCell = document.createElement("td");
	        input = document.createElement("input");
	        input.type = "double";
	        input.value = user.wallet;
	        input.disabled = true;
	        input.name = "wallet";
	        input.id = "wallet";
	        input.style.width = "200px";
	        inputCell.appendChild(input);
	        inputCell.style.display = "none";
	        row.appendChild(inputCell);
	        table.appendChild(row);

	        // Edit and Save buttons
	        row = document.createElement("tr");
	        var buttonCell = document.createElement("td");
	        buttonCell.colSpan = 2;

	        // Create Edit button
	        var editButton = document.createElement("button");
	        editButton.textContent = "Edit";
	        editButton.id = "editButton";
	        editButton.addEventListener("click", function() {
	          enableEdit(form, user.user_id);
	        });
	        buttonCell.appendChild(editButton);
	        buttonCell.appendChild(document.createTextNode("    "));

	        // Create Save button
	        var saveButton = document.createElement("input");
	        saveButton.type = "submit";
	        saveButton.value = "Save";
	        saveButton.id = "saveButton";
	        saveButton.disabled = true;
	        saveButton.addEventListener("click", function() {
	          savedata(form, user.user_id);
	        });
	        buttonCell.appendChild(saveButton);

	        row.appendChild(buttonCell);
	        table.appendChild(row);
	      }

	      form.appendChild(table);
	      hideBufferingLayer();
	    },
	    error: function(xhr, status, error) {
	      console.error("AJAX request failed: " + status + ", " + error);
	      hideBufferingLayer();
	    }
	  });

	  document.getElementById("dashboard2").style.display = "none";
	  document.getElementById("userDetails").style.display = "block";
	  document.getElementById("ticketDetails").style.display = "none";
	  document.getElementById("passengerDetails").style.display = "none";
	  document.getElementById("editFormContainer").style.display = "none";
	}

	var userId; // Declare a variable to store the user ID

	function enableEdit(form, userId) {
	  // Enable editing of name, age, and gender fields
	  $("#userName").prop("disabled", false);
	  $("#age").prop("disabled", false);
	  $("#gender").prop("disabled", false);
	  // Disable the Edit button
	  $("#editButton").prop("disabled", true);
	  // Enable the Save button
	  $("#saveButton").prop("disabled", false);
	  // Store the user ID
	  userId = userId;
	}

	function savedata(form, userId) {
			  showBufferingLayer(); // Show the spinner before form submission
		 $("#userForm").submit(function(event) {
			    event.preventDefault();
		
		 var id = $("#userId").val();
		    var user = $("#userEmail").val();
		    var password = $("#password").val();
		    var name = $("#userName").val();
		    var age = $("#age").val();
		    var gender = $("#gender").val();
		    var cashback = $("#cashback").val();
		    var wallet = $("#wallet").val();

	  // Send the updated data to the server
	  
	   var updatedUser = {
	      "user_id": id,
	      "email": user,
	      "password": password,
	      "full_name": name,
	      "age": age,
	      "gender": gender,
	      "cashback": cashback,
	      "wallet": wallet
	    };
	  
	   console.log(updatedUser);
	  $.ajax({
		  type: "POST",
	    url: "updateUser", // Replace with the actual URL of your update service
	    data: JSON.stringify(updatedUser),
	     contentType: "application/json",
	    success: function(response) {
	      alert("User details updated successfully!");
	      // Disable the Save button
	      $("#saveButton").prop("disabled", true);
	      // Enable the Edit button
	      $("#editButton").prop("disabled", false);
	      // Disable editing of name, age, and gender fields
	      $("#userName").prop("disabled", true);
	      $("#age").prop("disabled", true);
	      $("#gender").prop("disabled", true);
	            hideBufferingLayer();
	    },
	    error: function(xhr, status, error) {
	    	alert("Failed to update user");
	      console.error("AJAX request failed: " + status + ", " + error);
	                  hideBufferingLayer();
	    }
	  });
     });
	}

	// Call the function to display user details on page load
	//showUserDetails();

  
 function showBooking(){
	          showBufferingLayer();
	         var dashboardHeader = document.querySelector("#dashboardHeader h1");
            dashboardHeader.textContent = "Welcome To Ticket Details";
 	$.ajax({
         url: "ticketList", // Replace with the actual URL of your service
         method: "GET",
         success: function(response) {
             var tickets = JSON.parse(response);
             console.log(tickets);
             var tableBody = document.querySelector("#ticketDetails table tbody");
             tableBody.innerHTML = ""; // Clear existing table rows
             
             // Iterate over the services and populate the table
             for (var i = 0; i < tickets.length; i++) {
                 var ticket = tickets[i];
                 var row = document.createElement("tr");

                 var bookingIdCell = document.createElement("td");
                 bookingIdCell.textContent = ticket.booking_id;
                 row.appendChild(bookingIdCell);
                 
                 var paymentIdCell = document.createElement("td");
                 var travelDate = new Date(ticket.travel_date);
                 paymentIdCell.textContent = travelDate.toLocaleDateString();
                 row.appendChild(paymentIdCell);
                 
          
                 
                 var bookingdateCell = document.createElement("td");
                 var bookingDate = new Date(ticket.booking_date);
                 bookingdateCell.textContent = bookingDate.toLocaleDateString();
                 row.appendChild(bookingdateCell);
                 
                

                 var paymentModeCell = document.createElement("td");
                 paymentModeCell.textContent = ticket.payment_mode;
                 row.appendChild(paymentModeCell);
                 
                 
                 var totalfareCell = document.createElement("td");
                 totalfareCell.textContent = ticket.total_fare;
                 row.appendChild(totalfareCell);
                 
                 var statusCell = document.createElement("td");
                 statusCell.textContent = ticket.status;
                 if(ticket.status=='cancelled'){
                	statusCell.style.color = "red";
                 }
                 else{
                	  statusCell.style.color = "blue";
                 }
                 row.appendChild(statusCell);
                 
                 
                 var noofseatsbokkedCell = document.createElement("td");
                 noofseatsbokkedCell.textContent = ticket.no_of_seats_booked;
                 row.appendChild(noofseatsbokkedCell);
                 
                 var previewCell = document.createElement("td");
                 var previewButton = document.createElement("button");
                 previewButton.textContent = "Preview";
                 previewButton.id = "preview-button";
                 previewButton.addEventListener("click", createPopup.bind(null, ticket));
                 previewCell.appendChild(previewButton);
                 row.appendChild(previewCell);

                 
                 tableBody.appendChild(row);
                 hideBufferingLayer();

             }
         },
         error: function(xhr, status, error) {
			                     hideBufferingLayer();
             console.error("AJAX request failed: " + status + ", " + error);
         }
     });
 	
 	
 	function createPopup(ticket) {
 	    var popup = document.createElement("div");
 	    popup.id = "popup";
 	    popup.classList.add("popup");

 	    var popupContent = document.createElement("div");
 	    popupContent.classList.add("popup-content");

 	    // Create table element
 	    var table = document.createElement("table");
 	    table.classList.add("popup-table");

 	    // Create table rows and cells for ticket details
 	    var ticketDetails = [
 	        { label: "Booking ID:", value: ticket.booking_id },
 	        { label: "Travel Date:", value: formatDate(ticket.travel_date) },
 	        { label: "Booking Date:", value: formatDate(ticket.booking_date) },
 	        { label: "Trip ID:", value: ticket.trip_id },
 	        { label: "Service ID:", value: ticket.service_id },
 	        { label: "Source:", value: ticket.source },
 	        { label: "Destination:", value: ticket.destination },
 	        { label: "Departure:", value: ticket.departure },
 	        { label: "Payment Mode:", value: ticket.payment_mode },
 	        { label: "Total Fare:", value: ticket.total_fare },
 	        { label: "Status:", value: ticket.status },
 	        { label: "No. of Seats Booked:", value: ticket.no_of_seats_booked }
 	    ];

 	    // Create table rows and cells for each ticket detail
 	    ticketDetails.forEach(function(detail) {
 	        var row = document.createElement("tr");

 	        var labelCell = document.createElement("td");
 	        labelCell.textContent = detail.label;
 	        row.appendChild(labelCell);

 	        var valueCell = document.createElement("td");
 	        valueCell.textContent = detail.value;
 	        row.appendChild(valueCell);

 	        table.appendChild(row);
 	    });

 	    // Check if passengers list exists
 	    if (ticket.passengerList) {
 	        // Create row for passengers heading
 	        var passengersHeadingRow = document.createElement("tr");

 	        var passengersHeadingCell = document.createElement("td");
 	        passengersHeadingCell.textContent = "Passengers:";
 	        passengersHeadingCell.colSpan = 2;
 	        passengersHeadingRow.appendChild(passengersHeadingCell);

 	        table.appendChild(passengersHeadingRow);

 	        // Create table row for passenger details
 	        var passengersDetailsRow = document.createElement("tr");
 	        var passengersDetailsCell = document.createElement("td");
 	        passengersDetailsCell.colSpan = 2;

 	        // Create table for passenger details
 	        var passengersTable = document.createElement("table");

 	        // Create table row for each passenger
 	        ticket.passengerList.forEach(function(passenger) {
 	            var passengerRow = document.createElement("tr");

 	            var nameCell = document.createElement("td");
 	            nameCell.textContent = "Name: " + passenger.passenger_name;
 	            passengerRow.appendChild(nameCell);

 	            var genderCell = document.createElement("td");
 	            genderCell.textContent = "Gender: " + passenger.passenger_gender;
 	            passengerRow.appendChild(genderCell);

 	            var ageCell = document.createElement("td");
 	            ageCell.textContent = "Age: " + passenger.passenger_age;
 	            passengerRow.appendChild(ageCell);

 	            var fareCell = document.createElement("td");
 	            fareCell.textContent = "Fare: " + passenger.seat_fare;
 	            passengerRow.appendChild(fareCell);

 	            passengersTable.appendChild(passengerRow);
 	        });

 	        passengersDetailsCell.appendChild(passengersTable);
 	        passengersDetailsRow.appendChild(passengersDetailsCell);
 	        table.appendChild(passengersDetailsRow);
 	    }

 	    // Append the table to the popup content
 	    popupContent.appendChild(table);

 	    var backButton = document.createElement("button");
 	    backButton.textContent = "Back";
 	    backButton.classList.add("popup-button"); // Add a CSS class for the button

 	    backButton.addEventListener("click", function() {
 	        popup.classList.remove("show-popup"); // Remove the animation class

 	        setTimeout(function() {
 	            popup.remove(); // Remove the popup after the animation finishes
 	        }, 10);
 	    });

 	    popupContent.appendChild(backButton);

 	    document.body.appendChild(popup);

 	    // Add event listener to hide the popup on click
 	    setTimeout(function() {
 	        popup.classList.add("show-popup"); // Add the animation class after a delay
 	    }, 100);

 	    popup.appendChild(popupContent);
 	}


 	
 	function formatDate(dateString) {
 	    var date = new Date(dateString);
 	    return date.toLocaleDateString(); // Adjust the format according to your requirements
 	}
//////////////////////////
 	

 	document.getElementById("dashboard2").style.display = "none";
    document.getElementById("userDetails").style.display = "none";
   document.getElementById("ticketDetails").style.display = "block";	
   document.getElementById("passengerDetails").style.display = "none";
   document.getElementById("editFormContainer").style.display = "none";


 }
 
 
 function showfutureBooking(){
	 	  showBufferingLayer(); // Show the spinner before form submission
	 	   var dashboardHeader = document.querySelector("#dashboardHeader h1");
            dashboardHeader.textContent = "Welcome To Future Ticket Details";
	 	$.ajax({
	         url: "futureticketList", // Replace with the actual URL of your service
	         method: "GET",
	         success: function(response) {
	             var tickets = JSON.parse(response);
	             console.log(tickets);
	             var tableBody = document.querySelector("#ticketDetails table tbody");
	             tableBody.innerHTML = ""; // Clear existing table rows
	             
	             // Iterate over the services and populate the table
	             for (var i = 0; i < tickets.length; i++) {
	                 var ticket = tickets[i];
	                 var row = document.createElement("tr");

	                 var bookingIdCell = document.createElement("td");
	                 bookingIdCell.textContent = ticket.booking_id;
	                 row.appendChild(bookingIdCell);
	                 
	                 var paymentIdCell = document.createElement("td");
	                 var travelDate = new Date(ticket.travel_date);
	                 paymentIdCell.textContent = travelDate.toLocaleDateString();
	                 row.appendChild(paymentIdCell);
	                 
	          
	                 
	                 var bookingdateCell = document.createElement("td");
	                 var bookingDate = new Date(ticket.booking_date);
	                 bookingdateCell.textContent = bookingDate.toLocaleDateString();
	                 row.appendChild(bookingdateCell);
	                 
	                

	                 var paymentModeCell = document.createElement("td");
	                 paymentModeCell.textContent = ticket.payment_mode;
	                 row.appendChild(paymentModeCell);
	                 
	                 
	                 var totalfareCell = document.createElement("td");
	                 totalfareCell.textContent = ticket.total_fare;
	                 row.appendChild(totalfareCell);
	                 
	                 var statusCell = document.createElement("td");
	                 statusCell.textContent = ticket.status;
	                 row.appendChild(statusCell);
	                 
	                 
	                 var noofseatsbokkedCell = document.createElement("td");
	                 noofseatsbokkedCell.textContent = ticket.no_of_seats_booked;
	                 row.appendChild(noofseatsbokkedCell);
	                 
	                 var previewCell = document.createElement("td");
	                 var previewButton = document.createElement("button");
	                 previewButton.textContent = "Preview";
	                 previewButton.id = "preview-button";
	                 previewButton.addEventListener("click", createPopup.bind(null, ticket));
	                 previewCell.appendChild(previewButton);
	                 row.appendChild(previewCell);
	                 
	              // Create cancel button
	                 var cancelButton = document.createElement("button");
	                 cancelButton.textContent = "Cancel Ticket";
	                 cancelButton.id = "cancel-button"; // Add an ID to the button
	                 cancelButton.addEventListener("click", cancelTicket.bind(null, ticket.booking_id,ticket.payment_id,ticket.total_fare));

	                 cancelButton.style.backgroundColor = "#b51212"; // Apply green color
	                 cancelButton.style.color = "white";
	                 var cancelButtonCell = document.createElement("td");
	                 cancelButtonCell.appendChild(cancelButton);
	                 row.appendChild(cancelButtonCell);
	                 tableBody.appendChild(row);
	                       hideBufferingLayer();

	             }
	         },
	         error: function(xhr, status, error) {
	             console.error("AJAX request failed: " + status + ", " + error);
	         }
	     });

	 	function createPopup(ticket) {
	 	    var popup = document.createElement("div");
	 	    popup.id = "popup";
	 	    popup.classList.add("popup");

	 	    var popupContent = document.createElement("div");
	 	    popupContent.classList.add("popup-content");

	 	    // Create table element
	 	    var table = document.createElement("table");
	 	    table.classList.add("popup-table");

	 	    // Create table rows and cells for ticket details
	 	    var ticketDetails = [
	 	        { label: "Booking ID:", value: ticket.booking_id },
	 	        { label: "Travel Date:", value: formatDate(ticket.travel_date) },
	 	        { label: "Booking Date:", value: formatDate(ticket.booking_date) },
	 	        { label: "Trip ID:", value: ticket.trip_id },
	 	        { label: "Service ID:", value: ticket.service_id },
	 	        { label: "Source:", value: ticket.source },
	 	        { label: "Destination:", value: ticket.destination },
	 	        { label: "Departure:", value: ticket.departure },
	 	        { label: "Payment Mode:", value: ticket.payment_mode },
	 	        { label: "Total Fare:", value: ticket.total_fare },
	 	        { label: "Status:", value: ticket.status },
	 	        { label: "No. of Seats Booked:", value: ticket.no_of_seats_booked }
	 	    ];

	 	    // Create table rows and cells for each ticket detail
	 	    ticketDetails.forEach(function(detail) {
	 	        var row = document.createElement("tr");

	 	        var labelCell = document.createElement("td");
	 	        labelCell.textContent = detail.label;
	 	        row.appendChild(labelCell);

	 	        var valueCell = document.createElement("td");
	 	        valueCell.textContent = detail.value;
	 	        row.appendChild(valueCell);

	 	        table.appendChild(row);
	 	    });

	 	    // Check if passengers list exists
	 	    if (ticket.passengerList) {
	 	        // Create row for passengers heading
	 	        var passengersHeadingRow = document.createElement("tr");

	 	        var passengersHeadingCell = document.createElement("td");
	 	        passengersHeadingCell.textContent = "Passengers:";
	 	        passengersHeadingCell.colSpan = 2;
	 	        passengersHeadingRow.appendChild(passengersHeadingCell);

	 	        table.appendChild(passengersHeadingRow);

	 	        // Create table row for passenger details
	 	        var passengersDetailsRow = document.createElement("tr");
	 	        var passengersDetailsCell = document.createElement("td");
	 	        passengersDetailsCell.colSpan = 2;

	 	        // Create table for passenger details
	 	        var passengersTable = document.createElement("table");

	 	        // Create table row for each passenger
	 	        ticket.passengerList.forEach(function(passenger) {
	 	            var passengerRow = document.createElement("tr");

	 	            var nameCell = document.createElement("td");
	 	            nameCell.textContent = "Name: " + passenger.passenger_name;
	 	            passengerRow.appendChild(nameCell);

	 	            var genderCell = document.createElement("td");
	 	            genderCell.textContent = "Gender: " + passenger.passenger_gender;
	 	            passengerRow.appendChild(genderCell);

	 	            var ageCell = document.createElement("td");
	 	            ageCell.textContent = "Age: " + passenger.passenger_age;
	 	            passengerRow.appendChild(ageCell);

	 	            var fareCell = document.createElement("td");
	 	            fareCell.textContent = "Fare: " + passenger.seat_fare;
	 	            passengerRow.appendChild(fareCell);

	 	            passengersTable.appendChild(passengerRow);
	 	        });

	 	        passengersDetailsCell.appendChild(passengersTable);
	 	        passengersDetailsRow.appendChild(passengersDetailsCell);
	 	        table.appendChild(passengersDetailsRow);
	 	    }

	 	    // Append the table to the popup content
	 	    popupContent.appendChild(table);

	 	    var backButton = document.createElement("button");
	 	    backButton.textContent = "Back";
	 	    backButton.classList.add("popup-button"); // Add a CSS class for the button

	 	    backButton.addEventListener("click", function() {
	 	        popup.classList.remove("show-popup"); // Remove the animation class

	 	        setTimeout(function() {
	 	            popup.remove(); // Remove the popup after the animation finishes
	 	        }, 10);
	 	    });

	 	    popupContent.appendChild(backButton);

	 	    document.body.appendChild(popup);

	 	    // Add event listener to hide the popup on click
	 	    setTimeout(function() {
	 	        popup.classList.add("show-popup"); // Add the animation class after a delay
	 	    }, 100);

	 	    popup.appendChild(popupContent);
	 	}


	 	function formatDate(dateString) {
	 	    var date = new Date(dateString);
	 	    return date.toLocaleDateString(); // Adjust the format according to your requirements
	 	}
	 	

	 	document.getElementById("dashboard2").style.display = "none";
	    document.getElementById("userDetails").style.display = "none";
	   document.getElementById("ticketDetails").style.display = "block";	
	   document.getElementById("passengerDetails").style.display = "none";
       document.getElementById("editFormContainer").style.display = "none";

	 }
	   
 function showPastBooking(){
	 	  showBufferingLayer(); // Show the spinner before form submission

 			var dashboardHeader = document.querySelector("#dashboardHeader h1");
            dashboardHeader.textContent = "Welcome To Past Ticket Details";
	 	$.ajax({
	         url: "pastticketList", // Replace with the actual URL of your service
	         method: "GET",
	         success: function(response) {
	             var tickets = JSON.parse(response);
	             var tableBody = document.querySelector("#ticketDetails table tbody");
	             tableBody.innerHTML = ""; // Clear existing table rows
	             
	             // Iterate over the services and populate the table
	             for (var i = 0; i < tickets.length; i++) {
	                 var ticket = tickets[i];
	                 var row = document.createElement("tr");

	                 var bookingIdCell = document.createElement("td");
	                 bookingIdCell.textContent = ticket.booking_id;
	                 row.appendChild(bookingIdCell);
	                 
	                 var paymentIdCell = document.createElement("td");
	                 var travelDate = new Date(ticket.travel_date);
	                 paymentIdCell.textContent = travelDate.toLocaleDateString();
	    
	                 row.appendChild(paymentIdCell);

	                 
	                 var bookingdateCell = document.createElement("td");
	                 var bookingDate = new Date(ticket.booking_date);
	                 bookingdateCell.textContent = bookingDate.toLocaleDateString();
	                 row.appendChild(bookingdateCell);

	                 var paymentModeCell = document.createElement("td");
	                 paymentModeCell.textContent = ticket.payment_mode;
	                 row.appendChild(paymentModeCell);
	                 
	                 
	                 var totalfareCell = document.createElement("td");
	                 totalfareCell.textContent = ticket.total_fare;
	                 row.appendChild(totalfareCell);
	                 
	                 var statusCell = document.createElement("td");
	                 statusCell.textContent = ticket.status;
	                 row.appendChild(statusCell);
	                 
	                 
	                 var noofseatsbokkedCell = document.createElement("td");
	                 noofseatsbokkedCell.textContent = ticket.no_of_seats_booked;
	                 row.appendChild(noofseatsbokkedCell);
	                 
	                 var previewCell = document.createElement("td");
	                 var previewButton = document.createElement("button");
	                 previewButton.textContent = "Preview";
	                 previewButton.id = "preview-button";
	                 previewButton.addEventListener("click", createPopup.bind(null, ticket));
	                 previewCell.appendChild(previewButton);
	                 row.appendChild(previewCell);

	                 
	                 tableBody.appendChild(row);
	                       hideBufferingLayer();
	             }
	         },
	         error: function(xhr, status, error) {
	             console.error("AJAX request failed: " + status + ", " + error);
	         }
	     });
	 	function createPopup(ticket) {
	 	    var popup = document.createElement("div");
	 	    popup.id = "popup";
	 	    popup.classList.add("popup");

	 	    var popupContent = document.createElement("div");
	 	    popupContent.classList.add("popup-content");

	 	    // Create table element
	 	    var table = document.createElement("table");
	 	    table.classList.add("popup-table");

	 	    // Create table rows and cells for ticket details
	 	    var ticketDetails = [
	 	        { label: "Booking ID:", value: ticket.booking_id },
	 	        { label: "Travel Date:", value: formatDate(ticket.travel_date) },
	 	        { label: "Booking Date:", value: formatDate(ticket.booking_date) },
	 	        { label: "Trip ID:", value: ticket.trip_id },
	 	        { label: "Service ID:", value: ticket.service_id },
	 	        { label: "Source:", value: ticket.source },
	 	        { label: "Destination:", value: ticket.destination },
	 	        { label: "Departure:", value: ticket.departure },
	 	        { label: "Payment Mode:", value: ticket.payment_mode },
	 	        { label: "Total Fare:", value: ticket.total_fare },
	 	        { label: "Status:", value: ticket.status },
	 	        { label: "No. of Seats Booked:", value: ticket.no_of_seats_booked }
	 	    ];

	 	    // Create table rows and cells for each ticket detail
	 	    ticketDetails.forEach(function(detail) {
	 	        var row = document.createElement("tr");

	 	        var labelCell = document.createElement("td");
	 	        labelCell.textContent = detail.label;
	 	        row.appendChild(labelCell);

	 	        var valueCell = document.createElement("td");
	 	        valueCell.textContent = detail.value;
	 	        row.appendChild(valueCell);

	 	        table.appendChild(row);
	 	    });

	 	    // Check if passengers list exists
	 	    if (ticket.passengerList) {
	 	        // Create row for passengers heading
	 	        var passengersHeadingRow = document.createElement("tr");

	 	        var passengersHeadingCell = document.createElement("td");
	 	        passengersHeadingCell.textContent = "Passengers:";
	 	        passengersHeadingCell.colSpan = 2;
	 	        passengersHeadingRow.appendChild(passengersHeadingCell);

	 	        table.appendChild(passengersHeadingRow);

	 	        // Create table row for passenger details
	 	        var passengersDetailsRow = document.createElement("tr");
	 	        var passengersDetailsCell = document.createElement("td");
	 	        passengersDetailsCell.colSpan = 2;

	 	        // Create table for passenger details
	 	        var passengersTable = document.createElement("table");

	 	        // Create table row for each passenger
	 	        ticket.passengerList.forEach(function(passenger) {
	 	            var passengerRow = document.createElement("tr");

	 	            var nameCell = document.createElement("td");
	 	            nameCell.textContent = "Name: " + passenger.passenger_name;
	 	            passengerRow.appendChild(nameCell);

	 	            var genderCell = document.createElement("td");
	 	            genderCell.textContent = "Gender: " + passenger.passenger_gender;
	 	            passengerRow.appendChild(genderCell);

	 	            var ageCell = document.createElement("td");
	 	            ageCell.textContent = "Age: " + passenger.passenger_age;
	 	            passengerRow.appendChild(ageCell);

	 	            var fareCell = document.createElement("td");
	 	            fareCell.textContent = "Fare: " + passenger.seat_fare;
	 	            passengerRow.appendChild(fareCell);

	 	            passengersTable.appendChild(passengerRow);
	 	        });

	 	        passengersDetailsCell.appendChild(passengersTable);
	 	        passengersDetailsRow.appendChild(passengersDetailsCell);
	 	        table.appendChild(passengersDetailsRow);
	 	    }

	 	    // Append the table to the popup content
	 	    popupContent.appendChild(table);

	 	    var backButton = document.createElement("button");
	 	    backButton.textContent = "Back";
	 	    backButton.classList.add("popup-button"); // Add a CSS class for the button

	 	    backButton.addEventListener("click", function() {
	 	        popup.classList.remove("show-popup"); // Remove the animation class

	 	        setTimeout(function() {
	 	            popup.remove(); // Remove the popup after the animation finishes
	 	        }, 10);
	 	    });

	 	    popupContent.appendChild(backButton);

	 	    document.body.appendChild(popup);

	 	    // Add event listener to hide the popup on click
	 	    setTimeout(function() {
	 	        popup.classList.add("show-popup"); // Add the animation class after a delay
	 	    }, 100);

	 	    popup.appendChild(popupContent);
	 	}
	 	function formatDate(dateString) {
	 	    var date = new Date(dateString);
	 	    return date.toLocaleDateString(); // Adjust the format according to your requirements
	 	}
	 	
	 	
	 	document.getElementById("dashboard2").style.display = "none";
	    document.getElementById("userDetails").style.display = "none";
	   document.getElementById("ticketDetails").style.display = "block";	
	   document.getElementById("passengerDetails").style.display = "none";
       document.getElementById("editFormContainer").style.display = "none";


	 }
 
 
 
 function showcancelledBooking(){
	 	  showBufferingLayer(); // Show the spinner before form submission
  			var dashboardHeader = document.querySelector("#dashboardHeader h1");
            dashboardHeader.textContent = "Cancelled Ticket Details";
	 	$.ajax({
	         url: "cancelticketList", // Replace with the actual URL of your service
	         method: "GET",
	         success: function(response) {
	             var tickets = JSON.parse(response);
	             var tableBody = document.querySelector("#ticketDetails table tbody");
	             tableBody.innerHTML = ""; // Clear existing table rows
	             
	             // Iterate over the services and populate the table
	             for (var i = 0; i < tickets.length; i++) {
	                 var ticket = tickets[i];
	                 var row = document.createElement("tr");

	                 var bookingIdCell = document.createElement("td");
	                 bookingIdCell.textContent = ticket.booking_id;
	                 row.appendChild(bookingIdCell);
	                 
	                 var paymentIdCell = document.createElement("td");
	                 var travelDate = new Date(ticket.travel_date);
	                 paymentIdCell.textContent = travelDate.toLocaleDateString();
	                 row.appendChild(paymentIdCell);
	                 
	          
	                 
	                 var bookingdateCell = document.createElement("td");
	                 var bookingDate = new Date(ticket.booking_date);
	                 bookingdateCell.textContent = bookingDate.toLocaleDateString();
	                 row.appendChild(bookingdateCell);
	                 
	                

	                 var paymentModeCell = document.createElement("td");
	                 paymentModeCell.textContent = ticket.payment_mode;
	                 row.appendChild(paymentModeCell);
	                 
	                 
	                 var totalfareCell = document.createElement("td");
	                 totalfareCell.textContent = ticket.total_fare;
	                 row.appendChild(totalfareCell);
	                 
	                 var statusCell = document.createElement("td");
	                 statusCell.textContent = ticket.status;
	                 statusCell.style.color = "red";
	                 row.appendChild(statusCell);
	                 
	                 
	                 var noofseatsbokkedCell = document.createElement("td");
	                 noofseatsbokkedCell.textContent = ticket.no_of_seats_booked;
	                 row.appendChild(noofseatsbokkedCell);
	                 
	                 var previewCell = document.createElement("td");
	                 var previewButton = document.createElement("button");
	                 previewButton.textContent = "Preview";
	                 previewButton.id = "preview-button";
	                 previewButton.addEventListener("click", createPopup.bind(null, ticket));
	                 previewCell.appendChild(previewButton);
	                 row.appendChild(previewCell);

	                 
	                 tableBody.appendChild(row);
	                       hideBufferingLayer();

	             }
	         },
	         error: function(xhr, status, error) {
	             console.error("AJAX request failed: " + status + ", " + error);
	         }
	     });
	 	
	 	
	 	function createPopup(ticket) {
	    var popup = document.createElement("div");
	    popup.id = "popup";
	    popup.classList.add("popup");

	    var popupContent = document.createElement("div");
	    popupContent.classList.add("popup-content");

	    // Create table element
	    var table = document.createElement("table");
	    table.classList.add("popup-table");

	    // Create table rows and cells for ticket details
	    var ticketDetails = [
	        { label: "Booking ID:", value: ticket.booking_id },
	        { label: "Travel Date:", value:formatDate(ticket.travel_date) },
	        { label: "Booking Date:", value:formatDate(ticket.booking_date)},
	        { label: "Trip ID:", value: ticket.trip_id },
	        { label: "Service ID:", value: ticket.service_id },
	        { label: "Source:", value: ticket.source },
	        { label: "Destination:", value: ticket.destination },
	        { label: "Departure:", value: ticket.departure },
	        { label: "Payment Mode:", value: ticket.payment_mode },
	        { label: "Total Fare:", value: ticket.total_fare },
	        { label: "Status:", value: ticket.status },
	        { label: "No. of Seats Booked:", value: ticket.no_of_seats_booked },
	        
	    ];

	    // Create table rows and cells for each ticket detail
	    ticketDetails.forEach(function(detail) {
	        var row = document.createElement("tr");

	        var labelCell = document.createElement("td");
	        labelCell.textContent = detail.label;
	        row.appendChild(labelCell);

	        var valueCell = document.createElement("td");
	        valueCell.textContent = detail.value;
	        row.appendChild(valueCell);

	        table.appendChild(row);
	    });

	    // Append the table to the popup content
	    popupContent.appendChild(table);

	    var backButton = document.createElement("button");
	    backButton.textContent = "Back";
	    backButton.classList.add("popup-button"); // Add a CSS class for the button

	    backButton.addEventListener("click", function() {
	        popup.classList.remove("show-popup"); // Remove the animation class
	        setTimeout(function() {
	            popup.remove(); // Remove the popup after the animation finishes
	        }, 500);
	    });

	    popupContent.appendChild(backButton);
	    popup.appendChild(popupContent);

	    document.body.appendChild(popup);

	    // Add event listener to hide the popup on click
	    setTimeout(function() {
	        popup.classList.add("show-popup"); // Add the animation class after a delay
	    }, 10);
	}
	 	
	 	function formatDate(dateString) {
	 	    var date = new Date(dateString);
	 	    return date.toLocaleDateString(); // Adjust the format according to your requirements
	 	}
	 	document.getElementById("dashboard2").style.display = "none";
	    document.getElementById("userDetails").style.display = "none";
	   document.getElementById("ticketDetails").style.display = "block";	
	   document.getElementById("passengerDetails").style.display = "none";
	   document.getElementById("editFormContainer").style.display = "none";


	 }
	 
 
	
 function rating(){
	 	  showBufferingLayer(); // Show the spinner before form submission
 			var dashboardHeader = document.querySelector("#dashboardHeader h1");
            dashboardHeader.textContent = "Welcome To Service Rating";
	 	$.ajax({
	         url: "ratingList", // Replace with the actual URL of your service
	         method: "GET",
	         success: function(response) {
	             var tickets = JSON.parse(response);
	             var tableBody = document.querySelector("#ticketDetails table tbody");
	             tableBody.innerHTML = ""; // Clear existing table rows
	             
	             // Iterate over the services and populate the table
	             for (var i = 0; i < tickets.length; i++) {
	                 var ticket = tickets[i];
	                 var row = document.createElement("tr");

	                 var bookingIdCell = document.createElement("td");
	                 bookingIdCell.textContent = ticket.booking_id;
	                 row.appendChild(bookingIdCell);
	                 
	                 var paymentIdCell = document.createElement("td");
	                 var travelDate = new Date(ticket.travel_date);
	                 paymentIdCell.textContent = travelDate.toLocaleDateString();
	                 row.appendChild(paymentIdCell);
	                         
	                 var bookingdateCell = document.createElement("td");
	                 var bookingDate = new Date(ticket.booking_date);
	                 bookingdateCell.textContent = bookingDate.toLocaleDateString();
	                 row.appendChild(bookingdateCell);
	                 
	                 var paymentModeCell = document.createElement("td");
	                 paymentModeCell.textContent = ticket.payment_mode;
	                 row.appendChild(paymentModeCell);
	                 
	                 
	                 var totalfareCell = document.createElement("td");
	                 totalfareCell.textContent = ticket.total_fare;
	                 row.appendChild(totalfareCell);
	                 
	                 var statusCell = document.createElement("td");
	                 statusCell.textContent = "Travelled";
	                 statusCell.style.color = "darkblue";
	                 row.appendChild(statusCell);
                 
	                 var noofseatsbokkedCell = document.createElement("td");
	                 noofseatsbokkedCell.textContent = ticket.no_of_seats_booked;
	                 row.appendChild(noofseatsbokkedCell);
	                 
	                 var ratingCell = document.createElement("td");
	                 var ratingButton = document.createElement("button");
	                 ratingButton.textContent = "Give rating";
	                 ratingButton.id = "rating-button";
	                 ratingButton.addEventListener("click",showRatingPopup.bind(null, ticket));
	                 ratingCell.appendChild(ratingButton);
	                 row.appendChild(ratingCell);

	                 
	                 tableBody.appendChild(row);
	                 document.getElementById('spinner').style.display = 'none';
	                 hideBufferingLayer();

	             }
	         },
	         error: function(xhr, status, error) {
	             console.error("AJAX request failed: " + status + ", " + error);
	         }
	     });
	 	
	 	function showRatingPopup(ticket) {
	 	    console.log("in rating popup");
	 	    console.log(ticket.booking_id);
	 	    const popup = document.createElement("div");
	 	    popup.setAttribute("class", "rating-popup");

	 	    const ratingText = document.createElement("p");
	 	    ratingText.textContent = "Give your rating:";
	 	    popup.appendChild(ratingText);

	 	    const ratingOptions = document.createElement("div");
	 	    ratingOptions.setAttribute("class", "rating-options");

	 	    // Create star rating buttons
	 	    for (let i = 1; i <= 5; i++) {
	 	        const starButton = document.createElement("button");
	 	        starButton.setAttribute("class", "rating-star");
	 	        starButton.textContent = "★"; // Use a star icon here, such as ★
	 	        starButton.addEventListener("click", function() {
	 	            handleRating(ticket, i);
	 	        });

	 	        ratingOptions.appendChild(starButton);
	 	    }

	 	    const submitButton = document.createElement("button");
	 	    submitButton.setAttribute("class", "submit-button");
	 	    submitButton.textContent = "Submit";
	 	    submitButton.addEventListener("click", function() {
	 	        handleSubmit(ticket);
	 	    });
	 	    
			const cancelButton = document.createElement("button");
			cancelButton.setAttribute("class", "cancel-button");
			cancelButton.textContent = "Cancel";
			cancelButton.addEventListener("click", function() {
			const ratingPopup = document.querySelector(".rating-popup");
	 	    ratingPopup.remove();
			});
			
			
	 	    popup.appendChild(ratingOptions);
	 	    popup.appendChild(submitButton);
	 	    popup.appendChild(cancelButton);
	 	    document.body.appendChild(popup);
	 	}

	 	function handleRating(ticket, rating) {
	 	    const ratingStars = document.querySelectorAll(".rating-star");
	 	    ratingStars.forEach((star, index) => {
	 	        if (index < rating) {
	 	            star.style.color = "yellow";
	 	        } else {
	 	            star.style.color = "black";
	 	        }
	 	    });
	 	}

	 	function handleSubmit(ticket) {
			 	  showBufferingLayer(); // Show the spinner before form submission
	 	    const selectedRating = document.querySelectorAll(".rating-star[style='color: yellow;']").length;
	 	    const message = "Thank you for giving a rating of " + selectedRating + " star(s)!";
	 	   

	 		 var data={
	 				  "booking_id": ticket.booking_id ,
	 				  "payment_id":ticket.payment_id ,
	 		    		 "user_id":ticket.user_id ,
       	                "rating": selectedRating                      
	 	        };    	 		 
	 		  var data=JSON.stringify(data);
	 		  console.log(data);   	    
	 	   $.ajax({
		        url: "updateRatingList", // Replace with the actual URL of your controller method
		        method: "POST",
		        data:data,// Pass the values to the controller method
		        contentType: "application/json",
		        success: function(response) {
		        	 console.log("rating send successfully");

		             // Show a confirmation popup or alert
		             alert(message);

		             // Refresh the table to display the updated list
		                   hideBufferingLayer();

		             rating();
		        },
		        error: function(xhr, status, error) {
		        	 //alert("Passenger not  deleted successfully");
		             rating();
		            console.error("AJAX request failed: " + status + ", " + error);
		        }
		    });
	 	    // Send the rating value to the controller using AJAX or fetch
	 	    // Example using fetch:
	 	    const ratingPopup = document.querySelector(".rating-popup");
	 	    ratingPopup.remove();
	 	}

 	
	 	function formatDate(dateString) {
	 	    var date = new Date(dateString);
	 	    return date.toLocaleDateString(); // Adjust the format according to your requirements
	 	}

	 	document.getElementById("dashboard2").style.display = "none";
	    document.getElementById("userDetails").style.display = "none";
	   document.getElementById("ticketDetails").style.display = "block";	
	   document.getElementById("passengerDetails").style.display = "none";
	   document.getElementById("editFormContainer").style.display = "none";


	 }
	 
	 
 function showPassengers() {
	 	  showBufferingLayer(); // Show the spinner before form submission
          var dashboardHeader = document.querySelector("#dashboardHeader h1");
                dashboardHeader.textContent = " Passengers Details";
	    $.ajax({
	        url: "passengersList", // Replace with the actual URL of your service
	        method: "GET",
	        success: function(response) {
	            
	            var passengers = JSON.parse(response);
	            var tableBody = document.querySelector("#passengerDetails table tbody");
	            tableBody.innerHTML = ""; // Clear existing table rows

	            // Iterate over the passengers and populate the table
	            for (var i = 0; i < passengers.length; i++) {
	                var passenger = passengers[i];
	                var row = document.createElement("tr");
					
	                var userIdCell = document.createElement("td");
	                userIdCell.textContent = passenger.user_id;
	                userIdCell.style.display = "none"; 
	                row.appendChild(userIdCell);

	          
	                var nameCell = document.createElement("td");
	                nameCell.textContent = passenger.passenger_name;
	                row.appendChild(nameCell);

	                var ageCell = document.createElement("td");
	                ageCell.textContent = passenger.age;
	                row.appendChild(ageCell);

	                var genderCell = document.createElement("td");
	                genderCell.textContent = passenger.gender;
	                row.appendChild(genderCell);
	                
	                var actionCell2 = document.createElement("td");
	                var deleteButton = document.createElement("button");
	                deleteButton.innerHTML = '<i class="fas fa-trash"></i>';
	                deleteButton.addEventListener("click", function() {
	                	 var selectedRow = this.parentNode.parentNode;
	                	    var userId = selectedRow.cells[0].textContent;
	                	    var name = selectedRow.cells[1].textContent;
	                	    var age = selectedRow.cells[2].textContent;
	                	    var gender = selectedRow.cells[3].textContent;

						 var isConfirmed = confirm("Are you sure you want to delete this passenger?");

    					if (isConfirmed) {
      						  // Call the controller method to delete the passenger
       							 deletePassenger(userId, name, age, gender);
    						}
	                    // Call the controller method to delete the passenger
	                    //deletePassenger(userId,name,age,gender);
	                });
	                actionCell2.appendChild(deleteButton);
 
	                row.appendChild(actionCell2);
	                tableBody.appendChild(row);
	                
	                
	            }
	            
	            var addButtonRow = document.createElement("tr");
	            var addButtonCell = document.createElement("td");
	            addButtonCell.colSpan = 5; // Span the cell across all columns
	            addButtonCell.style.textAlign = "center"; // Align the button in the center
	            var addButton = document.createElement("button");
	            addButton.textContent = "Add Passengers";
	            addButton.addEventListener("click", function() {
                 	    resetForm();
                       // Display the add passengers form
	                document.getElementById("editFormContainer").style.display = "block";
	                var userIdInput = document.getElementById("editUserId");
	                userIdInput.value = passenger.user_id;
	            	// Perform action when "Add Passengers" button is clicked
	            });
	            addButtonCell.appendChild(addButton);
	            addButtonRow.appendChild(addButtonCell);

	            // Insert the button row in the middle of the table
	            var rows = tableBody.getElementsByTagName("tr");
	            var middleIndex = Math.floor(rows.length);
	            tableBody.insertBefore(addButtonRow, rows[middleIndex]);
	                  hideBufferingLayer();

	        },
	        error: function(xhr, status, error) {
	            console.error("AJAX request failed: " + status + ", " + error);
	        }
	    });

	    document.getElementById("dashboard2").style.display = "none";
	    document.getElementById("userDetails").style.display = "none";
	    document.getElementById("ticketDetails").style.display = "none";
	    document.getElementById("passengerDetails").style.display = "block";
        document.getElementById("editFormContainer").style.display = "none";

	}
 
 function deletePassenger(userId, name, age, gender) {
	 	  showBufferingLayer(); // Show the spinner before form submission

     document.getElementById("editFormContainer").style.display = "none";

	 var passenger={
      		  "user_id": userId,
                "passenger_name": name,
                "age": age,
                "gender": gender            
        };    
	 
	 
	  var data=JSON.stringify(passenger);
	  console.log(passenger);  
	    $.ajax({
	        url: "deletePassenger", // Replace with the actual URL of your controller method
	        method: "POST",
	        data:data,// Pass the values to the controller method
	        contentType: "application/json",
	        success: function(response) {
	        	 console.log("Passenger deleted successfully");

	             // Show a confirmation popup or alert
	             alert("Passenger deleted successfully");

	             // Refresh the table to display the updated list
	             showPassengers();
	                   hideBufferingLayer();

	        },
	        error: function(xhr, status, error) {
	        	 alert("Passenger not  deleted successfully");
	        	 showPassengers();
	            console.error("AJAX request failed: " + status + ", " + error);
	        }
	    });
	}

 
 
 function submitPassengerDetails(){
	 	  showBufferingLayer(); // Show the spinner before form submission
	  $("#editFormContainer").submit(function(event) {
		  event.preventDefault();
		 
		  
		  var userId = document.getElementById("editUserId").value;
	      var name = document.getElementById("editName").value;
	      var age = document.getElementById("editAge").value;
	      var gender = document.getElementById("editGender").value;
	      
		 // event.preventDefault();
		  //var id= $("#editUserId").val();
        // var name = $("#editName").val();
        // var age = $("#editAge").val();
        // var gender = $("#editGender").val();
         
         var passenger={
       		  "user_id": userId,
                 "passenger_name": name,
                 "age": age,
                 "gender": gender            
         };     
		  var data=JSON.stringify(passenger);
		  console.log(data); 
         
		  $.ajax({
             type: "POST",
             url: "addPassenger",
             data:data, 
             contentType: "application/json",
             success: function(response) {
                 // Handle success respons
                 console.log("passenger details updated successfully!");
                 alert("Passenger added successfully");

	             // Refresh the table to display the updated list
	                   hideBufferingLayer();
	             showPassengers();
                 // Redirect to employee details page or show a success message
                 
	             document.getElementById("editFormContainer").style.display = "none";
             },
             error: function(xhr, status, error) {
	             document.getElementById("editFormContainer").style.display = "none";

                 // Handle error response
 			console.log("Error updating passenger details: " + error);
        alert("Failed to update passenger details");
        showPassengers();
                 // Show an error message or handle the error case
             }
         });
	  });
 }
 
	function resetForm() {
	    document.getElementById("editName").value = "";
	    document.getElementById("editAge").value = "";
	    document.getElementById("editGender").value = ""; // Set a default value
	}
	
	
	function cancelTicket(booking_id,payment_id,total_fare) {
	   

	    var confirmCancel = window.confirm("Are you sure you want to cancel this ticket?");
	    if (confirmCancel) {
			 // Display the confirmation dialog
	    	  showBufferingLayer(); // Show the spinner before form submission
	        $.ajax({
	            url: "cancelTicket", // Replace with the actual URL of your service
	            method: "POST",
	            data: {booking_id: booking_id,payment_id:payment_id,fare:total_fare},
	            success: function(response) {
	                console.log(response);
	                console.log("Ticket Cancelled");

	                alert(booking_id + response + " Ticket Cancelled Successfully");
	                window.location.reload();
	                      hideBufferingLayer();


	            },
	            error: function(xhr, status, error) {
	                console.error("AJAX request failed: " + status + ", " + error);
	                alert("Ticket Cancellation Failed");
	            }
	        });
	    }
	    else{
			document.getElementById('spinner').style.display = 'none';
		}
	}