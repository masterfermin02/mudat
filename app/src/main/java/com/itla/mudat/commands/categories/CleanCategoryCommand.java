package com.itla.mudat.commands.categories;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.CategoryComponent;

/**
 * Created by maste on 12/5/2017.
 */

public class CleanCategoryCommand implements Command {

    private CategoryComponent categoryComponent;


    public CleanCategoryCommand(CategoryComponent categoryComponent){

        this.categoryComponent = categoryComponent;

    }


    @Override
    public void execute() {
        categoryComponent.getName().setText("");
    }
}
