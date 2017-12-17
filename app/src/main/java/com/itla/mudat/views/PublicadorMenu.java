package com.itla.mudat.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.itla.mudat.R;
import com.itla.mudat.entity.Adsense;
import com.itla.mudat.views.adsenses.ListAdsense;
import com.itla.mudat.views.categories.ListCategory;
import com.itla.mudat.views.users.ListUser;

public class PublicadorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicador_menu);

        Button btnSeeUsers = (Button) findViewById(R.id.publicadorUser);
        Button btnSeeAdesenses = (Button) findViewById(R.id.publicadorAdsense);
        Button btnSeeCategories = (Button) findViewById(R.id.publicadorCategory);
        btnSeeUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListUser.class);
                startActivity(intent);

            }
        });
        btnSeeAdesenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAdsense.class);
                startActivity(intent);

            }
        });
        btnSeeCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListCategory.class);
                startActivity(intent);

            }
        });
    }
}
