/**
 * 分析上下文，环境，注意起点
 * 1.构造器:那里调用属于哪里，找线程体
 * 2.run方法：本线程自身的
 */
package Thread_study03;

public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        //先调用new 构造器myrun，然后启动线程 调用run
        new Thread(new MyRun02()).start();
    }
    public static class MyRun02 implements Runnable {
        //两个线程打印出的name不一样,修改不影响。
        public MyRun02(){
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName() + "--->"+threadLocal.get());
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--->还剩下" + threadLocal.get());
        }
    }
}
