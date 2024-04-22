package com.sse.ustc.lockcs.admin.servlet;

import com.sse.ustc.lockcs.admin.service.ServiceAdmin;
import com.sse.ustc.lockcs.admin.service.impl.ServiceAdminImpl;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnOneTeacherServlet")
public class ReturnOneTeacherServlet extends HttpServlet{
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
        String tid = request.getParameter("tid");
//        ServiceAdmin service = new ServiceAdminImpl();
        Teacher teacher = service.cs_findTeacherByTid(tid);
        request.setAttribute("teacher",teacher);
        request.getRequestDispatcher("admin/changeOneTeacherInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
