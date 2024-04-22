package com.sse.ustc.lockcs.admin.dao.impl;
import com.sse.ustc.lockcs.admin.dao.DaoAdmin;
import com.sse.ustc.lockcs.admin.util.JDBCUtils;
import com.sse.ustc.lockcs.student.domain.Course;
import com.sse.ustc.lockcs.student.domain.Student;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class DaoAdminImpl implements DaoAdmin {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public DaoAdminImpl() {
        super();
    }

    @Override
    public int cs_insertTeacher(Teacher teacher) {
        String sql="insert into teacher(id,teacherID,password,phone,name) values(NULL,?,?,?,?)";
        int count=template.update(sql,teacher.getTeacherId(),teacher.getPassword(),teacher.getPhone(),teacher.getName());
        return count;
    }

    @Override
    public int cs_insertStudent(Student student) {
        String sql="insert into student(id,studentId,password,phone,name,sex,grade,level) values(NULL,?,?,?,?,?,?,?)";
        int count=template.update(sql,student.getStudentId(),student.getPassword(),student.getPhone(),student.getName(),
                student.getSex(),student.getGrade(),student.getLevel());
        return count;
    }

    @Override
    public int cs_insertCourse(Course course) {
        String sql = "insert into course(id,courseId,courseName,credit,total,number,tName,tId,place,startTime, endTime) " +
                "values(NULL,?,?,?,?,?,?,?,?,?,?)";
        int count = template.update(sql, course.getCourseId(), course.getCourseName(), course.getCredit(),
                course.getTotal(), course.getNumber(), course.gettName(), course.gettId(),
                course.getPlace(), course.getStartTime(), course.getEndTime());
        return count;
    }

    @Override
    public void cs_updateTeacher(Teacher teacher) {
        String sql="update teacher set password = ? ,phone = ? ,name = ? where teacherId = ? ";
        template.update(sql,teacher.getPassword(),teacher.getPhone(),teacher.getName(),teacher.getTeacherId());
    }

    @Override
    public void cs_updateStudent(Student student) {
        System.out.println(student.getStudentId());
        String sql="update student set password = ? ,phone = ? ,name = ? ,sex = ? ,grade = ? ,level = ? where studentId = ? ";
        template.update(sql,student.getPassword(),student.getPhone(),student.getName(),student.getSex(),
                student.getGrade(),student.getLevel(),student.getStudentId());
    }

    @Override
    public void cs_updateCourse(Course course) {
        String sql="update course set courseName = ? ,credit = ? ,total = ? ,number = ? ,tName = ? ,tId = ? ,place = ? ," +
                "startTime = ? ,endTime = ? where courseId = ? ";
        template.update(sql,course.getCourseName(),course.getCredit(),course.getTotal(),course.getNumber(),course.gettName(),
                course.gettId(),course.getPlace(),course.getStartTime(),course.getEndTime(),course.getCourseId());
    }


    @Override
    public void cs_deleteCourse(String courseId) {
        String sql1="delete from student_course where cid in (select id from course where courseId = ? )";
        template.update(sql1,courseId);
        String sql2="delete from course where courseId = ? ";
        template.update(sql2,courseId);
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
    public int cs_findStudent_TotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from student where 1 = 1 ";
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
    public List<Student> cs_findStudentByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from student where 1 = 1 ";
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

        return template.query(sb.toString(), new BeanPropertyRowMapper<Student>(Student.class), params.toArray());
    }

    @Override
    public int cs_findTeacher_TotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from teacher where 1 = 1 ";
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
    public List<Teacher> cs_findTeacherByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from teacher where 1 = 1 ";
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

        return template.query(sb.toString(), new BeanPropertyRowMapper<Teacher>(Teacher.class), params.toArray());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Student cs_findStudentBySid(String Sid) {
        try{
            String sql="select * from student where studentId = ? ";
            return template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),Sid);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public Teacher cs_findTeacherByTid(String Tid) {
        try{
            String sql="select * from teacher where teacherId = ? ";
            return template.queryForObject(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class),Tid);
        }
        catch(Exception e)
        {
            return null;
        }

    }

    @Override
    public Course cs_findCourseByCid(String Cid) {
        try{
            String sql="select * from course where courseId = ? ";
            return template.queryForObject(sql,new BeanPropertyRowMapper<Course>(Course.class),Cid);
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
