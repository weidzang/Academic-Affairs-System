package com.sse.ustc.lockcs.admin.service;

import com.sse.ustc.lockcs.student.domain.Course;
import com.sse.ustc.lockcs.student.domain.PageBean;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.student.domain.Sym_Course;
import com.sse.ustc.lockcs.teacher.domain.Teacher;

import java.util.Map;

public interface ServiceAdmin {
    PageBean<Course> cs_findCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition);
    PageBean<Student> cs_findStudentByPage(String _currentPage, String _rows, Map<String, String[]> condition);
    PageBean<Teacher> cs_findTeacherByPage(String _currentPage, String _rows, Map<String, String[]> condition);
    int cs_insertStudent(Student student);
    int cs_insertTeacher(Teacher teacher);
    int cs_insertCourse(Course course);
    void cs_deleteCourse(String courseId);
    void cs_updateStudent(Student student);
    void cs_updateTeacher(Teacher teacher);
    void cs_updateCourse(Course course);
    Student cs_findStudentBySid(String studentId);
    Teacher cs_findTeacherByTid(String teacherId);
    Course cs_findCourseByCid(String courseId);
}
