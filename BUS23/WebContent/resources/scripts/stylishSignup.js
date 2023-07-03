function togglePasswordVisibility() {
	  var passwordField = document.getElementById("password");
	  var confirmPasswordField = document.getElementById("confirmPassword");
	  var toggleCheckbox = document.getElementById("togglePassword");

	  if (toggleCheckbox.checked) {
	    passwordField.type = "text";
	    confirmPasswordField.type = "text";
	  } else {
	    passwordField.type = "password";
	    confirmPasswordField.type = "password";
	  }
	}

document.getElementById("myForm").addEventListener("submit", function(event) {
	  var password = document.getElementById("password").value;
	  var confirmPassword = document.getElementById("confirmPassword").value;

	  // Validate password length (between 8 and 16 characters)
	  if (password.length < 8 || password.length > 16) {
	    alert("Password must be between 8 and 16 characters");
	    event.preventDefault();
	  }

	  // Validate at least one special symbol, one letter, and one digit
	  var passwordRegex = /^(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?])(?=.*[a-zA-Z])(?=.*\d).{8,16}$/;
	  if (!passwordRegex.test(password)) {
	    alert("Password must contain at least one special symbol, one letter, and one digit");
	    event.preventDefault();
	  }
	  
	  if (password !== confirmPassword) {
	   alert("Passwords do not match");
	    event.preventDefault(); // Prevent form submission
	  }
	  
	});
  $(document).ready(function() {
    var urlParams = new URLSearchParams(window.location.search);
    var inputData = urlParams.get('data');
    $('#to').val(inputData);

    
    $('#signupContainer').hide();
    $('#otpContainer').hide();
    $('#sendEmailButton').click(function() {
      
      var to = $('#to').val();
      $.ajax({
        url: 'email',
        method: 'GET',
        data: { to: to },
        success: function(response) {
        	$('#otpContainer').show();
          alert("Email Sent Successfully");
        },
        error: function(xhr, status, error) {
          alert('Failed to send email:', error);
        }
      });
    });

    $('#otpButton').click(function() {  	
      var otp = $('#otp').val();
      $.ajax({
        url: 'validateOTP1',
        method: 'POST',
        data: { otp: otp },
        success: function(response) {
          console.log(response); 
          var data = JSON.parse(response);
          if(data.key1 == 'success') {
            var signupContainer = document.getElementById('signupContainer');
            var prevBlock= document.getElementById('otp-block');
            signupContainer.style.display = 'block';
            prevBlock.style.display='none';
            var emailId = document.getElementById("to").value;            
            document.getElementById("user-email").value=emailId;
            
            
          }
        },
        error: function(xhr, status, error) {
          alert('Failed to match OTP:', error);
        }
      });
    });
  });