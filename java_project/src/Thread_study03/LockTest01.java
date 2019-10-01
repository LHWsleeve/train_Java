package Thread_study03;

/**
 * 不可重入锁：锁不可以延续使用
 * 该代码死锁，不释放
 */
public class LockTest01 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        b();
        lock.unlock();
    }
//不可重入锁
    public void b() throws InterruptedException {
        lock.lock();
        //....
        lock.unlock();

    }
    public static void main(String[] args) throws InterruptedException {
        LockTest01 test = new LockTest01();
        test.a();
        test.b();

    }
}

class Lock{
    //是否占用
    private  boolean isLock = false;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLock){
           wait();
        }
        isLock = true;
    }
    //释放锁
    public synchronized void unlock(){
        isLock=false;
        notifyAll();
    }
}
