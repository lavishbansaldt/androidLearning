package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LauncherActivity extends AppCompatActivity {

    private Button mIntentBtn;
    private Button mServiceBtn;
    private Button mFragmentBtn;
    private Button mBroadcastBtn;
    private Button mRecyclerViewBtn;
    private Button mViewPagerBtn;
    private Button mViewPager2Btn;
    private Button mOkHttpBtn;
    private Button mRetrofitBtn;
    private Button mRxJavaBtn;
    private Button mBottomSheetBtn;
    private Button mDagger2Btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        mIntentBtn = findViewById(R.id.intentBtn);
        mServiceBtn = findViewById(R.id.serviceBtn);
        mFragmentBtn = findViewById(R.id.fragmentBtn);
        mBroadcastBtn = findViewById(R.id.broadcastBtn);
        mRecyclerViewBtn = findViewById(R.id.recycler_view_btn);
        mViewPagerBtn = findViewById(R.id.viewpager_btn);
        mViewPager2Btn = findViewById(R.id.viewpager2_btn);
        mBottomSheetBtn = findViewById(R.id.bottom_sheet_btn);
        mOkHttpBtn = findViewById(R.id.okhttp_btn);
        mRetrofitBtn = findViewById(R.id.retrofit_btn);
        mRxJavaBtn = findViewById(R.id.rx_java_btn);
        mDagger2Btn = findViewById(R.id.dagger_btn);


        final Context ctx= this;

        mIntentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentDemoIntent = new Intent(ctx, IntentDemo.class);
                startActivity(intentDemoIntent);

            }
        });

        mServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceDemoIntent = new Intent(ctx, ServiceDemo.class);
                startActivity(serviceDemoIntent);

            }
        });

        mFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragmentDemoIntent = new Intent(ctx, FragmentsDemo.class);
                startActivity(fragmentDemoIntent);

            }
        });

        mBroadcastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiverDemoIntent = new Intent(ctx, BroadcastReceiverDemo.class);
                startActivity(receiverDemoIntent);

            }
        });

        mRecyclerViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyclerViewDemoIntent = new Intent(ctx, RecyclerViewDemo.class);
                startActivity(recyclerViewDemoIntent);

            }
        });

        mViewPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewPagerDemoIntent = new Intent(ctx, ViewPagerDemo.class);
                startActivity(viewPagerDemoIntent);

            }
        });

        mViewPager2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewPager2DemoIntent = new Intent(ctx, ViewPager2Demo.class);
                startActivity(viewPager2DemoIntent);

            }
        });

        mBottomSheetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bottomSheetDemoIntent = new Intent(ctx, BottomSheetDemo.class);
                startActivity(bottomSheetDemoIntent);

            }
        });

        mOkHttpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent okHttpAndThreadingDemoIntent = new Intent(ctx, OkHttpAndThreadingDemo.class);
                startActivity(okHttpAndThreadingDemoIntent);

            }
        });

        mRetrofitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retrofitDemoIntent = new Intent(ctx, RetrofitDemo.class);
                startActivity(retrofitDemoIntent);
            }
        });

        mRxJavaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent rxJavaIntent = new Intent(ctx, RxJava.class);
                startActivity(rxJavaIntent);
            }
        });

        mDagger2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("msg", "ok");
                Intent dagger2Intent = new Intent(ctx, Dagger2Demo.class);
                startActivity(dagger2Intent);
            }
        });






    }
}