package Thread2;

public class BlockSleep01 {
    public static void main(String[] args) {

    }

}
class Web12306 implements Runnable{
    private int tickleNums = 99;

    @Override
    public void run() {
        while (true){
            if (tickleNums<0){
                System.out.println("无票");
                break;
            }
            //模拟延时，放大问题
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    ""+"-----👉"+tickleNums--);
        }
    }
    public static void main(String[] args){
        Web12306 web = new Web12306();
        new Thread(web, "码农一号").start();
        new Thread(web, "码农二号").start();
        new Thread(web, "码农三号").start();

    }
}
