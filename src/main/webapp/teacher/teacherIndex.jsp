<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/3
  Time: 9:53
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
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">科大选课系统 SSE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active"
               href="${pageContext.request.contextPath}/teacher/teacherIndex.jsp">首页<span class="sr-only">(current)</span></a>
<%--            <a class="nav-item nav-link"--%>
<%--               href="${pageContext.request.contextPath}/teacher/cs_publishCourse.jsp">发布课程</a>--%>
            <a class="nav-item nav-link "
               href="${pageContext.request.contextPath}/CS_lookPublishedCourseServlet?currentPage=1&rows=10">查看课程</a>
<%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/examineStuResumeServlet">审核简历</a>--%>
<%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/lookFinishedServlet">查看完成项目</a>--%>
<%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/evaluateStudentServlet">评价完成项目</a>--%>
            <%--<button type="button" class="btn btn-primary" style="position: relative;left:190%;">登录</button>--%>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <img style="height: 36px" src="./image/teacherImg.jpg">
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${teacher.name}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_TeacherInfoServlet?eid=${teacher.id}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<div style="margin-top: 200px;text-align: center;">
    <h2>${teacher.name}，欢迎您使用USTC SSE 选课系统</h2>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position:absolute;bottom:0;width:100%; height:15%">
    <div style="float: left;width:40%;letter-spacing:3px;height:100%;">
        <a style="color:cadetblue;font-family:黑体;font-size:2em;position:relative;left:9%;top:15%;" href="#">科大选课系统 SSE</a>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%">网站介绍</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">网站功能介绍</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;">网站创作意义</a>
        </ul>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%">友情链接</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="https://www.cnki.net/" target="_blank">知网</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="https://www.ahnu.edu.cn/" target="_blank">师大官网</a>
        </ul>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%;">快捷页面</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">学生登录</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">教师登录</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">企业登录</a>
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