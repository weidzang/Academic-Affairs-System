<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/3
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>首页</title>
</head>
<style>
    a {
        text-decoration: none
    }
</style>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">选课系统管理平台</a>
    <div class="dropdown" style="margin-left: 71%;">
        <img style="height: 36px" src="./image/admiImg.jpg">
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${admin.name}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="#">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<div>
    <div style="background-color: rgb(235, 235, 235); height:600px;width:15%;float:left;position: relative;top:0px;text-align: center">
        <button type="button" data-toggle="collapse" data-target="#demo1"
                style="background-color: rgb(235, 235, 235); width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            学生管理
        </button>
        <div id="demo1" class="collapse in" style="text-decoration:none">
            <button onclick="window.location.href = '${pageContext.request.contextPath}/studentListServlet'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                学生详细信息
            </button>
            <br>
            <%--<button  onclick="window.location.href = '${pageContext.request.contextPath}/Stu/studentRegister.jsp'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加学生信息</button>--%>
            <a target="_blank" href="${pageContext.request.contextPath}/Stu/studentRegister.jsp" type="button"
               style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加学生信息</a>
        </div>
        <button type="button" data-toggle="collapse" data-target="#demo2"
                style="background-color: rgb(235, 235, 235);width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            教师管理
        </button>
        <div id="demo2" class="collapse in">
            <button onclick="window.location.href = '${pageContext.request.contextPath}/teacherListServlet'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                教师详细信息
            </button>
            <br>
            <%--<button onclick="window.location.href = '${pageContext.request.contextPath}/teacher/teacherRegister.jsp'" type="button" style="background-color:white;width:100%;font-family:楷体;color:blacke;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加教师信息</button>--%>
            <a target="_blank" href="${pageContext.request.contextPath}/teacher/teacherRegister.jsp" type="button"
               style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加教师信息</a>
        </div>
        <button type="button" data-toggle="collapse" data-target="#demo3"
                style="background-color: rgb(235, 235, 235);width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            课程管理
        </button>
        <div id="demo3" class="collapse in">
            <%--<button onclick="window.location.href = '企业详细信息查询界面.html'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">审核企业信息</button><br>--%>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/courseListServlet'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                课程详细信息
            </button>
            <br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/admin/cs_publishCourse.jsp'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                发布课程
            </button>
            <br>
            <%--<button onclick="window.location.href = '${pageContext.request.contextPath}/enterprise/enterpriseRegister.jsp'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加企业信息</button>--%>
            <%--<a target="_blank" href="${pageContext.request.contextPath}/enterprise/enterpriseRegister.jsp" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加课程信息</a>--%>
        </div>
    </div>
    <div style="float:left;width: 85%;">
        <div style="margin-top: 200px;text-align: center;">
            <h2>${admin.name}，亲爱的管理员，欢迎您使用选课系统管理平台</h2>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position:absolute;bottom:0;width:100%; height:15%">
    <div style="float: left;width:40%;letter-spacing:3px;height:100%;">
        <a style="color:cadetblue;font-family:黑体;font-size:2em;position:relative;left:9%;top:15%;"
           href="#">选课系统管理平台</a>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%">网站介绍</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;"
               href="#">网站功能介绍</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;">网站创作意义</a>
        </ul>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%">友情链接</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;"
               href="https://www.cnki.net/" target="_blank">知网</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;"
               href="https://www.ahnu.edu.cn/" target="_blank">师大官网</a>
        </ul>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%;">快捷页面</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;"
               href="#">学生登录</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;"
               href="#">教师登录</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;"
               href="#">企业登录</a>
        </ul>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
