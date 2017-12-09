package com.itla.mudat.commands.adsenses;

import com.itla.mudat.commands.Command;
import com.itla.mudat.commands.users.CleanUserScreenCommand;
import com.itla.mudat.components.AdsenseComponent;
import com.itla.mudat.components.CategoryComponent;

/**
 * Created by maste on 12/9/2017.
 */

public class CleanAdsenseCommand implements Command {

    private AdsenseComponent component;

    public CleanAdsenseCommand(AdsenseComponent component){
        this.component = component;
    }
    @Override
    public void execute() {
        component.getTitle().setText("");
        component.getDetails().setText("");
        component.getCondiction().setText("");
        component.getLocation().setText("");
        component.getPrice().setText("");
    }
}
