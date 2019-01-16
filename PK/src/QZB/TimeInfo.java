package QZB;

import java.util.List;

/**
 * @program: PK
 * @description: 不排课时间
 * @author: Mr.Sun
 * @create: 2018-09-25 22:22
 **/
public class TimeInfo {
    /**
     *哪一天的不排课信息
     */
    private int day;
    /**
     *不排课的具体信息，0-不能排课，1-可以排课
     */
    private List<Integer> avbTimeInfo;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Integer> getAvbTimeInfo() {
        return avbTimeInfo;
    }

    public void setAvbTimeInfo(List<Integer> avbTimeInfo) {
        this.avbTimeInfo = avbTimeInfo;
    }
}
