package trav.wifi_flux_revised.stores;

import com.squareup.otto.Subscribe;

import trav.wifi_flux_revised.actions.Action;
import trav.wifi_flux_revised.actions.WifiActions;
import trav.wifi_flux_revised.dispatcher.Dispatcher;

/**
 * Created by trav on 8/2/2017.
 */
public class WifiStore extends Store {

    private static WifiStore ins;

    public WifiStore(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    StoreChangeEvent changeEvent() {
        return new WifiStoreChangeEvent();
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
    switch(WifiActions.SSID){
        case "TravelTab":
            emitStoreChange();
            break;
    }
    }

    public static WifiStore get(Dispatcher dispatcher) {
        if (ins == null) {
            ins = new WifiStore(dispatcher);
        }
        return ins;
    }

    public class WifiStoreChangeEvent implements StoreChangeEvent{

    }

}
