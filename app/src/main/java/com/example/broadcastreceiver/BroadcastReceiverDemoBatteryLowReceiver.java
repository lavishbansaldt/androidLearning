package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverDemoBatteryLowReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.w("Message", "Your device is dying");
        Toast.makeText(context, "Your device is dying",
                Toast.LENGTH_SHORT).show();
    }
}
