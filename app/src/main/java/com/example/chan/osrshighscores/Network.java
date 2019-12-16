package com.example.chan.osrshighscores;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Chan on 12/5/2017.
 */

public class Network {

    private Context context;

    public Network(Context context)
    {
        this.context = context;
    }

    /*
     * Check the network by getting the context(activity) of the caller and checking if it has an active connection or not.
     * Returns true if connected and not null, else returns false.
     */
    public boolean checkNetwork()
    {
        ConnectivityManager con = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net = con.getActiveNetworkInfo();
        return net != null && net.isConnected();
    }
}
