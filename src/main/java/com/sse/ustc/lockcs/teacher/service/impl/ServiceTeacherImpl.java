package com.sse.ustc.lockcs.teacher.service.impl;

import com.sse.ustc.lockcs.teacher.dao.DaoTeacher;
import com.sse.ustc.lockcs.teacher.dao.impl.DaoTeacherImpl;
import com.sse.ustc.lockcs.teacher.domain.Stu_Course_Result;
import com.sse.ustc.lockcs.teacher.service.ServiceTeacher;
import com.sse.ustc.lockcs.student.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ServiceTeacherImpl implements ServiceTeacher{
//    private DaoTeacher dao = new DaoTeacherImpl();

    @Autowired
    private DaoTeacher dao;

    @Override
    public int cs_publishCourse(Course course) {
        return dao.cs_publicCourse(course);
    }


    @Override
    public PageBean<Course> cs_lookPublishedCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition, Integer tId) {
        PageBean<Course> pb = new PageBean<Course>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //3.调用dao查询总记录数
        int totalCount = dao.cs_lookPublishedCourse_TotalCount(condition, tId);
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
        List<Course> list = dao.cs_lookPublishedCourseByPage(start,rows,condition,tId); // 加一个课程有没有被这个同学选过

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public List<Stu_Course_Result> cs_setStudentGrade(String cId) {
        List<Stu_Course_Result> list = dao.cs_setStudentGradeByPage(cId); // 加一个课程有没有被这个同学选过
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
        return list;
    }

    @Override
    public int CS_saveStuResult(String sid, String cid, String result) {
        return dao.CS_saveStuResult(sid, cid, result);
    }

    @Override
    public Course cs_returnCourseByCid(String cid) {
        return dao.cs_returnCourseByCid(cid);
    }

    @Override
    public Integer getTIDByName(String who) {
        return dao.getTIDByName(who);
    }
}
