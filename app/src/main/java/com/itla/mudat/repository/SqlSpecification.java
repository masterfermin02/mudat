package com.itla.mudat.repository;

/**
 * Created by maste on 11/20/2017.
 */

public interface SqlSpecification extends Specification {
    String toSqlQuery();
}
