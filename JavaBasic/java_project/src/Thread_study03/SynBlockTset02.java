package Thread_study03;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：操作容器,同步块
 */
public class SynBlockTset02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<10000;i++){
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
            }
        try {
            Thread.sleep(100);//若没有延迟，子线程未结束就过早打印
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}