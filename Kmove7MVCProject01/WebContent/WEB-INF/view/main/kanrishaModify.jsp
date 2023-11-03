<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>情報修正</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<body>
    <%@ include file="/WEB-INF/view/header.jsp" %>
    <br>
    <form action="kanrishaModify.do" method="post">
        <div class="container">
            <div style="font-size: 50px">
                <i class="fa-solid fa-user" style="color: #000000;"></i>
            </div>
            <h2>情報修正</h2>
            <div>
                <label for="id">ID:</label>
                <% project.model.bean.Kanrisha kanrisha = (project.model.bean.Kanrisha) session.getAttribute("authUser"); %>
                <%= kanrisha.getKanrisha_uid() %>
            </div>
            <div>
                <label for="curPwd">現在PW:</label> <input type="password" name="curPwd">
            </div>
			<c:if test="${errors.curPwd}">現在のパスワードの入力をお願いします。</c:if>
			<c:if test="${errors.badCurPwd}">現在のパスワードと一致しません。</c:if>
            <div>
                <label for="newPwd">変更PW:</label> <input type="password" name="newPwd">
            </div>
			<c:if test="${errors.newPwd}">新しいパスワードの入力をお願いします。</c:if>
            <div>
                <label for="kanrisha_nm">氏名:</label> <input type="text" name="newNm">
            </div>
			<c:if test="${errors.newNm}">氏名の入力をお願いします。</c:if>
            <div class="button-container">
                <button type="submit" class="search-button">修正</button>
            </div>
        </div>
    </form>
</body>
</html>
