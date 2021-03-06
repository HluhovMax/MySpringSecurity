package net.proselyte.springsecurityapp.authentification.service;

import net.proselyte.springsecurityapp.authentification.dao.UserDao;
import net.proselyte.springsecurityapp.authentification.model.Role;
import net.proselyte.springsecurityapp.authentification.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        //Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                        user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
