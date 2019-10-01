/**
 * Inheritable：继承上下文环境的顺序 起点，拷贝数据给子线程
 */
package Thread_study03;

public class ThreadLocalTest04 {
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        threadLocal.set(2);
        //线程由main环境开辟，将数据拷贝一份
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }).start();
    }
}