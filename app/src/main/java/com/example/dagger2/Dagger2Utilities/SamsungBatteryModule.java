package com.example.dagger2.Dagger2Utilities;

import dagger.Module;
import dagger.Provides;

@Module
public class SamsungBatteryModule {


    public SamsungBatteryModule(){};

    @Provides
    Battery provideBattery(SamsungBattery samsungBattery){
        return samsungBattery;
    }



}
