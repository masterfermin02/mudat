package com.itla.mudat.repository.adsense;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.itla.mudat.entity.Adsense;
import com.itla.mudat.mappers.Mapper;
import com.itla.mudat.repository.Repository;
import com.itla.mudat.repository.Specification;
import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.repository.category.CategorySqlRepository;
import com.itla.mudat.repository.user.UserSqlRepository;
import com.itla.mudat.schema.AdsenseSchema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by maste on 11/25/2017.
 */

public class AdsenseSqlRepository implements Repository<Adsense> {

    private final SQLiteOpenHelper openHelper;

    private final Mapper<Adsense, ContentValues> toContentValuesMapper;
    private final Mapper<Cursor, Adsense> toAdsenseMapper;

    public AdsenseSqlRepository(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;

        this.toContentValuesMapper = new AdsenseToContentValuesMapper();
        this.toAdsenseMapper = new CursorToAdsenseMapper(new CategorySqlRepository(openHelper), new UserSqlRepository(openHelper));
    }

    @Override
    public void add(Adsense item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<Adsense> items) {
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            for (Adsense item : items) {
                final ContentValues contentValues = toContentValuesMapper.map(item);

                database.insert(AdsenseSchema.TABLE, null, contentValues);
            }

            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public void update(Adsense item) {
        // TODO to be implemented
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
        String[] parameters={item.getId().toString()};

        try {
            final ContentValues contentValues = toContentValuesMapper.map(item);
            database.update(AdsenseSchema.TABLE, contentValues, AdsenseSchema.ID +" = ?",parameters);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public Adsense get(Specification specification)
    {
        return query(specification).get(0);
    }

    @Override
    public void remove(Adsense item) {
        // TODO to be implemented
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
        String[] parameters={item.getId().toString()};

        try {
            database.delete(AdsenseSchema.TABLE, AdsenseSchema.ID +" = ?",parameters);
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
    public List<Adsense> query(Specification specification) {
        final SqlSpecification sqlSpecification = (SqlSpecification) specification;

        final SQLiteDatabase database = openHelper.getReadableDatabase();
        final List<Adsense> categories = new ArrayList<>();

        try {
            final Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery(), new String[]{});

            for (int i = 0, size = cursor.getCount(); i < size; i++) {
                cursor.moveToPosition(i);

                categories.add(toAdsenseMapper.map(cursor));
            }

            cursor.close();

            return categories;
        } finally {
            database.close();
        }
    }

}
