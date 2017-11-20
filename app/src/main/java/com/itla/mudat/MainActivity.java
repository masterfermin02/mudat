package com.itla.mudat;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itla.mudat.view.RegisterUser;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Called when the user taps the register button */
    public void addUser(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);

    }


}
