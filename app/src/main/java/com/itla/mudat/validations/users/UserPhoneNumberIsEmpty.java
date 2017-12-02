package com.itla.mudat.validations.users;

import android.text.TextUtils;
import android.widget.EditText;

import com.itla.mudat.components.UserComponent;
import com.itla.mudat.validations.IValidation;

/**
 * Created by maste on 12/1/2017.
 */

public class UserPhoneNumberIsEmpty implements IValidation {

    UserComponent userComponent;

    public UserPhoneNumberIsEmpty(UserComponent userComponent)
    {
        this.userComponent = userComponent;
    }

    @Override
    public Boolean validate() {
        EditText phone = userComponent.getPhone();
        if(TextUtils.isEmpty(phone.getText()))
        {
            phone.setError("User phone is required.");
            return false;
        }
        return true;
    }
}
