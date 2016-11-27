<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/tableStyle.css" />
</head>

<h1 class="h">Registration details</h1>
<body>
	<h3>Your Registration 2017-1</h3>

	<table class="formtable">
		<tr>
			<td class="title">year</td>
			<td class="title">semester</td>
			<td class="title">code</td>
			<td class="title">subject</td>
			<td class="title">division</td>
			<td class="title">credit</td>
		</tr>
		<c:forEach var="registrationDetails" items="${registrationDetails}">
			<tr>
				<td class="label"><c:out value="${registrationDetails.year}"></c:out></td>
				<td class="label"><c:out
						value="${registrationDetails.semester}"></c:out></td>
				<td class="label"><c:out value="${registrationDetails.code}"></c:out></td>
				<td class="label"><c:out value="${registrationDetails.subject}"></c:out></td>
				<td class="label"><c:out
						value="${registrationDetails.division}"></c:out></td>
				<td class="label"><c:out value="${registrationDetails.credit}"></c:out></td>
			</tr>
		</c:forEach>
	</table>



</body>
<p>
	<a href="${pageContext.request.contextPath}/registerForCourse">
		register again </a>
</p>
<p>
	<a href="${pageContext.request.contextPath}"> go home </a>
</p>
</html>