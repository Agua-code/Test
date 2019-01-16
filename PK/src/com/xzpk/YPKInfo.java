package com.xzpk;

import java.util.List;

/**
 * @program: PK
 * @description: 预排课信息输入
 * @author: Mr.Sun
 * @create: 2018-09-25 22:28
 **/
public class YPKInfo {
    /**
     *预排了哪个班级ID
     */
    private int classID;
    /**
     *预排的结果
     */
    private List<YPKDataInfo> ypkDataInfo;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public List<YPKDataInfo> getYpkDataInfo() {
        return ypkDataInfo;
    }

    public void setYpkDataInfo(List<YPKDataInfo> ypkDataInfo) {
        this.ypkDataInfo = ypkDataInfo;
    }
}
