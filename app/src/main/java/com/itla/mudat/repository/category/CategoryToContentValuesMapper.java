package com.itla.mudat.repository.category;

import android.content.ContentValues;

import com.itla.mudat.entity.Category;
import com.itla.mudat.repository.Mapper;
import com.itla.mudat.schema.CategorySchema;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/25/2017.
 */

public class CategoryToContentValuesMapper implements Mapper<Category,ContentValues> {

    public ContentValues map(Category category)
    {
        ContentValues values = new ContentValues();
        values.put(CategorySchema.NAME, category.getName());
        return values;
    }

}
