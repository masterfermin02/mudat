package com.itla.mudat.entity;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by maste on 11/25/2017.
 */

public class CategoryTest {

    @Test
    public void it_should_create_new_category() throws Exception
    {
        int id = 0;
        String name = "Category1";

        Category category = new Category();
        category.setName(name);

        String categoryExperted = "Category{" +
                "id=" + id +
                ", name='" + name + "\'" +
                "}";

        assertEquals(categoryExperted, category.toString());
    }
}
