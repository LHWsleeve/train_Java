package Thread;


public class RunableThread implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("唱歌");
        }
    }
    public static void main(String[] args){
        //创建实现类对象
        RunableThread st = new RunableThread();
        //创建代理类对象
        Thread t = new Thread(st);
        t.start();
        for (int i=0;i<20;i++){
            System.out.println("coding");
        }

    }
}
