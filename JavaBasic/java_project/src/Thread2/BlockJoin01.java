package Thread2;
/**
 * jion()方法：线程实例的join()方法可以使得一个线程在另一个线程结束后再执行，即也就是说使得当前线程可以阻塞其他线程执行
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 *
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 */
public class BlockJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread tt= new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("lamda"+i);
            }
        });
        tt.start();
        for (int i=0;i<100;i++){
            if (i==20){
                tt.join();//此时，main主线程阻塞
            }
            System.out.println("main......"+i);
        }
    }
}
