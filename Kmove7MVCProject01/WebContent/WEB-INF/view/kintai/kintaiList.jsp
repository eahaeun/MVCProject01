<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

	<title>勤怠一覧</title>
	<div align="center">社員照会</div>

	<%@ include file="/WEB-INF/view/header.jsp"%>
	<div align="center">
		<h3>社員番号照会</h3>
		<br />
		<table border="1">
			<tr>
				<th>社員番号</th>
			</tr>
			<c:choose>
				<c:when test="${shainList==null}">
					<tr>
						<td colspan=7><b>一致する社員番号がありません。</b></td>
					</tr>
				</c:when>
				<c:when test="${shainList != null }">
					<c:forEach var="shain" items="${shainList}">
						<tr>
							<td>${shain.shain_no}</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</div>
</body>
</html>