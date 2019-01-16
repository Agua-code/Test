package XZPK;

import java.util.List;

/**
 * @program: PK
 * @description:基础信息(用于输入所有的信息)
 * @author: Mr.Sun
 * @create: 2018-09-25 21:45
 **/
public class BasicDataInfo {
    /**
     * 一周上几天
     */
    private int weakDay;
    /**
     * 上午上几节
     */
    private int dayCrsMr;
    /**
     * 下午上几节
     */
    private int dayCrsAf;
    /**一天一共上几节
     */
    private int dayCrs;
    /**
     * 班级数量
     */
    private int classNum;
    /**
     * 班级信息（总的）
     */
    private List<Integer> classID;
    /**
     *课程数量
     */
    private int crsNum;
    /**
     *课程信息（总的）
     */
    private List<CrsListInfo> crsListInfo;
    /**
     *教师数量
     */
    private int teaNum;
    /**
     *教师信息（总的）
     */
    private List<String> teaName;
    /**
     *优先排课总开关
     */
    private int ctwo;
    /**
     *优先排课课程（如果ctwo==1，存在优先排课信息，如果ctwo==0，则不存在）
     */
    private List<Integer> ctwoCrs;
    /**
     *优先排课的节数（如果ctwo==1，存在优先排课信息，如果ctwo==0，则不存在）
     */
    private int ctwoTime;
    /**
     *班级需要上哪些课程，由哪个老师来交
     */
    private List<ClassCrsInfo> classCrsInfo;
    /**
     *不排课时间（按照"Class","Teacher","Course"进行分类）
     */
    private List<NoClassTimeInfo> noClassTimeInfo;
    /**
     *合班课数量
     */
    private int HBKNum;
    /**
     *合班课信息（如果HBKNum > 0 ，则存在，HBKNum == 0 则不存在）
     */
    private List<HBKInfo> hbkInfo;
    /**
     *预排课信息
     */
    private List<YPKInfo> ypkInfo;

    public int getWeakDay() {
        return weakDay;
    }

    public void setWeakDay(int weakDay) {
        this.weakDay = weakDay;
    }

    public int getDayCrsMr() {
        return dayCrsMr;
    }

    public void setDayCrsMr(int dayCrsMr) {
        this.dayCrsMr = dayCrsMr;
    }

    public int getDayCrsAf() {
        return dayCrsAf;
    }

    public void setDayCrsAf(int dayCrsAf) {
        this.dayCrsAf = dayCrsAf;
    }

    public int getDayCrs() {
        return dayCrs;
    }

    public void setDayCrs(int dayCrs) {
        this.dayCrs = dayCrs;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public List<Integer> getClassID() {
        return classID;
    }

    public void setClassID(List<Integer> classID) {
        this.classID = classID;
    }

    public int getCrsNum() {
        return crsNum;
    }

    public void setCrsNum(int crsNum) {
        this.crsNum = crsNum;
    }

    public List<CrsListInfo> getCrsListInfo() {
        return crsListInfo;
    }

    public void setCrsListInfo(List<CrsListInfo> crsListInfo) {
        this.crsListInfo = crsListInfo;
    }

    public int getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(int teaNum) {
        this.teaNum = teaNum;
    }

    public List<String> getTeaName() {
        return teaName;
    }

    public void setTeaName(List<String> teaName) {
        this.teaName = teaName;
    }

    public int getCtwo() {
        return ctwo;
    }

    public void setCtwo(int ctwo) {
        this.ctwo = ctwo;
    }

    public List<Integer> getCtwoCrs() {
        return ctwoCrs;
    }

    public void setCtwoCrs(List<Integer> ctwoCrs) {
        this.ctwoCrs = ctwoCrs;
    }

    public int getCtwoTime() {
        return ctwoTime;
    }

    public void setCtwoTime(int ctwoTime) {
        this.ctwoTime = ctwoTime;
    }

    public List<ClassCrsInfo> getClassCrsInfo() {
        return classCrsInfo;
    }

    public void setClassCrsInfo(List<ClassCrsInfo> classCrsInfo) {
        this.classCrsInfo = classCrsInfo;
    }

    public List<NoClassTimeInfo> getNoClassTimeInfo() {
        return noClassTimeInfo;
    }

    public void setNoClassTimeInfo(List<NoClassTimeInfo> noClassTimeInfo) {
        this.noClassTimeInfo = noClassTimeInfo;
    }

    public int getHBKNum() {
        return HBKNum;
    }

    public void setHBKNum(int HBKNum) {
        this.HBKNum = HBKNum;
    }

    public List<HBKInfo> getHbkInfo() {
        return hbkInfo;
    }

    public void setHbkInfo(List<HBKInfo> hbkInfo) {
        this.hbkInfo = hbkInfo;
    }

    public List<YPKInfo> getYpkInfo() {
        return ypkInfo;
    }

    public void setYpkInfo(List<YPKInfo> ypkInfo) {
        this.ypkInfo = ypkInfo;
    }




}
