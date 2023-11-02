<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="./css/mainpage.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠登録</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #fff;
	color: #000;
}

h3 {
	text-align: center;
	background-color: #000;
	color: #fff;
	padding: 10px;
}

.container {
	margin: 0 auto;
	max-width: 800px;
	padding: 20px;
	background-color: #000;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: left;
}

select, input[type="text"] {
	width: 100%;
	padding: 5px;
}

button {
	background-color: #0074e4;
	color: #000;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<form action="kintaiRegist.do" method="get">
	</form>
	<br />
	<div style="display: flex;">
		<div style="flex: 1; margin-right: 10px;">
			<table border="1">
				<tr>
					<th></th>
					<th>社員番号</th>
					<th>社員名</th>
					<th>部署名</th>
					<th>役職名</th>
				</tr>
				<c:forEach var="shain" items="${shain}">
				<tr>
				<td><input type="checkbox" name="shain_no_checkbox"
						onclick="autoFillShainNo()"></td>
					<td>${001}</td>
					<td>${shain.shain_nm}</td>
					<td>${shain.busho_nm}</td>
					<td>${shain.yakushoku_nm}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div style="flex: 1;">
			<form>
				<table border="1">
					<tr>
						<td>入力日</td>
						<td><input type="text" id="KINTAI_KM" name="KINTAI_KM"></td>
					</tr>
					<tr>
						<td>勤怠項目</td>
						<td><select name="NYUROKU_YMD">
								<option value="出張">出張</option>
								<option value="休暇">休暇</option>
								<option value="休日勤務">休日勤務</option>
						</select>
					</tr>
					<tr>
						<td>開始日</td>
						<td><input type="text" id="KAISHI_YMD" name="KAISHI_YMD"></td>
					</tr>
					<tr>
						<td>終了日</td>
						<td><input type="text" id="SHURYO_YMD" name="SHURYO_YMD"></td>
					</tr>

					<tr>
						<td>手当</td>
						<td><input type="text" name="KINTAI_PAY"></td>
					</tr>
				</table>
				<br />
				<button type="submit" formaction="regist.do" formmethod="post"
					style="background-color: #000; color: #fff;">登録</button>
			</form>
		</div>
	</div>
	<br />
	</div>
</body>

<script>
	$(function() {
		$("#KINTAI_KM").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
		});
		$("#KAISHI_YMD").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
		});
		$("#SHURYO_YMD").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
		});
	});
	function autoFillShainNo() {
		var shainNoCheckbox = document.getElementById("shainNoCheckbox");
		var shainNoInput = document.getElementsByName("shain_no")[0];
		if (shainNoCheckbox.checked) {
			shainNoInput.value = "";

		}

		else {
			shainNoInput.value = "";

		}
	}
</script>

</html>
