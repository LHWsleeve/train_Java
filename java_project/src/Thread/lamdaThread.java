package Thread;

/**
 * lamda表达式 简化线程（用一次）
 * 创建线程方式一：
 * 继承Tread+重写run
 */
public class lamdaThread {
    //静态内部类
    static class Test extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("听歌");
            }
        }
    }

    public static void main(String[] args) {
        //创建启动对象

        Test t = new Test();
        t.start(); //线程启动，听歌coding双路并行，执行顺序不一定
//        st.run();//方法调用，所以必须先执行完st.run，才能执行coding

        //局部内部类
        class Test2 extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("听歌");
                }
            }
        }

        new Thread(new Test2()).start();

        //匿名内部类，必须借助接口或者父类
        new Thread(new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("听歌");
                }
            }

        }).start();
        //JDK8简化lamda,仅限于接口只有一个方法。一个方法可以自动推到
        new Thread(()-> {
            for (int i = 0; i < 20; i++) {
            System.out.println("听歌");
            }
        }
        ).start();
    }
}