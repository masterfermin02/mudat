package com.itla.mudat.repository.category;

import android.database.Cursor;

import com.itla.mudat.entity.Category;
import com.itla.mudat.mappers.Mapper;
import com.itla.mudat.schema.CategorySchema;

/**
 * Created by maste on 11/25/2017.
 */

public class CursorToCategoryMapper implements Mapper<Cursor,Category> {

    public Category map(Cursor cursor)
    {
        Category category = new Category();
        category.setId(cursor.getInt(cursor.getColumnIndex(CategorySchema.ID)));
        category.setName(cursor.getString(cursor.getColumnIndex(CategorySchema.NAME)));

        return category;
    }
}
