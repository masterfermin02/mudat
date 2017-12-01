package com.itla.mudat.commands.users;

import com.itla.mudat.commands.Command;
import com.itla.mudat.commands.PipeLineCommand;
import com.itla.mudat.components.UserComponent;
import com.itla.mudat.repository.Repository;
import com.itla.mudat.repository.user.UserSqlRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maste on 11/30/2017.
 */

public class SaveCleanUserScreenCommand implements Command {

    PipeLineCommand pipeLineCommand;

    public SaveCleanUserScreenCommand(UserComponent userComponent, UserSqlRepository repository)
    {
        List<Command> commands = new ArrayList<>();
        commands.add(new SaveUserCommand(userComponent, repository));
        commands.add(new CleanUserScreenCommand(userComponent));
        pipeLineCommand = new PipeLineCommand(commands);
    }

    public SaveCleanUserScreenCommand(UserComponent userComponent, UserSqlRepository repository, CleanUserScreenCommand cleanUserScreenCommand)
    {
        List<Command> commands = new ArrayList<>();
        commands.add(new SaveUserCommand(userComponent, repository));
        commands.add(cleanUserScreenCommand);
        pipeLineCommand = new PipeLineCommand(commands);
    }

    @Override
    public void execute() {
        pipeLineCommand.execute();
    }

}
