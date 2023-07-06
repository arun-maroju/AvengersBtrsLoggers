$(document).ready(function() {
      $('#btn').click(function() {
	console.log('forgot clicked..');

        var inputData = $('#username').val();
        if(inputData!=''){
        	window.location.href = 'forgot?data=' + inputData;
        }
        
      });
      
      
      
      $('#btn1').click(function() {
        window.location.href = 'signup';
      });
      
       $('#btn2').click(function() {
          window.location.href = 'home';
        });
      
    });