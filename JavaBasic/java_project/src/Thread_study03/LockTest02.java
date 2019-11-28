package Thread_study03;

/**
 * 可重入锁：锁可以延续使用
 */
public class LockTest02 {
    Lock2 lock = new Lock2();
    public void a() throws InterruptedException {
        lock.lock();
        b();
        lock.unlock();
    }
//可重入锁
    public void b() throws InterruptedException {
        lock.lock();
        //....
        lock.unlock();

    }
    public static void main(String[] args) throws InterruptedException {
        LockTest02 test = new LockTest02();
        test.a();
        test.b();

    }
}

class Lock2{
    //是否占用
    private  boolean isLock = false;
    private Thread lockedBy = null;//存储线程
    private int holdCount = 0;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLock&&lockedBy!=t){
           wait();
        }
        isLock = true;
        lockedBy = t;
        holdCount++;
    }
    //释放锁
    public synchronized void unlock(){
        if (Thread.currentThread()==lockedBy){
            holdCount--;
            if (holdCount==0){
                isLock=false;
                notifyAll();
                lockedBy=null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}
