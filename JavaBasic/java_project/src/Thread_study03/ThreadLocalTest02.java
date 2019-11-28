/**
 * 每个线程存储自身数据，更改不会影响其他线程
 */
package Thread_study03;

public class ThreadLocalTest02 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun02()).start();

        }
    }
    static class MyRun02 implements Runnable {
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "--->得到了" + left);
            threadLocal.set(left - 1);
            System.out.println(Thread.currentThread().getName() + "--->还剩下" + threadLocal.get());

        }
    }
}
