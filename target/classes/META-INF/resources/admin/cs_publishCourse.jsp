<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/6
  Time: 11:34
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
    <title>发布课程</title>
    <script type="text/javascript">
        window.onload = function () {
            //显示用户不存在或密码不正确
            var state = '<%=request.getAttribute("state")%>';
            if (state == 'success') {
                alert("${map.name[0]}项目发布成功");
            } else if (state == "error") {
                alert("项目发布失败");
            }
        }

        function validate1() {
            var courseId = document.getElementById("courseId");
            var courseName = document.getElementById("courseName");
            var credit = document.getElementById("credit");
            var total = document.getElementById("total");
            var place = document.getElementById("place");


            if (courseId.value == "" || courseName == "" || credit == "" || total == "" || place == "") {
                alert("项目名不能为空！");
                return false;
            }

            return true;
        }
    </script>
</head>
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
        <div class="blank" style="height: 10px;"></div>
        <h3 style="text-align: center;">请填写发布课程详细信息</h3>
        <div style="width: 800px;margin: 0px auto;display: table;">
            <form onsubmit="return validate1();" action="${pageContext.request.contextPath}/CS_publishCourseServlet">
                <%--                <div class="form-group">--%>
                <%--                    <label for="tName">老师</label>--%>
                <%--                    <input type="text" class="form-control" name="tName" id="tName" value="${teacher.name}" readonly>--%>
                <%--                </div>--%>
                <div class="form-group">
                    <label for="tName">老师</label>
                    <select name="tName" id="tName" style="position: relative;width:90%;left: 10px;">
                        <option value="白天" selected="selected">白天</option>
                        <option value="徐云">徐云</option>
                        <option value="丁箐">丁箐</option>
                        <option value="石竹">石竹</option>
                        <option value="王高峰">王高峰</option>
                        <option value="张信明">张信明</option>
                        <option value="凌棕">凌棕</option>
                    </select>
                </div>
                <%--                <div class="form-group" hidden>--%>
                <%--                    <label for="tId">老师</label>--%>
                <%--                    <input type="text" class="form-control" name="tId" id="tId" value="${teacher.id}" readonly>--%>
                <%--                </div>--%>
                <div class="form-group">
                    <label for="courseId">课程ID</label>
                    <input type="text" class="form-control" name="courseId" id="courseId" value="${map.courseId[0]}"
                           maxlength="15">
                </div>
                <div class="form-group">
                    <label for="courseName">课程名</label>
                    <input type="text" class="form-control" name="courseName" id="courseName"
                           value="${map.courseName[0]}" maxlength="15">
                </div>
                <div class="form-group">
                    <label for="credit">学分</label>
                    <input type="text" class="form-control" name="credit" id="credit" value="${map.credit[0]}"
                           maxlength="15">
                </div>
                <div class="form-group">
                    <label for="total">上课最大人数</label>
                    <input type="text" class="form-control" name="total" id="total" value="${map.total[0]}"
                           maxlength="15">
                </div>
                <div class="form-group">
                    <label for="startTime">选课开始时间</label>
                    <input id="startTime" name="startTime" type="date" value="${map.startTime[0]}"/>
                </div>
                <div class="form-group">
                    <label for="endTime">选课结束时间</label>
                    <input id="endTime" name="endTime" type="date" value="${map.endTime[0]}"/>
                </div>
                <div class="form-group">
                    <label for="place">上课地点</label>
                    <input type="text" class="form-control" name="place" id="place" value="${map.place[0]}"
                           maxlength="15">
                </div>
                <div style="margin: 0px auto;display: table;">
                    <button type="submit" class="btn btn-primary">提交发布信息</button>
                    <div style="width: 150px;display: inline-block;"></div>
                    <button type="reset" class="btn btn-primary">重置发布信息</button>
                </div>
            </form>
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