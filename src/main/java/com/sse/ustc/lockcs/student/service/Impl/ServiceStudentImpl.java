package com.sse.ustc.lockcs.student.service.Impl;

import com.sse.ustc.lockcs.admin.domain.Admin;
import com.sse.ustc.lockcs.lock.DistributedLockClient;
import com.sse.ustc.lockcs.lock.DistributedRedisLock;
import com.sse.ustc.lockcs.student.dao.DaoStudent;
import com.sse.ustc.lockcs.student.dao.impl.DaoStudentImpl;
import com.sse.ustc.lockcs.student.domain.*;
import com.sse.ustc.lockcs.student.service.ServiceStudent;
import com.sse.ustc.lockcs.teacher.domain.Teacher;
import lombok.SneakyThrows;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ServiceStudentImpl implements ServiceStudent {
//    private DaoStudent daoStudent = new DaoStudentImpl();

    @Autowired
    private DaoStudentImpl daoStudent;

    @Autowired
    private DistributedLockClient distributedLockClient;

    @Override
    public Student login(Student student) {
        return daoStudent.login(student);
    }

    @Override
    public Teacher login_teacher(Teacher teacher) {
        return daoStudent.login_teacher(teacher);
    }

    @Override
    public Admin login_admin(Admin admin) {
        System.out.println(admin.getName());return daoStudent.login_admin(admin); }

    @Override
    public PageBean<Sym_Course> cs_findCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition, Integer sid) {
        PageBean<Sym_Course> pb = new PageBean<Sym_Course>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //3.调用dao查询总记录数
        int totalCount = daoStudent.cs_findCourse_TotalCount(condition);
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
        List<Course> list = daoStudent.cs_findCourseByPage(start,rows,condition); // 加一个课程有没有被这个同学选过
        List<Sym_Course> list_sym = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            Course c = list.get(i);
            Sym_Course sym_course = new Sym_Course();
            sym_course.setCourse(c);
            int cnt = daoStudent.cs_Sym_Course(sid, c.getId());
//            System.out.println(sid + " " + c.getId() + " " + cnt);
            if(cnt == 1){
                sym_course.setSym(1);
            }
            else{
                sym_course.setSym(0);
            }
            list_sym.add(sym_course);
        }


        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list_sym);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public int cs_selectOneCourse(Integer sid, Integer cid) {
        /*
        redisTemplate = getRedis();
        redisTemplate.opsForValue().set("1","hello");
        Object str = redisTemplate.opsForValue().get("stock");
        System.out.println(str);
        */
        int cnt = daoStudent.cs_Sym_Course(sid, cid);//是不是已经选过了
        if(cnt >= 1){
            return 0;
        }
        // lock
        DistributedRedisLock lock = distributedLockClient.getRedisLock(cid.toString());
//        RLock lock = this.redissonClient.getLock(cid.toString());
        lock.lock();
        int num = 0;
        try {
            num = daoStudent.cs_countCourse(cid);//课程有没有余额
            if(num > 0){
                int count = daoStudent.cs_insertStu_Course(sid, cid);//默认成功，应该是一个事件，若宕机，应该回滚
            }
        }finally {
            //unlock
            lock.unlock();
        }
        return num;
    }
    @Override
    public int cs_deleteOneCourse(Integer sid, Integer cid) {
        /*
        redisTemplate = getRedis();
        redisTemplate.opsForValue().set("1","hello");
        Object str = redisTemplate.opsForValue().get("stock");
        System.out.println(str);
        */

        // lock
        DistributedRedisLock lock = distributedLockClient.getRedisLock(cid.toString());
//        RLock lock = this.redissonClient.getLock(cid.toString());
        lock.lock();
        int num = 0;
        try {
            num = daoStudent.cs_deleteStu_Course(sid, cid);//默认成功，应该是一个事件，若宕机，应该回滚
        }finally {
            //unlock
            lock.unlock();
        }
        return num;
    }

    @Override
    public List<Course_Result> cs_lookSelfResult(Integer id) {
        return daoStudent.cs_lookSelfResult(id);
    }

    public static RedisTemplate getRedis(){
        RedisTemplate template = new RedisTemplate();
        RedisStandaloneConfiguration standaloneConfig=new RedisStandaloneConfiguration("127.0.0.1", 6379);
        JedisConnectionFactory fac = new JedisConnectionFactory(standaloneConfig);
        fac.afterPropertiesSet();
        template.setConnectionFactory(fac);
        template.afterPropertiesSet();
        return template;
    }

}
