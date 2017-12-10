package com.itla.mudat.repository.adsense;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.AdsenseSchema;
import com.itla.mudat.schema.CategorySchema;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/25/2017.
 */

public class AllAdsenseSpecificacion implements SqlSpecification {

    @Override
    public String toSqlQuery() {
     return "SELECT "+AdsenseSchema.fields +","+
             UserSchema.TABLE+"."+UserSchema.NAME+" as "+UserSchema.JOIN_NAME+","+
             CategorySchema.TABLE+"."+CategorySchema.NAME+ " as "+CategorySchema.JOIN_NAME +
        " FROM  "+AdsenseSchema.TABLE +
                " JOIN "+ UserSchema.TABLE+" on "+AdsenseSchema.TABLE+"."+AdsenseSchema.USERID+" = "+UserSchema.TABLE+"."+UserSchema.ID+
                " JOIN "+ CategorySchema.TABLE+" on "+AdsenseSchema.TABLE+"."+AdsenseSchema.CATEGORYID+" = "+CategorySchema.TABLE+"."+CategorySchema.ID;
    }
}
