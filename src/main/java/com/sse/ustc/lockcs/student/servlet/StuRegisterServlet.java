package com.sse.ustc.lockcs.student.servlet;

import com.sse.ustc.lockcs.admin.service.ServiceAdmin;
import com.sse.ustc.lockcs.admin.service.impl.ServiceAdminImpl;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.student.service.Impl.ServiceStudentImpl;
import com.sse.ustc.lockcs.student.service.ServiceStudent;
import org.apache.commons.beanutils.BeanUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/stuRegisterServlet")
public class StuRegisterServlet extends HttpServlet{
    @Autowired
    private ServiceAdmin service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext application = this.getServletContext();
        // 解决servlet用@Autowired自动注入service失败的问题
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //2.获取数据,封装User对象
        Map<String, String[]> map = request.getParameterMap();
        //3封装对象
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(studentAllInfo.toString());
        //4,返回结果
//        ServiceAdmin service = new ServiceAdminImpl();
        int count = service.cs_insertStudent(student);
//        System.out.println(count);
        //state 状态
        if(count>0){
            request.setAttribute("state","success");
            //回写操作
//            request.setAttribute("map",map);
            request.setAttribute("sid",student.getStudentId());
            request.setAttribute("password",student.getPassword());
        }
        else{
            request.setAttribute("error_stu","error_stu");
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
