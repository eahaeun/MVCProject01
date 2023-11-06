<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報修正</title>
<link rel="stylesheet" type="text/css" href="./css/shainModify.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<br/>
	<form action="shainModify.do" method="get">
		<div class="search-box">
			<input type="text" class="search-input" placeholder="社員番号を入力"
				name="shain_no"> <input type="submit" value="検索"
				class="search-button">
		</div>
	</form>

	<form action="shainModify.do" method="POST">
		<div class="section-container">
			<div class="section">
				<h2>基本情報</h2>
				<!-- 기본 정보 -->
				社員番号: <input type="text" name="shain_no" value=${shain.shain_no}>
				<br>
				<!-- 사원 번호 -->

				社員名: <input type="text" name="shain_nm" value=${shain.shain_nm}>
				<br>
				<!-- 성함 -->
				入社日: <input type="date" name="nyusha_ymd"
					value="${shain.nyusha_ymd}"> <br>
				<!-- 입사일 -->
				退社日: <input type="date" name="taishoku_ymd"
					value="${shain.taishoku_ymd}"> <br>
				<!-- 퇴사일 -->
				住所: <input type="text" name="address" value=${shain.address}>
				<br>
				<!-- 주소 -->
				部署名: <select name="busho_nm" value=${shain.busho_nm}>
					<!-- 부서 -->
					<c:forEach var="busho" items="${bushoList}">
						<option value="${busho.busho_nm}">${busho.busho_nm}</option>
					</c:forEach>
				</select><br> 役職名: <input type="text" name="yakushoku_nm"
					value=${shain.yakushoku_nm}> <br>
				<!-- 직책명 -->
				電話番号: <input type="text" name="renraku_tel"
					value=${shain.renraku_tel}> <br>
				<!-- 전화번호 -->
				メールアドレス: <input type="text" name="renraku_email"
					value=${shain.renraku_email}> <br>
				<!-- 메일 -->
			</div>

			<div class="section">
				<h2>給与情報</h2>
				<!-- 급여 정보 -->
				基本給(万円): <select name="kihon_pay" value=${shain.kihon_pay}>
					<option value="20">20</option>
					<option value="22">22</option>
					<option value="24">24</option>
					<option value="26">26</option>
					<option value="28">28</option>
					<option value="30">30</option>
				</select> <br> 給与口座銀行: <select name="ginko_nm" value=${shain.ginko_nm}>
					<!-- 급여계좌은행 -->
					<option value="ゆうちょ銀行">ゆうちょ銀行</option>
					<!-- 우체국 은행 -->
					<option value="楽天銀行">楽天銀行</option>
					<!-- 라쿠텐 은행 -->
					<option value="新生銀行">新生銀行</option>
					<!-- 신세이 은행 -->
				</select> <br> 給与口座番号: <input type="text" name="koza_num"
					value=${shain.koza_num}> <br>
				<!-- 급여계좌번호 -->
			</div>
		</div>
		<input type="hidden" name="zaishoku_st" value="在職">
		<div class="search-box" align="center">
			<input type="submit" class="search-button" value="修整">
			<!-- 수정 -->
		</div>
	</form>
</body>
</html>