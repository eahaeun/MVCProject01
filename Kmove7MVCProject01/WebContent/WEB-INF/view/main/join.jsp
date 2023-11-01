<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<link rel="stylesheet" type="text/css" href="./css/join.css">
<script src="https://kit.fontawesome.com/bda9280492.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>
	<br>
	<div class="container">
		<form action="join.do" method="post">
			<div style="font-size: 50px">
				<i class="fa-solid fa-user-plus" style="color: #000000;"></i>
			</div>
			<h2>会員登録</h2>
			<div>
				<label for="id" id="login-label">ID:</label> <input type="text"
					name="kanrisha_uid">
			</div>
			<div>
				<label for="pw" id="login-label">PW:</label> <input type="password"
					name="kanrisha_pw">
			</div>
			<div>
				<label for="pw-confirm" id="login-label">PW確認:</label> <input
					type="password" name="comfirm_pw">
			</div>
			<div>
				<label for="name" id="login-label">氏名:</label> <input type="text"
					name="kanrisha_nm">
			</div>
			<div class="button-container">
				<input type="submit" value="会員登録" class="search-button">
			</div>
			<c:if
				test="${errors.kanrisha_uid or errors.kanrisha_pw or errors.kanrisha_nm or errors.confirm_id}">
				<script>
					alert('未入力の項目があります。');
				</script>
			</c:if>
			<c:if test="${errors.notMatch }">
				<script>
					alert('パスワード確認が一致しません。');
				</script>
			</c:if>
			<c:if test="${errors.duplicatedId }">
				<script>
					alert('既に使用中のIDです。');
				</script>
			</c:if>
		</form>
		
	</div>
</body>
</html>