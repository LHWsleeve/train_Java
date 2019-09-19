package Thread2;
/**
 * join:合并线程，插队线程
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
