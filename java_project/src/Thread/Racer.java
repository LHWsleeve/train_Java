package Thread;

/**
 * 模拟龟兔赛跑
 */
public class Racer implements Runnable{
    private static String winer;
    @Override
    public void run() {
       for (int step=1;step<=100;step++){
           System.out.println(Thread.currentThread().getName()+"--👉"+step);
           //比赛是否结束
           boolean flag = GameOver(step);
           if (flag){
               break;
           }
       }
    }
    private boolean GameOver(int step){
        if (winer!=null){
            return true;
        }else {
            if (step==100){
                if (Thread.currentThread().getName().equals("tuzi")){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                winer = Thread.currentThread().getName();
                System.out.println("winer is"+"===👉"+winer);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"乌龟").start();
        new Thread(racer,"tuzi").start();
    }
}
