package Thread_study03;

/**
 * 取钱
 * 线程安全:在并发时，保证数据正确性，尽可能效率高
 * synchronized
 *
 * 2.同步块，目标更明确
 */
public class SynBlockTest03 {
    public static void main(String[] args) {
        Account account = new Account(100,"礼金");
        SynDrawing you = new SynDrawing(account,80,"可悲的你");
        SynDrawing wifi = new SynDrawing(account,90,"happy的她");
        you.start();
        wifi.start();

    }
}

//模拟取款机,线程安全
class SynDrawing extends Thread{
    private final Account account;//取钱账户
    private int drawMoney;//取得钱
    private int packetToal;//口袋的钱

    SynDrawing(Account account, int drawMoney, String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public  void run() {
       test();
    }

    //目标锁定account
    private  void test() {
        //这个if提高性能
        if (account.money<=0){
            return;
        }
        //同步块
        synchronized (account) {
            if (account.money - drawMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawMoney;
            packetToal += drawMoney;
            System.out.println(this.getName() + "---👉账户余额为" + account.money);
            System.out.println(this.getName() + "---👉口袋里的钱为" + packetToal);
        }
    }
}