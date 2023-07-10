 var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");

    // Define the center point of the canvas
    var centerX = canvas.width / 2;
    var centerY = canvas.height / 2;

    // Define the outer radius of the steering wheel
    var outerRadius = 20;
    var innerRadius = 15;

    // Define colors
    var backgroundColor = "#f2f2f2";
    var spokeColor = "#000000";

    // Draw the inner circle
    ctx.beginPath();
    ctx.arc(centerX, centerY, innerRadius, 0, 2 * Math.PI);
    ctx.fillStyle = backgroundColor;
    ctx.fill();
    ctx.lineWidth = 2;
    ctx.strokeStyle = spokeColor;
    ctx.stroke();

    // Draw the spokes of the steering wheel
    var numSpokes = 3;
    var angle = (2 * Math.PI) / numSpokes;

    for (var i = 0; i < numSpokes; i++) {
      ctx.save();
      ctx.translate(centerX, centerY);
      ctx.rotate(i * angle);

      ctx.beginPath();
      ctx.moveTo(0, 0);
      ctx.lineTo(innerRadius, 0);
      ctx.lineWidth = 3;
      ctx.strokeStyle = spokeColor;
      ctx.stroke();

      ctx.restore();
    }


 window.onpageshow = function(event) {
	  if (event.persisted) {
	    // Reload the current page
	    location.reload();
	  }
	};
  
  
  $(document).ready(function() {
	  

	  
  	    var maxSeats = 5; // Maximum number of seats allowed
	    var seats_selected_count = 0;
	    var selected_seats = {};

	    
	    var seatStatusData = getSeatStatusJson();
	    disableSeats(seatStatusData);
	    // Add event listener to each bus seat
	    $('.bus-seat').click(function() {
	        // Check if the maximum seat count has been reached
	        if (seats_selected_count >= maxSeats && !$(this).hasClass('selected')) {
	            showPopup("You can choose "+maxSeats+" seats only");
	            return; // Exit the function if the maximum count is reached and the seat is not selected
	        }

	        // Check if the seat is disabled
	        if ($(this).hasClass('disabled')) {
	            showPopup("This seat is not available");
	            return; // Exit the function if the seat is disabled
	        }

	        // Toggle selected class on seat click
	        $(this).toggleClass('selected');

	        var seatId = $(this).attr('id');
	        if ($(this).hasClass('selected')) {
	            // Increment count and add seat to selected_seats object
	            seats_selected_count++;
	            var fareDiv = document.getElementById('fareTable');
	            var trElement = document.createElement('tr');

	            var td1 = document.createElement('td');
	            td1.textContent =seatId ;

	            var td2 = document.createElement('td');
	            var sf=document.getElementById('sf').textContent;
	            var sfInt = parseInt(sf);
	            td2.textContent = sfInt;
	            trElement.appendChild(td1);
	            trElement.appendChild(td2);
	            fareDiv.appendChild(trElement);
	            var tf=document.getElementById('tf').textContent;
	            var tfInt=parseInt(tf);
	            tfInt=tfInt+sfInt;
	            tfstr=tfInt.toString();
	            console.log("Hello tfstr "+tfstr);
	            document.getElementById('tf').textContent=tfstr;
	            
	            
	            
	            if ($(this).css('background-color') === 'rgb(255, 192, 203)') {
	            	selected_seats[seatId] = "Female";
	              }
	            else
	            	{
		            selected_seats[seatId] = "Any";
	            	}  
	            console.log("seat selected");
	        } else {
	            // Decrement count and remove seat from selected_seats object
	            seats_selected_count--;
	            var fareDiv = document.getElementById('fare');
	            var table = fareDiv.querySelector('table');
	            var rowsToDelete = table.querySelectorAll("tr td:first-child");
	            var rowFare;
	            for (var i = 0; i < rowsToDelete.length; i++) {
	              if (rowsToDelete[i].textContent === seatId) {
	                var row = rowsToDelete[i].parentNode;
	                
	                
	                var fareCell = row.querySelector("td:last-child");
	                var sf=fareCell.textContent;
	                var sfInt = parseInt(sf);
	                var tf=document.getElementById('tf').textContent;
		            var tfInt=parseInt(tf);
		            tfInt=tfInt-sfInt;
		            tfstr=tfInt.toString();
		            console.log("Hello tfstr "+tfstr);
		            document.getElementById('tf').textContent=tfstr;
		            
	                row.parentNode.removeChild(row);
	              }
	            }
	            delete selected_seats[seatId];
	            console.log("seat de-selected");

	        }

	        // Output selected seat count and seat data in JSON format
	        console.log('Seats selected:', seats_selected_count);
	        console.log('Selected seats:', JSON.stringify(selected_seats));
	    });

	    $('.bus-seat1').click(function() {
	        // Check if the maximum seat count has been reached
	        if (seats_selected_count >= maxSeats && !$(this).hasClass('selected')) {
	            showPopup("You can choose "+maxSeats+" seats only");
	            return; // Exit the function if the maximum count is reached and the seat is not selected
	        }

	        // Check if the seat is disabled
	        if ($(this).hasClass('disabled')) {
	            showPopup("This seat is not available");
	            return; // Exit the function if the seat is disabled
	        }

	        // Toggle selected class on seat click
	        $(this).toggleClass('selected');

	        var seatId = $(this).attr('id');
	        if ($(this).hasClass('selected')) {
	        	seats_selected_count++;
	        	var fareDiv = document.getElementById('fareTable');
	            var trElement = document.createElement('tr');

	            var td1 = document.createElement('td');
	            td1.textContent =seatId ;

	            var td2 = document.createElement('td');
	            var bf=document.getElementById('bf').textContent;
	            var bfInt = parseInt(bf);
	            td2.textContent = bfInt;
	            
	            var tf=document.getElementById('tf').textContent;
	            var tfInt=parseInt(tf);
	            tfInt=tfInt+bfInt;
	            tfstr=tfInt.toString();
	            console.log("Hello tfstr "+tfstr);
	            document.getElementById('tf').textContent=tfstr;
	            
	            
	            
	            

	            trElement.appendChild(td1);
	            trElement.appendChild(td2);

	            fareDiv.appendChild(trElement);
	            // Increment count and add seat to selected_seats object
	        	if ($(this).css('background-color') === 'rgb(255, 192, 203)') {
	            	selected_seats[seatId] = "Female";
	              }
	            else
	            	{
		            selected_seats[seatId] = "Any";
	            	}  
	            console.log("seat selected");
	            

	            
	            
	        } else {
	            // Decrement count and remove seat from selected_seats object
	            seats_selected_count--;
	            var fareDiv = document.getElementById('fare');
	            var table = fareDiv.querySelector('table');
	            var rowsToDelete = table.querySelectorAll("tr td:first-child");
	            
	            var rowFare;

	            for (var i = 0; i < rowsToDelete.length; i++) {
	              if (rowsToDelete[i].textContent === seatId) {
	                var row = rowsToDelete[i].parentNode;
	                
	                var fareCell = row.querySelector("td:last-child");
	                var bf=fareCell.textContent;
	                var bfInt = parseInt(bf);
	                var tf=document.getElementById('tf').textContent;
		            var tfInt=parseInt(tf);
		            tfInt=tfInt-bfInt;
		            tfstr=tfInt.toString();
		            console.log("Hello tfstr "+tfstr);
		            document.getElementById('tf').textContent=tfstr;
	                
	                row.parentNode.removeChild(row);
	              }
	            }
	            delete selected_seats[seatId];
	            console.log("seat de-selected");

	        }

	        // Output selected seat count and seat data in JSON format
	        console.log('Seats selected:', seats_selected_count);
	        console.log('Selected seats:', JSON.stringify(selected_seats));
	    });

	    // Function to show the popup message
	    function showPopup(message) {
	        alert(message);
	    } 
  function disableSeats(seats) {
      for (var i = 0; i < seats.length; i++) {
          var seatId = seats[i].seat_id;
          var status = seats[i].status;
          var gender = seats[i].gender;

          var seatElement = $('#' + seatId);

          // Check seat status and gender to determine blocking and color
          if (status) {
        	  console.log("Executing..1");
              if (gender === 'Male' || gender==='Other') {
            	  console.log("Executing..2");

                  seatElement.addClass('disabled');
                  seatElement.css('background-color', 'orange');
              } else if (gender === 'Female') {
            	  
            	  console.log("Executing..3");

            	  
                  seatElement.addClass('disabled');
                  
                  seatElement.css('background-color', 'rgb(255, 105, 180)');
              }
              else{
            	  console.log("Executing..4");

              }
          }
          else{
        	  
        	  
				if (gender === 'Female') {
            	  
            	  console.log("Executing..5");

            	 seatElement.css('background-color', 'rgb(255, 192, 203)');
              }
        	  
          }
      }
  }
  
  //changing the code
  
  document.getElementById("submitButton").addEventListener("click", function() {
    if (seats_selected_count > 0) {
        var form = document.createElement("form");
        form.method = "POST";
        form.action = "passengers";

        // Add input fields for data
        var data1 = document.createElement("input");
        data1.type = "hidden";
        data1.name = "noOfSeatsSelected";
        data1.value = seats_selected_count;
        form.appendChild(data1);

        var data2 = document.createElement("input");
        data2.type = "hidden";
        data2.name = "seatsData";
        data2.value = JSON.stringify(selected_seats);
        form.appendChild(data2);

        // Embed the hidden inputs
        var hiddenInputs = document.querySelectorAll('input[type="hidden"]');
        hiddenInputs.forEach(function(input) {
            var hiddenInput = document.createElement("input");
            hiddenInput.type = "hidden";
            hiddenInput.name = input.name;
            hiddenInput.value = input.value;
            form.appendChild(hiddenInput);
        });

        // Submit the form
        document.body.appendChild(form);
        form.submit();
    } else {
        console.log("No seats selected.");
        alert("Select at least one seat");
    }
});

  
  document.getElementById("submitButton1").addEventListener("click", function() {
	  
	  if (seats_selected_count > 0) {
		  var form = document.createElement("form");
		    form.method = "POST";
		    form.action = "passengers";

		    // Add input fields for data
		    var data1 = document.createElement("input");
		    data1.type = "hidden";
		    data1.name = "noOfSeatsSelected";
		    data1.value = seats_selected_count;
		    form.appendChild(data1);

		    var data2 = document.createElement("input");
		    data2.type = "hidden";
		    data2.name = "seatsData";
		    data2.value = JSON.stringify(selected_seats);;
		    form.appendChild(data2);

		    // Submit the form
		    document.body.appendChild(form);
		    form.submit();
	  }
	  else
		  {
		  console.log("O seats selected..");
		  alert("Select at least one seat");
		  }
	    // Create a form
	   
	  });
  
  });

function goBack() {
  window.history.back();
}