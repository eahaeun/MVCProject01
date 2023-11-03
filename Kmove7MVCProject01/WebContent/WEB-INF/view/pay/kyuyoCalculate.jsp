<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<link rel="stylesheet" type="text/css" href="./css/kyuyoCalculate.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<c:if test="${empty shain}">
		<script>
			alert("該当する社員番号は存在しません。");
			location.href = "kyuyoSearch.do";
		</script>
	</c:if>

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

	<form action="kyuyoCalculate.do" method="post"
		onsubmit="return validateForm();">
		<div class="search-box">
			帰属年月 : <input type="month" class="search-input" name="kizoku_ym"
				id="kizoku_ym">
		</div>

		<div class="payment-deduction-container">
			<div class="payment-deduction-box">
				<div class="payment-box">
					<h3>支給</h3>
					<label for="basicSalary">基本給: <input type="text"
						name="kihon_pay" id="basicSalary" class="right-align"
						value=${shain.kihon_pay}></label><br> <label
						for="holidayAllowance">休日手当: <input type="text"
						name="kintai_pay" id="holidayAllowance" class="right-align"></label><br>
					<label for="mealAllowance">食費: <input type="text"
						name="shoku_pay" id="mealAllowance" class="right-align"></label><br>
				</div>
				<div class="vl"></div>
				<div class="deduction-box">
					<h3>控除</h3>
					<label for="nationalPension">国民年金: <input type="text"
						name="nenkin" id="nationalPension" class="right-align"
						value=${zeikin.nenkin}></label><br> <label
						for="healthInsurance">健康保険: <input type="text"
						name="kenko" id="healthInsurance" class="right-align"
						value=${zeikin.kenko}></label><br> <label
						for="employmentInsurance">雇用保険: <input type="text"
						name="koyo" id="employmentInsurance" class="right-align"
						value=${zeikin.koyo}></label><br> <label for="incomeTax">所得税:
						<input type="text" name="shotoku" id="incomeTax"
						class="right-align">
					</label><br> <label for="otherDeductions" class="right-align">その他:
						<input type="text" name="etc" id="otherDeductions"
						class="right-align">
					</label><br>
				</div>
			</div>
		</div>
		<input type="hidden" name="shain_number" value="${shain.shain_no}">
		<div class="search-box" align="center">
			<input class="search-button" type="submit" value="計算">
		</div>
	</form>
	<script>
		function validateForm() {
			var kizoku_ym = document.getElementById("kizoku_ym").value;
			if (kizoku_ym === "") {
				alert("帰属年月を入力してください。");
				return false;
			}
			return true;
		}

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
