<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.avengers.bus.models.entityModels.*,com.avengers.bus.models.dtoModels.*,com.avengers.bus.models.inputModels.*,java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bus Seat Layout</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link href="<c:url value="/resources/styles/busLayout.css" />" rel="stylesheet">
 <style>
 <%if(session.getAttribute("userId")!=null)  {%>
  body{ background-color: white;  margin-top: -20px; margin-left: -10px;}
#navbarLogin {padding-top:20px;margin: 0;width: 1431px;}
<%  } else{  %><%}%>
 </style>
</head>
 <% if(session.getAttribute("userId")!=null)  { %>
<jsp:include page="navbarAfterLogin.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<%  } else{     %>
<jsp:include page="navbar.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<%} %>
<body>
    <div id="body1">
 		<% 
   		 List<SeatsBookedForOneService> sl = (List<SeatsBookedForOneService>) request.getAttribute("sl");
    		BusSearchListDto b= (BusSearchListDto) request.getAttribute("selectedBusDetails");
    		System.out.println(b);
    %>    
  <div class="bus-block">
                <h4 class="bus-title">Service No: <span class="bold red"><%= b.getTrip_id()+""+b.getService_id() %></span></h4>
                <div class="bus-details">
                	<div>
                    <p><span class="label">Type:</span> <span class="time black"><%= b.getBsty_title() %></span></p>  
                    </div>
                     <div>
                        <p><span class="label ">Source:</span> <span class="time green"><%= b.getSource() %></span></p>
                        <p><span class="label">Departure:</span> <span class="time green"><%= b.getDepature() %></span></p>
                    </div>
                    <div>
                    <p><span class="label ">Destination :</span> <span class="time green"><%= b.getDestination() %></span></p>                       
                        <p><span class="label">Arrival:</span> <span class="time green"><%= b.getArrival() %></span></p>
                    </div>
                    <div>
                        <p><span class="label date">Seat Fare:</span> <span class="time green" id='sf'><%= b.getSeat_fare() %></span></p>
                        <p><span class="label ">Berth Fare:</span> <span class="time green" id='bf'><%= b.getBerth_fare() %></span></p>
                    </div>           
                </div>
            </div>
        <input type="hidden" name="service_id" value="<%= b.getService_id() %>">                
                 <input type="hidden" name="trip_id" value="<%= b.getTrip_id() %>">
                 <input type="hidden" name="source" value="<%= b.getSource() %>">
                 <input type="hidden" name="destination" value="<%= b.getDestination() %>">
                 <input type="hidden" name="trip_date" value="<%= b.getTrip_date() %>">
                <input type="hidden" name="arrival" value="<%= b.getArrival() %>">
                   <input type="hidden" name="depature" value="<%= b.getDepature() %>">                 
                 <input type="hidden" name="bsty_title" value="<%= b.getBsty_title()%>">
                 <input type="hidden" name="available_seats" value="<%= b.getAvailable_seats() %>">
				<input type="hidden" name="seat_fare" value="<%= b.getSeat_fare()%>">
                 <input type="hidden" name="berth_fare" value="<%= b.getBerth_fare() %>">
 
    <div class="whole-bus-seat-layout">    
    <div class="bus-container">				          
    <canvas id="canvas" width="50" height="50" style="position: relative ;left:150px"></canvas>   
    		<div id="FirstBookingBlock" class="bus-seat-layout">   		
        <%-- Loop to generate bus seats dynamically --%>
					      <!-- 1,2 -->  <div class="bus-seat-layout">
					      <hr>
					          <% int arr[][]={{1,2},{3,4},{5,6},{7,8},{9,10},{11,12},{13,14},{15,16}};
					         	for(int col=0;col<2;col++)	{%>
					         	 <div class="bus-seat-row">					         	
					         	<%  for(int row=0;row<8;row++)
					         		{
					         			int seatNumber = arr[row][col];					         			
					         			 %>
						                    <%-- Output the seat element with dynamic seat number --%>
						                     <div class="bus-seat" id="<%= seatNumber %>">
						                        <%= seatNumber %>
						                    </div>
						                <% 	}%>
					         		</div>
					         		<% } %>
					      <!-- 1,2 -->   </div>
					       <!-- 3 -->   <div class="bus-seat-layout">
				        <%-- Loop to generate bus seats dynamically --%>
				       
				            <div class="bus-seat-row">
				                <% for (int col = 25; col <= 28; col++) { %>
				                    <%-- Generate seat numbers dynamically based on row and col --%>
				                    <% int seatNumber = col; %>
				                    <%-- Output the seat element with dynamic seat number --%>
				                    <div class="bus-seat1" id="<%= seatNumber %>">
				                        <%= seatNumber %>
				                    </div>
				                <% } %>
				                    
				            </div>
				        <!-- 3 -->  </div>        
         </div>
         <h3 class="deck-names"> Lower Deck</h3>       
        </div>
     <div class="space-layout">
     </div>
        <div class="space-layout">
     </div>
        <div class="space-layout">
     </div>  
    <div class="bus-container">
   							 <div id="SecondBookingBlock" class="bus-seat-layout1">  	
						    	<div class="bus-seat-layout1">					    	       
						            <div class="bus-seat-row">
						                <% for (int col = 17; col <= 23; col++) { %>
						                    <%-- Generate seat numbers dynamically based on row and col --%>
						                    <% int seatNumber =col;
						                    col++;%>
						                    <%-- Output the seat element with dynamic seat number --%>
						                    <div class="bus-seat1" id="<%= seatNumber %>">
						                        <%= seatNumber %>
						                    </div>
						                <% } %>						                    
						            </div>
						            <%-- Loop to generate bus seats dynamically --%>
						            <div class="bus-seat-row">
						                <% for (int col = 18; col <= 24; col++) { %>
						                    <%-- Generate seat numbers dynamically based on row and col --%>
						                    <% int seatNumber = col ;
						                    col++;%>
						                    <%-- Output the seat element with dynamic seat number --%>
						                    <div class="bus-seat1" id="<%= seatNumber %>">
						                        <%= seatNumber %>
						                    </div>
						                <% } %>
					          </div>
				 </div>
       <div class="space-layout">
       </div> <div class="bus-seat-layout1">
				        <%-- Loop to generate bus seats dynamically --%>
				            <div class="bus-seat-row">
				                <% for (int col = 29; col <= 32; col++) { %>
				                    <%-- Generate seat numbers dynamically based on row and col --%>
				                    <% int seatNumber = col; %>
				                    <%-- Output the seat element with dynamic seat number --%>
				                    <div class="bus-seat1" id="<%= seatNumber %>">
				                        <%= seatNumber %>
				                    </div>
				                <% } %>
				            </div>				 
				   		 </div>
    </div>
    <h3 class="deck-names"> Upper Deck</h3>
    </div>
    </div>
    <div class='fare' id='fare' name='fare'>
  <div id='fare_cal_block'>  <div class="rectangle-container">
        <div class="rectangle" style="background-color:  #f2f2f2;"></div>
        <span class="rectangle-text">Available</span>
		</div>
	<div class="rectangle-container">
        <div class="rectangle" style="background-color:  #2ecc71;"></div>
        <span class="rectangle-text">Selected</span>
		</div> <div class="rectangle-container">
        <div class="rectangle" style="background-color:  rgb(255, 192, 203);"></div>
        <span class="rectangle-text">Only-Females</span>
		</div> <div class="rectangle-container">
        <div class="rectangle" style="background-color:  rgb(255, 105, 180);"></div>
        <span class="rectangle-text">Booked By Females</span>
		</div><div class="rectangle-container">
        <div class="rectangle" style="background-color:  orange;"></div>
        <span class="rectangle-text">Booked</span>
		</div><div class='fare' id='fare' name='fare'>
    <table id='fareTable'>
    <tr><th>Seat</th><th>Fare</th></tr>
    
    </table>
    <p><span class="label ">Total Fare:</span> <span class="time green" id='tf'>0</span></p>
    </div>   
    </div> <% Gson gson = new Gson();
	    String seatStatusJson = gson.toJson(sl);
	    System.out.println(seatStatusJson); %> <script type="text/javascript">
	    function getSeatStatusJson() {
	    	var jsonData=<%=seatStatusJson%>;
	    	  return jsonData;
	    	}
	    </script> <!-- JSP -->
<button id="submitButton" class="btn btn-primary btn-addPassengers">Add Passengers</button>
<button onclick="goBack()" class="btn btn-primary btn-addPassengers">Go Back</button>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script> 
        <%
        BusSearchListDto bus=(BusSearchListDto) request.getAttribute("selectedBusDetails");
        		System.out.println("................\n"+bus);
        %>   
    </div>
           <script src="<c:url value="/resources/scripts/busLayout.js" />"></script>   
</body>
</html>