package com.itla.mudat.repository.user;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.itla.mudat.entity.User;
import com.itla.mudat.repository.Mapper;
import com.itla.mudat.repository.Repository;
import com.itla.mudat.repository.Specification;
import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.UserSchema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by maste on 11/20/2017.
 */

public class UserSqlRepository implements Repository<User> {

    private final SQLiteOpenHelper openHelper;

    private final Mapper<User, ContentValues> toContentValuesMapper;
    private final Mapper<Cursor, User> toUserMapper;

    public UserSqlRepository(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;

        this.toContentValuesMapper = new UserToContentValuesMapper();
        this.toUserMapper = new CursorToUserMapper();
    }

    @Override
    public void add(User item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<User> items) {
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            for (User item : items) {
                final ContentValues contentValues = toContentValuesMapper.map(item);

                database.insert(UserSchema.TABLE, null, contentValues);
            }

            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public void update(User item) {
        // TODO to be implemented
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
        String[] parameters={item.getId().toString()};

        try {
            final ContentValues contentValues = toContentValuesMapper.map(item);
            database.update(UserSchema.TABLE, contentValues,UserSchema.ID +" = ?",parameters);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public User get(Specification specification)
    {
        return query(specification).get(0);
    }

    @Override
    public void remove(User item) {
        // TODO to be implemented
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
        String[] parameters={item.getId().toString()};

        try {
            database.delete(UserSchema.TABLE, UserSchema.ID +" = ?",parameters);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public void remove(Specification specification) {
        // TODO to be implemented
        final SqlSpecification sqlSpecification = (SqlSpecification) specification;
        final SQLiteDatabase database = openHelper.getReadableDatabase();

        try {
            database.execSQL(sqlSpecification.toSqlQuery());
        } finally {
            database.close();
        }
    }

    @Override
    public List<User> query(Specification specification) {
        final SqlSpecification sqlSpecification = (SqlSpecification) specification;

        final SQLiteDatabase database = openHelper.getReadableDatabase();
        final List<User> users = new ArrayList<>();

        try {
            final Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery(), new String[]{});

            for (int i = 0, size = cursor.getCount(); i < size; i++) {
                cursor.moveToPosition(i);

                users.add(toUserMapper.map(cursor));
            }

            cursor.close();

            return users;
        } finally {
            database.close();
        }
    }

}

