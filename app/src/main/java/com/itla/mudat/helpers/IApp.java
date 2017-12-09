package com.itla.mudat.helpers;

import android.content.Context;
import android.content.Intent;

import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;

/**
 * Created by maste on 11/30/2017.
 */

public class IApp {

    private static User userLogged;



    public static void setUserLogged(User user)
    {
        userLogged = user;
    }

    public static User getUserLogged()
    {
        return userLogged;
    }

    public  static boolean userIsLogged()
    {
        return userLogged != null;
    }

    public static boolean isPublicador()
    {
        return userLogged.getUserType() == UserType.PUBLICADOR;
    }

}
