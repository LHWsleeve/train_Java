package Thread2;

/**
 * yield礼让线程，暂停线程，直接进入就绪状态，不是阻塞状态
 * yield()方法：暂停当前正在执行的线程对象，并执行其他线程。
 * yield()应该做的是让当前运行线程回到就绪状态，以允许具有相同优先级的其他线程获得运行机会。
 * 因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 * 结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
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
