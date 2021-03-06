package com.itla.mudat.commands.categories;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.itla.mudat.commands.Command;
import com.itla.mudat.commands.PipeLineCommand;
import com.itla.mudat.commands.activities.FinishActivityCommand;
import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.repository.category.CategorySqlRepository;
import com.itla.mudat.validations.categories.CategoryValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maste on 12/5/2017.
 */

public class SaveCategoryPipeLine implements Command {

    private PipeLineCommand pipeLineCommand;
    private CategoryValidation categoryValidation;

    public SaveCategoryPipeLine(CategoryComponent categoryComponent, CategorySqlRepository repository, Activity context, CleanCategoryCommand cleanCategory){
        List<Command> commands = new ArrayList<>();
        commands.add(new SaveCategoryCommand(categoryComponent, repository));
        commands.add(cleanCategory);
        commands.add(new FinishActivityCommand(context));
        pipeLineCommand = new PipeLineCommand(commands);
        categoryValidation = new CategoryValidation(categoryComponent);
    }

    @Override
    public void execute() {

        if(categoryValidation.validate())
            pipeLineCommand.execute();
    }
}
