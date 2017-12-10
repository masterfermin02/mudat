package com.itla.mudat.views.adsenses;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.R;
import com.itla.mudat.adapter.ListAdsenseAdapter;
import com.itla.mudat.adapter.ListCategoryAdapter;
import com.itla.mudat.commands.adsenses.AdsenseFillEditTextCommand;
import com.itla.mudat.entity.Adsense;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.helpers.IApp;
import com.itla.mudat.repository.adsense.AdsenseSqlRepository;
import com.itla.mudat.repository.adsense.AllAdsenseSpecificacion;
import com.itla.mudat.repository.category.AllCategorySpecificacion;
import com.itla.mudat.views.categories.ListCategory;
import com.itla.mudat.views.categories.RegisterCategory;

import java.util.List;

public class ListAdsense extends AppCompatActivity {

    private AdsenseSqlRepository repository;
    private ListAdsenseAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adsense);
        FloatingActionButton btnAddAdsense = (FloatingActionButton) findViewById(R.id.btnAddAdsense);
        btnAddAdsense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rContext = new Intent(ListAdsense.this, RegisterAdsense.class);
                startActivity(rContext);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listViewAdsenses);
        repository = new AdsenseSqlRepository(DbHelpers.getDbConnection(this));

        List<Adsense> adsenses = repository.query(new AllAdsenseSpecificacion());
        listAdapter = new ListAdsenseAdapter(adsenses, this);
        listView.setAdapter(listAdapter);

        if(IApp.userIsLogged() && IApp.isPublicador())
        {
            btnAddAdsense.setVisibility(View.VISIBLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent rContext = new Intent(ListAdsense.this, RegisterAdsense.class);
                    Adsense adsense = (Adsense) adapterView.getItemAtPosition(i);

                    rContext.putExtra("adsense", adsense);
                    startActivity(rContext);

                }
            });
        }

    }

    @Override
    public void onResume(){
        super.onResume();

        listAdapter.setAdsenses(repository.query(new AllAdsenseSpecificacion()));
        listAdapter.notifyDataSetChanged();
    }
}
