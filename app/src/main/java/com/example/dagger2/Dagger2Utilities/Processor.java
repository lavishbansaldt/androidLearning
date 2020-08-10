package com.example.androidlearning.Dagger2Utilities;

import android.util.Log;

import javax.inject.Inject;

public class Processor {

    @Inject
    public Processor(){
    }


    public void reportConfiguration() {
        Log.i("Config. of Processor: ", this.getClass().getSimpleName()+" config. details..");
    }


    public void reportManufacturer() {
        Log.i("Manufacturer: ",this.getClass().getSimpleName()+" by Qualcomm");
    }
}