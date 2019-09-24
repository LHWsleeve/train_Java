package Thread_study03;

import java.util.List;

/**
 * 快乐影院
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema c = new Cinema(2,"happy cinema");
        new Thread(new Customer(c,2),"一号").start();
        new Thread(new Customer(c,1),"二号").start();
    }
}

class Customer implements Runnable{
    Cinema cinema;
    List<Integer> seats;

    public Customer(Cinema cinema, List<Integer> seats) {
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
    List<Integer> available;
    String name;
    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean BookTikcets(List<Integer> seats){
        System.out.println("可用位置:"+available);



}

