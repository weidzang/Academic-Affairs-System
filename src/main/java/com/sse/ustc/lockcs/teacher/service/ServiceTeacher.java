package com.sse.ustc.lockcs.teacher.service;

import com.sse.ustc.lockcs.teacher.domain.Stu_Course_Result;
import com.sse.ustc.lockcs.student.domain.*;

import java.util.List;
import java.util.Map;

public interface ServiceTeacher {

    int cs_publishCourse(Course course);

    PageBean<Course> cs_lookPublishedCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition, Integer tId);

    List<Stu_Course_Result> cs_setStudentGrade(String cid);

    int CS_saveStuResult(String sid, String cid, String result);

    Course cs_returnCourseByCid(String cid);

    Integer getTIDByName(String who);
}
