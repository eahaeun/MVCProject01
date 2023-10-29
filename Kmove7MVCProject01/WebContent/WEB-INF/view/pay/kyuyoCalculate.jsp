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
        h1 {
            margin: 10px 0;
        }

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

        ul.menu li.logout {
            position: absolute;
            top: 0;
            right: 10px;
        }

        ul.menu li.logout a {
            background-color: #555;
            color: #fff;
        }

        .search-box {
            text-align: center;
            margin-top: 20px;
        }

        .search-input {
            padding: 5px;
        }

        .search-button {
            padding: 5px 10px;
            background-color: #555;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        .payment-deduction-container {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 20px;
        }

        .payment-deduction-box {
            display: flex;
            border: 1px solid #000;
            width: 35%;
        }

        .payment-box,
        .deduction-box {
            flex: 1;
            background-color: #fff;
            padding: 10px;
            display: flex;
            flex-direction: column;
        }

        .payment-box input,
        .deduction-box input {
            text-align: right;
        }

        .vl {
            border-left: 1px solid black;
            height: 285px;
        }

        .payment-box,
        .deduction-box {
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

        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 60%;
            margin: 0 auto;
        }

        th,
        td {
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

        .right-align {
            float: right;
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

    <form action="kyuyoCalculate.do" method="post">
        <div class="search-box">
            帰属年月 : <input type="month" class="search-input" name="kizoku_ym">
        </div>

        <div class="payment-deduction-container">
            <div class="payment-deduction-box">
                <div class="payment-box">
                    <h3>支給</h3>
                    <label for="basicSalary">基本給: <input type="text" name="kihon_pay" id="basicSalary" class="right-align" value=${shain.kihon_pay}></label><br>
                    <label for="holidayAllowance">休日手当: <input type="text" name="kintai_pay" id="holidayAllowance" class="right-align"></label><br>
                    <label for="mealAllowance">食費: <input type="text" name="shoku_pay" id="mealAllowance" class="right-align"></label><br>
                </div>
                <div class="vl"></div>
                <div class="deduction-box">
                    <h3>控除</h3>
                    <label for="nationalPension">国民年金: <input type="text" name="nenkin" id="nationalPension" class="right-align" value=${zeikin.nenkin}></label><br>
                    <label for="healthInsurance">健康保険: <input type="text" name="kenko" id="healthInsurance" class="right-align" value=${zeikin.kenko}></label><br>
                    <label for="employmentInsurance">雇用保険: <input type="text" name="koyo" id="employmentInsurance" class="right-align" value=${zeikin.koyo}></label><br>
                    <label for="incomeTax">所得税: <input type="text" name="shotoku" id="incomeTax" class="right-align"></label><br>
                    <label for="otherDeductions" class="right-align">その他: <input type="text" name="etc" id="otherDeductions" class="right-align"></label><br>
                </div>
            </div>
        </div>
        <input type="hidden" name="shain_number" value="${shain.shain_no}">
        <div class="search-box" align="center">
            <input class="search-button" type="submit" value="計算">
        </div>
    </form>
</body>
</html>
