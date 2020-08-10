package com.example.dagger2.Dagger2Utilities;

import android.util.Log;

import javax.inject.Inject;


public class AppleLaptop implements Laptop {
        private Battery mBattery;

    private Processor mProcessor;

    String mLaptopName;



    @Inject
    public AppleLaptop(Battery battery, Processor processor, String laptopName){
        mBattery = battery;
        mProcessor = processor;
        mLaptopName =  laptopName;

    }


    public void reportConfiguration(){
        Log.i("Config. of Laptop", "Apple Laptop config. details");
        mBattery.reportConfiguration();
        mProcessor.reportConfiguration();
    }

    public void reportManufacturer(){
        Log.i("Manufacturer of Laptop", "Laptop manufactured by Apple Inc.");
        mBattery.reportManufacturer();
        mProcessor.reportManufacturer();
    }
}
