package net.proselyte.springsecurityapp.mvc.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Created by 38066 on 24.01.2019.
 */
@Data
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
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", hire=" + hire +
                ", department=" + department.getName() +
                '}';
    }
}
