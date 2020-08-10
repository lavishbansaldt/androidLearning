package com.example.androidlearning.Dagger2Utilities;


import dagger.Binds;
import dagger.Module;
import com.example.androidlearning.Dagger2Utilities.AppleLaptop;
@Module
abstract public class AppleLaptopModule {

    @Binds
    abstract Laptop bindLaptop(AppleLaptop laptop);


}
