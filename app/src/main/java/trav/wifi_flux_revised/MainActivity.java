package trav.wifi_flux_revised;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.view.View;
import android.widget.Button;


import com.squareup.otto.Bus;



import trav.wifi_flux_revised.actions.ActionsCreator;
import trav.wifi_flux_revised.dispatcher.Dispatcher;
import trav.wifi_flux_revised.stores.WifiStore;

public class MainActivity extends AppCompatActivity {

    private Dispatcher disp;
    private ActionsCreator actionsCreator;
    private WifiStore wifiStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDependencies();

        Button enable = (Button) findViewById(R.id.enable);
        enable.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                connect();
            }
        });


        Button disable = (Button) findViewById(R.id.disable);
        disable.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                disconnect();
            }
        });

    }

    private void connect(){
        actionsCreator.connectWifi(this);
    }

    private void disconnect(){
        actionsCreator.disconnectWifi(this);
    }

    private void initDependencies(){
        disp = Dispatcher.get(new Bus());
        actionsCreator = ActionsCreator.get(disp);
        wifiStore = WifiStore.get(disp);

    }
}

