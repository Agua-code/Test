package ZBPK_NKC;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.Collator;
import java.util.Locale;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.Random;
import java.lang.Math;


public class nkcGraphcolor  {
    //基本信息数据结构
    int Crs_Num = 0;
    int Class_Num = 0;
    int Tea_Num = 0;
    int KCL = 0;//一周多少节课
    int Weak_Day = 0;
    int Day_Crs = 0;
    int Day_Crs_Mr = 0;
    int Day_Crs_Af = 0;
    int PDay[] = null;
    int PCr[]= null;
    int MCls[]= null;
    int MCrs[]= null;
    int Class_Crs_CD[][]= null;
    int Min_Day[]= null;
    int Max_Day[]= null;
    int LTK_Week[]= null;//课程每周的节数
    int Crs_Attri[]= null;
    int Tct[]= null;//是否集中排课
    int Vtx_len = 0;
    //课表数据结构
    int Class_Crs[][][]= null;//班级课表
    int Tea_Crs[][][]= null;//教师课表
    int Stu_Crs[][][]= null;//学生课表
    //int Key_Stu_Crs[][][]= null;//重点班学生课表
    //排课时间限制数据结构
    int Class_AvrT[][][]= null;
    int Tea_AvrT[][][]= null;
    int Crs_AvrT[][][]= null;
    int AVB_Cl[][]= null;
    //图着色数据结构
    int MNum = 0;
    int N_vtx = 0;
    int Edge[][]= null;
    int A_Matrix[][]= null;
    int Set_cl[][]= null;
    int Set_Crs[][][]= null;
    int Par[]= null;
    int Node_Tea[][]= null;
    int Node_Stu[][] = null;
    int Node_Course[][]= null;
    int Node_Class[][]= null;
    int Node_Avb[][]= null;
    int Tea_CP[][]= null;
    int Synthesis_Node[]= null;//合成点
    int Synthesis_Node_Num = 0;//合成数量
    int Tea_CP_Sign[][]= null;//教师教的课程的标记
    int Color[]= null;
    int Initial_Color[]= null;
    int Best_Color[]= null;
    int Final_Color[]= null;
    int Node_Tea_Sign[]= null;
    //检验课表优劣数组
    int Day_Set[] = null;
    int set[] = null;
    int Class_Score[]= null;//班级课表优劣
    int Tea_JP_Score[]= null;//教师课表优劣
    int Tea_Score[]= null;//二次教师课表优劣
    int TScr[]= null;
    int Tea_Scr[][]= null;
    int daycr[]= null;
    int daylt[]= null;
    int All_cl[]= null;//一周内课程的分布情况
    int Ctwo = 0;
    int C_Time = 0;
    int Cct[] = null;
    int Btwo_Course[]= null;//每一门课的开关
    int Crs_srt_cl[][]= null;
    int JP_KC[][]= null;
    //tabu搜索数据结构
    int tabuh[]= null;
    int TTL = 0;
    int f = 0;
    int f_crs = 0;
    int f_tea = 0;
    int f_best = 0;
    int fc = 0;
    int fc_best = 0;
    int Delta_Matrix[][]= null;
    int TabuTenure[][]= null;
    int best_x[]= null;
    int best_v[]= null;
    int Delta_Crs[][]= null;
    int Delta_Tpj[][]= null;
    int Delta_Ttm[][]= null;
    int dgl[]= null;
    //合班课数据结构
    int HBK_Num = 0;
    int HBK[][]= null;
    int HBK_C[]= null;
    int Class_Crs_HEBAN[][]= null;
    //课程信息数据结构
    ArrayList< ArrayList<String> > Tname = null;//任课教师二维表
    ArrayList< ArrayList<String> > Cnumber = null;//课程数量二维表
    ArrayList<String> Coursename = null;//课程名字
    ArrayList<String> Grade = null;//年级
    ArrayList<String> Class = null;//班级
    ArrayList<String> Tea_Name = null;

    int Class_Crs_Num[][]= null;
    int Class_Crs_Num_L[][]= null;
    int Class_Tea[][]= null;
    //学生信息数据结构
    int Stu_Num = 0;
    //int Key_Stu_Num = 0;
    int Stu_ID[]= null;
    int Stu_Class[]= null;
    ArrayList<String> Stu_Course= null;

    //选考课数据结构
    int XK_Class_Set[] = null;
    int XK_Tea_Set[]= null;
    int XK_Stu_Set[]= null;
    //单双周数据结构
    int DSZ_Num = 0;
    int DSZ[][]= null;
    int DS = 0;
    //预排课数据结构
    int YPK_Num[]= null;
    int YPK[]= null;
    //课程检查数据结构
    int Class_Rst[][];
    int Tea_Rst[][];
    int Class_Crs_Rst[][][];
    int Tea_Crs_Rst[][][];
    int Class_Weak[][][];
    int Tea_Weak[][][];

    Collator co = Collator.getInstance(Locale.CHINA);
    Random rand = new Random();

