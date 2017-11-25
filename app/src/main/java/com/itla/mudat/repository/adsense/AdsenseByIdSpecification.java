package com.itla.mudat.repository.adsense;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.AdsenseSchema;

/**
 * Created by maste on 11/25/2017.
 */

public class AdsenseByIdSpecification implements SqlSpecification {

    public final int id;

    public AdsenseByIdSpecification(final int id)
    {

        this.id = id;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = '%3$s';",
                AdsenseSchema.TABLE,
                AdsenseSchema.ID,
                id
        );
    }
}
