package Thread_study03;

/**
 * 可重入锁：锁可以延续使用
 */
public class LockTest {
    public void test(){
        //第一次锁
        synchronized (this){
            //第二次获得同样的锁
            synchronized (this) {
                while (true) {
                    System.out.println("ReentrantLock!");
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest().test();
    }
}
