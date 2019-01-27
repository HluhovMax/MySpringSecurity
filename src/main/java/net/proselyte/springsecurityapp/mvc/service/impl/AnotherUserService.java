package net.proselyte.springsecurityapp.mvc.service.impl;

import net.proselyte.springsecurityapp.authentification.dao.UserDao;
import net.proselyte.springsecurityapp.authentification.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 38066 on 27.01.2019.
 */
@Service
public class AnotherUserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.save(user);
    }

    public void delete(Integer id) {
        userDao.deleteById(id);
    }

    public User getById(Integer integer) {
        return userDao.findById(integer).get();
    }

    public List<User> getAll() {
        return userDao.findAll();
    }

    public boolean existsById(Integer integer) {
        return userDao.existsById(integer);
    }
}
