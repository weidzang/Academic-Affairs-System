package com.sse.ustc.lockcs.student.domain;/**
 *
 * @description Sym_Course
 * @author
 * @date 2023/4/27 22:35
 */
public class Sym_Course {
     private Integer sym;
     private Course course;

    public Integer getSym() {
        return sym;
    }

    public void setSym(Integer sym) {
        this.sym = sym;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
