<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<style>
.container {
	text-align: center;
	border: 1px solid #000; /* 검은색 테두리 */
	padding: 10px; /* 안쪽 여백 추가 */
	border-radius: 5px; /* 모서리를 둥글게 만듦 */
	width: 20%;
	display: flex;
	justify-content: center;
	margin: 0 auto; /* 가운데 정렬을 위한 margin 설정 */
	flex-direction: column; /* 내부 요소를 수직 방향으로 정렬 */
	align-items: center; /* 내부 요소를 가운데 정렬 */
}

.container div:not(:first-child) {
	margin-right: 35px;
}

.button-container {
	text-align: right;
}

.right-align {
	float: right;
}

label {
	display: inline-block;
	/* label 태그는 inline 태그이므로 width, height, margin 상하가 적용되지 않으므로 inline-block 속성으로 변경해주는 것이 우선이다!*/
	width: 70px;
	text-align: right;
	margin: 10px 0;
}

h1, .button-container {
	margin: 10px 0;
}

input {
	width: 130px;
	margin: 10px 0;
}

/* 스타일 설정 */
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.title {
	background-color: #333; /* 타이틀 배경색 추가 */
	color: #fff; /* 타이틀 텍스트 색상 추가 */
	text-align: center;
	padding: 10px 0;
}

ul.menu {
	list-style: none;
	padding: 0;
	text-align: center;
	background-color: #f2f2f2;
	margin: 0;
}

ul.menu li {
	display: inline-block;
	margin: 0 20px;
	position: relative;
}

ul.menu li a {
	text-decoration: none;
	color: #000;
	display: block;
	padding: 10px 20px;
	transition: background-color 0.3s;
	background-color: #f2f2f2;
}

ul.menu li a:hover {
	background-color: #555;
	color: #fff;
}

ul.menu li ul.submenu {
	display: none;
	position: absolute;
	top: 100%;
	left: 0;
	list-style: none;
	padding: 0;
}

ul.menu li:hover ul.submenu {
	display: block;
	background-color: #333;
	border-top: 1px solid #555;
}

ul.submenu li {
	margin: 0;
}

ul.submenu li a {
	display: block;
	padding: 10px 20px;
	color: #000;
	text-decoration: none;
	transition: background-color 0.3s;
}

ul.submenu li a:hover {
	background-color: #555;
}

.search-button {
	padding: 5px 10px;
	background-color: #555;
	color: #fff;
	border: none;
	cursor: pointer; /* 마우스 커서 스타일 지정 */
}
</style>
<script src="https://kit.fontawesome.com/bda9280492.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="title">
		<h1>
			<a href="main.do" style="text-decoration: none; color: white;">人事・給与管理システム</a>
		</h1>
	</div>
	<ul class="menu">
		<li><a href="#">基本設定</a>
			<ul class="submenu">
				<li><a href="#">情報修正</a></li>
				<li><a href="#">部署登録</a></li>
				<li><a href="#">社員登録</a></li>
			</ul></li>
		<li><a href="#">人事管理</a>
			<ul class="submenu">
				<li><a href="#">社員一覧</a></li>
				<li><a href="#">社員情報修正</a></li>
			</ul></li>
		<li><a href="#">勤怠管理</a>
			<ul class="submenu">
				<li><a href="#">勤怠入力</a></li>
				<li><a href="#">勤怠一覧</a></li>
			</ul></li>
		<li><a href="#">給与管理</a>
			<ul class="submenu">
				<li><a href="#">給与入力</a></li>
				<li><a href="#">給与台帳</a></li>
			</ul></li>
		<li><a href="#">退職管理</a>
			<ul class="submenu">
				<li><a href="#">退職処理</a></li>
				<li><a href="#">退職給与入力</a></li>
			</ul></li>
	</ul>
	<br>
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
					alert('입력되지 않은 칸이 있습니다.');
				</script>
			</c:if>
			<c:if test="${errors.notMatch }">
				<script>
					alert('암호와 확인이 일치하지 않습니다.');
				</script>
			</c:if>
			<c:if test="${errors.duplicatedId }">
				<script>
					alert('이미 사용중인 아이디입니다.');
				</script>
			</c:if>
		</form>
	</div>
</body>
</html>