package com.itla.mudat.commands.categories;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.entity.Category;
import com.itla.mudat.repository.Repository;
import com.itla.mudat.repository.category.CategorySqlRepository;

/**
 * Created by maste on 12/5/2017.
 */

public class SaveCategoryCommand implements Command {

    private CategoryComponent categoryComponent;
    private CategorySqlRepository repository;

    public SaveCategoryCommand(CategoryComponent categoryComponent, CategorySqlRepository repository){

        this.categoryComponent = categoryComponent;
        this.repository = repository;
    }

    @Override
    public void execute() {

        Category category = new Category();
        category.setId(categoryComponent.getId());
        category.setName(categoryComponent.getName().getText().toString());
        if(categoryComponent.getId() != 0)
            repository.update(category);
        else
            repository.add(category);

    }
}
