<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員登録ページ</title>
    <style>
                /* 스타일 설정 */
        h3 {
            text-align: center;
        }

        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .title {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
        }

        ul.menu {
            list-style: none;
            padding: 0;
            text-align: center;
            background-color: #f2f2f2;
            margin: 0;
        }

        ul.menu li {
            display: inline-block;
            margin: 0 20px;
            position: relative;
        }

        ul.menu li a {
            text-decoration: none;
            color: #000;
            display: block;
            padding: 10px 20px;
            transition: background-color 0.3s;
            background-color: #f2f2f2;
        }

        ul.menu li a:hover {
            background-color: #555;
            color: #fff;
        }

        ul.menu li ul.submenu {
            display: none;
            position: absolute;
            top: 100%;
            left: 0;
            list-style: none;
            padding: 0;
        }

        ul.menu li:hover ul.submenu {
            display: block;
            background-color: #333;
            border-top: 1px solid #555;
        }

        ul.submenu li {
            margin: 0;
        }

        ul.submenu li a {
            display: block;
            padding: 10px 20px;
            color: #000;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        ul.submenu li a:hover {
            background-color: #555;
        }

        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 60%;
            margin: 0 auto;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 5px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #fff;
        }

        /* 추가된 스타일 */
        .search-box {
            text-align: center;
            margin-top: 20px;
        }

        .search-input {
            padding: 5px;
        }

        .null-input {
            opacity: 0;
        }

        .search-button {
            padding: 5px 10px;
            background-color: #555;
            color: #fff;
            border: none;
        }

        /* 추가된 스타일: 박스 컨테이너 */
        .payment-deduction-container {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 20px;
        }

        /* 추가된 스타일: 지급과 공제내역 박스 */
        .payment-deduction-box {
            display: flex;
            border: 1px solid #000;
            width: 35%;
        }

        .payment-box, .deduction-box {
            flex: 1;
            background-color: #fff;
            padding: 10px;
            display: flex;
            flex-direction: column;
        }

        /* 추가된 스타일: 오른쪽 정렬 */
        .payment-box input, .deduction-box input {
            text-align: right;
        }

        /* 추가된 스타일: 검정색 세로 분리선 */
        .vl {
            border-left: 1px solid black;
            height: 350px;
        }

        /* 수정된 스타일: 지급과 공제내역 박스 크기 조정 */
        .payment-box, .deduction-box {
            padding: 0 10px;
        }

        .special-label {
            color: white;
        }

        .horizontal-line {
            border-top: 1px solid black;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        .right-align {
            float: right;
        }

        .zero-align {
            float: right;
            opacity: 0;
        }

        /* 테이블 */
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 60%;
            margin: 0 auto;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 5px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #fff;
        }
    </style>
    <script src="https://kit.fontawesome.com/bda9280492.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="title">
        <h1>
            <a href="main.do" style="text-decoration: none; color: white;">人事・給与管理システム</a>
        </h1>
    </div>
    <ul class="menu">
        <c:if test="${!empty authUser}">
            <li class="logout"><a href="logout.do">ログアウト</a></li>
        </c:if>
        <li><a href="#">基本設定</a>
            <ul class="submenu">
                <li><a href="#">情報修正</a></li>
                <li><a href="#">部署登録</a></li>
                <li><a href="#">社員登録</a></li>
            </ul>
        </li>
        <li><a href="#">人事管理</a>
            <ul class="submenu">
                <li><a href="#">社員一覧</a></li>
                <li><a href="#">社員情報修正</a></li>
            </ul>
        </li>
        <li><a href="#">勤怠管理</a>
            <ul class="submenu">
                <li><a href="#">勤怠入力</a></li>
                <li><a href="#">勤怠一覧</a></li>
            </ul>
        </li>
        <li><a href="#">給与管理</a>
            <ul class="submenu">
                <li><a href="#">給与入力</a></li>
                <li><a href="#">給与台帳</a></li>
            </ul>
        </li>
        <li><a href="#">退職管理</a>
            <ul class="submenu">
                <li><a href="#">退職処理</a></li>
                <li><a href="#">退職給与入力</a></li>
            </ul>
        </li>
    </ul>
    <br />

    <form action="kyuyoCalculate.do" method="get">
        <div class="search-box">
            <input type="text" name="shain_no" class="search-input" value="${shain.shain_no}">
            <input type="submit" value="検索" class="search-button">
        </div>
    </form>
    <br />

    <table>
        <tr>
            <th>社員番号</th>
            <th>氏名</th>
            <th>部署</th>
            <th>役職</th>
            <th>在職状態</th>
        </tr>
        <tr>
            <td>${shain.shain_no}</td>
            <td>${shain.shain_nm}</td>
            <td>${shain.busho_nm}</td>
            <td>${shain.yakushoku_nm}</td>
            <td>${shain.zaishoku_st}</td>
        </tr>
    </table>

    <form action="kyuyoRegist.do" method="post">
        <div class="search-box">
            帰属年月 : <input type="month" class="search-input" name="kizoku_ym" value="${kyuyoReq.kizoku_ym}">
        </div>

	    <!-- 추가된 내용: 지급과 공제내역을 입력할 박스 컨테이너 -->
	    <div class="payment-deduction-container">
	        <div class="payment-deduction-box">
	            <!-- 지급내역 박스 -->
	            <div class="payment-box">
	                <h3>支給</h3>
	                <label for="basicSalary">基本給: <input type="text" id="basicSalary" class="right-align" value=${kyuyoReq.kihon_pay}></label><br>
	                <label for="holidayAllowance">休日手当: <input type="text" id="holidayAllowance" class="right-align" value=${kyuyoReq.kintai_pay}></label><br>
	                <label for="mealAllowance">食費: <input type="text" id="mealAllowance" class="right-align" value=${kyuyoReq.shoku_pay}></label><br>
	                <label for="incomeTax" class="special-label">空欄: <input type="text" id="incomeTax" class="zero-align"></label><br>
	                <label for="otherDeductions" class="special-label">空欄: <input type="text" id="otherDeductions" class="zero-align"></label><br>
	                <div class="horizontal-line"></div>
	
	                <!-- 추가된 내용: 지급액 입력란 (밑에 추가) -->
	                &nbsp;
	                <label for="otherDeductions">支給額: <span style="float: right;">${sikyu_pay}円</span></label><br>
	            </div>
	
	            <!-- 검정색 세로 분리선 -->
	            <div class="vl"></div>
	
	            <!-- 공제내역 박스 -->
	            <div class="deduction-box">
	                <h3>控除</h3>
	                <label for= "nationalPension">国民年金: <input type="text" id="nationalPension" class="right-align" value=${kyuyoReq.nenkin}></label><br>
	                <label for= "healthInsurance">健康保険: <input type="text" id="healthInsurance" class="right-align" value=${kyuyoReq.kenko}></label><br>
	                <label for= "employmentInsurance">雇用保険: <input type="text" id="employmentInsurance" class="right-align" value=${kyuyoReq.koyo}></label><br>
	                <label for= "incomeTax">所得税: <input type="text" id="incomeTax" class="right-align" value=${kyuyoReq.shotoku}></label><br>
	                <label for= "otherDeductions">その他: <input type="text" id="otherDeductions" class="right-align" value=${kyuyoReq.etc}></label><br>
	                <div class="horizontal-line"></div>
	
	                <!-- 추가된 내용: 공제액 입력란 (밑에 추가) -->
	                &nbsp;
	                <label for "otherDeductions">控除: <span style="float: right;">${kojyo_pay}円</span></label><br>
	            </div>
	        </div>
	    </div>
	    <div align="center">
	        <h3>総支給額は${sosikyu_pay}円です。</h3>
	    </div>
	    
	    <!-- 히든 -->
	    <input type="hidden" name="shain_number" value="${shain.shain_no}">
	    <input type="hidden" name="sikyu_pay" value="${sikyu_pay}">
	    <input type="hidden" name="kojyo_pay" value="${kojyo_pay}">
	    
	    <div class="search-box" align="center">
	        <input type="submit" value="保存">
	    </div>
    </form>
</body>
</html>
