package Thread_study03;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 */
public class HappyCinema2 {
    public static void main(String[] args) {
        //可用位置
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(6);
        available.add(7);

        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);

        SxtCinema c = new SxtCinema(available,"happy cinema");
        new Thread(new HappyCustomer(c,seats1),"一号").start();
        new Thread(new HappyCustomer(c,seats2),"二号").start();
    }
}

class HappyCustomer implements Runnable{
    SxtCinema cinema;
    List<Integer> seats;

    public HappyCustomer(SxtCinema cinema, List<Integer> seats) {
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
class SxtCinema {
    List<Integer> available;
    String name;
    public SxtCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean BookTikcets(List<Integer> seats){
        System.out.println("欢迎光临"+this.name+"当前可用位置：---"+available);
        System.out.println("可用位置:"+available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);

        //相减
        copy.removeAll(seats);
        //判断大小
        if (available.size()-copy.size()!=seats.size())
        {
            return false;
        }
        //成功
        available = copy;
        return true;
    }
}

