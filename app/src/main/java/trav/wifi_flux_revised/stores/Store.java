package trav.wifi_flux_revised.stores;

import trav.wifi_flux_revised.actions.Action;
import trav.wifi_flux_revised.dispatcher.Dispatcher;

/**
 * Created by trav on 8/2/2017.
 */
public abstract class Store {

    final Dispatcher dispatcher;

    protected Store(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    void emitStoreChange() {
        dispatcher.emitChange(changeEvent());
    }

    abstract StoreChangeEvent changeEvent();

    public abstract void onAction(Action action);

    public interface StoreChangeEvent {}
}
