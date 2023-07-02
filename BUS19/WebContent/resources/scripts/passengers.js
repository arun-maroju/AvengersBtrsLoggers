	
function goBackAndReload() {
	  if (window.location.href.indexOf("#") > -1) {
		  window.history.back();
		  window.history.back();
		//  window.location.replace(document.referrer);
	  } else {
	    window.history.back();
		//  window.location.replace(document.referrer);


	  }
	}

    function fillFormFields(button) {
        console.log("in function");
        var row = button.parentNode.parentNode.parentNode.parentNode;
        var name = row.cells[0].innerText;
        var age = row.cells[1].innerText;
        var gender = row.cells[2].innerText;

        var selectedSeatNumber = button.textContent;
        var passengerContainers = document.getElementsByClassName('passenger-container');

        for (var i = 0; i < passengerContainers.length; i++) {
            var seatNumberField = passengerContainers[i].querySelector('input[name="seat_number"]');
            if (seatNumberField.value === selectedSeatNumber) {
                var passengerNameField = passengerContainers[i].querySelector('input[name="passenger_name"]');
                var passengerAgeField = passengerContainers[i].querySelector('input[name="passenger_age"]');
                var passengerGenderField = passengerContainers[i].querySelector('select[name="passenger_gender"]');

                if (passengerGenderField.disabled && gender === 'Female') {
                    passengerNameField.value = name;
                    passengerAgeField.value = age;
                    passengerGenderField.value = gender;
                } else if (!passengerGenderField.disabled) {
                    passengerNameField.value = name;
                    passengerAgeField.value = age;
                    passengerGenderField.value = gender;
                } else {
                    alert('Only female can book this seat');
                }
                return;
            }
        }

        alert('Invalid seat number. Please try again.');
    }