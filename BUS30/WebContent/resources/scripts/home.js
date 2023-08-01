/**
 * 
 */


$(document).ready(function(){

  $("#searchBuses").click(function(){
    $("#buslist").show();
  });

  // Update destination options based on source selection
  $("#fssId").change(function() {
    var selectedSource = $(this).val();
    $("#tssId option").show(); // Show all options
    $("#tssId option[value='" + selectedSource + "']").hide(); // Hide selected source option
  });
  
  $("#tssId").change(function() {
    var selectedSource = $(this).val();
    $("#fssId option").show(); // Show all options
    $("#fssId option[value='" + selectedSource + "']").hide(); // Hide selected source option
  });
  
  // Swap values between source and destination fields
  $("#swapBtn").click(function() {
    var sourceValue = $("#fssId").val();
    var destinationValue = $("#tssId").val();
    
    $("#fssId").val(destinationValue);
    $("#tssId").val(sourceValue);
 
  });
});

 $(document).ready(function() {
        $("#contactLink").click(function() {
            // Make an AJAX request to retrieve the contact details
            $.ajax({
                url: "getContactDetails",
                type: "GET",
                success: function(response) {
                    // Update the contact details section with the response
                    $("#contactDetails").html(response);
                },
                error: function() {
                    alert("Failed to retrieve contact details.");
                }
            });
        });
    });


