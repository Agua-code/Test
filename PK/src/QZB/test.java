package QZB;

import QZB.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @program: test
 * @description: 选考测试
 * @author: Mr.Sun
 * @create: 2018-10-20 13:02
 **/
public class test {

    private static String ReadFile(String path){
        String laststr="";
        File file=new File(path);// 打开文件
        BufferedReader reader=null;
        try{
            FileInputStream in = new FileInputStream(file);
            reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));// 读取文件
            String tempString=null;
            while((tempString=reader.readLine())!=null){
                laststr=laststr+tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException el){
                }
            }
        }
        return laststr;
    }

    public static void main(String[] args) throws IOException {
        int i, j, k;
        int class_id = 0;
        int day = 0;
        int tea_id = 0;
        int crs_id = 0;
        int m, l;
        int x, y;
        Collator co = Collator.getInstance(Locale.CHINA);
        BasicDataInfo inputdata = new BasicDataInfo();
        String jsonStr = ReadFile("C:\\Users\\18367\\IdeaProjects\\PK\\src\\QZB\\QZBPKInfo_test8.0.json");

        JSONObject jsonObject=JSONObject.fromObject(jsonStr);
        inputdata.setWeakDay(jsonObject.getInt("weakDay"));
        inputdata.setDayCrs(jsonObject.getInt("dayCrs"));
        inputdata.setDayCrsAf(jsonObject.getInt("dayCrsAf"));
        inputdata.setDayCrsMr(jsonObject.getInt("dayCrsMr"));

        //所有班级、课程、教师信息列表
        inputdata.setClassNum(jsonObject.getInt("classNum"));
        JSONArray classList = jsonObject.getJSONArray("classID");
        List<Integer> classid = new ArrayList<Integer>();
        for(i = 0;i < classList.size();i++)
        {

            classid.add(classList.getInt(i));
        }
        inputdata.setClassID(classid);

        inputdata.setCrsNum(jsonObject.getInt("crsNum"));
        JSONArray crsList = jsonObject.getJSONArray("crsListInfo");
        List<CrsListInfo> crsListInfos = new ArrayList<CrsListInfo>();
        for(i = 0;i < crsList.size();i++)
        {
            CrsListInfo crsListInfo = new CrsListInfo();
            crsListInfo.setCourseID(crsList.getJSONObject(i).getInt("courseID"));
            crsListInfo.setCourseName(crsList.getJSONObject(i).getString("courseName"));
            crsListInfos.add(crsListInfo);
            //System.out.print(crsList.getJSONObject(i).getInt("id") + "\n");
        }
        inputdata.setCrsListInfo(crsListInfos);

        inputdata.setTeaNum(jsonObject.getInt("teaNum"));
        JSONArray teaList = jsonObject.getJSONArray("teaID");
        List<Integer> teaID = new ArrayList<Integer>();
        for(i = 0;i < teaList.size();i++)
        {
            teaID.add(teaList.getInt(i));
        }
        inputdata.setTeaID(teaID);

        //触发优先排课
        inputdata.setCtwo(jsonObject.getInt("ctwo"));
        if(jsonObject.getInt("ctwo") == 1)//触发优先排课
        {
            JSONArray CtwoCrsArray = jsonObject.getJSONArray("ctwoCrs");
            List<Integer> ctwocrs = new ArrayList<Integer>();
            for(i=0;i<CtwoCrsArray.size();i++)
            {
                ctwocrs.add(CtwoCrsArray.getInt(i));
            }
            inputdata.setCtwoCrs(ctwocrs);
            inputdata.setCtwoTime(jsonObject.getInt("ctwoTime"));
        }

        //班级-课程信息
        JSONArray classArray = jsonObject.getJSONArray("classCrsInfo");
        List<ClassCrsInfo> classCrsInfos = new ArrayList<ClassCrsInfo>();
        for(i = 0;i<classArray.size();i++)
        {
            ClassCrsInfo classCrsInfo = new ClassCrsInfo();
            classCrsInfo.setClassID(classArray.getJSONObject(i).getInt("classID"));

            //这里有问题
            JSONArray courseArray = classArray.getJSONObject(i).getJSONArray("courseInfoList");
            List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
            for(j=0;j<courseArray.size();j++)
            {
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setCourseTeaID(courseArray.getJSONObject(j).getInt("courseTeaID"));
                courseInfo.setCourseID(courseArray.getJSONObject(j).getInt("courseID"));
                courseInfo.setCourseNum(courseArray.getJSONObject(j).getInt("courseNum"));
                courseInfo.setCourseLTNum(courseArray.getJSONObject(j).getInt("courseLTNum"));
                courseInfo.setCourseTeaNum(courseArray.getJSONObject(j).getInt("courseTeaNum"));
                courseInfo.setCourseTime(courseArray.getJSONObject(j).getInt("courseTime"));
                courseInfo.setCourseType(courseArray.getJSONObject(j).getInt("courseType"));
                courseInfos.add(courseInfo);
                //System.out.println(Class_Tea[class_id][crs_id]);
            }
            classCrsInfo.setCourseInfoList(courseInfos);
            classCrsInfos.add(classCrsInfo);
        }
        inputdata.setClassCrsInfo(classCrsInfos);

        /////////////////////////////////////////////////////////////
        //不排课时间
        JSONArray noClassTimeArray = jsonObject.getJSONArray("noClassTimeInfo");
        List<NoClassTimeInfo> noClassTimeInfos = new ArrayList<NoClassTimeInfo>();
        for(i = 0;i<noClassTimeArray.size();i++)
        {
            //System.out.print(noClassTimeArray.getJSONObject(i).getString("type"));
            NoClassTimeInfo noClassTimeInfo = new NoClassTimeInfo();
            if(co.compare(noClassTimeArray.getJSONObject(i).getString("type"),"Class") == 0)
            {
                noClassTimeInfo.setType(noClassTimeArray.getJSONObject(i).getString("type"));
                noClassTimeInfo.setId(noClassTimeArray.getJSONObject(i).getInt("id"));
                noClassTimeInfo.setConcentrated(noClassTimeArray.getJSONObject(i).getInt("concentrated"));
                List<TimeInfo> timeInfos = new ArrayList<TimeInfo>();
                JSONArray timeArray = noClassTimeArray.getJSONObject(i).getJSONArray("timeInfo");
                for(j=0;j<timeArray.size();j++)
                {
                    TimeInfo timeInfo = new TimeInfo();
                    timeInfo.setDay(timeArray.getJSONObject(j).getInt("day"));
                    List<Integer> avbtime = new ArrayList<Integer>();
                    JSONArray avbTimeArray = timeArray.getJSONObject(j).getJSONArray("avbTimeInfo");
                    for(k=0;k<avbTimeArray.size();k++)
                    {
                        avbtime.add(avbTimeArray.getInt(k));
                        //System.out.print(Class_AvrT[class_id][day][k+1] + " ");
                    }
                    timeInfo.setAvbTimeInfo(avbtime);
                }
                noClassTimeInfo.setTimeInfo(timeInfos);
            }
            else if(co.compare(noClassTimeArray.getJSONObject(i).getString("type"),"Teacher") == 0)
            {
                noClassTimeInfo.setType(noClassTimeArray.getJSONObject(i).getString("type"));
                noClassTimeInfo.setId(noClassTimeArray.getJSONObject(i).getInt("id"));
                noClassTimeInfo.setConcentrated(noClassTimeArray.getJSONObject(i).getInt("concentrated"));
                List<TimeInfo> timeInfos = new ArrayList<TimeInfo>();
                JSONArray timeArray = noClassTimeArray.getJSONObject(i).getJSONArray("timeInfo");
                for(j=0;j<timeArray.size();j++)
                {
                    TimeInfo timeInfo = new TimeInfo();
                    timeInfo.setDay(timeArray.getJSONObject(j).getInt("day"));
                    List<Integer> avbtime = new ArrayList<Integer>();
                    JSONArray avbTimeArray = timeArray.getJSONObject(j).getJSONArray("avbTimeInfo");
                    for(k=0;k<avbTimeArray.size();k++)
                    {
                        avbtime.add(avbTimeArray.getInt(k));
                        //System.out.print(Class_AvrT[class_id][day][k+1] + " ");
                    }
                    timeInfo.setAvbTimeInfo(avbtime);
                }
                noClassTimeInfo.setTimeInfo(timeInfos);
            }
            else if(co.compare(noClassTimeArray.getJSONObject(i).getString("type"),"Course") == 0)
            {
                noClassTimeInfo.setType(noClassTimeArray.getJSONObject(i).getString("type"));
                noClassTimeInfo.setId(noClassTimeArray.getJSONObject(i).getInt("id"));
                noClassTimeInfo.setConcentrated(noClassTimeArray.getJSONObject(i).getInt("concentrated"));
                List<TimeInfo> timeInfos = new ArrayList<TimeInfo>();
                JSONArray timeArray = noClassTimeArray.getJSONObject(i).getJSONArray("timeInfo");
                for(j=0;j<timeArray.size();j++)
                {
                    TimeInfo timeInfo = new TimeInfo();
                    timeInfo.setDay(timeArray.getJSONObject(j).getInt("day"));
                    List<Integer> avbtime = new ArrayList<Integer>();
                    JSONArray avbTimeArray = timeArray.getJSONObject(j).getJSONArray("avbTimeInfo");
                    for(k=0;k<avbTimeArray.size();k++)
                    {
                        avbtime.add(avbTimeArray.getInt(k));
                        //System.out.print(Class_AvrT[class_id][day][k+1] + " ");
                    }
                    timeInfo.setAvbTimeInfo(avbtime);
                }
                noClassTimeInfo.setTimeInfo(timeInfos);
            }
            noClassTimeInfos.add(noClassTimeInfo);
        }
        inputdata.setNoClassTimeInfo(noClassTimeInfos);
        //合班课
        inputdata.setHBKNum(jsonObject.getInt("hBKNum"));
        if(jsonObject.getInt("hBKNum") > 0)
        {
            List<HBKInfo> hbkInfos = new ArrayList<HBKInfo>();
            JSONArray HBKArray = jsonObject.getJSONArray("hbkInfo");
            for(i=0;i<HBKArray.size();i++)
            {
                HBKInfo hbkInfo = new HBKInfo();
                hbkInfo.setHbkcID(HBKArray.getJSONObject(i).getInt("hbkcID"));
                hbkInfo.setHbkClassNum(HBKArray.getJSONObject(i).getInt("hbkClassNum"));

                JSONArray HBKClassArray = HBKArray.getJSONObject(i).getJSONArray("hbkClassInfo");
                List<Integer> hbkclass = new ArrayList<Integer>();
                for(j=0;j<HBKClassArray.size();j++)
                {
                    hbkclass.add(HBKClassArray.getInt(j));
                }
                hbkInfo.setHbkClassInfo(hbkclass);
                hbkInfos.add(hbkInfo);
            }
            inputdata.setHbkInfo(hbkInfos);
        }

        //预排课
        JSONArray YPKArray = jsonObject.getJSONArray("ypkInfo");
        List<YPKInfo> ypkInfos = new ArrayList<YPKInfo>();
        for(i=0;i<YPKArray.size();i++)
        {
            YPKInfo ypkInfo = new YPKInfo();
            ypkInfo.setClassID(YPKArray.getJSONObject(i).getInt("classID"));

            JSONArray timeArry = YPKArray.getJSONObject(i).getJSONArray("ypkDataInfo");
            List<YPKDataInfo> timeinfos = new ArrayList<YPKDataInfo>();
            for(j=0;j<timeArry.size();j++) {
                YPKDataInfo timeInfo = new YPKDataInfo();
                timeInfo.setDay(timeArry.getJSONObject(j).getInt("day"));

                JSONArray YPKTimeArray = timeArry.getJSONObject(j).getJSONArray("ypkData");
                List<Integer> ypktime = new ArrayList<Integer>();
                for (k = 0; k < YPKTimeArray.size(); k++) {
                    ypktime.add(YPKTimeArray.getInt(k));
                }
                timeInfo.setYpkData(ypktime);
                timeinfos.add(timeInfo);
            }
            ypkInfo.setYpkDataInfo(timeinfos);
            ypkInfos.add(ypkInfo);
        }
        inputdata.setYpkInfo(ypkInfos);

        //选考
        inputdata.setXKNum(jsonObject.getInt("xKNum"));
        JSONArray xkListArray = jsonObject.getJSONArray("xkListInfo");
        List<XKListInfo> xkListInfos = new ArrayList<XKListInfo>();
        for(i=0;i<xkListArray.size();i++)
        {
            XKListInfo xkListInfo = new XKListInfo();
            xkListInfo.setXkTime(xkListArray.getJSONObject(i).getInt("xkTime"));
            JSONArray xkClassArray = xkListArray.getJSONObject(i).getJSONArray("xkClass");
            List<Integer> xkClass = new ArrayList<Integer>();
            for(j=0;j<xkClassArray.size();j++)
            {
                xkClass.add(xkClassArray.getInt(j));
            }
            xkListInfo.setXkClass(xkClass);
            xkListInfos.add(xkListInfo);
        }
        inputdata.setXkListInfo(xkListInfos);
        //学生选课情况
        List<StuDataInfo> stuDataInfoList = new ArrayList<StuDataInfo>();
        JSONArray stuDataArray = jsonObject.getJSONArray("stuDataInfoList");
        for(i=0;i < stuDataArray.size();i++)
        {
            StuDataInfo stuDataInfo = new StuDataInfo();
            stuDataInfo.setStuID(stuDataArray.getJSONObject(i).getInt("stuID"));
            stuDataInfo.setStuClass(stuDataArray.getJSONObject(i).getInt("stuClass"));
            stuDataInfo.setStuName(stuDataArray.getJSONObject(i).getString("stuName"));
            //stuDataArray.getJSONObject(i).getJSONArray("stuMoveList");
            JSONArray stuCourseList = stuDataArray.getJSONObject(i).getJSONArray("stuCourseListInfo");
            List<StuCourseListInfo> stuCourseListInfos = new ArrayList<StuCourseListInfo>();
            for(j = 0;j<stuCourseList.size();j++){
                StuCourseListInfo stuCourseListInfo = new StuCourseListInfo();
                stuCourseListInfo.setStuTargetCourse(stuCourseList.getJSONObject(j).getInt("stuTargetCourse"));
                stuCourseListInfo.setStuCourseTime(stuCourseList.getJSONObject(j).getInt("stuCourseTime"));
                stuCourseListInfo.setStuCourseType(stuCourseList.getJSONObject(j).getInt("stuCourseType"));
                stuCourseListInfo.setStuTargetClass(stuCourseList.getJSONObject(j).getInt("stuTargetClass"));
                stuCourseListInfos.add(stuCourseListInfo);
            }
            stuDataInfo.setStuCourseListInfo(stuCourseListInfos);
            stuDataInfoList.add(stuDataInfo);
        }
        inputdata.setStuDataInfoList(stuDataInfoList);


        QZBGraphcolor graph = new QZBGraphcolor();
        graph.setData(inputdata);
        try{
            ResultOutput outputResult = new ResultOutput();
            outputResult = graph.startArrageSceldue();
            List<ClassResultList> classResultLists = outputResult.getClassResultList();
            for(ClassResultList classResultList:classResultLists)
            {
                System.out.print( classResultList.getDay() + " " + classResultList.getCrs() + " " + classResultList.getCourseID() + " " + classResultList.getStuList() + "\n");
                /*if(classResultList.getCrs() == 8){
                    System.out.print("\n");
                    if(classResultList.getDay() == 5){
                        System.out.print("\n");
                    }
                }*/

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
            /*List<TeaResultList> teaResultLists = outputResult.getTeaResultList();
            for(TeaResultList teaResultList:teaResultLists)
            {
                System.out.print(teaResultList.getCourseID() + " ");
                if(teaResultList.getCrs() == 12){
                    System.out.print("\n");
                    if(teaResultList.getDay() == 7){
                        System.out.print("\n");
                    }
                }
            }
            List<StuResultList> stuResultLists = outputResult.getStuResultList();
            for(StuResultList stuResultList:stuResultLists){
                System.out.print(stuResultList.getDay() + " " + stuResultList.getCrs() + " " + stuResultList.getTeaID() + "\n");
            }*/
        }catch (MyException e)
        {
            System.out.print(e);
        }
    }
}
