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

$.ajax({
	    url: "routeCollection", // Replace with the actual URL of your service
	    method: "GET",
	    success: function(response) {
	        console.log(response);
	        var rcs = JSON.parse(response);
	        var chartData = {
	            labels: [],
	            datasets: [{
	                label: 'Route wise Collections',
	                data: [],
	                backgroundColor: []
	            }]
	        };
	        
	        for (var i = 0; i < rcs.length; i++){
	            chartData.labels[i] = rcs[i].route;
	            chartData.datasets[0].data[i] = rcs[i].collection;
	            chartData.datasets[0].backgroundColor[i]="#60c2f0"
	        }
	        var ctx = document.getElementById('routeCollectionChart').getContext('2d');
	        var routeCollectionChart = new Chart(ctx, {
	            type: 'bar',
	            data: chartData
	        });
	        
	        // Use chartData to create a chart here or perform further processing
	        
	    },
	    error: function(xhr, status, error) {
	        console.error("AJAX request failed: " + status + ", " + error);
	    }
	});

	$.ajax({
	    url: "tripCollection", // Replace with the actual URL of your service
	    method: "GET",
	    success: function(response) {
	        console.log(response);
	        var tcs = JSON.parse(response);
	        var chartData = {
	            labels: [],
	            datasets: [{
	                label: 'Trip wise Collections',
	                data: [],
	                backgroundColor: []
	            }]
	        };
	        
	        for (var i = 0; i < tcs.length; i++){
	            chartData.labels[i] = tcs[i].route+" - ("+tcs[i].time+")";
	            chartData.datasets[0].data[i] = tcs[i].collection;
	            chartData.datasets[0].backgroundColor[i]="#60c2f0"
	        }
	        var ctx = document.getElementById('tripCollectionChart').getContext('2d');
	        var tripCollectionChart = new Chart(ctx, {
	            type: 'bar',
	            data: chartData
	        });
	        
	        // Use chartData to create a chart here or perform further processing
	        
	    },
	    error: function(xhr, status, error) {
	        console.error("AJAX request failed: " + status + ", " + error);
	    }
	});
    
	
	$.ajax({
	    url: "monthlyCollection", // Replace with the actual URL of your service
	    method: "GET",
	    success: function(response) {
	        console.log(response);
	        var mcs = JSON.parse(response);
	        var chartData = {
	            labels: [],
	            datasets: [{
	                label: 'Monthly Collections',
	                data: [],
	                backgroundColor: []
	            }]
	        };
	        
	        for (var i = 0; i < mcs.length; i++){
	            chartData.labels[i] = mcs[i].month;
	            chartData.datasets[0].data[i] = mcs[i].collection;
	            chartData.datasets[0].backgroundColor[i]="#60c2f0"
	        }
	        var ctx = document.getElementById('monthlyCollectionChart').getContext('2d');
	        var tripCollectionChart = new Chart(ctx, {
	            type: 'line',
	            data: chartData,
	            
	            
	        });
	        
	        // Use chartData to create a chart here or perform further processing
	        
	    },
	    error: function(xhr, status, error) {
	        console.error("AJAX request failed: " + status + ", " + error);
	    }
	});
    
    
    document.getElementById('ticketAmountFilter').addEventListener('change', function() {
    	  // Function code to be executed when the value of the select changes
    	  var selectedServiceId = this.value;
    	  console.log('Selected Service ID:', selectedServiceId);
    	 
        $.ajax({
        	url: "adminTicketList", // Replace with the actual URL of your service
            method: "GET",
            success: function(response) {
          	  console.log(response);
          	  var payments = JSON.parse(response);
                var tableBody = document.querySelector("#paymentList table tbody");
                tableBody.innerHTML = ""; // Clear existing table rows
                
                // Iterate over the routes and populate the table
                for (var i = 0; i < payments.length; i++) {
                    var payment = payments[i];
                    
                    
                   
                    var row = document.createElement("tr");

                    var cell1 = document.createElement("td");
                    cell1.textContent = payment.booking_id;
                    row.appendChild(cell1);
                    
                    if(selectedServiceId!='Any')
              	  {
              	  	if(document.getElementById('ticketAmountFilter').value<=payment.total_fare){
              	  		continue;
              	  	}
              	  }
                    
                    var cell2 = document.createElement("td");
                    cell2.textContent = payment.payment_id;
                    row.appendChild(cell2);
                    
                    var cell11 = document.createElement("td");
                    cell11.textContent = payment.order_id;
                    row.appendChild(cell11);
                    
                    var cell3 = document.createElement("td");
                    cell3.textContent = payment.user_id;
                    row.appendChild(cell3);
                    
                    var cell4 = document.createElement("td");
                    cell4.textContent = payment.booking_date;
                    row.appendChild(cell4);
                    
                    var cell5 = document.createElement("td");
                    cell5.textContent = payment.booking_time;
                    row.appendChild(cell5);
                    
                    
                    var cell9 = document.createElement("td");
                    cell9.textContent = payment.payment_mode;
                    row.appendChild(cell9);
                    
                    var cell10 = document.createElement("td");
                    cell10.textContent = payment.total_fare;
                    row.appendChild(cell10);
                    
    var actionsCell = document.createElement("td");
                    var viewDetailsButton = document.createElement("button");
                    viewDetailsButton.textContent = "View Details";
                    viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(payment));
                    actionsCell.appendChild(viewDetailsButton);
                    row.appendChild(actionsCell);
                    
                    tableBody.appendChild(row);
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX request failed: " + status + ", " + error);
            }
        });

        document.getElementById("dashboard2").style.display = "none";
        document.getElementById("serviceList").style.display = "none";
        document.getElementById("busList").style.display = "none";
        document.getElementById("routeList").style.display = "none";
        document.getElementById("ticketList").style.display = "none";
        document.getElementById("paymentList").style.display = "block";
        });
    
    
    
    document.getElementById('ticketServiceidFilter').addEventListener('change', function() {
  	  // Function code to be executed when the value of the select changes
  	  var selectedServiceId = this.value;
  	  console.log('Selected Service ID:', selectedServiceId);
  	  
  	  

      $.ajax({
          url: "adminTicketList", // Replace with the actual URL of your service
          method: "GET",
          success: function(response) {
              var tickets = JSON.parse(response);
              var tableBody = document.querySelector("#ticketList table tbody");
              tableBody.innerHTML = ""; // Clear existing table rows
              
              
              // Iterate over the routes and populate the table
              for (var i = 0; i < tickets.length; i++) {
                  var ticket = tickets[i];
                  var row = document.createElement("tr");

                  var cell1 = document.createElement("td");
                  cell1.textContent = ticket.booking_id;
                  row.appendChild(cell1);
                  
                  var cell2 = document.createElement("td");
                  cell2.textContent = ticket.payment_id;
                  row.appendChild(cell2);
                  
                  var cell3 = document.createElement("td");
                  cell3.textContent = ticket.user_id;
                  row.appendChild(cell3);
                  
                  if(selectedServiceId!='Any')
            	  {
            	  	if(selectedServiceId!=ticket.service_id){
            	  		continue;
            	  	}
            	  }
                  
                  var filterOption=document.createElement("option");
                  filterOption.textContent = ticket.service_id;
                  filterOption.value = ticket.service_id;
                  ticketServiceidFilter.appendChild(filterOption);
                  
                  var cell4 = document.createElement("td");
                  cell4.textContent = ticket.travel_date;
                  row.appendChild(cell4);
                  
                  var cell5 = document.createElement("td");
                  cell5.textContent = ticket.departure;
                  row.appendChild(cell5);
                  
                  var cell6 = document.createElement("td");
                  cell6.textContent = ticket.route_id;
                  row.appendChild(cell6);
                  
                  var cell7 = document.createElement("td");
                  cell7.textContent = ticket.trip_id;
                  row.appendChild(cell7);
                  
                  var cell8 = document.createElement("td");
                  cell8.textContent = ticket.service_id;
                  row.appendChild(cell8);
                  
                  var cell9 = document.createElement("td");
                  cell9.textContent = ticket.payment_mode;
                  row.appendChild(cell9);
                  
                  var cell10 = document.createElement("td");
                  cell10.textContent = ticket.total_fare;
                  row.appendChild(cell10);
                  
                  var cell11 = document.createElement("td");
                  cell11.textContent = ticket.status;
                  row.appendChild(cell11);
                  
                  var cell12 = document.createElement("td");
                  cell12.textContent = ticket.no_of_seats_booked;
                  row.appendChild(cell12);
                  
                  
                  
                  var actionsCell = document.createElement("td");
                  var viewDetailsButton = document.createElement("button");
                  viewDetailsButton.textContent = "View Passengers";
                  viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(ticket));
                  actionsCell.appendChild(viewDetailsButton);
                  row.appendChild(actionsCell);
                  
                  tableBody.appendChild(row);
              }
          },
          error: function(xhr, status, error) {
              console.error("AJAX request failed: " + status + ", " + error);
          }
      });

      document.getElementById("dashboard2").style.display = "none";
      document.getElementById("serviceList").style.display = "none";
      document.getElementById("busList").style.display = "none";
      document.getElementById("routeList").style.display = "none";
      document.getElementById("ticketList").style.display = "block";
      document.getElementById("paymentList").style.display = "none";
  	  
  	 });
    
    
    document.getElementById('serviceidFilter').addEventListener('change', function() {
    	  // Function code to be executed when the value of the select changes
    	  var selectedServiceId = this.value;
    	  console.log('Selected Service ID:', selectedServiceId);
    	   $.ajax({
              url: "serviceList", // Replace with the actual URL of your service
              method: "GET",
              success: function(response) {
                  var services = JSON.parse(response);
                  var tableBody = document.querySelector("#serviceList table tbody");
             		 tableBody.innerHTML = ""; // Clear existing table row
             		

                  
                  for (var i = 0; i < services.length; i++) {
                      var service = services[i];
                     
                      
                      if(selectedServiceId!='Any')
                    	  {
                    	  	if(selectedServiceId!=service.service_id){
                    	  		continue;
                    	  	}
                    	  }
                      
                      
                      var row = document.createElement("tr");

                      var serviceIdCell = document.createElement("td");
                      serviceIdCell.textContent = service.service_id;
                      row.appendChild(serviceIdCell);
                      
                      

                      var tripIdCell = document.createElement("td");
                      tripIdCell.textContent = service.trip_id;
                      row.appendChild(tripIdCell);
                      
          
                      var tripDateCell = document.createElement("td");
                      tripDateCell.textContent = new Date(service.trip_date).toLocaleDateString();
                      row.appendChild(tripDateCell);

                      var seatsBookedCell = document.createElement("td");
                      seatsBookedCell.textContent = service.seats_available;
                      row.appendChild(seatsBookedCell);

                      var collectionCell = document.createElement("td");
                      collectionCell.textContent = service.collection;
                      row.appendChild(collectionCell);

                      var viewDetailsCell = document.createElement("td");
                      var viewDetailsButton = document.createElement("button");
                      viewDetailsButton.textContent = "View Details";
                      viewDetailsButton.addEventListener("click", createViewDetailsHandler(service));
                      viewDetailsCell.appendChild(viewDetailsButton);
                      row.appendChild(viewDetailsCell);
                      
                      
                      var passChartCell = document.createElement("td");
                      var passChartButton = document.createElement("button");
                      passChartButton.textContent = "Get Passengers Chart";
                      passChartButton.addEventListener("click", createpassChartHandler(service));
                      passChartCell.appendChild(passChartButton);
                      row.appendChild(passChartCell);

                      tableBody.appendChild(row);
                      
                    
                      
                  }
              },
              error: function(xhr, status, error) {
                  console.error("AJAX request failed: " + status + ", " + error);
              }
          });

          document.getElementById("dashboard2").style.display = "none";
          document.getElementById("serviceList").style.display = "block";
          document.getElementById("busList").style.display = "none";
          document.getElementById("routeList").style.display = "none";
          document.getElementById("ticketList").style.display = "none";
          document.getElementById("paymentList").style.display = "none";
});

    
    
    $(function() {
        $('input[name="paymentDatefilter"]').daterangepicker({
          autoUpdateInput: false,
          locale: {
            cancelLabel: 'Clear'
          }
        });
		
        $('input[name="paymentDatefilter"]').on('cancel.daterangepicker', function(ev, picker) {
            // Clear the selected date range and perform necessary actions
            $(this).val('');
            console.log("Clear button clicked");
            showPayments();
            // ... your code for handling the cancel event
          });
        $('input[name="paymentDatefilter"]').on('apply.daterangepicker', function(ev, picker) {
          var startDate = picker.startDate;
          var endDate = picker.endDate;
          var dates = [];
          var currentDate = startDate.clone();

          while (currentDate.isSameOrBefore(endDate)) {
            dates.push(currentDate.format('MM/DD/YYYY'));
            currentDate.add(1, 'days');
          }
          
           $.ajax({
              url: "adminTicketList", // Replace with the actual URL of your service
              method: "GET",
              success: function(response) {
            	  console.log(response);
            	  var payments = JSON.parse(response);
                  var tableBody = document.querySelector("#paymentList table tbody");
                  tableBody.innerHTML = ""; // Clear existing table rows
                  
                  // Iterate over the routes and populate the table
                  for (var i = 0; i < payments.length; i++) {
                      var payment = payments[i];
                      
                      var comparisonDate = new Date(payment.booking_date).toLocaleDateString(); // Replace with your service trip date
                      var comparisonDateFormatted = moment(comparisonDate).format('MM/DD/YYYY');

                      if (dates.includes(comparisonDateFormatted)) {
                        console.log('Comparison date', comparisonDateFormatted, 'is present in the dates array.');
                      } else {
                        console.log('Comparison date', comparisonDateFormatted, 'is not present in the dates array.');
                        continue;
                      }
                      
                      var row = document.createElement("tr");

                      var cell1 = document.createElement("td");
                      cell1.textContent = payment.booking_id;
                      row.appendChild(cell1);
                      
                      var cell2 = document.createElement("td");
                      cell2.textContent = payment.payment_id;
                      row.appendChild(cell2);
                      
                      var cell11 = document.createElement("td");
                      cell11.textContent = payment.order_id;
                      row.appendChild(cell11);
                      
                      var cell3 = document.createElement("td");
                      cell3.textContent = payment.user_id;
                      row.appendChild(cell3);
                      
                      var cell4 = document.createElement("td");
                      cell4.textContent = payment.booking_date;
                      row.appendChild(cell4);
                      
                      var cell5 = document.createElement("td");
                      cell5.textContent = payment.booking_time;
                      row.appendChild(cell5);
                      
                      
                      var cell9 = document.createElement("td");
                      cell9.textContent = payment.payment_mode;
                      row.appendChild(cell9);
                      
                      var cell10 = document.createElement("td");
                      cell10.textContent = payment.total_fare;
                      row.appendChild(cell10);
                        
                      var actionsCell = document.createElement("td");
                      var viewDetailsButton = document.createElement("button");
                      viewDetailsButton.textContent = "View Details";
                      viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(payment));
                      actionsCell.appendChild(viewDetailsButton);
                      row.appendChild(actionsCell);
                      
                      tableBody.appendChild(row);
                  }
              },
              error: function(xhr, status, error) {
                  console.error("AJAX request failed: " + status + ", " + error);
              }
          });

          document.getElementById("dashboard2").style.display = "none";
          document.getElementById("serviceList").style.display = "none";
          document.getElementById("busList").style.display = "none";
          document.getElementById("routeList").style.display = "none";
          document.getElementById("ticketList").style.display = "none";
          document.getElementById("paymentList").style.display = "block";
          
           console.log(dates);
        });

        $('input[name="ticketDatefilter"]').on('cancel.daterangepicker', function(ev, picker) {
          $(this).val('');
        });
      });
    
      $(function() {
        $('input[name="ticketDatefilter"]').daterangepicker({
          autoUpdateInput: false,
          locale: {
            cancelLabel: 'Clear'
          }
        });
		
        $('input[name="ticketDatefilter"]').on('cancel.daterangepicker', function(ev, picker) {
            // Clear the selected date range and perform necessary actions
            $(this).val('');
            console.log("Clear button clicked");
            showTickets();
            // ... your code for handling the cancel event
          });
        
        
        
        $('input[name="ticketDatefilter"]').on('apply.daterangepicker', function(ev, picker) {
          var startDate = picker.startDate;
          var endDate = picker.endDate;
          var dates = [];
          var currentDate = startDate.clone();

          while (currentDate.isSameOrBefore(endDate)) {
            dates.push(currentDate.format('MM/DD/YYYY'));
            currentDate.add(1, 'days');
          }
          
            $.ajax({
              url: "adminTicketList", // Replace with the actual URL of your service
              method: "GET",
              success: function(response) {
            	  console.log(response);
                  var tickets = JSON.parse(response);
                  var tableBody = document.querySelector("#ticketList table tbody");
                  tableBody.innerHTML = ""; // Clear existing table rows
                  
                  // Iterate over the routes and populate the table
                  for (var i = 0; i < tickets.length; i++) {
                      var ticket = tickets[i];
                      var row = document.createElement("tr");

                      var cell1 = document.createElement("td");
                      cell1.textContent = ticket.booking_id;
                      row.appendChild(cell1);
                      
                      var cell2 = document.createElement("td");
                      cell2.textContent = ticket.payment_id;
                      row.appendChild(cell2);
                      
                      var comparisonDate = new Date(ticket.travel_date).toLocaleDateString(); // Replace with your service trip date
                      var comparisonDateFormatted = moment(comparisonDate).format('MM/DD/YYYY');

                      if (dates.includes(comparisonDateFormatted)) {
                        console.log('Comparison date', comparisonDateFormatted, 'is present in the dates array.');
                      } else {
                        console.log('Comparison date', comparisonDateFormatted, 'is not present in the dates array.');
                        continue;
                      }
                      
                      
                      var cell3 = document.createElement("td");
                      cell3.textContent = ticket.user_id;
                      row.appendChild(cell3);
                      
                      var cell4 = document.createElement("td");
                      cell4.textContent = ticket.travel_date;
                      row.appendChild(cell4);
                      
                      var cell5 = document.createElement("td");
                      cell5.textContent = ticket.departure;
                      row.appendChild(cell5);
                      
                      var cell6 = document.createElement("td");
                      cell6.textContent = ticket.route_id;
                      row.appendChild(cell6);
                      
                      var cell7 = document.createElement("td");
                      cell7.textContent = ticket.trip_id;
                      row.appendChild(cell7);
                      
                      var cell8 = document.createElement("td");
                      cell8.textContent = ticket.service_id;
                      row.appendChild(cell8);
                      
                      var cell9 = document.createElement("td");
                      cell9.textContent = ticket.payment_mode;
                      row.appendChild(cell9);
                      
                      var cell10 = document.createElement("td");
                      cell10.textContent = ticket.total_fare;
                      row.appendChild(cell10);
                      
                      var cell11 = document.createElement("td");
                      cell11.textContent = ticket.status;
                      row.appendChild(cell11);
                      
                      var cell12 = document.createElement("td");
                      cell12.textContent = ticket.no_of_seats_booked;
                      row.appendChild(cell12);
                      
                      
                      
                      var actionsCell = document.createElement("td");
                      var viewDetailsButton = document.createElement("button");
                      viewDetailsButton.textContent = "View Passengers";
                      viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(ticket));
                      actionsCell.appendChild(viewDetailsButton);
                      row.appendChild(actionsCell);
                      
                      tableBody.appendChild(row);
                  }
              },
              error: function(xhr, status, error) {
                  console.error("AJAX request failed: " + status + ", " + error);
              }
          });

          document.getElementById("dashboard2").style.display = "none";
          document.getElementById("serviceList").style.display = "none";
          document.getElementById("busList").style.display = "none";
          document.getElementById("routeList").style.display = "none";
          document.getElementById("ticketList").style.display = "block";
          document.getElementById("paymentList").style.display = "none";
          console.log(dates);
        });

        $('input[name="ticketDatefilter"]').on('cancel.daterangepicker', function(ev, picker) {
          $(this).val('');
        });
      });
    
   $(function() {
        $('input[name="datefilter"]').daterangepicker({
          autoUpdateInput: false,
          locale: {
            cancelLabel: 'Clear'
          }
        });
		
        $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
            // Clear the selected date range and perform necessary actions
            $(this).val('');
            console.log("Clear button clicked");
            showServices();
            // ... your code for handling the cancel event
          });
        
        
        
        $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
          var startDate = picker.startDate;
          var endDate = picker.endDate;
          var dates = [];
          var currentDate = startDate.clone();

          while (currentDate.isSameOrBefore(endDate)) {
            dates.push(currentDate.format('MM/DD/YYYY'));
            currentDate.add(1, 'days');
          }
          
         $.ajax({
              url: "serviceList", // Replace with the actual URL of your service
              method: "GET",
              success: function(response) {
                  var services = JSON.parse(response);
                  var tableBody = document.querySelector("#serviceList table tbody");
             		 tableBody.innerHTML = ""; // Clear existing table row
                for (var i = 0; i < services.length; i++) {
                      var service = services[i];
                     
                      
                      var row = document.createElement("tr");

                      var serviceIdCell = document.createElement("td");
                      serviceIdCell.textContent = service.service_id;
                      row.appendChild(serviceIdCell);
                      
                     
                      var tripIdCell = document.createElement("td");
                      tripIdCell.textContent = service.trip_id;
                      row.appendChild(tripIdCell);
                      
                      
                      var comparisonDate = new Date(service.trip_date).toLocaleDateString(); // Replace with your service trip date
                      var comparisonDateFormatted = moment(comparisonDate).format('MM/DD/YYYY');

                      if (dates.includes(comparisonDateFormatted)) {
                        console.log('Comparison date', comparisonDateFormatted, 'is present in the dates array.');
                      } else {
                        console.log('Comparison date', comparisonDateFormatted, 'is not present in the dates array.');
                        continue;
                      }

                      var tripDateCell = document.createElement("td");
                      tripDateCell.textContent = new Date(service.trip_date).toLocaleDateString();
                      row.appendChild(tripDateCell);

                      var seatsBookedCell = document.createElement("td");
                      seatsBookedCell.textContent = service.seats_available;
                      row.appendChild(seatsBookedCell);

                      var collectionCell = document.createElement("td");
                      collectionCell.textContent = service.collection;
                      row.appendChild(collectionCell);

                      var viewDetailsCell = document.createElement("td");
                      var viewDetailsButton = document.createElement("button");
                      viewDetailsButton.textContent = "View Details";
                      viewDetailsButton.addEventListener("click", createViewDetailsHandler(service));
                      viewDetailsCell.appendChild(viewDetailsButton);
                      row.appendChild(viewDetailsCell);
                      
                      
                      var passChartCell = document.createElement("td");
                      var passChartButton = document.createElement("button");
                      passChartButton.textContent = "Get Passengers Chart";
                      passChartButton.addEventListener("click", createpassChartHandler(service));
                      passChartCell.appendChild(passChartButton);
                      row.appendChild(passChartCell);

                      tableBody.appendChild(row);
                      
                    
                      
                  }
              },
              error: function(xhr, status, error) {
                  console.error("AJAX request failed: " + status + ", " + error);
              }
          });

          document.getElementById("dashboard2").style.display = "none";
          document.getElementById("serviceList").style.display = "block";
          document.getElementById("busList").style.display = "none";
          document.getElementById("routeList").style.display = "none";
          document.getElementById("ticketList").style.display = "none";
          document.getElementById("paymentList").style.display = "none";
 console.log(dates);
        });

        $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
          $(this).val('');
        });
      });
    
    
        function showDashboard() {
            document.getElementById("dashboard2").style.display = "grid";
            document.getElementById("serviceList").style.display = "none";
            document.getElementById("busList").style.display = "none";
            document.getElementById("routeList").style.display = "none";
            document.getElementById("ticketList").style.display = "none";
            document.getElementById("paymentList").style.display = "none";
            
            
        }
        
        function showPayments() {
            $.ajax({
                url: "adminTicketList", // Replace with the actual URL of your service
                method: "GET",
                success: function(response) {
                    var payments = JSON.parse(response);
                    var tableBody = document.querySelector("#paymentList table tbody");
                    tableBody.innerHTML = ""; // Clear existing table rows
                    
                    // Iterate over the routes and populate the table
                    for (var i = 0; i < payments.length; i++) {
                        var payment = payments[i];
                        var row = document.createElement("tr");

                        var cell1 = document.createElement("td");
                        cell1.textContent = payment.booking_id;
                        row.appendChild(cell1);
                        
                        var cell2 = document.createElement("td");
                        cell2.textContent = payment.payment_id;
                        row.appendChild(cell2);
                        
                        var cell11 = document.createElement("td");
                        cell11.textContent = payment.order_id;
                        row.appendChild(cell11);
                        
                        var cell3 = document.createElement("td");
                        cell3.textContent = payment.user_id;
                        row.appendChild(cell3);
                        
                        var cell4 = document.createElement("td");
                        cell4.textContent = payment.booking_date;
                        row.appendChild(cell4);
                        
                        var cell5 = document.createElement("td");
                        cell5.textContent = payment.booking_time;
                        row.appendChild(cell5);
                        
                        
                        var cell9 = document.createElement("td");
                        cell9.textContent = payment.payment_mode;
                        row.appendChild(cell9);
                        
                        var cell10 = document.createElement("td");
                        cell10.textContent = payment.total_fare;
                        row.appendChild(cell10);
                        

                        
                        
                        
                        var actionsCell = document.createElement("td");
                        var viewDetailsButton = document.createElement("button");
                        viewDetailsButton.textContent = "View Details";
                        viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(payment));
                        actionsCell.appendChild(viewDetailsButton);
                        row.appendChild(actionsCell);
                        
                        tableBody.appendChild(row);
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX request failed: " + status + ", " + error);
                }
            });

            document.getElementById("dashboard2").style.display = "none";
            document.getElementById("serviceList").style.display = "none";
            document.getElementById("busList").style.display = "none";
            document.getElementById("routeList").style.display = "none";
            document.getElementById("ticketList").style.display = "none";
            document.getElementById("paymentList").style.display = "block";
        }
        
        
        function showTickets() {
            $.ajax({
                url: "adminTicketList", // Replace with the actual URL of your service
                method: "GET",
                success: function(response) {
                    var tickets = JSON.parse(response);
                    var tableBody = document.querySelector("#ticketList table tbody");
                    tableBody.innerHTML = ""; // Clear existing table rows
                    
                    var ticketServiceidFilter = document.getElementById('ticketServiceidFilter');
                    ticketServiceidFilter.innerHTML="";
                    
                    var filterOption=document.createElement("option");
                    filterOption.textContent = "Any";
                    filterOption.value = "Any";
                    ticketServiceidFilter.appendChild(filterOption);
                    
                    
                    
                    
                    // Iterate over the routes and populate the table
                    for (var i = 0; i < tickets.length; i++) {
                        var ticket = tickets[i];
                        var row = document.createElement("tr");

                        var cell1 = document.createElement("td");
                        cell1.textContent = ticket.booking_id;
                        row.appendChild(cell1);
                        
                        var cell2 = document.createElement("td");
                        cell2.textContent = ticket.payment_id;
                        row.appendChild(cell2);
                        
                        var cell3 = document.createElement("td");
                        cell3.textContent = ticket.user_id;
                        row.appendChild(cell3);
                        
                        
                        var filterOption=document.createElement("option");
                        filterOption.textContent = ticket.service_id;
                        filterOption.value = ticket.service_id;
                        ticketServiceidFilter.appendChild(filterOption);
                        
                        var cell4 = document.createElement("td");
                        cell4.textContent = ticket.travel_date;
                        row.appendChild(cell4);
                        
                        var cell5 = document.createElement("td");
                        cell5.textContent = ticket.departure;
                        row.appendChild(cell5);
                        
                        var cell6 = document.createElement("td");
                        cell6.textContent = ticket.route_id;
                        row.appendChild(cell6);
                        
                        var cell7 = document.createElement("td");
                        cell7.textContent = ticket.trip_id;
                        row.appendChild(cell7);
                        
                        var cell8 = document.createElement("td");
                        cell8.textContent = ticket.service_id;
                        row.appendChild(cell8);
                        
                        var cell9 = document.createElement("td");
                        cell9.textContent = ticket.payment_mode;
                        row.appendChild(cell9);
                        
                        var cell10 = document.createElement("td");
                        cell10.textContent = ticket.total_fare;
                        row.appendChild(cell10);
                        
                        var cell11 = document.createElement("td");
                        cell11.textContent = ticket.status;
                        row.appendChild(cell11);
                        
                        var cell12 = document.createElement("td");
                        cell12.textContent = ticket.no_of_seats_booked;
                        row.appendChild(cell12);
                        
                        
                        
                        var actionsCell = document.createElement("td");
                        var viewDetailsButton = document.createElement("button");
                        viewDetailsButton.textContent = "View Passengers";
                        viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(ticket));
                        actionsCell.appendChild(viewDetailsButton);
                        row.appendChild(actionsCell);
                        
                        tableBody.appendChild(row);
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX request failed: " + status + ", " + error);
                }
            });

            document.getElementById("dashboard2").style.display = "none";
            document.getElementById("serviceList").style.display = "none";
            document.getElementById("busList").style.display = "none";
            document.getElementById("routeList").style.display = "none";
            document.getElementById("ticketList").style.display = "block";
            document.getElementById("paymentList").style.display = "none";
        }
         function createViewTicketDetailsHandler(routeNumber,source,destination) {
            return function() {
                // AJAX call to retrieve route details
                $.ajax({
                    url: "viewRouteDetails", // Replace with the actual URL of your controller endpoint
                    method: "GET",
                    data: { routeNumber: routeNumber },
                    success: function(response) {
                        // Handle the success response from the controller
                        console.log("Route details retrieved successfully:", response);
                        
                        // Process the retrieved route details as needed
                        
                        // Get the necessary data from the response and populate the popup content
                        var routePopupContent = document.getElementById("routePopupContent");
                        var routeNumberElement = document.getElementById("routeNumber");
                        var routeSourceElement = document.getElementById("routeSource");
                        var routeDestinationElement = document.getElementById("routeDestination");
                        var stopsTable = routePopupContent.querySelector("table");
                        
                        // Clear existing stops from the table
                        stopsTable.innerHTML = "";
                        
                        // Set the route number value
                        routeNumberElement.textContent = routeNumber;
                        var row = document.createElement("tr");
                        var routeNumberCell = document.createElement("td");
                        routeNumberCell.textContent = "Route: ";
                        row.appendChild(routeNumberCell);
                        stopsTable.appendChild(row);
                        
                        var routeNumberCell2 = document.createElement("td");
                        routeNumberCell2.textContent = routeNumber;
                        row.appendChild(routeNumberCell2);
                        stopsTable.appendChild(row);
                        
                        
                        var row = document.createElement("tr");
                        var sourceCell = document.createElement("td");
                        sourceCell.textContent = "Source: ";
                        row.appendChild(sourceCell);
                        stopsTable.appendChild(row);
                        
                        var sourceCell2 = document.createElement("td");
                        sourceCell2.textContent = source;
                        row.appendChild(sourceCell2);
                        stopsTable.appendChild(row);
                        
                        var row = document.createElement("tr");
                        var destinationCell = document.createElement("td");
                        destinationCell.textContent = "Destination: ";
                        row.appendChild(destinationCell);
                        stopsTable.appendChild(row);
                        
                        var destinationCell2 = document.createElement("td");
                        destinationCell2.textContent = destination;
                        row.appendChild(destinationCell2);
                        stopsTable.appendChild(row);
                        
                        
                        // Show the popup content
                        routePopupContent.style.display = "block";
                        
                        // Iterate over the stops in the response and populate the stops table
                        var stops = JSON.parse(response);
                        for (var i = 0; i < stops.length; i++) {
                            var stop = stops[i];
                            var row = document.createElement("tr");
                            
                            var stopNumberCell = document.createElement("td");
                            stopNumberCell.textContent = "Stop " + (i + 1);
                            row.appendChild(stopNumberCell);
                            
                            var stopNameCell = document.createElement("td");
                            stopNameCell.textContent = stop.stop_name;
                            row.appendChild(stopNameCell);
                            
                            stopsTable.appendChild(row);
                        }
                        
                        var popup = document.createElement("div");
                        popup.classList.add("popup");
                        var content = routePopupContent.cloneNode(true);
                        content.style.display = "block";
                        popup.appendChild(content);
                        
                        // Append the popup to the body
                        document.body.appendChild(popup);
                        
                        // Close the popup when clicked outside of it
                        
                        popup.addEventListener("click", function(event) {
                            if (event.target === popup) {
                                popup.remove();
                                routePopupContent.style.display = "none";
                            }
                        });
                    },

                    error: function(xhr, status, error) {
                        // Handle the error response from the controller
                        console.error("AJAX request failed: " + status + ", " + error);
                    }
                });
            };
        }
		   function showRoutes() {
            $.ajax({
                url: "routeList", // Replace with the actual URL of your service
                method: "GET",
                success: function(response) {
                    var routes = JSON.parse(response);
                    var tableBody = document.querySelector("#routeList table tbody");
                    tableBody.innerHTML = ""; // Clear existing table rows
                    
                    // Iterate over the routes and populate the table
                    for (var i = 0; i < routes.length; i++) {
                        var route = routes[i];
                        var row = document.createElement("tr");

                        var routeIdCell = document.createElement("td");
                        routeIdCell.textContent = route.route_id;
                        row.appendChild(routeIdCell);
                        
                        var sourceCell = document.createElement("td");
                        sourceCell.textContent = route.source;
                        row.appendChild(sourceCell);
                        
                        var destinationCell = document.createElement("td");
                        destinationCell.textContent = route.destination;
                        row.appendChild(destinationCell);
                        
                        var actionsCell = document.createElement("td");
                        var viewDetailsButton = document.createElement("button");
                        viewDetailsButton.textContent = "View Details";
                        viewDetailsButton.addEventListener("click", createViewRouteDetailsHandler(route.route_id,route.source,route.destination));
                        actionsCell.appendChild(viewDetailsButton);
                        row.appendChild(actionsCell);
                        
                        tableBody.appendChild(row);
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX request failed: " + status + ", " + error);
                }
            });

            document.getElementById("dashboard2").style.display = "none";
            document.getElementById("serviceList").style.display = "none";
            document.getElementById("busList").style.display = "none";
            document.getElementById("routeList").style.display = "block";
            document.getElementById("ticketList").style.display = "none";
            document.getElementById("paymentList").style.display = "none";
        }

        function createViewRouteDetailsHandler(routeNumber,source,destination) {
            return function() {
                // AJAX call to retrieve route details
                $.ajax({
                    url: "viewRouteDetails", // Replace with the actual URL of your controller endpoint
                    method: "GET",
                    data: { routeNumber: routeNumber },
                    success: function(response) {
                        // Handle the success response from the controller
                        console.log("Route details retrieved successfully:", response);
                        
                        // Process the retrieved route details as needed
                        
                        // Get the necessary data from the response and populate the popup content
                        var routePopupContent = document.getElementById("routePopupContent");
                        var routeNumberElement = document.getElementById("routeNumber");
                        var routeSourceElement = document.getElementById("routeSource");
                        var routeDestinationElement = document.getElementById("routeDestination");
                        var stopsTable = routePopupContent.querySelector("table");
                        
                        // Clear existing stops from the table
                        stopsTable.innerHTML = "";
                        
                        // Set the route number value
                        routeNumberElement.textContent = routeNumber;
                        var row = document.createElement("tr");
                        var routeNumberCell = document.createElement("td");
                        routeNumberCell.textContent = "Route: ";
                        row.appendChild(routeNumberCell);
                        stopsTable.appendChild(row);
                        
                        var routeNumberCell2 = document.createElement("td");
                        routeNumberCell2.textContent = routeNumber;
                        row.appendChild(routeNumberCell2);
                        stopsTable.appendChild(row);
                        
                        
                        var row = document.createElement("tr");
                        var sourceCell = document.createElement("td");
                        sourceCell.textContent = "Source: ";
                        row.appendChild(sourceCell);
                        stopsTable.appendChild(row);
                        
                        var sourceCell2 = document.createElement("td");
                        sourceCell2.textContent = source;
                        row.appendChild(sourceCell2);
                        stopsTable.appendChild(row);
                        
                        var row = document.createElement("tr");
                        var destinationCell = document.createElement("td");
                        destinationCell.textContent = "Destination: ";
                        row.appendChild(destinationCell);
                        stopsTable.appendChild(row);
                        
                        var destinationCell2 = document.createElement("td");
                        destinationCell2.textContent = destination;
                        row.appendChild(destinationCell2);
                        stopsTable.appendChild(row);
                        
                        
                        // Show the popup content
                        routePopupContent.style.display = "block";
                        
                        // Iterate over the stops in the response and populate the stops table
                        var stops = JSON.parse(response);
                        for (var i = 0; i < stops.length; i++) {
                            var stop = stops[i];
                            var row = document.createElement("tr");
                            
                            var stopNumberCell = document.createElement("td");
                            stopNumberCell.textContent = "Stop " + (i + 1);
                            row.appendChild(stopNumberCell);
                            
                            var stopNameCell = document.createElement("td");
                            stopNameCell.textContent = stop.stop_name;
                            row.appendChild(stopNameCell);
                            
                            stopsTable.appendChild(row);
                        }
                        
                        var popup = document.createElement("div");
                        popup.classList.add("popup");
                        var content = routePopupContent.cloneNode(true);
                        content.style.display = "block";
                        popup.appendChild(content);
                        
                        // Append the popup to the body
                        document.body.appendChild(popup);
                        
                        // Close the popup when clicked outside of it
                        
                        popup.addEventListener("click", function(event) {
                            if (event.target === popup) {
                                popup.remove();
                                routePopupContent.style.display = "none";
                            }
                        });
                    },

                    error: function(xhr, status, error) {
                        // Handle the error response from the controller
                        console.error("AJAX request failed: " + status + ", " + error);
                    }
                });
            };
        }
 // Assuming you have a date input field with the id "selectedDate"
        var selectedDate = document.getElementById("selectedDate").value;

        $.ajax({
          url: "serviceListByDate", // Replace with the actual URL of your controller endpoint
          method: "GET",
          data: { date: selectedDate },
          success: function(response) {
            // Handle the success response from the controller
            console.log("Service details retrieved successfully:", response);

            // Process the retrieved service details as needed
            var services = JSON.parse(response);
            // Display the service details on the page
            // ...
          },
          error: function(xhr, status, error) {
            // Handle the error response from the controller
            console.error("AJAX request failed: " + status + ", " + error);
          }
        });
		function showServices() {
            $.ajax({
                url: "serviceList", // Replace with the actual URL of your service
                method: "GET",
                success: function(response) {
                    var services = JSON.parse(response);
                    var tableBody = document.querySelector("#serviceList table tbody");
               		 tableBody.innerHTML = ""; // Clear existing table row
               		 
                    // Iterate over the services and populate the table
                    var serviceFilter = document.getElementById('serviceidFilter');
               		 serviceFilter.innerHTML="";
               		 
               		var filterOption=document.createElement("option");
                    filterOption.textContent = "Any";
                    filterOption.value = "Any";
                    serviceFilter.appendChild(filterOption);

                    
                    for (var i = 0; i < services.length; i++) {
                        var service = services[i];
                       
                        
                        var row = document.createElement("tr");

                        var serviceIdCell = document.createElement("td");
                        serviceIdCell.textContent = service.service_id;
                        row.appendChild(serviceIdCell);
                        
                        var filterOption=document.createElement("option");
                        filterOption.textContent = service.service_id;
                        filterOption.value = service.service_id;
                        serviceFilter.appendChild(filterOption);

                        var tripIdCell = document.createElement("td");
                        tripIdCell.textContent = service.trip_id;
                        row.appendChild(tripIdCell);

                        var tripDateCell = document.createElement("td");
                        tripDateCell.textContent = new Date(service.trip_date).toLocaleDateString();
                        row.appendChild(tripDateCell);

                        var seatsBookedCell = document.createElement("td");
                        seatsBookedCell.textContent = service.seats_available;
                        row.appendChild(seatsBookedCell);

                        var collectionCell = document.createElement("td");
                        collectionCell.textContent = service.collection;
                        row.appendChild(collectionCell);

                        var viewDetailsCell = document.createElement("td");
                        var viewDetailsButton = document.createElement("button");
                        viewDetailsButton.textContent = "View Details";
                        viewDetailsButton.addEventListener("click", createViewDetailsHandler(service));
                        viewDetailsCell.appendChild(viewDetailsButton);
                        row.appendChild(viewDetailsCell);
                        
                        
                        var passChartCell = document.createElement("td");
                        var passChartButton = document.createElement("button");
                        passChartButton.textContent = "Get Passengers Chart";
                        passChartButton.addEventListener("click", createpassChartHandler(service));
                        passChartCell.appendChild(passChartButton);
                        row.appendChild(passChartCell);

                        tableBody.appendChild(row);
                        
                      
                        
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX request failed: " + status + ", " + error);
                }
            });

            document.getElementById("dashboard2").style.display = "none";
            document.getElementById("serviceList").style.display = "block";
            document.getElementById("busList").style.display = "none";
            document.getElementById("routeList").style.display = "none";
            document.getElementById("ticketList").style.display = "none";
            document.getElementById("paymentList").style.display = "none";
        }

        function createpassChartHandler(service){
        	return function() {
                $.ajax({
                    url: "viewServicePassengerDetails", // Replace with the actual URL of your controller endpoint
                    method: "GET",
                    data: { serviceId: service.service_id },
                    success: function(response) {
                        // Handle the success response from the controller
                        console.log("Service details retrieved successfully:", response);
                        
                        // Process the retrieved service details as needed
                        var popupContent = document.getElementById("servicePassengerPopupContent");
                        
                        // Parse the JSON response
                        var pass = JSON.parse(response);
                        
                        // Set the values in the popup content
                        document.getElementById("sid").value = pass[0].serviceId;
                        var tableBody2 = document.querySelector("#servicePassengerPopupContent table tbody");
                        tableBody2.innerHTML="";
                        
                        
                        // Iterate over the routes and populate the table
                        for (var i = 0; i < pass.length; i++) {
                            var passenger = pass[i];
                            document.getElementById("sid").value = passenger.serviceId;
                            var row = document.createElement("tr");

                            var bookingIdCell = document.createElement("td");
                            bookingIdCell.textContent = passenger.booking_id;
                            row.appendChild(bookingIdCell);
                            
                            var seatNoCell = document.createElement("td");
                            seatNoCell.textContent = passenger.seat_no;
                            row.appendChild(seatNoCell);
                            
                            var nameCell = document.createElement("td");
                            nameCell.textContent = passenger.passenger_name;
                            row.appendChild(nameCell);
                            
                            var ageCell = document.createElement("td");
                            ageCell.textContent = passenger.age;
                            row.appendChild(ageCell);
                            
                            var genderCell = document.createElement("td");
                            genderCell.textContent = passenger.gender;
                            row.appendChild(genderCell);
                            
                            
                            
                            tableBody2.appendChild(row);
                        }

                        // Show the popup content
                        popupContent.style.display = "block";
                        
                        // Create a popup element
                        var popup = document.createElement("div");
                        popup.classList.add("popup");
                        
                        // Clone the popup content and append it to the popup element
                        var content = popupContent.cloneNode(true);
                        content.style.display = "block";
                        popup.appendChild(content);
                        
                        // Append the popup to the body
                        document.body.appendChild(popup);
                        
                        // Close the popup when clicked outside of it
                        popup.addEventListener("click", function(event) {
                            if (event.target === popup) {
                                popup.remove();
                                popupContent.style.display = "none";
                            }
                        });
                    },
                    error: function(xhr, status, error) {
                        // Handle the error response from the controller
                        console.error("AJAX request failed: " + status + ", " + error);
                    }
                });
            };

        }
        
        
        function createViewDetailsHandler(service) {
            return function() {
                $.ajax({
                    url: "viewServiceDetails", // Replace with the actual URL of your controller endpoint
                    method: "GET",
                    data: { serviceId: service.service_id },
                    success: function(response) {
                        // Handle the success response from the controller
                        console.log("Service details retrieved successfully:", response);
                        
                        // Process the retrieved service details as needed
                        var popupContent = document.getElementById("popupContent");
                        
                        // Parse the JSON response
                        var serv = JSON.parse(response);
                        
                        // Set the values in the popup content
                        document.getElementById("serviceId").textContent = serv.serviceId;
                        document.getElementById("source").textContent = serv.source;
                        document.getElementById("destination").textContent = serv.destination;
                        document.getElementById("departure").textContent = serv.departure;
                        document.getElementById("arrival").textContent = serv.arrival;
                        document.getElementById("tripDate").textContent = serv.tripDate;
                        document.getElementById("busType").textContent = serv.busType;
                        document.getElementById("routeId").textContent = serv.routeId;
                        document.getElementById("collection").textContent = serv.collection;
                        document.getElementById("seatsAvailable").textContent = serv.seatsAvailable;
                        document.getElementById("seatsBooked").textContent = serv.seatsBooked;
                        document.getElementById("busTypeTitle").textContent = serv.busTypeTitle;
                        document.getElementById("busTypeDescription").textContent = serv.busTypeDescription;
                        
                        // Show the popup content
                        popupContent.style.display = "block";
                        
                        // Create a popup element
                        var popup = document.createElement("div");
                        popup.classList.add("popup");
                        
                        // Clone the popup content and append it to the popup element
                        var content = popupContent.cloneNode(true);
                        content.style.display = "block";
                        popup.appendChild(content);
                        
                        // Append the popup to the body
                        document.body.appendChild(popup);
                        
                        // Close the popup when clicked outside of it
                        popup.addEventListener("click", function(event) {
                            if (event.target === popup) {
                                popup.remove();
                                popupContent.style.display = "none";
                            }
                        });
                    },
                    error: function(xhr, status, error) {
                        // Handle the error response from the controller
                        console.error("AJAX request failed: " + status + ", " + error);
                    }
                });
            };
        }






        function showBuses() {
            $.ajax({
                url: "busList", // Replace with the actual URL of your service
                method: "GET",
                success: function(response) {
                    var buses = JSON.parse(response);
                    var tableBody = document.querySelector("#busList table tbody");
                    tableBody.innerHTML = ""; // Clear existing table rows
                    
                    // Iterate over the services and populate the table
                    for (var i = 0; i < buses.length; i++) {
                        var bus = buses[i];
                        var row = document.createElement("tr");

                        var busIdCell = document.createElement("td");
                        busIdCell.textContent = bus.bus_id;
                        row.appendChild(busIdCell);
                        
                        
                        var regnoCell = document.createElement("td");
                        regnoCell.textContent = bus.regno;
                        row.appendChild(regnoCell);
                        
                        
                        var typeIdCell = document.createElement("td");
                        typeIdCell.textContent = bus.type_id;
                        row.appendChild(typeIdCell);
                        
                        
                        var seatCell = document.createElement("td");
                        seatCell.textContent = bus.bus_no_seats;
                        row.appendChild(seatCell);
                        
                        
                        var statusCell = document.createElement("td");
                        statusCell.textContent = bus.bus_status;
                        row.appendChild(statusCell);
                        

                        tableBody.appendChild(row);
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX request failed: " + status + ", " + error);
                }
            });
            document.getElementById("dashboard2").style.display = "none";
            document.getElementById("serviceList").style.display = "none";
            document.getElementById("busList").style.display = "block";
            document.getElementById("routeList").style.display = "none";
            document.getElementById("ticketList").style.display = "none";
            document.getElementById("paymentList").style.display = "none";
        }

        $(document).ready(function() {
            // Attach datepicker to the "datepicker" input field
            $("#datepicker").datepicker({
                dateFormat: "yy-mm-dd", // Set the desired date format
                onSelect: function(dateText, inst) {
                    // Make an AJAX request with the selected date as a parameter
                    $.ajax({
                        url: "ticketList",
                        method: "GET",
                        data: {
                            selectedDate: dateText
                        },
                        success: function(response) {
                            var tickets = JSON.parse(response);
                            // Populate the table with the filtered tickets
                            // ...
                        },
                        error: function(xhr, status, error) {
                            console.error("AJAX request failed: " + status + ", " + error);
                        }
                    });
                }
            });
        });
