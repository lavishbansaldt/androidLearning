package com.example.androidlearning;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpAndThreadingDemo extends AppCompatActivity {

    TextView mTextView;
    TextView mWorkerResponse;
    ThreadDemoWorkerThread worker;

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i("msg", (String)msg.obj);
            mWorkerResponse.setText((String) msg.obj);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_threading);

        mTextView = findViewById(R.id.text_view_for_result);

        OkHttpClient client = new OkHttpClient();
        String url = "https://jsonplaceholder.typicode.com/posts";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("msg", "failure");
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    OkHttpAndThreadingDemo.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextView.setText(myResponse);
                        }
                    });

                }
            }
        });


        //threading
        mWorkerResponse = findViewById(R.id.worker_response);
        worker = new ThreadDemoWorkerThread();
        worker.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg= Message.obtain();
            msg.obj = "Task 1 completed";
            handler.sendMessage(msg);

        }).execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg= Message.obtain();
            msg.obj = "Task 2 completed";
            handler.sendMessage(msg);
        }).execute(() ->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg= Message.obtain();
            msg.obj = "Task 3 completed";
            handler.sendMessage(msg);
        });

    }
}