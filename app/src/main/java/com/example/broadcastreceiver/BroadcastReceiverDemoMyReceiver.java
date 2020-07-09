package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverDemoMyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.w("Check", "Inside On Receiver");
        Toast.makeText(context, "Received the broadcast message",
                Toast.LENGTH_SHORT).show();
    }
}
