package com.itla.mudat.commands.adsenses;

import com.itla.mudat.commands.Command;
import com.itla.mudat.commands.categories.SaveCategoryCommand;
import com.itla.mudat.components.AdsenseComponent;
import com.itla.mudat.entity.Adsense;
import com.itla.mudat.repository.adsense.AdsenseSqlRepository;

import java.util.Date;

/**
 * Created by maste on 12/9/2017.
 */

public class SaveAdsenseCommand implements Command {

    private AdsenseComponent adsenseComponent;
    private AdsenseSqlRepository repository;

    public SaveAdsenseCommand(AdsenseComponent adsenseComponent, AdsenseSqlRepository repository){
        this.adsenseComponent = adsenseComponent;
        this.repository = repository;
    }

    @Override
    public void execute() {
        Adsense adsense = new Adsense();
        adsense.setId(adsenseComponent.getId());
        adsense.setTitle(adsenseComponent.getTitle().getText().toString());
        adsense.setCondiction(adsenseComponent.getCondiction().getText().toString());
        adsense.setDetails(adsenseComponent.getDetails().getText().toString());
        adsense.setCategory(adsenseComponent.getCategory());
        adsense.setPrice(Double.valueOf(adsenseComponent.getPrice().getText().toString()));
        adsense.setLocation(adsenseComponent.getLocation().getText().toString());
        adsense.setUser(adsenseComponent.getUser());
        adsense.setCreatedAt(new Date());
        if(adsenseComponent.getId() != 0)
            repository.update(adsense);
        else
            repository.add(adsense);

    }
}
