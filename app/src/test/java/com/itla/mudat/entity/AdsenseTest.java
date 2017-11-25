package com.itla.mudat.entity;

import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by maste on 11/25/2017.
 */

public class AdsenseTest {

    @Test
    public void it_should_create_new_Adsense() throws Exception
    {
        int id = 0;
        Category category = new Category();
        category.setName("Category1");
        User user = new User();
        user.setName("Juan");
        Adsense adsense = new Adsense();
        Date createdAt = new Date();
        String condiction = "this is the condiction";
        double price = 10.5;
        String title = "Title1";
        String location = "location";
        String details = "details";
        adsense.setCategory(category);
        adsense.setUser(user);
        adsense.setCreatedAt(createdAt);
        adsense.setCondiction(condiction);
        adsense.setPrice(price);
        adsense.setTitle(title);
        adsense.setLocation(location);
        adsense.setDetails(details);

        String adsenseExperted = "Adsense{" +
                "id=" + id +
                ", category=" + category +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", condiction='" + condiction + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", details='" + details + '\'' +
                '}';

        assertEquals(adsenseExperted, adsense.toString());

    }
}
