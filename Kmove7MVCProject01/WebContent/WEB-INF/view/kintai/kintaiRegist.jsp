<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠登録</title>
<link rel="stylesheet" type="text/css" href="./css/kintaiRegist.css">
</head>
<body>
	<form id="kinReg" method="post" action="kintaiRegist.do">
		<%@ include file="/WEB-INF/view/header.jsp"%>
		<br />
		<div>
			<div class="left-div">
				<table border="1">
					<tr>
						<th></th>
						<th>社員番号</th>
						<th>社員名</th>
						<th>部署名</th>
						<th>役職名</th>
					</tr>
					<c:choose>
						<c:when test="${shain==null}">
							<tr>
								<td colspan=7><b>一致する社員番号がありません。</b></td>
							</tr>
						</c:when>

						<c:when test="${shain != null }">
							<c:forEach var="shain" items="${shain}">
								<tr>
									<td><input type="checkbox" value="${shain.shain_no}"
										name="shain_no_checkbox"></td>
									<td>${shain.shain_no}</td>
									<td>${shain.shain_nm}</td>
									<td>${shain.busho_nm}</td>
									<td>${shain.yakushoku_nm}</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</table>
			</div>
		</div>

		<div class="right-div">
			<table border="1">
				<tr>
					<td>入力日</td>
					<td><input type="text" id="NYUROKU_YMD" name="NYUROKU_YMD"></td>
				</tr>
				<tr>
					<td>勤怠項目</td>
					<td><select name="KINTAI_KM">
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
			<button type="submit" form="kinReg">登録</button>
		</div>
	</form>
	<br />
</body>

<script>
	$(function() {
		$("#NYUROKU_YMD").datepicker({
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