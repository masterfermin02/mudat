package com.itla.mudat.repository.user;

import android.database.Cursor;

import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.repository.Mapper;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/20/2017.
 */

public class CursorToUserMapper implements Mapper<Cursor,User> {

    public User map(Cursor cursor)
    {
        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(UserSchema.ID)));
        user.setName(cursor.getString(cursor.getColumnIndex(UserSchema.NAME)));
        user.setUserType(UserType.valueOf(cursor.getString(cursor.getColumnIndex(UserSchema.USER_TYPE))));
        user.setIdentity(cursor.getString(cursor.getColumnIndex(UserSchema.IDENTITY)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(UserSchema.EMAIL)));
        user.setPhone(cursor.getString(cursor.getColumnIndex(UserSchema.PHONE)));
        user.setStatus(Boolean.valueOf(cursor.getString(cursor.getColumnIndex(UserSchema.STATUS))));

        return user;
    }
}
