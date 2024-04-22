package com.sse.ustc.lockcs.student.servlet;

import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.student.service.ServiceStudent;
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

/**
 * ClassName: CS_delectOneCourse
 * Package: com.sse.ustc.lockcs.student.servlet
 * Description:
 *
 * @Author: zwd
 * @Create: 2023/6/15 - 20:30
 * @Version: v1.0
 */
@WebServlet("/CS_deleteOneCourse")
public class CS_deleteOneCourse extends HttpServlet {
    @Autowired
    ServiceStudent service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext application = this.getServletContext();
        // 解决servlet用@Autowired自动注入service失败的问题
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        String cid_ = request.getParameter("id"); //还删除不了 ， 所以要在CS_findCourseByPageServlet 模糊查询中特殊判断一下
        Integer cid = Integer.parseInt(cid_);
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        int y = service.cs_deleteOneCourse(student.getId(), cid);//是否选课成功
        request.setAttribute("y", 2);
        request.getRequestDispatcher("/CS_findCourseByPageServlet?currentPage=1&rows=10").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
