package com.example.androidlearning.Dagger2Utilities;

import android.util.Log;

import javax.inject.Inject;

public class IntexBattery implements Battery {

    @Inject
    public IntexBattery(){};

    @Override
    public void reportConfiguration() {
        Log.i("Battery config" , "Intex Battery Config");
    }

    @Override
    public void reportManufacturer() {
        Log.i("Battery Manufacturer" , "Intex");
    }

}
