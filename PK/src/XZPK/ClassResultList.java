package XZPK;

/**
 * @program: PK
 * @description: 排课结果
 * @author: Mr.Sun
 * @create: 2018-09-26 11:32
 **/
public class ClassResultList {
    /**
     *班级ID
     */
    private int classID;
    /**
     *星期几
     */
    private int day;
    /**
     *第几节课
     */
    private int crs;
    /**
     *上的是哪一门课
     */
    private int courseID;
    /**
     *由哪位老师来上
     */
    private int teaID;
    /**
     *由哪位老师来上
     */
    private String teaName;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
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
}
