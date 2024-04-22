package com.sse.ustc.lockcs.teacher.servlet;
import com.sse.ustc.lockcs.admin.service.ServiceAdmin;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import com.sse.ustc.lockcs.teacher.service.impl.ServiceTeacherImpl;
import com.sse.ustc.lockcs.student.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/CS_lookPublishedCourseServlet")
public class CS_lookPublishedCourseServlet extends HttpServlet {
    @Autowired
    ServiceTeacherImpl service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext application = this.getServletContext();
        // 解决servlet用@Autowired自动注入service失败的问题
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        request.setCharacterEncoding("utf-8");
        //1 获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if (currentPage == null) {
            currentPage = "1";
        }
        if (rows == null) {
            rows = "10";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2 调用service
//        ServiceTeacherImpl service = new ServiceTeacherImpl();

        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        PageBean<Course> pb = service.cs_lookPublishedCourseByPage(currentPage, rows, condition, teacher.getId());
        //#设置不过于长，

        //3.将PageBean存入request
        request.setAttribute("pb", pb);
        //会写
        request.setAttribute("condition", condition);

        request.getRequestDispatcher("/teacher/cs_lookPublishedCourse.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
