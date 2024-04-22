package com.sse.ustc.lockcs.student.dao.impl;

import com.sse.ustc.lockcs.admin.domain.Admin;
import com.sse.ustc.lockcs.student.dao.DaoStudent;
import com.sse.ustc.lockcs.student.domain.*;
import com.sse.ustc.lockcs.student.util.JDBCUtils;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class DaoStudentImpl implements DaoStudent {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

//    @Autowired
//    private JdbcTemplate template;

    /**
     * 学生登录
     *
     * @param studentUser
     * @return
     */
    @Override
    public Student login(Student studentUser) {
        try {
            System.out.println(studentUser.getStudentId());
            System.out.println(studentUser.getPassword());
            String sql = "select * from student where studentId = ? and password = ?";
//            template.queryForMap(sql,studentUser.getUsername(),studentUser.getPassword());
            Student loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), studentUser.getStudentId(), studentUser.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 教师登录
     *
     * @param teacher
     * @return
     */
    @Override
    public Teacher login_teacher(Teacher teacher) {
        try {
            String sql = "select * from teacher where teacherId = ? and password = ?";
//            template.queryForMap(sql,studentUser.getUsername(),studentUser.getPassword());
            Teacher loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), teacher.getTeacherId(), teacher.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 管理员登录
     *
     * @param admin
     * @return
     */
    @Override
    public Admin login_admin(Admin admin)
    {
        try{
            String sql = "select * from admin where adminId = ? and password = ?";
            Admin loginuser=template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),admin.getAdminId(),admin.getPassword());
            return loginuser;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public int cs_findCourse_TotalCount(Map<String, String[]> condition) {
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
//        sb.append(" and state = ?");
//        params.add("1");
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Course> cs_findCourseByPage(int start, int rows, Map<String, String[]> condition) {
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
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());

        return template.query(sb.toString(), new BeanPropertyRowMapper<Course>(Course.class), params.toArray());

    }

    @Override
    public int cs_countCourse(Integer cid) {
        String sql_ = "select number from course where id = ? ";
        Integer number = template.queryForObject(sql_, Integer.class, cid);
        if(number <= 0){
            return 0;
        }
        String sql = "update course set number = ? where id = ?";
        int count = template.update(sql, number - 1, cid);
        return count;
    }

    @Override
    public int cs_insertStu_Course(Integer sid, Integer cid) {
        String sql = "insert into student_course(sid, cid) " +
                "values(?,?)";
        int count = template.update(sql, sid, cid);
        return count;
    }

    @Override
    public int cs_deleteStu_Course(Integer sid, Integer cid) {
        String sql = "delete from student_course where sid=? and cid=?";
        int count1 = template.update(sql, sid, cid);
        String sql1 = "select number from course where id = ? ";
        Integer number = template.queryForObject(sql1, Integer.class, cid);
        if(number <= 0){
            return 0;
        }
        String sql2 = "update course set number = ? where id = ?";
        int count2 = template.update(sql2, number + 1, cid);
        return count1&count2;
    }

    @Override
    public int cs_Sym_Course(Integer sid, Integer cid) {
        String sql_ = "select count(sid) from student_course where sid = ? and cid = ? ";
        Integer total = template.queryForObject(sql_, Integer.class, sid, cid);
        return total;
    }

    @Override
    public List<Course_Result> cs_lookSelfResult(Integer id) {
        String sql = "select * from student_course join course on student_course.cid = course.id where student_course.sid = ?";
        return template.query(sql, new BeanPropertyRowMapper<Course_Result>(Course_Result.class), id);
    }
}

