package com.sse.ustc.lockcs.teacher.dao;

import com.sse.ustc.lockcs.teacher.domain.Stu_Course_Result;
import com.sse.ustc.lockcs.student.domain.Course;

import java.util.List;
import java.util.Map;

public interface DaoTeacher {
    int cs_publicCourse(Course course);

    int cs_lookPublishedCourse_TotalCount(Map<String, String[]> condition, Integer tId);

    List<Course> cs_lookPublishedCourseByPage(int start, int rows, Map<String, String[]> condition, Integer tId);

    List<Stu_Course_Result> cs_setStudentGradeByPage(String cId);

    int CS_saveStuResult(String sid, String cid, String result);

    Course cs_returnCourseByCid(String cid);

    Integer getTIDByName(String who);
}
