
    public class Flower{
    int petalCount=0;
    String s = "initial value";
    Flower(int petal){
        System.out.println("1:"+petalCount);
    }
    Flower(String ss){
        System.out.println("2:"+ss);
        s =ss;
    }
    Flower(String s,int petal){
        this(petal);
        System.out.println("3");
    }
    Flower(){
        this("hi",47);
        System.out.println("4");
    }
    void printPetalCount(){
        System.out.println(petalCount+": s="+s);
    }

        public static void main(String[] args) {

        Flower f = new Flower();
            //调用流程 1.实例化Flower（）-->2.无参构造器中有this（string，int），实例化xxx -->
            // 3.实例化this（int）-->4.输出第一个，第三个，第四个，和最后一个
        f.printPetalCount();
        }

}
