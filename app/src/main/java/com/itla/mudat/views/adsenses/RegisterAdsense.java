package com.itla.mudat.views.adsenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.adapter.ListCategoryAdapter;
import com.itla.mudat.adapter.ListUserAdapter;
import com.itla.mudat.commands.adsenses.AdsenseFillEditTextCommand;
import com.itla.mudat.commands.adsenses.CleanAdsenseCommand;
import com.itla.mudat.commands.adsenses.SaveAdsensePipeLine;
import com.itla.mudat.components.AdsenseComponent;
import com.itla.mudat.entity.Category;
import com.itla.mudat.entity.User;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.adsense.AdsenseSqlRepository;
import com.itla.mudat.repository.category.AllCategorySpecificacion;
import com.itla.mudat.repository.category.CategoryByIdSpecification;
import com.itla.mudat.repository.category.CategorySqlRepository;
import com.itla.mudat.repository.user.AllUserSpecification;
import com.itla.mudat.repository.user.UserByIdSpecification;
import com.itla.mudat.repository.user.UserSqlRepository;

import java.util.List;

public class RegisterAdsense extends AppCompatActivity {

    private AdsenseSqlRepository repository;
    private Category category;
    private CleanAdsenseCommand cleanAdsenseCommand;
    private SaveAdsensePipeLine saveCommand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_adsense);

        repository = new AdsenseSqlRepository(DbHelpers.getDbConnection(this));
        UserSqlRepository userRepository = new UserSqlRepository(DbHelpers.getDbConnection(this));
        CategorySqlRepository categoryRepository = new CategorySqlRepository(DbHelpers.getDbConnection(this));
        category = new Category();
        final AdsenseComponent adsenseComponent = new AdsenseComponent();
        adsenseComponent.setTitle((EditText) findViewById(R.id.adsense_title));
        adsenseComponent.setDetails((EditText) findViewById(R.id.adsense_details));
        adsenseComponent.setCondiction((EditText) findViewById(R.id.adsense_condiction));
        adsenseComponent.setUser(userRepository.get(new UserByIdSpecification(1)));
        adsenseComponent.setPrice((EditText) findViewById(R.id.adsense_price));
        adsenseComponent.setLocation((EditText) findViewById(R.id.adsense_location));
        Spinner spinner = (Spinner) findViewById(R.id.adsense_category_spinner);
        List<Category> categories = categoryRepository.query(new AllCategorySpecificacion());
        ListCategoryAdapter listCategoryAdapter = new ListCategoryAdapter(categories, this);
        spinner.setAdapter(listCategoryAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adsenseComponent.setCategory((Category) adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        cleanAdsenseCommand = new CleanAdsenseCommand(adsenseComponent);
        saveCommand = new SaveAdsensePipeLine(adsenseComponent, repository, this, cleanAdsenseCommand);

        new AdsenseFillEditTextCommand(adsenseComponent, getIntent().getExtras()).execute();
    }

    public void adsenseSave(View view)
    {
        saveCommand.execute();
    }

    public void adsenseClean(View view)
    {
        cleanAdsenseCommand.execute();
    }
}
