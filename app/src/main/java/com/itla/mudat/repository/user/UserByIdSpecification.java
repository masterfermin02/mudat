package com.itla.mudat.repository.user;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/20/2017.
 */

public class UserByIdSpecification implements SqlSpecification {

    private final int id;

    public UserByIdSpecification(final int id) {
        this.id = id;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = %3$d;",
                UserSchema.TABLE,
                UserSchema.ID,
                id
        );
    }
}
