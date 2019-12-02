package com.example.miniproject2smb;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

public class BroadcastService extends Service {
    private String LOG_TAG = null;
    private ArrayList<String> mList;

    public static final String usedIntent = "com.example.miniprojectsmb.intent.action.EVENT1";
    private CustomBroadcastReceiver myBroadcastReciever = new CustomBroadcastReceiver();
    private final String channelID = "channel1";
    private int id=0;


    @Override
    public void onCreate() {
        super.onCreate();
        LOG_TAG = this.getClass().getSimpleName();
        Log.i(LOG_TAG, "In onCreate");
        mList = new ArrayList<String>();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(LOG_TAG, "In onStartCommand");

        registerReceiver(myBroadcastReciever, new IntentFilter(usedIntent));

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Wont be called as service is not bound
        Log.i(LOG_TAG, "In onBind");
        return null;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.i(LOG_TAG, "In onTaskRemoved");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "In onDestroy");
    }
}
