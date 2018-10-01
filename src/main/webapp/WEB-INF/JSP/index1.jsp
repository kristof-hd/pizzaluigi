<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
	<head>
		<!-- 
			<title>Pizza Luigi</title>
			<link rel='icon' href='images/pizza.ico' type='image/x-icon'>
			<meta name='viewport' content='width=device-width,initial-scale=1'>
			<link rel='stylesheet' href='css/pizzaluigi.css'>
		-->
		<c:import url='/WEB-INF/JSP/head.jsp'> 
			<c:param name='title' value='Pizza Luigi'/>
		</c:import>
	</head>
	<body>
		<c:import url='/WEB-INF/JSP/menu.jsp'/>
		<h1>Pizza Luigi</h1>
		<!-- <img src='images/pizza.jpg' alt='pizza' class='fullwidth'> -->
		<img src='<c:url value="/images/pizza.jpg"/>' alt='pizza' class='fullwidth'>
		<h2>${boodschap}</h2>
		<h2>De zaakvoerder</h2>
			<dl>
				<dt>Naam</dt><dd>${zaakvoerder.naam}</dd>
				<dt>Aantal kinderen</dt><dd>${zaakvoerder.aantalKinderen}</dd> 
				<dt>Gehuwd</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee'}</dd>			
			</dl>
		<c:if test='${not empty laatstBezocht}'>
			<p>Je bezocht onze website laatst op ${laatstBezocht}.</p>
		</c:if>
		<p>${identificatie.emailAdres}</p>
	</body>
</html>

