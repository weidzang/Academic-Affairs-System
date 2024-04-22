package com.sse.ustc.lockcs.student.servlet;
import com.sse.ustc.lockcs.teacher.domain.Stu_Course_Result;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import com.sse.ustc.lockcs.teacher.service.impl.ServiceTeacherImpl;
import com.sse.ustc.lockcs.student.domain.*;
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
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/CS_lookSelfResultServlet")
public class CS_lookSelfResultServlet extends HttpServlet {
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
        request.setCharacterEncoding("utf-8");
        //2 调用service
//        ServiceStudent service = new ServiceStudentImpl();

        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");

        Fun_Course_Result fun_course_result = new Fun_Course_Result();
        List<Course_Result> CR = service.cs_lookSelfResult(student.getId());
        fun_course_result.setCourse_result_List(CR);
        fun_course_result.Fun_AgvMaxMin();

//        PageBean<Stu_Course_Result> pb = service.cs_setStudentGrade(cid);

//        Course course = service.cs_returnCourseByCid(cid);
        //#设置不过于长，

//        request.setAttribute("cid", cid); // 存入cid
        request.setAttribute("funCR", fun_course_result); // 存入cid
//        request.setAttribute("course", course);

        request.getRequestDispatcher("/Stu/cs_lookSelfResult.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
