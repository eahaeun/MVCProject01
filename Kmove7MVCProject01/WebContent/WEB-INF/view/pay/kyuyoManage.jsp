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
	<br />
	<table>
		<tr>
			<th colspan="5" style="text-align: left;">・氏名：${shain.shain_nm}
				&nbsp;&nbsp;&nbsp;&nbsp; ・部署：${shain.busho_nm}
				&nbsp;&nbsp;&nbsp;&nbsp; ・役職：${shain.yakushoku_nm}</th>
		</tr>
		<tr>
			<th>帰属年月</th>
			<th>給総額</th>
			<th>除総額</th>
			<th>差引支給額</th>
			<th>削除</th>
		</tr>
		<c:choose>
			<c:when test="${kyuyo==null}">
				<tr>
					<td colspan="5"><b>登録された給与記録がありません。</b></td>
				</tr>
			</c:when>
			<c:when test="${kyuyo != null }">
				<c:forEach var="kyuyoObj" items="${kyuyo}">
					<tr>
						<td>${kyuyoObj.kizoku_ym}</td>
						<td>${kyuyoObj.sikyu_pay}円</td>
						<td>${kyuyoObj.kojyo_pay}円</td>
						<td>${kyuyoObj.sikyu_pay - kyuyoObj.kojyo_pay}円</td>
						<td>
							<form onsubmit="return confirmDelete();">
								<!-- Hidden fields to store data -->
								<input type="hidden" name="shain_no" value="${shain.shain_no}">
								<input type="hidden" name="kizoku_ym"
									value="${kyuyoObj.kizoku_ym}">
								<button type="submit" formaction="kyuyoDelete.do"
									formaction="post">削除</button>
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
			</c:when>
		</c:choose>
	</table>

	<script>
		// 확인 대화 상자를 표시하는 JavaScript 함수
		function confirmDelete() {
			return confirm("本当に削除しますか？");
		}
	</script>

</body>
</html>