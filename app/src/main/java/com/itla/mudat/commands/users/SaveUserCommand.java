package com.itla.mudat.commands.users;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.repository.user.UserSqlRepository;

/**
 * Created by maste on 11/30/2017.
 */

public class SaveUserCommand implements Command {


    private UserSqlRepository repository;
    private UserComponent userComponent;

    public SaveUserCommand(UserComponent userComponent, UserSqlRepository repository)
    {
        this.repository = repository;
        this.userComponent = userComponent;
    }
    @Override
    public void execute() {
        User user = new User();
        user.setName(userComponent.getName().getText().toString());
        user.setUserType(UserType.CLIENTE);
        user.setIdentity(userComponent.getIdentity().getText().toString());
        user.setEmail(userComponent.getEmail().getText().toString());
        user.setPhone(userComponent.getPhone().getText().toString());
        user.setPass(userComponent.getPass().getText().toString());
        user.setStatus(Boolean.TRUE);
        repository.add(user);
    }

}
