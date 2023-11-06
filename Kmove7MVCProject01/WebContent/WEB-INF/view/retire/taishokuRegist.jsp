<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>退職処理</title>
    <link rel="stylesheet" type="text/css" href="./css/taishoku.css">
</head>
<body>
<%@ include file="/WEB-INF/view/header.jsp" %>
<br/>
<form action="taishokuRegist.do" method="POST">
    <div align="center">
        <div class="input-container">
            <h2>退職処理</h2>
            <label for="taishoku_jiyu">退社事由: </label>
            <input type="text" name="taishoku_jiyu" value="${param.taishoku_jiyu}" id="taishoku_jiyu"><br>
            <label for="taishoku_renraku">退社後の連絡先: </label>
            <input type="text" name="taishoku_renraku" value="${param.taishoku_renraku}" id="taishoku_renraku"><br>
            <label for="taishoku_pay">退職金: </label>
            <input type="text" name="taishoku_pay" value="${param.taishoku_pay}" id="taishoku_pay"><br>
            <input type="hidden" name="shain_no" value="${shain_no}">
        </div>
        <br/>
        <div align="center">
            <input type="submit" value="退社処理">
        </div>
    </div>
</form>
</body>
</html>
