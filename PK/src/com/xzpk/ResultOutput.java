package com.xzpk;

import java.util.List;

/**
 * @program: PK
 * @description: 结果输出
 * @author: Mr.Sun
 * @create: 2018-09-26 11:29
 **/
public class ResultOutput {
    /**
     *一周总的课时数
     */
    private int weakCrs;
    /**
     *班级课表结果
     */
    private List<ClassResultList> classResultList;
    /**
     *教师课表结果
     */
    private List<TeaResultList> teaResultList;

    public int getWeakCrs() {
        return weakCrs;
    }

    public void setWeakCrs(int weakCrs) {
        this.weakCrs = weakCrs;
    }

    public List<ClassResultList> getClassResultList() {
        return classResultList;
    }

    public void setClassResultList(List<ClassResultList> classResultList) {
        this.classResultList = classResultList;
    }

    public List<TeaResultList> getTeaResultList() {
        return teaResultList;
    }

    public void setTeaResultList(List<TeaResultList> teaResultList) {
        this.teaResultList = teaResultList;
    }
}
