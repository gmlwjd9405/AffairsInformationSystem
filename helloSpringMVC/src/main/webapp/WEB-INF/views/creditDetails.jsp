<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/tableStyle.css" />
</head>

<h1 class="h">Credit details</h1>
<body>
	<table class="formtable">
		<tr>
			<c:forEach var="creditDetails" items="${creditDetails}">
				<td class="title"><c:out value="${creditDetails.division}"></c:out></td>
			</c:forEach>
			<td class="title">tatal credits
		</tr>
		<tr>
			<c:forEach var="creditDetails" items="${creditDetails}">
				<td class="label"><c:out value="${creditDetails.credit}"></c:out></td>
			</c:forEach>
			<td class="totalCredits">${totalCredits}
		</tr>
	</table>
</body>
<a href="${pageContext.request.contextPath}"> go home </a>
</html>