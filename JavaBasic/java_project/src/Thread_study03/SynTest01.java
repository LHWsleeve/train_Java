package Thread_study03;

/**
 * 线程安全:在并发时，保证数据正确性，尽可能效率高
 * synchronized
 * 1.同步方法
 * 2.同步块
 */
public class SynTest01 {
    public static void main(String[] args) {
        safeWeb12306 web = new safeWeb12306();
        new Thread(web, "一号").start();
        new Thread(web, "二号").start();
        new Thread(web, "三号").start();
    }
}

class safeWeb12306 implements Runnable{
    private int tickleNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
//线程安全，同步
private synchronized void test(){
        if (tickleNums<0){
            flag = false;
            System.out.println("无票");
            return;
        }

    try {
        Thread.sleep(200);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName()+
            ""+"-----👉"+tickleNums--);
}
    }
