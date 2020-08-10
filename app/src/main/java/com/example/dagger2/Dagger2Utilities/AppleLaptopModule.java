package com.example.dagger2.Dagger2Utilities;


import dagger.Binds;
import dagger.Module;
import com.example.androidlearning.Dagger2Utilities.AppleLaptop;
@Module
abstract public class AppleLaptopModule {

    @Binds
    abstract AppleLaptop bindLaptop(AppleLaptop laptop);


}
