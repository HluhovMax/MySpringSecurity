package net.proselyte.springsecurityapp.mvc.service;

import net.proselyte.springsecurityapp.mvc.model.Employee;

import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
public interface EmployeeService extends GenericService<Employee, Integer> {

    @Override
    void save(Employee employee);

    @Override
    void delete(Integer id);

    @Override
    List<Employee> getAll();

    @Override
    Employee getById(Integer id);

    @Override
    void update(Employee employee);
}
