<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退社処理完了</title>
</head>
<body>
    <%
       String message = "退社処理が完了しました。";
    %>

    <script>
       alert('<%= message %>');
       window.location.href = "taishokushaRegist.do";
    </script>
    
    
</body>
</html>