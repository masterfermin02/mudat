package com.itla.mudat.views.users;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.commands.users.CleanUserScreenCommand;
import com.itla.mudat.commands.users.FillUserEditText;
import com.itla.mudat.commands.users.SaveCleanUserScreenCommand;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.dao.ConexionSQLiteHelper;

import com.itla.mudat.R;
import com.itla.mudat.entity.User;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.user.UserSqlRepository;
import com.itla.mudat.validations.users.UserValidation;

public class RegisterUser extends AppCompatActivity {


    private UserSqlRepository repository;
    private SaveCleanUserScreenCommand saveCleanUserScreenCommand;
    private CleanUserScreenCommand cleanUserScreenCommand;
    private UserValidation userValidation;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        repository = new UserSqlRepository(DbHelpers.getDbConnection(this));
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        UserComponent userComponent = new UserComponent();
        userComponent.setName((EditText) findViewById(R.id.name));
        userComponent.setIdentity((EditText) findViewById(R.id.identity));
        userComponent.setEmail((EditText) findViewById(R.id.email));
        userComponent.setPhone((EditText) findViewById(R.id.phone));
        userComponent.setPass((EditText) findViewById(R.id.pass));
        cleanUserScreenCommand = new CleanUserScreenCommand(userComponent);
        saveCleanUserScreenCommand = new SaveCleanUserScreenCommand(userComponent, repository, cleanUserScreenCommand);
        userValidation = new UserValidation(userComponent);
        new FillUserEditText(userComponent, user, getIntent().getExtras()).execute();

    }

    public void save(View view)
    {
        if(userValidation.validate())
            saveCleanUserScreenCommand.execute();
    }

    public void clean(View view)
    {
        cleanUserScreenCommand.execute();

    }

}
