 $(document).ready(function() {
	 
	 $('#otpContainer').hide();
	  
      var alertMessage = "In Forgot Password Page";
      if (alertMessage) {
          alert(alertMessage);
      }
	  
    var urlParams = new URLSearchParams(window.location.search);
    var inputData = urlParams.get('data');
   
    if(inputData==null)
    	{
    		inputData="${email}"
    	}
    $('#to').val(inputData);
    $('#email').val(inputData);

    
    $('#sendEmailButton').click(function() {
        var to = $('#to').val();
		
        $.ajax({
          url: 'email',
          method: 'GET',
          data: { "to": to ,"purpose":"reset"},
          success: function(response) {
            alert(response);
            if(response!="Email Sent Successfully"){
            	 window.location.href = "signup";
            }
            $('#otpContainer').show();
          },
          error: function(xhr, status, error) {
            alert('Failed to send email:', error);
          }
        });
        
      });
    });