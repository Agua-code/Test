package XZPK;

import java.util.List;

/**
 * @program: PK
 * @description: 不满足的情况
 * @author: Mr.Sun
 * @create: 2018-09-26 19:20
 **/
public class Unsatisfaction {
    /**
     * 哪个班，班级和教师和课程不一定全部有数据，最后的形式为XX班的XX课在XX天存在XX问题，或XX老师的XX课在XX天存在问题，或XX老师在XX天存在问题
     */
    private int classID;
    /**
     *哪位教师
     */
    private int teaID;
    /**
     *哪位教师
     */
    private String teaName;
    /**
     *哪节课
     */
    private int courseID;
    /**
     *哪几天触发了
     */
    private List<Integer> dayLists;
    /**
     *触发了的规则
     */
    private String rule;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getTeaID() {
        return teaID;
    }

    public void setTeaID(int teaID) {
        this.teaID = teaID;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public List<Integer> getDayLists() {
        return dayLists;
    }

    public void setDayLists(List<Integer> dayLists) {
        this.dayLists = dayLists;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
