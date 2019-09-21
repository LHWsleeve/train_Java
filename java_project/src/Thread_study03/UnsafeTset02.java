package Thread_study03;

/**
 * 取钱，线程不安全
 */
public class UnsafeTset02 {
    public static void main(String[] args) {
        Account account = new Account(100,"礼金");
        Drawing you = new Drawing(account,80,"可悲的你");
        Drawing wifi = new Drawing(account,90,"happy的她");
        you.start();
        wifi.start();

    }
}

class Account {
    int money;
    String name;

    Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//模拟取款机
class Drawing extends Thread{
    private Account account;//取钱账户
    private int drawMoney;//取得钱
    private int packetToal;//口袋的钱

   public Drawing(Account account, int drawMoney, String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
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