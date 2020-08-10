package com.example.androidlearning.RxJavaRetrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit mRetrofitInstance;

    private RetrofitClient(){}

    public static Retrofit getRetrofitInstance(){

        if(mRetrofitInstance == null){
            mRetrofitInstance = new Retrofit.Builder()
                    .baseUrl("https://fierce-cove-29863.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofitInstance;

    }
}
