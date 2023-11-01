<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="shainlist.do" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<td>在職状態</td>
					<td>社員番号</td>
					<td>社員名</td>
					<td>住所</td>
					<td>部署名</td>
					<td>役職名</td>
					<td>電話番号</td>
					<td>メールアドレス</td>
					<td>基本給(万円)</td>
					<td>入社日</td>
					<td>退社日</td>
					<td>給与口座銀行</td>
					<td>給与口座番号</td>
				</tr>


						<c:forEach var="shain" items="${shainList}">
							<tr>
								<td>${shain.zaishoku_st}</td>
								<td>${shain.shain_no}</td>
								<td>${shain.shain_nm}</td>
								<td>${shain.address}</td>
								<td>${shain.busho_nm}</td>
								<td>${shain.yakushoku_nm}</td>
								<td>${shain.renraku_tel}</td>
								<td>${shain.renraku_email}</td>
								<td>${shain.kihon_pay}円</td>
								<td>${shain.nyusha_ymd}</td>
								<td>${shain.taishoku_ymd}</td>
								<td>${shain.ginko_nm}</td>
								<td>${shain.koza_num}</td>
							</tr>
						</c:forEach>
			</table>
</body>
</html>