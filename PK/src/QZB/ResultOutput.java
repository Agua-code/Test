package QZB;

import java.util.List;

/**
 * @program: PK
 * @description: 结果输出
 * @author: Mr.Sun
 * @create: 2018-09-26 11:29
 **/
public class ResultOutput {
    /**
     * 总排课质量
     */
    private String courseQuality;
    /**
     *排课质量总的描述
     */
    private String qualityDescription;
    /**
     *具体触发了哪些规则
     */
    private List<Rule> rules;
    /**
     *一周总的课时数
     */
    private int weakCrs;
    /**
     *班级课表结果
     */
    private List<ClassResultList> classResultList;
    /**
     *教师课表结果
     */
    private List<TeaResultList> teaResultList;
    /**
     *学生课表结果
     */
    private List<StuResultList> stuResultList;

    public int getWeakCrs() {
        return weakCrs;
    }

    public void setWeakCrs(int weakCrs) {
        this.weakCrs = weakCrs;
    }

    public List<ClassResultList> getClassResultList() {
        return classResultList;
    }

    public void setClassResultList(List<ClassResultList> classResultList) {
        this.classResultList = classResultList;
    }

    public List<TeaResultList> getTeaResultList() {
        return teaResultList;
    }

    public void setTeaResultList(List<TeaResultList> teaResultList) {
        this.teaResultList = teaResultList;
    }

    public String getCourseQuality() {
        return courseQuality;
    }

    public void setCourseQuality(String courseQuality) {
        this.courseQuality = courseQuality;
    }

    public String getQualityDescription() {
        return qualityDescription;
    }

    public void setQualityDescription(String qualityDescription) {
        this.qualityDescription = qualityDescription;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<StuResultList> getStuResultList() {
        return stuResultList;
    }

    public void setStuResultList(List<StuResultList> stuResultList) {
        this.stuResultList = stuResultList;
    }
}
