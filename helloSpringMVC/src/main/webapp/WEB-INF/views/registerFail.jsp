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

<h1 class="result">Fail to register</h1>
<body>
	<p>${message}</p>
</body>
<p>
	<a href="${pageContext.request.contextPath}/registerForCourse">
		register again </a>
</p>
<p>
	<a href="${pageContext.request.contextPath}/registrationDetails">
		show my registration </a>
</p>
<p>
	<a href="${pageContext.request.contextPath}"> go home </a>
</p>
</html>