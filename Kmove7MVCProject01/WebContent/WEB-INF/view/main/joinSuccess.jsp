<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="./css/joinSuccess.css">
<title>会員登録完了</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>
	<br>
	<div align="center">
	${param.kanrisha_nm }様、会員登録が完了しました。
	</div>
</body>
</html>