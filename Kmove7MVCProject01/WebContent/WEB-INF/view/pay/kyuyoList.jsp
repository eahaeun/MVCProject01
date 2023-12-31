<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録ページ</title>
<link rel="stylesheet" type="text/css" href="./css/kyuyoList.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>
	<br />
	
	<!-- 給与を支給月別に表示 -->
	<table>
		<tr>
			<th>帰属年月</th>
			<th>人数</th>
			<th>支給総額</th>
			<th>控除総額</th>
			<th>差引支給額</th>
		</tr>
		<c:choose>
			<c:when test="${kyuyoList==null}">
				<tr>
					<td colspan=5><b>登録された給与記録がありません。</b></td>
				</tr>
			</c:when>
			<c:when test="${kyuyoList != null }">
				<c:forEach var="kyuyo" items="${kyuyoList}">
					<tr style="cursor: pointer;" onClick="location.href='kyuyoDetail.do?kizoku_ym=' + '${kyuyo.kizoku_ym}'">
						<td>${kyuyo.kizoku_ym}</td>
						<td>${kyuyo.pay_cnt}</td>
						<td>${kyuyo.sousikyu}円</td>
						<td>${kyuyo.soukojyo}円</td>
						<td>${kyuyo.sousikyu - kyuyo.soukojyo}円</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>