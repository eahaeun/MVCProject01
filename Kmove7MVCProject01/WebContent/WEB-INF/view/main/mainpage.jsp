<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>メインページ</title>
<link rel="stylesheet" type="text/css" href="./css/mainpage.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>
	<c:if test="${!empty authUser}">
		<div align="center">
			<p>ようこそ、${authUser.kanrisha_nm}様。ご利用いただきありがとうございます。</p>
		</div>
	</c:if>
	<c:if test="${empty authUser}">
		<div align="center">
			<p>サイトに登録し、人事・給与管理システムをご利用ください！</p>
		</div>
	</c:if>
</body>
</html>