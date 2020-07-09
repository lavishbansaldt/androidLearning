package com.example.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlearning.R;

public class ServiceDemo extends AppCompatActivity {
    private static String BROADCAST_ACTION = "com.broadcastreceiverdemo.intent.broadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

    }

    public void start(View view){
        Intent intent= new Intent(this, ServiceDemoMyService.class);
        startService(intent);
    }

    public void stop(View view){
        Intent intent= new Intent(this, ServiceDemoMyService.class);
        stopService(intent);
    }
}