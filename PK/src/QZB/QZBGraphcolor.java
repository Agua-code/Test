package QZB;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @program: PK
 * @description: 全走班模式
 * @author: Mr.Sun
 * @create: 2018-09-30 15:40
 **/
public class QZBGraphcolor {
    //基本信息数据结构
    private int Crs_Num = 0;
    private int Class_Num = 0;
    private int Tea_Num = 0;
    private int KCL = 0;//一周多少节课
    private int Weak_Day = 0;
    private int Day_Crs = 0;
    private int Day_Crs_Mr = 0;
    private int Day_Crs_Af = 0;
    private int maxCourseID = 0;
    private int PDay[] = null;
    private int PCr[]= null;
    private int MCls[]= null;
    private int MCrs[]= null;
    private int Class_Crs_CD[][]= null;
    private int Min_Day[]= null;
    private int Max_Day[]= null;
    private int Max_Mr[] = null;
    private int Max_Af[] = null;
    private int LTK_Week[]= null;//课程每周的节数
    private int Crs_Attri[]= null;
    private int Tct[]= null;//是否集中排课
    private int Vtx_len = 0;
    private int Tea_Course_Num[] = null;
    //String Filename1= new String();
    //String Filename2= new String();
    //课表数据结构
    private int Class_Crs[][][]= null;//班级课表
    private int Tea_Crs[][][]= null;//教师课表
    private int Stu_Crs[][][]= null;//学生课表
    //排课时间限制数据结构
    private int Class_AvrT[][][]= null;
    private int Tea_AvrT[][][]= null;
    private int Crs_AvrT[][][]= null;
    private int XK_AvrT[][][]= null;
    private int AVB_Cl[][]= null;
    //图着色数据结构
    private int MNum = 0;
    private int N_vtx = 0;
    private int Edge[][]= null;
    private int A_Matrix[][]= null;
    private int Set_cl[][]= null;
    private int Stu_cl[][] = null;//哪个班的哪门课有哪些学生
    private int Stu_Class_cl[][] = null;
    private int Set_Crs[][][]= null;
    private int Par[]= null;
    private int Node_Tea[][]= null;
    private int Node_Stu[][] = null;
    private int Node_Course[][]= null;
    private int Node_Class[][]= null;
    private int Node_Avb[][]= null;
    private int Tea_CP[][]= null;
    private int Synthesis_Node[]= null;//合成点
    private int Synthesis_Node_Num = 0;//合成数量
    private int XK_Node[] = null;//选考合成点
    private int XK_Node_Num = 0;//选考合成数量
    private int Tea_CP_Sign[][]= null;//教师教的课程的标记
    private int Color[]= null;
    private int Initial_Color[]= null;
    private int Best_Color[]= null;
    private int Final_Color[]= null;
    private int Node_Tea_Sign[]= null;
    //检验课表优劣数组
    private int Day_Set[][] = null;
    private int Day[][] = null;
    private int set[] = null;
    private int Class_Score[]= null;//班级课表优劣
    private int Tea_JP_Score[]= null;//教师课表优劣
    private int Tea_Score[]= null;//二次教师课表优劣
    private int TScr[]= null;
    private int Tea_Scr[][]= null;
    private int daycr[]= null;
    private int daylt[]= null;
    private int All_cl[]= null;//一周内课程的分布情况
    private int Ctwo = 0;
    private int C_Time = 0;
    private int Cct[] = null;//每一门课的开关
    private int Crs_srt_cl[][]= null;
    private int JP_KC[][]= null;
    //tabu搜索数据结构
    private int tabuh[]= null;
    private int TTL = 0;
    private int f = 0;
    private int f_crs = 0;
    private int f_tea = 0;
    private int f_best = 0;
    private int fc = 0;
    private int fc_best = 0;
    private int Delta_Matrix[][]= null;
    private int TabuTenure[][]= null;
    private int best_x[]= null;
    private int best_v[]= null;
    private int Delta_Crs[][]= null;
    private int Delta_Tpj[][]= null;
    private int Delta_Ttm[][]= null;
    private int dgl[]= null;
    //合班课数据结构
    private int HBK_Num = 0;
    private int HBK[][]= null;
    private int HBK_C[]= null;
    private int Class_Crs_HEBAN[][]= null;
    //课程信息数据结构
    private ArrayList<String> Coursename = null;//课程名字
    private ArrayList<Integer> CourseID = null;//课程名字
    private ArrayList<Integer> Class = null;//班级
    private ArrayList<Integer> Tea_ID = null;
    private int Class_Crs_Num[][]= null;
    private int Class_Crs_Num_L[][]= null;
    private int Class_Tea[][]= null;
    //学生信息数据结构
    private int Stu_Num = 0;
    private int Stu_ID[]= null;
    private int Stu_Class[][]= null;
    private int Stu_Course[];
    private int Stu_XK[][];
    //走一课数据结构
    private int CM = 0;
    //选考课数据结构
    private int XK_Class_Set[][]= null;
    private int XK_Tea_Set[][]= null;
    private int XK_Stu_Set[][]= null;
    private int XK[];
    private int XK_Sign[];
    private int XK_Num;
    private int XK_Set_cl[][];
    private int XK_srt_cl[][];
    private int Delta_XK[][];
    private int XK_f;
    private int XK_Type[] = null;
    private int XK_TargetCourse[][] = null;
    //单双周数据结构
    private int DSZ_Num = 0;
    private int DSZ[][]= null;
    private int DS = 0;
    //预排课数据结构
    int YPK_Num[]= null;
    int YPK[]= null;
    int XK_YPK[]= null;
    //课程检查数据结构
    private int Class_Rst[][];
    private int Tea_Rst[][];
    private int Class_Crs_Rst[][][];
    private int Tea_Crs_Rst[][][];
    private int Class_Weak[][][];
    private int Tea_Weak[][][];
    private long startTime = 0;
    private long endTime = 0;

    Collator co = Collator.getInstance(Locale.CHINA);
    Random rand = new Random();

    public QZBGraphcolor(){

    }

