package com.itla.mudat.components;

import android.widget.EditText;

/**
 * Created by maste on 12/5/2017.
 */

public class CategoryComponent {

    private int id;
    private EditText name;


    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
