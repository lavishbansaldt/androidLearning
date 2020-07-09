package com.example.okhttpandthreading;

import android.os.Handler;
import android.os.HandlerThread;

public class ThreadDemoWorkerThread extends HandlerThread {

    private static final String TAG = "worker";
    private Handler handler;

    public ThreadDemoWorkerThread() {
        super(TAG);

        start();
        handler = new Handler(getLooper());
    }

    public ThreadDemoWorkerThread execute(Runnable task){
        handler.post(task);
        return this;
    }
}
