package Thread2;

/**
 * 守护线程：是为用户线程服务的；JVM停止，不用等待守护线程执行完毕
 * 默认都是用户线程。JVM等待所有用户线程执行完毕才会停止
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t = new Thread(god);
        t.setDaemon(true);//将用户线程调整为守护
        t.start();
        new Thread(you).start();
    }
}
class You extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=365*100;i++){
            System.out.println("happy life");
        }
        System.out.println("over");
    }
}

class God extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("bless you...");
        }
    }
}
