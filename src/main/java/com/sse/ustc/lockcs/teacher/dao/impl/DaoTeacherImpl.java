package com.sse.ustc.lockcs.teacher.dao.impl;
import com.sse.ustc.lockcs.teacher.dao.DaoTeacher;
import com.sse.ustc.lockcs.teacher.domain.Stu_Course_Result;
import com.sse.ustc.lockcs.teacher.util.JDBCUtils;
import com.sse.ustc.lockcs.student.domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class DaoTeacherImpl implements DaoTeacher {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int cs_publicCourse(Course course) {
        String sql = "insert into course(id,courseId,courseName,credit,total,number,tName,tId,place,startTime, endTime) " +
                "values(NULL,?,?,?,?,?,?,?,?,?,?)";
        int count = template.update(sql, course.getCourseId(), course.getCourseName(), course.getCredit(),
                course.getTotal(), course.getNumber(), course.gettName(), course.gettId(),
                course.getPlace(), course.getStartTime(), course.getEndTime());
        return count;
    }


    @Override
    public int cs_lookPublishedCourse_TotalCount(Map<String, String[]> condition, Integer tId) {
        String sql = "select count(*) from course where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key) || "who".equals(key) || "id".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //处理datatime查询
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        //查询审核通过的
        sb.append(" and tId = ?");
        params.add(tId);
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Course> cs_lookPublishedCourseByPage(int start, int rows, Map<String, String[]> condition, Integer tId) {
        String sql = "select * from course where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key) || "who".equals(key) || "id".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //处理datatime查询
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        sb.append(" and tId = ?");
        params.add(tId);
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());

        return template.query(sb.toString(), new BeanPropertyRowMapper<Course>(Course.class), params.toArray());
    }

    @Override
    public List<Stu_Course_Result> cs_setStudentGradeByPage(String cId) {
        //select student.* from student_course join student on student_course.sid = student.id where student_course.cid = 1
        String sql = "select * from student_course join student on student_course.sid = student.id where student_course.cid = ?";

        System.out.println(sql);
        return template.query(sql, new BeanPropertyRowMapper<Stu_Course_Result>(Stu_Course_Result.class), cId);
    }

    @Override
    public int CS_saveStuResult(String sid, String cid, String result) {
        String sql = "update student_course set result = ? where sid = ? and cid = ?";
        template.update(sql, result, sid, cid);
        return 1;
    }

    @Override
    public Course cs_returnCourseByCid(String cid) {
        String sql = "select * from course where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), cid);
    }

    @Override
    public Integer getTIDByName(String who) {
        String sql = "select id from teacher where name = ?";
        return template.queryForObject(sql, Integer.class, who);
    }
}
