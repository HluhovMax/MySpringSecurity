package net.proselyte.springsecurityapp.service;

/**
 * Created by 38066 on 24.01.2019.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
