package Thread;

import java.util.concurrent.*;

/**
 * 模拟龟兔赛跑
 */
public class CRacer implements Callable<Integer> {
    private static String winer;
    @Override
    public Integer call() {
       for (int step=1;step<=100;step++){
           System.out.println(Thread.currentThread().getName()+"--👉"+step);
           //比赛是否结束
           boolean flag = GameOver(step);
           if (flag){
               return step;
           }
       }
       return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        ExecutorService ser = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = ser.submit(racer);
        Future<Integer> result2 = ser.submit(racer);
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1);
        ser.shutdownNow();
//        new Thread(racer,"乌龟").start();
//        new Thread(racer,"tuzi").start();

    }
}
