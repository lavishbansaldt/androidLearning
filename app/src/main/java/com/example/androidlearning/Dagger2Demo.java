package com.example.androidlearning;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidlearning.Dagger2Utilities.AppleLaptopModule;
import com.example.androidlearning.Dagger2Utilities.Battery;
import com.example.androidlearning.Dagger2Utilities.Laptop;
import com.example.androidlearning.Dagger2Utilities.OperatingSystem;
import com.example.androidlearning.Dagger2Utilities.Processor;
import com.example.androidlearning.Dagger2Utilities.SamsungBatteryModule;
import com.example.androidlearning.Dagger2Utilities.UtilitySoftwares;

import javax.inject.Inject;

import dagger.BindsInstance;
import dagger.Component;

@Component (modules = { SamsungBatteryModule.class, AppleLaptopModule.class} )
interface LaptopComponent {

    void injectMainActivity(Dagger2Demo Dagger2Activity);

    @Component.Factory
    interface Factory{
        LaptopComponent runtimeValues(@BindsInstance String laptopName);


    }
}


public class Dagger2Demo extends AppCompatActivity {

    //Field Injection
    @Inject
    Laptop mLaptop;


    //@Inject
    // OperatingSystem mOS;

    //@Inject
    //UtilitySoftwares mUtilitySoftwares;

    @Inject
    Battery mBattery;

    @Inject
    Processor mProcessor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        OperatingSystem os = new OperatingSystem();
        UtilitySoftwares utilitySoftwares = new UtilitySoftwares();

        LaptopComponent component = DaggerLaptopComponent.factory().runtimeValues("My Laptop");

        component.injectMainActivity(this);
        //Log.i("Util soft initialsed..", (mUtilitySoftwares!= null ? "initialsied" : "not initialised"));


        mLaptop.reportConfiguration();
        mLaptop.reportManufacturer();


    }
}

