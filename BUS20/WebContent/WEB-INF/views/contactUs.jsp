<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us - AvengersBTRS</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link href="<c:url value="/resources/styles/contactUs.css" />" rel="stylesheet"> 
 <style>     
 <%if(session.getAttribute("userId")!=null) { %>body{ background-color: white; margin-top: -20px;margin-left: -10px;}#navbarLogin {padding-top:20px; margin: 0;width: 1431px;}<% }  else{   %><%}%>
  </style>
</head>
 <% if(session.getAttribute("userId")!=null){%><jsp:include page="navbarAfterLogin.jsp"><jsp:param name="currentPage" value="home" /></jsp:include><% }else{      	       %><jsp:include page="navbar.jsp"><jsp:param name="currentPage" value="home" /></jsp:include><%} %>
<body>
    <div class="container">
        <header>
            <h1>Contact Us</h1>
        </header>
        <main>
            <section>
                <h2>Corporate Head Office - Bangalore</h2>
                <address>
                    AvengersBTRS India Private Limited<br>
                    Indiqube Leela Galleria, 5th Floor, #No 23<br>
                    Old Airport Road, HAL 2nd Stage, Kodihalli Village<br>
                    Varthur Hobli, Ward No: 74<br>
                    Bengaluru, Karnataka - 560008<br>
                    BANGALORE
                </address>
            </section>
            <section>
                <h2>Other Offices</h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="office">
                            <h3>Coimbatore Office</h3>
                            <address>
                                AvengersBTRS India Private Limited<br>
                                JK Centre, 2nd floor, 5th<br>
                                Kannapiran Mills Rd, Sowri Palayam<br>
                                Nearby KIA service center<br>
                                Coimbatore, Tamil Nadu - 641015
                            </address>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="office">
                            <h3>Ahmedabad Office</h3>
                            <address>
                                AvengersBTRS India Private Limited<br>
                                Dynasty, Unit No. 905, 9th Floor<br>
                                Beside SBI Bank, CG Road Branch<br>
                                Near Stadium Circle, CG Road, Navrangpura<br>
                                Ahmedabad, Gujarat - 380009
                            </address>
                        </div>
                    </div>
                </div>
                <!-- Add more offices here -->
            </section>
            <section>
                <h2>Contact Details</h2>
                <p>
                    For any support or complaints, please chat with us on our website. Our support team is available 24/7 to assist you.
                </p>
                <p>
                    For press enquiries, please email us at <a href="mailto:press@avengers.com">press@avengers.com</a> (only for press/media enquiries).
                </p>
                <p>
                    For escalations or unresolved concerns, you may contact our grievance officer. Please visit our <a href="contact">Grievance Officer page</a> for more information.
                </p>
            </section>
        </main>
        <footer>
            <p>&copy; 2023 AvengersBTRS. All rights reserved.</p>
        </footer>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
