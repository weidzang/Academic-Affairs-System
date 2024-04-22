<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/2
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查看成绩</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <%--*********css冲突位置--%****************************************--%>
    <!-- 1. 导入CSS的全局样式 -->
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <script type="text/javascript">

    </script>

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
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/Stu/studentIndex.jsp">首页<span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link"
               href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=1&rows=10">课程列表</a>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/CS_lookSelfResultServlet">查看得分</a>

        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <c:if test="${student.sex == '男' || empty uesr.ssex}">
            <img style="height: 30px" src="Stu/image/boy.jpeg">
        </c:if>
        <c:if test="${student.sex == '女'}">
            <img style="height: 30px" src="Stu/image/girl.jpg">
        </c:if>
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${student.name}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${student.id}">修改资料</a>
            </li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>

</nav>
<div>
    <div style="background-color: rgb(235, 235, 235); height:600px;width:15%;float:left;position: relative;margin-top:10px;">
        <H4>您选了${funCR.course_result_List.size()}门课</H4>
        <H5>课程信息如下：</H5>
        <h6>平均分：${funCR.averageResult}</h6>
        <h6>最高分：${funCR.maxResult}</h6>
        <h6>最低分：${funCR.minResult}</h6>

    </div>
    <div style="float:left;width: 85%;">
        <div class="container">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>课程ID</th>
                    <th>课程名</th>
                    <th>总学分</th>
                    <th>教课老师</th>
                    <th>上课地点</th>

                    <th>成绩</th>
                </tr>
                </thead>

                <c:forEach items="${funCR.course_result_List}" var="t" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${t.courseId}</td>
                        <td>${t.courseName}</td>
                        <td>${t.credit}</td>
                        <td>${t.tName}</td>
                        <td>${t.place}</td>

                        <td>
                            <c:if test="${empty t.result}">
                                未出成绩
                            </c:if>
                            <c:if test="${t.result != null}">
                                ${t.result}
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

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