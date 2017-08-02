package trav.wifi_flux_revised.dispatcher;

import android.net.wifi.WifiManager;

import com.squareup.otto.Bus;

import trav.wifi_flux_revised.actions.Action;
import trav.wifi_flux_revised.actions.ActionsCreator;
import trav.wifi_flux_revised.stores.Store;

/**
 * Created by trav on 8/1/2017.
 */
public class Dispatcher {
    private final Bus bus;
    private static Dispatcher ins;

    public static Dispatcher get(Bus bus){
        if(ins == null){
            ins = new Dispatcher(bus);
        }
        return ins;
    }

    Dispatcher(Bus bus){
        this.bus = bus;
    }

    public void register(final Object cls) {
        bus.register(cls);

    }

    public void unregister(final Object cls) {
        bus.unregister(cls);
    }

    public void emitChange(Store.StoreChangeEvent o) {
        post(o);
    }

    public void dispatch(Boolean enable) {
       
    }


    private void post(final Object event) {
        bus.post(event);
    }


}
