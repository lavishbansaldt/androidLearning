package com.example.androidlearning.Dagger2Utilities;

import dagger.Module;
import dagger.Provides;

@Module
public class DellLaptopModule {
    String mLaptopName;
    public DellLaptopModule(String laptopName){
        mLaptopName = laptopName;
    }

    @Provides
    String provideLaptopName(){
        return mLaptopName;
    }

    @Provides
    Laptop provideLaptop(DellLaptop laptop){
        return laptop;
    }

}