    public void setData(BasicDataInfo inputBasicData){
        int i, j, k;
        int class_id;
        int day;
        int tea_id;
        int crs_id;
        int target_crs_id;
        int m,l;
        int x,y;
        int courseTime = 0;
        int courseType = 0;
        Coursename = new ArrayList<String>();
        CourseID = new ArrayList<Integer>();
        Class = new ArrayList<Integer>();
        Tea_ID = new ArrayList<Integer>();


        Weak_Day = inputBasicData.getWeakDay();
        Day_Crs_Mr = inputBasicData.getDayCrsMr();
        Day_Crs_Af = inputBasicData.getDayCrsAf();
        Day_Crs = inputBasicData.getDayCrs();
        KCL = Weak_Day*Day_Crs;
        Class_Num = inputBasicData.getClassNum();
        List<Integer> classListInfo = inputBasicData.getClassID();
        for(i = 0;i<classListInfo.size();i++)
        {
            Class.add(classListInfo.get(i));
        }
        Crs_Num = inputBasicData.getCrsNum();
        List<CrsListInfo> crsListInfo = inputBasicData.getCrsListInfo();
        for(CrsListInfo crsInfo:crsListInfo)
        {
            CourseID.add(crsInfo.getCourseID());
            Coursename.add(crsInfo.getCourseName());
        }
        Tea_Num = inputBasicData.getTeaNum();
        List<Integer> teaListInfo = inputBasicData.getTeaID();
        for(i=0;i<teaListInfo.size();i++)
        {
            Tea_ID.add(teaListInfo.get(i));
        }
        for(i = 0;i<CourseID.size();i++){
            if(CourseID.get(i) > maxCourseID){
                maxCourseID = CourseID.get(i);
            }
        }
        XK_Num = inputBasicData.getXKNum();
        List<XKListInfo> xkListInfos = inputBasicData.getXkListInfo();
        for(XKListInfo xkListInfo:xkListInfos) {
            courseTime = xkListInfo.getXkTime();
            crs_id = Crs_Num + courseTime;
            CourseID.add(maxCourseID + courseTime);
            Coursename.add("走" + courseTime);
        }
        Crs_Num = Crs_Num + XK_Num;
        XK_TargetCourse = new int[Class_Num + 1][XK_Num + 1];

        /*System.out.print("Crs_Num =" + Crs_Num + "\n");
        for(i=0;i<Crs_Num;i++){
            System.out.print(CourseID.get(i) + " ");
        }
        System.out.print("\n");*/
        //System.out.print("Class_Num =" + Class_Num + "\n");
        //System.out.print("Tea_Num =" + Tea_Num + "\n");

        Class_Crs_Num = new int[Class_Num + 1][Crs_Num + 1];
        for (i = 0; i <= Class_Num; i++)
            for (j = 0; j <= Crs_Num; j++)
                Class_Crs_Num[i][j] = 0;

        Class_Crs_Num_L = new int[Class_Num + 1][Crs_Num + 1];
        for (i = 0; i <= Class_Num; i++)
            for (j = 0; j <= Crs_Num; j++)
                Class_Crs_Num_L[i][j] = 0;

        Class_Tea = new int[Class_Num + 1][Crs_Num + 1];
        for (i = 0; i <= Class_Num; i++)
            for (j = 0; j <= Crs_Num; j++)
                Class_Tea[i][j] = 0;
        Cct = new int[Crs_Num + 1];//优先排课
        for (i = 0; i <= Crs_Num; i++)
            Cct[i] = 0;
        Tct = new int[Tea_Num + 1];//教师集中排课
        for (i = 0; i <= Tea_Num; i++)
            Tct[i] = 1;
        Class_AvrT = new int [Class_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Tea_AvrT = new int [Tea_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Crs_AvrT = new int [Crs_Num + 1][Weak_Day + 1][Day_Crs + 1];
        XK_AvrT = new int[XK_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Tea_Course_Num = new int[Tea_Num + 1];
        ////////////////////////////////////////////////////////
        for (i = 0; i <= Class_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Class_AvrT[i][j][k] = 1;
            }
        }
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Tea_AvrT[i][j][k] = 1;
            }
        }
        for (i = 0; i <= Crs_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Crs_AvrT[i][j][k] = 1;
            }
        }
        for (i = 0; i <= XK_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    XK_AvrT[i][j][k] = 1;
            }
        }

        Ctwo = inputBasicData.getCtwo();
        if(Ctwo == 1)//触发优先排课
        {
            crs_id = 0;
            C_Time = inputBasicData.getCtwoTime();
            List<Integer> ctwoCrsList = inputBasicData.getCtwoCrs();
            for(i=0;i<ctwoCrsList.size();i++)
            {
                for(j=0;j<CourseID.size();j++)
                {
                    if(CourseID.get(j) - ctwoCrsList.get(i) == 0)
                    {
                        crs_id = j + 1;
                        break;
                    }
                }
                Cct[crs_id] = 1;
            }
        }

        List<ClassCrsInfo> classCrsInfo = inputBasicData.getClassCrsInfo();
        for(ClassCrsInfo classCrs:classCrsInfo)
        {
            class_id = 0;
            crs_id = 0;
            target_crs_id = 0;
            tea_id = 0;
            for(j=0;j<Class.size();j++)
            {
                if(Class.get(j) == classCrs.getClassID() )
                {
                    class_id = j + 1;//哪个班级
                    break;
                }
            }
            List<CourseInfo> courseInfo = classCrs.getCourseInfoList();
            for(CourseInfo course:courseInfo)
            {
                courseTime = course.getCourseTime();
                courseType = course.getCourseType();
                if(courseType == 0){
                    for(j=0;j<CourseID.size();j++)
                    {
                        if(CourseID.get(j) - course.getCourseID() == 0)
                        {
                            crs_id = j + 1;
                            break;
                        }
                    }
                }else if(courseType == 1){
                    for(j=0;j<CourseID.size();j++)
                    {
                        if(maxCourseID + courseTime - CourseID.get(j) == 0)
                        {
                            crs_id = j + 1;
                            break;
                        }
                    }
                    target_crs_id = course.getCourseID();
                    XK_TargetCourse[class_id][courseTime] = target_crs_id;
                }


                Class_Crs_Num[class_id][crs_id] = course.getCourseNum();//课时数
                //System.out.print(course.getCourseNum() + " ");
                Class_Crs_Num_L[class_id][crs_id] = course.getCourseLTNum();//连堂课时数
                if(course.getCourseTeaNum() == 0)
                {
                    Class_Tea[class_id][crs_id] = -1;//自习课
                }
                else if(course.getCourseTeaNum() == 1)
                {
                    for(x=0;x<Tea_ID.size();x++)
                    {
                        if(Tea_ID.get(x) - course.getCourseTeaID() == 0)
                        {
                            tea_id = x + 1;
                            break;
                        }
                    }
                    Class_Tea[class_id][crs_id] = tea_id;
                    //System.out.print(Class_Tea[class_id][j+1]);
                }
            }

        }

       /* for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Crs_Num; j++)//一门一门来
            {
                System.out.print(Class_Crs_Num[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for(i=1;i<=Class_Num;i++){
            for(j=1;j<=Crs_Num;j++){
                System.out.print(Class_Tea[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        //////////////////////////////////////////////////////////////

        Class_Crs_HEBAN = new int[Class_Num + 1][Crs_Num + 1];
        Class_Crs_CD = new int[Class_Num + 1][Crs_Num + 1];
        Tea_CP = new int [Tea_Num + 1][Class_Num + 1];//教师教了哪几个班？
        Tea_CP_Sign = new int [Tea_Num + 1][Class_Num + 1];//教师教了哪几个班？
        Class_Crs = new int [Class_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Tea_Crs = new int [Tea_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Stu_Crs = new int [10000 + 1][Weak_Day + 1][Day_Crs + 1];
        for (i = 0; i <= Class_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Class_Crs[i][j][k] = 0;
            }
        }
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Tea_Crs[i][j][k] = 0;
            }
        }
        for (i = 0; i <= 10000; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Stu_Crs[i][j][k] = 0;
            }
        }

        Class_Crs_Rst = new int [Class_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Tea_Crs_Rst = new int [Tea_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Class_Weak = new int [Class_Num*Crs_Num + 1][Weak_Day + 1][9 + 1];
        Tea_Weak = new int [Tea_Num + 1][Weak_Day + 1][5 + 1];

        m = Weak_Day*Day_Crs + 1;//着色数
        l = Class_Num*Crs_Num + 1;//节点数

        Class_Rst = new int [l + 1][30 + 1];
        for (i = 0; i <= l; i++)
        {
            for (j = 0; j <= 30; j++)
            {
                Class_Rst[i][j] = 0;
            }
        }
        Tea_Rst = new int [Tea_Num + 1][30 + 1];
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= 30; j++)
            {
                Tea_Rst[i][j] = 0;
            }
        }

        dgl = new int[m + 1];
        for (i = 1; i <= m; i++)
        {
            dgl[i] = 0;
        }
        PDay = new int[m + 1];
        PCr = new int[m + 1];
        All_cl = new int[m + 1];
        MCrs = new int[l];
        MCls = new int[l];
        Min_Day = new int[l];
        Max_Day = new int[l];
        Max_Mr = new int[l];
        Max_Af = new int[l];
        Crs_Attri = new int[l];
        LTK_Week = new int[l];
        Class_Score = new int[l];
        Tea_JP_Score = new int[Tea_Num + 1];
        Tea_Score = new int[Tea_Num + 1];
        TScr = new int[Day_Crs + 1];
        Tea_Scr = new int [Tea_Num + 1][Weak_Day + 1];
        //KM_Tea = new int[ l ];
        int t1, t2, t3;
        t1 = 1;
        for (t2 = 1; t2 <= Weak_Day; t2++)
            for (t3 = 1; t3 <= Day_Crs; t3++)
            {
                PDay[t1] = t2;
                PCr[t1] = t3;
                t1++;
            }
        Vtx_len = 1;
        for (i = 1; i <= Class_Num; i++)
            for (j = 1; j <= Crs_Num; j++)
                Vtx_len += Class_Crs_Num[i][j];

        YPK_Num = new int[l + 1];
        for (i = 0; i <= l; i++)
        {
            YPK_Num[i] = 0;
        }
        YPK = new int[Vtx_len + 1];
        for (i = 0; i <= Vtx_len; i++)
        {
            YPK[i] = 0;
        }
        AVB_Cl = new int[Vtx_len+1][m];

        Color = new int[Vtx_len + 1];
        Initial_Color = new int[Vtx_len + 1];
        Best_Color= new int[Vtx_len + 1];
        Final_Color = new int[Vtx_len + 1];
        Par = new int[Vtx_len];
        A_Matrix = new int[Vtx_len + 1][Vtx_len + 1];
        Synthesis_Node = new int[Vtx_len + 1];
        XK_Node = new int[Vtx_len + 1];

        Set_cl = new int [l + 1][m];
        Stu_cl = new int [l + 1][10000];
        Stu_Class_cl = new int [Class_Num + 1][10000];

        Set_Crs = new int[Class_Num + 1][Crs_Num + 1][m];

        Crs_srt_cl = new int [l + 1][m];

        Node_Tea = new int[Vtx_len + 1][Tea_Num + 1];//教师属性
        Node_Stu = new int[Vtx_len + 1][10000 + 1];//学生属性
        Node_Course = new int[Vtx_len + 1][2 + 1];//课程属性

        Node_Class = new int[Vtx_len + 1][Class_Num + 1];//班级属性
        Node_Avb = new int[Vtx_len + 1][m];

        Edge = new int[Vtx_len + 1][Vtx_len + 1];
        Node_Tea_Sign = new int[Vtx_len + 1];

        set = new int[30];

        JP_KC = new int [30+1][m+1];
        for (i = 0; i <= 30; i++)
        {
            for (j = 0; j <= m; j++)
            {
                JP_KC[i][j] = 0;
            }
        }

        daycr = new int[Weak_Day + 1];
        daylt = new int[Weak_Day + 1];

        tabuh = new int[1500];
        best_x = new int[1000];
        best_v = new int[1000];
        TTL = 2 * Class_Num;
        TabuTenure = new int[Vtx_len + 1][m + 1];
        Delta_Matrix = new int[Vtx_len + 1][m + 1];
        Delta_Crs = new int[Vtx_len + 1][m + 1];
        Delta_Tpj = new int[Vtx_len + 1][m + 1];
        Delta_Ttm = new int[Vtx_len + 1][m + 1];
        Delta_XK = new int[Vtx_len + 1][m + 1];
        /////////////////////////////////////////////////////////////
        //不排课时间
        List<NoClassTimeInfo> noClassTimeInfoList = inputBasicData.getNoClassTimeInfo();
        for(NoClassTimeInfo noClassTimeInfo:noClassTimeInfoList)
        {
            class_id = 0;
            crs_id = 0;
            tea_id = 0;
            if(co.compare(noClassTimeInfo.getType(),"Class") == 0)//班级不排课
            {
                for(j=0;j<Class.size();j++)
                {
                    if(Class.get(j) == noClassTimeInfo.getId() )
                    {
                        class_id = j + 1;//哪个班级
                        break;
                    }
                }
                List<TimeInfo> timeInfoList = noClassTimeInfo.getTimeInfo();
                for(TimeInfo timeInfo:timeInfoList)
                {
                    day = timeInfo.getDay();
                    List<Integer> avbTimeInfoList = timeInfo.getAvbTimeInfo();
                    for(k=0;k<avbTimeInfoList.size();k++)
                    {
                        Class_AvrT[class_id][day][k+1] = avbTimeInfoList.get(k);
                    }
                }

            }
            else if(co.compare(noClassTimeInfo.getType(),"Teacher") == 0)//教师不排课
            {
                for(j=0;j<Tea_ID.size();j++)
                {
                    if(Tea_ID.get(j) - noClassTimeInfo.getId() == 0)
                    {
                        tea_id = j + 1;//哪个教师
                        break;
                    }
                }
                Tct[tea_id] = noClassTimeInfo.getConcentrated();
                List<TimeInfo> timeInfoList = noClassTimeInfo.getTimeInfo();
                for(TimeInfo timeInfo:timeInfoList)
                {
                    day = timeInfo.getDay();
                    List<Integer> avbTimeInfoList = timeInfo.getAvbTimeInfo();
                    for(k=0;k<avbTimeInfoList.size();k++)
                    {
                        Tea_AvrT[tea_id][day][k+1] = avbTimeInfoList.get(k);
                    }
                }
            }
            else if(co.compare(noClassTimeInfo.getType(),"Course") == 0)
            {
                for(j=0;j<CourseID.size();j++)
                {
                    if(CourseID.get(j) == noClassTimeInfo.getId() )
                    {
                        crs_id = j + 1;//哪门课程
                        break;
                    }
                }
                List<TimeInfo> timeInfoList = noClassTimeInfo.getTimeInfo();
                for(TimeInfo timeInfo:timeInfoList)
                {
                    day = timeInfo.getDay();
                    List<Integer> avbTimeInfoList = timeInfo.getAvbTimeInfo();
                    for(k=0;k<avbTimeInfoList.size();k++)
                    {
                        Crs_AvrT[crs_id][day][k + 1] = avbTimeInfoList.get(k);
                    }
                }
            }
            else if(co.compare(noClassTimeInfo.getType(),"XK") == 0)
            {
                crs_id = Crs_Num + noClassTimeInfo.getId();//id == time
                List<TimeInfo> timeInfoList = noClassTimeInfo.getTimeInfo();
                for(TimeInfo timeInfo:timeInfoList)
                {
                    day = timeInfo.getDay();
                    List<Integer> avbTimeInfoList = timeInfo.getAvbTimeInfo();
                    for(k=0;k<avbTimeInfoList.size();k++)
                    {
                        Crs_AvrT[crs_id][day][k + 1] = avbTimeInfoList.get(k);
                    }
                }
            }
        }

        //合班课
        HBK_Num = inputBasicData.getHBKNum();
        HBK = new int[Class_Num * 2 + 1][Class_Num + 1];
        HBK_C = new int[Class_Num * 2 + 1];
        if(HBK_Num>0)
        {
            crs_id = 0;
            class_id = 0;
            List<HBKInfo> hbkInfoList = inputBasicData.getHbkInfo();
            i = 0;
            for(HBKInfo hbkInfo:hbkInfoList)
            {
                for(j=0;j<CourseID.size();j++)
                {
                    if(CourseID.get(j) - hbkInfo.getHbkcID() == 0 )
                    {
                        crs_id = j + 1;//哪门课程
                    }
                }
                i++;
                HBK_C[i] = crs_id;
                HBK[i][0] = hbkInfo.getHbkClassNum();
                List<Integer> hbkClassInfoList = hbkInfo.getHbkClassInfo();
                for(j=0;j<hbkClassInfoList.size();j++)
                {
                    for(k=0;k<Class.size();k++)
                    {
                        if(Class.get(k) - hbkClassInfoList.get(j) == 0)
                        {
                            class_id = k+1;//哪个班
                            break;
                        }
                    }
                    HBK[i][j+1] = class_id;
                }
            }
        }
        //预排课
        List<YPKInfo> ypkInfoList = inputBasicData.getYpkInfo();
        class_id = 0;
        for(YPKInfo ypkInfo:ypkInfoList)
        {
            for(j=0;j<Class.size();j++)
            {
                if(Class.get(j) == ypkInfo.getClassID())
                {
                    class_id = j + 1;//哪个班
                    break;
                }
            }
            List<YPKDataInfo> ypkDataInfoList = ypkInfo.getYpkDataInfo();
            for(YPKDataInfo ypkDataInfo:ypkDataInfoList)
            {
                day = ypkDataInfo.getDay();
                List<Integer> ypkDataList = ypkDataInfo.getYpkData();
                for(k=0;k<ypkDataList.size();k++)
                {
                    crs_id = 0;//初始化
                    for(x=0;x<CourseID.size();x++)
                    {
                        if (CourseID.get(x) - ypkDataList.get(k) == 0)
                        {
                            crs_id = x + 1;//哪门课
                            break;
                        }
                    }
                    Class_Crs[class_id][day][k + 1] = crs_id;
                }
            }
        }
        //选考课

        XK_Tea_Set = new int[XK_Num + 1][Tea_Num + 1];
        XK_Class_Set = new int[XK_Num + 1][Class_Num + 1];
        for (i = 0; i <= XK_Num; i++)
        {
            for (j = 0; j <= Class_Num; j++)
            {
                XK_Class_Set[i][j] = 0;
            }
        }
        XK_Stu_Set = new int[XK_Num + 1][Class_Num + 1];
        for (i = 0; i <= XK_Num; i++)
        {
            for (j = 0; j <= Class_Num; j++)
            {
                XK_Stu_Set[i][j] = 0;
            }
        }
        XK_Set_cl = new int[XK_Num + 1][10 + 1];
        for (i = 0; i <= XK_Num; i++)
        {
            for (j = 0; j <= 10; j++)
            {
                XK_Set_cl[i][j] = 0;
            }
        }
        XK_Sign = new int[XK_Num + 1];//选考的标记
        for (i = 0; i <= XK_Num; i++)
        {
            XK_Sign[i] = 1;
        }
        XK_Type = new int[XK_Num + 1];
        XK_srt_cl = new int [XK_Num + 1][m];
        Day_Set = new int[XK_Num + 1][Weak_Day + 1];
        Day = new int[Crs_Num + 1][Weak_Day + 1];
        XK = new int[Crs_Num + 1];//第几门课是第几节选考

        i = 0;
        crs_id = 0;
        for(XKListInfo xkListInfo:xkListInfos)
        {
            for(j=0;j<CourseID.size();j++)
            {
                if(maxCourseID + xkListInfo.getXkTime() - CourseID.get(j) == 0)
                {
                    crs_id = j + 1;
                    break;
                }
            }
            XK[crs_id] = i + 1;//1,2,3,4
            l = 0;
            List<Integer> xkClass = xkListInfo.getXkClass();
            for(j = 0;j<xkClass.size();j++)
            {
                for(k=0;k<Class.size();k++)
                {
                    if(xkClass.get(j) - Class.get(k) == 0)
                    {
                        class_id = k + 1;
                        break;
                    }
                }
                if (XK_Sign[XK[crs_id]] > 0)
                {
                    XK_Sign[XK[crs_id]]--;
                    Class_Crs_HEBAN[class_id][crs_id] = 50000;
                    l = ++XK_Class_Set[XK[crs_id]][0];
                    XK_Class_Set[XK[crs_id]][l] = class_id;
                    XK_Tea_Set[XK[crs_id]][l] = Class_Tea[class_id][crs_id];
                }
                else
                {
                    Class_Crs_Num[class_id][crs_id] = 0;
                    l = ++XK_Class_Set[XK[crs_id]][0];
                    XK_Class_Set[XK[crs_id]][l] = class_id;
                    XK_Tea_Set[XK[crs_id]][l] = Class_Tea[class_id][crs_id];
                }
            }
            XK_Tea_Set[XK[crs_id]][0] = l;
            i++;
        }


        /*for(i=1;i<=Crs_Num;i++)
        {
            System.out.print(XK[i] + "\n");
        }*/
        /*for(i=1;i<=XK_Num;i++)
        {

            for(j=1;j<=XK_Class_Set[i][0];j++){
                System.out.print( XK_Class_Set[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        //XK预排课，只有一个班级

        Stu_XK = new int[10000 + 1][Crs_Num + 1];
        for(i=0;i<=10000;i++)
        {
            for(j=0;j<=Crs_Num;j++)
            {
                Stu_XK[i][j] = 0;
            }
        }
        Stu_ID = new int[10000 + 1];
        Stu_Class = new int[10000 + 1][Crs_Num + 1];
        Stu_Num = 0;

        List<StuDataInfo> stuDataInfoList = inputBasicData.getStuDataInfoList();
        for(StuDataInfo stuDataInfo:stuDataInfoList)
        {
            Stu_ID[Stu_Num] = stuDataInfo.getStuID();
            //System.out.print(stuDataInfo.getStuClass() + "  ");
            for(j=0;j<Class.size();j++)
            {
                if(stuDataInfo.getStuClass() - Class.get(j) == 0)
                {
                    class_id = j + 1;
                    break;
                }
            }
            //System.out.print(class_id + " \n");
            for(j = 0;j<=Crs_Num;j++)
            {
                Stu_Class[Stu_Num][j] = 0;//初始化都没有课上
            }
            Stu_Class[Stu_Num][0] = class_id;//0位置存储班级
            //System.out.print(Stu_Class[Stu_Num][0] + " \n");
            List<StuCourseListInfo> stuCourseListInfos = stuDataInfo.getStuCourseListInfo();
            for(StuCourseListInfo stuCourseListInfo:stuCourseListInfos)
            {
                class_id = 0;
                crs_id = 0;
                target_crs_id = 0;
                courseTime = stuCourseListInfo.getStuCourseTime();
                courseType = stuCourseListInfo.getStuCourseType();
                for(k=0;k<Class.size();k++)
                {
                    if(stuCourseListInfo.getStuTargetClass() - Class.get(k) == 0)
                    {
                        class_id = k + 1;
                        break;
                    }
                }//目标班级
                for(k=0;k<CourseID.size();k++)
                {
                    if(stuCourseListInfo.getStuTargetCourse() - CourseID.get(k) == 0)
                    {
                        crs_id = k + 1;
                        break;
                    }
                }//目标课程
                /*if(crs_id == 0){
                    System.out.print(stuCourseListInfo.getStuTargetCourse() + "\n");
                }*/

                if(courseType == 0){
                    Stu_Class[Stu_Num][crs_id] = class_id;//这节课要去哪里上
                }else if(courseType == 1){
                    for(k=0;k<CourseID.size();k++)
                    {
                        if(maxCourseID + courseTime - CourseID.get(k) == 0)
                        {
                            target_crs_id = k + 1;
                            break;
                        }
                    }//目标课程
                    Stu_Class[Stu_Num][target_crs_id] = class_id;//这节课要去哪里上
                    Stu_Class[Stu_Num][crs_id] = class_id;//这节课要去哪里上
                    Stu_XK[Stu_Num][target_crs_id] = crs_id;//选考走班课
                }
            }
            Stu_Num++;
        }
        //System.out.print("StuNum =" + Stu_Num + "\n");
        /*for(i=0;i<Stu_Num;i++){
            System.out.print(Stu_Class[i][0] + "\n");
        }*/
    }


    private void check_kc() throws MyException {
        int i, j, l, m, n, ll, t;
        for (i = 1; i <= Class_Num; i++)
        {
            l = 0;
            for (j = 1; j <= Crs_Num; j++)
                l += Class_Crs_Num[i][j];
            ll = 0;
            for (j = 1; j <= KCL; j++)
            {
                m = PDay[j];
                n = PCr[j];
                ll += Class_AvrT[i][m][n];
                //System.out.print(Class_AvrT[i][m][n] + " ");
            }
            if (l > ll)
            {
                //System.out.print("班级 " + i + " 课程数量超标，请检查 l = " + l + " 可排课时间为"  + ll + "\n" );
                throw new MyException("班级 " + i + " 课程数量超标，请检查 l = " + l + " 可排课时间为"  + ll);
            }
        }

        for (t = 1; t <= Tea_Num; t++)
        {
            l = 0;
            for (i = 1; i <= Class_Num; i++)
                for (j = 1; j <= Crs_Num; j++)
                    if (Class_Tea[i][j] == t)
                        l += Class_Crs_Num[i][j];
            ll = 0;
            for (j = 1; j <= KCL; j++)
            {
                m = PDay[j];
                n = PCr[j];
                ll += Tea_AvrT[t][m][n];
            }
            //System.out.print("ll=" + ll + "\n");
            //System.out.print("l=" + l + "\n");
            if (l > ll)
            {
                //System.out.print("老师 " + Tea_Name.get(t-1) + "课程数量超标，请检查" + "\n");
                throw new MyException("老师 " + Tea_ID.get(t-1) + "课程数量超标，请检查l = " + l + " 可排课时间为"  + ll);
            }
        }
    }

    private void check_HBK() throws MyException {
        int i, j, l, m, n;
        for (i = 1; i <= HBK_Num; i++)
        {
            l = HBK[i][0];
            m = Class_Tea[HBK[i][1]][HBK_C[i]];
            for (j = 2; j <= l; j++)
            {
                n = Class_Tea[HBK[i][j]][HBK_C[i]];
                if (m != n)
                {
                    //System.out.print("存在合班课老师不一致的情况");
                    throw new MyException("存在合班课老师不一致的情况");
                }
            }
        }
    }

    private void set_HB(){
        int i, j, k, l, m, bn;
        //设置合班课
        for (bn = 1; bn <= HBK_Num; bn++)
        {
            m = HBK[bn][1];
            k = HBK_C[bn];
            l = HBK[bn][0];

            Class_Crs_HEBAN[m][k] = 100000 + bn;
            for (j = 2; j <= l; j++)
            {
                m = HBK[bn][j];
                Class_Crs_Num[m][k] = 0;
            }
        }

        /*System.out.print("合班信息" + "\n");
        for(i = 1;i<=Class_Num;i++){
            for(j = 1;j <= Crs_Num;j++){
                System.out.print(Class_Crs_HEBAN[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");*/
    }//设置合班课

    private void set_CD(){
        int i, j, l;
        l = 0;
        for (i = 1; i <= Class_Num; i++)
            for (j = 1; j <= Crs_Num; j++)
            {
                if (Class_Crs_Num[i][j]>0)//经过处理之后还需要排的课
                {
                    l++;
                    Class_Crs_CD[i][j] = l;
                    MCls[l] = i;//是哪个班
                    MCrs[l] = j;//是哪门课
                }
                else
                    Class_Crs_CD[i][j] = -1;
            }
        MNum = l;
    }

    private void set_Stu()
    {
        int i, j, k, l,m, N;
        int x, y;

        /*for(i=0;i<Stu_Num;i++) {
            for (j = 1; j <= Crs_Num; j++) {
                System.out.print(Stu_Class[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");*/

        /*for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Crs_Num; j++)//一门一门来
            {
                System.out.print(Class_Crs_Num[i][j] + " ");
            }
            System.out.print("\n");
        }*/

        //构造学生数据结构
        l = 1;
        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Crs_Num; j++)//一门一门来
            {
                if (Class_Crs_Num[i][j]>0)
                {
                    N = 0;
                    for (k = 0; k < Stu_Num; k++)
                    {
                        if (Stu_Class[k][j] == i)//该学生走班到这个班上这节课
                        {
                            m = 0;
                            for (x = 1; x <= N; x++)
                            {
                                if (Stu_cl[l][x] == Stu_ID[k])//上课学生有重复
                                {
                                    m = 1;
                                    break;
                                }
                                //如果没有重复
                            }
                            if (m == 0)
                            {
                                N++;
                                Stu_cl[l][N] = Stu_ID[k];
                            }
                        }
                    }
                    Stu_cl[l][0] = N;//第几门课有多少人
                    l++;
                }
            }
        }
        /*for(i=1;i<l;i++){
            System.out.print("第" + i + "门课：人数为" +  Stu_cl[i][0] + "分别是：");
            for(j=1;j<=Stu_cl[i][0];j++){
                System.out.print(Stu_cl[i][j] + " ");
            }
            System.out.print("\n");
        }*/

        for (i = 1; i <= Class_Num; i++)
        {
            N = 0;
            for (k = 0; k < Stu_Num; k++)
            {
                if (Stu_Class[k][0] == i)
                {
                    N++;
                    Stu_Class_cl[i][N] = Stu_ID[k];//不管是什么课，自己班的学生一定会去上，再考虑插班生
                }
            }
            Stu_Class_cl[i][0] = N;
        }
        /*for (i = 1; i <= Class_Num; i++)
        {
            for (k = 0; k <= Stu_Class_cl[i][0]; k++)
            {
                System.out.print(Stu_Class_cl[i][k] + " ");
            }
            System.out.print("\n");
        }*/

    }

    private void set_YPK(){
        int i, j, k, n;
        for (i = 1; i <= N_vtx; i++)
        {
            Initial_Color[i] = 0;
        }
        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++)
                {
                    if (Class_Crs[i][j][k] != 0)
                    {
                        //System.out.print("n=" + Class_Crs[i][j][k] + "\n");
                        n = Class_Crs[i][j][k];
                        YPK_Num[Class_Crs_CD[i][n]]++;
                        //System.out.print("Set_cl[Class_Crs_CD[i][n]=" + Set_cl[Class_Crs_CD[i][n]][YPK_Num[Class_Crs_CD[i][n]]] + "\n");
                        YPK[Set_cl[Class_Crs_CD[i][n]][YPK_Num[Class_Crs_CD[i][n]]]] = 1;//表示已经被预排
                        Initial_Color[Set_cl[Class_Crs_CD[i][n]][YPK_Num[Class_Crs_CD[i][n]]]] = (j - 1)*Day_Crs + k;
                        //System.out.print("Color=" + ((j - 1)*Day_Crs + k) + "\n");
                    }
                }
            }
        }

    }
    private void set_avbtime(){
        int i, j, k, m, n, gcls;
        int k1, k2, k3;

        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= KCL; j++)
            {
                k1 = k2 = k3 = 1;
                m = PDay[j];
                n = PCr[j];
                //班级不排课时间
                for (k = 1; k <= Node_Class[i][0]; k++)
                {
                    gcls = Node_Class[i][k];
                    k1 = k1&Class_AvrT[gcls][m][n];

                }
                //教师不排课时间
                for (k = 1; k <= Node_Tea[i][0]; k++)
                {
                    if (Node_Tea[i][k] >= 0)
                    {
                        k2 = k2&Tea_AvrT[Node_Tea[i][k]][m][n];
                    }
                    else if (Node_Tea[i][k] == -1)
                    {
                        k2 = 1;
                    }
                }
                //课程不排课时间
                for (k = 1; k <= Node_Course[i][0]; k++)
                {
                    k3 = k3&Crs_AvrT[Node_Course[i][k]][m][n];
                }
                k = k1&k2&k3;
                AVB_Cl[i][j] = k;
            }
        }
    }
    private void set_crs_attrib(){
        int l, gcls, gcr, nl, nt, min, max;
        l = 0;

        for (gcls = 1; gcls <= Class_Num; gcls++)
            for (gcr = 1; gcr <= Crs_Num; gcr++)
            {
                if (Class_Crs_Num[gcls][gcr]>0)
                {
                    l++;
                    nl = Class_Crs_Num[gcls][gcr];//总的课时数
                    nt = Class_Crs_Num_L[gcls][gcr];//连堂课
                    if (nt == 0)
                    {
                        max = (nl - 1) / Weak_Day + 1;
                        min = nl / Weak_Day;
                        Max_Day[l] = max;
                        Min_Day[l] = min;
                        if(nl>3)
                        {
                            Max_Mr[l] = Class_Crs_Num[gcls][gcr]-1;
                            Max_Af[l] = Class_Crs_Num[gcls][gcr]-1;
                        }
                        else
                        {
                            Max_Mr[l] = Class_Crs_Num[gcls][gcr];
                            Max_Af[l] = Class_Crs_Num[gcls][gcr];
                        }
                        LTK_Week[l] = 0;
                        Crs_Attri[l] = 0;
                        if ( co.compare(Coursename.get(gcr-1),"语文") == 0 || co.compare(Coursename.get(gcr-1),"数学") == 0 || co.compare(Coursename.get(gcr-1),"英语") == 0 )
                            Crs_Attri[l] = 1;//一等课
                        if ((nl == 2) && (Weak_Day >= 4))
                            Crs_Attri[l] = 2;//两天不能连排
                        else if ((nl == 3) && (Weak_Day > 4))
                            Crs_Attri[l] = 3;//三天不能连排
                    }
                    else
                    {
                        max = (nl - 2 * nt - 1) / (Weak_Day - nt) + 1;
                        min = (nl - 2 * nt) / (Weak_Day - nt);
                        Max_Day[l] = max;
                        Min_Day[l] = min;
                        if(nl>3)
                        {
                            Max_Mr[l] = Class_Crs_Num[gcls][gcr]-1;
                            Max_Af[l] = Class_Crs_Num[gcls][gcr]-1;
                        }
                        else
                        {
                            Max_Mr[l] = Class_Crs_Num[gcls][gcr];
                            Max_Af[l] = Class_Crs_Num[gcls][gcr];
                        }
                        LTK_Week[l] = nt;
                        Crs_Attri[l] = 0;
                        if (co.compare(Coursename.get(gcr-1),"语文") == 0 || co.compare(Coursename.get(gcr-1),"数学") == 0 || co.compare(Coursename.get(gcr-1),"英语") == 0)
                            Crs_Attri[l] = 1;
                        if ((nl - nt == 2) && (Weak_Day >= 4))
                            Crs_Attri[l] = 2;//两天不能连排
                        else if ((nl - nt == 3) && (Weak_Day > 4))
                            Crs_Attri[l] = 3;//三天不能连排
                    }
                }
            }
    }

    private int has_common_node(int t1, int t2){
        int i, j;
        for (i = 1; i <= Node_Class[t1][0]; i++)//班级冲突冲突
        {
            if (Node_Class[t1][i] == 0)
            {
                continue;
            }
            for (j = 1; j <= Node_Class[t2][0]; j++)
            {
                if (Node_Class[t2][j] == 0)
                {
                    continue;
                }
                if (Node_Class[t1][i] == Node_Class[t2][j])
                    return 1;
            }
        }

        for (i = 1; i <= Node_Stu[t1][0]; i++)//学生冲突
        {
            if (Node_Stu[t1][i] == 0)
            {
                continue;
            }
            for (j = 1; j <= Node_Stu[t2][0]; j++)
            {
                if (Node_Stu[t2][j] == 0)
                {
                    continue;
                }
                if (Node_Stu[t1][i] == Node_Stu[t2][j])
                    return 1;
            }
        }

        for (i = 1; i <= Node_Tea[t1][0]; i++)//学生冲突
        {
            if (Node_Tea[t1][i] == 0)
            {
                continue;
            }
            if (Node_Tea[t1][i] == -1)
                return 0;
            for (j = 1; j <= Node_Tea[t2][0]; j++)
            {
                if (Node_Tea[t2][j] == 0)
                    continue;
                if (Node_Tea[t2][j] == -1)
                    return 0;
                if (Node_Tea[t1][i] == Node_Tea[t2][j])
                    return 1;
            }
        }
        return 0;
    }


    private void con_struct_graph(){
        int i, j, k, l, m, n, t, th,x,y;
        int bn;
        int SN;
        l = 1;
        k = 1;
        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Crs_Num; j++)
                if (Class_Crs_Num[i][j]>0)
                {
                    Set_cl[k][0] = Class_Crs_Num[i][j];
                    for (t = 1; t <= Class_Crs_Num[i][j]; t++)
                    {
                        Set_cl[k][t] = l;
                        Par[l] = k;
                        l++;
                    }
                    k++;
                }
        }
        N_vtx = l - 1;
        //System.out.print("N_vtx=" + N_vtx + "\n");
        for (i = 1; i <= N_vtx; i++)
        {
            Node_Class[i][0] = 0;
            Node_Stu[i][0] = 0;
        }



        /*
        for (i = 1; i <= N_vtx; i++)
        {
            System.out.print( Node_Tea_Sign[i] + " " );
        }
        */
        //**************************************开始设置图着色属性
        l = 1;
        XK_Node_Num = 0;
        Synthesis_Node_Num = 0;//需要优先排的点
        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Crs_Num; j++)
                if (Class_Crs_Num[i][j]>0)
                {
                    for (t = 1; t <= Class_Crs_Num[i][j]; t++)
                    {
                        th = Class_Tea[i][j];//作为标记
                        if (Class_Crs_HEBAN[i][j] >= 100000)//触发排课
                        {
                            //cout << "合班课" << endl;
                            bn = Class_Crs_HEBAN[i][j] - 100000;
                            Node_Class[l][0] = HBK[bn][0];
                            for (k = 1; k <= HBK[bn][0]; k++)
                            {
                                Node_Class[l][k] = HBK[bn][k];
                            }
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea[l][0] = 1;
                            Node_Tea[l][1] = th;
                            Node_Tea_Sign[l] = th;
                            SN = 0;
                            for (x = 1; x <= Node_Class[l][0]; x++)
                            {
                                Node_Stu[l][0] += Stu_Class_cl[Node_Class[l][x]][0];
                                for (y = 1; y <= Stu_Class_cl[Node_Class[l][x]][0]; y++)
                                {
                                    SN++;
                                    Node_Stu[l][SN] = Stu_Class_cl[Node_Class[l][x]][y];
                                }
                            }
                        }
                        else if (Class_Crs_HEBAN[i][j] == 50000)//选考 ,没问题（目前有三个选考）
                        {
                            Node_Class[l][0] = XK_Class_Set[XK[j]][0];
                            for (k = 1; k <= XK_Class_Set[XK[j]][0]; k++)
                            {
                                Node_Class[l][k] = XK_Class_Set[XK[j]][k];
                            }
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea_Sign[l] = -2;
                            Node_Tea[l][0] = XK_Tea_Set[XK[j]][0];
                            for (k = 1; k <= XK_Tea_Set[XK[j]][0]; k++)
                            {
                                Node_Tea[l][k] = XK_Tea_Set[XK[j]][k];
                            }
                            XK_Node_Num++;
                            XK_Node[XK_Node_Num] = l;
                            XK_Set_cl[XK[j]][++XK_Set_cl[XK[j]][0]] = l;//是哪节课

                            SN = 0;
                            for (x = 1; x <= Node_Class[l][0]; x++)
                            {
                                Node_Stu[l][0] += Stu_Class_cl[Node_Class[l][x]][0];
                                for (y = 1; y <= Stu_Class_cl[Node_Class[l][x]][0]; y++)
                                {
                                    SN++;
                                    //System.out.print("SN=" + SN + "\n");
                                    Node_Stu[l][SN] = Stu_Class_cl[Node_Class[l][x]][y];
                                }
                            }
                        }
                        else if (th == -200)//单双周
                        {

                            Node_Class[l][0] = 1;
                            Node_Class[l][1] = i;
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea[l][0] = 2;
                            Node_Tea[l][1] = Class_Tea[i][DSZ[t][1]];
                            Node_Tea[l][2] = Class_Tea[i][DSZ[t][2]];
                            Node_Stu[l][0] = Stu_cl[Par[l]][0];
                            for (k = 1; k <= Stu_cl[Par[l]][0]; k++)
                            {
                                Node_Stu[l][k] = Stu_cl[Par[l]][k];
                            }

                        }
                        else//普通课 ，没问题
                        {
                            Node_Class[l][0] = 1;
                            Node_Class[l][1] = i;
                            //cout << "i=" << i << endl;
                            Node_Tea[l][0] = 1;
                            Node_Tea[l][1] = th;
                            Node_Tea_Sign[l] = th;
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Stu[l][0] = Stu_cl[Par[l]][0];
                            for (k = 1; k <= Stu_cl[Par[l]][0]; k++)
                            {
                                Node_Stu[l][k] = Stu_cl[Par[l]][k];
                            }
                            if (Stu_cl[Par[l]][0] > Stu_Class_cl[i][0])
                            {
                                Synthesis_Node_Num++;
                                Synthesis_Node[Synthesis_Node_Num] = l;
                            }
                        }
                        l++;
                    }
                }
        }
        /*System.out.print("一共" + (l - 1) + "节课" + "\n");
        //**************************输出看一下
        for(i=1;i<=N_vtx;i++)
        {
            System.out.print("Node_Class =" + " ");
            for(j=1;j<=Node_Class[i][0];j++)
            {
                System.out.print( Node_Class[i][j] + " ");
            }
            System.out.print("\n");
        }
        for(i=1;i<=N_vtx;i++)
        {
            System.out.print("Node_Course =" + " ");
            for(j=1;j<=Node_Course[i][0];j++)
            {
                System.out.print(Node_Course[i][j] + " ");
            }
            System.out.print("\n");
        }
        for(i=1;i<=N_vtx;i++)
        {
            System.out.print("Node_Tea=" + " ");
            for(j=1;j<=Node_Tea[i][0];j++)
            {
                System.out.print(Node_Tea[i][j] + " ");
            }
            System.out.print("\n");
        }
        for(i=1;i<=N_vtx;i++)
        {
            System.out.print("Node_Stu=" + " ");
            for(j=1;j<=Node_Stu[i][0];j++)
            {
                System.out.print(Node_Stu[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        ///////////////////////////////////////////////////////////////
        for (i = 1; i <= N_vtx; i++)
            for (j = 1; j <= N_vtx; j++)
            {
                Edge[i][j] = has_common_node(i, j);
            }

        for (i = 1; i <= N_vtx; i++)
            Edge[i][i] = 0;

        for (i = 1; i <= N_vtx; i++)
        {
            A_Matrix[i][0] = 0;
            for (j = 1; j <= N_vtx; j++)
            {
                if (Edge[i][j] == 1)
                {
                    A_Matrix[i][0]++;
                    A_Matrix[i][A_Matrix[i][0]] = j;
                }
            }
        }

        /*for( i = 1 ; i <= N_vtx; i++ )
        {
            for(j=0;j<=A_Matrix[ i ][ 0 ];j++)
            {
                System.out.print(A_Matrix[ i ][ j ] + " ");
            }
            System.out.print("\n");
        }*/


        /*
        Synthesis_Node_Num = 0;//需要优先排的点
        for (i = 1; i <= N_vtx; i++)
        {
            if (A_Matrix[i][0] > 3 * KCL)
            {
                Synthesis_Node_Num++;
                Synthesis_Node[Synthesis_Node_Num] = i;
            }

        }
        */

        for (i = 1; i <= Synthesis_Node_Num; i++)
        {
            System.out.print("需要优先排的点为 = " + Synthesis_Node[i] + "\n");
        }

        //*************************************************教师教了哪几门课
        for (i = 0; i <= Tea_Num; i++)
            Tea_CP[i][0] = 0;
        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= Node_Tea[i][0]; j++)
            {
                if (Node_Tea[i][j] > 0 && Class_Crs_Num[MCls[Par[i]]][MCrs[Par[i]]] > 1)//教师不为0//单双周的其实是不计的
                {
                    l = 1;
                    for (k = 1; k <= Tea_CP[Node_Tea[i][j]][0]; k++)
                    {
                        if (Tea_CP[Node_Tea[i][j]][k] == Par[i])
                        {
                            l = 0;
                            break;
                        }
                    }
                    if (l == 1)
                    {
                        t = ++Tea_CP[Node_Tea[i][j]][0];
                        Tea_CP[Node_Tea[i][j]][t] = Par[i];
                    }

                }
            }
        }

       /* for (i = 1; i <= Tea_Num; i++)
        {
            for (j = 1; j <= Tea_CP[i][0]; j++)
                System.out.print("教师 " + i + " 教了" + MCrs[Tea_CP[i][j]] + "课");
            System.out.print("\n");
        }*/

        //************************************************教师教了几门课标记
        l = 1;
        for (i = 0; i <= Tea_Num; i++)
            Tea_CP_Sign[i][0] = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            Tea_CP_Sign[i][1] = 1;
            Tea_CP_Sign[i][0]++;
            for (j = 2; j <= Tea_CP[i][0]; j++)
            {

                for (k = 1; k < j; k++)
                {
                    l = 0;
                    if (MCrs[Tea_CP[i][j]] == MCrs[Tea_CP[i][k]] && Class_Crs_Num[MCls[Tea_CP[i][k]]][MCrs[Tea_CP[i][k]]] == Class_Crs_Num[MCls[Tea_CP[i][j]]][MCrs[Tea_CP[i][j]]])
                    {
                        Tea_CP_Sign[i][j] = Tea_CP_Sign[i][k];
                        l = 1;
                        break;
                    }
                }
                if (l == 0)
                {
                    Tea_CP_Sign[i][0]++;
                    Tea_CP_Sign[i][j] = Tea_CP_Sign[i][0];
                }
            }
            if (Tea_CP[i][0] == 0)
            {
                Tea_CP_Sign[i][0] = 0;
            }
        }

        /*for (i = 1; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Tea_CP[i][0]; j++)
                System.out.print(Tea_CP_Sign[i][j]+" ");
            System.out.print("\n");
        }*/

        //Set_crs
        for (i = 0; i <= Class_Num; i++)
        {
            for (j = 0; j <= Crs_Num; j++)
            {
                Set_Crs[i][j][0] = 0;
            }
        }

        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Crs_Num; j++)
            {
                l = 1;
                for (x = 1; x <= N_vtx; x++)
                {
                    for (y = 1; y <= Node_Course[x][0]; y++)
                    {
                        if (Node_Course[x][y] == j && Node_Class[x][1] == i )
                        {
                            Set_Crs[i][j][l] = x;
                            l++;
                        }
                    }
                }
                Set_Crs[i][j][0] = l - 1;
            }
        }

        /*for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Crs_Num; j++) {
                for (k = 0; k <= Set_Crs[i][j][0]; k++) {
                    System.out.print(Set_Crs[i][j][k] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }*/

    }

    private void ini_tabu(){
        int i, j, l, l1;
        int[] al = { 1, 2, 1, 4, 1, 2, 1, 8, 1, 2, 1, 4, 1, 2, 1 };
        l1 = l = 0;
        for (i = 0; i < 15; i++)
        {
            l = l1 + 100;
            for (j = l1; j < l; j++)
                tabuh[j] = al[i] * TTL;
            l1 = l;
        }
    }

    private int Get_Initial_solution(int search_depth) throws MyException {
        int i;
        int num_best;
        int x, v;
        int iter;
        int best_delta, delt;
        int old_color;//移动前着色类
        int select;//随机选择方案
        //int num;//可大致认为是邻域总数
        //System.out.print("inial_f2 = " + f + "\n");
        greed_ini_solution();
        f_best = f;//f_best为当前的惩罚计数
        for (i = 1; i <= N_vtx; i++)
            Best_Color[i] = Color[i];



        for (i = 1; i <= N_vtx; i++)
            Best_Color[i] = Color[i];
        for (iter = 1; iter <= search_depth; iter++)
        {
            best_delta = 9999999;
            num_best = 0;
            for (x = 1; x <= N_vtx; x++)//每一个点
            {
                if (Node_Tea_Sign[x] != -2  && YPK[x] == 0)
                    if (Delta_Matrix[x][Color[x]] > 0) //
                    {
                        for (v = 1; v <= KCL; v++)
                            if ((AVB_Cl[x][v] == 1) && (v != Color[x]) && (TabuTenure[x][v] <= iter))
                            {
                                delt = Delta_Matrix[x][v] - Delta_Matrix[x][Color[x]];
                                if (delt < best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = v;
                                    num_best = 1;
                                    best_delta = delt;
                                }
                                else if (delt == best_delta)
                                {
                                    if (num_best < 1000)
                                    {
                                        best_x[num_best] = x;
                                        best_v[num_best] = v;
                                        num_best++;
                                    }
                                }
                            }
                    }
            }
            if (num_best == 0){
                //System.out.print("num_best = " + num_best + "\n");
                return f_best;
            }


            select = rand.nextInt(num_best);
            if (best_v[select] > 0)
            {
                old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
                f += Delta_Matrix[best_x[select]][best_v[select]] - Delta_Matrix[best_x[select]][old_color];
                One_Move_Update_Delta_Matrix(best_x[select], old_color, best_v[select]);//更新增量矩阵
                Color[best_x[select]] = best_v[select];//更新着色类方案
                TabuTenure[best_x[select]][old_color] = 15 + iter;
            }

            if (f < f_best) //f improved ,update f_best and colour
            {
                f_best = f;//更新当前最优惩罚值
                for (i = 1; i <= N_vtx; i++)
                    Best_Color[i] = Color[i];
            }

            if (f == 0)
            {
                System.out.print("A feasible solution is found f == 0" + "\n");
                return 0;
            }
        }
        System.out.print("The solution is not feasible f == " + f + "\n");
        return f;
    }//搜索初始解

    private int Compoud_Tabu_Search_JP(int search_depth){
        int i, j, m, len, tl,l;
        int num_best;
        int x, y, v;
        int iter;
        int best_delta, delt;
        int v_best_delta, v_delt;
        int old_color, old_color_x, old_color_y;//移动前着色类
        int select;//随机选择方案
        int num;//可大致认为是邻域总数
        copy_ini_solution();
        f_best = f;//f_best为当前的惩罚计数

        f_crs = 0;
        //初始班级课表优劣
        for (i = 1; i <= MNum; i++)
        {
            m = Set_cl[i][1];//是哪一节课
            Class_Score[i] = Cal_Class_Score(m, Color[m]);
            f_crs += Class_Score[i];
        }
        //教师课表优劣

        Sort_Src();
        for (i = 1; i <= Tea_Num; i++)
            Tea_JP_Score[i] = 0;
        for (i = 1; i <= MNum; i++)
        {
            m = Set_cl[i][1];//是哪一节课
            for (j = 1; j <= Node_Tea[m][0]; j++)
            {
                if (Node_Tea[m][j] > 0)
                {
                    Tea_JP_Score[Node_Tea[m][j]] = Cal_JP_Score(m, Color[m], Node_Tea[m][j]);//哪位老师
                }
            }
        }

        f_tea = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            f_tea = f_tea + Tea_JP_Score[i];
        }

        fc = f_crs+ f_tea;
        fc_best = fc;
        System.out.print("f=" + f + " fc=" + fc + "\n");
        if ((f == 0) && (fc == 0))
        {
            System.out.print("finis f == 0 and fc == 0 and ftea == 0" + "\n");
            return 1;
        }
        System.out.print("In begin of Compoud_Tabu_Search_JP f = " + f + " fc = " + fc + "\n");
        Ini_Delta_Crs();
        Ini_Delta_Tpj();
        //当前最优解为当前解
        for (i = 1; i <= N_vtx; i++)
            Best_Color[i] = Color[i];
        for (iter = 1; iter <= search_depth; iter++)
        {
            num = 0;
            best_delta = 9999999;
            v_best_delta = 9999999;
            num_best = 0;
            for (x = 1; x <= N_vtx; x++)
            {

                l = 0;
                for (i = 1; i <= Node_Tea[x][0]; i++)
                {
                    if ((Node_Tea[x][i] > 0) && (Tea_JP_Score[Node_Tea[x][i]] > 0))
                    {
                        l = 1;
                    }
                }////教师是否>0

                if ((Delta_Matrix[x][Color[x]])>0 || (Class_Score[Par[x]])>0 || l == 1 )
                {
                    if (Node_Tea_Sign[x] != -2 && YPK[x] == 0)
                    {
                        for (v = 1; v <= KCL; v++)
                            if ((AVB_Cl[x][v] == 1) && (v != Color[x]) && (TabuTenure[x][v] <= iter))
                            {
                                delt = Delta_Matrix[x][v] - Delta_Matrix[x][Color[x]];
                                if (delt < best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = v;
                                    best_delta = delt;
                                    v_best_delta = Delta_Crs[x][v] + Delta_Tpj[x][v];// +3 * (PCr[v] - PCr[Color[x]]);
                                    num_best = 1;
                                }
                                else if (delt == best_delta)  //if some flips have the same delta,then choose at most 50 and record them   && num_best < 50
                                {
                                    v_delt = Delta_Crs[x][v] + Delta_Tpj[x][v];// +3 * (PCr[v] - PCr[Color[x]]);
                                    if (v_delt < v_best_delta)
                                    {
                                        best_x[0] = x;
                                        best_v[0] = v;
                                        best_delta = delt;
                                        v_best_delta = v_delt;
                                        num_best = 1;
                                    }
                                    else if ((v_delt == v_best_delta) && (num_best < 1000))
                                    {
                                        best_x[num_best] = x;
                                        best_v[num_best] = v;
                                        num_best++;
                                    }
                                }
                            }
                    }
                }
            }

            for (x = 1; x <= N_vtx; x++)
            {

                l = 0;
                for (i = 1; i <= Node_Tea[x][0]; i++)
                {
                    if ((Node_Tea[x][i] > 0) && (Tea_JP_Score[Node_Tea[x][i]] > 0))
                    {
                        l = 1;
                    }
                }////教师是否>0

                if ((Delta_Matrix[x][Color[x]])>0 || (Class_Score[Par[x]])>0 || l == 1)
                {
                    for (y = 1; y <= N_vtx; y++)
                        if ((MCls[Par[x]] == MCls[Par[y]]) && (AVB_Cl[x][Color[y]] == 1) && (AVB_Cl[y][Color[x]] == 1) && (Par[x] != Par[y]) && (Color[y] != Color[x]) && (TabuTenure[x][Color[y]] <= iter) && (TabuTenure[y][Color[x]] <= iter))
                        {
                            if ((Node_Tea_Sign[x] != -2) && (Node_Tea_Sign[y] != -2) && YPK[x] == 0 && YPK[y] == 0)
                            {
                                delt = Delta_Matrix[x][Color[y]] - Delta_Matrix[x][Color[x]] + Delta_Matrix[y][Color[x]] - Delta_Matrix[y][Color[y]] - 2;
                                if (delt < best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = -y;
                                    best_delta = delt;
                                    v_best_delta = Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]];
                                    num_best = 1;
                                }
                                else if (delt == best_delta)  //if some flips have the same delta,then choose at most 50 and record them   && num_best < 50
                                {
                                    v_delt = Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]];
                                    if (v_delt < v_best_delta)
                                    {
                                        best_x[0] = x;
                                        best_v[0] = -y;
                                        best_delta = delt;
                                        v_best_delta = v_delt;
                                        num_best = 1;
                                    }
                                    else if ((v_delt == v_best_delta) && (num_best < 1000))
                                    {
                                        best_x[num_best] = x;
                                        best_v[num_best] = -y;
                                        num_best++;
                                    }
                                }
                            }
                        }
                }
            }

            if (num_best > 0)
                select = rand.nextInt(num_best);   //从备选方案中随机选择一个方案
            else
                return fc_best;

            if (best_v[select] > 0)
            {
                old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
                f += Delta_Matrix[best_x[select]][best_v[select]] - Delta_Matrix[best_x[select]][old_color];
                fc += Delta_Crs[best_x[select]][best_v[select]] +Delta_Tpj[best_x[select]][best_v[select]];

                One_Move_Update_Delta_Matrix(best_x[select], old_color, best_v[select]);//更新增量矩阵
                One_Move_Update_Course(best_x[select], old_color, best_v[select]);
                Color[best_x[select]] = best_v[select];//更新着色类方案
                One_Move_Update_JP(best_x[select]);
                tl = iter % 1500;
                TabuTenure[best_x[select]][Color[best_x[select]]] = tabuh[tl] + iter;
                Update_Delta_Crs(best_x[select]);
                Update_Delta_Tpj(best_x[select]);
            }
            else
            {
                x = best_x[select];
                y = -best_v[select];

                f += Delta_Matrix[x][Color[y]] - Delta_Matrix[x][Color[x]] + Delta_Matrix[y][Color[x]] - Delta_Matrix[y][Color[y]] - 2 * Edge[x][y];
                fc += Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]];

                old_color_x = Color[x];  //存储顶点移动之前的着色类
                old_color_y = Color[y];
                One_Move_Update_Delta_Matrix(x, old_color_x, old_color_y);//更新增量矩阵
                One_Move_Update_Course(x, old_color_x, old_color_y);
                Color[x] = old_color_y;//更新着色类方案
                One_Move_Update_JP(x);
                tl = iter % 1500;
                TabuTenure[x][Color[x]] = tabuh[tl] + iter;

                One_Move_Update_Delta_Matrix(y, old_color_y, old_color_x);//更新增量矩阵
                One_Move_Update_Course(y, old_color_y, old_color_x);
                Color[y] = old_color_x;//更新着色类方案
                One_Move_Update_JP(y);
                TabuTenure[y][Color[y]] = tabuh[tl] + iter;

                Update_Delta_Crs(x);//没问题
                Update_Delta_Tpj(x);
                Update_Delta_Crs(y);
                Update_Delta_Tpj(y);

            }
            if (iter % 1000 == 0)
                reset_tabu_tenure();

            if (f < f_best) //f improved ,update f_best and colour
            {
                f_best = f;//更新当前最优惩罚值
                fc_best = fc;
                for (i = 1; i <= N_vtx; i++)
                    Best_Color[i] = Color[i];

            }
            else if ((f <= f_best) && (fc < fc_best))
            {
                fc_best = fc;
                for (i = 1; i <= N_vtx; i++)
                    Best_Color[i] = Color[i];
            }

            if ((f == 0) && (fc == 0))
            {
                System.out.print("finis f == 0 and fc == 0" + "\n");
                return 0;
            }
        }
        System.out.print("Here f = " + f + " fc_best = " + fc_best + " fc = " + fc + "\n");
        if (f_best == 0)
            return fc_best;
        else
            return 9999999;
    }//深度搜索
    private int Compoud_Tabu_Search_BTH(int search_depth){
        int i, j, m, len, tl, l;
        int num_best;
        int x, y, v;
        int iter;
        int best_delta, delt;
        int v_best_delta, v_delt;
        int old_color, old_color_x, old_color_y;//移动前着色类
        int select;//随机选择方案
        int num;//可大致认为是邻域总数
        copy_ini_solution();
        f_best = f;//f_best为当前的惩罚计数

        f_crs = 0;
        //初始班级课表优劣
        for (i = 1; i <= MNum; i++)
        {
            m = Set_cl[i][1];//是哪一节课
            Class_Score[i] = Cal_Class_Score(m, Color[m]);
            f_crs += Class_Score[i];
        }
        //教师课表优劣
        System.out.print("f_crs=" + f_crs + "\n");
        Sort_Src();
        for (i = 1; i <= Tea_Num; i++)
            Tea_JP_Score[i] = 0;
        for (i = 1; i <= MNum; i++)
        {
            m = Set_cl[i][1];//是哪一节课
            for (j = 1; j <= Node_Tea[m][0]; j++)
            {
                if (Node_Tea[m][j] > 0)
                {
                    Tea_JP_Score[Node_Tea[m][j]] = Cal_JP_Score(m, Color[m], Node_Tea[m][j]);//哪位老师
                }
            }
        }
        f_tea = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            f_tea = f_tea + Tea_JP_Score[i];
        }
        System.out.print("f_tea1=" + f_tea + "\n");
        set_tea_Src();//计算课程集中程度
        f_tea = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            f_tea = f_tea + Tea_Score[i];
        }
        System.out.print("f_tea2=" + f_tea + "\n");
        fc = f_crs + f_tea;
        fc_best = fc;
        System.out.print("f=" + f + " fc=" + fc + "\n");
        if ((f == 0) && (fc == 0))
        {
            System.out.print("finis f == 0 and fc == 0 and ftea == 0" + "\n");
            return 1;
        }
        System.out.print("In begin of Compoud_Tabu_Search_BTH f = " + f + " fc = " + fc + "\n");

        Ini_Delta_Crs();//课程集中程度
        Ini_Delta_Ttm();//教师课程集中程度
        Ini_Delta_Tpj();//教案平齐

        //当前最优解为当前解
        for (i = 1; i <= N_vtx; i++)
            Best_Color[i] = Color[i];
        for (iter = 1; iter <= search_depth; iter++)
        {
            num = 0;
            best_delta = 9999999;
            v_best_delta = 9999999;
            num_best = 0;

            for (x = 1; x <= N_vtx; x++)
            {
                l = 0;
                for (i = 1; i <= Node_Tea[x][0]; i++)
                {
                    if ((Node_Tea[x][i] > 0) && (Tea_Score[Node_Tea[x][i]] > 0))
                    {
                        l = 1;
                    }
                }////教师是否>0
                if ((Delta_Matrix[x][Color[x]])>0 || (Class_Score[Par[x]])>0 || l == 1)
                {
                    if (Node_Tea_Sign[x] != -2 && YPK[x] == 0)
                    {
                        for (v = 1; v <= KCL; v++)
                            if ((AVB_Cl[x][v] == 1) && (v != Color[x]) && (TabuTenure[x][v] <= iter))
                            {
                                delt = Delta_Matrix[x][v] - Delta_Matrix[x][Color[x]];
                                //cout << "inner_iter = " << iter << endl;
                                if (delt < best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = v;
                                    best_delta = delt;
                                    v_best_delta = Delta_Crs[x][v] + Delta_Tpj[x][v] + Delta_Ttm[x][v]; //+ 3 * (PCr[v] - PCr[Color[x]]);

                                    num_best = 1;
                                }
                                else if (delt == best_delta)  //if some flips have the same delta,then choose at most 50 and record them   && num_best < 50
                                {
                                    v_delt = Delta_Crs[x][v] + Delta_Tpj[x][v] + Delta_Ttm[x][v];// +3 * (PCr[v] - PCr[Color[x]]);
                                    if (v_delt < v_best_delta)
                                    {
                                        best_x[0] = x;
                                        best_v[0] = v;
                                        best_delta = delt;
                                        v_best_delta = v_delt;
                                        num_best = 1;
                                    }
                                    else if ((v_delt == v_best_delta) && (num_best < 1000))
                                    {
                                        best_x[num_best] = x;
                                        best_v[num_best] = v;
                                        num_best++;
                                    }
                                }
                            }
                    }
                }
            }


            for (x = 1; x <= N_vtx; x++)
            {
                l = 0;
                for (i = 1; i <= Node_Tea[x][0]; i++)
                {
                    if ((Node_Tea[x][i] > 0) && (Tea_Score[Node_Tea[x][i]] > 0))
                    {
                        l = 1;
                    }
                }////教师是否>0
                if ((Delta_Matrix[x][Color[x]])>0 || (Class_Score[Par[x]])>0 || l == 1)
                {
                    for (y = 1; y <= N_vtx; y++)
                        if ((MCls[Par[x]] == MCls[Par[y]]) && (AVB_Cl[x][Color[y]] == 1) && (AVB_Cl[y][Color[x]] == 1) && (Par[x] != Par[y]) && (Color[y] != Color[x]) && (TabuTenure[x][Color[y]] <= iter) && (TabuTenure[y][Color[x]] <= iter))
                        {
                            if ((Node_Tea_Sign[x] != -2) && (Node_Tea_Sign[y] != -2) && YPK[x] == 0 && YPK[y] == 0)
                            {
                                delt = Delta_Matrix[x][Color[y]] - Delta_Matrix[x][Color[x]] + Delta_Matrix[y][Color[x]] - Delta_Matrix[y][Color[y]] - 2;
                                if (delt < best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = -y;
                                    best_delta = delt;
                                    if (Node_Tea_Sign[x] == Node_Tea_Sign[y])//有问题要改
                                        v_best_delta = Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]];
                                    else
                                        v_best_delta = Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]] + Delta_Ttm[x][Color[y]] + Delta_Ttm[y][Color[x]];
                                    num_best = 1;
                                }
                                else if (delt == best_delta)  //if some flips have the same delta,then choose at most 50 and record them   && num_best < 50
                                {
                                    if (Node_Tea_Sign[x] == Node_Tea_Sign[y])
                                        v_delt = Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]];
                                    else
                                        v_delt = Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]] + Delta_Ttm[x][Color[y]] + Delta_Ttm[y][Color[x]];
                                    if (v_delt < v_best_delta)
                                    {
                                        best_x[0] = x;
                                        best_v[0] = -y;
                                        best_delta = delt;
                                        v_best_delta = v_delt;
                                        num_best = 1;
                                    }
                                    else if ((v_delt == v_best_delta) && (num_best < 1000))
                                    {
                                        best_x[num_best] = x;
                                        best_v[num_best] = -y;
                                        num_best++;
                                    }
                                }
                            }
                        }
                }
            }

            if (num_best > 0)
                select = rand.nextInt(num_best);   //从备选方案中随机选择一个方案
            else
                return fc_best;

            if (best_v[select] > 0)
            {
                old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
                f += Delta_Matrix[best_x[select]][best_v[select]] - Delta_Matrix[best_x[select]][old_color];
                fc += Delta_Crs[best_x[select]][best_v[select]];
                One_Move_Update_Delta_Matrix(best_x[select], old_color, best_v[select]);//更新增量矩阵
                One_Move_Update_Course(best_x[select], old_color, best_v[select]);
                Color[best_x[select]] = best_v[select];//更新着色类方案
                One_Move_Update_JP(best_x[select]);

                tl = iter % 1500;
                TabuTenure[best_x[select]][Color[best_x[select]]] = tabuh[tl] + iter;
                m = Update_Tea_Src(best_x[select], best_x[select]);
                fc += m - f_tea;
                f_tea = m;

                Update_Delta_Crs(best_x[select]);
                Update_Delta_Ttm(best_x[select]);
                Update_Delta_Tpj(best_x[select]);
            }
            else
            {
                x = best_x[select];
                y = -best_v[select];

                f += Delta_Matrix[x][Color[y]] - Delta_Matrix[x][Color[x]] + Delta_Matrix[y][Color[x]] - Delta_Matrix[y][Color[y]] - 2 * Edge[x][y];
                fc += Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]];// + cal_value_swap_tea(x,y);

                old_color_x = Color[x];  //存储顶点移动之前的着色类
                old_color_y = Color[y];
                One_Move_Update_Delta_Matrix(x, old_color_x, old_color_y);//更新增量矩阵
                One_Move_Update_Course(x, old_color_x, old_color_y);
                Color[x] = old_color_y;//更新着色类方案
                One_Move_Update_JP(x);

                tl = iter % 1500;
                TabuTenure[x][Color[x]] = tabuh[tl] + iter;

                One_Move_Update_Delta_Matrix(y, old_color_y, old_color_x);//更新增量矩阵
                One_Move_Update_Course(y, old_color_y, old_color_x);
                Color[y] = old_color_x;//更新着色类方案
                One_Move_Update_JP(y);

                TabuTenure[y][Color[y]] = tabuh[tl] + iter;
                m = Update_Tea_Src(x, y);
                fc += m - f_tea;
                f_tea = m;

                Update_Delta_Crs(x);
                Update_Delta_Ttm(x);
                Update_Delta_Tpj(x);
                Update_Delta_Crs(y);
                Update_Delta_Ttm(y);
                Update_Delta_Tpj(y);
            }

            if (iter % 1000 == 0)
                reset_tabu_tenure();

            if (f < f_best) //f improved ,update f_best and colour
            {
                f_best = f;//更新当前最优惩罚值
                fc_best = fc;
                for (i = 1; i <= N_vtx; i++)
                    Best_Color[i] = Color[i];

            }
            else if ((f <= f_best) && (fc < fc_best))
            {
                fc_best = fc;
                for (i = 1; i <= N_vtx; i++)
                    Best_Color[i] = Color[i];
            }

            if ((f == 0) && (fc == 0))
            {
                System.out.print("finis f == 0 and fc == 0" + "\n");
                return 0;
            }
        }
        System.out.print("f = " + f + " fc_best = " + fc_best + " fc = " + fc + "\n");
        if (f_best == 0)
            return fc_best;
        else
            return 9999999;
    }//第二次深度搜索

    private int Cal_Class_Score(int ndi, int knew){
        int pnd = Par[ndi];//属于哪一门课
        int kold = Color[ndi];
        int Class = MCls[pnd];
        int len;
        int f1 = 0;
        int maxk = Weak_Day / 2;//3天
        if (maxk < 3)
            maxk = 3;
        int i, j, k, l, len_lt, max, min;
        int x, y;
        int crsMr = 0;
        int crsAf = 0;
        int c_Num = Node_Course[ndi][0];//这节课的课程属性
        for (x = 1; x <= c_Num; x++)
        {
            //可以进行改进
            len = Set_Crs[MCls[pnd]][Node_Course[ndi][x]][0];//同一个班的同一门课程有哪些课
            for (i = 1; i <= Set_Crs[ MCls[pnd] ][ Node_Course[ndi][x] ][0]; i++)//这些课在哪个时间点
            {
                if (Set_Crs[MCls[pnd]][Node_Course[ndi][x]][i] != ndi)
                    set[i] = Color[ Set_Crs[ MCls[pnd] ][ Node_Course[ndi][x] ][i] ];
                else
                    set[i] = knew;
            }
            int flag = 0;
            int dayZ = 0;
            int  m_c = Weak_Day*Day_Crs;//35天=KCL
            for (i = 1; i <= Weak_Day; i++)
            {
                daycr[i] = 0;//课时
                daylt[i] = 0;//连堂课
            }

            for (i = 1; i <= len; i++)
                daycr[PDay[set[i]]]++;//每天上几节

            for (i = 1; i <= len; i++)
            {
                if(PCr[set[i]] >= Day_Crs_Mr)
                {
                    crsMr++;//上午的课时数增加
                }
                else
                {
                    crsAf++;//下午的课时数增加
                }
            }

            int gcls = MCls[pnd];
            int gcr = MCrs[pnd];

            if (Class_Crs_Num_L[gcls][gcr] > 0)//如果存在连堂课
            {
                for (i = 1; i <= m_c; i++)
                    All_cl[i] = 0;
                for (i = 1; i <= len; i++)
                    All_cl[set[i]] = 1;
                len_lt = 0;
                for (i = 1; i < m_c; i++)
                    if ((All_cl[i] == 1) && (All_cl[i + 1] == 1) && (PCr[i] != Day_Crs) && (PCr[i] != Day_Crs_Mr))
                    {
                        len_lt++;//连堂课数量+1
                        dayZ = PDay[i];//属于哪一天
                        daylt[dayZ]++;//这一天的连堂课数量+1
                        i++;
                    }
                if (len_lt < Class_Crs_Num_L[gcls][gcr])
                    f1 += 50 * (Class_Crs_Num_L[gcls][gcr] - len_lt);

                if (len_lt > Class_Crs_Num_L[gcls][gcr])//不能多也不能少
                    f1 += 50 * (len_lt - Class_Crs_Num_L[gcls][gcr]);
                max = -9999;
                min = 9999;
                for (i = 1; i <= Weak_Day; i++)
                {
                    if (daycr[i] > max)//一天最多上几节
                        max = daycr[i];
                    if (daycr[i] < min)//一天最少上几节
                        min = daycr[i];
                }
                if (max - min > 2)
                    f1 += 60;

                for (i = 1; i <= Weak_Day; i++)
                    if (daylt[i] == 0)//如果这一天没有连堂课
                    {
                        if (daycr[i] > Max_Day[pnd])//判断有没有超多一天最大的节数
                            f1 += 20;
                        if (daycr[i] < Min_Day[pnd])
                            f1 += 20;
                    }

                if (Ctwo == 1)//如果需要优先排课
                    if (Cct[MCrs[pnd]] == 1)
                    {
                        for (i = 1; i <= len; i++)
                            if (PCr[set[i]] > C_Time)
                                f1 += 3;
                    }

                if (Crs_Attri[pnd] == 1)
                {
                    l = 0;
                    for (i = 1; i <= len; i++)
                        if (PCr[set[i]] == 1)
                            l++;
                    if (l >= maxk)//有一半排在第一节
                        f1 += 4;
                }

                //课程上下午分布
                if(crsMr > Max_Mr[pnd] || crsAf >Max_Af[pnd])
                {
                    f1 +=2;
                }


            }
            else//没有连堂课
            {
                if (Ctwo == 1)
                    if (Cct[MCrs[pnd]] == 1)
                    {
                        for (i = 1; i <= len; i++)
                            if (PCr[set[i]] > C_Time)
                                f1 += 3;
                    }

                for (j = 1; j <= Weak_Day; j++)
                {
                    if (daycr[j] > Max_Day[pnd])
                        f1 += 20;
                    if (daycr[j] < Min_Day[pnd])
                        f1 += 20;
                }

                if (Crs_Attri[pnd] == 3)//3天不能连上
                {
                    for (j = 1; j <= Weak_Day - 2; j++)
                        if ((daycr[j] > 0) && (daycr[j + 1] > 0) && (daycr[j + 2] > 0))
                        {
                            f1 += 2;
                        }
                }
                else if (Crs_Attri[pnd] == 2)//两天不能连上
                {
                    for (j = 1; j <= Weak_Day - 1; j++)
                        if ((daycr[j] > 0) && (daycr[j + 1] > 0))
                        {
                            f1 += 2;
                        }
                }

                if (Crs_Attri[pnd] == 1)//对于一周上5节课的课程
                {
                    l = 0;
                    for (i = 1; i <= len; i++)
                        if (PCr[set[i]] == 1)//连续半周排第一节
                            l++;
                    if (l >= maxk)
                        f1 += 4;
                }

                //课程上下午分布
                if(crsMr > Max_Mr[pnd] || crsAf >Max_Af[pnd])
                {
                    f1 +=2;

                }
            }
        }
        return f1;
    }
    private int Cal_JP_Score(int ndi, int knew, int t){
        int crs = Par[ndi];//是哪一门课
        int x,y,z;
        int i, j, k, f1, l, m, n, max_pre, min_l, min_c, max_c;
        f1 = 0;
        int[] Tea_set=new int[30];
        int[] maxc=new int[10 + 1];
        int[] minc=new int[10 + 1];
        int[] maxl=new int[10 + 1];
        int[] minl=new int[10 + 1];
        int len;
        int len_l;
        for (i = 1; i <= Set_cl[crs][0]; i++) //记录初始的状态
        {
            set[i] = Crs_srt_cl[crs][i];//这一门课的所有课
        }

        for (i = 1; i <= Set_cl[crs][0]; i++)
            if (Crs_srt_cl[crs][i] == Color[ndi])
            {
                Crs_srt_cl[crs][i] = knew;
                break;
            }//每个都着不同的色了已经
        bubble_sort(Crs_srt_cl[crs], Set_cl[crs][0]);//这门课重新排序

        for (x = 1; x <= Tea_CP_Sign[t][0]; x++)//一个老师的所有课
        {
            //循环次数太多
            len = 0;
            for (y = 1; y <= Tea_CP[t][0]; y++)
            {
                if (Tea_CP_Sign[t][y] == x)//属于需要比较的
                {
                    len++;
                    Tea_set[len] = Tea_CP[t][y];
                }
            }
            Tea_set[0] = len;//有多少门课
            int pnd = Tea_set[1];//新值

            if (Class_Crs_Num_L[MCls[pnd]][MCrs[pnd]] > 0)
            {
                len_l = 0;
                //第一种判定方式
                for (j = 1; j <= 10; j++)
                {
                    maxc[j] = -1;
                    minc[j] = 99999;
                }
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j]; //老师教的这门课，有几门课需要进行比较
                    l = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            l++;//每一次进入计数
                            if (Crs_srt_cl[k][i - 1] < minc[l])//第l次连课的第一节在什么时候上
                                minc[l] = Crs_srt_cl[k][i-1];
                            if (Crs_srt_cl[k][i] > maxc[l])//第l次连课的第二节在什么时候上
                                maxc[l] = Crs_srt_cl[k][i];
                            //break;
                        }
                    }
                    f1 = f1 + maxc[l] - minc[l] - 3;
                    if (len_l < l)
                    {
                        len_l = l;//有几次连堂课
                    }
                }

                int[] a=new int[30];
                l = 0;
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            a[i] = 1;//找出所有的连堂课
                            a[i - 1] = 1;
                        }
                    }
                    for (i = 1; i <= len_l; i++)//对于第一节课
                    {
                        for (m = 1; m <= Set_cl[pnd][0]; m++)
                        {
                            if ((a[m] == 0) && (Crs_srt_cl[k][m] < maxc[i]) && (Crs_srt_cl[k][m] > minc[i])) //非连堂课去进行判定//不该是这样去检验
                                l++;
                        }
                    }
                }
                if (l > 0)
                    f1 = f1+3;
                else
                    f1 = f1+0;


                //第二种判定方式
                for (j = 1; j <= 10; j++)
                {
                    maxl[j] = -1;
                    minl[j] = 99999;
                }
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            a[i] = 1;
                            a[i - 1] = 1;
                        }
                    }
                    l = 0;
                    for (i = 1; i <= len_l; i++)
                    {
                        for (m = 1; m <= Set_cl[pnd][0]; m++)
                        {
                            if ((a[m] == 0) && (Crs_srt_cl[k][m] < maxc[i])) //最后一节连堂课之前有几节课，一定要一样
                                l++;
                        }
                        if (l > maxl[i])
                            maxl[i] = l;
                        if (l < minl[i])
                            minl[i] = l;
                    }
                }
                for (i = 1; i <= len_l; i++)
                {
                    f1 = f1 + 2 * (maxl[i] - minl[i]);  //另一种判定方式，不同课连堂课之前上的课的数量
                }
                //教案平齐（没连堂的教案平齐和连堂教案平齐）
                if (Class_Crs_Num_L[MCls[pnd]][MCrs[pnd]] > 1)//多次连堂课
                {
                    min_l = 9999;
                    for (j = 1; j <= len; j++)
                    {
                        k = Tea_set[j];
                        for (i = 1; i <= Set_cl[pnd][0]; i++)
                            a[i] = 0;
                        for (i = 2; i <= Set_cl[pnd][0]; i++)
                        {
                            if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))//连堂课
                            {
                                a[i] = 1;
                                a[i - 1] = 1;
                            }
                        }
                        l = 0;
                        for (i = 1; i <= Set_cl[pnd][0]; i++)
                            if ((a[i] == 1))
                            {
                                l++;//l肯定是双数
                                JP_KC[j][l] = Crs_srt_cl[k][i];//记录连堂课
                            }
                        if (l < min_l)
                            min_l = l/2;//最少的连堂的有几节课/2
                    }
                    for (i = 1; i <= min_l-1; i++)//连堂课的节数，从第二节开始
                    {
                        max_c = -1;
                        min_c = 99999;
                        for (j = 1; j <= len; j++)
                        {
                            if (JP_KC[j][i*2+1] < min_c)
                                min_c = JP_KC[j][i*2+1];
                            if (JP_KC[j][i*2] > max_c)
                                max_c = JP_KC[j][i*2];//最早开始和最晚开始的两节课
                        }
                        if (min_c < max_c)//最早开始的要比前一节最晚开始的早，不对
                            f1 += 2;
                    }
                }
                //进行非连堂课的教案平齐
                min_l = 9999;
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))//非连堂课
                        {
                            a[i] = 1;
                            a[i - 1] = 1;
                        }
                    }
                    l = 0;
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        if ((a[i] == 0))
                        {
                            l++;
                            JP_KC[j][l] = Crs_srt_cl[k][i];//没有连课的这几节
                        }
                    if (l < min_l)
                        min_l = l;//没连堂的有几节课
                }
                max_pre = -1;
                for (j = 1; j <= len; j++)
                {
                    if (JP_KC[j][1] > max_pre)
                        max_pre = JP_KC[j][1];//最晚开始的最早的一节课
                }

                for (i = 2; i <= min_l; i++)//连堂课的节数，从第二节开始
                {
                    max_c = -1;
                    min_c = 99999;
                    for (j = 1; j <= len; j++)
                    {
                        if (JP_KC[j][i] < min_c)
                            min_c = JP_KC[j][i];
                        if (JP_KC[j][i] > max_c)
                            max_c = JP_KC[j][i];//最早开始和最晚开始的两节课
                    }
                    if (min_c < max_pre || PDay[min_c] == PDay[max_pre])//最早开始的要比前一节最晚开始的早或在同一天，不对
                        f1 += 2;
                    max_pre = max_c;//转换
                }
            }
            else
            {
                //如果不触发连堂课，直接判断教案平齐
                max_pre = -1;
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    if (Crs_srt_cl[k][1] > max_pre)
                        max_pre = Crs_srt_cl[k][1];
                }
                for (i = 2; i <= Set_cl[pnd][0]; i++)
                {
                    max_c = -1;
                    min_c = 99999;
                    for (j = 1; j <= len; j++)
                    {
                        k = Tea_set[j];
                        if (Crs_srt_cl[k][i] < min_c)
                            min_c = Crs_srt_cl[k][i];
                        if (Crs_srt_cl[k][i] > max_c)
                            max_c = Crs_srt_cl[k][i];
                    }
                    if(Set_cl[pnd][0] <= Weak_Day){
                        if (min_c < max_pre || PDay[min_c] == PDay[max_pre])
                        {
                            f1 += 3;
                        }
                    }else{
                        if ( min_c < max_pre )
                        {
                            f1 += 3;
                        }
                    }


                    /*if (min_c < max_pre || PDay[min_c] == PDay[max_pre])
                        f1 += 3;*/
                    max_pre = max_c;
                }
            }

        }
        //算完之后回归原位
        for (i = 1; i <= Set_cl[crs][0]; i++)
        {
            Crs_srt_cl[crs][i] = set[i];//这个pnd不是原来的pnd了
        }
        return f1;

    }
    private int Cal_TScr(){
        int i, j, k, maxk, mink, mr, fn;
        int ft = 0;
        int n_mor = 0;
        int n_af = 0;
        int max_mor=0;
        int min_mor = -1;
        int max_af=0;
        int min_af = -1;
        for (i = 1; i <= Day_Crs_Mr; i++)
            if (TScr[i] != 0)
            {
                n_mor++;
                if (min_mor == -1)
                    min_mor = i;
                max_mor = i;
            }

        for (i = Day_Crs_Mr + 1; i <= Day_Crs; i++)
            if (TScr[i] != 0)
            {
                n_af++;
                if (min_af == -1)
                    min_af = i;
                max_af = i;
            }

        if ((n_mor > 0) && (n_af > 0) && (n_mor + n_af < Day_Crs_Mr - 1))
            return (Day_Crs_Mr + max_mor - min_mor + 1 - n_mor + max_af - min_af + 1 - n_af);
        if (n_mor > 0)
            return (max_mor - min_mor + 1 - n_mor);
        if (n_af > 0)
            return (max_af - min_af + 1 - n_af);
        return 0;
    }

    private int Cal_value_one_move_tea(int ndi, int knew,int th){
        int pnd = Par[ndi];
        int kold = Color[ndi];
        int i, j, k, l, m, l1, l2;
        i = MCls[pnd];//哪个班
        j = MCrs[pnd];//哪节课
        if (Tct[th] == 0)//不需要集中排课
            return 0;

        int day_old, crs_old, day_new, crs_new;
        day_old = PDay[kold];//原来在哪天
        day_new = PDay[knew];//新的在哪天
        crs_old = PCr[kold];//原来在第几节
        crs_new = PCr[knew];//新的在第几节
        if (day_old == day_new)//如果是在同一天
        {
            for (i = 1; i <= Day_Crs; i++)
            {
                TScr[i] = Tea_Crs[th][day_old][i];
            }
            TScr[crs_old]--;
            TScr[crs_new]++;
            l = Cal_TScr() - Tea_Scr[th][day_old];
            return l;
        }
        else
        {
            for (i = 1; i <= Day_Crs; i++)
            {
                TScr[i] = Tea_Crs[th][day_old][i];
            }
            TScr[crs_old]--;
            l1 = Cal_TScr() - Tea_Scr[th][day_old];

            for (i = 1; i <= Day_Crs; i++)
            {
                TScr[i] = Tea_Crs[th][day_new][i];
            }
            TScr[crs_new]++;
            l2 = Cal_TScr() - Tea_Scr[th][day_new];
            return l1 + l2;
        }
    }

    private void greed_ini_solution() throws MyException {
        int i, j, k, l, v;
        int c, m;
        int x, y;
        int num_best = 0;
        int pick, day, crs;
        int old_color;
        int iter;
        int best_delta, delt, v_delt, v_best_delta;
        int select;
        int a[] = { 0,0,0,0,0,0,0,0 };//天
        int period;
        int len;

        setcolor();
        Clear_Delta_Matrix();
        Build_Delta_Matrix();//初始化

        for (i = 0; i <= XK_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
                Day_Set[i][j] = 0;
        }
        //System.out.print("进入" + "\n");

        l = 1;
        XK_Type[l] = XK_Set_cl[1][0];//课时数一样的才进行比较
        for(i=2;i<=XK_Num;i++){
            len = 0;
            for(j=1;j<=l;j++){
                if(XK_Set_cl[i][0] == XK_Type[j]){
                    len = 1;
                }
            }
            if(len != 1){
                l++;
                XK_Type[l] = XK_Set_cl[i][0];//课时数一样的才进行比较
            }
        }
        XK_Type[0] = l;
        /*for(i=0;i<=XK_Type[0];i++){
            System.out.print(XK_Type[i] + " ");
        }*/
        /*len = XK_Set_cl[1][0];
        System.out.print("len="+len + "\n");*/
        //初始预排选考课
        for (x = 1; x <= N_vtx; x++){
            if ((Color[x] == 0) && (Node_Tea_Sign[x] == -2))
            {
                while (true)
                {
                    if(System.currentTimeMillis() - startTime > 600000){
                        throw new MyException("排课超时，请检查数据是否正确或联系客服人员");
                    }
                    pick = 0;
                    k = rand.nextInt(KCL) + 1;
                    for (y = 1; y <= XK_Node_Num; y++)
                    {
                        if (k == Color[XK_Node[y]])//相同的色直接继续
                        {
                            pick = 1;
                            break;
                        }
                    }
                    if (pick == 1)
                    {
                        continue;
                    }
                    day = PDay[k];//在哪一天
                    crs = PCr[k];//哪一节课

                    //cout << "Day_Set[XK[Node_Course[x][1]]][day]=" << Day_Set[XK[Node_Course[x][1]]][day] << " Max_Day[Par[x]]=" << Max_Day[Par[x]] << endl;
                    if ((AVB_Cl[x][k] == 1) && (Day_Set[XK[Node_Course[x][1]]][day] < Max_Day[Par[x]]))//
                    {
                        //System.out.print("x=" + x + "  Node_Course[x][1]=" + Node_Course[x][1] + " " + k + "\n");
                        old_color = Color[x];  //存储顶点移动之前的着色类
                        One_Move_Update_Delta_Matrix(x, old_color, k);//更新增量矩阵
                        Color[x] = k;
                        Day_Set[XK[Node_Course[x][1]]][day]++;
                        break;
                    }
                }
            }
        }
        /*System.out.print("检查初始预排选考课结果：" + "\n");
        for(i=1;i<=N_vtx;i++){
            System.out.print(Color[i] + " ");
        }
        System.out.print("\n");
        System.out.print("完成预排" + "\n");*/
        //完成预排，开始检验
        for (i = 1; i <= XK_Num; i++)
        {
            for (j = 1; j <= XK_Set_cl[i][0]; j++)
            {
                m = XK_Set_cl[i][j];
                //System.out.print("m = " + m + "\n");
                c = Color[m];
                XK_srt_cl[i][j] = c;//哪节课在哪个时间段上
            }
            bubble_sort(XK_srt_cl[i], XK_Set_cl[i][0]);
            XK_srt_cl[i][0] = XK_Set_cl[i][0];
        }
        /*for(i=1;i<=XK_Num;i++){
            for(j=0;j<=XK_Set_cl[i][0];j++){
                System.out.print(XK_srt_cl[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        XK_f = Cal_XK_Score();

        Ini_Delta_XK();
        //System.out.print("开始优化" + "\n");
        for(iter = 0;iter<1000;iter++)
        {
            best_delta = 9999999;
            v_best_delta = 9999999;
            num_best = 0;
            for (i = 1; i <= XK_Node_Num; i++)
            {
                x = XK_Node[i];
                if(YPK[x] == 0){//非预排课，可以动
                    for (v = 1; v <= KCL; v++)
                    {
                        if ((AVB_Cl[x][v] == 1) && (v != Color[x]))//不等于同色，且没有被预排
                        {
                            delt = Delta_Matrix[x][v] - Delta_Matrix[x][Color[x]];
                            if (delt < best_delta)
                            {
                                best_x[0] = x;
                                best_v[0] = v;
                                best_delta = delt;
                                v_best_delta = Delta_XK[x][v];
                                num_best = 1;
                            }
                            else if (delt == best_delta)
                            {
                                v_delt = Delta_XK[x][v];//
                                if (v_delt < v_best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = v;
                                    best_delta = delt;
                                    v_best_delta = v_delt;
                                    num_best = 1;
                                }
                                else if ((v_delt == v_best_delta) && (num_best < 1000))
                                {
                                    best_x[num_best] = x;
                                    best_v[num_best] = v;
                                    num_best++;
                                }
                            }
                        }
                    }
                }
            }
            if(num_best == 0){
                break;
            }
            select = rand.nextInt(num_best);
            old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
            One_Move_Update_Delta_XK(best_x[select], old_color, best_v[select]);//更新增量矩阵
            One_Move_Update_Delta_Matrix(best_x[select], old_color, best_v[select]);//更新增量矩阵
            Color[best_x[select]] = best_v[select];//更新着色类方案
            //System.out.print("v = " + best_v[select] + "\n");
            Update_Delta_XK();
            One_Move_Update_Delta_XK(best_x[select], old_color, best_v[select]);//再更新回来
            XK_f = Cal_XK_Score();

            if(XK_f <= 0){
                break;
            }
            /*System.out.print("XK_f = " + XK_f + "\n");
            for(i=1;i<=N_vtx;i++){
                System.out.print(Color[i] + " ");
            }
            System.out.print("\n");
            for(i=1;i<=Weak_Day;i++){
                for(j=1;j<=Day_Crs;j++){
                    Class_Crs[1][i][j] = 0;
                }
            }
            for(i=1;i<=N_vtx;i++){
                Class_Crs[1][PDay[Color[i]]][PCr[Color[i]]] = MCrs[Par[i]];
            }
            for(i=1;i<=Weak_Day;i++){
                for(j=1;j<=Day_Crs;j++){
                    System.out.print(Class_Crs[1][i][j] + "\t");
                }
                System.out.print("\n");
            }*/
        }
        /*System.out.print("检查最终预排选考课结果：" + "\n");
        for(i=1;i<=N_vtx;i++){
            System.out.print(Color[i] + " ");
        }
        System.out.print("\n");*/

        for (i = 0; i <= Crs_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
                Day[i][j] = 0;
        }

        //*********************************
        //开始预排课程
        for (i = 1; i <= Synthesis_Node_Num; i++)
        {
            x = Synthesis_Node[i];
            if (Color[x] == 0)
            {
                while (1 > 0)
                {
                    if(System.currentTimeMillis() - startTime > 600000){
                        throw new MyException("排课超时，请检查数据是否正确或联系客服人员");
                    }
                    pick = 0;
                    k = rand.nextInt(KCL) + 1;
                    for (y = 1; y <= Synthesis_Node_Num; y++)
                    {
                        if (k == Color[Synthesis_Node[y]])
                        {
                            pick = 1;
                        }
                    }
                    if (pick == 1)
                    {
                        continue;
                    }

                    day = PDay[k];
                    crs = PCr[k];
                    if ((AVB_Cl[x][k] == 1) && (Day[MCrs[Par[x]]][day] < Max_Day[Par[x]]) && (crs >= 2))
                    {
                        old_color = Color[x];  //存储顶点移动之前的着色类
                        One_Move_Update_Delta_Matrix(x, old_color, k);//更新增量矩阵
                        Color[x] = k;
                        Day[MCrs[Par[x]]][day]++;
                        break;
                    }
                }
            }
        }

        l = 0;
        for (x = 1; x <= N_vtx; x++)
        {
            if (Color[x] > 0)
            {
                l++;
            }
        }
        //System.out.print("l = " + l + "\n");
        for (iter = l + 1; iter <= N_vtx; iter++)
        {
            best_delta = 9999999;
            v_best_delta = 9999999;
            num_best = 0;
            for (x = 1; x <= N_vtx; x++)
                if (Color[x] == 0)
                {
                    for (v = 1; v <= KCL; v++)
                        if ((AVB_Cl[x][v] == 1))
                        {
                            delt = Delta_Matrix[x][v];
                            if (delt < best_delta)
                            {
                                best_x[0] = x;
                                best_v[0] = v;
                                best_delta = delt;
                                v_best_delta = Delta_Matrix[x][0];
                                num_best = 1;
                            }
                            else if (delt == best_delta)  //if some flips have the same delta,then choose at most 50 and record them   && num_best < 50
                            {
                                v_delt = Delta_Matrix[x][0];
                                if (v_delt > v_best_delta)
                                {
                                    best_x[0] = x;
                                    best_v[0] = v;
                                    best_delta = delt;
                                    v_best_delta = v_delt;
                                    num_best = 1;
                                }
                                else if ((v_delt == v_best_delta) && (num_best < 1000))
                                {
                                    best_x[num_best] = x;
                                    best_v[num_best] = v;
                                    num_best++;
                                }
                            }
                        }
                }
            if (num_best == 0)
            {
                //System.out.print("x=" + x + "\n");
                //System.out.print("对课程的时间约束太多，无法生成合法解"+"\n");
                throw new MyException("对课程的时间约束太多，无法生成合法解");
            }
            select = rand.nextInt( num_best);
            old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
            One_Move_Update_Delta_Matrix(best_x[select], old_color, best_v[select]);//更新增量矩阵
            Color[best_x[select]] = best_v[select];//更新着色类方案
        }
        /*for (i = 1; i <= N_vtx; i++)
            System.out.print(Color[i] + " ");
        System.out.print("\n");*/
        f = 0;
        for (i = 1; i <= N_vtx; i++)
            for (j = 1; j < i; j++)
                if (Edge[i][j] != 0)
                {
                    if (Color[i] == Color[j])
                    {
                        f += 1;
                        //System.out.print("i= " + i + "班级" + MCls[Par[i]] + "课程" + MCrs[Par[i]] + " j= " + j + "班级" + MCls[Par[j]] + "课程" + MCrs[Par[j]] + "\n");
                    }
                }

        //System.out.print("inial_f=" + f + "\n");
    }


    private void copy_ini_solution(){
        int i, j;
        for (i = 1; i <= N_vtx; i++)
        {
            Color[i] = Best_Color[i];
        }
        Clear_Delta_Matrix();
        Build_Delta_Matrix();
    }

    private void setcolor(){
        int i;
        for (i = 1; i <= N_vtx; i++)
        {
            Color[i] = Initial_Color[i];//预排课赋值
        }
    }
    private void Clear_Delta_Matrix(){
        int x, v;
        f = 0;
        f_crs = 0;
        for (x = 0; x <= N_vtx; x++)
            for (v = 0; v <= KCL; v++)
                Delta_Matrix[x][v] = 0; //Delta_Matrix[x][v] means the change on function when the colour of x flip to colour v

        for (x = 0; x <= N_vtx; x++)
            for (v = 0; v <= KCL; v++)
                TabuTenure[x][v] = 0; //TabuTenure[x][v]means in the following generation the colour of x can not be flip to clour v
    }
    private void Build_Delta_Matrix(){
        int i, j;
        f = 0;
        for (i = 1; i <= N_vtx; i++)
            for (j = 1; j < i; j++)
                if (Edge[i][j] != 0)
                {
                    Delta_Matrix[i][Color[j]] += 1;
                    Delta_Matrix[j][Color[i]] += 1;
                    if (Color[i] == Color[j])
                        f += 1;
                }
    }

    private void One_Move_Update_Delta_XK(int tt, int v0, int v1)
    {
        int i, j, m, c;
        for (i = 1; i <= XK_Num; i++)
        {
            for (j = 1; j <= XK_Set_cl[i][0]; j++)
            {
                if (XK_Set_cl[i][j] == tt)
                {
                    XK_srt_cl[i][j] = v1;
                }
                else
                {
                    m = XK_Set_cl[i][j];
                    c = Color[m];
                    XK_srt_cl[i][j] = c;
                }
            }
            bubble_sort(XK_srt_cl[i], XK_Set_cl[i][0]);
            XK_srt_cl[i][0] = XK_Set_cl[i][0];
        }
    }

    private void One_Move_Update_Delta_Matrix(int tt, int v0, int v1) {
        int i, len, x;
        len = A_Matrix[tt][0];
        for (i = 1; i <= len; i++)
        {
            x = A_Matrix[tt][i];
            Delta_Matrix[x][v0] -= Edge[x][tt];
            Delta_Matrix[x][v1] += Edge[x][tt];
        }
    }
    private void One_Move_Update_Course(int tt, int v0, int v1){
        int pnd = Par[tt];
        Class_Score[pnd] = Cal_Class_Score(tt, v1);
    }
    private void One_Move_Update_JP(int tt){
        int i, j, k, l, t;
        int pnd = Par[tt];//这节课属于哪门课
        for (i = 1; i <= Set_cl[pnd][0]; i++)
            Crs_srt_cl[pnd][i] = Color[Set_cl[pnd][i]];//颜色已经改变
        bubble_sort(Crs_srt_cl[pnd], Set_cl[pnd][0]);

        for (i = 1; i <= Node_Tea[tt][0]; i++)
        {
            t = Node_Tea[tt][i];
            if (t > 0)
                Tea_JP_Score[t] = Cal_JP_Score(tt, Color[tt],t);
        }
    }
    private void Sort_Src(){
        int i, j, c, l, m;
        for (i = 1; i <= MNum; i++)
        {
            for (j = 1; j <= Set_cl[i][0]; j++)
            {
                m = Set_cl[i][j];
                c = Color[m];
                Crs_srt_cl[i][j] = c;//哪节课在哪个时间段上
            }
            bubble_sort(Crs_srt_cl[i], Set_cl[i][0]);
            Crs_srt_cl[i][0] = Set_cl[i][0];
        }
    }
    private void bubble_sort(int pset[], int len){
        int i, j, temp;
        for (i = 1; i < len; i++)
            for (j = 1; j < len + 1 - i; j++)
                if (pset[j] > pset[j + 1])
                {
                    temp = pset[j];
                    pset[j] = pset[j + 1];
                    pset[j + 1] = temp;
                }
    }

    private int Cal_XK_Score()//计算有误，进行修改
    {
        int i, j, k;
        int len;
        int max_XK;
        int min_XK;
        int max_pre_XK;
        int ff = 0;
        int node;
        int node_2;
        int node_pre;
        int color;
        //集中排课+教案平齐
        /*for(i=1;i<=XK_Num;i++){
            for(j=0;j<=XK_Set_cl[i][0];j++){
                System.out.print(XK_srt_cl[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        for (i = 1; i <= XK_Num; i++)
        {
            for(j = 1;j <= Weak_Day;j++){
                Day_Set[i][j] = 0;//课时
            }
        }

        for (i = 1; i <= XK_Num; i++)//这些课在哪个时间点
        {
            for(j = 1;j <= XK_Set_cl[i][0];j++){
                color = XK_srt_cl[i][j];
                Day_Set[i][PDay[color]]++;
            }
        }

        /*for (i = 1; i <= XK_Num; i++){
            for(j = 1;j <= Weak_Day;j++){
                System.out.print(Day_Set[i][j] + " ");
            }
            System.out.print("\n");
        }*/

        for (i = 1; i <= XK_Num; i++){
            for(j = 1;j <= Weak_Day;j++){
                if(Day_Set[i][j] > Max_Day[Par[XK_Set_cl[i][1]]] || Day_Set[i][j] < Min_Day[Par[XK_Set_cl[i][1]]]){
                    ff += 2;
                }
            }
        }

        for(i=1;i<=XK_Type[0];i++){
            node = 0;//有几个点
            max_XK = -1;
            min_XK = 999999;
            for (j = 1; j <= XK_Num; j++)
            {
                if(XK_Set_cl[j][0] == XK_Type[i]){
                    node++;
                    if (XK_srt_cl[j][1] > max_XK)
                    {
                        max_XK = XK_srt_cl[j][1];
                    }
                    if (XK_srt_cl[j][1] < min_XK)
                    {
                        min_XK = XK_srt_cl[j][1];
                    }
                }
            }
            //System.out.print("node = " + node + "\n");
            max_pre_XK = max_XK;
            len = XK_Type[i];
            //System.out.print("len =" + len + "\n" );
            for (j = 2; j <= len; j++)
            {
                max_XK = -1;
                min_XK = 999999;
                for (k = 1; k <= XK_Num; k++)
                {
                    if(XK_Set_cl[k][0] == XK_Type[i]){
                        if (XK_srt_cl[k][j] > max_XK)
                        {
                            max_XK = XK_srt_cl[k][j];
                        }
                        if (XK_srt_cl[k][j] < min_XK)
                        {
                            min_XK = XK_srt_cl[k][j];
                        }
                    }
                }
                if(node < 3){
                    ff = ff + max_XK - min_XK - XK_Type[i] ;//集中
                    if(XK_Type[i] <= Weak_Day){
                        if (min_XK < max_pre_XK || PDay[min_XK] == PDay[max_pre_XK])//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }else{
                        if (min_XK < max_pre_XK)//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }

                }else if(node == 3){
                    if(XK_Type[i] <= Weak_Day){
                        if (min_XK < max_pre_XK || PDay[min_XK] == PDay[max_pre_XK])//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }else{
                        if (min_XK < max_pre_XK)//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }
                }else{
                    if (min_XK < max_pre_XK)//最早开始的要比前一节最晚开始的早，不对
                    {
                        ff += 200;
                    }
                }
                max_pre_XK = max_XK;//转换
            }
        }
        return ff;
    }

    private int Cal_XK_Score(int x, int new_color)
    {
        int i, j, k;
        int len;
        int max_XK;
        int min_XK;
        int max_pre_XK;
        int ff = 0;
        int node;
        int node_2;
        int node_pre;
        int color;
        int m, c;
        for (i = 1; i <= XK_Num; i++)
        {
            for (j = 1; j <= XK_Set_cl[i][0]; j++)
            {
                if (XK_Set_cl[i][j] == x)
                {
                    XK_srt_cl[i][j] = new_color;
                }
                else
                {
                    m = XK_Set_cl[i][j];
                    c = Color[m];
                    XK_srt_cl[i][j] = c;
                }
            }
            bubble_sort(XK_srt_cl[i], XK_Set_cl[i][0]);
            XK_srt_cl[i][0] = XK_Set_cl[i][0];
        }
        for (i = 1; i <= XK_Num; i++)
        {
            for(j = 1;j <= Weak_Day;j++){
                Day_Set[i][j] = 0;//课时
            }
        }

        for (i = 1; i <= XK_Num; i++)//这些课在哪个时间点
        {
            for(j = 1;j <= XK_Set_cl[i][0];j++){
                color = XK_srt_cl[i][j];
                Day_Set[i][PDay[color]]++;
            }
        }

        /*for (i = 1; i <= XK_Num; i++){
            for(j = 1;j <= Weak_Day;j++){
                System.out.print(Day_Set[i][j] + " ");
            }
            System.out.print("\n");
        }*/

        for (i = 1; i <= XK_Num; i++){
            for(j = 1;j <= Weak_Day;j++){
                if(Day_Set[i][j] > Max_Day[Par[XK_Set_cl[i][1]]] || Day_Set[i][j] < Min_Day[Par[XK_Set_cl[i][1]]]){
                    ff += 2;
                }
            }
        }
        //集中排课+教案平齐
        for(i=1;i<=XK_Type[0];i++){
            node = 0;
            max_XK = -1;
            min_XK = 999999;
            for (j = 1; j <= XK_Num; j++)
            {
                if(XK_Set_cl[j][0] == XK_Type[i]){
                    node++;
                    if (XK_srt_cl[j][1] > max_XK)
                    {
                        max_XK = XK_srt_cl[j][1];
                    }
                    if (XK_srt_cl[j][1] < min_XK)
                    {
                        min_XK = XK_srt_cl[j][1];
                    }
                }
            }
            max_pre_XK = max_XK;
            len = XK_Type[i];
            //System.out.print("len =" + len + "\n" );
            for (j = 2; j <= len; j++)
            {
                max_XK = -1;
                min_XK = 999999;
                for (k = 1; k <= XK_Num; k++)
                {
                    if(XK_Set_cl[k][0] == XK_Type[i]){
                        if (XK_srt_cl[k][j] > max_XK)
                        {
                            max_XK = XK_srt_cl[k][j];
                        }
                        if (XK_srt_cl[k][j] < min_XK)
                        {
                            min_XK = XK_srt_cl[k][j];
                        }
                    }
                }
                if(node < 3){
                    ff = ff + max_XK - min_XK - XK_Type[i] ;//集中
                    if(XK_Type[i] <= Weak_Day){
                        if (min_XK < max_pre_XK || PDay[min_XK] == PDay[max_pre_XK])//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }else{
                        if (min_XK < max_pre_XK)//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }
                }else if(node == 3){
                    if(XK_Type[i] <= Weak_Day){
                        if (min_XK < max_pre_XK || PDay[min_XK] == PDay[max_pre_XK])//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }else{
                        if (min_XK < max_pre_XK)//最早开始的要比前一节最晚开始的早，不对
                        {
                            ff += 200;
                        }
                    }
                }else{
                    if (min_XK < max_pre_XK)//最早开始的要比前一节最晚开始的早，不对
                    {
                        ff += 200;
                    }
                }
                //System.out.print("ff = " + ff + "\n");
                max_pre_XK = max_XK;//转换
            }
        }
        //System.out.print("\n");
        return ff;
    }

    //**********************************************************************
    private void Ini_Delta_XK()
    {
        int i, j;
        int x;
        for (i = 1; i <= XK_Node_Num; i++)
        {
            x = XK_Node[i];
            for (j = 1; j <= KCL; j++)
            {

                if (Color[x] == j)
                {
                    Delta_XK[x][j] = 0;
                }
                else
                {
                    Delta_XK[x][j] = Cal_XK_Score(x, j) - XK_f;
                }
            }
        }
    }

    private void Ini_Delta_Crs(){
        int i, j, l;
        for (i = 1; i <= N_vtx; i++)
        {
            l = Cal_Class_Score(i, Color[i]);
            for (j = 1; j <= KCL; j++)
                Delta_Crs[i][j] = Cal_Class_Score(i, j) - l;
        }

    }
    private void Ini_Delta_Tpj(){
        int i, j, k;
        int gl;
        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= KCL; j++)
            {
                Delta_Ttm[i][j] = 0;
            }
        }
        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= KCL; j++)
            {
                gl = 0;
                for (k = 1; k <= Node_Tea[i][0]; k++)
                {
                    if (Node_Tea[i][k] <= 0)//
                    {
                        gl += 0;
                    }
                    else
                    {
                        gl += Cal_value_one_move_tea(i, j, Node_Tea[i][k]);//告知是哪个教师，能传进来的必大于0
                    }
                }
                Delta_Ttm[i][j] = gl;
            }
        }
    }
    private void Ini_Delta_Ttm(){
        int i, j, k, l;
        int gl;
        int gll;
        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= KCL; j++)
            {
                Delta_Tpj[i][j] = 0;
            }
        }

        for (i = 1; i <= N_vtx; i++)
        {
            gll = 0;
            if (Node_Tea_Sign[i] <= 0)
            {
                for (k = 1; k <= KCL; k++)
                    Delta_Tpj[i][k] = 0;
                continue;
            }
            else
            {
                for (j = 1; j <= Node_Tea[i][0]; j++)
                {
                    gll = 1;
                    l = Cal_JP_Score(i, Color[i], Node_Tea[i][j]);
                    for (k = 1; k <= KCL; k++)
                    {
                        dgl[k] += Cal_JP_Score(i, k, Node_Tea[i][j]) - l;
                    }
                }
            }
            if (gll == 1)
            {
                for (k = 1; k <= KCL; k++)
                {
                    Delta_Tpj[i][k] = dgl[k];
                    dgl[k] = 0;
                }
            }
        }

    }

    private void Update_Delta_XK()
    {
        int i, j;
        int x;
        XK_f = Cal_XK_Score();
        for (i = 1; i <= XK_Node_Num; i++)
        {
            for (j = 1; j <= KCL; j++)
            {
                x = XK_Node[i];
                if (Color[x] == j)
                {
                    Delta_XK[x][j] = 0;
                }
                else
                {
                    Delta_XK[x][j] = Cal_XK_Score(x, j) - XK_f;
                }
            }
        }
    }

    private void Update_Delta_Crs(int ndi){
        int i, j, k, l, delta;

        for (k = 1; k <= Set_cl[Par[ndi]][0]; k++)
        {
            i = Set_cl[Par[ndi]][k];
            l = Cal_Class_Score(i, Color[i]);
            for (j = 1; j <= KCL; j++)
                Delta_Crs[i][j] = Cal_Class_Score(i, j) - l;
        }

    }
    private void Update_Delta_Tpj(int ndi){
        int i, j, k, l,m;
        int x, y;
        int gl;
        int gll;

        //cout << "Tea" << endl;
        //存在问题
        if (Node_Tea_Sign[ndi] <= 0)
        {
            return;
        }

        for (i = 1; i <= N_vtx; i++)
        {
            gll = 0;
            for (x = 1; x <= Node_Tea[i][0]; x++)
            {
                for (y = 1; y <= Node_Tea[ndi][0]; y++)
                {
                    if (Node_Tea[i][x] == Node_Tea[ndi][y])//只要是教师相同的点,就会受到影响
                    {
                        gll = 1;
                        l = Cal_JP_Score(i, Color[i], Node_Tea[i][x]);
                        for (m = 1; m <= KCL; m++)
                        {
                            dgl[m] += (Cal_JP_Score(i, m, Node_Tea[i][x]) - l);
                        }
                    }
                }

            }
            if (gll == 1)
            {
                for (j = 1; j <= KCL; j++)
                {
                    Delta_Tpj[i][j] = dgl[j];
                    dgl[j] = 0;
                }

            }
        }


    }
    private void Update_Delta_Ttm(int ndi){
        int i, j, x, y;
        int gl;
        int gll;
        if (Node_Tea_Sign[ndi] <= 0)
        {
            return;
        }
        for (i = 1; i <= N_vtx; i++)
        {

            for (j = 1; j <= KCL; j++)
            {
                gll = 0;//判断用
                gl = 0;
                for (x = 1; x <= Node_Tea[i][0]; x++)
                {
                    for (y = 1; y <= Node_Tea[ndi][0]; y++)
                    {
                        if (Node_Tea[i][x] == Node_Tea[ndi][y])
                        {
                            gll = 1;
                            gl += Cal_value_one_move_tea(i, j, Node_Tea[i][x]);//告知是哪个教师，能传进来的必大于0
                        }

                    }
                }
                if (gll == 1)
                {
                    Delta_Ttm[i][j] = gl;
                }
            }
        }

    }
    private int Update_Tea_Src(int x, int y){
        int i, j, k, l;
        set_tea_Src(x, y);
        l = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            l += Tea_Score[i];
        }
        return l;
    }
    private void set_tea_Src(){
        int i, j, k, l, m, n, c, s, t, th, ii;
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Tea_Crs[i][j][k] = 0;
            }
        }

        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= Node_Tea[i][0]; j++)//多少教师
            {
                c = Color[i];
                th = Node_Tea[i][j];
                if(th>0)
                    Tea_Crs[th][PDay[c]][PCr[c]]++;
            }
        }

        for (i = 1; i <= Tea_Num; i++)
        {
            Tea_Score[i] = 0;
            for (j = 1; j <= Weak_Day; j++)
            {
                if (Tct[i] == 1)
                {
                    for (k = 1; k <= Day_Crs; k++)
                        TScr[k] = Tea_Crs[i][j][k];//哪几节上的
                    Tea_Scr[i][j] = Cal_TScr();
                }
                else
                    Tea_Scr[i][j] = 0;
                Tea_Score[i] += Tea_Scr[i][j];
            }
            Tea_Score[i] = Tea_Score[i] + Tea_JP_Score[i];
        }
    }
    private void set_tea_Src(int x, int y){
        int i, j, k, l, m, n, c, s, t, th, ii;
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Tea_Crs[i][j][k] = 0;
            }
        }

        for (i = 1; i <= N_vtx; i++)
        {
            for (j = 1; j <= Node_Tea[i][0]; j++)//多少教师
            {
                c = Color[i];
                th = Node_Tea[i][j];
                if (th>0)
                    Tea_Crs[th][PDay[c]][PCr[c]]++;
            }
        }

        if (Node_Tea_Sign[x] > 0)
        {
            for (i = 1; i <= Node_Tea[x][0]; i++)
            {
                for (j = 1; j <= Weak_Day; j++)
                {
                    if (Tct[Node_Tea[x][i]] == 1)
                    {
                        for (k = 1; k <= Day_Crs; k++)
                            TScr[k] = Tea_Crs[Node_Tea[x][i]][j][k];
                        Tea_Scr[Node_Tea[x][i]][j] = Cal_TScr();
                        //T_f[ TPP[ x ] ] += Tea_Scr[ TPP[ x ] ][ j ];
                    }
                    else
                        Tea_Scr[Node_Tea[x][i]][j] = 0;
                }
            }

        }

        if ((Node_Tea_Sign[x] != Node_Tea_Sign[y]) && (Node_Tea_Sign[y] > 0))
        {
            for (i = 1; i <= Node_Tea[y][0]; i++)
            {
                for (j = 1; j <= Weak_Day; j++)
                {
                    if (Tct[Node_Tea[y][i]] == 1)
                    {
                        for (k = 1; k <= Day_Crs; k++)
                            TScr[k] = Tea_Crs[Node_Tea[y][i]][j][k];
                        Tea_Scr[Node_Tea[y][i]][j] = Cal_TScr();
                    }
                    else
                        Tea_Scr[Node_Tea[y][i]][j] = 0;
                }
            }
        }

        for (i = 1; i <= Tea_Num; i++)
        {
            Tea_Score[i] = 0;
            for (j = 1; j <= Weak_Day; j++)
            {
                Tea_Score[i] += Tea_Scr[i][j];
            }
            Tea_Score[i] = Tea_Score[i] + Tea_JP_Score[i];
        }
    }
    private void reset_tabu_tenure(){
        int x, v;
        for (x = 0; x <= N_vtx; x++)
            for (v = 0; v <= KCL; v++)
                TabuTenure[x][v] = 0;
    }

    private void get_result(){
        int i, j, k, l, m, n, c, s, t, th, ii, bn, x, y;
        int M = 0;
        int class_id = 0;
        for (i = 0; i <= Class_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Class_Crs[i][j][k] = 0;
            }
        }
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Tea_Crs[i][j][k] = 0;
            }
        }
        for (i = 0; i <= Stu_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Stu_Crs[i][j][k] = 0;
            }
        }

        System.out.print("Start Class_Crs_get_result" + "\n");


        System.out.print("\n");
        l = 1;
        System.out.print("H1安排班级和教师课表"+"\n");
        for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Crs_Num; j++) {
                System.out.print(Class_Crs_Num[i][j] + " ");
            }
            System.out.print("\n");
        }

        for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Crs_Num; j++)
                if (Class_Crs_Num[i][j] > 0) {
                    if (Class_Crs_HEBAN[i][j] >= 100000)//触发合班课
                    {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++) {
                            m = Set_cl[l][t];
                            c = Color[m];
                            th = Class_Tea[i][j];
                            bn = Class_Crs_HEBAN[i][j] - 100000;//合班课不允许有两个教师
                            for (k = 1; k <= HBK[bn][0]; k++) {
                                Class_Crs[HBK[bn][k]][PDay[c]][PCr[c]] = j;
                            }
                            if (th > 0) {
                                for (k = 1; k <= HBK[bn][0]; k++) {
                                    M = (int) Math.pow(100, k);
                                    Tea_Crs[th][PDay[c]][PCr[c]] = Tea_Crs[th][PDay[c]][PCr[c]] + HBK[bn][k] * M;
                                }
                            }
                            /*
                            if (th == -2) {
                                for (ii = 1; ii <= XK_Tea_Set[XK[j]][0]; ii++) {
                                    m = XK_Tea_Set[XK[j]][ii];
                                    Tea_Crs[m][PDay[c]][PCr[c]] = j;
                                }
                            }*/
                        }
                    }
                    else if (Class_Crs_HEBAN[i][j] == 50000) {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++) {
                            m = Set_cl[l][t];
                            c = Color[m];
                            for (k = 1; k <= XK_Class_Set[XK[j]][0]; k++) {
                                Class_Crs[XK_Class_Set[XK[j]][k]][PDay[c]][PCr[c]] = j;
                                th = Class_Tea[XK_Class_Set[XK[j]][k]][j];
                                if (th > 0)
                                    Tea_Crs[th][PDay[c]][PCr[c]] = XK_Class_Set[XK[j]][k];
                            }

                            /*if (th == -2) {
                                for (ii = 1; ii <= XK_Tea_Set[XK[j]][0]; ii++) {
                                    m = XK_Tea_Set[XK[j]][ii];
                                    Tea_Crs[m][PDay[c]][PCr[c]] = -3;
                                }
                            }*/
                        }
                    }
                    else//正常
                    {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++) {
                            m = Set_cl[l][t];
                            c = Color[m];
                            for (x = 1; x <= Node_Tea[m][0]; x++) {
                                th = Node_Tea[m][x];
                                if (th > 0)
                                    Tea_Crs[th][PDay[c]][PCr[c]] = i;
                                /*if (th == -2) {
                                    for (ii = 1; ii <= XK_Tea_Set[XK[j]][0]; ii++) {
                                        m = XK_Tea_Set[XK[j]][ii];
                                        Tea_Crs[m][PDay[c]][PCr[c]] = -3;
                                    }
                                }*/
                            }
                            Class_Crs[i][PDay[c]][PCr[c]] = j;
                        }
                    }
                    l++;
                }
        }

        System.out.print("H2安排学生课表" + "\n");

        for (i = 0; i <Stu_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                {
                    Stu_Crs[i][j][k] = Class_Crs[Stu_Class[i][0]][j][k];
                }
            }
        }

        /*for(i=0;i<Stu_Num;i++){
            for(j=1;j<=Crs_Num;j++){
                System.out.print(Stu_XK[i][j] + " ");
            }
            System.out.print("\n");
        }*/

        for(i = 0;i <Stu_Num;i++)
        {
            for(j = 1;j<=Crs_Num;j++)
            {
                class_id = Stu_Class[i][j];
                //System.out.print("class_id = " + class_id + "\n");
                if(Stu_XK[i][j] > 0)//这节选考课要去其他地方上
                {
                   // System.out.print("进入了" + "\n");
                    for(x = 1;x<=Weak_Day;x++)
                    {
                        for(y = 1;y<=Day_Crs;y++)
                        {
                            if(Class_Crs[class_id][x][y] == j)
                                Stu_Crs[i][x][y] = Stu_XK[i][j];
                        }
                    }
                }
                else
                {
                    for(x = 1;x<=Weak_Day;x++)
                    {
                        for(y = 1;y<=Day_Crs;y++)
                        {
                            if(Class_Crs[class_id][x][y] == j)
                                Stu_Crs[i][x][y] = j;
                        }
                    }
                }

            }
        }


       System.out.print("班级课表" + "\n");
        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++){
                    if(Class_Crs[i][j][k]>0){
                        //System.out.print(CourseID.get(Class_Crs[i][j][k]-1)+" ");
                        System.out.print(Class_Crs[i][j][k]+"\t");
                    }
                    else{
                        System.out.print("\t");
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        System.out.print("教师课表" + "\n");
        for (i = 1; i <= Tea_Num; i++)
        {
            System.out.print(Tea_ID.get(i-1) + "\n");
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++){
                    System.out.print(Tea_Crs[i][j][k]+" ");
                }

                System.out.print("\n");
            }
            System.out.print("\n");
        }

        /*System.out.print("学生课表" + "\n");
        for (i = 0; i < Stu_Num; i++)
        {
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++){
                    if(Stu_Crs[i][j][k]>0){
                        //System.out.print(CourseID.get(Stu_Crs[i][j][k]-1)+" ");
                        System.out.print(Stu_Crs[i][j][k]+" ");
                    }
                    else{
                        System.out.print(" " + " ");
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }*/
    }

    private int Last_Cal_Class_Score(int ndi, int knew){
        int pnd = Par[ndi];//属于哪一门课
        int kold = Color[ndi];
        int len;
        int f1 = 0;
        int maxk = Weak_Day / 2;//3天
        if (maxk < 3)
            maxk = 3;
        int i, j, k, l, len_lt, max, min;
        int x, y;
        int crsMr = 0;
        int crsAf = 0;
        int c_Num = Node_Course[ndi][0];//这节课的课程属性
        for (x = 1; x <= c_Num; x++)
        {
            //可以进行改进
            len = Set_Crs[MCls[pnd]][Node_Course[ndi][x]][0];
            for (i = 1; i <= Set_Crs[ MCls[pnd] ][ Node_Course[ndi][x] ][0]; i++)
            {
                if (Set_Crs[MCls[pnd]][Node_Course[ndi][x]][i] != ndi)
                    set[i] = Color[ Set_Crs[ MCls[pnd] ][ Node_Course[ndi][x] ][i] ];
                else
                    set[i] = knew;
            }
            int flag = 0;
            int dayZ = 0;
            int  m_c = Weak_Day*Day_Crs;//35天=KCL
            for (i = 1; i <= Weak_Day; i++)
            {
                daycr[i] = 0;//课时
                daylt[i] = 0;//连堂课
            }

            for (i = 1; i <= len; i++)
                daycr[PDay[set[i]]]++;//每天上几节

            for (i = 1; i <= len; i++)
            {
                if(PCr[set[i]] >= Day_Crs_Mr)
                {
                    crsMr++;//上午的课时数增加
                }
                else
                {
                    crsAf++;//下午的课时数增加
                }
            }

            int gcls = MCls[pnd];
            int gcr = MCrs[pnd];
            int gvtx=(gcls-1)*Crs_Num+gcr;

            if (Class_Crs_Num_L[gcls][gcr] > 0)//如果存在连堂课
            {
                for (i = 1; i <= m_c; i++)
                    All_cl[i] = 0;
                for (i = 1; i <= len; i++)
                    All_cl[set[i]] = 1;
                len_lt = 0;
                for (i = 1; i < m_c; i++)
                    if ((All_cl[i] == 1) && (All_cl[i + 1] == 1) && (PCr[i] != Day_Crs) && (PCr[i] != Day_Crs_Mr))
                    {
                        len_lt++;//连堂课数量+1
                        dayZ = PDay[i];//属于哪一天
                        daylt[dayZ]++;//这一天的连堂课数量+1
                        i++;
                    }
                if (len_lt < Class_Crs_Num_L[gcls][gcr])//连堂课少了
                {
                    Class_Rst[pnd][1] = 1;//连堂课少了
                    Class_Weak[pnd][0][1]++;
                    f1 += 50 * (Class_Crs_Num_L[gcls][gcr] - len_lt);
                }
                if (len_lt > Class_Crs_Num_L[gcls][gcr])//连堂课多了
                {
                    Class_Rst[pnd][2] = 1;//连堂课多了
                    Class_Weak[pnd][0][2]++;
                    f1 += 50 * (len_lt - Class_Crs_Num_L[gcls][gcr]);
                }

                max = -9999;
                min = 9999;
                for (i = 1; i <= Weak_Day; i++)
                {
                    if (daycr[i] > max)//一天最多上几节
                    {
                        max = daycr[i];
                    }
                    if (daycr[i] < min)//一天最少上几节
                    {
                        min = daycr[i];
                    }

                }
                if (max - min > 2)
                    f1 += 60;

                for (i = 1; i <= Weak_Day; i++)
                    if (daylt[i] == 0)//如果这一天没有连堂课
                    {
                        if (daycr[i] > Max_Day[pnd])//判断有没有超多一天最大的节数
                        {
                            Class_Rst[pnd][3] = 1;//多上了
                            Class_Weak[pnd][i][3]=1;//星期几触发了
                            for (j = 1; j <= len; j++)
                            {
                                if (PDay[set[j]] == i)
                                {
                                    Class_Crs_Rst[gcls][i][PCr[set[j]]] = 3;//哪几节触发了
                                }

                            }
                            f1 += 20;
                        }
                        if (daycr[i] < Min_Day[pnd])
                        {
                            Class_Rst[pnd][4] = 1;//少上了
                            Class_Weak[pnd][i][4]=1;//星期几触发了
                            for (j = 1; j <= len; j++)
                            {
                                if (PDay[set[j]] == i)
                                {
                                    Class_Crs_Rst[gcls][i][PCr[set[j]]] = 4;//哪几节触发了
                                }
                            }
                            f1 += 10;
                        }
                    }

                if (Ctwo == 1)//如果需要优先排课
                    if (Cct[MCrs[pnd]] == 1)
                    {
                        for (i = 1; i <= len; i++)
                            if (PCr[set[i]] > C_Time)
                            {
                                f1 += 3;
                                Class_Rst[pnd][5] = 1;//没有优先排
                                Class_Weak[pnd][PDay[set[i]]][5]=1;//哪一天
                                //System.out.print(MCls[pnd]+"  "+MCrs[pnd]+"\n");
                                Class_Crs_Rst[gcls][PDay[set[i]]][PCr[set[i]]] = 5;//哪一节
                            }

                    }

                if (Crs_Attri[pnd] == 1)
                {
                    //System.out.print("进来了");
                    l = 0;
                    for (i = 1; i <= len; i++)
                        if (PCr[set[i]] == 1)
                            l++;
                    if (l >= maxk)//有一半排在第一节
                    {
                        f1 += 4;
                        Class_Rst[pnd][6] = 1;
                        for (j = 1; j <= len; j++)
                            if (PCr[set[j]] == 1)
                            {
                                Class_Crs_Rst[gcls][PDay[set[j]]][PCr[set[j]]] = 6;
                                Class_Weak[pnd][PDay[set[j]]][6]=1;
                            }
                    }
                }

                //课程上下午分布（课程上下午分布过于集中）
                if(crsMr > Max_Mr[pnd] || crsAf >Max_Af[pnd])
                {
                    f1 +=2;
                    Class_Rst[pnd][9] = 1;
                    for (j = 1; j <= len; j++)
                    {
                        Class_Crs_Rst[gcls][PDay[set[j]]][PCr[set[j]]] = 9;
                        Class_Weak[pnd][PDay[set[j]]][9]=1;
                    }
                }

            }
            else//没有连堂课
            {
                if (Ctwo == 1)
                    if (Cct[MCrs[pnd]] == 1)
                    {
                        for (i = 1; i <= len; i++)
                            if (PCr[set[i]] > C_Time)
                            {
                                f1 += 3;
                                Class_Rst[pnd][5] = 1;
                                Class_Crs_Rst[gcls][PDay[set[i]]][PCr[set[i]]] = 5;
                                Class_Weak[pnd][PDay[set[i]]][5]=1;
                            }

                    }

                for (i = 1; i <= Weak_Day; i++)
                {
                    if (daycr[i] > Max_Day[pnd])
                    {
                        f1 += 20;
                        Class_Rst[pnd][3] = 1;
                        Class_Weak[pnd][i][3]=1;
                        for (j = 1; j <= len; j++)
                        {
                            if (PDay[set[j]] == i)
                                Class_Crs_Rst[gcls][i][PCr[set[j]]] = 3;
                        }
                    }
                    if (daycr[i] < Min_Day[pnd])
                    {
                        f1 += 10;
                        Class_Rst[pnd][4] = 1;
                        Class_Weak[pnd][i][4]=1;
                        for (j = 1; j <= len; j++)
                        {
                            if (PDay[set[j]] == i)
                                Class_Crs_Rst[gcls][i][PCr[set[j]]] = 4;
                        }
                    }

                }

                if (Crs_Attri[pnd] == 3)//3天不能连上
                {
                    for (i = 1; i <= Weak_Day - 2; i++)
                        if ((daycr[i] > 0) && (daycr[i + 1] > 0) && (daycr[i + 2] > 0))
                        {
                            f1 += 2;
                            Class_Rst[pnd][7] = 1;
                            Class_Weak[pnd][i][7]=1;
                            Class_Weak[pnd][i+1][7]=1;
                            Class_Weak[pnd][i+2][7]=1;
                            for (j = 1; j <= len; j++)
                            {
                                if (PDay[set[j]] == i || PDay[set[j]] == i + 1 || PDay[set[j]] == i + 2)
                                    Class_Crs_Rst[gcls][PDay[set[j]]][PCr[set[j]]] = 7;
                            }
                        }
                }
                else if (Crs_Attri[pnd] == 2)//两天不能连上
                {
                    for (i= 1; i <= Weak_Day - 1; i++)
                        if ((daycr[i] > 0) && (daycr[i + 1] > 0))
                        {
                            f1 += 2;
                            Class_Rst[pnd][8] = 1;
                            Class_Weak[pnd][i][8]=1;
                            Class_Weak[pnd][i+1][8]=1;
                            for (j = 1; j <= len; j++)
                            {
                                if (PDay[set[j]] == i || PDay[set[j]] == i + 1)
                                    Class_Crs_Rst[gcls][PDay[set[j]]][PCr[set[j]]] = 8;
                            }
                        }
                }

                if (Crs_Attri[pnd] == 1)//对于一周上5节课的课程
                {
                    //System.out.print("进来了");
                    l = 0;
                    for (i = 1; i <= len; i++)
                        if (PCr[set[i]] == 1)//连续半周排第一节
                            l++;
                    if (l >= maxk)
                    {
                        f1 += 4;
                        Class_Rst[pnd][6] = 1;
                        for (j = 1; j <= len; j++)
                            if (PCr[set[j]] == 1)
                            {
                                Class_Crs_Rst[gcls][PDay[set[j]]][PCr[set[j]]] = 6;
                                Class_Weak[pnd][PDay[set[j]]][6]=1;
                            }
                    }
                }

                if(crsMr > Max_Mr[pnd] || crsAf >Max_Af[pnd])
                {
                    f1 +=2;
                    Class_Rst[pnd][9] = 1;
                    for (j = 1; j <= len; j++)
                    {
                        Class_Crs_Rst[gcls][PDay[set[j]]][PCr[set[j]]] = 9;
                        Class_Weak[pnd][PDay[set[j]]][9]=1;
                    }
                }

            }
        }
        return f1;
    }

    private int Last_Cal_JP_Score(int ndi, int knew, int t){
        int crs = Par[ndi];//是哪一门课
        int x,y,z;
        int i, j, k, f1, l, m, n, max_pre, min_l, min_c, max_c;
        f1 = 0;
        int[] Tea_set=new int[30];
        int[] maxc=new int[10 + 1];
        int[] minc=new int[10 + 1];
        int[] maxl=new int[10 + 1];
        int[] minl=new int[10 + 1];
        int len;
        int len_l;
        for (i = 1; i <= Set_cl[crs][0]; i++) //记录初始的状态
        {
            set[i] = Crs_srt_cl[crs][i];//这一门课的所有课
        }

        for (i = 1; i <= Set_cl[crs][0]; i++)
            if (Crs_srt_cl[crs][i] == Color[ndi])
            {
                Crs_srt_cl[crs][i] = knew;
                break;
            }//每个都着不同的色了已经
        bubble_sort(Crs_srt_cl[crs], Set_cl[crs][0]);//这门课重新排序

        for (x = 1; x <= Tea_CP_Sign[t][0]; x++)//一个老师的所有课
        {
            //循环次数太多
            len = 0;
            for (y = 1; y <= Tea_CP[t][0]; y++)
            {
                if (Tea_CP_Sign[t][y] == x)//属于需要比较的
                {
                    len++;
                    Tea_set[len] = Tea_CP[t][y];
                }
            }
            Tea_set[0] = len;//有多少门课
            int pnd = Tea_set[1];//新值

            if (Class_Crs_Num_L[MCls[pnd]][MCrs[pnd]] > 0)
            {
                len_l = 0;
                //第一种判定方式
                for (j = 1; j <= 10; j++)
                {
                    maxc[j] = -1;
                    minc[j] = 99999;
                }
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j]; //老师教的这门课，有几门课需要进行比较
                    l = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            l++;//每一次进入计数
                            if (Crs_srt_cl[k][i - 1] < minc[l])//第l次连课的第一节在什么时候上
                                minc[l] = Crs_srt_cl[k][i-1];
                            if (Crs_srt_cl[k][i] > maxc[l])//第l次连课的第二节在什么时候上
                                maxc[l] = Crs_srt_cl[k][i];
                            //break;
                        }
                    }
                    f1 = f1 + maxc[l] - minc[l] - 3;
                    if (len_l < l)
                    {
                        len_l = l;//有几次连堂课
                    }
                }


                int[] a=new int[30];
                l = 0;
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];//哪门课
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            a[i] = 1;//找出所有的连堂课
                            a[i - 1] = 1;
                        }
                    }
                    for (i = 1; i <= len_l; i++)//对于第一节课
                    {
                        for (m = 1; m <= Set_cl[pnd][0]; m++)
                        {
                            if ((a[m] == 0) && (Crs_srt_cl[k][m] < maxc[i]) && (Crs_srt_cl[k][m] > minc[i])) //非连堂课去进行判定//不该是这样去检验
                                l++;
                        }
                    }
                }
                if (l > 0)
                {
                    f1 = f1+3;
                    Tea_Rst[t][1] = 1;

                    k = Tea_set[j];//哪门课
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            a[i] = 1;//找出所有的连堂课
                            a[i - 1] = 1;
                        }
                    }
                    for (i = 1; i <= len_l; i++)//对于第一节课
                    {
                        for (m = 1; m <= Set_cl[pnd][0]; m++)
                        {
                            if ((a[m] == 0) && (Crs_srt_cl[k][m] < maxc[i]) && (Crs_srt_cl[k][m] > minc[i])) //处于连堂课之间的
                            {
                                Tea_Weak[t][PDay[Crs_srt_cl[k][m]]][1] = 1;
                                Tea_Crs_Rst[t][PDay[Crs_srt_cl[k][m]]][PCr[Crs_srt_cl[k][m]]] = 1;
                            }
                        }
                    }

                }
                else
                    f1 = f1+0;


                //第二种判定方式
                for (j = 1; j <= 10; j++)
                {
                    maxl[j] = -1;
                    minl[j] = 99999;
                }
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))
                        {
                            a[i] = 1;
                            a[i - 1] = 1;
                        }
                    }
                    l = 0;
                    for (i = 1; i <= len_l; i++)
                    {
                        for (m = 1; m <= Set_cl[pnd][0]; m++)
                        {
                            if ((a[m] == 0) && (Crs_srt_cl[k][m] < maxc[i])) //最后一节连堂课之前有几节课，一定要一样
                                l++;
                        }
                        if (l > maxl[i])
                            maxl[i] = l;
                        if (l < minl[i])
                            minl[i] = l;
                    }
                }
                for (i = 1; i <= len_l; i++)
                {
                    f1 = f1 + 2 * (maxl[i] - minl[i]);  //另一种判定方式，不同课连堂课之前上的课的数量
                    if(maxl[i] - minl[i]>0)
                    {
                        Tea_Rst[t][2] = 1;// 连堂课前后不平齐
                        Tea_Weak[t][0][2]++;
                    }
                }
                //教案平齐（没连堂的教案平齐和连堂教案平齐）
                if (Class_Crs_Num_L[MCls[pnd]][MCrs[pnd]] > 1)//多次连堂课
                {
                    min_l = 9999;
                    for (j = 1; j <= len; j++)
                    {
                        k = Tea_set[j];
                        for (i = 1; i <= Set_cl[pnd][0]; i++)
                            a[i] = 0;
                        for (i = 2; i <= Set_cl[pnd][0]; i++)
                        {
                            if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))//连堂课
                            {
                                a[i] = 1;
                                a[i - 1] = 1;
                            }
                        }
                        l = 0;
                        for (i = 1; i <= Set_cl[pnd][0]; i++)
                            if ((a[i] == 1))
                            {
                                l++;//l肯定是双数
                                JP_KC[j][l] = Crs_srt_cl[k][i];//记录连堂课
                            }
                        if (l < min_l)
                            min_l = l/2;//最少的连堂的有几节课/2
                    }
                    for (i = 1; i <= min_l-1; i++)//连堂课的节数，从第二节开始
                    {
                        max_c = -1;
                        min_c = 99999;
                        for (j = 1; j <= len; j++)
                        {
                            if (JP_KC[j][i*2+1] < min_c)
                                min_c = JP_KC[j][i*2+1];
                            if (JP_KC[j][i*2] > max_c)
                                max_c = JP_KC[j][i*2];//最早开始和最晚开始的两节课
                        }
                        if (min_c < max_c )//最早开始的要比前一节最晚开始的早，不对
                        {
                            f1 += 2;
                            Tea_Rst[t][5] = 1;
                            Tea_Weak[t][PDay[min_c]][5] = 1;
                            Tea_Weak[t][PDay[max_c]][5] = 1;
                            Tea_Crs_Rst[t][PDay[min_c]][PCr[min_c]] = 5;
                            Tea_Crs_Rst[t][PDay[max_c]][PCr[max_c]] = 5;
                        }

                    }
                }
                //进行非连堂课的教案平齐
                min_l = 9999;
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        a[i] = 0;
                    for (i = 2; i <= Set_cl[pnd][0]; i++)
                    {
                        if (((Crs_srt_cl[k][i] - Crs_srt_cl[k][i - 1]) == 1) && (PDay[Crs_srt_cl[k][i]] == PDay[Crs_srt_cl[k][i - 1]]))//非连堂课
                        {
                            a[i] = 1;
                            a[i - 1] = 1;
                        }
                    }
                    l = 0;
                    for (i = 1; i <= Set_cl[pnd][0]; i++)
                        if ((a[i] == 0))
                        {
                            l++;
                            JP_KC[j][l] = Crs_srt_cl[k][i];//没有连课的这几节
                        }
                    if (l < min_l)
                        min_l = l;//没连堂的有几节课
                }
                max_pre = -1;
                for (j = 1; j <= len; j++)
                {
                    if (JP_KC[j][1] > max_pre)
                        max_pre = JP_KC[j][1];//最晚开始的最早的一节课
                }

                for (i = 2; i <= min_l; i++)//连堂课的节数，从第二节开始
                {
                    max_c = -1;
                    min_c = 99999;
                    for (j = 1; j <= len; j++)
                    {
                        if (JP_KC[j][i] < min_c)
                            min_c = JP_KC[j][i];
                        if (JP_KC[j][i] > max_c)
                            max_c = JP_KC[j][i];//最早开始和最晚开始的两节课
                    }
                    if (min_c < max_pre || PDay[min_c] == PDay[max_pre])//最早开始的要比前一节最晚开始的早，不对
                    {
                        f1 += 2;
                        Tea_Rst[t][3] = 1;
                        Tea_Weak[t][PDay[min_c]][3] = 1;
                        Tea_Weak[t][PDay[max_pre]][3] = 1;
                        Tea_Crs_Rst[t][PDay[min_c]][PCr[min_c]] = 3;
                        Tea_Crs_Rst[t][PDay[max_pre]][PCr[max_pre]] = 3;
                    }
                    max_pre = max_c;//转换
                }
            }
            else
            {
                //如果不触发连堂课，直接判断教案平齐
                max_pre = -1;
                for (j = 1; j <= len; j++)
                {
                    k = Tea_set[j];
                    if (Crs_srt_cl[k][1] > max_pre)
                        max_pre = Crs_srt_cl[k][1];
                }
                for (i = 2; i <= Set_cl[pnd][0]; i++)
                {
                    max_c = -1;
                    min_c = 99999;
                    for (j = 1; j <= len; j++)
                    {
                        k = Tea_set[j];
                        if (Crs_srt_cl[k][i] < min_c)
                            min_c = Crs_srt_cl[k][i];
                        if (Crs_srt_cl[k][i] > max_c)
                            max_c = Crs_srt_cl[k][i];
                    }
                    if(Set_cl[pnd][0] <= Weak_Day){
                        if (min_c < max_pre || PDay[min_c] == PDay[max_pre])
                        {
                            //System.out.print("触发了教案不平齐" + "\n");
                            f1 += 3;
                            Tea_Rst[t][3] = 1;
                            Tea_Weak[t][PDay[min_c]][3] = 1;
                            Tea_Weak[t][PDay[max_pre]][3] = 1;
                            Tea_Crs_Rst[t][PDay[min_c]][PCr[min_c]] = 3;
                            Tea_Crs_Rst[t][PDay[max_pre]][PCr[max_pre]] = 3;
                        }
                    }else{
                        if ( min_c < max_pre )
                        {
                            //System.out.print("触发了教案不平齐" + "\n");
                            f1 += 3;
                            Tea_Rst[t][3] = 1;
                            Tea_Weak[t][PDay[min_c]][3] = 1;
                            Tea_Weak[t][PDay[max_pre]][3] = 1;
                            Tea_Crs_Rst[t][PDay[min_c]][PCr[min_c]] = 3;
                            Tea_Crs_Rst[t][PDay[max_pre]][PCr[max_pre]] = 3;
                        }
                    }

                    max_pre = max_c;
                }
            }

        }
        //算完之后回归原位
        for (i = 1; i <= Set_cl[crs][0]; i++)
        {
            Crs_srt_cl[crs][i] = set[i];//这个pnd不是原来的pnd了
        }
        return f1;
    }

    private void Out_Put_Erro_BTH(int Rslt[]){
        int i, j, k, m, l;
        for (i = 1; i <= N_vtx; i++)
        {
            Color[i] = Rslt[i];
        }
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Tea_Crs_Rst[i][j][k] = 0;
            }
        }

        for (i = 0; i <= Class_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Class_Crs_Rst[i][j][k] = 0;
            }
        }
        for (i = 0; i <= Class_Num*Crs_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= 9; k++)
                    Class_Weak[i][j][k] = 0;
            }
        }
        for (i = 0; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= 5; k++)
                    Tea_Weak[i][j][k] = 0;
            }
        }
        Clear_Delta_Matrix();
        Build_Delta_Matrix();

        f_best = f;

        fc = 0;
        for (i = 1; i <= MNum; i++)
        {
            m = Set_cl[i][1];
            Class_Score[i] = Last_Cal_Class_Score(m, Color[m]);
            fc += Class_Score[i];
            if (Class_Score[i] != 0)
            {
                System.out.print("可能不合理的课程 班级: " + Class.get(MCls[i]-1) + "班， 课程：" + MCrs[i] + " Score = " + Class_Score[i] + "\n");
            }

        }


        Sort_Src();
        for (i = 1; i <= Tea_Num; i++)
            Tea_JP_Score[i] = 0;
        for (i = 1; i <= MNum; i++)
        {
            m = Set_cl[i][1];//是哪一节课
            for (j = 1; j <= Node_Tea[m][0]; j++)
            {
                if (Node_Tea[m][j] > 0)
                {
                    Tea_JP_Score[Node_Tea[m][j]] = Last_Cal_JP_Score(m, Color[m], Node_Tea[m][j]);//哪位老师
                }
            }
        }

        for (i = 1; i <= Tea_Num; i++)
            if (Tea_JP_Score[i] != 0)
            {
                System.out.print( "可能教案不平齐的老师: " + Tea_ID.get(i-1) + " Score = " + Tea_JP_Score[i] + "\n");
            }


        set_tea_Src();

        for (i = 1; i <= Tea_Num; i++)
        {
            l = 0;
            for (j = 1; j <= Weak_Day; j++)
            {
                l += Tea_Scr[i][j];
                if(Tea_Scr[i][j]>0)
                {
                    Tea_Weak[i][j][4]=1;
                }
            }
            if (l > 0)
            {
                Tea_Rst[i][4]=1;
                System.out.print("可能时间不集中的老师: " + Tea_ID.get(i-1) + " Score = " + l + "\n");
            }

        }

        f_tea = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            f_tea += Tea_Score[i];
        }

        fc += f_tea;
        fc_best = fc;
        System.out.print("硬约束 f = " + f + " 软约束 fc = " + fc + "\n");

        for (i = 1; i <= Tea_Num; i++)
        {
            l = 0;
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++)
                {
                    if (Tea_Crs[i][j][k] != 0)
                    {
                        l++;
                    }
                }
            }
            Tea_Course_Num[i] = l;
            System.out.print("教师 " + Tea_ID.get(i-1) + " 一周上 " + Tea_Course_Num[i] + " 节课" + "\n");
        }
    }

    /*private void out_put_file(){
        int i, j, k, l, m, x, y;
        y = 0;
        String[] a= {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日" };
        String[] b ={ " ","第一节","第二节", "第三节", "第四节", "第五节", "第六节", "第七节", "第八节" };
        File Filename5 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\QZB\\time_class.csv");
        BufferedWriter outFile = null;
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(Filename5));
            outFile =  new BufferedWriter(write);
            outFile.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            for (i = 1; i <= Class_Num; i++)
            {
                outFile.write( Class.get(i-1) +"\n");
                for (j = 1; j <= Weak_Day; j++)
                {
                    outFile.write(a[j] + ",");
                    for (k = 1; k <= Day_Crs; k++)
                        if (Class_Crs[i][j][k] > 0)
                            outFile.write(Coursename.get(Class_Crs[i][j][k] - 1)+",");
                        else if (Class_Crs[i][j][k] == 0)
                            outFile.write(""+",");
                    outFile.write("\n");
                }
                outFile.write("\n");
            }
            outFile.flush();
            outFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        File Filename6 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\QZB\\time_teacher.csv");
        BufferedWriter outFile1 = null;
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(Filename6));
            outFile1 =  new BufferedWriter(write);
            outFile1.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            for (i = 1; i <= Tea_Num; i++) {
                outFile1.write(Tea_Name.get(i - 1) + "\n");
                outFile1.write("" + ",");
                for (j = 1; j <= Day_Crs; j++) {
                    outFile1.write(b[j] + ",");
                }
                outFile1.write("\n");
                for (j = 1; j <= Weak_Day; j++) {
                    outFile1.write(a[j] + ",");
                    for (k = 1; k <= Day_Crs; k++)
                        if (Tea_Crs[i][j][k] > 0 && Tea_Crs[i][j][k] < 100)
                        {
                            outFile1.write(Class.get(Tea_Crs[i][j][k] - 1) + "\\" );
                            outFile1.write(Coursename.get(Class_Crs[Tea_Crs[i][j][k]][j][k] - 1) + ",");
                        }
                        else if (Tea_Crs[i][j][k] >= 100)
                        {
                            Tea_Crs[i][j][k] = Tea_Crs[i][j][k] / 100;
                            for (x = 1; x <= Class_Num; x++)
                            {
                                if (Tea_Crs[i][j][k] == 0)
                                {
                                    break;
                                }
                                else
                                {
                                    y = Tea_Crs[i][j][k];
                                    outFile1.write(Class.get(Tea_Crs[i][j][k] % 100 - 1) + "\\");
                                    Tea_Crs[i][j][k] = Tea_Crs[i][j][k] / 100;
                                }
                            }
                            outFile1.write(Coursename.get(Class_Crs[y][j][k] - 1) + ",");
                        }
                        else
                            outFile1.write("" + ",");
                    outFile1.write("\n");
                }
            }
            outFile1.flush();
            outFile1.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        File Filename7 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\QZB\\time_stu.csv");
        BufferedWriter outFile2 = null;
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(Filename7));
            outFile2 =  new BufferedWriter(write);
            outFile2.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            for (i = 0; i < Stu_Num; i++)
            {
                outFile2.write("学号："+",");
                outFile2.write(Stu_ID[i]+","+",");
                outFile2.write("班级:"+","+ Class.get(Stu_Class[i][0]-1)+"\n");
                for (j = 1; j <= Weak_Day; j++)
                {
                    outFile2.write(a[j]+",");
                    for (k = 1; k <= Day_Crs; k++)
                        if (Stu_Crs[i][j][k] > 0)
                            outFile2.write(Coursename.get(Stu_Crs[i][j][k] - 1)+",");
                        else if (Stu_Crs[i][j][k] == 0)
                            outFile2.write(""+",");
                    outFile2.write("\n");
                }
                outFile2.write("\n");
            }
            outFile2.flush();
            outFile2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    private ResultOutput getResultData(){
        int i, j, k;
        int x, y, z;
        int l, m, n, o, p;
        int crs_id = 0;
        int class_id = 0;
        y = 0;
        ResultOutput outputData = new ResultOutput();

        double v = 0;
        int[] Class_Rst_V = { 0,0,0,0,0,0,0,0,0,0 };//小项
        int[] Tea_Rst_V = { 0,0,0,0,0,0 };
        int[] Class_V = { 0,0,0,0,0 };//大项
        int[] Tea_V = { 0,0,0,0 };
        int[][] DY_Class = { { 0,0,0,0 },{ 2,1,2,0 },{ 2,3,4,0 },{ 1,5,0,0 },{ 4,6,7,8,9 } };
        int[][] DY_Tea = { { 0,0,0 },{ 3,1,2,5 },{ 1,3,0 },{ 1,4,0 } };
        String[] a = { "","LTK_limit","Day_Crs_limit","Priority_class_limit","Weak_Crs_distributed" };
        String[] b = { "","LTK_JP","FLTK_JP","JZSK" };
        String[] a1 = { "","连堂课限制","日课时限制","优先排课限制","周课时分布" };
        String[] b1 = { "","连堂课教案平齐","非连堂课教案平齐","集中授课" };
        String[] c = { "","连堂课少上","连堂课多上","超出天最大限制","低于天最小限制","没有满足优先排","第一节安排过多","三天连上","两天连上" ,"上下午分布过于紧密"};
        String[] d = { "","两次连堂课之间有课","连堂课前后教案不平齐","普通课教案不平齐","授课不集中" ,"连堂课教案不平齐"};
        String[] w = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        for(i=1;i<=MNum;i++)
        {
            for(j=1;j<=Weak_Day;j++)
            {
                for(k=1;k<=9;k++)
                {
                    Class_Weak[i][0][k] += Class_Weak[i][j][k];//判断是否有触发
                }
            }
        }
        for(i=1;i<=Tea_Num;i++)
        {
            for(j=1;j<=Weak_Day;j++)
            {
                for(k=1;k<=5;k++)
                {
                    Tea_Weak[i][0][k]+=Tea_Weak[i][j][k];//判断是否有触发
                }
            }
        }

        for(i = 1; i <= MNum; i++)
        {
            for (j = 1; j <= 9; j++)
            {
                Class_Rst_V[j] += Class_Weak[i][0][j];//8条规则分别的值
            }
        }
        l = 0;
        for (i = 1; i <= 4; i++)
        {
            for (j = 1; j <= DY_Class[i][0]; j++)
            {
                Class_V[i] += Class_Rst_V[DY_Class[i][j]];//四条大规则的值
            }
            if (Class_V[i] > 0)
                l++;
        }
        for (i = 1; i <= Tea_Num; i++)
        {
            for (j = 1; j <= 5; j++)
            {
                Tea_Rst_V[j] += Tea_Weak[i][0][j];//5条规则分别的值
            }
        }
        m = 0;
        for (i = 1; i <= 3; i++)
        {
            for (j = 1; j <= DY_Tea[i][0]; j++)
            {
                Tea_V[i] += Tea_Rst_V[DY_Tea[i][j]];//三条大规则的值
            }
            if (Tea_V[i] > 0)
                m++;
        }
        for(i=1;i<=4;i++)//5条大规则
        {
            v+=100.0 - (Class_V[i] * 100.0) / (MNum*Weak_Day*1.0);
        }
        for(i=1;i<=3;i++)//3条大规则
        {
            v+=100.0 - (Tea_V[i] * 100.0)/ (Tea_Num*Weak_Day*1.0);
        }
        v=v/7;
        String Course_quality = v + "%";
        String Quality_description;
        if(v!=100)
        {
            Quality_description = "在排课规则中，班级不排课时间、课程不排课时间、教师不排课时间、合班课";
            for (i = 1; i <= 4; i++)
            {
                if (Class_V[i] == 0)
                {
                    Quality_description = Quality_description +"、" + a1[i];
                }
            }
            for (i = 1; i <= 3; i++)
            {
                if (Tea_V[i] == 0)
                {
                    Quality_description = Quality_description + "、" + b1[i];
                }
            }
            Quality_description = Quality_description + " 等规则的满足率为100%,";
            n = 0;
            for (i = 1; i <= 4; i++)
            {
                if (Class_V[i] > 0)//违反
                {
                    Quality_description = Quality_description + a1[i];
                    n++;
                    if (n == l + m)
                        break;
                    Quality_description = Quality_description + "、";
                }
            }
            for (i = 1; i <= 3; i++)
            {
                if (Tea_V[i] > 0)//违反
                {
                    Quality_description = Quality_description + b1[i];
                    n++;
                    if (n == l + m)
                        break;
                    Quality_description = Quality_description + "、";
                }
            }
            Quality_description = Quality_description + "等规则仍有不满足";
        }
        else
        {
            Quality_description = "所有条件都满足，排课质量为100%";
        }

        outputData.setCourseQuality(Course_quality);
        outputData.setQualityDescription(Quality_description);
        List<Rule> ruleList =  new ArrayList();
        for (i = 1; i <= 4; i++) {
            n = 0;
            Rule rule = new Rule();
            rule.setType(a[i]);
            rule.setSatisfctionRate((100.0 - (Class_V[i] * 100.0) / (MNum*Weak_Day*1.0)) + "%");
            List<Unsatisfaction> unsatisfactionList = new ArrayList();
            for (j = 1; j <= DY_Class[i][0]; j++)//对应几条小规则
            {
                for (k = 1; k <= MNum; k++)
                {
                    if(Class_Rst[k][DY_Class[i][j]] == 1)//一旦触发
                    {
                        Unsatisfaction unsatisfaction = new Unsatisfaction();
                        unsatisfaction.setClassID(Class.get(MCls[k] - 1));
                        unsatisfaction.setCourseID(CourseID.get(MCrs[k] - 1));
                        p = 0;
                        List<Integer> dayLists = new ArrayList();
                        for (y = 1; y <= Weak_Day; y++)
                        {
                            if(Class_Weak[k][y][DY_Class[i][j]]==1)//哪一天
                            {
                                dayLists.add(y);
                                p++;
                                if(p == Class_Weak[k][0][DY_Class[i][j]])
                                    break;
                            }
                        }
                        unsatisfaction.setDayLists(dayLists);
                        unsatisfaction.setRule(c[DY_Class[i][j]]);
                        unsatisfactionList.add(unsatisfaction);
                        n++;
                        if(n == Class_V[i])
                            break;
                    }
                }
            }
            rule.setUnsatisfactions(unsatisfactionList);
            List<ProblematicCrs> problematicCrsList = new ArrayList();
            for (j = 1; j <= DY_Class[i][0]; j++)
            {
                for (x = 1; x <= Class_Num; x++)
                {
                    for (y = 1; y <= Weak_Day; y++)
                    {
                        for (z = 1; z <= Day_Crs; z++)
                        {
                            if (Class_Crs_Rst[x][y][z] == DY_Class[i][j])
                            {
                                ProblematicCrs problematicCrs = new ProblematicCrs();
                                problematicCrs.setType("classRule");
                                problematicCrs.setClassID(Class.get(x-1));
                                problematicCrs.setDay(y);
                                problematicCrs.setCrs(z);
                                problematicCrsList.add(problematicCrs);
                            }
                        }
                    }
                }
            }
            rule.setProblematicCrsList(problematicCrsList);
            ruleList.add(rule);
        }

        for (i = 1; i <= 3; i++) {
            n = 0;
            Rule rule = new Rule();
            rule.setType(b[i]);
            rule.setSatisfctionRate((100.0 - (Tea_V[i] * 100.0) / (Tea_Num * Weak_Day * 1.0)) + "%");
            List<Unsatisfaction> unsatisfactionList = new ArrayList<Unsatisfaction>();
            for (j = 1; j <= DY_Tea[i][0]; j++) {
                for (k = 1; k <= Tea_Num; k++) {
                    if (Tea_Rst[k][DY_Tea[i][j]] == 1) {
                        Unsatisfaction unsatisfaction = new Unsatisfaction();
                        unsatisfaction.setTeaID(Tea_ID.get(k - 1));
                        p = 0;
                        List<Integer> dayLists = new ArrayList<Integer>();
                        for (y = 1; y <= Weak_Day; y++) {
                            if (Tea_Weak[k][y][DY_Tea[i][j]] == 1) {
                                dayLists.add(y);
                                p++;
                                if (p == Tea_Weak[k][0][DY_Tea[i][j]])
                                    break;
                            }
                        }
                        unsatisfaction.setDayLists(dayLists);
                        unsatisfaction.setRule(d[DY_Tea[i][j]]);
                        n++;
                        if (n == Tea_V[i])
                            break;
                    }
                }
            }
            rule.setUnsatisfactions(unsatisfactionList);
            List<ProblematicCrs> problematicCrsList = new ArrayList();
            for (j = 1; j <= DY_Tea[i][0]; j++)
            {
                for (x = 1; x <= Tea_Num; x++)
                {
                    for (y = 1; y <= Weak_Day; y++)
                    {
                        for (z = 1; z <= Day_Crs; z++)
                        {
                            if (Tea_Crs_Rst[x][y][z] == DY_Tea[i][j])
                            {
                                ProblematicCrs problematicCrs = new ProblematicCrs();
                                problematicCrs.setType("teaRule");
                                problematicCrs.setTeaID(Tea_ID.get(x-1));
                                problematicCrs.setDay(y);
                                problematicCrs.setCrs(z);
                                problematicCrsList.add(problematicCrs);
                            }

                        }
                    }
                }
            }
            rule.setProblematicCrsList(problematicCrsList);
            ruleList.add(rule);
        }
        outputData.setRules(ruleList);

        outputData.setWeakCrs(Weak_Day);
        List<ClassResultList> classResultLists = new ArrayList<ClassResultList>();
        for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Weak_Day; j++) {
                for (k = 1; k <= Day_Crs; k++) {
                    ClassResultList classResultList = new ClassResultList();
                    classResultList.setClassID(Class.get(i-1));
                    classResultList.setDay(j);
                    classResultList.setCrs(k);
                    if(Class_Crs[i][j][k]>0)
                    {
                        if(CourseID.get(Class_Crs[i][j][k]-1) > maxCourseID){
                            classResultList.setCourseID(XK_TargetCourse[i][CourseID.get(Class_Crs[i][j][k]-1)-maxCourseID]);
                        }else{
                            classResultList.setCourseID(CourseID.get(Class_Crs[i][j][k]-1));
                        }

                        if(Class_Tea[i][Class_Crs[i][j][k]] > 0)
                        {
                            classResultList.setTeaID(Tea_ID.get(Class_Tea[i][Class_Crs[i][j][k]]-1));
                        }
                        List<Integer> stuList = new ArrayList<Integer>();
                        for(x = 0;x<Stu_Num;x++)
                        {
                            crs_id = Stu_Crs[x][j][k];
                            if(Stu_Class[x][crs_id] == i){
                                stuList.add(Stu_ID[x]);
                            }
                        }
                        classResultList.setStuList(stuList);
                    }

                    classResultLists.add(classResultList);
                }
            }
        }
        outputData.setClassResultList(classResultLists);

        /*
        for (i = 1; i <= Tea_Num; i++)
        {
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++)
                    System.out.print(Tea_Crs[i][j][k]+" ");
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        */
        List<TeaResultList> teaResultLists = new ArrayList<TeaResultList>();
        for (i = 1; i <= Tea_Num; i++) {
            for (j = 1; j <= Weak_Day; j++) {
                for (k = 1; k <= Day_Crs; k++) {
                    if(Tea_Course_Num[i] > 0){
                        TeaResultList teaResultList = new TeaResultList();
                        teaResultList.setTeaID(Tea_ID.get(i-1));
                        //System.out.print("TeaName = " + Tea_Name.get(i-1));
                        teaResultList.setDay(j);
                        teaResultList.setCrs(k);
                        List<Integer> classIdLists = new ArrayList<Integer>();
                        if(Tea_Crs[i][j][k] > 0 && Tea_Crs[i][j][k] < 100)
                        {
                            classIdLists.add(Class.get(Tea_Crs[i][j][k] - 1));
                            if(CourseID.get(Class_Crs[Tea_Crs[i][j][k]][j][k]-1) > maxCourseID){
                                teaResultList.setCourseID(XK_TargetCourse[Tea_Crs[i][j][k]][CourseID.get(Class_Crs[Tea_Crs[i][j][k]][j][k]-1)-maxCourseID]);
                            }else{
                                teaResultList.setCourseID(CourseID.get(Class_Crs[Tea_Crs[i][j][k]][j][k]-1));
                            }

                        }
                        else if(Tea_Crs[i][j][k] >= 100)
                        {
                            Tea_Crs[i][j][k] = Tea_Crs[i][j][k] / 100;
                            for (x = 1; x <= Class_Num; x++)
                            {
                                if (Tea_Crs[i][j][k] == 0)
                                {
                                    break;
                                }
                                else
                                {
                                    y = Tea_Crs[i][j][k];
                                    classIdLists.add(Class.get(Tea_Crs[i][j][k] % 100 - 1));
                                    Tea_Crs[i][j][k] = Tea_Crs[i][j][k] / 100;
                                }
                            }
                            teaResultList.setCourseID(CourseID.get(Class_Crs[y][j][k] - 1));
                        }
                        teaResultList.setClassIdList(classIdLists);
                        teaResultLists.add(teaResultList);
                    }
                }
            }
        }
        outputData.setTeaResultList(teaResultLists);

        /*System.out.print("学生课表" + "\n");
        for (i = 0; i < Stu_Num; i++)
        {
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++){
                    if(Stu_Crs[i][j][k]>0){
                        //System.out.print(CourseID.get(Stu_Crs[i][j][k]-1)+" ");
                        System.out.print(Stu_Crs[i][j][k]+" ");
                    }
                    else{
                        System.out.print("    " + " ");
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }*/

        for(i=1;i<=Class_Num;i++){
            for(j=1;j<=Crs_Num;j++){
                System.out.print(Class_Tea[i][j] + " ");
            }
            System.out.print("\n");
        }

        List<StuResultList> stuResultLists = new ArrayList<StuResultList>();
        for(i = 0;i < Stu_Num;i++){
            for(j = 1;j <= Weak_Day;j++){
                for(k = 1;k <= Day_Crs;k++){
                    StuResultList stuResultList = new StuResultList();
                    stuResultList.setStuID(Stu_ID[i]);
                    crs_id = Stu_Crs[i][j][k];
                    if(crs_id > 0)
                    {
                        stuResultList.setCourseID(CourseID.get(crs_id-1));
                        //System.out.print("i = " + i + "j = " + j + "k =" + k + "crs=" + crs_id +" " + Stu_Class[i][crs_id] + "\n");
                        stuResultList.setClassID(Class.get(Stu_Class[i][crs_id]-1));
                        class_id = Stu_Class[i][crs_id];
                        //System.out.print(Stu_Class[i][crs_id] + "  "+Class_Tea[Stu_Class[i][crs_id]][Class_Crs[Stu_Class[i][crs_id]][j][k]] + "\n");
                        if(Class_Tea[class_id][Class_Crs[class_id][j][k]] > 0){
                             stuResultList.setTeaID(Tea_ID.get(Class_Tea[class_id][Class_Crs[class_id][j][k]] - 1));
                        }else{
                            stuResultList.setTeaID(0);
                        }

                    }
                    stuResultList.setDay(j);
                    stuResultList.setCrs(k);
                    stuResultLists.add(stuResultList);
                }
            }
        }
        outputData.setStuResultList(stuResultLists);
        return outputData;
    }

    public ResultOutput startArrageSceldue() throws MyException {
        startTime = System.currentTimeMillis();   //获取开始时间
        int i, j, k, minl, gl, l, flag = 0;
        check_kc();
        check_HBK();
        set_HB();
        set_CD();
        set_Stu();
        con_struct_graph();
        set_YPK();
        set_avbtime();
        set_crs_attrib();
        System.out.print("Begin");

        minl = 9999999;
        TTL = 2 * Class_Num;
        ini_tabu();
        for (k = 1; k <= 10; k++)
        {
            System.out.print("f=" + f + "\n");
            Get_Initial_solution(3000);
            l = 0;
            while (f != 0 && l<200)
            {
                if(System.currentTimeMillis() - startTime > 600000){
                    throw new MyException("排课超时，请检查数据是否正确或联系客服人员");
                }
                Get_Initial_solution(3000);
                System.out.print("f=" + f + "\n");
                System.out.print("l =" + l + "\n");
                l++;
            }
            if(l >= 200)
            {
                if( flag == 0)
                {
                    System.out.print("由隐性冲突造成的可排课时间小于总课时，请减少部分约束");
                    throw new MyException( "由隐性冲突造成的可排课时间小于总课时，请减少部分约束");
                }
                else if(flag == 1)
                {
                    break;
                }
            }
            gl = Compoud_Tabu_Search_JP(5000);//教案平齐
            gl = Compoud_Tabu_Search_BTH(10000);//集中排课
            if (gl < minl)
            {
                minl = gl;
                flag = 1;
                for (i = 1; i <= N_vtx; i++)
                    Final_Color[i] = Best_Color[i];
            }
            System.out.print("|--------------| minl = " + minl + " |---------| gl = " + gl + "\n");
            if(System.currentTimeMillis() - startTime > 600000){
                throw new MyException("排课超时，请检查数据是否正确或联系客服人员");
            }
        }
        if (flag == 0)
        {
            throw new MyException("生成的方案是非法方案，约束太多导致,请减少约束");
        }
        for (i = 1; i <= N_vtx; i++)
            Color[i] = Final_Color[i];

        get_result();
        //out_put_file();
        Out_Put_Erro_BTH(Final_Color);
        get_result();
        System.out.print(System.currentTimeMillis() - startTime + "\n");
        return getResultData();

    }



}
