package com.sse.ustc.lockcs.student.servlet;

import com.sse.ustc.lockcs.rocketmq.Message;
import com.sse.ustc.lockcs.rocketmq.Producer;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.student.service.Impl.ServiceStudentImpl;
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
 * @author
 * @description CS_selectOneCourse
 * @date 2023/4/27 20:25
 */
@WebServlet("/CS_selectOneCourse")
public class CS_selectOneCourse extends HttpServlet {
//    @Autowired
//    ServiceStudent service;
    @Autowired
    Producer producer;


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
        producer.sendMessage("select-course",new Message(student.getId(), cid));
        //int y = service.cs_selectOneCourse(student.getId(), cid);//是否选课成功
        request.setAttribute("y", 1);
        request.getRequestDispatcher("/CS_findCourseByPageServlet?currentPage=1&rows=10").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

