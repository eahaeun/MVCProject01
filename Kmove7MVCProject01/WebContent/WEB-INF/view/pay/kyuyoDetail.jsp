<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>給与詳細</title>
<link rel="stylesheet" type="text/css" href="./css/kyuyoDetail.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<br />
	
	<!-- 該当する帰属年月に給与情報を持っている社員の情報を表示 -->
	<table>
		<tr>
			<th colspan="8" style="text-align: left;">・帰属年月：${kizoku_ym}</th>
		</tr>
		<tr>
			<th>氏名</th>
			<th>入社日</th>
			<th>部署</th>
			<th>役職</th>
			<th>基本給</th>
			<th>支給総額</th>
			<th>控除総額</th>
			<th>差引支給額</th>
		</tr>
		<c:choose>
			<c:when test="${kyuyoDetail==null}">
				<tr>
					<td colspan="8"><b>입력된 급여내역이 없습니다.</b></td>
				</tr>
			</c:when>
			<c:when test="${kyuyoDetail != null }">
				<c:set var="totalKihonPay" value="0" />
				<c:set var="totalSikyuPay" value="0" />
				<c:set var="totalKojyoPay" value="0" />
				<c:set var="totalSashihikiPay" value="0" />
				<c:forEach var="kyuyo" items="${kyuyoDetail}">
					<tr>
						<td>${kyuyo.shain_nm}</td>
						<td>${kyuyo.nyusha_ymd}</td>
						<td>${kyuyo.busho_nm}</td>
						<td>${kyuyo.yakushoku_nm}</td>
						<td>${kyuyo.kihon_pay}円</td>
						<td>${kyuyo.sikyu_pay}円</td>
						<td>${kyuyo.kojyo_pay}円</td>
						<td>${kyuyo.sikyu_pay - kyuyo.kojyo_pay}円</td>
					</tr>
					<c:set var="totalKihonPay"
						value="${totalKihonPay + kyuyo.kihon_pay}" />
					<c:set var="totalSikyuPay"
						value="${totalSikyuPay + kyuyo.sikyu_pay}" />
					<c:set var="totalKojyoPay"
						value="${totalKojyoPay + kyuyo.kojyo_pay}" />
					<c:set var="totalSashihikiPay"
						value="${totalSashihikiPay + (kyuyo.sikyu_pay - kyuyo.kojyo_pay)}" />
				</c:forEach>
				<tr>
					<td colspan="4">合計</td>
					<td>${totalKihonPay}円</td>
					<td>${totalSikyuPay}円</td>
					<td>${totalKojyoPay}円</td>
					<td>${totalSashihikiPay}円</td>
			</c:when>
		</c:choose>
	</table>
</body>
</html>