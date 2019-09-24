package Thread_study03;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 */
public class HappyCinema {
    public static void main(String[] args) {
        //可用位置
        Cinema c = new Cinema(2,"happy cinema");
        new Thread(new Customer(c,2),"一号").start();
        new Thread(new Customer(c,1),"二号").start();
    }
}

class Customer implements Runnable{
    private final Cinema cinema;
    private int seats;

    Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.BookTikcets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "--位置为--" + seats);
            }else {
                System.out.println("位置不够" + Thread.currentThread().getName());
            }
        }
    }
}



//影院
class Cinema {
    int available;
    String name;
    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean BookTikcets(int seats){
        System.out.println("可用位置:"+available);
        if (seats>available){
            return false;
        }else {
            available-=seats;
        }
            return true;
        }
}

