<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<title>H+ Sports</title>
<style type="text/css">
body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
}

.header {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 18px;
}

.bottom {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	text-align: center;
	vertical-align: middle;
	color: #8E969D;
}
</style>
<link type="text/css" rel="stylesheet" href="resources/css/global.css" />
</head>
<body>
	<table style="border: 1px solid #CAD6E0" align="center" cellpadding="0"
		cellspacing="0" border="0" width="400">
		<tbody>

			<tr>
				<td class="header" height="42" align="center" valign="middle"
					width="100%" bgcolor="#E4EBEB">Entry Form | Catalog</td>
			</tr>
			<tr>
				<td height="1" width="100%" bgcolor="#CAD6E0"></td>
			</tr>
			<tr>
				<td><img src="resources/img/banner.jpeg" /></td>
			</tr>
			<tr>
				<td width="100%" colspan="2">
				${pageContext.request.contextPath} 
				${param.name}
				${cookie.someCookie.value}
					<table width="100%"  align="left"
						cellpadding="0" cellspacing="0" border="0">
						<tbody>
						<tr>
							<th>Name</th>
							<th>Manufacturer</th>
							<th></th>
						</tr>
						<c:forEach items="${items}" var="item">
						
							<tr>
								<td >
								<c:out value="${item.name}" />
								</td>
								<td >
									${item.manufacturer} 
								</td>
								<td >
									${item.sku} 
								</td>
							</tr>
						</tbody>
						</c:forEach>
					</table>
				</td>
			</tr>

			<tr>
				<td colspan="2" valign="bottom" height="1" width="100%"
					bgcolor="#CAD6E0"></td>
			</tr>
		</tbody>
	</table>
</body>

</html>
