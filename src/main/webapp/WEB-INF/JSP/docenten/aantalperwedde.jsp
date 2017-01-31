<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Aantal docenten per wedde' />
</head>
<body>
	<v:menu />
	<h1>Aantal docenten per wedde</h1>
	<table class=”anders”>
		<thead>
			<tr>
				<th>Wedde</th>
				<th>Aantal docenten</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${weddesEnAantallen}' var='weddeEnAantal'>
				<tr>
					<td><fmt:formatNumber value='${weddeEnAantal.wedde}'
							minFractionDigits='2' maxFractionDigits='2' /></td>
					<td><div style='width:${weddeEnAantal.aantal}em'>
							${weddeEnAantal.aantal}</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>