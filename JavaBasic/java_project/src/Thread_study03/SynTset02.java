package Thread_study03;

/**
 * 取钱
 * 线程安全:在并发时，保证数据正确性，尽可能效率高
 * synchronized
 * 1.同步方法
 * 2.同步块
 */
public class SynTset02 {
    public static void main(String[] args) {
        Account account = new Account(100,"礼金");
        SafeDrawing you = new SafeDrawing(account,80,"可悲的你");
        SafeDrawing wifi = new SafeDrawing(account,90,"happy的她");
        you.start();
        wifi.start();

    }
}

//模拟取款机
class SafeDrawing extends Thread{
    private Account account;//取钱账户
    private int drawMoney;//取得钱
    private int packetToal;//口袋的钱

   public SafeDrawing(Account account, int drawMoney, String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public  void run() {
       test();
    }

    //目标不对，锁定失败,这里不是锁this，是锁account
    private synchronized void test(){
        if (account.money-drawMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawMoney;
        packetToal+=drawMoney;
        System.out.println(this.getName()+"---👉账户余额为"+account.money);
        System.out.println(this.getName()+"---👉口袋里的钱为"+packetToal);
    }
}