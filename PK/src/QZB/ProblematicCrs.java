package QZB;

/**
 * @program: PK
 * @description: 有问题的节数
 * @author: Mr.Sun
 * @create: 2018-09-26 19:29
 **/
public class ProblematicCrs {
    /**
     * 规则类型,classRule和teaRule两种类型，classRule类型包括classID，day，crs，teaRule类型包括teaName，day，crs
     */
    private String type;
    private int classID;
    private int teaID;
    private String teaName;
    /**
     *哪一天
     */
    private int day;
    /**
     *哪节课
     */
    private int crs;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
