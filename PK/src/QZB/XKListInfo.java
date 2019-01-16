package QZB;

import java.util.List;

/**
 * @program: PK
 * @description: 选考课上课的班级
 * @author: Mr.Sun
 * @create: 2018-10-06 09:30
 **/
public class XKListInfo {
    private int xkTime;
    private List<Integer> xkClass;

    public int getXkTime() {
        return xkTime;
    }

    public void setXkTime(int xkTime) {
        this.xkTime = xkTime;
    }

    public List<Integer> getXkClass() {
        return xkClass;
    }

    public void setXkClass(List<Integer> xkClass) {
        this.xkClass = xkClass;
    }
}
