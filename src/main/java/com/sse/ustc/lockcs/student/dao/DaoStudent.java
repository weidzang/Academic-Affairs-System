package com.sse.ustc.lockcs.student.dao;

import com.sse.ustc.lockcs.admin.domain.Admin;
import com.sse.ustc.lockcs.student.domain.*;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface DaoStudent {
    Student login(Student student);

    Teacher login_teacher(Teacher teacher);

    Admin login_admin(Admin admin);

    int cs_findCourse_TotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */

    List<Course> cs_findCourseByPage(int start, int rows, Map<String, String[]> condition);


    int cs_countCourse(Integer cid);

    int cs_insertStu_Course(Integer sid, Integer cid);

    int cs_deleteStu_Course(Integer sid, Integer cid);

    int cs_Sym_Course(Integer sid, Integer cid);

    List<Course_Result> cs_lookSelfResult(Integer id);
}
