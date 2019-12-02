package com.example.miniproject2smb;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private int id = 0;
    private String productName;
    private int productPrice;
    private int productCount;
    private boolean bought = false;
    private String channelName = "Some Channel";
    private String channelId = "channel1";

    @Override
    public void onReceive(Context context, Intent intent) {
        productName = intent.getStringExtra("name");
        productPrice = intent.getIntExtra("price", 0);
        productCount = intent.getIntExtra("count", 0);
        bought = intent.getBooleanExtra("bought", false);

//        Intent intentListActivity = context.getPackageManager().getLaunchIntentForPackage("com.example.miniprojectsmb");
        Intent intentListActivity = new Intent(Intent.ACTION_MAIN);
        intentListActivity.setComponent(
                new ComponentName("com.example.miniprojectsmb", "com.example.miniprojectsmb.ListActivity")
        );
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentListActivity, 0);

        Toast.makeText(context, "Nazwa: " + " " + productName, Toast.LENGTH_LONG).show();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, channelId);
        notification.setContentTitle("Wprowadzono nowy produkt");
        notification.setContentText("Produkt " + productName + " został wprowadzony z ceną " + productPrice + " w ilości " + productCount);
        notification.setContentIntent(pendingIntent);
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setAutoCancel(true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            channel.setDescription("description of channel");

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify(id++, notification.build());


        ////---------------------------------------------------------------------------

    }


}
