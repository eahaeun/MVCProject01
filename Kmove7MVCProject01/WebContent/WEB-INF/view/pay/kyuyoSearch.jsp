<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<link rel="stylesheet" type="text/css" href="./css/kyuyoSearch.css">
<script src="https://kit.fontawesome.com/bda9280492.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>

	<!-- 검색 창과 버튼 -->
	<form action="kyuyoCalculate.do" method="get">
		<div class="search-box">
			<input type="text" class="search-input" placeholder="社員番号を入力" name="shain_no">
			<input type="submit" value="検索" class="search-button">
		</div>
	</form>
</body>
</html>