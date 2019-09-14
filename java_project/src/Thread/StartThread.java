package Thread;

/**
 * 创建线程方式一：
 * 继承Tread+重写run
 */
public class StartThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("听歌");
        }
    }
    public static void main(String[] args){
        //创建启动对象
        StartThread st = new StartThread();
        st.start(); //线程启动，听歌coding双路并行，执行顺序不一定
//        st.run();//方法调用，所以必须先执行完st.run，才能执行coding
        for (int i=0;i<20;i++){
            System.out.println("一边coding");
        }
    }
}
