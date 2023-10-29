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
h1 {
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

/* 로그아웃 버튼 스타일 추가 */
ul.menu li.logout {
	position: absolute;
	top: 0;
	right: 10px;
}

ul.menu li.logout a {
	background-color: #555;
	color: #fff;
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
	text-align: center;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
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
	<br />
	<br />
	<table>
		<tr>
			<th>帰属年月</th>
			<th>人数</th>
			<th>支給総額</th>
			<th>控除総額</th>
			<th>差引支給額</th>
		</tr>
		<c:choose>
			<c:when test="${kyuyoList==null}">
				<tr>
					<td colspan=5><b>입력된 급여내역이 없습니다.</b></td>
				</tr>
			</c:when>
			<c:when test="${kyuyoList != null }">
				<c:forEach var="kyuyo" items="${kyuyoList}">
					<tr>
						<td>${kyuyo.kizoku_ym}</td>
						<td>${kyuyo.pay_cnt}</td>
						<td>${kyuyo.sousikyu}円</td>
						<td>${kyuyo.soukojyo}円</td>
						<td>${kyuyo.sousikyu - kyuyo.soukojyo}円</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>