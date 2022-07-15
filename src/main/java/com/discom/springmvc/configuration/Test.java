package com.discom.springmvc.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(new BCryptPasswordEncoder().encode("chauhan"));
    }

}
