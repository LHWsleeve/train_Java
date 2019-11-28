package Thread_study03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全：操作并发容器
 */
public class SynContainer {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i=0;i<10000;i++){
            new Thread(()->{
                    list.add(Thread.currentThread().getName());
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