package com.itla.mudat.commands.activities;

import android.app.Activity;

import com.itla.mudat.commands.Command;

/**
 * Created by maste on 12/5/2017.
 */

public class FinishActivityCommand implements Command {

    private Activity activity;

    public FinishActivityCommand(Activity activity){
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.finish();
    }
}
