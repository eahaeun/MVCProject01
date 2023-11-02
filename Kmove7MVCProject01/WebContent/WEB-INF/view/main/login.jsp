<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="./css/login.css">
<script src="https://kit.fontawesome.com/bda9280492.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<br>
	<form>
		<div class="container">
			<div style="font-size: 50px">
				<i class="fa-solid fa-user" style="color: #000000;"></i>
			</div>
			<h2>ログイン</h2>
			<div>
				<label for="id">ID:</label> <input type="text" name="kanrisha_uid">
			</div>
			<div>
				<label for="pw">PW:</label> <input type="password"
					name="kanrisha_pw">
			</div>
			<div class="button-container">
				<button type="submit" class="search-button" formaction="join.do"
					formmethod="get">会員登録</button>
				<button type="submit" class="search-button" formaction="login.do"
					formmethod="post">ログイン</button>
			</div>
		</div>

		<c:if test="${errors.idOrPwNotMatch}">
			<script>
				alert('IDまたはパスワードが一致しません。');
			</script>
		</c:if>
		<c:if test="${errors.id or errors.password}">
			<script>
				alert('IDとパスワードを入力してください。');
			</script>
		</c:if>
	</form>
</body>
</html>