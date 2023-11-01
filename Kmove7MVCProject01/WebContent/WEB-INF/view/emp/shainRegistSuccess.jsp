<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
       String message = "등록이 성공적으로 완료되었습니다.";
    %>

    <script>
       alert('<%= message %>');
       window.location.href = "shainList.do";
    </script>
    
    
</body>
</html>