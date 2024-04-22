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
    <title>课程列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <%--*********css冲突位置--%****************************************--%>
    <!-- 1. 导入CSS的全局样式 -->
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <script type="text/javascript">

        window.onload = function () {
            var y = '<%=request.getAttribute("y")%>';
            if(y == "1"){
                alert("操作成功！请稍后刷新页面查看选课结果...");
            }
            else if(y=="2"){
                alert("退课成功！");
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
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/Stu/studentIndex.jsp">首页<span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=1&rows=10">课程列表</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/CS_lookSelfResultServlet">查看得分</a>
            <%--<a class="nav-item nav-link "--%>
               <%--href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=1&rows=10">企业项目</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/ifEmployedListServlet">项目处理</a>--%>
            <%--<a class="nav-item nav-link" href="${pageContext.request.contextPath}/haveNoStuResumeServlet">我的简历</a>--%>
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
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${student.id}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>

</nav>
<div style="width: 100%;height: 100%;display: flex;flex-direction: column">

    <%--<div class="blank" style="height: 50px;"></div>--%>
    <div class="container" style="float: left;margin-top: 20px">
        <div style="float: left;margin-top: 20px">
            <form class="form-inline" action="${pageContext.request.contextPath}/CS_findCourseByPageServlet" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">课程名</label>
                    <input type="text" name="courseName" value="${condition.courseName[0]}" class="form-control"
                           id="exampleInputName2">
                </div>
                <div class="form-group">
                    <label for="exampleInputName3">教师姓名</label>
                    <input type="text" name="tName" value="${condition.tName[0]}" class="form-control"
                           id="exampleInputName3">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail2">上课地点</label>
                    <input type="data" name="place" value="${condition.place[0]}" class="form-control"
                           id="exampleInputEmail2">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
        <div style="float: right">
            <h6>要求学分：${pb.requireFen}</h6>
            <h6>已选学分：${pb.obtainFen}</h6>
        </div>

    </div>
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>选课</th>
                <th>序号</th>
                <th>课程编号</th>
                <th>课程名</th>
                <th>学分</th>
                <th>总量</th>
                <th>余量</th>
                <th>教师姓名</th>
                <th>地点</th>
                <th>选课开始日期</th>
                <th>选课结束日期</th>
            </tr>
            </thead>

            <c:forEach items="${pb.list}" var="t" varStatus="s">
                <tr>
<%--                    <td><a href="${pageContext.request.contextPath}/CS_selectOneCourse?id=${t.id}">选课</a></td>--%>
                    <td>
                        <c:if test="${t.sym == '0'}">
                            <a style="color: #4cae4c" href="${pageContext.request.contextPath}/CS_selectOneCourse?id=${t.course.id}">选课</a>
                        </c:if>
                        <c:if test="${t.sym == '1'}">
                            <a style="color: #ac2925" href="${pageContext.request.contextPath}/CS_deleteOneCourse?id=${t.course.id}">退课</a>
                        </c:if>
                    </td>
                    <td>${s.count}</td>
                    <td>${t.course.courseId}</td>
                    <td>${t.course.courseName}</td>
                    <td>${t.course.credit}</td>
                    <td>${t.course.total}</td>
                    <td>${t.course.number}</td>
                    <td>${t.course.tName}</td>
                    <td>${t.course.place}</td>
                    <td>${t.course.startTime}</td>
                    <td>${t.course.endTime}</td>
                    <%--<td>${t.url}</td>--%>

                    <%--<td><a href="${pageContext.request.contextPath}/lookOneProjectServlet?id=${t.id}">查看详情</a></td>--%>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div style="margin-left: 15%;margin-bottom: 10%">
        <nav aria-label="Page navigation">
            <ul class="pagination pagination-lg">
                <li>
                    <a href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=${pb.currentPage -1}&rows=10&filename=${condition.filename[0]}&algorithm=${condition.algorithm[0]}&submitTime=${condition.submitTime[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">Previous</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active">
                            <a style="color: #0f0f0f;font-size: 25px" href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=${i}&rows=10&filename=${condition.filename[0]}&algorithm=${condition.algorithm[0]}&submitTime=${condition.submitTime[0]}">&nbsp;&nbsp;${i}&nbsp;</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=${i}&rows=10&filename=${condition.filename[0]}&algorithm=${condition.algorithm[0]}&submitTime=${condition.submitTime[0]}">&nbsp;&nbsp;${i}&nbsp;</a>
                        </li>
                    </c:if>
                </c:forEach>

                <li>
                    <a href="${pageContext.request.contextPath}/CS_findCourseByPageServlet?currentPage=${pb.currentPage +1}&rows=10&filename=${condition.filename[0]}&algorithm=${condition.algorithm[0]}&submitTime=${condition.submitTime[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">Next</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
      共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
            </ul>
        </nav>
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