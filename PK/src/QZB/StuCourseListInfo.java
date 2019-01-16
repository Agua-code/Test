package QZB;

/**
 * @program: PK
 * @description: 学生上课信息输入
 * @author: Mr.Sun
 * @create: 2018-12-03 20:33
 **/
public class StuCourseListInfo {
    private int stuTargetCourse;//目标课程
    private int stuCourseTime;//
    private int stuCourseType;//
    private int stuTargetClass;//目标教室（班级）

    public int getStuTargetCourse() {
        return stuTargetCourse;
    }

    public void setStuTargetCourse(int stuTargetCourse) {
        this.stuTargetCourse = stuTargetCourse;
    }

    public int getStuCourseTime() {
        return stuCourseTime;
    }

    public void setStuCourseTime(int stuCourseTime) {
        this.stuCourseTime = stuCourseTime;
    }

    public int getStuCourseType() {
        return stuCourseType;
    }

    public void setStuCourseType(int stuCourseType) {
        this.stuCourseType = stuCourseType;
    }

    public int getStuTargetClass() {
        return stuTargetClass;
    }

    public void setStuTargetClass(int stuTargetClass) {
        this.stuTargetClass = stuTargetClass;
    }
}
