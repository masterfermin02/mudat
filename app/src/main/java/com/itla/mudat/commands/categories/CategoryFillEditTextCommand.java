package com.itla.mudat.commands.categories;

import android.os.Bundle;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.entity.Category;
import com.itla.mudat.mappers.Mapper;
import com.itla.mudat.mappers.categories.CategoryToComponent;

/**
 * Created by maste on 12/5/2017.
 */

public class CategoryFillEditTextCommand implements Command {

    private CategoryComponent categoryComponent;
    private Bundle parameter;
    private Mapper<Category,CategoryComponent> categoryToComponent = new CategoryToComponent();


    public CategoryFillEditTextCommand(CategoryComponent categoryComponent, Bundle parameter){
        this.categoryComponent = categoryComponent;
        this.parameter = parameter;
    }

    @Override
    public void execute() {
        if (parameter != null && parameter.containsKey("category")) {
            Category category = (Category) parameter.getSerializable("category");
            categoryComponent.setId(category.getId());
            categoryComponent.getName().setText(category.getName());
        }
    }
}
