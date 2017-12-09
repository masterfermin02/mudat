package com.itla.mudat.commands.adsenses;

import android.os.Bundle;

import com.itla.mudat.commands.Command;
import com.itla.mudat.components.AdsenseComponent;
import com.itla.mudat.entity.Adsense;

/**
 * Created by maste on 12/9/2017.
 */

public class AdsenseFillEditTextCommand implements Command {

    private AdsenseComponent adsenseComponent;
    private Bundle parameter;

    public AdsenseFillEditTextCommand(AdsenseComponent adsenseComponent, Bundle parameter){
        this.adsenseComponent = adsenseComponent;
        this.parameter = parameter;
    }

    @Override
    public void execute() {

        if(parameter != null && parameter.containsKey("adsense"))
        {
            Adsense adsense = (Adsense) parameter.getSerializable("adsense");
            adsenseComponent.setId(adsense.getId());
            adsenseComponent.getTitle().setText(adsense.getTitle().toString());
            adsenseComponent.getCondiction().setText(adsense.getCondiction().toString());
            adsenseComponent.getDetails().setText(adsense.getDetails().toString());
            adsenseComponent.setCategory(adsense.getCategory());
            adsenseComponent.setUser(adsense.getUser());
            adsenseComponent.getPrice().setText(String.valueOf(adsense.getPrice()));
            adsenseComponent.getLocation().setText(adsense.getLocation().toString());
        }

    }
}
