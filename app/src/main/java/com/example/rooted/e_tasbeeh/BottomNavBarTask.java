package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class BottomNavBarTask {

  private static BottomNavigationView navigationView;
  private BottomNavBarTask()
  {

  }
    Vibrator mVibrator;;
    SharedPreferences mySharedPreferences = null;
    MediaPlayer mediaPlayer;
Context con;
    public BottomNavBarTask (Context con,BottomNavigationView view) {
        this.con=con;
        mySharedPreferences = con.getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
        navigationView=view;
        mediaPlayer = MediaPlayer.create(con, R.raw.type);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mVibrator  = (Vibrator) con.getSystemService(Context.VIBRATOR_SERVICE);
    }

   public static BottomNavigationView  getInstance()
   {
       if(navigationView!=null)
       {
           return navigationView;

       }
       else
       {
           return null;
       }
   }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if(new SharedPrefsReader(mySharedPreferences).canPlaySound())
            {
                mediaPlayer.start();
            }
            if(new SharedPrefsReader(mySharedPreferences).canVibrate())
            {

                int dot = 10;      // Length of a Morse Code "dot" in milliseconds
                int dash = 20;     // Length of a Morse Code "dash" in milliseconds
                int short_gap = 10;    // Length of Gap Between dots/dashes
                int medium_gap = 10;   // Length of Gap Between Letters
                int long_gap = 1000;    // Length of Gap Between Words
                long[] pattern = {
                        0,  // Start immediately
                        dot, short_gap, dot    // s

                };

                mVibrator.vibrate(pattern, -1);
            }

            switch (item.getItemId()) {
                case R.id.navigation_home:


                    Intent intent=new Intent(con,Home.class);
                    con.startActivity(intent);
                  //overridePendingTransition(R.anim.goup,R.anim.godown);
                    return true;
                case R.id.navigation_dua:



                    return true;
                case R.id.navigation_kaba_compass:


                    intent = new Intent(con, QiblaLocation.class);
                    con.startActivity(intent);
                    //overridePendingTransition(R.anim.goup,R.anim.godown);
                    return true;
                case R.id.navigation_settings:

                    intent=new Intent(con,SettngsActivity.class);
                    con.startActivity(intent);
                    //overridePendingTransition(R.anim.goup,R.anim.godown);
                    return true;
                case R.id.navigation_prayer_time:


                    intent = new Intent(con, PrayerTime.class);
                    con.startActivity(intent);
               //     overridePendingTransition(R.anim.goup,R.anim.godown);

                    return true;
            }
            return false;
        }
    };

    public  BottomNavigationView getNavBar()
    {
        return navigationView;
    }

}
