package com.example.miniproject2smb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String usedIntent = "com.example.miniprojectsmb.intent.action.EVENT1";
    private CustomBroadcastReceiver myBroadcastReciever = new CustomBroadcastReceiver();
    private final String channelID = "channel1";
    private int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(this, BroadcastService.class);
        startService(serviceIntent);


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        registerReceiver(myBroadcastReciever, new IntentFilter(usedIntent));
//    }
}




