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

<h1 class="h">Show all Courses</h1>
<body>
	<table class="formtable">
		<tr>
			<td class="title">year</td>
			<td class="title">semester</td>
			<td class="title">code</td>
			<td class="title">subject</td>
			<td class="title">division</td>
			<td class="title">credit</td>
		</tr>
		<c:forEach var="course" items="${course}">
			<tr>
				<td class="label"><c:out value="${course.year}"></c:out></td>
				<td class="label"><c:out value="${course.semester}"></c:out></td>
				<td class="label"><c:out value="${course.code}"></c:out></td>
				<td class="label"><c:out value="${course.subject}"></c:out></td>
				<td class="label"><c:out value="${course.division}"></c:out></td>
				<td class="label"><c:out value="${course.credit}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}"> go home </a>

</body>
</html>