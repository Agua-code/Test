package QZB;

import java.util.List;

/**
 * @program: PK
 * @description: 学生信息输入
 * @author: Mr.Sun
 * @create: 2018-10-06 09:50
 **/
public class StuDataInfo {
    private String stuName;
    private int stuID;
    private int stuClass;
    private List<StuCourseListInfo> stuCourseListInfo;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public List<StuCourseListInfo> getStuCourseListInfo() {
        return stuCourseListInfo;
    }

    public void setStuCourseListInfo(List<StuCourseListInfo> stuCourseListInfo) {
        this.stuCourseListInfo = stuCourseListInfo;
    }
}
