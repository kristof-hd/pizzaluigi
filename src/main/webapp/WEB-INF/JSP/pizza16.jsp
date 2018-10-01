<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
	<head>
		<vdab:head title='${pizza.naam}'/>
	</head>
	<body>
		<vdab:menu/>
		<c:if test='${empty pizza}'>
			<h1>Pizza niet gevonden</h1>
		</c:if>
		<c:if test='${not empty pizza}'>
			<h1>${pizza.naam}</h1>
			<dl>
				<dt>Nummer</dt>
				<dd>${pizza.id}</dd>
				<dt>Naam</dt>
				<dd>${pizza.naam}</dd>
				<dt>Prijs</dt>
				<dd>${pizza.prijs}</dd>
				<dt>InDollar</dt>
				<dd>${inDollar}</dd>
				<dt>Pikant</dt>
				<dd>${pizza.pikant ? 'ja' : 'nee'}</dd>
			</dl>
		</c:if>
	</body>
</html>