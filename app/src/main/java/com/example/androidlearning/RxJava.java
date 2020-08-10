package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidlearning.RxJavaAdapter.UserAdapter;
import com.example.androidlearning.RxJavaModel.User;
import com.example.androidlearning.RxJavaRetrofit.FansAPI;
import com.example.androidlearning.RxJavaRetrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RxJava extends AppCompatActivity {

    public Retrofit mRetrofit;
    public RecyclerView mUsersView;
    public FansAPI mFansAPI;
    public CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        mUsersView = findViewById(R.id.recycler_view);
        mUsersView.setHasFixedSize(true);
        mUsersView.setLayoutManager(new LinearLayoutManager(this));

        mRetrofit = RetrofitClient.getRetrofitInstance();
        mFansAPI = mRetrofit.create(FansAPI.class);

        mCompositeDisposable = new CompositeDisposable();


        fetchData();



    }


    private Observable<List<User>> getCricketFansObservable(){
        return mFansAPI.getCricketFansObservable();
    }


    private Observable<List<User>> getFootballFansObservable(){
        return mFansAPI.getFootballFansObservable();
    }

    private List<User> filterUserWhoLovesBoth(List<User> cricketFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<>();
        for (User cricketFan : cricketFans) {
            for (User footballFan : footballFans) {
                if (cricketFan.id == footballFan.id) {
                    userWhoLovesBoth.add(cricketFan);
                }
            }
        }
        return userWhoLovesBoth;
    }

    private DisposableObserver<List<User>> getCommonFansObserver(){
        return new DisposableObserver<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                UserAdapter userAdapter = new UserAdapter(users);
                mUsersView.setAdapter(userAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }



    private void fetchData(){

        mCompositeDisposable.add(
                Observable.zip(getCricketFansObservable(), getFootballFansObservable(),
                        (cricketFansList, footballFansList) -> filterUserWhoLovesBoth(cricketFansList, footballFansList))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(getCommonFansObserver())
        );

    }


    @Override
    protected void onDestroy() {
        mCompositeDisposable.clear();
        super.onDestroy();
    }
}