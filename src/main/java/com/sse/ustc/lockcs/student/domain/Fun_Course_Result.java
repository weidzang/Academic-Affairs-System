package com.sse.ustc.lockcs.student.domain;

import java.util.List;

/**
 * @author you liangfeng
 * @description Fun_Course_Result
 * @date 2023/4/29 21:47
 */
public class Fun_Course_Result {
    private List<Course_Result> course_result_List;

    private Double averageResult;
    private Integer maxResult;
    private Integer minResult;

    public void Fun_AgvMaxMin(){
        Double ans = 0.0;
        Integer t;
        Integer t2 = 0;
        Integer t3 = 5000;
        Integer cnt = 0;
        for(int i = 0; i < course_result_List.size(); i++){
            t = course_result_List.get(i).getResult();
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

    public List<Course_Result> getCourse_result_List() {
        return course_result_List;
    }

    public void setCourse_result_List(List<Course_Result> course_result_List) {
        this.course_result_List = course_result_List;
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
