package com.sse.ustc.lockcs.admin.dao;

import com.sse.ustc.lockcs.student.domain.Course;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.teacher.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface DaoAdmin {
    int cs_insertTeacher(Teacher teacher);
    int cs_insertStudent(Student student);
    int cs_insertCourse(Course course);
    void cs_updateTeacher(Teacher teacher);
    void cs_updateStudent(Student student);
    void cs_updateCourse(Course course);
    void cs_deleteCourse(String cid);
    Student cs_findStudentBySid(String Sid);
    Teacher cs_findTeacherByTid(String Tid);
    Course cs_findCourseByCid(String Cid);
    int cs_findCourse_TotalCount(Map<String, String[]> condition);
    List<Course> cs_findCourseByPage(int start, int rows, Map<String, String[]> condition);
    int cs_findStudent_TotalCount(Map<String, String[]> condition);
    List<Student> cs_findStudentByPage(int start, int rows, Map<String, String[]> condition);
    int cs_findTeacher_TotalCount(Map<String, String[]> condition);
    List<Teacher> cs_findTeacherByPage(int start, int rows, Map<String, String[]> condition);
}
