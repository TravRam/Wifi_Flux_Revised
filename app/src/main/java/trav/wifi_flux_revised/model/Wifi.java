package trav.wifi_flux_revised.model;

/**
 * Created by trav on 8/2/2017.
 */
public class Wifi {

    boolean enable;

    public Wifi(boolean enable){
        this.enable = true;
    }

    public boolean isEnabled(){
        return enable;
    }

    public void setEnable(boolean enable){
        this.enable = enable;
    }

}
