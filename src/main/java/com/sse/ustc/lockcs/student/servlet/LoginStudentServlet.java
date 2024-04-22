package com.sse.ustc.lockcs.student.servlet;

import com.sse.ustc.lockcs.admin.domain.Admin;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.student.service.Impl.ServiceStudentImpl;
import com.sse.ustc.lockcs.student.service.ServiceStudent;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginStudentServlet")
public class LoginStudentServlet extends HttpServlet {
    @Autowired
    ServiceStudent service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext application = this.getServletContext();
        // 解决servlet用@Autowired自动注入service失败的问题
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //2.获取数据,封装User对象
        String studentId = request.getParameter("studentId");
        String password = request.getParameter("password");

        //3 确定谁登录
        String who = request.getParameter("who");
        System.out.println(who);
        switch (who){
            case "student" :{
                //5.调用Service查询
                Student student = new Student();
                student.setStudentId(studentId);
                student.setPassword(password);

//                ServiceStudent service = new ServiceStudentImpl();
                Student loginUser = service.login(student);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("student", loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/Stu/studentIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

                }
                break;
            }
            /**
             * 这里教师登录直接在学生大文件里操作了，不然重复代码较多，只要在学生里的dao 里创建一个自己的查询函数就行
             * 将企业页面 改成教师页面
             */
            case "teacher" :{
                //5.调用Service查询
                Teacher teacher = new Teacher();
                teacher.setTeacherId(studentId);
                teacher.setPassword(password);
//                ServiceStudent service = new ServiceStudentImpl();//
                Teacher loginUser = service.login_teacher(teacher);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("teacher", loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/teacher/teacherIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

                }
                break;
            }
            case "admin" :{
                //5.调用Service查询
                Admin admin=new Admin();
                admin.setAdminId(studentId);
                admin.setPassword(password);
//                ServiceStudent service = new ServiceStudentImpl();//
                Admin loginUser = service.login_admin(admin);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("admin", loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/admin/admiIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

                }
                break;
            }

//            case "admi" :{
//                //5.调用Service查询
//                ServiceStudent service = new ServiceStudentImpl();//
//                AdmiAllInfo loginUser = service.login_admi(user);
//                //6.判断是否登录成功
//                if(loginUser != null){
//                    //登录成功
//                    //将用户存入session
//                    session.setAttribute("user",loginUser);
//                    //  System.out.println(loginUser.toString());
//                    //跳转页面
//                    response.sendRedirect(request.getContextPath()+"/admi/admiIndex.jsp");
//                }else{
//                    //登录失败
//                    //提示信息
//                    request.setAttribute("login_error","login_error");
//                    //转发到登录页面
//                    request.getRequestDispatcher("/index.jsp").forward(request,response);
//                }
//                break;
//            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
