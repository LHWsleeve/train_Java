package Thread2;

/**
 * 线程优先级1-10
 * 1.NORM_PRIOITY 5 默认
 * 2.MIN__PRIOITY 1
 * 3.MAX_PRIOITY 10
 * 注意：优先级只代表概率，不代表绝对的先后顺序
 */
public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp = new MyPriority();

        Thread t1 = new Thread(mp,"1");
        Thread t2 = new Thread(mp,"2");
        Thread t3 = new Thread(mp,"3");
        Thread t4 = new Thread(mp,"4");
        Thread t5 = new Thread(mp,"5");
        Thread t6 = new Thread(mp,"6");

        //设置优先级，一定要在启动前
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---👉"+Thread.currentThread().getPriority());
//        Thread.yield();
    }
}
