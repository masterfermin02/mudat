package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.itla.mudat.views.adsenses.ListAdsense;
import com.itla.mudat.views.categories.ListCategory;
import com.itla.mudat.views.users.ListUser;
import com.itla.mudat.views.users.RegisterUser;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the register button */
    public void user(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ListUser.class);
        startActivity(intent);

    }

    /** Called when the user taps the register button */
    public void adsense(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ListAdsense.class);
        startActivity(intent);

    }

    /** Called when the user taps the register button */
    public void category(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ListCategory.class);
        startActivity(intent);

    }


}
