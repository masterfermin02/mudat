package com.itla.mudat.schema;

/**
 * Created by maste on 11/19/2017.
 */

public class Adsense {

    public static final String TABLE = "adsense";
    public static final String ID = "id";
    public static final String USERID = "userId";
    public static final String CATEGORYID = "categoryId";
    public static final String CREATED_AT = "created_at";
    public static final String PRICE = "price";
    public static final String LOCATION = "location";
    public static final String DETAILS = "details";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `"+TABLE+"` ("+
            "`"+ID+"`	INTEGER PRIMARY KEY AUTOINCREMENT,"+
	        "`"+USERID+"`	INTEGER,"+
            "`"+CATEGORYID+"`	INTEGER,"+
            "`"+CREATED_AT+"`	TEXT,"+
            "`"+PRICE+"`	REAL,"+
            "`"+LOCATION+"`	TEXT,"+
            "`"+DETAILS+"`	TEXT"+
            ");";
}
