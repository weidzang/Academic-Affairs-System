<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/3
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>学生注册平台</title>
    <script type="text/javascript">
        window.onload = function () {
            //显示用户不存在或密码不正确
            var state = '<%=request.getAttribute("state")%>';
            if (state == 'success') {
                alert("注册成功！请去登录");
            }
            else if (state == 'error') {
                alert("注册失败，账号已有，请更换账号注册")
            }
        }

        function validate1() {
            var studentId = document.getElementById("studentId");
            var stuName = document.getElementById("name");
            var password = document.getElementById("password");
            var repassword = document.getElementById("repassword");


            if (studentId.value == "") {
                alert("学号不能为空！");
                return false;
            }
            if (studentId.value.length > 12 || studentId.value.length < 4) {
                alert("学号长度应不少于4位，不多于11位！ ");
                return false;
            }
//            var re = /^[0-9]+.?[0-9]]*/;
//            if(!re.test(username)){
//                alert("账号要为数字类型");
//                return false;
//            }
            if (stuName.value == "") {
                alert("姓名不能为空");
                return false;
            }

            if (password.value.length > 10 || password.value.length < 6) {
                alert("密码长度应不少于6位，不多于10位 ");
                return false;
            }
            if (password.value != repassword.value) {
                alert("两次输入的密码不一致，请重新输入");
                return false;
            }

            return true;
        }
    </script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">选课系统管理平台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="../register.jsp">首页<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link active" href="#">学生注册</a>
            <a class="nav-item nav-link" href="../teacher/teacherRegister.jsp">教师注册</a>
            <a class="nav-item nav-link" href="../admin/admiRegister.jsp">管理员注册</a>
            <a class="nav-item nav-link" style="color:greenyellow" href="../index.jsp">前去登录</a>
        </div>
    </div>
</nav>
<div class="blank" style="height: 20px;"></div>
<div style="display:flex;justify-content:center; align-items:center;width: 100%;">
    <%--<div style="width:30%;">--%>
        <form onsubmit="return validate1();" action="${pageContext.request.contextPath}/stuRegisterServlet"
              method="post">

            <table class="table" style="position: relative;left: 0;width: 100%">
                <tr>
                    <%--这里不用使用隐藏域--%>
                    <%--<input type="hidden" value="NULL" name="sid" style="width:400px;height:20px;">--%>
                    <td>学生账号:</td>
                    <td>
                        <input type="text" name="studentId" value="${map.studentId[0]}" placeholder="请填写您的账号"
                               style="width:100%;" id="studentId">
                    </td>
                </tr>
                <tr>
                    <td>学生姓名:</td>
                    <td>
                        <input type="text" name="name" value="${map.name[0]}" placeholder="请填写您的姓名"
                               style="width:100%;" id="name">
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td>
                        <input type="password" name="password" placeholder="请填写您的密码" style="width:100%;"
                               id="password">
                    </td>
                </tr>
                </tr>
                <tr>
                    <td>确认密码:</td>
                    <td>
                        <input type="password" placeholder="请再次确认您的密码" style="width:100%;"
                               id="repassword">
                    </td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <select name="sex" value="${map.sex[0]}" style="width:50%;">
                            <option value="男" selected="selected">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>学历:</td>
                    <td>
                        <input type="text" name="level" value="${map.level[0]}" placeholder="请填写您的学历"
                               style="width:100%;">
                    </td>
                </tr>
                <tr>
                    <td>学年:</td>
                    <td>
                        <input type="text" name="grade" value="${map.grade[0]}" placeholder="请填写您的所在专业"
                               style="width:100%;">
                    </td>
                </tr>
                <tr>
                    <td>联系方式:</td>
                    <td>
                        <input type="text" name="phone" value="${map.phone[0]}" placeholder="请填写您的联系方式"
                               style="width:100%;">
                    </td>
                    <%--<input type="hidden" value="NULL" name="sevaluate" style="width:400px;height:20px;">--%>
                </tr>
                <br>
            </table>
            <input type="submit" class="btn btn-primary" value="注册" style="position: relative;left:35%;"></input>
            <input type="reset" class="btn btn-primary" value="重置" style="position: relative;left:50%;"></input>
        </form>
    <%--</div>--%>

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