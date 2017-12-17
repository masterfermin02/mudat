package com.itla.mudat.validations.users;

import android.text.TextUtils;
import android.widget.EditText;

import com.itla.mudat.components.users.UserComponent;
import com.itla.mudat.validations.IValidation;

/**
 * Created by maste on 12/1/2017.
 */

public class UserNameIsEmpty implements IValidation {

    UserComponent userComponent;

    public UserNameIsEmpty(UserComponent userComponent)
    {
        this.userComponent = userComponent;
    }

    @Override
    public Boolean validate() {
        EditText name = userComponent.getName();
        if(TextUtils.isEmpty(name.getText()))
        {
            name.setError("User name is required.");
            return false;
        }
        return true;
    }
}
