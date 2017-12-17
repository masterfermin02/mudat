package com.itla.mudat.repository.user;

import com.itla.mudat.repository.SqlSpecification;
import com.itla.mudat.schema.UserSchema;

/**
 * Created by maste on 11/20/2017.
 */

public class UserByEmailAndPassSpecification implements SqlSpecification {

    private final String email;
    private final String pass;

    public UserByEmailAndPassSpecification(final String email, final String pass) {
        this.email = email;
        this.pass = pass;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = '%3$s' and `%4$s` = '%5$s' limit 1;",
                UserSchema.TABLE,
                UserSchema.EMAIL,
                email,
                UserSchema.PASS,
                pass
        );
    }
}
