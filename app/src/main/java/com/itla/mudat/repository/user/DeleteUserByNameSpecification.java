package com.itla.mudat.repository.user;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/21/2017.
 */

public class DeleteUserByNameSpecification implements SqlSpecification {

    private final String name;

    public DeleteUserByNameSpecification(final String name) {
        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "DELETE FROM %1$s WHERE `%2$s` = '%3$s';",
                UserSchema.TABLE,
                UserSchema.NAME,
                name
        );
    }
}
