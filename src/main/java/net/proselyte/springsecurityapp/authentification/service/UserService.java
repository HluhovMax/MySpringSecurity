package net.proselyte.springsecurityapp.authentification.service;

import net.proselyte.springsecurityapp.authentification.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
