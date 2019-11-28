package sxt;

import java.util.*;

public class TestStoreData {
    public static void main(String[] args){
        Map<String,Object> map = new HashMap<>();
        map.put("id", 1001);
        map.put("姓名", "李四");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("id", 1002);
        map2.put("姓名", "王五");

        List<Map<String, Object>> table = new ArrayList<>();
        table.add(map);
        table.add(map2);
        for (Map<String, Object> row:table){
            Set<String> keyset = row.keySet();
            for (String key:keyset){
                System.out.print(key+":"+row.get(key)+" ");
            }
            System.out.println();
        }

    }
}
