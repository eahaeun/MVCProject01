<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
<link rel="stylesheet" type="text/css" href="./css/shainList.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<div class="title">
		<h1>社員一覧</h1>
	</div>
	<ul class="menu">
		<form action="shainList.do" method="GET">
			<li><button type="submit" name="list" value="在職者">在職者</button></li>
			<!-- 재직자 -->
			<li><button type="submit" name="list" value="退社者">退社者</button></li>
			<!-- 퇴직자 -->
			<li><button type="submit" name="list" value="全体">全 体</button></li>
			<!-- 전체 -->
		</form>
	</ul>
	<table>
		<tr>
			<th>状 態</th>
			<!-- 상 태 -->
			<th>社員番号</th>
			<!-- 사원번호 -->
			<th>社員名</th>
			<!-- 성 함 -->
			<th>住 所</th>
			<!-- 주 소 -->
			<th>部署名</th>
			<!-- 부 서 -->
			<th>役職名</th>
			<!-- 직책명 -->
			<th>電話番号</th>
			<!-- 전화번호 -->
			<th>メール</th>
			<!-- 메 일 -->
			<th>入社日</th>
			<!-- 입사일 -->
			<th>退社日</th>
			<!-- 퇴사일 -->
			<th>基本給</th>
			<!-- 기본급 -->
			<th>給与口座銀行</th>
			<!-- 급여계좌은행 -->
			<th>給与口座番号</th>
			<!-- 급여계좌번호 -->
		</tr>
		<c:forEach var="shain" items="${shain}">
			<tr>
				<td>${shain.zaishoku_st}</td>
				<td>${shain.shain_no}</td>
				<td>${shain.shain_nm}</td>
				<td>${shain.address}</td>
				<td>${shain.busho_nm}</td>
				<td>${shain.yakushoku_nm}</td>
				<td>${shain.renraku_tel}</td>
				<td>${shain.renraku_email}</td>
				<td>${shain.nyusha_ymd}</td>
				<td>${shain.taishoku_ymd}</td>
				<td>${shain.kihon_pay}</td>
				<td>${shain.ginko_nm}</td>
				<td>${shain.koza_num}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>