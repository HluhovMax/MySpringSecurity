package net.proselyte.springsecurityapp.mvc.service;

import net.proselyte.springsecurityapp.mvc.model.Department;

import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
public interface DepartmentService extends GenericService<Department, Integer> {

    @Override
    void save(Department department);

    @Override
    void delete(Integer id);

    @Override
    List<Department> getAll();

    @Override
    Department getById(Integer id);

    @Override
    void update(Department department);
}
