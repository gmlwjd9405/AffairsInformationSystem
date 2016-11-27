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
			<tr><td>2017</td><td>1</td><td>CSE0051</td><td>DB시스템구현</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0039</td><td>IOS프로그래밍2</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0052</td><td>SW설계및테스트</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0055</td><td>고급DB설계</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0054</td><td>고급SW설계</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0044</td><td>디지털콘텐츠기획및제작</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0043</td><td>빅데이터프로그래밍</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0053</td><td>사용자어플리케이션구현</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0050</td><td>서버시스템구현</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0041</td><td>안드로이드프로그래밍2</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0037</td><td>오픈소스소프트웨어</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0042</td><td>웹프레임워크2</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0038</td><td>정보보안</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0040</td><td>컴파일러</td><td>전선</td><td>3</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0036</td><td>캡스톤디자인2</td><td>전지</td><td>4</td></tr>
			<tr><td>2017</td><td>1</td><td>CSE0056</td><td>캡스톤디자인3</td><td>전지</td><td>4</td></tr>
		</table>
		
	</sf:form>
</body>
<a href="${pageContext.request.contextPath}"> go home </a>
</html>