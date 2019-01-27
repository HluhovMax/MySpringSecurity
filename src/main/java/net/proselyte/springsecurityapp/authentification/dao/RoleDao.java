package net.proselyte.springsecurityapp.authentification.dao;

import net.proselyte.springsecurityapp.authentification.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByName(String role);
}
