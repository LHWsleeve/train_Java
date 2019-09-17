package Thread2;

import javax.swing.*;

/**
 * 终止线程
 * 1.线程正常执行完毕
 * 2.加入标识位。不要使用stop()
 */
public class TreminateTread implements Runnable{
    //加入标识位 标记线程体是否可以运行
    private boolean flag = true;
    private String name;

    public TreminateTread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        //关联标识
        while (flag){
            System.out.println(this.name+"--→"+i++);
        }
    }

    //提供方法改变标识
    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TreminateTread tp = new TreminateTread("C");
        new Thread(tp).start();

        for (int i=0;i<=99;i++){
            if (i==88){
                tp.terminate();
                System.out.println("gameover");
            }
            System.out.println("main--→"+i);
        }
    }

}
