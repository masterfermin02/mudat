package com.itla.mudat.schema;

/**
 * Created by maste on 11/19/2017.
 */

public class Category {

    public static final String TABLE = "category";
    public static final String ID = "id";
    public static final String NAME = "name";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `"+TABLE+"` ("+
        "`"+ID+"` INTEGER PRIMARY KEY AUTOINCREMENT,"+
	    "`"+NAME+"`	TEXT"+
    ");";
}
