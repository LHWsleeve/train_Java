package Thread2;
/**
 * jion()方法：线程实例的join()方法可以使得一个线程在另一个线程结束后再执行，即也就是说使得当前线程可以阻塞其他线程执行
 * 当前线程阻塞，其他执行完之后，再执行。
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
