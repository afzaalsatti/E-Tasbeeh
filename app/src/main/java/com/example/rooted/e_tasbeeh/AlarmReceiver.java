package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;


import java.util.Calendar;
import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {
    Context context;
    AlarmManager alarmManager;
    SharedPreferences mySharedPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context=context;


        mySharedPreferences = context.getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);
        alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        if(new SharedPrefsReader(mySharedPreferences).cansendNotif())
        {
            addNotification();
        }

       setAlarm();
    }

    private void addNotification() {



        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent resultIntent = new Intent(context, PrayerTime.class);
        int notificationId = 1;
        String channelId = "channel-02";
        String channelName = "Alarm Channel";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.logo_app_icon)
                .setContentTitle("E-Zikar")
                .setContentText("Click to Earn Good Deeds by reciting zikar and Duas!");

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
    void setAlarm()
    {
        boolean inc=true;
        Calendar cal=Calendar.getInstance();
        int mon = cal.get(Calendar.MONTH);
        int  year = cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        if(day==28)
        {
            if(mon==1)
            {
                mon=mon+1;
                day=1;
                inc=false;
            }

        }
        if(day==29)
        {
            if(mon==11)
            {
                mon=0;
                year=year+1;
            }
            else
            {
                mon=mon+1;
            }
             day=1;
            inc=false;
        }
        if(inc)
        {
            day=day+1;
        }


        cal.set(Calendar.MONTH,mon);
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.DAY_OF_MONTH,day);
        cal.set(Calendar.HOUR_OF_DAY,07);
        cal.set(Calendar.MINUTE,00);
        Random rand=new Random();
        int code=rand.nextInt(99999999);

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, code, intent, PendingIntent.FLAG_CANCEL_CURRENT|  Intent.FILL_IN_DATA);

        // AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent );




    }
}
