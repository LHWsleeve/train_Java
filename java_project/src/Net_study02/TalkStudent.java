package Net_study02;

/**
 * 加入多线程，模拟在线交流
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();//发送
        new Thread(new TalkeReveive(8888,"老师")).start();//接受

    }
}
