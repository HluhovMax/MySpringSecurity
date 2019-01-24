package net.proselyte.springsecurityapp.authentification.dao;

import net.proselyte.springsecurityapp.authentification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
