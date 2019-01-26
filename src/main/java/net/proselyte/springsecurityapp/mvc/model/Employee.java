package net.proselyte.springsecurityapp.mvc.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @ManyToMany(mappedBy = "employees")
    private Set<Department> department;

    public Employee() {
        if (department == null) {
            department = new HashSet<>();
        }
    }
}
