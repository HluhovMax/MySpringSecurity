package net.proselyte.springsecurityapp.mvc.service.impl;

import net.proselyte.springsecurityapp.mvc.model.Department;
import net.proselyte.springsecurityapp.mvc.repository.DepartmentRepository;
import net.proselyte.springsecurityapp.mvc.repository.EmployeeRepository;
import net.proselyte.springsecurityapp.mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Integer id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }
}
