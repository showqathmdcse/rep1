package org.example;

import com.java.login.dao.LoginDao;
import com.java.login.dto.User;
import com.java.login.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogin {
    private LoginDao ld = new LoginDao();
    private User user = new User();
    private LoginService ls=new LoginService();

    @Test

    public void testAunthicateTrue() {
//        boolean act=false;
        user.setUserName("admin");
        user.setPassword("admin");
        boolean exp = ld.authenticate(user);
        assertTrue(exp);
    }

    @Test

    public void testAunthicateFalse() {
//        boolean act=false;
        user.setUserName("admin");
        user.setPassword("admi");
        boolean exp = ld.authenticate(user);
        assertFalse(exp);
    }

    @Test
    public void testAunthicateNull() {
        assertThrows(NullPointerException.class, () -> {
            boolean exp = ld.authenticate(user);
        });
    }

    @Test
    public void testAunthicateEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUserName("");
            user.setPassword("as");
            boolean exp = ld.authenticate(user);
        });
    }

    @Test
    public void testAunthicateLoginService() {
        assertThrows(NullPointerException.class, () -> {
            ls.auntheticate(user);
        });

    }
    @Test
    public void testMany(){
      assertAll(()->{
                  user.setUserName("admin");
                  user.setPassword("admi");
                  boolean exp = ld.authenticate(user);
                  assertFalse(exp);
              },
              ()-> {
                  user.setUserName("admin");
                  user.setPassword("admin");
                  boolean exp = ld.authenticate(user);
                  assertTrue(exp);
              });
    }
}


