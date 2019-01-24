package net.proselyte.springsecurityapp.mvc.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 38066 on 24.01.2019.
 */

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private int salary;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "hire_date")
    private Date hire;
    @OneToMany
    @JoinTable(name = "department_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Department department;

    public Employee() {
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHire() {
        return hire;
    }

    public void setHire(Date hire) {
        this.hire = hire;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", hire=" + hire +
                ", department=" + department +
                '}';
    }
}
