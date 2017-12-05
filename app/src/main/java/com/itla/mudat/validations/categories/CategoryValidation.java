package com.itla.mudat.validations.categories;

import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.validations.IValidation;
import com.itla.mudat.validations.PipeLineValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maste on 12/5/2017.
 */

public class CategoryValidation implements IValidation{

    private PipeLineValidation pipeLineValidation;

    public CategoryValidation(CategoryComponent categoryComponent){
        List<IValidation> validations = new ArrayList<>();
        validations.add(new CategoryMustBeNotEmpty(categoryComponent));
        pipeLineValidation = new PipeLineValidation(validations);
    }

    @Override
    public Boolean validate() {
        return pipeLineValidation.validate();
    }
}
