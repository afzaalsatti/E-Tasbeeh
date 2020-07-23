package com.example.rooted.e_tasbeeh;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class NotificationHandler {
    Context context;
    AlarmManager alarmManager;

    public NotificationHandler(Context context,  AlarmManager alarmManager ) {
        this.context = context;
        this.alarmManager=alarmManager;

    }

    void setAlarm()
    {

        boolean inc=true;
        Calendar cal=Calendar.getInstance();

       int mon = cal.get(Calendar.MONTH);

       int  year = cal.get(Calendar.YEAR);
       int day=cal.get(Calendar.DAY_OF_MONTH);
       int hr=cal.get(Calendar.HOUR_OF_DAY);
       int mins=cal.get(Calendar.MINUTE);



        cal.set(Calendar.MONTH,mon);
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.DAY_OF_MONTH,day);
        cal.set(Calendar.HOUR_OF_DAY,hr);
        cal.set(Calendar.MINUTE,mins+1);


        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 2342, intent, PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);

       // AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent );




    }













}
