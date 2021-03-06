package Thread;

/**
 * 静态代理
 * 公共接口：
 * 1.真实角色
 * 2.代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingComoany(new You()).happyMarry();
    }
}
interface Marry{
    void happyMarry();
}
//真实角色
class You implements Marry{
    public void happyMarry(){
        System.out.println("me and jtt 发财了");
        }
}
//代理角色
class  WeddingComoany implements Marry{
    private Marry target;

    public WeddingComoany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }
    private void ready(){
        System.out.println("准备好了");
    }
    private void after(){
        System.out.println("结束");
    }
}