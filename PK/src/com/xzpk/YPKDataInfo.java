package com.xzpk;

import java.util.List;

/**
 * @program: PK
 * @description: 预排课时间输入
 * @author: Mr.Sun
 * @create: 2018-09-25 22:30
 **/
public class YPKDataInfo {
    /**
     *预排了哪一天
     */
    private int day;
    /**
     *预排了哪些课
     */
    private List<YPKData> ypkData;

    public List<YPKData> getYpkData() {
        return ypkData;
    }

    public void setYpkData(List<YPKData> ypkData) {
        this.ypkData = ypkData;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }




}
