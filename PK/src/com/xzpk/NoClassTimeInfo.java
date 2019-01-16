package com.xzpk;

import java.util.List;

/**
 * @program: PK
 * @description: 不排课信息输入
 * @author: Mr.Sun
 * @create: 2018-09-25 22:21
 **/
public class NoClassTimeInfo {
    /**
     *不排课时间的类型，"Class","Teacher","Course"三种
     */
    private String type;
    /**
     *ClassID或TeacherID或CourseID，由type决定
     */
    private int id;
    /**
     *是否集中授课，如果是"Teacher"类型，则输入该数据
     */
    private int concentrated;
    /**
     *不排课时间输入0-不能排课，1-可以排课
     */
    private List<TimeInfo> timeInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConcentrated() {
        return concentrated;
    }

    public void setConcentrated(int concentrated) {
        this.concentrated = concentrated;
    }

    public List<TimeInfo> getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(List<TimeInfo> timeInfo) {
        this.timeInfo = timeInfo;
    }
}
