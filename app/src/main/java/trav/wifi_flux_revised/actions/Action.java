package trav.wifi_flux_revised.actions;

import android.widget.Button;

/**
 * Created by trav on 8/2/2017.
 */
public class Action {
    private final Boolean enable;
    private final Boolean disable;

    Action(Boolean enable, Boolean disable){
        this.enable = enable;
        this.disable = disable;
    }

    public Boolean getEnable(){
        return enable;
    }

    public Boolean getDisable(){
        return disable;
    }

}
