package com.itla.mudat.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itla.mudat.dao.ConexionSQLiteHelper;
import com.itla.mudat.entity.User;

import com.itla.mudat.R;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.repository.user.UserSqlRepository;

public class RegisterUser extends AppCompatActivity {


    protected EditText name;
    protected EditText userType;
    protected EditText identity;
    protected EditText email;
    protected EditText phone;
    protected EditText pass;
    protected EditText status;
    private UserSqlRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        repository = new UserSqlRepository(new ConexionSQLiteHelper(this,"mudat_db", null, 1));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.mapProp();

    }

    public void save(View view)
    {
        User user = new User();
        user.setName(name.getText().toString());
        user.setUserType(UserType.CLIENTE);
        user.setIdentity(identity.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setPass(pass.getText().toString());
        user.setStatus(Boolean.TRUE);
        repository.add(user);
    }

    protected void mapProp()
    {
        this.name = (EditText) findViewById(R.id.name);
        this.identity = (EditText) findViewById(R.id.identity);
        this.email = (EditText) findViewById(R.id.email);
        this.phone = (EditText) findViewById(R.id.phone);
        this.pass = (EditText) findViewById(R.id.pass);
    }

    public void clean(View view)
    {
        name.setText("");
        identity.setText("");
        email.setText("");
        phone.setText("");
        pass.setText("");

    }

}
