package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar pr_dialog;
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    ImageView p1,p2,p3,p4,p5;
    GridLayout grid;
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor editor = null;
    int t;
    Intent mainIntent;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar time=Calendar.getInstance();
       t=time.get(Calendar.HOUR_OF_DAY);

context=this;

         mySharedPreferences = getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
        editor = mySharedPreferences.edit();

        if(t>=7 && t<=18)
        {
            editor.putBoolean("night",false);
            editor.apply();
        }else
        {
            editor.putBoolean("night",true);
            editor.apply();
        }

        if(new SharedPrefsReader(mySharedPreferences).enableNight())
        {
            setContentView(R.layout.activity_splash);
        }else {
            setContentView(R.layout.activity_splash_light);
        }

       // AdsManager.getInstance().initilizeads(this,this);
        pr_dialog = (ProgressBar) findViewById(R.id.pr_dialog);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                setContentView(R.layout.splashactivity2);

                if(new SharedPrefsReader(mySharedPreferences).enableNight())
                {
                    setContentView(R.layout.splashactivity2);
                }else {
                    setContentView(R.layout.splashactivity2light);
                }

                p1=findViewById(R.id.p1);
                p2=findViewById(R.id.p2);
                p3=findViewById(R.id.p3);
                p4=findViewById(R.id.p4);
                p5=findViewById(R.id.p5);
                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                        SplashActivity.this.startActivity(mainIntent);
                        SplashActivity.this.finish();
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(SplashActivity.this,DuaListActivity.class);
                        SplashActivity.this.startActivity(mainIntent);
                        SplashActivity.this.finish();
                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(context,QiblaLocation.class);
                        SplashActivity.this.startActivity(mainIntent);
                        SplashActivity.this.finish();
                    }
                });
                p4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

try
{

    mainIntent = new Intent(SplashActivity.this,PrayerTime.class);

    startActivity(mainIntent);
    SplashActivity.this.finish();
}catch(Exception e) {

}
                    }
                });
                p5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         mainIntent = new Intent(SplashActivity.this,SettngsActivity.class);
                        SplashActivity.this.startActivity(mainIntent);
                        SplashActivity.this.finish();
                    }
                });

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
