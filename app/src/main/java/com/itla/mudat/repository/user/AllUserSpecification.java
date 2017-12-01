package com.itla.mudat.repository.user;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/30/2017.
 */

public class AllUserSpecification implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s ",
                UserSchema.TABLE
        );
    }
}
