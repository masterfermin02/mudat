package com.itla.mudat.entity;

import org.junit.Test;
import android.util.Log;

import static org.junit.Assert.assertEquals;

/**
 * Created by maste on 11/18/2017.
 */

public class UserTest {

    @Test
    public void saveUser() throws Exception{
        User user = new User();
        user.setName("Mario");
        user.setUserType(UserType.CLIENTE);
        user.setIdentity("123456");
        user.setEmail("test@email.com");
        user.setPhone("8095556565");
        user.setPass("123456");
        user.setStatus(Boolean.TRUE);

        User userExpert = new User();
        userExpert.setName("Mario");
        userExpert.setUserType(UserType.CLIENTE);
        userExpert.setIdentity("123456");
        userExpert.setEmail("test@email.com");
        userExpert.setPhone("8095556565");
        userExpert.setPass("123456");
        userExpert.setStatus(Boolean.TRUE);

        assertEquals(userExpert.toString(), user.save());

    }

}
