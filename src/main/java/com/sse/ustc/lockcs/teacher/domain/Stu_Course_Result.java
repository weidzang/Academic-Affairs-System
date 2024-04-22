package com.sse.ustc.lockcs.teacher.domain;

import com.sse.ustc.lockcs.student.domain.Student;

/**
 * @author you liangfeng
 * @description Stu_Course_Result
 * @date 2023/4/28 23:44
 */
public class Stu_Course_Result {//学生表 和 成绩 组合
    private Integer sid;
    private Integer cid;
    private Integer result;
    private Integer id;
    private String studentId;
    private String password;
    private String phone;
    private String name;
    private String sex;
    private Integer grade;
    private String level;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Stu_Course_Result{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", result=" + result +
                ", id=" + id +
                ", studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                ", level='" + level + '\'' +
                '}';
    }
}
