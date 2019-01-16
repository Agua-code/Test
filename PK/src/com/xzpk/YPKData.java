package com.xzpk;

/**
 * @program: PK
 * @description:预排课具体信息输入
 * @author: Mr.Sun
 * @create: 2018-09-25 22:37
 **/
public class YPKData {
    /**
     *预排的具体信息，0表示这节课没有预排，课程ID表示这节课预排了该课程
     */
    private int ypkID;
    public int getYpkID() {
        return ypkID;
    }

    public void setYpkID(int ypkID) {
        this.ypkID = ypkID;
    }
}
