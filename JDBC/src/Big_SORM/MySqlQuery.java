package Big_SORM;

import po.Employees;
import java.util.List;

public class MySqlQuery extends Query {
public static void testDML(){
    Employees e =new Employees();
    e.setEmployee_id(206);
//        new MySqlQuery().delect(e);
    e.setDepartment_id(50);
    e.setJob_id("IT_PROG");
    e.setLast_name("xxxxx");
    e.setFirst_name("b");
    e.setSalary((double) 13000);
//        new MySqlQuery().insert(e);
    new MySqlQuery().update(e,new String[]{"Last_name"});
}

    public static void main(String[] args) {
       List list = new MySqlQuery().queryRows("select * from employees where employee_id>? and salary>?"
       ,Employees.class,new Object[]{200,5000});
        System.out.println(list);
    }

    @Override
    public Object querypage(int pageNum, int size) {
        return null;
    }
}
