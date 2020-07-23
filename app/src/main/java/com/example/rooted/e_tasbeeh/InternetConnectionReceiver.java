package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationCompat;


public class InternetConnectionReceiver  extends BroadcastReceiver {
    Context context;
    SharedPreferences mySharedPreferences;
    @Override
    public void onReceive(Context context, Intent intent) {
                this.context=context;
        mySharedPreferences = context.getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
        try {

            ConnectivityManager connectivityManager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager
                        .getActiveNetworkInfo();


                if (networkInfo != null && networkInfo.isConnected()) {

                    try {

                        if(new SharedPrefsReader(mySharedPreferences).cansendNotif())
                        {
                            addNotification();
                        }




                    } catch (Exception e) {

                    }







                }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addNotification() {



        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent resultIntent = new Intent(context, Home.class);
        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Internet Notification";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.logo_app_icon)

                .setContentTitle("E-Zikar")
                .setContentText("Click to Find Prayer Timings and Qibla Location and alot more!");

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_CANCEL_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setAutoCancel(true);
        notificationManager.notify(notificationId, mBuilder.build());














    }
}
