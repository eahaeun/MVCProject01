<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠登録</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
}

h3 {
	text-align: center;
	background-color: #0074e4;
	color: #ffffff;
	padding: 10px;
}

.container {
	margin: 0 auto;
	max-width: 800px;
	padding: 20px;
	background-color: #ffffff;
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
	color: #fff;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

footer {
	text-align: center;
	background-color: #0074e4;
	color: #fff;
	padding: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/header.jsp" />
	<h3>勤怠登録</h3>
	<br />

	<form>
		<table border="1">
			<tr>
				<td>社員番号</td>
				<td><input type="text" name="shain_no"></td>
			</tr>
			<tr>
				<td>入力日</td>
				<td><input type="text" name="KINTAI_KM"></td>
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
		<button type="submit" formaction="regist.do" formmethod="post">登録</button>
	</form>
	<br />
	</div>
</body>
<footer>
	<div align="center">
		<br /> <br /> Copyright
	</div>
</footer>
<script>
	$(function() {
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
</script>

</html>