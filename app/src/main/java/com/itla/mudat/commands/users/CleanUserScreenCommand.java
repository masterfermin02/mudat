package com.itla.mudat.commands.users;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.users.UserComponent;

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
