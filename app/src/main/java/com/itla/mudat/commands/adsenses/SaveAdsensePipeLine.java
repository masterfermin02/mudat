package com.itla.mudat.commands.adsenses;

import android.app.Activity;

import com.itla.mudat.commands.Command;
import com.itla.mudat.commands.PipeLineCommand;
import com.itla.mudat.commands.activities.FinishActivityCommand;
import com.itla.mudat.commands.categories.SaveCategoryCommand;
import com.itla.mudat.components.AdsenseComponent;
import com.itla.mudat.repository.adsense.AdsenseSqlRepository;
import com.itla.mudat.validations.PipeLineValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maste on 12/9/2017.
 */

public class SaveAdsensePipeLine implements Command {

    private PipeLineCommand pipeLineCommand;

    public SaveAdsensePipeLine(AdsenseComponent adsenseComponent,
                               AdsenseSqlRepository adsenseSqlRepository,
                               Activity context,
                               CleanAdsenseCommand cleanAdsenseCommand){
        List<Command> commands = new ArrayList<>();
        commands.add(new SaveAdsenseCommand(adsenseComponent, adsenseSqlRepository));
        commands.add(cleanAdsenseCommand);
        commands.add(new FinishActivityCommand(context));
        pipeLineCommand = new PipeLineCommand(commands);

    }
    @Override
    public void execute() {
        pipeLineCommand.execute();
    }
}
