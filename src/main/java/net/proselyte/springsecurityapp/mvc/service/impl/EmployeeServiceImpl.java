package net.proselyte.springsecurityapp.mvc.service.impl;

import net.proselyte.springsecurityapp.mvc.model.Employee;
import net.proselyte.springsecurityapp.mvc.repository.EmployeeRepository;
import net.proselyte.springsecurityapp.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }
}
