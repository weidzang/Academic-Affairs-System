<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/2
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <title>学生注册平台</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">选课系统管理平台</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="#">首页<span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="./Stu/studentRegister.jsp">学生注册</a>
      <a class="nav-item nav-link" href="./teacher/teacherRegister.jsp">教师注册</a>
      <a class="nav-item nav-link" href="./admin/admiRegister.jsp">管理员注册</a>
      <a class="nav-item nav-link" style="color:greenyellow" href="${pageContext.request.contextPath}/index.jsp">前去登录</a>
    </div>
  </div>
</nav>
<div style="margin-top: 200px;text-align: center">
  <h2>欢迎您进入账号注册界面</h2>
  <br>
  <h3>请选择对象注册</h3>

</div>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position:absolute;bottom:0;width:100%; height:110px;">
  <div style="float: left;width:40%;letter-spacing:3px;height:100%;">
    <a style="color:cadetblue;font-family:黑体;font-size:2em;position:relative;left:130px;top:30px;" href="#">协同育人校企合作平台</a>
  </div>
  <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
    <ul>
      <a style="color:white;position: relative;left:30px;">网站介绍</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;" href="#">网站功能介绍</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;">网站创作意义</a>
    </ul>
  </div>
  <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
    <ul>
      <a style="color:white;position: relative;left:30px;">友情链接</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;" href="https://www.cnki.net/" target="_blank">知网</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;" href="https://www.ahnu.edu.cn/" target="_blank">师大官网</a>
    </ul>
  </div>
  <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
    <ul>
      <a style="color:white;position: relative;left:30px;">快捷页面</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;" href="#">学生登录</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;" href="#">教师登录</a><br>
      <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;" href="#">企业登录</a>
    </ul>
  </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>