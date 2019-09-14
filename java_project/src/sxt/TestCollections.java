package sxt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
                list.add("abc:"+i);
         }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
    }