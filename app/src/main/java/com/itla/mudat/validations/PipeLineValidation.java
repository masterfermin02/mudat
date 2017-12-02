package com.itla.mudat.validations;

import java.util.List;

import javax.crypto.spec.IvParameterSpec;

/**
 * Created by maste on 12/1/2017.
 */

public class PipeLineValidation implements IValidation {

    private List<IValidation> validations;

    public PipeLineValidation(List<IValidation> validations)
    {
        this.validations = validations;

    }

    @Override
    public Boolean validate() {
        for (IValidation validation: validations
             ) {
            if(!validation.validate())
                return false;
        }
        return true;
    }
}
