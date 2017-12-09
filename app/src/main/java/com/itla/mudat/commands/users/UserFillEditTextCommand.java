package com.itla.mudat.commands.users;

import android.os.Bundle;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.entity.User;

/**
 * Created by maste on 12/2/2017.
 */

public class UserFillEditTextCommand implements Command {

    private UserComponent userComponent;
    private Bundle parameter;

    public UserFillEditTextCommand(UserComponent userComponent, Bundle parameter){
        this.userComponent = userComponent;
        this.parameter = parameter;

    }

    @Override
    public void execute() {

        if (parameter != null && parameter.containsKey("user")) {
            User user = (User) parameter.getSerializable("user");
            userComponent.setId(user.getId());
            userComponent.getName().setText(user.getName());
            userComponent.getIdentity().setText(user.getIdentity());
            userComponent.getPhone().setText(user.getPhone());
            userComponent.getEmail().setText(user.getEmail());
            userComponent.getPass().setText(user.getPass());
            userComponent.setStatus(user.getStatus());
            userComponent.setUserType(user.getUserType());
        }
    }
}
