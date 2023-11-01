<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>部署登録</title>
    <link rel="stylesheet" type="text/css" href="./css/kyuyoRegist.css">
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>
    <div style="display: flex;">

        <div style="width: 50%; padding: 20px;">
            <h2>部署リスト</h2>
            <table border="1">
                <tr>
                    <th>部署名</th>
                    <th>担当者</th>
                    <th>連絡所</th>
                </tr>
                <c:forEach var="busho" items="${bushoList}">
                    <tr>
                        <td>${busho.busho_nm}</td>
                        <td>${busho.tanto_nm}</td>
                        <td>${busho.busho_renraku}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div style="width: 50%; padding: 20px;">
            <h2>部署登録</h2>
            <form action="bushoRegist.do" method="post">
                <label for="busho_nm">部署名:</label>
                <input type="text" name="busho_nm"><br><br>
                <label for="tanto_nm">担当者:</label>
                <input type="text" name="tanto_nm"><br><br>
                <label for="busho_renraku">連絡所:</label>
                <input type="text" name="busho_renraku"><br><br>
                <input type="submit" value="登録">
            </form>
        </div>
        
    </div>
</body>
</html>