<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録成功</title>
</head>
<body>
    <%
       String message = "등록이 성공적으로 완료되었습니다.";
    %>

    <script>
       alert('<%= message %>');
       window.location.href = "shainRegist.do";
    </script>
    
    
</body>
</html>