package Thread;
/**
 * lamda+参数
 */

public class LamdaTest01 {
    public static void main(String[] args) {
        Ilike like = new Like();
        like.lamda(0);
//lamda+参数
        Ilike like2 = new Like();

        // 如果只有一个参数，括号也可以省略
        //如果只有一行代码，花括号也可以省略
        //like2 = a->System.out.println("I like"+a);

        //如果有返回值
        //如果只有一行代码，return可以省略。直接返回
        // like3 = (a,b)->a+b；

        like2 = (int a)->{
            System.out.println("I like"+a);
        };
        like2.lamda(2);
    }
}

interface Ilike{
    void lamda(int a);
}
class Like implements Ilike{

    @Override
    public void lamda(int a ) {
        System.out.println("i like lamda"+a);
    }
}