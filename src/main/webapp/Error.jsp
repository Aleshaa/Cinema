<%--
  Created by IntelliJ IDEA.
  User: Alesha
  Date: 01.10.2016
  Time: 17:14
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <style>
        body {
            /* Margin bottom by footer height */
            margin-bottom: 60px;
            background-image: url(${contextPath}/resources/img/IronMan3.jpg) center no-repeat fixed;
            height: 100%;
            color: #46b8da;
        }
        .c {
            border: 1px solid #333; /* Рамка */
            display: inline-block;
            padding: 5px 15px; /* Поля */
            text-decoration: none; /* Убираем подчёркивание */
            background-color: #d0e9c6;
            color: #000; /* Цвет текста */
        }
        .c:hover {
            box-shadow: 0 0 5px rgba(0,0,0,0.3); /* Тень */
            text-decoration: none; /* Убираем подчёркивание */
            background: linear-gradient(to bottom, #fcfff4, #e9e9ce); /* Градиент */
            color: #a00;
        }
    </style>
</head>
<body>
    <form name="simpleForm" method="post" action="errorController">
        <div style="background-color: #080808; border-radius: 8px; width: 30%">
            <h1>ERROR in <c:out value="${errorMessage}"/></h1>
        </div>
        <h1 hidden="true"><c:out value="${errorMessage}"/></h1>
        <input type="submit" value="Вернуться назад" />
    </form>
</body>
</html>
