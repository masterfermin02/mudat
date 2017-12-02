package com.itla.mudat.validations.users;

import com.itla.mudat.components.UserComponent;
import com.itla.mudat.validations.IValidation;
import com.itla.mudat.validations.PipeLineValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maste on 12/1/2017.
 */

public class UserValidation implements IValidation {

    private PipeLineValidation pipeLineValidation;

    public UserValidation(UserComponent userComponent){
        List<IValidation> validations = new ArrayList<>();
        validations.add(new UserNameIsEmpty(userComponent));
        validations.add(new UserPhoneNumberIsEmpty(userComponent));

        pipeLineValidation = new PipeLineValidation(validations);
    }

    @Override
    public Boolean validate() {
        return pipeLineValidation.validate();
    }
}
