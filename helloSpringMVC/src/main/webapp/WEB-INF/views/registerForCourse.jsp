<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/tableStyle.css" />
<style>
td {
	text-align: right;
	vertical align: center;
	border: 1px solid black;
	text-align: center;
}
</style>
</head>

<h1 class="h">Register for a course</h1>
<body>
	<sf:form method="get" action="${pageContext.request.contextPath}/doRegister" modelAttribute="course">
		<h3>Input Code What You Want To Register</h3>
		<table class="inputTable">
			<tr>
				<td class="inputLabel">Code:</td>
				<td class="inputLabel"><sf:input path="code" type="text" /></td>
				<td class="inputLabel"><input value="Register" type="submit" />
				</td>
			</tr>
			<tr>
				<td Class="errorMsg"></td>
				<td Class="errorMsg"><sf:errors path="code"></sf:errors></td>
			</tr>
		</table>

		<table class="formtable">
			<tr>
			<td class="title">year</td>
			<td class="title">semester</td>
			<td class="title">code</td>
			<td class="title">subject</td>
			<td class="title">division</td>
			<td class="title">credit</td>
		</tr>
		<c:forEach var="courseInfoList" items="${courseInfoList}">
			<tr>
				<td class="label"><c:out value="${courseInfoList.year}"></c:out></td>
				<td class="label"><c:out value="${courseInfoList.semester}"></c:out></td>
				<td class="label"><c:out value="${courseInfoList.code}"></c:out></td>
				<td class="label"><c:out value="${courseInfoList.subject}"></c:out></td>
				<td class="label"><c:out value="${courseInfoList.division}"></c:out></td>
				<td class="label"><c:out value="${courseInfoList.credit}"></c:out></td>
			</tr>
		</c:forEach>
			
			
		</table>
		
	</sf:form>
</body>
<a href="${pageContext.request.contextPath}"> go home </a>
</html>