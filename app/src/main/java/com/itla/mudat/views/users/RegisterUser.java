package com.itla.mudat.views.users;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.commands.users.CleanUserScreenCommand;
import com.itla.mudat.commands.users.UserFillEditTextCommand;
import com.itla.mudat.commands.users.SavePipeLineCommand;
import com.itla.mudat.components.UserComponent;

import com.itla.mudat.R;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.user.UserSqlRepository;

public class RegisterUser extends AppCompatActivity {


    private UserSqlRepository repository;
    private SavePipeLineCommand saveCommand;
    private CleanUserScreenCommand cleanUserScreenCommand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        repository = new UserSqlRepository(DbHelpers.getDbConnection(this));

        UserComponent userComponent = new UserComponent();
        userComponent.setName((EditText) findViewById(R.id.name));
        userComponent.setIdentity((EditText) findViewById(R.id.identity));
        userComponent.setEmail((EditText) findViewById(R.id.email));
        userComponent.setPhone((EditText) findViewById(R.id.phone));
        userComponent.setPass((EditText) findViewById(R.id.pass));

        cleanUserScreenCommand = new CleanUserScreenCommand(userComponent);
        saveCommand = new SavePipeLineCommand(userComponent, repository, cleanUserScreenCommand, this);
        new UserFillEditTextCommand(userComponent, getIntent().getExtras()).execute();

    }

    public void save(View view)
    {
        saveCommand.execute();
    }

    public void clean(View view)
    {
        cleanUserScreenCommand.execute();
    }

}
