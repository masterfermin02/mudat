package com.itla.mudat.views.categories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.R;
import com.itla.mudat.commands.categories.CategoryFillEditTextCommand;
import com.itla.mudat.commands.categories.CleanCategoryCommand;
import com.itla.mudat.commands.categories.SaveCategoryPipeLine;
import com.itla.mudat.components.CategoryComponent;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.category.CategorySqlRepository;

public class RegisterCategory extends AppCompatActivity {


    private CategorySqlRepository repository;
    private CategoryComponent categoryComponent = new CategoryComponent();
    private CleanCategoryCommand cleanCategory;
    private SaveCategoryPipeLine saveCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_category);

        repository = new CategorySqlRepository(DbHelpers.getDbConnection(this));

        categoryComponent.setName((EditText) findViewById(R.id.category_name));

        cleanCategory = new CleanCategoryCommand(categoryComponent);
        saveCommand = new SaveCategoryPipeLine(categoryComponent,repository, this, cleanCategory);
        new CategoryFillEditTextCommand(categoryComponent, getIntent().getExtras()).execute();
    }

    public void categorySave(View view)
    {

        saveCommand.execute();
    }

    public void categoryClean(View view)
    {

        cleanCategory.execute();
    }


}
