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
