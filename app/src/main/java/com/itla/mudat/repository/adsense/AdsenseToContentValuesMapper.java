package com.itla.mudat.repository.adsense;

import android.content.ContentValues;

import com.itla.mudat.entity.Adsense;
import com.itla.mudat.repository.Mapper;
import com.itla.mudat.schema.AdsenseSchema;

import java.util.ArrayDeque;

/**
 * Created by maste on 11/25/2017.
 */

public class AdsenseToContentValuesMapper implements Mapper<Adsense,ContentValues> {

    public ContentValues map(Adsense adsense)
    {
        ContentValues values = new ContentValues();
        values.put(AdsenseSchema.CATEGORYID, adsense.getCategory().getId());
        values.put(AdsenseSchema.USERID, adsense.getUser().getId());
        values.put(AdsenseSchema.CREATED_AT, adsense.getCreatedAt().toString());
        values.put(AdsenseSchema.CONDICTION, adsense.getCondiction());
        values.put(AdsenseSchema.PRICE, adsense.getPrice());
        values.put(AdsenseSchema.TITLE, adsense.getTitle());
        values.put(AdsenseSchema.LOCATION, adsense.getLocation());
        values.put(AdsenseSchema.DETAILS, adsense.getDetails());
        return values;
    }

}
