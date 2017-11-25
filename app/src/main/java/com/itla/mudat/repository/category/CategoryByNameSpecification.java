package com.itla.mudat.repository.category;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.CategorySchema;

/**
 * Created by maste on 11/25/2017.
 */

public class CategoryByNameSpecification implements SqlSpecification {

    public final String name;

    public CategoryByNameSpecification(final String name)
    {

        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = '%3$s';",
                CategorySchema.TABLE,
                CategorySchema.NAME,
                name
        );
    }
}
