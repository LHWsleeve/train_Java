package Thread_study03;

/**
 * 线程安全:在并发时，保证数据正确性，尽可能效率高
 * synchronized
 * 1.同步方法
 * 2.同步块
 */
public class SynBlockTest04 {
    public static void main(String[] args) {
        SynWeb12306 web = new SynWeb12306();
        new Thread(web, "一号").start();
        new Thread(web, "二号").start();
        new Thread(web, "三号").start();
    }
}

class SynWeb12306 implements Runnable{
    private int tickleNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test5();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
//线程安全，尽可能锁定合理的范围（不是指代码，指的是数据完整性）
//double checking
private  void test5() {
    if (tickleNums <=0) {//考虑没有票的情况
        flag = false;
        System.out.println("无票");
        return;
    }
    synchronized (this) {
        if (tickleNums <=0) {//考虑最后一张票
            flag = false;
            System.out.println("无票");
            return;
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "" + "-----👉" + tickleNums--);
    }
}




    //线程不安全，锁定范围太小，锁不住
private  void test4() {
    synchronized (this) {
        if (tickleNums < 0) {
            flag = false;
            System.out.println("无票");
            return;
        }
    }//锁尾
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "" + "-----👉" + tickleNums--);

}




    //只锁ticknums（只能是对象）,线程不安全，锁定失败。锁的对象不能变，tick不能变。对象的属性可以变（大对象可以变，内部在变化锁不住）
private  void test3() {
    synchronized ((Integer)tickleNums) {
        if (tickleNums < 0) {
            flag = false;
            System.out.println("无票");
            return;
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "" + "-----👉" + tickleNums--);
    }
}


//同步块，范围太大，性能低下
private  void test2() {
    synchronized (this) {
        if (tickleNums < 0) {
            flag = false;
            System.out.println("无票");
            return;
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "" + "-----👉" + tickleNums--);
    }
}

//线程安全，同步
private synchronized void test1(){
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
