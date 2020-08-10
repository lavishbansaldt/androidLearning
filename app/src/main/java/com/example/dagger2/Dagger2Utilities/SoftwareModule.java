package com.example.androidlearning.Dagger2Utilities;

import android.graphics.Path;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class SoftwareModule {
    private OperatingSystem mOs;
    private UtilitySoftwares mUtilitySoftwares;

    public SoftwareModule(OperatingSystem os, UtilitySoftwares utilitySoftwares){
        mOs = os;
        mUtilitySoftwares = utilitySoftwares;
    }

    @Provides
    public OperatingSystem provideOperatingSystem(){
        return mOs;
    }

    @Provides
    public UtilitySoftwares provideUtilitySoftwares(){
        return mUtilitySoftwares;
    }


}
