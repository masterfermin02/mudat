package com.itla.mudat.entity;

import java.io.Serializable;

/**
 * Created by maste on 11/18/2017.
 */

public class Category implements Serializable {

    protected int id;
    protected String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
