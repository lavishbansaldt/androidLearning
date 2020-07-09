package com.example.androidlearning;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BroadcastReceiverDemo extends AppCompatActivity {

    BroadcastReceiverDemoMyReceiver mReceiver;
    BroadcastReceiverDemoBatteryLowReceiver mBatteryLowReceiver;
    public static String BROADCAST_ACTION = "com.broadcastreceiverdemo.intent.broadcast";
    public static final String ACTION_BATTERY_LOW= "android.intent.action.BATTERY_LOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        mReceiver = new BroadcastReceiverDemoMyReceiver();
        mBatteryLowReceiver = new BroadcastReceiverDemoBatteryLowReceiver();

        IntentFilter intFilter= new IntentFilter();
        intFilter.addAction(BROADCAST_ACTION);
        intFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(mReceiver, intFilter);

        IntentFilter intFilter2 = new IntentFilter();
        intFilter2.addAction(ACTION_BATTERY_LOW);
        registerReceiver(mBatteryLowReceiver, intFilter2);
    }

    public void onBroadcast(View view){
        Intent broadcastIntent= new Intent();
        broadcastIntent.setAction(BROADCAST_ACTION);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        sendBroadcast(broadcastIntent);

    }
}