package com.sse.ustc.lockcs.student.servlet;

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

@WebServlet("/CS_findCourseByPageServlet")
public class CS_findCourseByPageServlet extends HttpServlet {

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
//        ServiceStudent service = new ServiceStudentImpl();

//        Student student = (Student)request.getSession().getAttribute("student");
//        String tsno = Student.getSsno();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        //传入student.gerId() 是为了 判断该同学有没有选择这门课程
        PageBean<Sym_Course> pb = service.cs_findCourseByPage(currentPage, rows, condition, student.getId());
        //#设置不过于长，
        pb.setRequireFen(33);
        float sum = 0;
        for (Sym_Course e: pb.getList()) {
            if(e.getSym() == 1){
                sum = sum + e.getCourse().getCredit();;
            }
        }
        pb.setObtainFen(sum);
        //3.将PageBean存入request
        request.setAttribute("pb", pb);
        //会写
        request.setAttribute("condition", condition);
        //#请求对象who
        String who = request.getParameter("who");
        if ("teacher".equals(who)) {
            request.getRequestDispatcher("/teacher/lookAllProject_Teacher.jsp").forward(request, response);
            System.out.println("老师");
        } else {
            //4.转发到list.jsp
            request.getRequestDispatcher("./Stu/CS_lookCoursePage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
