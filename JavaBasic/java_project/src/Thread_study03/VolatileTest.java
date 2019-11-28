package Thread_study03;

/**
 * 用于保证数据的同步，可见性。轻量级的syn
 */
public class VolatileTest {
private volatile static int num=0;

    public static void main(String[] args) {
        new Thread(()->{
            while (num==0){
                //死循环
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num=1;
    }
}
