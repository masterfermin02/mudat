package com.itla.mudat.schema;

/**
 * Created by maste on 11/19/2017.
 */

public class UserSchema {

    public static final String TABLE = "user";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String USER_TYPE = "userType";
    public static final String IDENTITY = "identity";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PASS = "pass";
    public static final String STATUS = "status";
    public static final String JOIN_NAME = "user_name";


    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `"+TABLE+"` (" +
            "`"+ID+"` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`"+NAME+"` TEXT," +
            "`"+USER_TYPE+"` BLOB," +
            "`"+IDENTITY+"` TEXT," +
            " `"+EMAIL+"` TEXT," +
            "`"+PHONE+"` TEXT," +
            "`"+PASS+"` TEXT," +
            " `"+STATUS+"` INTEGER" +
            ");";

}
