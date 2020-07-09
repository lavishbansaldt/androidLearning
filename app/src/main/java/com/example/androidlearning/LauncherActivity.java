package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        btn1= findViewById(R.id.intentBtn);
        btn2= findViewById(R.id.serviceBtn);
        btn3= findViewById(R.id.fragmentBtn);
        btn4= findViewById(R.id.broadcastBtn);
        btn5= findViewById(R.id.recycler_view_btn);
        btn6= findViewById(R.id.viewpager_btn);
        btn7= findViewById(R.id.viewpager2_btn);
        btn8= findViewById(R.id.bottom_sheet_btn);
        btn9= findViewById(R.id.okhttp_btn);
        btn10= findViewById(R.id.retrofit_btn);

        final Context ctx= this;

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentDemoIntent = new Intent(ctx, IntentDemo.class);
                startActivity(intentDemoIntent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceDemoIntent = new Intent(ctx, ServiceDemo.class);
                startActivity(serviceDemoIntent);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragmentDemoIntent = new Intent(ctx, FragmentsDemo.class);
                startActivity(fragmentDemoIntent);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiverDemoIntent = new Intent(ctx, BroadcastReceiverDemo.class);
                startActivity(receiverDemoIntent);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyclerViewDemoIntent = new Intent(ctx, RecyclerViewDemo.class);
                startActivity(recyclerViewDemoIntent);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewPagerDemoIntent = new Intent(ctx, ViewPagerDemo.class);
                startActivity(viewPagerDemoIntent);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewPager2DemoIntent = new Intent(ctx, ViewPager2Demo.class);
                startActivity(viewPager2DemoIntent);

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bottomSheetDemoIntent = new Intent(ctx, BottomSheetDemo.class);
                startActivity(bottomSheetDemoIntent);

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent okHttpAndThreadingDemoIntent = new Intent(ctx, OkHttpAndThreadingDemo.class);
                startActivity(okHttpAndThreadingDemoIntent);

            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("msg", "ok");
                Intent retrofitDemoIntent = new Intent(ctx, RetrofitDemo.class);
                startActivity(retrofitDemoIntent);
            }
        });






    }
}