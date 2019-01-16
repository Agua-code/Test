package XZPK;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: PK
 * @description: 测试排课算法
 * @author: Mr.Sun
 * @create: 2018-09-27 16:31
 **/
public class test {
    public static void main(String[] args) throws IOException
    {

        /*
        BasicDataInfo inputData = new BasicDataInfo();
        inputData.setWeakDay(5);
        inputData.setDayCrsMr(3);
        inputData.setDayCrsAf(3);
        inputData.setDayCrs(6);
        inputData.setClassNum(3);

        List<Integer> classListInfoList = new ArrayList<Integer>();
        int classListInfo1 = 1607;
        classListInfoList.add(classListInfo1);
        inputData.setClassID(classListInfoList);

        inputData.setCrsNum(5);
        List<CrsListInfo> crsListInfoList = new ArrayList<CrsListInfo>();
        CrsListInfo crsListInfo = new CrsListInfo();
        crsListInfo.setCourseID(1854);
        crsListInfo.setCourseName("语文");
        inputData.setCrsListInfo(crsListInfoList);

        inputData.setCtwo(1);
        List<Integer> ctwoCrsListInfos = new ArrayList<Integer>();
        int ctwoCrsListInfo = 1854;
        ctwoCrsListInfos.add(ctwoCrsListInfo);
        inputData.setCtwoCrs(ctwoCrsListInfos);
        inputData.setCtwoTime(4);

        List<ClassCrsInfo> classCrsInfos = new ArrayList<ClassCrsInfo>();
        ClassCrsInfo classCrsInfo = new ClassCrsInfo();
        classCrsInfo.setClassID(1607);
        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
        CourseInfo courseInfo = new CourseInfo();
        courseInfos.add(courseInfo);
        classCrsInfo.setCourseInfoList(courseInfos);
        classCrsInfos.add(classCrsInfo);
        inputData.setClassCrsInfo(classCrsInfos);
        */


        XZGraphcolor graph = new XZGraphcolor();
        graph.setJsonData("C:\\Users\\18367\\IdeaProjects\\PK\\src\\XZPK\\新建文件夹\\demon_data33.json");

        try{
            ResultOutput outputResult = graph.startArrageSceldue();
            List<ClassResultList> classResultLists = outputResult.getClassResultList();
            for(ClassResultList classResultList:classResultLists)
            {
                System.out.print(classResultList.getDay() + " " + classResultList.getCrs() + " " + classResultList.getCourseID() + "\n");
            }
            List<Rule> ruleList = outputResult.getRules();
            for(Rule rule:ruleList)
            {
                System.out.print(rule.getSatisfctionRate() + "\n");
                List<Unsatisfaction> unsatisfactions = rule.getUnsatisfactions();
                //System.out.print("un = " + unsatisfactions.size());
                for(Unsatisfaction unsatisfaction:unsatisfactions)
                {
                    System.out.print(unsatisfaction.getRule() + " ");
                }
                System.out.print("\n");
            }
            List<TeaResultList> teaResultLists = outputResult.getTeaResultList();
            for(TeaResultList teaResultList:teaResultLists)
            {
                System.out.print(teaResultList.getDay() + " " + teaResultList.getCrs() + " " + teaResultList.getCourseID() + "\n");
            }
        }catch (MyException e)
        {
            System.out.print(e);
        }




        /*
        for(int i = 0;i<graph.errorLists.size();i++)
        {
            graph.errorLists.get(i);
        }
        */
    }
}
