package Thread_study03;

/**
 * ThreadLocal:每个线程自身的本地，局部存储区域
 * get/set/initialValue
 */
public class ThreadLocalTest01 {
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//更改初始值,重写initialValue方法
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
    @Override
    protected Integer initialValue() {
        return 200;
    }
};
    //新的初始化方法
//    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        //设置值
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        new Thread(new MyRun()).start();

    }
    public static class  MyRun implements Runnable{
        @Override
        public void run() {
            threadLocal.set((int) (Math.random()*99));
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
        }
    }
}
