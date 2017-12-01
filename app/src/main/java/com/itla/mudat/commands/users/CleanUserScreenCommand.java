package com.itla.mudat.commands.users;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.itla.mudat.R;
import com.itla.mudat.commands.Command;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.repository.user.UserSqlRepository;

/**
 * Created by maste on 11/30/2017.
 */

public class CleanUserScreenCommand implements Command {

    private UserComponent userComponent;

    public CleanUserScreenCommand(UserComponent userComponent)
    {
        this.userComponent = userComponent;
    }
    @Override
    public void execute() {
        userComponent.getName().setText("");
        userComponent.getIdentity().setText("");
        userComponent.getEmail().setText("");
        userComponent.getPhone().setText("");
        userComponent.getPass().setText("");
    }

}
