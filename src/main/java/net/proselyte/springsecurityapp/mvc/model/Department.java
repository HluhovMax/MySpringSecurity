package net.proselyte.springsecurityapp.mvc.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 38066 on 24.01.2019.
 */
@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "department", targetEntity = Employee.class)
    private Set<Employee> employees;
}
