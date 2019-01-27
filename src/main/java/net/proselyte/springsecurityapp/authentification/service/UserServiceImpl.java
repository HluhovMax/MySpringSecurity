package net.proselyte.springsecurityapp.authentification.service;

import net.proselyte.springsecurityapp.authentification.dao.RoleDao;
import net.proselyte.springsecurityapp.authentification.dao.UserDao;
import net.proselyte.springsecurityapp.authentification.model.Role;
import net.proselyte.springsecurityapp.authentification.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        if (user.getUsername().equalsIgnoreCase("admin")) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.findByName("ADMIN"));
            user.setRoles(roles);
            userDao.save(user);
            return;
        }
        if (user.getUsername().equalsIgnoreCase("moderator")) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.findByName("MODERATOR"));
            user.setRoles(roles);
            userDao.save(user);
            return;
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.findByName("USER"));
            user.setRoles(roles);
            userDao.save(user);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
