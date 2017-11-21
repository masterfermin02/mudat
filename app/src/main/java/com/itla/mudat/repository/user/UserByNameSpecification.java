package com.itla.mudat.repository.user;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/20/2017.
 */

public class UserByNameSpecification implements SqlSpecification {

    private final String name;

    public UserByNameSpecification(final String name) {
        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = '%3$s';",
                UserSchema.TABLE,
                UserSchema.NAME,
                name
        );
    }
}
