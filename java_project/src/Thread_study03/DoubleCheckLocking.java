package Thread_study03;

/**
 * 单例模式：写法多种，我们使用doublechecking(懒汉式基础上加入并发控制)
 * 1.构造器私有化--》避免外部new构造器
 * 2.提供私有的静态属性--》存储对象的地址
 * 3.提供公共的静态方法--》获取属性（对象的地址）
 */
public class DoubleCheckLocking {
    //2.私有静态属性
    private volatile static DoubleCheckLocking instance;//避免指令重排
    //1.构造器私有化
    private DoubleCheckLocking() {

    }
    //3.提供公共静态方法
    public static DoubleCheckLocking getInstance() {
        //再次检测
        if (null!=instance){
            return instance;//避免不必要的同步，双重检测
        }
        synchronized (DoubleCheckLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckLocking();//可能存在指令重排，2太慢，3提前，导致返回空地址
                //1.开辟空间 2.初始化对象信息 3.返回对象引用地址给引用
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckLocking.getInstance());
        });
        t.start();
        System.out.println(DoubleCheckLocking.getInstance());
    }
}
