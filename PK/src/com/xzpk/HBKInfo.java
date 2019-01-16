package com.xzpk;

import java.util.List;

/**
 * @program: PK
 * @description: 合班课信息
 * @author: Mr.Sun
 * @create: 2018-09-25 22:25
 **/
public class HBKInfo {
    /**
     *合班的课程ID
     */
    private int hbkcID;
    /**
     *合班的班级数量
     */
    private int hbkClassNum;
    /**
     *合班的班级
     */
    private List<HBKClassInfo> hbkClassInfo;

    public int getHbkcID() {
        return hbkcID;
    }

    public void setHbkcID(int hbkcID) {
        this.hbkcID = hbkcID;
    }

    public int getHbkClassNum() {
        return hbkClassNum;
    }

    public void setHbkClassNum(int hbkClassNum) {
        this.hbkClassNum = hbkClassNum;
    }

    public List<HBKClassInfo> getHbkClassInfo() {
        return hbkClassInfo;
    }

    public void setHbkClassInfo(List<HBKClassInfo> hbkClassInfo) {
        this.hbkClassInfo = hbkClassInfo;
    }
}
