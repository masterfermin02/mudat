package com.itla.mudat.helpers;

import com.itla.mudat.schema.Adsense;
import com.itla.mudat.schema.Category;
import com.itla.mudat.schema.UserSchema;

import java.util.Arrays;
import java.util.List;

/**
 * Created by maste on 11/19/2017.
 */

public class DbHelpers {

    public static final List<String> APP_TABLES_NAMES = Arrays.asList(UserSchema.TABLE, Category.TABLE, Adsense.TABLE);
    public static final List<String> APP_CREATE_TABLES = Arrays.asList(UserSchema.CREATE_TABLE, Category.CREATE_TABLE, Adsense.CREATE_TABLE);

}
