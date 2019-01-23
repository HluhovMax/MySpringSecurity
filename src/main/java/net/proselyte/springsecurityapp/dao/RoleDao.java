package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByName(String role);
}
