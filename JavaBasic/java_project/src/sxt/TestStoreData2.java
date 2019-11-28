package sxt;

import java.util.*;

/**
 * javabean+map
 */
public class TestStoreData2 {
    public static void main(String[] args){
        User user1 = new User(1001, "张三", 2000, "20000101");
        User user2 = new User(1002, "李四", 20000, "120000101");
        User user3 = new User(1003, "王五", 200000, "220000101");
        User user4 = new User(1004, "赵六", 2000000, "320000101");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        for(User u:list){
            System.out.println(u);
        }
        Map<Integer,User> map = new HashMap<>();
        map.put(1001,user1);
        map.put(1002,user2);
        map.put(1003,user3);
        map.put(1004,user4);
        Set<Integer> keys = map.keySet();
        for (Integer key:keys){
            System.out.println(key+"===="+map.get(key));
        }
    }
}



class  User{
    private int d;
    private  String name;
    private  double salary;
    private String hiredate;

    public  User(){}

    public User(int d, String name, double salary, String hiredate) {
        this.d = d;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public int getD() {
        return d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public void setD(int d) {
        this.d = d;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:"+d+",name:"+name+",salary:"+salary+",hiredate:"+hiredate;
    }
}