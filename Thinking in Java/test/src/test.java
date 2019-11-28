import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 吸血鬼数
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=10; i<100; i++){
            for (int j=i+1;j<100;j++) {
               int c =i*j;
                if (c < 1000 || c > 9999) {
                    continue;
                }
                list.add(i % 10);//各位
                list.add(i / 10);//十位
                list.add(j % 10);//各位
                list.add(j / 10);//十位
                list2.add(c % 10);//
                list2.add(c / 10 % 10);//
                list2.add(c / 100 % 10);//
                list2.add(c / 1000 % 10);//
                Collections.sort(list);//排序
                Collections.sort(list2);
                if (list.equals(list2)){
                System.out.println("i:"+i+" j:"+j+" c:"+c);
                }
                list.clear();
                list2.clear();
            }
        }
    }
}
