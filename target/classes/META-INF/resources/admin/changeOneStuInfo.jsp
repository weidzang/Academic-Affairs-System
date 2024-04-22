<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/12
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>修改信息</title>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            var success = '<%=request.getAttribute("success")%>';
            if (success == 'success') {
                alert("修改成功");
            }
        }
        $(function () {
            var regBtn = $("#regBtn");
            $("#regText").change(function () {
                var that = $(this);
                that.prop("checked", that.prop("checked"));
                if (that.prop("checked")) {
                    regBtn.prop("disabled", false)
                } else {
                    regBtn.prop("disabled", true)
                }
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">选课系统管理平台</a>
    <div class="dropdown" style="margin-left: 71%;">
        <img style="height: 36px" src="admin/image/admiImg.jpg">
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
<h3 style="text-align: center;">修改学生信息</h3>
<div style="width: 1000px;margin: 0px auto;display: table;">
    <form role="form" action="${pageContext.request.contextPath}/changeOneStuServlet" method="post">
        <div class="form-group">
            <label for="studentId">学号</label>
            <input type="text" name="studentId" value="${student.studentId}" readonly class="form-control" id="studentId" maxlength="11">
        </div>
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" name="name" value="${student.name}" class="form-control" id="name" maxlength="10">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" name="password" value="${student.password}" class="form-control" id="password" maxlength="10">
        </div>
        <div class="form-group">
            <label for="sex">性别</label>
            <select class="form-control" name="sex">
                <c:if test="${student.sex == '男' ||  empty student.sex}">
                    <option selected>男</option>
                    <option>女</option>
                </c:if>
                <c:if test="${student.sex == '女'}">
                    <option>男</option>
                    <option selected>女</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="level">学历</label>
            <input type="text" name="level" value="${student.level}" class="form-control" id="level" maxlength="15">
        </div>
        <div class="form-group">
            <label for="grade">学年</label>
            <input type="text" name="grade" value="${student.grade}" class="form-control" id="grade" maxlength="15">
        </div>
        <div class="form-group">
            <label for="phone">联系方式</label>
            <input type="text" name="phone" value="${student.phone}" class="form-control" id="phone" maxlength="11">
        </div>

        <div class="checkbox">
            <label>
                <input type="checkbox" id="regText"> 确认无误</label>
        </div>
        <button type="submit" class="btn btn-primary" id="regBtn" disabled>修改</button>
        <button type="button" class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/studentListServlet'">返回</button>
        <%--<button type="button" class="btn btn-primary" onclick="javascript:history.back(-1);">返回</button>--%>
    </form>
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
