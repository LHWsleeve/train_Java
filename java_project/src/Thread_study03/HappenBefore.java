package Thread_study03;

/**
 * 指令重排 ：代码的执行顺序与预期的不一致
 * cpu执行速度远大于内存速度，所以会存在cpu空闲，
 * jvm为了提高性能，指令重排，将不相关的指令提前运行。
 * 但是在多线程中可能会造成影响
 */
public class HappenBefore {
    // 变量1
    private static int a = 0;
    //变量2
    public static boolean flag=false;

    public static void main(String[] args) throws InterruptedException {
    //线程1
     Thread t = new Thread(()->{
         a = 1;
         flag=true;
     });
     //读取数据
        Thread t2 = new Thread(()->{
            while (true){
                if (flag){
                    a*=1;
                }
                if (a==0){
                    System.out.println("happenbefore a ->"+a);
                }
        }
        });
        t.start();
        t2.start();
        //合并线程
        t.join();
        t2.join();
    }
}
