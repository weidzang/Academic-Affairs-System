<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/2
  Time: 17:49
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
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body style="background-image: url(${pageContext.request.contextPath}/outModel/back.jpg);background-size: 100%">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #2aabd2">
    <a class="navbar-brand" href="#">科大选课系统 SSE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/Stu/studentIndex.jsp">首页<span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link " href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=1&rows=10">课程列表</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/CS_lookSelfResultServlet">查看成绩</a>
<%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/Stu/yzm_submitModel.jsp">热点路径</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=1&rows=10&name">企业项目</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/ifEmployedListServlet">项目处理</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/haveNoStuResumeServlet">我的简历</a>--%>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <c:if test="${student.sex == '男' || empty uesr.ssex}">
            <img style="height: 30px" src="./image/boy.jpeg">
        </c:if>
        <c:if test="${student.sex == '女'}">
            <img style="height: 30px" src="./image/girl.jpg">
        </c:if>
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${student.name}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${student.id}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<div style="margin-top: 100px;text-align: center;">
    <h2 style="color: white">${student.name}同学，欢迎您使用科大选课系统</h2>
</div>


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