    public nkcGraphcolor() throws IOException {
        read_data1();//第一次输入
        int i, j, k, l, m;
        Class_Crs_HEBAN = new int[Class_Num + 1][Crs_Num + 1];

        for (i = 1; i <= Class_Num; i++)
            for (j = 1; j <= Crs_Num; j++)
                Class_Crs_HEBAN[i][j] = i;

        XK_Stu_Set = new int[Class_Num + 2];
        XK_Class_Set = new int[Class_Num + 2];
        //ZB_Stu_Set = new int[Class_Num * Class_Num];
        //ZB_Tea_Set = new int[Tea_Num + 1];
        Class_Crs_CD = new int[Class_Num + 1][Crs_Num + 1];
        Tea_CP = new int [Tea_Num + 1][Class_Num + 1];//教师教了哪几个班？
        Tea_CP_Sign = new int [Tea_Num + 1][Class_Num + 1];//教师教了哪几个班？

        System.out.print("Class_Num="+Class_Num + "\n");

        Class_Crs = new int [Class_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Tea_Crs = new int [Tea_Num + 1][Weak_Day + 1][Day_Crs + 1];
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
        Class_Crs_Rst = new int [Class_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Tea_Crs_Rst = new int [Tea_Num + 1][Weak_Day + 1][Day_Crs + 1];
        Class_Weak = new int [Class_Num*Crs_Num + 1][Weak_Day + 1][8 + 1];
        Tea_Weak = new int [Tea_Num + 1][Weak_Day + 1][5 + 1];


        //ZBK = new int[Class_Num*Class_Num + 1][3 + 1];
        //ZBK_C = new int[Class_Num*Class_Num + 1];
        /////////////////////////////////////////////////////////////
        l = Class_Num*Crs_Num + 1;//节点数
        m = Weak_Day*Day_Crs + 1;//着色数
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

        Set_cl = new int [l + 1][m];
        Set_Crs = new int[Class_Num + 1][Crs_Num + 1][m];

        Crs_srt_cl = new int [l + 1][m];

        Node_Tea = new int[Vtx_len + 1][Tea_Num + 1];//教师属性
        Node_Stu = new int[Vtx_len + 1][Class_Num*Class_Num + 1];//学生属性
        Node_Course = new int[Vtx_len + 1][2 + 1];//课程属性

        Node_Class = new int[Vtx_len + 1][Class_Num + 1];//班级属性
        Node_Avb = new int[Vtx_len + 1][m];

        Edge = new int[Vtx_len + 1][Vtx_len + 1];
        Node_Tea_Sign = new int[Vtx_len + 1];
        Day_Set = new int[Weak_Day + 1];
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
        read_data2();//第二次读取数据
        Stu_Crs = new int [Stu_Num + 1][Weak_Day + 1][Day_Crs + 1];
        //Key_Stu_Crs = new int [Key_Stu_Num + 1][Weak_Day + 1][Day_Crs + 1];
        for (i = 0; i <= Stu_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Stu_Crs[i][j][k] = 0;
            }
        }
        /*
        for (i = 0; i <= Key_Stu_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                    Key_Stu_Crs[i][j][k] = 0;
            }
        }
        */
    }
    public void read_data1() throws IOException{
        int i, j, k, l, m, n;
        int T_k = 0;
        Coursename = new ArrayList();
        Grade = new ArrayList();
        Class = new ArrayList();
        Tname = new ArrayList<>();
        Cnumber = new ArrayList<>();
        Tea_Name = new ArrayList<>();
        //读取第一个文件
        File Filename1 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\kebiao.csv");
        BufferedReader inFile = null;
        FileInputStream in = new FileInputStream(Filename1);
        // 指定读取文件时以UTF-8的格式读取
        inFile = new BufferedReader(new UnicodeReader(in, Charset.defaultCharset().name()));


        try{
            String line = null;//一行
            line=inFile.readLine();
            String field;
            String item[]=line.split(",");
            System.out.print("length=" + item.length);
            for(i = 0;i < item.length; i++){
                System.out.print(item[i] + "  ");
                field = item[i];
                if (co.compare(field ,"年级") == 0|| co.compare(field,"班级") == 0 || co.compare(field,"") == 0){
                    continue;
                }
                else{
                    Coursename.add(field);
                    Crs_Num++;
                    System.out.print("Crs_Num=" + Crs_Num);
                }
            }
            System.out.print(Coursename.size()+"\r\n");
            for(i=0;i<Coursename.size();i++)
            {
                //System.out.print("进来了");
                System.out.print(Coursename.get(i)+"  ");
            }

            for (i = 0; i < Crs_Num; i++){
                /*
                if (co.compare(Coursename.get(i) , "走一")==0){//找到走一是第几行
                    CM = i + 1;//CM是走一课
                }
                */
                if (co.compare(Coursename.get(i) , "单双周")==0){//找到走一是第几行
                    DS = i + 1;//CM是走一课
                }
            }

            while((line=inFile.readLine())!=null) {

                ArrayList<String> Teachername = new ArrayList();//任课教师姓名*
                ArrayList<String> Courseweeknumber = new ArrayList();//课程数量*

                String item1[] = line.split(",");
                Grade.add(item1[0]);
                Class.add(item1[1]);
                Class_Num++;//每一个班级
                for (i = 2; i < item1.length; i++) {
                    field = item1[i];
                    if (i % 2 == 0)//偶数
                    {
                        Teachername.add(field);//将刚刚读取的字符串添加到向量fields中
                    } else if (i % 2 == 1) {
                        Courseweeknumber.add(field);//将刚刚读取的字符串添加到向量fields中
                    }
                }
                Tname.add(Teachername);//存入二维表
                Cnumber.add(Courseweeknumber);

            }

            inFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("成功了！！"+ "\r\n");

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
                Class_Tea[i][j] = -1;

        String str;
        String str0;
        String str2;
        for (i = 0; i<Class_Num; i++)//暂时为1
        {
            for (j = 0; j<Crs_Num; j++)
            {
                //System.out.print(Cnumber.get(i).get(j));
                if (Cnumber.get(i).get(j).length() == 3)//存在连课选项
                {
                    str = Cnumber.get(i).get(j);
                    str0 = String.valueOf(str.charAt(0));
                    str2 = String.valueOf(str.charAt(2));

                    Class_Crs_Num[i + 1][j + 1] = Integer.parseInt(str0) + Integer.parseInt(str2) * 2;
                    Class_Crs_Num_L[i + 1][j + 1] = Integer.parseInt(str2);

                }
                else
                {
                    str = Cnumber.get(i).get(j);
                    str0 = String.valueOf(str.charAt(0));
                    Class_Crs_Num[i + 1][j + 1] = Integer.parseInt(str0);
                    Class_Crs_Num_L[i + 1][j + 1] = 0;
                }
            }
        }
        k = 1;//老师从1开始编号
        for (i = 0; i<Class_Num; i++)//班级数
        {
            for (j = 0; j<Crs_Num; j++)
            {
                l = 0;
                str = Tname.get(i).get(j);
                for (int x = 0; x<i*Crs_Num + j; x++)
                {
                    m = x / Crs_Num;
                    n = x%Crs_Num;
                    if (co.compare(str ,Tname.get(m).get(n)) == 0 && co.compare(str, "") == 1)//相同
                    {
                        T_k = Class_Tea[m + 1][n + 1];//相同则是同一个老师
                        l = 2;
                        break;
                    }
                    else if (co.compare(str ,"无") == 0)
                    {
                        T_k = -1;//自习课教师是-1
                        l = 1;
                        break;
                    }
                    else if (co.compare(str ,"待定1") == 0)
                    {
                        T_k = -2;//选考课
                        l = 1;
                        break;
                    }
                    else if (co.compare(str ,"") == 0)
                    {
                        T_k = 0;
                        l = 1;
                        break;
                    }
                    else if (co.compare(str ,"待定2") == 0)
                    {
                        T_k = -20;
                        l = 1;
                        break;
                    }
                    else if (co.compare(str ,"待定3") == 0)
                    {
                        T_k = -200;
                        l = 1;
                        break;
                    }
                }
                if (l == 0)
                {
                    T_k = k++;
                    Tea_Name.add(Tname.get(i).get(j));//教师名字与编号对应

                }
                Class_Tea[i + 1][j + 1] = T_k;//班级课程所对应的教师编号
            }
        }
        Tea_Num = k - 1;

        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Crs_Num; j++)
            {
                System.out.print(Class_Tea[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print(Tea_Num+"\n");
        //////////////////////////////////////////////////////////////
        Cct = new int[Crs_Num + 1];//优先排课
        for (i = 0; i <= Crs_Num; i++)
            Cct[i] = 0;
        Tct = new int[Tea_Num + 1];//教师集中排课
        for (i = 0; i <= Tea_Num; i++)
            Tct[i] = 1;
        //读取第二个文件
        File Filename2 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\data_kebiao.txt");
        BufferedReader FIC = null;
        in = new FileInputStream(Filename2);
        // 指定读取文件时以UTF-8的格式读取
        FIC = new BufferedReader(new UnicodeReader(in, Charset.defaultCharset().name()));
        try{
            String line = null;//一行
            line=FIC.readLine();
            String field;
            String item[]=line.split("\\s+");
            Weak_Day = Integer.parseInt(item[0]);
            Day_Crs_Mr  = Integer.parseInt(item[1]);
            Day_Crs_Af = Integer.parseInt(item[2]);
            Day_Crs = Day_Crs_Mr + Day_Crs_Af;
            KCL = Weak_Day*Day_Crs;
            System.out.print( " Weak_Day = " + Weak_Day +" Day_Crs_Mr = ");
            System.out.print( Day_Crs_Mr + " Day_Crs_Af = " + Day_Crs_Af + " Day_Crs = " + Day_Crs+"\n" );
            ////////////////////////////////////////////////////////
            Class_AvrT = new int [Class_Num + 1][Weak_Day + 1][Day_Crs + 1];
            Tea_AvrT = new int [Tea_Num + 1][Weak_Day + 1][Day_Crs + 1];
            Crs_AvrT = new int [Crs_Num + 1][Weak_Day + 1][Day_Crs + 1];
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
            System.out.print("Crs_Num =" + Crs_Num + "\n");
            while((line=FIC.readLine()).equals(""))
            {
            }
            if(co.compare(line,"start")==0)
            {
                while (1>0)
                {
                    line=FIC.readLine();
                    String item1[]=line.split("\\s+");
                    if(co.compare(item1[0],"course")==0)
                    {
                        m = Integer.parseInt(item1[1]);
                        for (j = 1; j <= Weak_Day; j++)
                        {
                            String item2[] = FIC.readLine().split("\\s+");
                            //System.out.print(item1[k-1]);
                            for (k = 1; k <= Day_Crs; k++)
                            {
                                n = Integer.parseInt(item2[k-1]);
                                Crs_AvrT[m][j][k] = n;
                                if (n != 0 && n != 1)
                                {
                                    System.out.print("课程0-1数据有问题，请检查数据 n = " + n + "\n");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                    if(co.compare(item1[0],"teacher")==0)
                    {
                        m = Integer.parseInt(item1[1]);
                        Tct[m] = Integer.parseInt(item1[2]);

                        for (j = 1; j <= Weak_Day; j++)
                        {
                            String item2[] = FIC.readLine().split("\\s+");
                            for (k = 1; k <= Day_Crs; k++)
                            {
                                n = Integer.parseInt(item2[k-1]);
                                Tea_AvrT[m][j][k] = n;
                                if (n != 0 && n != 1)
                                {
                                    System.out.print("教师0-1数据有问题，请检查数据 n = " + n + "\n");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                    if(co.compare(item1[0],"class")==0)
                    {
                        m = Integer.parseInt(item1[1]);
                        for (j = 1; j <= Weak_Day; j++)
                        {
                            String item2[] = FIC.readLine().split("\\s+");
                            //System.out.print(item1[k-1]);
                            for (k = 1; k <= Day_Crs; k++)
                            {
                                n = Integer.parseInt(item2[k-1]);
                                Class_AvrT[m][j][k] = n;
                                if (n != 0 && n != 1)
                                {
                                    System.out.print("班级0-1数据有问题，请检查数据 n = " + n + "\n");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                    if(co.compare(item1[0],"end")==0)
                    {
                        break;
                    }
                }
            }
            while((line=FIC.readLine()).equals(""))
            {
            }
            //优先排课
            Ctwo = Integer.parseInt(line);
            if (Ctwo == 1)
            {
                String item1[]=FIC.readLine().split("\\s+");
                m = Integer.parseInt(item1[0]);
                for (i = 1; i <= m; i++)
                {
                    n = Integer.parseInt(item1[i]);
                    Cct[n] = 1;
                }
                C_Time = Integer.parseInt(FIC.readLine());
            }
            while((line=FIC.readLine()).equals(""))
            {
            }
            //合班课
            HBK_Num = Integer.parseInt(line);
            System.out.print("HBK_Num = "+ HBK_Num +"\n");
            HBK = new int[Class_Num * 2 + 1][Class_Num + 1];
            HBK_C = new int[Class_Num * 2 + 1];
            if (HBK_Num > 0)
            {
                for (i = 1; i <= HBK_Num; i++)
                {
                    String item1[] = FIC.readLine().split("\\s+");
                    HBK_C[i] = Integer.parseInt(item1[0]);
                    HBK[i][0] = Integer.parseInt(item1[1]);
                    String item2[] = FIC.readLine().split("\\s+");
                    for (j = 1; j <= HBK[i][0]; j++)
                    {
                        HBK[i][j] = Integer.parseInt(item2[j-1]);
                    }
                }
            }
            while((line=FIC.readLine()).equals(""))
            {
            }
            ///选考课
            XK_Tea_Set = new int[Tea_Num + 1];
            XK_Tea_Set[0] = Integer.parseInt(line);
            if (XK_Tea_Set[0] > 0)
            {
                String item1[] = FIC.readLine().split("\\s+");
                for (i = 1; i <= XK_Tea_Set[0]; i++)
                {

                    XK_Tea_Set[i] = Integer.parseInt(item1[i-1]);
                    if (XK_Tea_Set[i] > Tea_Num || XK_Tea_Set[i] < -2)
                    {
                        System.out.print("老师编号有问题，请检查数据"  + "\n");
                        System.exit(0);
                    }

                }
            }
            for (i = 0; i <= XK_Tea_Set[0]; i++)
                System.out.print(XK_Tea_Set[i]  + " ");
            System.out.print("\n");
            while((line=FIC.readLine()).equals(""))
            {
            }
            //单双周
            DSZ_Num = Integer.parseInt(line);
            System.out.print("DSZ_Num="  + DSZ_Num + "\n");
            DSZ = new int[DSZ_Num + 2][2 + 1];
            if (DSZ_Num>0)
            {
                for (i = 1; i <= DSZ_Num; i++)
                {
                    String item1[] = FIC.readLine().split("\\s+");
                    DSZ[i][1] = Integer.parseInt(item1[0]);
                    DSZ[i][2] = Integer.parseInt(item1[1]);
                }
            }
            while((line=FIC.readLine()).equals(""))
            {
            }
            if(line=="pstart")
            {
                //预排课
                while (1>0)
                {
                    String item1[] = FIC.readLine().split("\\s+");
                    if (item1[0] == "class")//班级
                    {
                        m = Integer.parseInt(item1[1]);
                        for (j = 1; j <= Weak_Day; j++)
                        {
                            String item2[] = FIC.readLine().split("\\s+");
                            for (k = 1; k <= Day_Crs; k++)
                            {
                                n = Integer.parseInt(item2[k-1]);
                                Class_Crs[m][j][k] = n;
                            }
                        }
                    }
                    else if (item1[0] == "pend")
                    {
                        break;
                    }
                }
            }



            FIC.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }//读取数据
    public void read_data2()throws IOException{
        int i,j, k, m, n;
        Stu_Course = new ArrayList<>();
        //Key_Stu_Move_Course= new ArrayList<>();
        //Key_Stu_Course= new ArrayList<>();
        //走班
        /*
        File Filename3 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\Output4.csv");
        BufferedReader inFile = null;
        FileInputStream in = new FileInputStream(Filename3);
        // 指定读取文件时以UTF-8的格式读取
        inFile = new BufferedReader(new UnicodeReader(in, Charset.defaultCharset().name()));

        try{
            String line = null;//一行
            inFile.readLine();
            while((line=inFile.readLine())!=null){
                String item[]=line.split(",");
                ZBK[ZBK_Num][1] = Integer.parseInt(item[0]);
                ZBK[ZBK_Num][2] = Integer.parseInt(item[1]);
                for (i = 0; i<Crs_Num; i++)
                {
                    if (co.compare(item[2] , Coursename.get(i))==0)
                    {
                        ZBK_C[ZBK_Num] = i + 1;
                    }
                }
                ZBK_Num++;
            }
            for (i = 0; i<ZBK_Num; i++)
            {
                System.out.print( ZBK[i][1] + " " + ZBK[i][2] + " " + ZBK_C[i] + "\n");
            }
            inFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        */
        //学生信息
        Stu_ID = new int[10000];
        Stu_Class = new int[10000];//10000个学生
        //Key_Stu_ID = new int[10000];
        //Key_Stu_Class = new int[10000];//10000个学生
        Stu_Num = 0;
        //Key_Stu_Num = 0;
        File Filename4 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\stu_data.csv");
        BufferedReader inFile_stu = null;
        FileInputStream in = new FileInputStream(Filename4);
        // 指定读取文件时以UTF-8的格式读取
        inFile_stu = new BufferedReader(new UnicodeReader(in, Charset.defaultCharset().name()));

        try{
            String line = null;//一行
            while((line=inFile_stu.readLine())!=null){
                String item[]=line.split(",");
                if (co.compare(item[0] , "0")==0)
                {
                    //学号
                    Stu_ID[Stu_Num] = Integer.parseInt(item[1]);
                    //班级
                    Stu_Class[Stu_Num] = Integer.parseInt(item[2]);
                    //课程
                    Stu_Course.add(item[3]);
                    Stu_Num++;
                }
                /*
                else if (co.compare(item[0] , "1")==0)
                {
                    //学号
                    Key_Stu_ID[Key_Stu_Num] = Integer.parseInt(item[1]);
                    //班级
                    Key_Stu_Class[Key_Stu_Num] = Integer.parseInt(item[2]);
                    //走一
                    Key_Stu_Move_Course.add(item[3]);
                    //走二
                    Key_Stu_Course.add(item[4]);
                    Key_Stu_Num++;
                }
                */
            }
            inFile_stu.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }//第二次读取数据

    public void check_kc(){
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
            }
            if (l > ll)
            {
                System.out.print("班级 " + i + " 课程数量超标，请检查 ll = " + l + "\n" );
                System.exit(0);
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
            //cout << "l = " << l << " ll = " << ll << endl;
            if (l > ll)
            {
                System.out.print("老师 " + t + "课程数量超标，请检查" + "\n");
                System.exit(0);
            }
        }

    }
    public void check_HBK(){
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
                    System.out.print("存在合班课老师不一致的情况");
                    System.exit(0);
                }
            }
        }
    }

    public void set_HB(){
        int j, k, l, m, bn;
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

    }//设置合班课
    public void set_XK(){
        int i, j, k, l;
        //设置选考课
        l = 0;
        k = 1;
        for (i = 1; i <= Class_Num; i++)
            for (j = 1; j <= Crs_Num; j++)
                if ((Class_Tea[i][j] == -2) && (Class_Crs_Num[i][j] > 0))
                {
                    if (k == 1)
                    {
                        k = 0;
                        Class_Crs_HEBAN[i][j] = 50000;
                        l++;
                        XK_Class_Set[l] = i;
                    }
                    else
                    {
                        Class_Crs_Num[i][j] = 0;
                        l++;
                        XK_Class_Set[l] = i;
                    }
                }
        XK_Class_Set[0] = l;//
    }//设置选考课
    /*
    public void set_ZB(){
        int  i, j, k, l, m, bn, first_CN;
        //设置走一课
        m = ZBK[0][1];//原班级
        k = ZBK_C[0];//课程
        l = ZBK[0][2];//插入班级
        ZB_Stu_Set[1] = m;
        ZB_Stu_Set[2] = l;
        ZB_Tea_Set[1] = Class_Tea[l][k];
        System.out.print("m= " + m + " k=" + k + " l=" + l + "\n" );
        first_CN = Class_Crs_Num[m][CM];//防止变为0
        Class_Crs_HEBAN[m][CM] = -50000;
        Class_Crs_Num[l][k] = 0;//把课时设为0了
        for (bn = 1; bn <ZBK_Num; bn++)
        {
            m = ZBK[bn][1];//原班级
            k = ZBK_C[bn];//课程
            l = ZBK[bn][2];//插入班级
            System.out.print("m= " + m + " k=" + k + " l=" + l + "\n" );
            Class_Crs_Num[m][CM] = 0;
            Class_Crs_Num[l][k] = 0;//把课时设为0了
            ZB_Stu_Set[bn * 2 + 1] = m;
            ZB_Stu_Set[bn * 2 + 2] = l;
            ZB_Tea_Set[bn + 1] = Class_Tea[l][k];
        }
        ZB_Stu_Set[0] = ZBK_Num * 2;
        ZB_Tea_Set[0] = ZBK_Num;
        m = ZBK[0][1];//原班级
        k = ZBK_C[0];//课程
        l = ZBK[0][2];//插入班级
        Class_Crs_Num[m][CM] = first_CN;//防止变为0
        for (i = 2; i <= ZBK_Num * 2; i++)
        {
            for (j = 1; j < i; j++)
            {
                if (ZB_Stu_Set[i] == ZB_Stu_Set[j])
                {
                    ZB_Stu_Set[i] = 0;
                }
            }
        }
        l = 0;
        for (i = 1; i <= ZBK_Num * 2; i++)
        {
            if (ZB_Stu_Set[i] != 0)
            {
                l++;
                ZB_Stu_Set[l] = ZB_Stu_Set[i];
            }

        }
        ZB_Stu_Set[0] = l;
        for (i = 2; i <= ZBK_Num; i++)
        {
            for (j = 1; j < i; j++)
            {
                if (ZB_Tea_Set[i] == ZB_Tea_Set[j])
                {
                    ZB_Tea_Set[i] = 0;
                }
            }
        }
        l = 0;
        for (i = 1; i <= ZBK_Num; i++)
        {
            if (ZB_Tea_Set[i] != 0)
            {
                l++;
                ZB_Tea_Set[l] = ZB_Tea_Set[i];
            }

        }
        ZB_Tea_Set[0] = l;
    }//设置走班课
    */
    public void set_CD(){
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
                    //KM_Tea[ l ] = Class_Tea[ i ][ j ];//是哪个老师
                }
                else
                    Class_Crs_CD[i][j] = -1;
            }
        MNum = l;
    }
    public void set_YPK(){
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
                        System.out.print("n=" + Class_Crs[i][j][k] + "\n");
                        n = Class_Crs[i][j][k];
                        YPK_Num[Class_Crs_CD[i][n]]++;
                        System.out.print("Set_cl[Class_Crs_CD[i][n]=" + Set_cl[Class_Crs_CD[i][n]][YPK_Num[Class_Crs_CD[i][n]]] + "\n");
                        YPK[Set_cl[Class_Crs_CD[i][n]][YPK_Num[Class_Crs_CD[i][n]]]] = 1;
                        Initial_Color[Set_cl[Class_Crs_CD[i][n]][YPK_Num[Class_Crs_CD[i][n]]]] = (j - 1)*Day_Crs + k;
                        System.out.print("Color=" + ((j - 1)*Day_Crs + k) + "\n");
                    }
                }
            }
        }
    }
    public void set_avbtime(){
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
    public void set_crs_attrib(){
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
                        LTK_Week[l] = 0;
                        Crs_Attri[l] = 0;
                        if (Coursename.get(gcr-1)=="语文" || Coursename.get(gcr-1) == "数学" || Coursename.get(gcr-1) == "英语")
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
                        LTK_Week[l] = nt;
                        Crs_Attri[l] = 0;
                        if (Coursename.get(gcr-1)=="语文" || Coursename.get(gcr-1) == "数学" || Coursename.get(gcr-1) == "英语")
                            Crs_Attri[l] = 1;
                        if ((nl - nt == 2) && (Weak_Day >= 4))
                            Crs_Attri[l] = 2;//两天不能连排
                        else if ((nl - nt == 3) && (Weak_Day > 4))
                            Crs_Attri[l] = 3;//三天不能连排
                    }
                }
            }
    }
    public int has_common_node(int t1, int t2){
        int i, j;
        for (i = 1; i <= Node_Class[t1][0]; i++)//班级冲突冲突
        {
            for (j = 1; j <= Node_Class[t2][0]; j++)
            {
                if (Node_Class[t1][i] == Node_Class[t2][j])
                    return 1;
            }
        }
        /*
        for (i = 1; i <= Node_Stu[t1][0]; i++)//学生冲突
        {
            if (Node_Stu[t1][i] == 0)
            {
                continue;
            }
            for (j = 1; j <= Node_Stu[t2][0]; j++)
            {
                if (Node_Stu[t2][j] == 0)
                    continue;
                if (Node_Stu[t1][i] == Node_Stu[t2][j])
                    return 1;
            }
        }
        */
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
    public void con_struct_graph(){
        int i, j, k, l, m, n, t, th,x,y;
        int bn;
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
        System.out.print("N_vtx=" + N_vtx + "\n");
        for (i = 1; i <= N_vtx; i++)
        {
            m = MCls[Par[i]];//哪门课
            n = MCrs[Par[i]];//哪个班
            t = Class_Tea[m][n];
            Node_Tea_Sign[i] = t;//哪个老师
        }
        for (i = 1; i <= N_vtx; i++)
        {
            System.out.print( Node_Tea_Sign[i] + " " );
        }
        //**************************************开始设置图着色属性
        l = 1;
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
                            bn = Class_Crs_HEBAN[i][j] - 100000;
                            //System.out.print("bn=" + bn + "\n");
                            Node_Class[l][0] = HBK[bn][0];
                            //System.out.print("HBK=" + HBK[bn][0] + "\n");
                            for (k = 1; k <= HBK[bn][0]; k++)
                            {
                                Node_Class[l][k] = HBK[bn][k];
                                //System.out.print("Node_Class=" + HBK[bn][0] + "\n");
                            }
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea[l][0] = 1;
                            Node_Tea[l][1] = th;
                        }
                        else if (Class_Crs_HEBAN[i][j] == 50000)//选考 ,没问题
                        {
                            Node_Class[l][0] = XK_Class_Set[0];
                            for (k = 1; k <= XK_Class_Set[0]; k++)
                            {
                                Node_Class[l][k] = XK_Class_Set[k];
                            }
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea[l][0] = XK_Tea_Set[0];
                            for (k = 1; k <= XK_Tea_Set[0]; k++)
                            {
                                Node_Tea[l][k] = XK_Tea_Set[k];
                            }

                        }
                        /*
                        else if (Class_Crs_HEBAN[i][j] == -50000)//走一 ,存在点问题
                        {
                            Node_Class[l][0] = ZB_Class_Set[0];
                            for (k = 1; k <= ZB_Class_Set[0]; k++)
                            {
                                Node_Class[l][k] = ZB_Class_Set[k];
                            }
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea[l][0] = ZB_Tea_Set[0];
                            for (k = 1; k <= ZB_Tea_Set[0]; k++)
                            {
                                Node_Tea[l][k] = ZB_Tea_Set[k];
                            }

                        }
                        */
                        else if (th == -200)//单双周
                        {
						/*
						Node_Course[l][0] = 2;
						Node_Course[l][1] = DSZ[t][1];
						Node_Course[l][2] = DSZ[t][2];
						*/
                            Node_Class[l][0] = 1;
                            Node_Class[l][1] = i;
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                            Node_Tea[l][0] = 2;
                            Node_Tea[l][1] = Class_Tea[i][DSZ[t][1]];
                            Node_Tea[l][2] = Class_Tea[i][DSZ[t][2]];

                        }
                        else//普通课 ，没问题
                        {
                            Node_Class[l][0] = 1;
                            Node_Class[l][1] = i;
                            Node_Tea[l][0] = 1;
                            Node_Tea[l][1] = th;
                            Node_Course[l][0] = 1;
                            Node_Course[l][1] = j;
                        }
                        l++;
                    }
                }
        }
        System.out.print("l=" + l + "\n");
        //**************************输出看一下
	/*
	for(i=1;i<=N_vtx;i++)
	{
	cout<<"Node_Class="<<Node_Class[i]<<endl;
	}
	for(i=1;i<=N_vtx;i++)
	{
	    cout<<"Node_Course="<<" ";
	    for(j=1;j<=Node_Course[i][0];j++)
	    {
	        cout<<Node_Course[i][j]<<" ";
	    }
	    cout<<endl;
	}
	for(i=1;i<=N_vtx;i++)
	{
	    cout<<"Node_Tea="<<" ";
	    for(j=1;j<=Node_Tea[i][0];j++)
	    {
	        cout<<Node_Tea[i][j]<<" ";
	    }
	    cout<<endl;
	    }
    for(i=1;i<=N_vtx;i++)
    {
	    cout<<"Node_Stu="<<" ";
	    for(j=1;j<=Node_Stu[i][0];j++)
	    {
	        cout<<Node_Stu[i][j]<<" ";
	    }
	    cout<<endl;
	}
	*/
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
	/*
	for( i = 1 ; i <= N_vtx; i++ )
	{
	cout<<A_Matrix[ i ][ 0 ]<<endl;
	}
	*/
        Synthesis_Node_Num = 0;//需要优先排的点
        for (i = 1; i <= N_vtx; i++)
        {
            if (A_Matrix[i][0] > 3 * KCL)
            {
                Synthesis_Node_Num++;
                Synthesis_Node[Synthesis_Node_Num] = i;
            }

        }
        for (i = 1; i <= Synthesis_Node_Num; i++)
        {
            System.out.print(Synthesis_Node[i] + "\n");
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
        for (i = 1; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Tea_CP[i][0]; j++)
                System.out.print(Tea_CP[i][j] + " ");
            System.out.print("\n");
        }
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
        for (i = 1; i <= Tea_Num; i++)
        {
            for (j = 0; j <= Tea_CP[i][0]; j++)
                System.out.print(Tea_CP_Sign[i][j]+" ");
            System.out.print("\n");
        }
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
        for (i = 1; i <= Class_Num; i++) {
            for (j = 1; j <= Crs_Num; j++) {
                for (k = 0; k <= Set_Crs[i][j][0]; k++) {
                    System.out.print(Set_Crs[i][j][k] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

    public void ini_tabu(){
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
    public int Get_Initial_solution(int search_depth){
        int i;
        int num_best;
        int x, v;
        int iter;
        int best_delta, delt;
        int old_color;//移动前着色类
        int select;//随机选择方案
        //int num;//可大致认为是邻域总数
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
                                else if (delt == best_delta)  //if some flips have the same delta,then choose at most 50 and record them   && num_best < 50
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
            if (num_best == 0)
                return f_best;

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
                //get_reslut1();
                return 0;
            }
        }
        System.out.print("The solution is not feasible f == " + f + "\n");
        return f;
    }//搜索初始解

    public int Compoud_Tabu_Search_JP(int search_depth){
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

	/*
	for (i = 1; i <= Tea_Num; i++)
	{
		cout << "i="<<Tea_JP_Score[i] << endl;
	}
	*/
        //set_tea_Src_PJ();
        //out_put_PJ();

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
        //cout << "成功1" << endl;
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

            //cout << "成功2" << endl;
            if (num_best > 0)
                select = rand.nextInt(num_best);   //从备选方案中随机选择一个方案
            else
                return fc_best;

            //cout << "v_best_delta1111=" << v_best_delta << endl;
            if (best_v[select] > 0)
            {
                //cout << "进入1" << endl;
                old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
                f += Delta_Matrix[best_x[select]][best_v[select]] - Delta_Matrix[best_x[select]][old_color];
                fc += Delta_Crs[best_x[select]][best_v[select]] +Delta_Tpj[best_x[select]][best_v[select]];

                //cout << "v_best_delta1122=" << Delta_Crs[best_x[select]][best_v[select]] + Delta_Tpj[best_x[select]][best_v[select]] << endl;
			/*
			if (v_best_delta != (Delta_Crs[best_x[select]][best_v[select]] + Delta_Tpj[best_x[select]][best_v[select]]))
			{
				cout << "不一样了！" << endl;
				getchar();
			}
			*/
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
                //cout << "进入2" << endl;
                x = best_x[select];
                y = -best_v[select];

                f += Delta_Matrix[x][Color[y]] - Delta_Matrix[x][Color[x]] + Delta_Matrix[y][Color[x]] - Delta_Matrix[y][Color[y]] - 2 * Edge[x][y];
                fc += Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]];
                //cout << "v_best_delta2222=" << Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]]<< endl;
			/*
			if (v_best_delta != (Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]]))
			{
				cout << "不一样了！" << endl;
				getchar();
			}
			//cout << "fc=" << fc << endl;
			//cout << "fc+=" << Delta_Crs[x][Color[y]] + Delta_Crs[y][Color[x]] + Delta_Tpj[x][Color[y]] + Delta_Tpj[y][Color[x]] << endl;
			*/
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
                //cout << "成功3" << endl;
                Update_Delta_Crs(x);//没问题
                Update_Delta_Tpj(x);
                Update_Delta_Crs(y);
                Update_Delta_Tpj(y);

            }
            //cout << "成功5" << endl;
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
                //reset_tabu_tenure();
                //cout << "f = " << f << " fc_best = " << fc_best << " fc = " << fc << endl;
            }
            //cout << "f = " << f << " fc_best = " << fc_best << " fc = " << fc << endl;
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
    public int Compoud_Tabu_Search_BTH(int search_depth){
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
        //out_put_PJ();
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
            //cout << "iter = " << iter << endl;
            //check_delta(iter);
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
								/*if(PCr[ v ] <= 2)
								v_best_delta -= 1;
								if(PCr[ Color[ x ] ] <= 2 )
								v_best_delta += 1; */
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
            //cout << "x = " << best_x[ select ] << " v = " <<  best_v[ select ] << " old_color = " << Color[ best_x[ select ] ] << endl;
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
                //TabuTenure[ y ][ old_color_y ] = rand( ) % 10 + 5 + iter ;
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
                //reset_tabu_tenure();
                //cout << "f = " << f << " fc_best = " << fc_best << " fc = " << fc << endl;
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
    public int Cal_Class_Score(int ndi, int knew){
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
                            f1 += 10;
                        if (daycr[i] < Min_Day[pnd])
                            f1 += 10;
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
                        f1 += 10;
                    if (daycr[j] < Min_Day[pnd])
                        f1 += 10;
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
            }
        }
        return f1;
    }
    public int Cal_JP_Score(int ndi, int knew, int t){
        //cout << "t=" << t << endl;
        int crs = Par[ndi];//是哪一门课
        //cout << "pnd1=" << pnd << endl;
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
            //cout << "len=" << len << endl;
            //如果这类课存在连堂课 ，需要比较的课也是连堂课

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
                    if (len_l < l)
                    {
                        len_l = l;//有几次连堂课
                    }
                }
                //cout << "len_l=" << len_l << endl;


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
                //cout << "f22222222=                         " << f1 << endl;
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
                                //cout << "j=" << endl;
                                JP_KC[j][l] = Crs_srt_cl[k][i];//记录连堂课
                            }
                        if (l < min_l)
                            min_l = l/2;//最少的连堂的有几节课/2
                        //cout << "min_l=" << min_l << endl;
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
                    if (min_c < max_pre)//最早开始的要比前一节最晚开始的早，不对
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
                    if (min_c < max_pre)
                        f1 += 3;
                    max_pre = max_c;
                }
            }

        }
        //算完之后回归原位
        for (i = 1; i <= Set_cl[crs][0]; i++)
        {
            Crs_srt_cl[crs][i] = set[i];//这个pnd不是原来的pnd了
        }
        //cout << "pnd2=" << pnd << endl;
        return f1;

    }
    public int Cal_TScr(){
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

        if ((n_mor > 0) && (n_af > 0))
            return (Day_Crs_Mr + max_mor - min_mor + 1 - n_mor + max_af - min_af + 1 - n_af);
        if (n_mor > 0)
            return (max_mor - min_mor + 1 - n_mor);
        if (n_af > 0)
            return (max_af - min_af + 1 - n_af);
        return 0;
    }
    public int Cal_value_one_move_tea(int ndi, int knew,int th){
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
    public void greed_ini_solution(){
        int i, j, k, l,v;
        int x,y;
        int num_best;
        int pick,day,crs;
        int old_color;
        int iter;
        int best_delta, delt, v_delt, v_best_delta;
        int select;

        setcolor();
        Clear_Delta_Matrix();
        Build_Delta_Matrix();//初始化

        l = 0;
        for (i = 0; i <= Weak_Day; i++)
            Day_Set[i] = 0;

        for (x = 1; x <= N_vtx; x++)
            if ((Color[x] == 0) && (Node_Tea_Sign[x] == -2))
            {
                //cout<<"进来了1"<<endl;
                while (1>0)
                {
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
                    day = PDay[k];//在哪一天
                    crs = PCr[k];//哪一节课
                    if ((AVB_Cl[x][k] == 1) && (Day_Set[day] < Max_Day[Par[x]]) && (crs >= 2))
                    {
                        old_color = Color[x];  //存储顶点移动之前的着色类
                        One_Move_Update_Delta_Matrix(x, old_color, k);//更新增量矩阵
                        Color[x] = k;
                        Day_Set[day]++;
                        break;
                    }
                }
            }
        for (i = 0; i <= Weak_Day; i++)
            Day_Set[i] = 0;
        //*********************************
        for (x = 1; x <= N_vtx; x++)
            if ((Color[x] == 0) && (Node_Tea_Sign[x] == -20))
            {
                while (1>0)
                {
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
                    if ((AVB_Cl[x][k] == 1) && (Day_Set[day] < Max_Day[Par[x]]) && (crs >= 2))
                    {
                        old_color = Color[x];  //存储顶点移动之前的着色类
                        One_Move_Update_Delta_Matrix(x, old_color, k);//更新增量矩阵
                        Color[x] = k;
                        Day_Set[day]++;
                        break;
                    }
                }
            }


        for (x = 1; x <= N_vtx; x++)
        {
            if (Color[x] > 0)
            {
                l++;
            }
        }
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
                System.out.print("x=" + x + "\n");
                System.out.print("对课程的时间约束太多，无法生成合法解"+"\n");
                System.exit(0);
            }
            select = rand.nextInt( num_best);
            old_color = Color[best_x[select]];  //存储顶点移动之前的着色类
            One_Move_Update_Delta_Matrix(best_x[select], old_color, best_v[select]);//更新增量矩阵
            Color[best_x[select]] = best_v[select];//更新着色类方案
        }
        f = 0;
        for (i = 1; i <= N_vtx; i++)
            for (j = 1; j < i; j++)
                if (Edge[i][j] != 0)
                {
                    if (Color[i] == Color[j])
                        f += 1;
                }

        System.out.print("f = " + f + "\n");

    }
    public void copy_ini_solution(){
        int i, j;
        for (i = 1; i <= N_vtx; i++)
        {
            Color[i] = Best_Color[i];
        }
        Clear_Delta_Matrix();
        Build_Delta_Matrix();
    }
    public void setcolor(){
        int i;
        for (i = 1; i <= N_vtx; i++)
        {
            Color[i] = Initial_Color[i];
        }
    }
    public void Clear_Delta_Matrix(){
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
    public void Build_Delta_Matrix(){
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



    public void One_Move_Update_Delta_Matrix(int tt, int v0, int v1) {
        int i, len, x;
        len = A_Matrix[tt][0];
        for (i = 1; i <= len; i++)
        {
            x = A_Matrix[tt][i];
            Delta_Matrix[x][v0] -= Edge[x][tt];
            Delta_Matrix[x][v1] += Edge[x][tt];
        }
    }
    public void One_Move_Update_Course(int tt, int v0, int v1){
        int pnd = Par[tt];
        Class_Score[pnd] = Cal_Class_Score(tt, v1);
    }
    public void One_Move_Update_JP(int tt){
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
    public void Sort_Src(){
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
    public void bubble_sort(int pset[], int len){
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
    public void Ini_Delta_Crs(){
        int i, j, l;
        for (i = 1; i <= N_vtx; i++)
        {
            l = Cal_Class_Score(i, Color[i]);
            for (j = 1; j <= KCL; j++)
                Delta_Crs[i][j] = Cal_Class_Score(i, j) - l;
        }
	/*
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= KCL; j++)
		{
			cout << Delta_Crs[i][j] << " ";
		}
		cout << endl;
	}
	*/

    }
    public void Ini_Delta_Tpj(){
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
	/*
	for (i = 1; i <= N_vtx; i++)
	{

		if (Node_Tea_Sign[i] <= 0)
		{
			for (j = 1; j <= KCL; j++)
				Delta_Ttm[i][j] = 0;
		}
		else
		{
			for (j = 1; j <= KCL; j++)
				Delta_Ttm[i][j] = Cal_value_one_move_tea(i, j);
		}
	}
	*/
    }
    public void Ini_Delta_Ttm(){
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
	/*
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= KCL; j++)
		{
			gl = 0;
			for (k = 1; k <= Node_Tea[i][0]; k++)
			{
				if (Node_Tea[i][k] <= 0)
				{
						gl += 0;
				}
				else
				{
					l = Cal_JP_Score(i, Color[i], Node_Tea[i][k]);
					gl += Cal_JP_Score(i, j, Node_Tea[i][k]) - l;
				}
			}
			Delta_Tpj[i][j] = gl;
		}
	}
	*/
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

	/*
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= Node_Tea[i][0]; j++)
		{
			if (Node_Tea[i][j] <= 0)
			{
				for (k = 1; k <= KCL; k++)
					Delta_Tpj[i][k] = 0;
			}
			else
			{
				l = Cal_JP_Score(i, Color[i], Node_Tea[i][j]);
				for (k = 1; k <= KCL; k++)
				{
					//cout <<"i="<<i<<" k="<<k<< "  gl222222222222222222222=" << Cal_JP_Score(i, k, Node_Tea[i][j]) - l << endl;
					Delta_Tpj[i][k] = Cal_JP_Score(i, k, Node_Tea[i][j]) - l;
				}

			}
		}
	}
	*/
	/*
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= KCL; j++)
		{
			cout << Delta_Tpj[i][j] << " ";
		}
		cout << endl;
	}
	*/
    }

    public void Update_Delta_Crs(int ndi){
        int i, j, k, l, delta;

        for (k = 1; k <= Set_cl[Par[ndi]][0]; k++)
        {
            i = Set_cl[Par[ndi]][k];
            l = Cal_Class_Score(i, Color[i]);
            for (j = 1; j <= KCL; j++)
                Delta_Crs[i][j] = Cal_Class_Score(i, j) - l;
        }
	/*
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= KCL; j++)
		{
			cout << Delta_Crs[i][j] << " ";
		}
		cout << endl;
	}
	*/
    }
    public void Update_Delta_Tpj(int ndi){
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
	/*
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
					if(Node_Tea[i][x] == Node_Tea[ndi][y] )
					{
						gll = 1;
						l = Cal_JP_Score(i, Color[i], Node_Tea[i][x]);
						gl += (Cal_JP_Score(i, j, Node_Tea[i][x]) - l);
					}

				}
			}
			if (gll == 1)
			{
				Delta_Tpj[i][j] = gl;
			}
		}
	}
	*/
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

	/*
	if (Node_Tea_Sign[ndi] <= 0)
	{
		//cout << "Sign=" << Node_Tea_Sign[ndi] << endl;
		return;
	}

	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= Node_Tea[i][0]; j++)
		{
			for (k = 1; k <= Node_Tea[ndi][0]; k++)
			{
				if (Node_Tea[i][j] == Node_Tea[ndi][k])//只要是教师相同的点,就会受到影响
				{
					l = Cal_JP_Score(i, Color[i], Node_Tea[i][j]);
					for (m = 1; m <= KCL; m++)
					{
						Delta_Tpj[i][m] = Cal_JP_Score(i, m, Node_Tea[i][j]) - l;//这里有个问题不知道怎么解决
					}
				}
			}

		}
	}
	*/
        //getchar();
	/*
	cout << "Update" << endl;
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= KCL; j++)
		{
			cout << Delta_Tpj[i][j] << " ";
		}
		cout << endl;
	}
	*/
    }
    public void Update_Delta_Ttm(int ndi){
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
	/*
	for (i = 1; i <= N_vtx; i++)
	{
		for (j = 1; j <= KCL; j++)
		{
			gl = 0;
			for (x = 1; x <= Node_Tea[i][0]; x++)
			{
				for (y = 1; y <= Node_Tea[ndi][0]; y++)
				{
					if (Node_Tea[i][y] <= 0)//
					{
						gl += 0;
					}
					else if(Node_Tea[i][x] == Node_Tea[ndi][y] && Node_Tea[ndi][y]> 0)
					{
						gl += Cal_value_one_move_tea(i, j, Node_Tea[i][x]);//告知是哪个教师，能传进来的必大于0
					}
				}

			}
			Delta_Ttm[i][j] = gl;
		}
	}
	*/
    }
    public int Update_Tea_Src(int x, int y){
        int i, j, k, l;
        set_tea_Src(x, y);
        l = 0;
        for (i = 1; i <= Tea_Num; i++)
        {
            l += Tea_Score[i];
        }
        return l;
    }
    public void set_tea_Src(){
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
    public void set_tea_Src(int x, int y){
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
    public void reset_tabu_tenure(){
        int x, v;
        for (x = 0; x <= N_vtx; x++)
            for (v = 0; v <= KCL; v++)
                TabuTenure[x][v] = 0;
    }
    public void get_reslut(){
        int i, j, k, l, m, n, c, s, t, th, ii, bn, x, y=0;
        int M = 0;
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
                for (k = 0; k <= 8; k++)
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

        System.out.print("Start Class_Crs get_result" + "\n");

        l = 1;
        System.out.print("H1"+"\n");
        for (i = 1; i <= Class_Num; i++)
        {
            for (j = 1; j <= Crs_Num; j++)
                if (Class_Crs_Num[i][j]>0)
                {
                    if (Class_Crs_HEBAN[i][j] >= 100000)//触发合班课
                    {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++)
                        {
                            m = Set_cl[l][t];
                            c = Color[m];
                            th = Class_Tea[i][j];
                            bn = Class_Crs_HEBAN[i][j] - 100000;//合班课不允许有两个教师
                            for (k = 1; k <= HBK[bn][0]; k++)
                            {
                                Class_Crs[HBK[bn][k]][PDay[c]][PCr[c]] = j;
                            }
                            if (th>0)
                            {
                                for (k = 1; k <= HBK[bn][0]; k++)
                                {
                                    M = (int) Math.pow(100, k);
                                    Tea_Crs[th][PDay[c]][PCr[c]] = Tea_Crs[th][PDay[c]][PCr[c]] + HBK[bn][k]*M;
                                }
                            }
                            if (th == -2)
                            {
                                for (ii = 1; ii <= XK_Tea_Set[0]; ii++)
                                {
                                    m = XK_Tea_Set[ii];
                                    Tea_Crs[m][PDay[c]][PCr[c]] = -3;
                                }
                            }
                        }
                    }
                    else if (Class_Crs_HEBAN[i][j] == 50000)
                    {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++)
                        {
                            m = Set_cl[l][t];
                            c = Color[m];
                            th = Class_Tea[i][j];
                            for (k = 1; k <= XK_Stu_Set[0]; k++)
                            {
                                Class_Crs[XK_Stu_Set[k]][PDay[c]][PCr[c]] = -2;
                            }
                            if (th>0)
                                Tea_Crs[th][PDay[c]][PCr[c]] = i;
                            if (th == -2)
                            {
                                for (ii = 1; ii <= XK_Tea_Set[0]; ii++)
                                {
                                    m = XK_Tea_Set[ii];
                                    Tea_Crs[m][PDay[c]][PCr[c]] = -3;
                                }
                            }
                        }
                    }
                    /*
                    else if (Class_Crs_HEBAN[i][j] == -50000)
                    {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++)
                        {
                            m = Set_cl[l][t];
                            c = Color[m];
                            th = Class_Tea[i][j];

                            for (k = 1; k <= ZB_Stu_Set[0]; k++)
                            {
                                for (x = 0; x<ZBK_Num; x++)
                                {
                                    if (ZB_Stu_Set[k] == ZBK[x][2])
                                    {
                                        y = ZBK_C[x];//课程
                                        th = Class_Tea[ZB_Stu_Set[k]][y];
                                        //cout<<"th="<<th<<" "<<ZB_Stu_Set[k]<<endl;
                                        Tea_Crs[th][PDay[c]][PCr[c]] = ZB_Stu_Set[k];
                                    }
                                    else if (ZB_Stu_Set[k] == ZBK[x][1])
                                    {
                                        y = CM;
                                        break;
                                    }
                                }
                                Class_Crs[ZB_Stu_Set[k]][PDay[c]][PCr[c]] = y;
                            }
                        }
                    }
                    */
                    else//正常
                    {
                        for (t = 1; t <= Class_Crs_Num[i][j]; t++)
                        {
                            m = Set_cl[l][t];
                            c = Color[m];
                            for (x = 1; x <= Node_Tea[m][0]; x++)
                            {
                                th = Node_Tea[m][x];
                                if (th>0)
                                    Tea_Crs[th][PDay[c]][PCr[c]] = i;
                                if (th == -2)
                                {
                                    for (ii = 1; ii <= XK_Tea_Set[0]; ii++)
                                    {
                                        m = XK_Tea_Set[ii];
                                        Tea_Crs[m][PDay[c]][PCr[c]] = -3;
                                    }
                                }
                            }
                            Class_Crs[i][PDay[c]][PCr[c]] = j;
                        }
                    }
                    l++;
                }
        }
        System.out.print("H2"+"\n");

        for (i = 0; i <Stu_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                {
                    Stu_Crs[i][j][k] = Class_Crs[Stu_Class[i]][j][k];
                }

            }
        }
        /*
        for (i = 0; i <Key_Stu_Num; i++)
        {
            for (j = 0; j <= Weak_Day; j++)
            {
                for (k = 0; k <= Day_Crs; k++)
                {
                    Key_Stu_Crs[i][j][k] = Class_Crs[Key_Stu_Class[i]][j][k];
                }

            }
        }
        */

        for (i = 1; i < Class_Num; i++)
        {
            for (j = 1; j <= Weak_Day; j++)
            {
                for (k = 1; k <= Day_Crs; k++)
                    System.out.print(Class_Crs[i][j][k]+" ");
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

    public void out_put_file(){
        int i, j, k, l, m, x, y;
        y = 0;
        String[] a= {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日" };
        String[] b ={ " ","第一节","第二节", "第三节", "第四节", "第五节", "第六节", "第七节", "第八节" };
        File Filename5 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\time_class.csv");
        BufferedWriter outFile = null;
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(Filename5));
            outFile =  new BufferedWriter(write);
            outFile.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            for (i = 1; i <= Class_Num; i++)
            {
                outFile.write(Grade.get(i-1) + Class.get(i-1) +"\n");
                for (j = 1; j <= Weak_Day; j++)
                {
                    outFile.write(a[j] + ",");
                    for (k = 1; k <= Day_Crs; k++)
                        if (Class_Crs[i][j][k] > 0)
                            outFile.write(Coursename.get(Class_Crs[i][j][k] - 1)+",");
                        else if (Class_Crs[i][j][k] == -2)
                            outFile.write("选考"+",");
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

        File Filename6 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\time_teacher.csv");
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
                            outFile1.write(Class.get(Tea_Crs[i][j][k] - 1) + ",");
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
                        else if (Tea_Crs[i][j][k] == -1)//这个不会触发
                            outFile1.write("班会" + ",");
                        else if (Tea_Crs[i][j][k] == -2)
                            outFile1.write("备课" + ",");
                        else if (Tea_Crs[i][j][k] == -3)
                            outFile1.write("选考" + ",");
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


        File Filename7 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\time_stu.csv");
        BufferedWriter outFile2 = null;
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(Filename7));
            outFile2 =  new BufferedWriter(write);
            outFile2.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            for (i = 0; i < Stu_Num; i++)
            {
                outFile2.write("学号："+",");
                outFile2.write(Stu_ID[i]+","+",");
                outFile2.write("班级:"+","+ Grade.get(Stu_Class[i] - 1)+Class.get(Stu_Class[i]-1)+"\n");
                for (j = 1; j <= Weak_Day; j++)
                {
                    outFile2.write(a[j]+",");
                    for (k = 1; k <= Day_Crs; k++)
                        if (Stu_Crs[i][j][k] > 0)
                            outFile2.write(Coursename.get(Stu_Crs[i][j][k] - 1)+",");
                        else if (Stu_Crs[i][j][k] == -2)
                            outFile2.write(Stu_Course.get(i)+",");
                    outFile2.write("\n");
                }
                outFile2.write("\n");
            }
            /*

            for (i = 0; i < Key_Stu_Num; i++)
            {
                outFile2.write("学号："+",");
                outFile2.write(Key_Stu_ID[i]+","+",");
                outFile2.write("班级:"+","+ Grade.get(Key_Stu_Class[i] - 1)+Class.get(Key_Stu_Class[i]-1)+"\n");
                for (j = 1; j <= Weak_Day; j++)
                {
                    outFile2.write(a[j]+",");
                    for (k = 1; k <= Day_Crs; k++)
                        if (Key_Stu_Crs[i][j][k] > 0 && Key_Stu_Crs[i][j][k] != CM)
                            outFile2.write(Coursename.get(Key_Stu_Crs[i][j][k] - 1)+",");
                        else if (Key_Stu_Crs[i][j][k] == -2)
                            outFile2.write(Key_Stu_Course.get(i)+",");
                        else if (Key_Stu_Crs[i][j][k] == CM)
                            outFile2.write(Key_Stu_Move_Course.get(i)+",");
                    outFile2.write("\n");
                }
                outFile2.write("\n");
            }
            */
            outFile2.flush();
            outFile2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int Last_Cal_Class_Score(int ndi, int knew){
        int pnd = Par[ndi];//属于哪一门课
        int kold = Color[ndi];
        int len;
        int f1 = 0;
        int maxk = Weak_Day / 2;//3天
        if (maxk < 3)
            maxk = 3;
        int i, j, k, l, len_lt, max, min;
        int x, y;
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
                            f1 += 10;
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
                                System.out.print(MCls[pnd]+"  "+MCrs[pnd]+"\n");
                                Class_Crs_Rst[gcls][PDay[set[i]]][PCr[set[i]]] = 5;//哪一节
                            }

                    }

                if (Crs_Attri[pnd] == 1)
                {
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
                        f1 += 10;
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
                                Class_Crs_Rst[gcls][PDay[set[i]]][PCr[set[j]]] = 6;
                                Class_Weak[pnd][PDay[set[i]]][6]=1;
                            }
                    }

                }
            }
        }
        return f1;
    }

    public int Last_Cal_JP_Score(int ndi, int knew, int t){
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
            //cout << "len=" << len << endl;
            //如果这类课存在连堂课 ，需要比较的课也是连堂课

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
                        if (min_c < max_c)//最早开始的要比前一节最晚开始的早，不对
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
                    if (min_c < max_pre)//最早开始的要比前一节最晚开始的早，不对
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
                    if (min_c < max_pre)
                    {
                        f1 += 3;
                        Tea_Rst[t][3] = 1;
                        Tea_Weak[t][PDay[min_c]][3] = 1;
                        Tea_Weak[t][PDay[max_pre]][3] = 1;
                        Tea_Crs_Rst[t][PDay[min_c]][PCr[min_c]] = 3;
                        Tea_Crs_Rst[t][PDay[max_pre]][PCr[max_pre]] = 3;
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

    public void Out_Put_Erro_BTH(int Rslt[]){
        int i, j, k, m, l;
        for (i = 1; i <= N_vtx; i++)
        {
            Color[i] = Rslt[i];
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

                //outFile << "可能不合理的课程 班级: " << MCls[i] << "班， 课程：" << MCrs[i] << " Score = " << Class_Score[i] << endl;
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
                System.out.print( "可能教案不平齐的老师: " + Tea_Name.get(i-1) + " Score = " + Tea_JP_Score[i] + "\n");
                //outFile << "可能教案不平齐的老师: " << Tea_Name[i - 1] << " Score = " << Tea_JP_Score[i] << endl;
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
                System.out.print("可能时间不集中的老师: " + Tea_Name.get(i-1) + " Score = " + l + "\n");
                //outFile << "可能时间不集中的老师: " << Tea_Name[i - 1] << " Score = " << l << endl;
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

        //outFile << "硬约束 f = " << f << " 软约束 fc = " << fc << endl;
        //if (f != 0)
        //outFile << "生成的方案是非法方案，约束太多导致" << endl;

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
            System.out.print("教师 " + Tea_Name.get(i-1) + " 一周上 " + l + " 节课" + "\n");
            //outFile << "教师 " << Tea_Name[i - 1] << " 一周上 " << l << " 节课" << endl;
        }
        //outFile.close();
    }

    public void to_json(){

        int i, j, k;
        int x, y, z;
        int l, m, n, o, p;
        double v = 0;
        int Class_Rst_Vaule = 0, Tea_Rst_Vaule = 0;
        int[] Class_Rst_V = { 0,0,0,0,0,0,0,0,0 };//小项
        int[] Tea_Rst_V = { 0,0,0,0,0,0 };
        int[] Class_V = { 0,0,0,0,0 };//大项
        int[] Tea_V = { 0,0,0,0 };
        int[][] DY_Class = { { 0,0,0,0 },{ 2,1,2,0 },{ 2,3,4,0 },{ 1,5,0,0 },{ 3,6,7,8 } };
        int[][] DY_Tea = { { 0,0,0 },{ 3,1,2,5 },{ 1,3,0 },{ 1,4,0 } };
        String[] a = { "","LTK_limit","Day_Crs_limit","Priority_class_limit","Weak_Crs_distributed" };
        String[] b = { "","LTK_JP","FLTK_JP","JZSK" };
        String[] a1 = { "","连堂课限制","日课时限制","优先排课限制","周课时分布" };
        String[] b1 = { "","连堂课教案平齐","非连堂课教案平齐","集中授课" };
        String[] c = { "","连堂课少上","连堂课多上","超出天最大限制","低于天最小限制","没有满足优先排","第一节安排过多","三天连上","两天连上" };
        String[] d = { "","两次连堂课之间有课","连堂课前后教案不平齐","普通课教案不平齐","授课不集中" ,"连堂课教案不平齐"};
        String[] w = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        //cout<<"成功"<<endl;
        for(i=1;i<=MNum;i++)
        {
            for(j=1;j<=Weak_Day;j++)
            {
                for(k=1;k<=8;k++)
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

        for (i = 1; i <= MNum; i++)
        {
            for (j = 1; j <= 8; j++)
            {
                Class_Rst_Vaule += Class_Rst[i][j];//总的值
            }
        }
        for(i = 1; i <= MNum; i++)
        {
            for (j = 1; j <= 8; j++)
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
                Tea_Rst_Vaule += Tea_Rst[i][j];//总的值
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
        File Filename8 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\result1.json");
        BufferedWriter outFile = null;
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(Filename8));
            outFile =  new BufferedWriter(write);
            //outFile.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            outFile.write("{"+"\n");
            outFile.write("    \"Course_quality\":" + "\"" + v + "%\"," + "\n");
            if(v!=100)
            {
                outFile.write( "    \"Quality_description\":" + "\"在排课规则中，班级不排课时间、课程不排课时间、教师不排课时间、合班课");
                for (i = 1; i <= 4; i++)
                {
                    if (Class_V[i] == 0)
                    {
                        outFile.write("、" + a1[i]);
                    }
                }
                for (i = 1; i <= 3; i++)
                {
                    if (Tea_V[i] == 0)
                    {
                        outFile.write("、" + b1[i]);
                    }
                }
                outFile.write(" 等规则的满足率为100%,");
                n = 0;
                for (i = 1; i <= 4; i++)
                {
                    if (Class_V[i] > 0)//违反
                    {
                        outFile.write(a1[i]);
                        n++;
                        if (n == l + m)
                            break;
                        outFile.write("、");
                    }

                }
                for (i = 1; i <= 3; i++)
                {
                    if (Tea_V[i] > 0)//违反
                    {
                        outFile.write(b1[i]);
                        n++;
                        if (n == l + m)
                            break;
                        outFile.write("、");
                    }

                }
                System.out.print("成功"+"\n");
                outFile.write("等规则仍有不满足\"," + "\n");

            }
            else
            {
                outFile.write("    \"Quality_description\":" + "\"所有条件都满足，排课质量为100%\","+"\n");
            }

            o = 0;
            for (i = 1; i <= 4; i++)
            {
                n = 0;
                outFile.write("    \"" + a[i] + "\":{" + "\n");
                outFile.write("       \"Rule_satisfaction_rate\":" + "\"" + (100.0 - (Class_V[i] * 100.0) / (MNum*Weak_Day*1.0)) + "%\"," + "\n");
                outFile.write("       \"Unsatisfaction\":[");
                for (j = 1; j <= DY_Class[i][0]; j++)
                {
                    for (k = 1; k <= MNum; k++)
                    {
                        if (Class_Rst[k][DY_Class[i][j]] == 1)//一旦触发
                        {
                            System.out.print( MCls[k] + "   " + MCrs[k] + "\n");
                            outFile.write("\"" + Class.get(MCls[k] - 1) + Coursename.get(MCrs[k] - 1) + "课");
                            p=0;
                            for (y = 1; y <= Weak_Day; y++)
                            {
                                if(Class_Weak[k][y][DY_Class[i][j]]==1)
                                {
                                    outFile.write(w[y]);
                                    p++;
                                    if(p == Class_Weak[k][0][DY_Class[i][j]])
                                        break;
                                    outFile.write("、");
                                }
                            }
                            outFile.write("存在" + c[DY_Class[i][j]] + "的情况");
                            outFile.write("\"");
                            n++;
                            if (n == Class_V[i])
                                break;
                            outFile.write(",");
                        }
                    }
                }
                outFile.write( "]," + "\n");
                n = 0;
                outFile.write("       \"Problematic_section\":[");
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
                                    if (n>0)
                                        outFile.write(",");
                                    outFile.write( "{\"Class\":" + x + ",\"Day\":" + y + ",\"Crs\":" + z + "}");
                                    n++;
                                }

                            }
                        }
                    }
                }
                outFile.write("]" + "\n");
                outFile.write("    }");
                o++;
                if (o == 7)
                    break;
                outFile.write("," +"\n");
            }
            for (i = 1; i <= 3; i++)
            {
                //if (Tea_V[i] > 0)
                {
                    n = 0;
                    outFile.write("    \"" + b[i] + "\":{" + "\n");
                    outFile.write("       \"Rule_satisfaction_rate\":" + "\"" + (100.0 - (Tea_V[i] * 100.0)/ (Tea_Num*Weak_Day*1.0)) + "%\"," + "\n");
                    outFile.write("       \"Unsatisfaction\":[");
                    for (j = 1; j <= DY_Tea[i][0]; j++)
                    {
                        for (k = 1; k <= Tea_Num; k++)
                        {
                            if (Tea_Rst[k][DY_Tea[i][j]] == 1)
                            {
                                outFile.write("\"" + Tea_Name.get(k-1));
                                p=0;
                                for (y = 1; y <= Weak_Day; y++)
                                {
                                    if(Tea_Weak[k][y][DY_Tea[i][j]]==1)
                                    {
                                        outFile.write(w[y]);
                                        p++;
                                        if(p == Tea_Weak[k][0][DY_Tea[i][j]])
                                            break;
                                        outFile.write("、");
                                    }
                                }
                                outFile.write("存在" + d[DY_Tea[i][j]] + "的情况\"");
                                n++;
                                if (n == Tea_V[i])
                                    break;
                                outFile.write(",");
                            }
                        }
                    }
                    outFile.write("]," + "\n");
                    n = 0;
                    outFile.write("       \"Problematic_section\":[");
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
                                        if (n>0)
                                            outFile.write(",");
                                        outFile.write("{\"Tea\":" + x + ",\"Day\":" + y + ",\"Crs\":" + z + "}");
                                        n++;
                                    }

                                }
                            }
                        }
                    }
                    outFile.write("]" + "\n");
                    outFile.write("    }");
                    o++;
                    if (o == 7)
                        break;
                    outFile.write("," + "\n");
                }
            }
            outFile.write("\n");
            outFile.write("}");
            outFile.flush();
            outFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        File Filename9 = new File("C:\\Users\\18367\\IdeaProjects\\PK\\src\\ZBPK_NKC\\result2.json");//不排课时间、课程
        BufferedWriter outFile1 = null;
        try {
            OutputStreamWriter write1 = new OutputStreamWriter(new FileOutputStream(Filename9));
            outFile1 =  new BufferedWriter(write1);
            outFile1.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            outFile1.write("{" + "\n");
            outFile1.write("    \"Weak_Crs\":" + "\"" + KCL + "\"," + "\n");
            outFile1.write("    \"Result\":" + "[" + "\n");
            l = 0;
            for (i = 1; i <= Class_Num; i++)
            {
                for (j = 1; j <= Weak_Day; j++)
                {
                    for (k = 1; k <= Day_Crs; k++)
                    {
                        outFile1.write("       {");
                        outFile1.write("\"Class\":\"" + Class.get(i-1) + "\",\"Day\":" + j + ",\"Crs\":" + k + ",");
                        outFile1.write("\"Course\":\"");
                        if (Class_Crs[i][j][k] > 0)
                        {
                            outFile1.write( Coursename.get(Class_Crs[i][j][k] - 1) + "\",");
                            outFile1.write("\"Tea\":\"" + Tname.get(i - 1).get(Class_Crs[i][j][k] - 1) + "\",");
                        }
                        else if (Class_Crs[i][j][k] == 0)
                        {
                            outFile1.write("\"" + ",");
                            outFile1.write("\"Tea\":" + "\"\",");
                        }
                        else if(Class_Crs[i][j][k] == -2)
                        {
                            outFile1.write("选考\"" + ",");
                            outFile1.write("\"Tea\":" + "\"\",");
                        }
                        outFile1.write("\"Course_scheduling\":[");

                        for (x = 1; x <= Crs_Num; x++)
                        {
                            outFile1.write("\""+Crs_AvrT[x][j][k]+"\"");
                            if (x == Crs_Num)
                                break;
                            outFile1.write(",");
                        }
                        outFile1.write("],");

                        outFile1.write("\"Tea_scheduling\":[");
                        for (x = 1; x <= Tea_Num; x++)
                        {
                            outFile1.write("\""+Tea_AvrT[x][j][k]+"\"");
                            if (x == Tea_Num)
                                break;
                            outFile1.write(",");
                        }

                        outFile1.write("]");
                        outFile1.write("}");
                        l++;
                        if (l == Class_Num*Weak_Day*Day_Crs)
                        {
                            outFile1.write("\n");
                            break;
                        }
                        outFile1.write("," + "\n");
                    }
                }
            }
            outFile1.write("    ]" + "\n");
            outFile1.write("}" + "\n");
            outFile1.flush();
            outFile1.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        int i, j, k, minl, gl, l, flag = 0;

        nkcGraphcolor graph = new nkcGraphcolor();
        graph.check_kc();
        graph.check_HBK();
        graph.set_HB();//设置合班课
        graph.set_XK();//设置选考课
        //graph.set_ZB();//设置走班课
        graph.set_CD();
        graph.con_struct_graph();
        graph.set_YPK();
        graph.set_avbtime();
        graph.set_crs_attrib();
        System.out.print("Begin"+"\n");
        minl = 9999999;
        graph.TTL = 2 * graph.Class_Num;
        graph.ini_tabu();
        for (k = 1; k <= 1; k++)
        {
            System.out.print("k=" + k );
            graph.Get_Initial_solution(5000);
            while (graph.f != 0)
            {
                graph.Get_Initial_solution(5000);
            }
            gl = graph.Compoud_Tabu_Search_JP(5000);//教案平齐
            //graph.get_reslut();
            gl = graph.Compoud_Tabu_Search_BTH(10000);//集中排课

            //get_reslut1();
            if (gl < minl)
            {
                minl = gl;
                flag = 1;
                for (i = 1; i <= graph.N_vtx; i++)
                    graph.Final_Color[i] = graph.Best_Color[i];
            }
            System.out.print("|--------------| minl = " + minl + " |---------| gl = " + gl + "\n");
        }
        for (i = 1; i <= graph.N_vtx; i++)
            graph.Color[i] = graph.Final_Color[i];
        graph.get_reslut();
        graph.out_put_file();
        graph.Out_Put_Erro_BTH(graph.Final_Color);
        graph.to_json();
    }
}


