package com.itla.mudat.repository.adsense;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.AdsenseSchema;
import com.itla.mudat.schema.CategorySchema;

/**
 * Created by maste on 11/25/2017.
 */

public class AdsenseByTitleSpecification implements SqlSpecification {

    public final String title;

    public AdsenseByTitleSpecification(final String title)
    {

        this.title = title;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = '%3$s';",
                AdsenseSchema.TABLE,
                AdsenseSchema.TITLE,
                title
        );
    }
}
