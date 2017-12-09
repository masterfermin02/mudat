package com.itla.mudat.components;

import android.widget.EditText;
import android.widget.TextView;

import com.itla.mudat.entity.Category;
import com.itla.mudat.entity.User;

import java.util.Date;

/**
 * Created by maste on 12/9/2017.
 */

public class AdsenseComponent {

    private int id;
    private EditText title;
    private Category category;
    private User user;
    private Date createdAt;
    private EditText condiction;
    private EditText price;
    private EditText location;
    private EditText details;
    private TextView categoryName;

    public TextView getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(TextView categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EditText getTitle() {
        return title;
    }

    public void setTitle(EditText title) {
        this.title = title;
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

    public EditText getCondiction() {
        return condiction;
    }

    public void setCondiction(EditText condiction) {
        this.condiction = condiction;
    }

    public EditText getPrice() {
        return price;
    }

    public void setPrice(EditText price) {
        this.price = price;
    }

    public EditText getLocation() {
        return location;
    }

    public void setLocation(EditText location) {
        this.location = location;
    }

    public EditText getDetails() {
        return details;
    }

    public void setDetails(EditText details) {
        this.details = details;
    }




}
