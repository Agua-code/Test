package QZB;

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
    private List<Integer> ypkData;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Integer> getYpkData() {
        return ypkData;
    }

    public void setYpkData(List<Integer> ypkData) {
        this.ypkData = ypkData;
    }
}
