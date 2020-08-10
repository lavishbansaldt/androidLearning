package com.example.dagger2.Dagger2Utilities;

import android.util.Log;

import com.example.androidlearning.Dagger2Utilities.Battery;
import com.example.androidlearning.Dagger2Utilities.Laptop;
import com.example.androidlearning.Dagger2Utilities.Processor;

import javax.inject.Inject;

public class DellLaptop implements Laptop {

    private Battery mBattery;

    private Processor mProcessor;

    String mLaptopName;


    @Inject
    public DellLaptop(Battery battery, Processor processor, String laptopName){
        mBattery = battery;
        mProcessor = processor;
        mLaptopName= laptopName;
    }


    public void reportConfiguration(){
        Log.i("Config. of Laptop", "Dell Laptop config. details");
        mBattery.reportConfiguration();
        mProcessor.reportConfiguration();
    }

    public void reportManufacturer(){
        Log.i("Manufacturer of Laptop", "Laptop manufactured by Dell");
        mBattery.reportManufacturer();
        mProcessor.reportManufacturer();
    }
}
