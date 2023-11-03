<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="title">
	<h1>
		<a href="main.do" style="text-decoration: none; color: white;">人事・給与管理システム</a>
	</h1>
</div>
<ul class="menu">
	<!-- 로그인 되어있을 때만 상단에 로그아웃 버튼 추가 -->
	<c:if test="${!empty authUser}">
		<li class="logout"><a href="logout.do">ログアウト</a></li>
	</c:if>
	<li><a href="#">基本設定</a>
		<ul class="submenu">
			<li><a href="kanrishaModify.do">情報修正</a></li>
			<li><a href="bushoRegist.do">部署登録</a></li>
			<li><a href="shainRegist.do">社員登録</a></li>
		</ul></li>
	<li><a href="#">人事管理</a>
		<ul class="submenu">
			<li><a href="shainList.do">社員一覧</a></li>
			<li><a href="shainSearch.do">社員情報修正</a></li>
		</ul></li>
	<li><a href="#">勤怠管理</a>
		<ul class="submenu">
			<li><a href="kintaiList.do">勤怠入力</a></li>
			<li><a href="kintaiSearch.do">勤怠一覧</a></li>
		</ul></li>
	<li><a href="#">給与管理</a>
		<ul class="submenu">
			<li><a href="kyuyoSearch.do">給与入力</a></li>
			<li><a href="kyuyoList.do">給与台帳</a></li>
		</ul></li>
	<li><a href="#">退職管理</a>
		<ul class="submenu">
			<li><a href="taishokuSearch.do">退職処理</a></li>
			<li><a href="taishokukinSearch.do">退職給与入力</a></li>
		</ul></li>
</ul>
<br />