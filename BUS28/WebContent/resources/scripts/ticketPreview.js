var ticketNum;
    var payment_id;
    //var userid=document.getElementById("uid");
    $(document).ready(function() {
    	var userid=$("#uid").val().toString();

    	console.log("Hello");
    	console.log(userid);
        $('form').submit(function(e) {
            e.preventDefault(); // Prevent form submission
            var form = $(this);

            $.ajax({
                url: form.attr('action'),
                type: form.attr('method'),
                data: form.serialize(),
                dataType: 'json',
                success: function(response) {
                  // Handle the success response here
                  console.log('Hello1 Arun');
                    console.log(response);
                    console.log('Hello Arun');                                       
                    if(response.status=="SeatsFilled"){
						console.log("Ak entered into if block of reseponse so that no seats available");
                    	console.log("seats filled");
                    	alert("Seats already filled");
                    	window.location.href = "home";
                    }
                    console.log(userid);
                    if (response.status == 'created') {
                        var options = {
                            "key": "rzp_test_eH7ePzZMEaZaJo",
                            "amount": response.amount,
                            "currency": "INR",
                            "name": "BRS",
                            "description": "Test Transaction",
                            "image": "https://example.com/your_logo",
                            "order_id": response.id,
                            "handler": function(response) {
                                payment_id=response.razorpay_payment_id.toString();
                                order_id=response.razorpay_order_id.toString();
                               // totalResponse = JSON.stringify(response) // URL encode the totalResponse
                               // encodedResponse = encodeURIComponent(totalResponse);
                                console.log(response.razorpay_payment_id);
                                console.log(response.razorpay_order_id);
                                console.log(response.razorpay_signature);
                                alert("Success");

                                // Clear the input fields
                                $('#amount').val('');
                                $('#ticketNumber').val('');
                                window.location.href = "confirm?payment_id="+payment_id+"&order_id="+order_id+"&user_id="+userid;
                            },
                            "prefill": {
                                "name": "",
                                "email": "",
                                "contact": ""
                            },
                            "notes": {
                                "address": "Razorpay Corporate Office"
                            },
                            "theme": {
                                "color": "#3399cc"
                            }
                        };
                       var rzp1 = new Razorpay(options);
                        rzp1.on('payment.failed', function(response) {
                            console.log(response.error.code);
                            console.log(response.error.description);
                            console.log(response.error.source);
                            console.log(response.error.step);
                            console.log(response.error.reason);
                            console.log(response.error.metadata.order_id);
                            console.log(response.error.metadata.payment_id);
                            alert("Failed");

                            window.location.href = "home";           
                        });

                        rzp1.open();
                    }
                },
                error: function(xhr, status, error) {
                    // Handle the error response here
                    conole.log('In error block');
                    console.log("hello in error function");
                    //console.log(xhr.responseText);
                }
            });
        });
    });