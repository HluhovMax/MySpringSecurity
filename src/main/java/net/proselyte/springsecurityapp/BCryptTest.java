package net.proselyte.springsecurityapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by 38066 on 25.01.2019.
 */
public class BCryptTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();
        String adminPass = encoder.encode("moderator");
        System.out.printf(adminPass);
    }
}
