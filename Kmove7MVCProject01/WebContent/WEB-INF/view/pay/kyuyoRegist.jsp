<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<link rel="stylesheet" type="text/css" href="./css/kyuyoRegist.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>

	<form action="kyuyoCalculate.do" method="get">
		<div class="search-box">
			<input type="text" name="shain_no" class="search-input"
				value="${shain.shain_no}"> <input type="submit" value="検索"
				class="search-button">
		</div>
	</form>
	<br />

	<table>
		<tr>
			<th>社員番号</th>
			<th>氏名</th>
			<th>部署</th>
			<th>役職</th>
			<th>在職状態</th>
			<th>給与記録</th>
		</tr>
		<tr>
			<td>${shain.shain_no}</td>
			<td>${shain.shain_nm}</td>
			<td>${shain.busho_nm}</td>
			<td>${shain.yakushoku_nm}</td>
			<td>${shain.zaishoku_st}</td>
			<td><button onclick="openPopup()">管理</button></td>
		</tr>
	</table>

	<form action="kyuyoRegist.do" method="post">
		<div class="search-box">
			帰属年月 : <input type="month" class="search-input" name="kizoku_ym"
				value="${kyuyoReq.kizoku_ym}">
		</div>

		<!-- 추가된 내용: 지급과 공제내역을 입력할 박스 컨테이너 -->
		<div class="payment-deduction-container">
			<div class="payment-deduction-box">
				<!-- 지급내역 박스 -->
				<div class="payment-box">
					<h3>支給</h3>
					<label for="basicSalary">基本給: <input type="text"
						id="basicSalary" class="right-align" value=${kyuyoReq.kihon_pay}></label><br>
					<label for="holidayAllowance">休日手当: <input type="text"
						id="holidayAllowance" class="right-align"
						value=${kyuyoReq.kintai_pay}></label><br> <label
						for="mealAllowance">食費: <input type="text"
						id="mealAllowance" class="right-align" value=${kyuyoReq.shoku_pay}></label><br>
					<label for="incomeTax" class="special-label">空欄: <input
						type="text" id="incomeTax" class="zero-align"></label><br> <label
						for="otherDeductions" class="special-label">空欄: <input
						type="text" id="otherDeductions" class="zero-align"></label><br>
					<div class="horizontal-line"></div>

					<!-- 추가된 내용: 지급액 입력란 (밑에 추가) -->
					&nbsp; <label for="otherDeductions">支給額: <span
						style="float: right;">${sikyu_pay}円</span></label><br>
				</div>

				<!-- 검정색 세로 분리선 -->
				<div class="vl"></div>

				<!-- 공제내역 박스 -->
				<div class="deduction-box">
					<h3>控除</h3>
					<label for="nationalPension">国民年金: <input type="text"
						id="nationalPension" class="right-align" value=${kyuyoReq.nenkin}></label><br>
					<label for="healthInsurance">健康保険: <input type="text"
						id="healthInsurance" class="right-align" value=${kyuyoReq.kenko}></label><br>
					<label for="employmentInsurance">雇用保険: <input type="text"
						id="employmentInsurance" class="right-align" value=${kyuyoReq.koyo}></label><br>
					<label for="incomeTax">所得税: <input type="text"
						id="incomeTax" class="right-align" value=${kyuyoReq.shotoku}></label><br>
					<label for="otherDeductions">その他: <input type="text"
						id="otherDeductions" class="right-align" value=${kyuyoReq.etc}></label><br>
					<div class="horizontal-line"></div>

					<!-- 추가된 내용: 공제액 입력란 (밑에 추가) -->
					&nbsp; <labelfor "otherDeductions">控除: <span style="float: right;">${kojyo_pay}円</span></label><br>
	            </div>
			</div>
		</div>
		<div align="center">
			<h3>総支給額は${sosikyu_pay}円です。</h3>
		</div>

		<!-- 히든 -->
		<input type="hidden" name="shain_number" value="${shain.shain_no}">
		<input type="hidden" name="sikyu_pay" value="${sikyu_pay}"> <input
			type="hidden" name="kojyo_pay" value="${kojyo_pay}">

		<div class="search-box" align="center">
			<input type="submit" value="保存">
		</div>
		<br />
		<br />
	</form>

	<script>
		function openPopup() {
			var width = 800;
			var height = 500;
			var left = (window.innerWidth - width) / 2;
			var top = (window.innerHeight - height) / 2;
			var options = 'width=' + width + ',height=' + height + ',left='
					+ left + ',top=' + top;
			var shainNo = "${shain.shain_no}".trim();
			// 새로운 창을 열기
			window.open('kyuyoManage.do?shain_no=' + shainNo, '給与管理', options);
		}
	</script>
</body>
</html>
