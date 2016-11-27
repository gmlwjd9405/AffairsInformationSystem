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

<h1 class="h">Inquiry course credits per semester</h1>
<body>
	<table class="formtable">
		<tr>
			<td class="title">year</td>
			<td class="title">semester</td>
			<td class="title">credits</td>
			<td class="title">details</td>
		</tr>
		<c:forEach var="coursePerSemester" items="${coursePerSemester}">
			<tr>
				<td class="label"><c:out value="${coursePerSemester.year}"></c:out></td>
				<td class="label"><c:out value="${coursePerSemester.semester}"></c:out></td>
				<td class="label"><c:out value="${coursePerSemester.credit}"></c:out></td>
				<td class="detailLink"><a
					href="${pageContext.request.contextPath}/subjectListPerSemester?year=${coursePerSemester.year}&semester=${coursePerSemester.semester}">details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<a href="${pageContext.request.contextPath}"> go home </a>
</html>