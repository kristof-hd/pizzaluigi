<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='vdab' uri="http://vdab.be/tags"%>
<!doctype html>
<html lang='nl'>
<head>
	<vdab:head title='Pizzas'/>
</head>
<body>
	<vdab:menu/>
	<h1>
		Pizza's
		<c:forEach begin='1' end='5'>&#9733; <%-- de HTML code van een ster --%>
		</c:forEach>
	</h1>
	<ul class='zebra'>
		<c:forEach var='pizza' items='${pizzas}'>
			<li>${pizza.id}: <c:out value='${pizza.naam}' />
				${pizza.prijs}&euro; <c:choose>
					<c:when test='${pizza.pikant}'>pikant</c:when>
					<c:otherwise>niet pikant</c:otherwise>
				</c:choose> <spring:url value='/pizzas16/{id}' var='url'>
					<spring:param name='id' value='${pizza.id}' />
				</spring:url> <a href='${url}'>Detail</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>