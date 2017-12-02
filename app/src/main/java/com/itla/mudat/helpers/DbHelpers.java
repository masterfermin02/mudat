package com.itla.mudat.helpers;

import android.content.Context;

import com.itla.mudat.dao.ConexionSQLiteHelper;
import com.itla.mudat.schema.AdsenseSchema;
import com.itla.mudat.schema.CategorySchema;
import com.itla.mudat.schema.UserSchema;

import java.util.Arrays;
import java.util.List;

/**
 * Created by maste on 11/19/2017.
 */

public class DbHelpers {

    public static final List<String> APP_TABLES_NAMES = Arrays.asList(UserSchema.TABLE, CategorySchema.TABLE, AdsenseSchema.TABLE);
    public static final List<String> APP_CREATE_TABLES = Arrays.asList(UserSchema.CREATE_TABLE, CategorySchema.CREATE_TABLE, AdsenseSchema.CREATE_TABLE);

    public static final ConexionSQLiteHelper getDbConnection(Context context)
    {
        return new ConexionSQLiteHelper(context,"mudat_db", null, 2);
    }

}
