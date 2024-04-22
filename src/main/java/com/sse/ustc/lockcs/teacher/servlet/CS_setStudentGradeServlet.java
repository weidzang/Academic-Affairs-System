package com.sse.ustc.lockcs.teacher.servlet;
import com.sse.ustc.lockcs.teacher.domain.Fun_Stu_Result;
import com.sse.ustc.lockcs.teacher.domain.Stu_Course_Result;
import com.sse.ustc.lockcs.student.domain.*;
import com.sse.ustc.lockcs.teacher.service.ServiceTeacher;
import com.sse.ustc.lockcs.teacher.service.impl.ServiceTeacherImpl;
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

@WebServlet("/CS_setStudentGradeServlet")
public class CS_setStudentGradeServlet extends HttpServlet {
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
        //2 调用service
//        ServiceTeacher service = new ServiceTeacherImpl();

//        HttpSession session = request.getSession();
//        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String cid = request.getParameter("id");
        Fun_Stu_Result pb = new Fun_Stu_Result();
        List<Stu_Course_Result> SCR = service.cs_setStudentGrade(cid);
        pb.setStu_course_results(SCR);
        pb.Fun_AgvMaxMin();
        Course course = service.cs_returnCourseByCid(cid);
        //#设置不过于长，

        request.setAttribute("cid", cid); // 存入cid
        request.setAttribute("pb", pb); // 存入cid
        request.setAttribute("course", course);

        request.getRequestDispatcher("/teacher/cs_setStudentGrade.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
