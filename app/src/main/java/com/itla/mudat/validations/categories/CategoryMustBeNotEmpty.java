package com.itla.mudat.validations.categories;

import android.text.TextUtils;
import android.widget.EditText;

import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.entity.Category;
import com.itla.mudat.validations.IValidation;

/**
 * Created by maste on 12/5/2017.
 */

public class CategoryMustBeNotEmpty implements IValidation {

    CategoryComponent categoryComponent;

    public CategoryMustBeNotEmpty(CategoryComponent categoryComponent)
    {
        this.categoryComponent = categoryComponent;
    }

    @Override
    public Boolean validate() {
        EditText name = categoryComponent.getName();
        if(TextUtils.isEmpty(name.getText()))
        {
            name.setError("Category name is required.");
            return false;
        }
        return true;
    }
}
