package com.itla.mudat.mappers.categories;

import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.entity.Category;
import com.itla.mudat.mappers.Mapper;

/**
 * Created by maste on 12/5/2017.
 */

public class CategoryToComponent implements Mapper<Category, CategoryComponent> {

    @Override
    public CategoryComponent map(Category category) {
        CategoryComponent categoryComponent = new CategoryComponent();
        categoryComponent.setId(category.getId());
        categoryComponent.getName().setText(category.getName());
        return categoryComponent;
    }
}
