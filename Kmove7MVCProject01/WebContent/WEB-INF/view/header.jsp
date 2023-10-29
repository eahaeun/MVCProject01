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
<
style> /* 스타일 설정 */ h3 {
	text-align: center;
}

body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.title {
	background-color: #333;
	color: #fff;
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

table {
	font-family: Arial, sans-serif;
	border-collapse: collapse;
	width: 60%;
	margin: 0 auto;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 5px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #fff;
}

/* 추가된 스타일 */
.search-box {
	text-align: center;
	margin-top: 20px;
}

.search-input {
	padding: 5px;
}

.null-input {
	opacity: 0;
}

.search-button {
	padding: 5px 10px;
	background-color: #555;
	color: #fff;
	border: none;
}

/* 추가된 스타일: 박스 컨테이너 */
.payment-deduction-container {
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 20px;
}

/* 추가된 스타일: 지급과 공제내역 박스 */
.payment-deduction-box {
	display: flex;
	border: 1px solid #000;
	width: 35%;
}

.payment-box, .deduction-box {
	flex: 1;
	background-color: #fff;
	padding: 10px;
	display: flex;
	flex-direction: column;
}

/* 추가된 스타일: 오른쪽 정렬 */
.payment-box input, .deduction-box input {
	text-align: right;
}

/* 추가된 스타일: 검정색 세로 분리선 */
.vl {
	border-left: 1px solid black;
	height: 350px;
}

/* 수정된 스타일: 지급과 공제내역 박스 크기 조정 */
.payment-box, .deduction-box {
	padding: 0 10px;
}

.special-label {
	color: white;
}

.horizontal-line {
	border-top: 1px solid black;
	margin-top: 10px;
	margin-bottom: 10px;
}

.right-align {
	float: right;
}

.zero-align {
	float: right;
	opacity: 0;
}

/* 테이블 */
table {
	font-family: Arial, sans-serif;
	border-collapse: collapse;
	width: 60%;
	margin: 0 auto;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 5px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #fff;
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
		<!-- 로그인 되어있을 때만 상단에 로그아웃 버튼 추가 -->
		<c:if test="${!empty authUser}">
			<li class="logout"><a href="logout.do">ログアウト</a></li>
		</c:if>
		<li><a href="#">基本設定</a>
			<ul class="submenu">
				<li><a href="kanrishaModify.do">情報修正</a></li>
				<li><a href="bushoRegist.do">部署登録</a></li>
				<li><a href="shainRegist.do">社員登録</a></li>
			</ul></li>
		<li><a href="#">人事管理</a>
			<ul class="submenu">
				<li><a href="shainList.do">社員一覧</a></li>
				<li><a href="shainSearch.do">社員情報修正</a></li>
			</ul></li>
		<li><a href="#">勤怠管理</a>
			<ul class="submenu">
				<li><a href="kintaiRegist.do">勤怠入力</a></li>
				<li><a href="kintaiSearch.do">勤怠一覧</a></li>
			</ul></li>
		<li><a href="#">給与管理</a>
			<ul class="submenu">
				<li><a href="kyuyoSearch.do">給与入力</a></li>
				<li><a href="kyuyoList.do">給与台帳</a></li>
			</ul></li>
		<li><a href="#">退職管理</a>
			<ul class="submenu">
				<li><a href="taishokuSearch.do">退職処理</a></li>
				<li><a href="taishokukinSearch.do">退職給与入力</a></li>
			</ul></li>
	</ul>
</body>
</html>