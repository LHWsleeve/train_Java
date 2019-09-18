package Thread2;

/**
 * yield礼让线程，暂停线程，直接进入就绪状态，不是阻塞状态
 */
public class Yield01 {
    public static void main(String[] args) {
        MyYeild my = new MyYeild();
        new Thread(my, "a").start();
        new  Thread(my ,"b").start();
    }
}

class MyYeild implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---start");
        Thread.yield();//礼让，重回调度器等待调度
        System.out.println(Thread.currentThread().getName()+"----end");
    }
}
