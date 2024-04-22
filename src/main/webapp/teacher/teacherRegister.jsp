<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/4
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>选课系统管理平台</title>
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
            var teacherId = document.getElementById("teacherId");
            var ename = document.getElementById("name");
            var epassword = document.getElementById("password");
            var reepassword = document.getElementById("repassword");
            var ephone = document.getElementById("phone");


            if (teacherId.value == "") {
                alert("账号不能为空！");
                return false;
            }
            if (teacherId.value.length > 10 || teacherId.value.length < 4) {
                alert("账号长度应不少于4位，不多于10位！ ");
                return false;
            }
            if (ename.value == "") {
                alert("姓名不能为空！");
                return false;
            }

            if (epassword.value.length > 10 || epassword.value.length < 6) {
                alert("密码长度应不少于6位，不多于10位！ ");
                return false;
            }
            if (epassword.value != reepassword.value) {
                alert("两次输入的密码不一致，请重新输入！");
                return false;
            }
            if (ephone.value.length != 11) {
                alert("号码输入格式错误");
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
            <a class="nav-item nav-link" href="../register.jsp">首页<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="../Stu/studentRegister.jsp">学生注册</a>
            <a class="nav-item nav-link" href="../teacher/teacherRegister.jsp">教师注册</a>
            <a class="nav-item nav-link" href="../admin/admiRegister.jsp">管理员注册</a>
<%--            <a class="nav-item nav-link active" href="#">添加课程</a>--%>
            <a class="nav-item nav-link" style="color:greenyellow" href="../index.jsp">前去登录</a>
        </div>
    </div>
</nav>
<div class="blank" style="height: 20px;"></div>
<div style="display:flex;justify-content:center; align-items:center;width: 100%;">
    <form onsubmit="return validate1();" action="${pageContext.request.contextPath}/teacherRegisterServlet"
          method="post">
        <%--<div class="container">--%>
            <table class="table" style="position: relative;left: 0;width: 100%;">
                <tr>
                    <td>教师工号:</td>
                    <td>
                        <input type="text" value="${map.teacherId[0]}" name="teacherId" id="teacherId" placeholder="请输入教师工号！"
                               style="width:100%;" maxlength="11">
                    </td>
                </tr>
                <tr>
                    <td>教师姓名:</td>
                    <td>
                        <input type="text" value="${map.name[0]}" name="name" id="name" placeholder="请输入教师姓名！"
                               style="width:100%;" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td>
                        <input type="password" name="password" id="password" placeholder="请填写密码！"
                               style="width:100%;" maxlength="15">
                    </td>
                </tr>
                <tr>
                    <td>确认密码:</td>
                    <td>
                        <input type="password" name="repassword" id="repassword" placeholder="请再次确认密码！"
                               style="width:100%;">
                    </td>
                </tr>
                <tr>
                    <td>联系方式:</td>
                    <td>
                        <input type="text" value="${map.phone[0]}" name="phone" id="phone" placeholder="请填写联系方式！"
                               style="width:100%;" maxlength="11">
                    </td>
                </tr>
                <br>
            </table>
            <input type="submit" class="btn btn-primary" value="注册" style="position: relative;left:35%;"></input>
            <input type="reset" class="btn btn-primary" value="重置" style="position: relative;left:50%;"></input>
        <%--</div>--%>
    </form>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
     style="position:fixed;left:0px;bottom:0px;width:100%; height:110px;">
    <div style="float: left;width:40%;letter-spacing:3px;height:100%;">
        <a style="color:cadetblue;font-family:黑体;font-size:2em;position:relative;left:130px;top:30px;" href="#">选课系统管理平台</a>
    </div>
    <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:30px;">网站介绍</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">网站功能介绍</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;">网站创作意义</a>
        </ul>
    </div>
    <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:30px;">友情链接</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="https://www.cnki.net/" target="_blank">知网</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="https://www.ahnu.edu.cn/" target="_blank">师大官网</a>
        </ul>
    </div>
    <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:30px;">快捷页面</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">学生登录</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">教师登录</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
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
