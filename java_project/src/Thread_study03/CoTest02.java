package Thread_study03;

/**
 * 协作模式：信号灯法
 * 借助标志位
 */
public class CoTest02
{
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者 演员
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            if (i%2==0){
                this.tv.play("奇葩说");
            }else {
                this.tv.play("太污了，MDZZ");
            }
        }
    }
}
//消费者 观众
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            this.tv.watch();
        }
    }
}
//同一个资源 电视
class Tv{
    String voice;
    //信号灯
    //T 演员表演，观众等待
    //F 观众观看，演员等待
    boolean flag= true;
    //表演
    public synchronized void play(String voice){
        //演员等待
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //表演时刻
        System.out.println("表演了:"+voice);
        this.voice = voice;
        //唤醒
        this.notifyAll();
        this.flag=!this.flag;
    }
    //观看
    public synchronized void watch(){
        //观众等待
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了:"+voice);
        ///唤醒
        this.notifyAll();
        //切换标志
        this.flag=!this.flag;
    }

}