package com.itla.mudat.repository.adsense;

import android.database.Cursor;

import com.itla.mudat.entity.Adsense;
import com.itla.mudat.repository.Mapper;
import com.itla.mudat.repository.category.CategoryByIdSpecification;
import com.itla.mudat.repository.category.CategorySqlRepository;
import com.itla.mudat.repository.user.UserByIdSpecification;
import com.itla.mudat.repository.user.UserSqlRepository;
import com.itla.mudat.schema.AdsenseSchema;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * Created by maste on 11/25/2017.
 */

public class CursorToAdsenseMapper implements Mapper<Cursor,Adsense> {

    private CategorySqlRepository categorySqlRepository;
    private UserSqlRepository userSqlRepository;

    public CursorToAdsenseMapper(CategorySqlRepository categorySqlRepository, UserSqlRepository userSqlRepository){
        this.categorySqlRepository = categorySqlRepository;
        this.userSqlRepository = userSqlRepository;
    }

    public Adsense map(Cursor cursor) {
        Adsense adsense = new Adsense();
        adsense.setId(cursor.getInt(cursor.getColumnIndex(AdsenseSchema.ID)));
        adsense.setCategory(
                categorySqlRepository.get(new CategoryByIdSpecification(cursor.getInt(cursor.getColumnIndex(AdsenseSchema.CATEGORYID))))
        );
        adsense.setUser(
                userSqlRepository.get(new UserByIdSpecification(cursor.getInt(cursor.getColumnIndex(AdsenseSchema.USERID))))
        );
        adsense.setCondiction(cursor.getString(cursor.getColumnIndex(AdsenseSchema.CONDICTION)));


        adsense.setCreatedAt(
                this.dateFormatt(cursor)
        );
        adsense.setPrice(cursor.getDouble(cursor.getColumnIndex(AdsenseSchema.PRICE)));
        adsense.setTitle(cursor.getString(cursor.getColumnIndex(AdsenseSchema.TITLE)));
        adsense.setLocation(cursor.getString(cursor.getColumnIndex(AdsenseSchema.LOCATION)));
        adsense.setDetails(cursor.getString(cursor.getColumnIndex(AdsenseSchema.DETAILS)));

        return adsense;
    }

    private Date dateFormatt(Cursor cursor)
    {
        try{
            DateFormat df = DateFormat.getDateInstance();
            return df.parse(cursor.getString(cursor.getColumnIndex(AdsenseSchema.CREATED_AT)));
        }catch (ParseException e){

        }finally {
            return new Date();
        }

    }
}
