package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.itla.mudat.views.users.Login;
import com.itla.mudat.views.users.RegisterClient;
import com.itla.mudat.views.users.RegisterPublicador;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the register button */
    public void login(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }

    /** Called when the user taps the register button */
    public void registerPublicador(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegisterPublicador.class);
        startActivity(intent);

    }

    /** Called when the user taps the register button */
    public void registerClient(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegisterClient.class);
        startActivity(intent);

    }



}
