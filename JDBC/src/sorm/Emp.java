package sorm;

import java.util.Date;
//表结构和类对应

public class Emp {
    private  Integer employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String job_id;
    private Integer phone_number;
    private Double salary;
    private Float commission_pct;
    private  Integer manager_id;
    private  Integer department_id;
    private Date hiredate;

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Float getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(Float commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    Emp(String first_name, String last_name, String email, String job_id, Integer phone_number, Double salary, Float commission_pct, Integer manager_id, Integer department_id, Date hiredate) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.job_id = job_id;
        this.phone_number = phone_number;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_id = manager_id;
        this.department_id = department_id;
        this.hiredate = hiredate;
    }

    Emp(Integer employee_id, String first_name, String last_name, String email, String job_id, Integer phone_number, Double salary, Float commission_pct, Integer manager_id, Integer department_id, Date hiredate) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.job_id = job_id;
        this.phone_number = phone_number;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_id = manager_id;
        this.department_id = department_id;
        this.hiredate = hiredate;
    }

    public Emp(Integer employee_id, String last_name) {
        this.employee_id = employee_id;
        this.last_name = last_name;
    }

    Emp() {
    }
}
