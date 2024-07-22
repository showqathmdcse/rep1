package com.java.login.dao;

import com.java.login.dto.User;

public class LoginDao {

    public boolean authenticate(User user) {
        if(user==null){
            throw new NullPointerException("user is null");
        }
        if(user.getUserName().length()==0 || user.getPassword().length()==0){
            throw new IllegalArgumentException("password is null or empty");
        }
        if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
            return true;
        }
        else
            return false;
    }
    }


