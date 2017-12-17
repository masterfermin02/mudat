package com.itla.mudat.helpers;

import android.content.Context;
import android.content.Intent;

import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.repository.user.UserByEmailAndPassSpecification;
import com.itla.mudat.repository.user.UserSqlRepository;

/**
 * Created by maste on 11/30/2017.
 */

public class IApp {

    private static User userLogged;
    private static UserSqlRepository repository;



    public static void setUserLogged(User user)
    {
        userLogged = user;
    }

    public static void setRepository(UserSqlRepository repository)
    {
        repository = repository;
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

    public static User login(String email, String pass){
        setUserLogged(repository.get(new UserByEmailAndPassSpecification(email,pass)));
        return  getUserLogged();
    }


}
