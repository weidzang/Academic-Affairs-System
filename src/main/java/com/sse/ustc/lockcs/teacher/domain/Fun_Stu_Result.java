package com.sse.ustc.lockcs.teacher.domain;

import com.sse.ustc.lockcs.student.domain.Course_Result;

import java.util.List;

/**
 * @author you liangfeng
 * @description Stu_Course_Result
 * @date 2023/4/29 21:47
 */
public class Fun_Stu_Result {
    private List<Stu_Course_Result> stu_course_results;

    private Double averageResult;
    private Integer maxResult;
    private Integer minResult;

    public void Fun_AgvMaxMin(){
        Double ans = 0.0;
        Integer t;
        Integer t2 = 0;
        Integer t3 = 5000;
        Integer cnt = 0;
        for(int i = 0; i < stu_course_results.size(); i++){
            t = stu_course_results.get(i).getResult();
            if(t != null){
                t2 = Math.max(t2, t);
                t3 = Math.min(t3, t);
                ans = ans + t.doubleValue();
                cnt = cnt + 1;
            }
        }
        this.maxResult = t2;
        this.minResult = t3;
        this.averageResult = ans / cnt;
    }

    public List<Stu_Course_Result> getStu_course_results() {
        return stu_course_results;
    }

    public void setStu_course_results(List<Stu_Course_Result> stu_course_results) {
        this.stu_course_results = stu_course_results;
    }

    public Double getAverageResult() {
        return averageResult;
    }

    public void setAverageResult(Double averageResult) {
        this.averageResult = averageResult;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public Integer getMinResult() {
        return minResult;
    }

    public void setMinResult(Integer minResult) {
        this.minResult = minResult;
    }
}
