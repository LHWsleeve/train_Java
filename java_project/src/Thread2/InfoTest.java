package Thread2;

/**
 * 其他方法
 * isAlive()
 * Thread.currentThread():表示当前线程
 * setName、getname：代理名称，即线程的名字
 */
public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        //设置角色：真实角色，代理绝色
        MyIfo info = new MyIfo("战斗机");
        Thread t = new Thread(info);
        t.setName("公鸡");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
//        MyIfo info2 = new MyIfo("")
    }
}

class MyIfo implements Runnable{
    private String name;

    MyIfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---👉"+name);
    }
}