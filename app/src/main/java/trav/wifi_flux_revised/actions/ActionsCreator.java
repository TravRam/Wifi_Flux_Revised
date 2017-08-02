package trav.wifi_flux_revised.actions;


import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import java.util.List;


import trav.wifi_flux_revised.MainActivity;
import trav.wifi_flux_revised.dispatcher.Dispatcher;
import trav.wifi_flux_revised.model.Wifi;

/**
 * Created by trav on 8/1/2017.
 */
public class ActionsCreator{
    private static ActionsCreator ins;
    final Dispatcher disp;

    ActionsCreator(Dispatcher dispatcher){
        this.disp = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher){
        if (ins == null){
            ins = new ActionsCreator(dispatcher);
        }
        return ins;
    }

    public void create() {
        disp.dispatch(
                true
        );

    }

    public void connectWifi(Context context){

        WifiManager wifiManage = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);  //Define wifi manager and config for future use.
        final WifiConfiguration conf = new WifiConfiguration();

        conf.SSID = "\"" + WifiActions.SSID + "\"";          //Set SSID and Password to Connect
        conf.preSharedKey = "\"" + WifiActions.pKey + "\"";

        conf.hiddenSSID = true;         //Hidden SSID
        conf.status = WifiConfiguration.Status.ENABLED;

        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);       //WPA Security to enable password

        conf.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
        conf.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);

        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);

        conf.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
        conf.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
        wifiManage.setWifiEnabled(true);                //Turn on Wifi
        if(wifiManage != null && wifiManage.isWifiEnabled()) {      //Test that null case is not considered and turned on correctly

            wifiManage.addNetwork(conf);            //Add Hidden Network to list of Wifi networks

            List<WifiConfiguration> list = wifiManage.getConfiguredNetworks();
            for (WifiConfiguration i: list) {

                if(i.SSID != null && i.SSID.equals("\"" + WifiActions.SSID + "\"")){         //Compare SSIDs to confirm network

                    wifiManage.disconnect();                //disconnect from current network and reconnect to the Hidden SSID

                    wifiManage.enableNetwork(i.networkId, true);

                    wifiManage.reconnect();

                    wifiManage.saveConfiguration(); //Save final Configuration

                    break;
                }
            }
        }
    }


    public void disconnectWifi(Context context){
        WifiManager wifiManage = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifiManage.setWifiEnabled(false);

    }



}


