    class jilei{
        public void c1(){
            System.out.println("123");
        }
    }

public class jicheng extends jilei{
    public void c1(){
        System.out.println("456");
        super.c1();
    }

    public static void main(String[] args) {
//        jilei jl = new jilei();
//        jl.c1();
        jicheng jc = new jicheng();
        jc.c1();
    }
}