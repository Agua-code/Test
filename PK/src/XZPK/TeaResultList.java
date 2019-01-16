package XZPK;

import java.util.List;

/**
 * @program: PK
 * @description: 教师课程信息
 * @author: Mr.Sun
 * @create: 2018-09-26 11:37
 **/
public class TeaResultList {
    /**
     *哪位教师的课表
     */
    private int teaID;
    /**
     *哪位教师的课表
     */
    private String teaName;
    /**
     *星期几
     */
    private int day;
    /**
     *第几节课
     */
    private int crs;
    /**
     *上的是哪门课
     */
    private int courseID;
    /**
     *由于有合班的情况存在，所以此处可能不止一个班级，所以用List存储
     */
    private List<Integer> classIdList;

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getCrs() {
        return crs;
    }

    public void setCrs(int crs) {
        this.crs = crs;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public List<Integer> getClassIdList() {
        return classIdList;
    }

    public void setClassIdList(List<Integer> classIdList) {
        this.classIdList = classIdList;
    }
}
