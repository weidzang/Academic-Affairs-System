package com.sse.ustc.lockcs.admin.servlet;

import com.sse.ustc.lockcs.admin.service.ServiceAdmin;
import com.sse.ustc.lockcs.admin.service.impl.ServiceAdminImpl;
import com.sse.ustc.lockcs.student.domain.Course;
import com.sse.ustc.lockcs.student.domain.PageBean;
import com.sse.ustc.lockcs.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/courseListServlet")
public class CourseListServlet extends HttpServlet{
    @Autowired
    ServiceAdmin service;

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
        if(currentPage==null){
            currentPage="1";
        }
        if(rows==null){
            rows="10";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2 调用service
//        ServiceAdmin service = new ServiceAdminImpl();
        PageBean<Course> pb = service.cs_findCourseByPage(currentPage,rows,condition);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
//        System.out.println(pb.toString());
        //会写
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("admin/courseInfoList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
