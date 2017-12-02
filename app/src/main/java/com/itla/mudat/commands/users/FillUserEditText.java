package com.itla.mudat.commands.users;

import android.os.Bundle;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.entity.User;

/**
 * Created by maste on 12/2/2017.
 */

public class FillUserEditText implements Command {

    private UserComponent userComponent;
    private User user;
    private Bundle parameter;

    public FillUserEditText(UserComponent userComponent, User user, Bundle parameter){
        this.userComponent = userComponent;
        this.user = user;
        this.parameter = parameter;

    }

    @Override
    public void execute() {

        if (parameter.containsKey("user")) {
            user = (User) parameter.getSerializable("user");

            userComponent.getName().setText(user.getName());
            userComponent.getPhone().setText(user.getPhone());
            userComponent.getEmail().setText(user.getEmail());
            /// Clave
            /// TipoUsuario
            //
        }
    }
}
