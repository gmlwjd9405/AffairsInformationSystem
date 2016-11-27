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

<h1 class="h">a total information system menu</h1>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/course"> 1) Show all
			Courses </a>
	<p>
		<a href="${pageContext.request.contextPath}/coursePerSemester"> 2)
			Inquiry course credits per semester </a>
	<p>
		<a href="${pageContext.request.contextPath}/creditDetails"> 3)
			Credit details </a>
	<p>
		<a href="${pageContext.request.contextPath}/registerForCourse"> 4)
			Register for a course </a>
	<p>
		<a href="${pageContext.request.contextPath}/registrationDetails">
			5) Registration details </a>
</body>
</html>
