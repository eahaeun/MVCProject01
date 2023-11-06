<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<link rel="stylesheet" type="text/css" href="./css/kintaiList.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>

	<!-- 검색 창과 버튼 -->
	<form action="kyuyoCalculate.do" method="get">
		<div class="search-box">
			<input type="text" class="search-input" placeholder="社員番号を入力"
				name="shain_no"> <input type="submit" value="検索"
				class="search-button">
		</div>
	</form>
	<br />
	<br />

	<table>
		<tr>
			<th>勤怠項目</th>
			<th>入力日</th>
			<th>開始日</th>
			<th>終了日</th>
			<th>手当</th>
		</tr>

		<c:forEach var="kintai" items="${kintaiList}">
			<tr style="cursor: pointer;"
				onClick="location.href='kintaiModify.do?kintai_no=' + '${kintai.KINTAI_NO}'">
				<td>${kintai.KINTAI_KM}</td>
				<td>${kintai.NYUROKU_YMD}</td>
				<td>${kintai.KAISHI_YMD}</td>
				<td>${kintai.SHURYO_YMD}</td>
				<td>${kintai.KINTAI_PAY}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>