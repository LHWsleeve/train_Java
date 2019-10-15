package ORM;

@Table("tb_student")
public class SxtStudent {
    @sxtField(columnName = "id",type = "int", lenth = 10)
    private int id;
    @sxtField(columnName = "name",type = "varchar", lenth = 10)
    private String name;
    @sxtField(columnName = "age",type = "int", lenth = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
