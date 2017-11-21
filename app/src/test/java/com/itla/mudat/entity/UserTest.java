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
        int id = 0;
        String name = "Mario";
        UserType userType = UserType.CLIENTE;
        String identity = "123456";
        String email = "test@email.com";
        String phone = "8095556565";
        String pass = "123456";
        Boolean status = Boolean.TRUE;

        User user = new User();
        user.setName(name);
        user.setUserType(userType);
        user.setIdentity(identity);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPass(pass);
        user.setStatus(status);


        String userExpert = "UserSchema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userType='" + userType + '\'' +
                ", identity='" + identity + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pass='" + pass + '\'' +
                ", status='" + status + '\'' +
                '}';

        assertEquals(userExpert, user.toString());

    }

}
