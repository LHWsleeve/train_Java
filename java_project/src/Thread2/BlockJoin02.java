package Thread2;

import java.awt.desktop.SystemSleepEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockJoin02 {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟");
        new Thread(new Father()).start();
    }
}
class Father extends Thread{
    @Override
    public void run() {
        System.out.println("想抽烟发现没了");
        System.out.println("让儿子去买中华");
        Thread f = new Thread(new Son());
        f.start();
        try {
            f.join();//卸载father的线程体中，必须father执行完才可以继续。father阻塞
            System.out.println("老爸接过烟，八零钱给了儿子");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("孩子丢了，找孩子");

        }

    }
}
class Son extends Thread{
    @Override
    public void run() {
        System.out.println("接过老爸的钱出门");
        System.out.println("路边有个游戏厅，玩了十秒");
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("mm:ss").format(new Date().getTime()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("买烟去....");
        System.out.println("拿一包中华回家了");
    }
}
