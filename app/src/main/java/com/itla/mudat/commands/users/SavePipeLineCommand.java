package com.itla.mudat.commands.users;

import android.app.Activity;

import com.itla.mudat.commands.Command;
import com.itla.mudat.commands.PipeLineCommand;
import com.itla.mudat.commands.activities.FinishActivityCommand;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.repository.Repository;
import com.itla.mudat.repository.user.UserSqlRepository;
import com.itla.mudat.validations.users.UserValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maste on 11/30/2017.
 */

public class SavePipeLineCommand implements Command {

    private PipeLineCommand pipeLineCommand;
    private UserValidation userValidation;

    public SavePipeLineCommand(UserComponent userComponent, UserSqlRepository repository, CleanUserScreenCommand cleanUserScreenCommand, Activity context)
    {
        List<Command> commands = new ArrayList<>();
        commands.add(new SaveUserCommand(userComponent, repository));
        commands.add(cleanUserScreenCommand);
        commands.add(new FinishActivityCommand(context));
        pipeLineCommand = new PipeLineCommand(commands);
        userValidation = new UserValidation(userComponent);
    }

    public SavePipeLineCommand(UserComponent userComponent, UserSqlRepository repository, CleanUserScreenCommand cleanUserScreenCommand)
    {
        List<Command> commands = new ArrayList<>();
        commands.add(new SaveUserCommand(userComponent, repository));
        commands.add(cleanUserScreenCommand);
        pipeLineCommand = new PipeLineCommand(commands);
        userValidation = new UserValidation(userComponent);
    }

    @Override
    public void execute() {
        if(userValidation.validate())
            pipeLineCommand.execute();
    }

}
