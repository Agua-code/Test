package QZB;

import java.util.List;

/**
 * @program: PK
 * @description: 班级课程对应信息输入
 * @author: Mr.Sun
 * @create: 2018-09-25 22:09
 **/
public class ClassCrsInfo {
    /**
     *班级ID
     */
    private int classID;
    /**
     *班级所对应的课程信息
     */
    private List<CourseInfo> courseInfoList;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public List<CourseInfo> getCourseInfoList() {
        return courseInfoList;
    }

    public void setCourseInfoList(List<CourseInfo> courseInfoList) {
        this.courseInfoList = courseInfoList;
    }


}
