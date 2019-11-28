package sxt;

import java.util.*;

/**
 * 测试迭代器
 *
 */

public class TestIterator {
    public static void main(String[] args){
//        testIterator();
        testIteratorset();
    }
    public static void testIterator(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    public static void testIteratorset(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        for (Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
}
