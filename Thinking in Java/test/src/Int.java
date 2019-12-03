import java.util.Arrays;
import java.util.Random;

public class Int {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(5)];
        System.out.println(Arrays.toString(a));
        print(1,2,3,4,5);
    }
    static void print(Object...args){
        for (Object o:args
             ) {
            System.out.println(o);
            System.out.println(o.getClass());
        }
    }
}
