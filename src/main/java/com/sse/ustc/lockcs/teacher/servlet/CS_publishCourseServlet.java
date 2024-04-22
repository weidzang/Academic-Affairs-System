package com.sse.ustc.lockcs.teacher.servlet;

import com.sse.ustc.lockcs.student.domain.Course;
import com.sse.ustc.lockcs.teacher.service.impl.ServiceTeacherImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/CS_publishCourseServlet")
public class CS_publishCourseServlet extends HttpServlet {
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
        Map<String, String[]> map = request.getParameterMap();
        Course course = new Course();

        try {
            BeanUtils.populate(course,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        ServiceTeacher service = new ServiceTeacherImpl();

//        String who = request.getParameter("tName");
//        course.settName(who);
        Integer tId = service.getTIDByName(course.gettName());
//        System.out.println("tid = " + tId);
        course.settId(tId);
        course.setNumber(course.getTotal()); //处理一下 让课程总量与课程余量 相同

        System.out.println(course.toString());

        int count = service.cs_publishCourse(course);
        if(count > 0){
            request.setAttribute("state","success");
            request.setAttribute("map",map);
            //回写操作
            request.getRequestDispatcher("admin/cs_publishCourse.jsp").forward(request,response);
        }
        else {
            request.setAttribute("state","error");
            //回写操作
            request.getRequestDispatcher("teacher/publishProject.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
