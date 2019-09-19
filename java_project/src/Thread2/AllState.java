package Thread2;

/**
 * 观察线程的状态
 *
 */

public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(".........");
            }
        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state);//NEW 状态

        t.start();
        state = t.getState();//RUNNABLE
        System.out.println(state);

//        while (state!=Thread.State.TERMINATED){
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            state = t.getState();//time-waiting
//            System.out.println(state);
//        }
        while (true){
            int num = Thread.activeCount();//活动的线程数
            System.out.println(num);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();//time-waiting
            System.out.println(state);
        }
//        state = t.getState();//tweminated
//        System.out.println(state);
    }
}
