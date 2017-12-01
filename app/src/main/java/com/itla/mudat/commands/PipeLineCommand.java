package com.itla.mudat.commands;

import java.util.List;

/**
 * Created by maste on 11/30/2017.
 */

public class PipeLineCommand implements Command {

    List<Command> commands;

    public PipeLineCommand(List<Command> commands)
    {
        this.commands = commands;
    }
    @Override
    public void execute() {
        for(Command command: commands)
        {
            command.execute();
        }
    }
}
