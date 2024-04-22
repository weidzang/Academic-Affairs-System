package com.sse.ustc.lockcs.admin.servlet;

import com.sse.ustc.lockcs.admin.service.ServiceAdmin;
import com.sse.ustc.lockcs.admin.service.impl.ServiceAdminImpl;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
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

@WebServlet("/changeOneTeacherServlet")
public class ChangeOneTeacherServlet extends HttpServlet{
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
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
//        ServiceAdmin service = new ServiceAdminImpl();
        service.cs_updateTeacher(teacher);
        //5.跳转到查询所有Servlet
        String tid=teacher.getTeacherId();
        Teacher teacher1 = service.cs_findTeacherByTid(tid);
        request.setAttribute("teacher",teacher1);
        request.setAttribute("success","success");
        request.getRequestDispatcher("admin/changeOneTeacherInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
