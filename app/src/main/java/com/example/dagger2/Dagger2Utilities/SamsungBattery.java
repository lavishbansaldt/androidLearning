package com.example.dagger2.Dagger2Utilities;

import android.util.Log;

import javax.inject.Inject;

public class SamsungBattery implements Battery {


    @Inject
    public SamsungBattery() {
    }

    ;

    @Override
    public void reportConfiguration() {
        Log.i("Battery config", "Samsung Battery Config");
    }

    @Override
    public void reportManufacturer() {
        Log.i("Battery Manufacturer", "Samsung");
    }
}
