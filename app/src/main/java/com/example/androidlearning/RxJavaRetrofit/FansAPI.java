package com.example.androidlearning.RxJavaRetrofit;

import com.example.androidlearning.RxJavaModel.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FansAPI {

    @GET("/getAllFootballFans")
    Observable<List<User>> getFootballFansObservable();

    @GET("/getAllCricketFans")
    Observable<List<User>> getCricketFansObservable();
}