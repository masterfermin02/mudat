package com.itla.mudat.repository.category;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.CategorySchema;

/**
 * Created by maste on 11/25/2017.
 */

public class AllCategorySpecificacion implements SqlSpecification {

    @Override
    public String toSqlQuery() {
     return String.format(
             "SELECT * FROM %1$s ;",
             CategorySchema.TABLE);
    }
}
