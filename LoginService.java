package com.java.login.service;

import com.java.login.dao.LoginDao;
import com.java.login.dto.User;

public class LoginService {

    private LoginDao ld=new LoginDao();

    public boolean auntheticate(User user){

        if(ld==null)
        {
            throw new NullPointerException();
        }
        return ld.authenticate(user);
    }
}
