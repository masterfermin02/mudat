package com.itla.mudat.mappers.users;

import android.content.ContentValues;

import com.itla.mudat.entity.User;
import com.itla.mudat.mappers.Mapper;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/20/2017.
 */

public class UserToContentValuesMapper implements Mapper<User,ContentValues> {

    public ContentValues map(User user)
    {
        ContentValues values = new ContentValues();
        values.put(UserSchema.NAME, user.getName());
        values.put(UserSchema.USER_TYPE, user.getUserType().toString());
        values.put(UserSchema.IDENTITY, user.getIdentity());
        values.put(UserSchema.EMAIL, user.getEmail());
        values.put(UserSchema.PHONE, user.getPhone());
        values.put(UserSchema.PASS, user.getPass());
        values.put(UserSchema.STATUS, user.getStatus());
        return values;
    }
}
