package QZB;

/**
 * @program: PK
 * @description: 学生课表信息
 * @author: Mr.Sun
 * @create: 2018-10-07 09:37
 **/
public class StuResultList {
    /**
     * 哪个学生
     */
    private int stuID;
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
     * 任课教师
     */
    private int teaID;

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

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
}
