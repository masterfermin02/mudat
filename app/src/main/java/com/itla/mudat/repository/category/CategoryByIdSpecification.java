package com.itla.mudat.repository.category;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.CategorySchema;

/**
 * Created by maste on 11/25/2017.
 */

public class CategoryByIdSpecification implements SqlSpecification {

    public final int id;

    public CategoryByIdSpecification(final int id)
    {

        this.id = id;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = '%3$s';",
                CategorySchema.TABLE,
                CategorySchema.ID,
                id
        );
    }
}
