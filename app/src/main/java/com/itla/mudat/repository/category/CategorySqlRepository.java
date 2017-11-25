package com.itla.mudat.repository.category;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.itla.mudat.entity.Category;
import com.itla.mudat.entity.Category;
import com.itla.mudat.repository.Mapper;
import com.itla.mudat.repository.Repository;
import com.itla.mudat.repository.Specification;
import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.repository.user.CursorToUserMapper;
import com.itla.mudat.repository.user.UserToContentValuesMapper;
import com.itla.mudat.schema.CategorySchema;
import com.itla.mudat.schema.UserSchema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by maste on 11/25/2017.
 */

public class CategorySqlRepository implements Repository<Category> {

    private final SQLiteOpenHelper openHelper;

    private final Mapper<Category, ContentValues> toContentValuesMapper;
    private final Mapper<Cursor, Category> toCategoryMapper;

    public CategorySqlRepository(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;

        this.toContentValuesMapper = new CategoryToContentValuesMapper();
        this.toCategoryMapper = new CursorToCategoryMapper();
    }

    @Override
    public void add(Category item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<Category> items) {
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            for (Category item : items) {
                final ContentValues contentValues = toContentValuesMapper.map(item);

                database.insert(CategorySchema.TABLE, null, contentValues);
            }

            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public void update(Category item) {
        // TODO to be implemented
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
        String[] parameters={item.getId().toString()};

        try {
            final ContentValues contentValues = toContentValuesMapper.map(item);
            database.update(CategorySchema.TABLE, contentValues,CategorySchema.ID +" = ?",parameters);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public Category get(Specification specification)
    {
        return query(specification).get(0);
    }

    @Override
    public void remove(Category item) {
        // TODO to be implemented
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
        String[] parameters={item.getId().toString()};

        try {
            database.delete(CategorySchema.TABLE, CategorySchema.ID +" = ?",parameters);
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
    public List<Category> query(Specification specification) {
        final SqlSpecification sqlSpecification = (SqlSpecification) specification;

        final SQLiteDatabase database = openHelper.getReadableDatabase();
        final List<Category> categories = new ArrayList<>();

        try {
            final Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery(), new String[]{});

            for (int i = 0, size = cursor.getCount(); i < size; i++) {
                cursor.moveToPosition(i);

                categories.add(toCategoryMapper.map(cursor));
            }

            cursor.close();

            return categories;
        } finally {
            database.close();
        }
    }

}
