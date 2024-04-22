package com.sse.ustc.lockcs.admin.service.impl;

import com.sse.ustc.lockcs.admin.dao.DaoAdmin;
import com.sse.ustc.lockcs.admin.dao.impl.DaoAdminImpl;
import com.sse.ustc.lockcs.admin.service.ServiceAdmin;
import com.sse.ustc.lockcs.student.domain.Course;
import com.sse.ustc.lockcs.student.domain.PageBean;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ServiceAdminImpl implements ServiceAdmin{
//    private DaoAdmin dao=new DaoAdminImpl();

    @Autowired
    private DaoAdmin dao;

    public ServiceAdminImpl() {
        super();
    }

    @Override
    public PageBean<Course> cs_findCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<Course> pb = new PageBean<Course>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //3.调用dao查询总记录数
        int totalCount = dao.cs_findCourse_TotalCount(condition);
        //4.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        //5分页条错误点击处理
        if(currentPage<1){
            currentPage=totalPage;
        }
        else if(currentPage>totalPage){
            currentPage=1;
        }
        //6.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Course> list = dao.cs_findCourseByPage(start,rows,condition);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<Student> cs_findStudentByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<Student> pb = new PageBean<Student>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //3.调用dao查询总记录数
        int totalCount = dao.cs_findStudent_TotalCount(condition);
        //4.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        //5分页条错误点击处理
        if(currentPage<1){
            currentPage=totalPage;
        }
        else if(currentPage>totalPage){
            currentPage=1;
        }
        //6.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Student> list = dao.cs_findStudentByPage(start,rows,condition);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<Teacher> cs_findTeacherByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<Teacher> pb = new PageBean<Teacher>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //3.调用dao查询总记录数
        int totalCount = dao.cs_findTeacher_TotalCount(condition);
        //4.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        //5分页条错误点击处理
        if(currentPage<1){
            currentPage=totalPage;
        }
        else if(currentPage>totalPage){
            currentPage=1;
        }
        //6.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Teacher> list = dao.cs_findTeacherByPage(start,rows,condition);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public int cs_insertStudent(Student student) { return this.dao.cs_insertStudent(student); }

    @Override
    public int cs_insertTeacher(Teacher teacher) { return this.dao.cs_insertTeacher(teacher); }

    @Override
    public int cs_insertCourse(Course course) { return this.dao.cs_insertCourse(course); }

    @Override
    public void cs_deleteCourse(String courseId) { this.dao.cs_deleteCourse(courseId); }

    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public void cs_updateStudent(Student student) { this.dao.cs_updateStudent(student); }

    @Override
    public void cs_updateTeacher(Teacher teacher) { this.dao.cs_updateTeacher(teacher); }

    @Override
    public void cs_updateCourse(Course course) { this.dao.cs_updateCourse(course); }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Student cs_findStudentBySid(String studentId) {
        return dao.cs_findStudentBySid(studentId);
    }

    @Override
    public Teacher cs_findTeacherByTid(String teacherId) {
        return dao.cs_findTeacherByTid(teacherId);
    }

    @Override
    public Course cs_findCourseByCid(String courseId) {
        Course course = dao.cs_findCourseByCid(courseId);
        System.out.println(courseId);
        System.out.println(course.getCourseName());
        System.out.println(course.toString());
        return course;
    }
}
