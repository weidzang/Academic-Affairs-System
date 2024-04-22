package com.sse.ustc.lockcs.teacher.domain;

/**
 * @author
 * @description Stu_Course
 * @date 2023/4/28 23:42
 */
public class Stu_Course {
    private Integer sid;
    private Integer cid;
    private Integer result;

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

    @Override
    public String toString() {
        return "Stu_Course{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", result=" + result +
                '}';
    }
}
