<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Us - AvengersBTRS</title>
     <link href="<c:url value="/resources/styles/aboutUs.css" />" rel="stylesheet">
 <style>
 <% if(session.getAttribute("userId")!=null){ %>
  body{ background-color: white;margin-top: -20px;margin-left: -10px;}
#navbarLogin {padding-top:20px;margin: 0;width: 1431px;}
<% }else{  %><%}%>  
</style>
</head>
 <%if(session.getAttribute("userId")!=null){ %>
<jsp:include page="navbarAfterLogin.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<%} else{      	       
%>
<jsp:include page="navbar.jsp">
  <jsp:param name="currentPage" value="home" />
</jsp:include>
<%} %>
<body>
    <div class="container">
        <header>
            <h1>About Us</h1>
        </header>
        <main>
            <section>
                <h2>About AvengersBTRS</h2>
                <p>
                    AvengersBTRS is India’s largest online bus ticketing platform that has transformed bus travel in the country by bringing ease and convenience to millions of Indians who travel using buses. We were founded in 2023 and are part of India’s leading online travel company Pennant Pvt Limited (NASDAQ: MMYT).
                </p>
                <p>
                    Our mission is to provide the widest choice, superior customer service, lowest prices, and unmatched benefits to our customers. Over the years, we have served over 18 million customers and have expanded our operations globally, reaching countries such as Indonesia, Singapore, Malaysia, Colombia, and Peru, in addition to India.
                </p>
            </section>
            <section>
                <h2>Management Team</h2>
                <div class="row">
                    <div class="col-md-6 profile">
                        <img src="data:image/jpeg;base64,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" alt="Mark Arun - CEO">
                        <h3>Mark Arun - CEO</h3>
                        <p>
                            Mark Arun has been the Chief Executive Officer of AvengersBTRS since June 2014. Prior to AvengersBTRS, he served as an Executive Vice President of Info Edge India (Naukri group) and has had multiple roles across Marketing, Brand Management, and Sales at Hindustan Unilever and Airtel. Mark holds an MCA from IIM Calcutta and an Honours degree in Production Engineering from AU University.
                        </p>
                    </div>
                    <div class="col-md-6 profile">
                        <img src="data:image/jpeg;base64,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" alt="Imran Streak - CTO">
                        <h3>Imran Streak - CTO</h3>
                        <p>
                            Imran Streak serves as the Chief Technology Officer at AvengersBTRS. He plays a crucial role in setting the company’s strategic direction, development, and future growth. With over 18 years of extensive experience in building scalable and high-performing products, Imran leads the effective delivery of scalable systems to customers, agents, and bus operators by incorporating the latest technology. He completed his BE in Computer Science Engineering from MVGR University and is passionate about sports, movies, TV, and music.
                        </p>
                    </div>
                </div>
            </section>
        </main>
        <footer>
            <p>&copy; 2023 AvengersBTRS. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
