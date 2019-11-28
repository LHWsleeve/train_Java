package Thread_study03;

/**
 * 协作模型：生产者消费者实现方式：管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer02 container = new SynContainer02();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer02 contanier;
    public Productor(SynContainer02 contanier) {
        this.contanier = contanier;
    }

    @Override
    public void run() {
        //生产
        for (int i=0;i<1000;i++){
            System.out.println("生产--第"+i+"个馒头");
            contanier.push(new Steamdbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer02 contanier;
    public Consumer(SynContainer02 contanier) {
        this.contanier = contanier;
    }
    @Override
    public void run() {
        //消费
        for (int i=0;i<100;i++){
            System.out.println("消费--第"+contanier.pop().id+"个馒头");
        }
    }
}
//缓冲区
 class SynContainer02{
    Steamdbun[] buns = new Steamdbun[10];
    int count = 0;
    //存储 生产
    public synchronized void push(Steamdbun bun){
        //何时生产 容器存在空间
        //不能生产
        if (count==buns.length){
            try {
                this.wait();//线程阻塞，通知消费者线程解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        //存在数据，通知消费
        this.notifyAll();
    }
    //获取 消费
    public synchronized Steamdbun pop(){
        //何时消费，容器中是否有数据
        //没有数据只有等待
        if (count==0){
            try {
                this.wait();//此时线程阻塞生产者通知消费，阻塞接触
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        Steamdbun bun = buns[count];
        this.notifyAll();//存在空间，换新通知生产
        return bun;
    }

}
//数据
class Steamdbun{
int id;

    public Steamdbun(int id) {
        this.id = id;
    }
}