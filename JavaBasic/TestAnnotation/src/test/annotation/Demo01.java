package test.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01  {

    @Override
    public String toString  (){
    return "";
    }

    @Deprecated
    public static void test001(){

    }
    @SuppressWarnings("all")
    public static void test002(){
        List list = new ArrayList();
        List list2 = new ArrayList();

    }
    public static void main(String[] args) {
        Date date = new Date();
        test001();
    }
}
