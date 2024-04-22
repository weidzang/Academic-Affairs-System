package com.sse.ustc.lockcs.student.service;

import com.sse.ustc.lockcs.admin.domain.Admin;
import com.sse.ustc.lockcs.student.domain.*;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ServiceStudent {

    /**
     * 学生登录方法
     * @param student
     * @return
     */
    Student login(Student student);

    /**
     * 教师登录
     * @param teacher
     * @return
     */
    Teacher login_teacher(Teacher teacher);
    /**
     * 教师登录
     * @param admin
     * @return
     */
    Admin login_admin(Admin admin);
    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Sym_Course> cs_findCourseByPage(String currentPage, String rows, Map<String, String[]> condition, Integer sid);

    int cs_selectOneCourse(Integer sid, Integer cid);

    int cs_deleteOneCourse(Integer sid, Integer cid);

    List<Course_Result> cs_lookSelfResult(Integer id);
}
