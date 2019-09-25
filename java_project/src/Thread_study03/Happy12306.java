package Thread_study03;

/**
 * 快乐火车票
 */
public class Happy12306 {
    public static void main(String[] args) {
        //可用位置
        Web12306 c = new Web12306(3,"happy sxt");
        new Passenger(c,"一号",2).start();
        new Passenger(c,"二号",1).start();

    }
}

//加代理
class Passenger extends Thread {
    int seats;
    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}

    //火车票
    class Web12306 implements Runnable {
        private int available;
        private String name;

         Web12306(int available, String name) {
            this.available = available;
            this.name = name;
        }

        @Override
        public void run() {
            Passenger p = (Passenger)Thread.currentThread();//获取当前线程，强转型，获取属性
            boolean flag = this.BookTikcets(p.seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "--位置为--" + p.seats);
            } else {
                System.out.println("位置不够" + Thread.currentThread().getName());
            }
        }
        //同步方法
        public synchronized boolean BookTikcets(int seats) {
            System.out.println("可用位置:" + available);
            if (seats > available) {
                return false;
            } else {
                available -= seats;
            }
            return true;
        }
    }