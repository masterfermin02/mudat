package com.itla.mudat.components;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.itla.mudat.R;

/**
 * Created by maste on 11/30/2017.
 */

public class UserComponent {

    private EditText name;
    private EditText identity;
    private EditText email;
    private EditText phone;
    private EditText pass;



    public void setName(EditText name) {
        this.name = name;
    }

    public void setIdentity(EditText identity) {
        this.identity = identity;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }

    public void setPhone(EditText phone) {
        this.phone = phone;
    }

    public void setPass(EditText pass) {
        this.pass = pass;
    }

    public EditText getName() {
        return name;
    }

    public EditText getIdentity() {
        return identity;
    }

    public EditText getEmail() {
        return email;
    }

    public EditText getPhone() {
        return phone;
    }

    public EditText getPass() {
        return pass;
    }


}
