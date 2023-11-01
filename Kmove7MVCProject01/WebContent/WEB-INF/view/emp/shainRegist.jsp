<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録</title>
<link rel="stylesheet" type="text/css" href="./css/shain.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>

	<div class="title">
		<h1>社員登録</h1>
	</div>

	<form action="shainRegist.do" method="POST">
		<div class="form-container">
			<div class="section">
				<h2>基本情報</h2>
				<!-- 기본 정보 -->
				社員番号: <input type="text" name="shain_no" value="${param.shain_no}">
				<c:if test="${errors.shain_no}">사원번호를 입력하세요.</c:if>
				<br>
				<!-- 사원 번호 -->

				社員名: <input type="text" name="shain_nm" value="${param.shain_nm}">
				<c:if test="${errors.shain_nm}">사원명을 입력하세요.</c:if>
				<br>
				<!-- 성함 -->
				入社日: <input type="date" name="nyusha_ymd"
					value="${param.nyusha_ymd}">
				<c:if test="${errors.nyusha_ymd}">입사일를 입력하세요.</c:if>
				<br>
				<!-- 입사일 -->
				住所: <input type="text" name="address" value="${param.address}">
				<c:if test="${errors.adress}">주소를 입력하세요.</c:if>
				<br>
				<!-- 주소 -->
				部署名: <select name="busho_nm" value="${param.busho_nm}"><c:if
						test="${errors.busho}">부서를 입력하세요.</c:if>
					<!-- 부서 -->
					<option value="人事部">人事部</option>
					<!-- 인사부 -->
					<option value="財務部">財務部</option>
					<!-- 재무부 -->
					<option value="営業部">営業部</option>
					<!-- 영업부 -->
				</select><br> 役職名: <input type="text" name="yakushoku_nm"
					value="${param.yakushoku_nm}">
				<c:if test="${errors.yakushoku_nm}">직책명을 입력하세요.</c:if>
				<br>
				<!-- 직책명 -->
				電話番号: <input type="text" name="renraku_tel"
					value="${param.renraku_tel}">
				<c:if test="${errors.renraku_tel}">전화번호를 입력하세요.</c:if>
				<br>
				<!-- 전화번호 -->
				メールアドレス: <input type="text" name="renraku_email"
					value="${param.renraku_email}">
				<c:if test="${errors.renraku_email}">이메일를 입력하세요.</c:if>
				<br>
				<!-- 메일 -->
			</div>

			<div class="section">
				<h2>給与情報</h2>
				<!-- 급여 정보 -->
				基本給(万円): <select name="kihon_pay" value="${param.kihon_pay}"><c:if
						test="${errors.kihon_pay}">급여를 입력하세요.</c:if>
					<option value="20">20</option>
					<option value="22">22</option>
					<option value="24">24</option>
					<option value="26">26</option>
					<option value="28">28</option>
					<option value="30">30</option>
				</select><br> 給与口座銀行: <select name="ginko_nm" value="${param.ginko_nm}"><c:if
						test="${errors.ginko_nm}">은행를 입력하세요.</c:if>
					<!-- 급여계좌은행 -->
					<option value="ゆうちょ銀行">ゆうちょ銀行</option>
					<!-- 우체국 은행 -->
					<option value="楽天銀行">楽天銀行</option>
					<!-- 라쿠텐 은행 -->
					<option value="新生銀行">新生銀行</option>
					<!-- 신세이 은행 -->
				</select><br> 給与口座番号: <input type="text" name="koza_num"
					value="${param.koza_num}">
				<c:if test="${errors.koza_num}">계좌번호를 입력하세요.</c:if>
				<br>
				<!-- 급여계좌번호 -->
				<input type="hidden" name="zaishoku_st" value="在職">
			</div>
		</div>

		<div align="center">
			<input type="submit" value="登録">
			<!-- 등록 -->
		</div>
	</form>
</body>
</html>