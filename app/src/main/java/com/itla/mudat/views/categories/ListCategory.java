package com.itla.mudat.views.categories;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.R;
import com.itla.mudat.adapter.ListCategoryAdapter;
import com.itla.mudat.entity.Category;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.category.AllCategorySpecificacion;
import com.itla.mudat.repository.category.CategorySqlRepository;

import java.util.List;

public class ListCategory extends AppCompatActivity {

    private CategorySqlRepository repository;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);
        FloatingActionButton btnAddCategory = (FloatingActionButton) findViewById(R.id.btnAddCategory);
        btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rCategory = new Intent(ListCategory.this, RegisterCategory.class);
                startActivity(rCategory);
            }
        });
        listView = (ListView) findViewById(R.id.listViewCategories);

        repository = new CategorySqlRepository(DbHelpers.getDbConnection(this));

        List<Category> listViewCategories = repository.query(new AllCategorySpecificacion());

        listView.setAdapter(new ListCategoryAdapter(listViewCategories, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent rCategory = new Intent(ListCategory.this, RegisterCategory.class);
                Category c = (Category) adapterView.getItemAtPosition(i);

                rCategory.putExtra("category", c);
                startActivity(rCategory);

            }
        });
    }
}
