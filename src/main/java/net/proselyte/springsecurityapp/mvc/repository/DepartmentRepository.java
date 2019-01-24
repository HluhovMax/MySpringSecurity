package net.proselyte.springsecurityapp.mvc.repository;

import net.proselyte.springsecurityapp.mvc.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 38066 on 24.01.2019.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
}
