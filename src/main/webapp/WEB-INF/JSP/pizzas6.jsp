<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
	<head>
		<!-- 
			<title>Pizza's</title>
			<link rel='icon' href='images/pizza.ico' type='image/x-icon'>
			<meta name='viewport' content='width=device-width,initial-scale=1'>
			<link rel='stylesheet' href='css/pizzaluigi.css'>
		-->
		<c:import url='/WEB-INF/JSP/head.jsp'>
			<c:param name='title' value="Pizza's"/>
		</c:import>
	</head>
	<body>
		<c:import url='/WEB-INF/JSP/menu.jsp'/>
		<h1>Pizza's
			<c:forEach begin='1' end='5'>&#9733; <%-- de HTML code van een ster --%>
			</c:forEach>
		</h1>
		<ul class='zebra'>
			<c:forEach var='entry' items='${pizzas}'>
				<li>${entry.key}: <c:out value='${entry.value.naam}'/> ${entry.value.prijs} &euro;
					<!-- 
						<c:choose>
							<c:when test='${entry.value.pikant}'>pikant</c:when> 
							<c:otherwise>niet pikant</c:otherwise>
						</c:choose> 
					-->
					${entry.value.pikant ? "pikant" : "niet pikant"}  
					<c:url value='/pizzas6' var='url'>>
						<c:param name='id' value='${entry.key}'/>
					</c:url>
					<a href='${url}'>Detail</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>