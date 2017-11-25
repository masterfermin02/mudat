package com.itla.mudat.entity;

import java.util.Date;

/**
 * Created by maste on 11/18/2017.
 */

public class Adsense {

    protected int id;
    protected Category category;
    protected User user;
    protected Date createdAt;
    protected String condiction;
    protected double price;
    protected String title;
    protected String location;
    protected String details;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCondiction() {
        return condiction;
    }

    public void setCondiction(String condiction) {
        this.condiction = condiction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Adsense{" +
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
    }
}
