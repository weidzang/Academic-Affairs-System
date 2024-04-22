package com.sse.ustc.lockcs.teacher.servlet;

import com.sse.ustc.lockcs.teacher.service.ServiceTeacher;
import com.sse.ustc.lockcs.teacher.service.impl.ServiceTeacherImpl;
import com.sse.ustc.lockcs.student.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CS_saveStuResultServlet")
public class CS_saveStuResultServlet extends HttpServlet {
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
        String sid = request.getParameter("sid");
        String cid= request.getParameter("cid");
        String result= request.getParameter("result");

//        ServiceTeacher service = new ServiceTeacherImpl();
        int sign = service.CS_saveStuResult(sid, cid, result);

        request.setAttribute("y", "yes");
        request.getRequestDispatcher("CS_setStudentGradeServlet?id=" + cid).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
