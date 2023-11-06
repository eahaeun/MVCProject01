<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退職処理</title>
<link rel="stylesheet" type="text/css" href="./css/shain.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>
	<br/>
	<form action="taishokuRegist.do" method="POST">
		<div class="form-container">
			<div class="section">
				<h2>退職処理</h2>

				退社事由: <input type="text" name="taishoku_jiyu" value="${param.taishoku_jiyu}">
				<br>
				退社後の連絡先: <input type="text" name="taishoku_renraku" value="${param.taishoku_renraku}">
				퇴직금: <input type="text" name="taishoku_pay" value="${param.taishoku_pay}">
				<input type="hidden" name="shain_no" value="${shain_no}">
				<br>
			</div>
		<div align="center">
			<input type="submit" value="退社処理">
		</div>
	</form>
</body>
</html>