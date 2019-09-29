package other;

import java.util.*;

/**
 * 任务定时调度：Time，Timer类
 */
public class TimerTest01
{
    public static void main(String[] args) {
        Timer timer = new Timer();
        //执行
//        timer.schedule(new Mytest(),1000);//执行一次
//        timer.schedule(new Mytest(),1000,200);//执行多次
        Calendar cal = new GregorianCalendar(2019,9,29,22,1,59);//定义一个时间
        timer.schedule(new Mytest(),cal.getTime(),200);//到这个时间后开始执行，每隔200ms多次执行
    }
}

class  Mytest extends TimerTask{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("hello world");
        }
    }
}