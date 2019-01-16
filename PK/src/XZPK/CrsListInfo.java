package XZPK;

/**
 * @program: PK
 * @description: 课程列表输入
 * @author: Mr.Sun
 * @create: 2018-09-25 21:58
 **/
public class CrsListInfo {
    /**
     *课程的ID，需要输入所有的课程
     */
    private int courseID;
    /**
     *课程的名字，因为需要做匹配，所以需要课程名字，名字与ID对应
     */
    private String courseName;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



}
