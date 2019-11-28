package Thread_study03;

/**
 * 线程不安全，有重复的数字，有负数
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        UnsafeWeb12306 web = new UnsafeWeb12306();
        new Thread(web, "码农一号").start();
        new Thread(web, "码农二号").start();
        new Thread(web, "码农三号").start();
    }
}

class UnsafeWeb12306 implements Runnable{
    private int tickleNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
    }
}

private void test(){
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
