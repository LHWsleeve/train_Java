package Thread2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 * sleep是一个静态方法，写在某一个线程体中，谁运行谁阻塞。
 * sleep一般模拟网络延时或跟时间有关的
 * sleep不会触发锁
 */
public class BlockSleep03 {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endTime = new Date(System.currentTimeMillis() + 100 * 10);
        long end = endTime.getTime();
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(100);
            endTime = new Date(endTime.getTime() - 100);
            if (end - 1000 > endTime.getTime()) {
                break;
            }
        }
    }
}
