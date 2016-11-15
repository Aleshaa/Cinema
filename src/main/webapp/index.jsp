<%--
  Created by IntelliJ IDEA.
  User: Alesha
  Date: 01.10.2016
  Time: 11:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cinema</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <style>
      body {
        height: 100%;
        color: #abdad4;
      }
      .filter-form {
        background-color: #3a3a3a;
        border-radius: 5px;
        width: 500px;
        align-items: left;
        padding-top: 10px;
      }
      input, select {
        background: #494549 !important;
      }
      input[type="text"] {
        border: 3px solid #525252;
      }
      .on-left {
        text-align: left;
        margin-left: 50px;
      }
    </style>
  </head>
  <body>
  <div class="container" align="center">
    <div class="filter-form">
      <form name="simpleForm" method="post" action="cinemaController" class="pro-form" id="pro-form">
        <span style="font-size: small; color: #ec971f">* - обязательные для заполнения поля</span>
        Продолжительность фильма<span style="color: #ec971f">*</span>: <br>
        от <input type="time" name="startDuration" value="00:40" min="00:01" max="24:00" required> <br>
        до <input type="time" name="endDuration" value="03:00" min="00:01" max="24:00" required> <br>
        <br>
        <div class="field">
          <label>Жанр<span style="color: #ec971f">*</span>:</label> <br>
          <div class="on-left">
            <input type="checkbox" name="genre" value="Fantastic" checked> Фантастика<br>
            <input type="checkbox" name="genre" value="Thriller"> Боевик<br>
            <input type="checkbox" name="genre" value="Comedy"> Комедия<br>
            <input type="checkbox" name="genre" value="Drama"> Драма<br>
            <br>
          </div>
        </div>
        <div class="field">
          <label>Страна<span style="color: #ec971f">*</span>:</label> <br>
          <div class="on-left">
            <input type="radio" name="country" value="USA"> США <br>
            <input type="radio" name="country" value="FRA" checked> Франция <br>
            <input type="radio" name="country" value="RUS"> Россия <br>
            <br>
          </div>
        </div>
        Год<span style="color: #ec971f">*</span>: <br>
        <select size="3" id="year" name="year" required>
          <script>
            var myDate = new Date();
            var year = myDate.getFullYear();
            for(var i = 1920; i < year+1; i++){
              document.write('<option value="'+i+'">'+i+'</option>');
            }
          </script>
        </select> <br>
        <br>
        Раннее время начала сеанса<span style="color: #ec971f">*</span>:
        <input type="time" name="startTime" value="10:00" min="08:00" max="23:00" required> <br>
        <br>
        Ключевое слово в названии:
        <input type="text" name="keyWord"> <br>
        <br>
        <input type="submit" value="Найти" />
      </form>
      </div>
  </div>
  </body>
</html>
