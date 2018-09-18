<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
	<head>
		<title>Pizza's</title>
		<link rel='icon' href='images/pizza.ico' type='image/x-icon'>
		<meta name='viewport' content='width=device-width,initial-scale=1'>
		<link rel='stylesheet' href='css/pizzaluigi.css'>
	</head>
	<body>
		<h1>Pizza's</h1>
		***${pizzas}***	<!-- bedoeld voor debugging -->
		<ul class='zebra'>
			<c:forEach var='entry' items='${pizzas}'>
				<li>${entry.key}: ${entry.value.naam} ${entry.value.prijs} &euro;</li>
			</c:forEach>
		</ul>
	</body>
</html>