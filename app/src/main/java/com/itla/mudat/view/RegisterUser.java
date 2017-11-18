package com.itla.mudat.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.itla.mudat.entity.User;

import com.itla.mudat.R;
import com.itla.mudat.entity.UserType;

public class RegisterUser extends AppCompatActivity {

    protected Button save;
    protected Button cancel;
    protected EditText name;
    protected EditText userType;
    protected EditText identity;
    protected EditText email;
    protected EditText phone;
    protected EditText pass;
    protected EditText status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.save = (Button) findViewById(R.id.save);
        this.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        this.cancel = (Button) findViewById(R.id.cancel);

        this.name = (EditText) findViewById(R.id.name);
        this.userType = (EditText) findViewById(R.id.userType);
        this.identity = (EditText) findViewById(R.id.identity);
        this.email = (EditText) findViewById(R.id.email);
        this.phone = (EditText) findViewById(R.id.phone);
        this.pass = (EditText) findViewById(R.id.pass);
        this.status = (EditText) findViewById(R.id.status);




    }

    public void save()
    {
        User user = new User();
        user.setName(name.getText().toString());
        user.setUserType(UserType.CLIENTE);
        user.setIdentity(identity.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setPass(pass.getText().toString());
        user.setStatus(Boolean.TRUE);
        log.i(user.save());
    }

}
