package com.itla.mudat.repository.adsense;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.AdsenseSchema;

/**
 * Created by maste on 11/21/2017.
 */

public class DeleteAdsenseByTitleSpecification implements SqlSpecification {

    private final String title;

    public DeleteAdsenseByTitleSpecification(final String title) {
        this.title = title;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "DELETE FROM %1$s WHERE `%2$s` = '%3$s';",
                AdsenseSchema.TABLE,
                AdsenseSchema.TITLE,
                title
        );
    }
}
