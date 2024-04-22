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
    <title>查看课程</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <%--*********css冲突位置--%****************************************--%>
    <!-- 1. 导入CSS的全局样式 -->
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <script type="text/javascript">
        window.onload = function () {
            //显示用户不存在或密码不正确
            var state = '<%=request.getAttribute("y")%>';
            if (state == 'yes') {
                alert("分数保存成功");
            } else if (state == "error") {
                alert("分数保存失败");
            }
        }

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
            <a class="nav-item nav-link "
               href="${pageContext.request.contextPath}/teacher/teacherIndex.jsp">首页<span class="sr-only">(current)</span></a>
<%--            <a class="nav-item nav-link "--%>
<%--               href="${pageContext.request.contextPath}/teacher/cs_publishCourse.jsp">发布课程</a>--%>
            <a class="nav-item nav-link active"
               href="${pageContext.request.contextPath}/CS_lookPublishedCourseServlet?currentPage=1&rows=10">查看课程</a>
            <%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/Stu/yzm_submitModel.jsp">热点路径</a>--%>
            <%--<a class="nav-item nav-link "--%>
            <%--href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=1&rows=10">企业项目</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/ifEmployedListServlet">项目处理</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/haveNoStuResumeServlet">我的简历</a>--%>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <img style="height: 36px" src="${pageContext.request.contextPath}/teacher/image/teacherImg.jpg">
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${teacher.name}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${teacher.id}">修改资料</a>
            </li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>

</nav>
<div>
    <div style="background-color: rgb(235, 235, 235); height:600px;width:15%;float:left;position: relative;margin-top:10px;">
        <H4>共有${pb.stu_course_results.size()}位同学选了该课</H4>
        <H5>课程信息如下：</H5>
        <h6>课程ID：${course.courseId}</h6>
        <h6>课程名：${course.courseName}</h6>
        <h6>课程学分：${course.credit}</h6>
        <h6>最大选课数：${course.total}</h6>
        <h6>剩余选数：${course.number}</h6>
        <h6>上课地点：${course.place}</h6>
        <h6>选课开始时间：${course.startTime}</h6>
        <h6>选课结束时间：${course.endTime}</h6>
        <H5>----------------------</H5>
        <h5 style="color: blue">班级平均分：${pb.averageResult}</h5>
        <h5 style="color: blue">班级最高分：${pb.maxResult}</h5>
        <h5 style="color: blue">班级最低分：${pb.minResult}</h5>
    </div>
    <div style="float:left;width: 85%;">
        <div class="container">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>学生ID</th>
                    <th>学生姓名</th>
                    <th>学生Tel</th>
                    <th>性别</th>
                    <th>年级</th>
                    <th>学历</th>
                    <th colspan="2" style="text-align: center;">学生打分</th>
                </tr>
                </thead>

                <c:forEach items="${pb.stu_course_results}" var="t" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${t.studentId}</td>
                        <td>${t.name}</td>
                        <td>${t.phone}</td>
                        <td>${t.sex}</td>
                        <td>${t.grade}</td>
                        <td>${t.level}</td>
                            <%--<td>${t.url}</td>--%>
                        <form action="${pageContext.request.contextPath}/CS_saveStuResultServlet" method="post">
                            <td colspan="2">
                                <div style="text-align: center;">
                                    <input type="text" name="sid" value="${t.sid}" hidden>
                                    <input type="text" name="cid" value="${t.cid}" hidden>
                                    <input type="text" name="result" placeholder="满分100，请打分" value="${t.result}"
                                           style="width: 90px;">
                                </div>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm">保存</button>
                            </td>
                        </form>
                            <%--                    <td><a href="${pageContext.request.contextPath}/CS_lookOneCourse_MutStudentServlet?id=${cid}"></a></td>--%>
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