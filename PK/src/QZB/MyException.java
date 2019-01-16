package QZB;

/**
 * @program: PK
 * @description: 异常信息
 * @author: Mr.Sun
 * @create: 2018-10-09 10:43
 **/
public class MyException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public MyException(){
        super();
    }
    public MyException(String msg){
        super(msg);
    }

}

