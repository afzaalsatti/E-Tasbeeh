package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class MainActivity extends Activity {

    BottomNavigationView navigation;
    RecyclerView zikar_list;
    double longitude;
    double latitude;
    ListHandler zikar_adapter;
    Toolbar toolbar;
    MediaPlayer mediaPlayer;
    public  String dayy;
int press=0;
    TextView title;
    String t;
    ImageView back,refresh;
    SharedPreferences mySharedPreferences = null;
    Vibrator mVibrator;
    InternetConnectionReceiver br;
    int color=0;
    AdView adView;
    Context context;
    public final static String EXTRA_MESSAGE = "MESSAGE";
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    AdRequest adRequest;
    SharedPreferences.Editor editor = null;


    String TAG = " com.example.rooted.e_tasbeeh";

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
context=this;

        // addzikar();

new LoadViewTask().execute();








    // registerNetworkBroadcastForNougat();


    }






    @Override
    public void onDestroy() {
        super.onDestroy();
      //  unregisterNetworkChanges();
    }

//

    @Override
    public void onBackPressed() {
        press++;
        if(press==1)
        {
            Toast.makeText(this,"press 1 more time to exit",Toast.LENGTH_SHORT).show();
        }
        else
        if(press==2)
        {

            finishAffinity();
            System.exit(0);
        }

    }

    public Context getContext()
{
    return this;
}




    private class LoadViewTask extends AsyncTask<Void, Void, Void>
    {
        //Before running code in separate thread
        @Override
        protected void onPreExecute()
        {
            mySharedPreferences = getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);
            if(mySharedPreferences.getBoolean("night",false))
            {
                setContentView(R.layout.activity_main);
                navigation = findViewById(R.id.navigation);
                navigation.getMenu().getItem(0).setIcon(R.drawable.hnd);
                color=2;
            }else
            {
                setContentView(R.layout.activity_mainlight);
                navigation = findViewById(R.id.navigation);
                navigation.getMenu().getItem(0).setIcon(R.drawable.hnl);
                color=1;
            }

            br=new InternetConnectionReceiver();
            zikar_list = findViewById(R.id.zikar_recycler);
            zikar_list.setHasFixedSize(true);
            toolbar = findViewById(R.id.toolbar);back=findViewById(R.id.back);
            back.setVisibility(View.INVISIBLE);
            refresh=findViewById(R.id.refresh);
            refresh.setVisibility(View.INVISIBLE);
            title=findViewById(R.id.toolbar_title);
            Typeface typeface = ResourcesCompat.getFont(context, R.font.arabic2);
            Menu menu = navigation.getMenu();
            MenuItem menuitem = menu.getItem(0);
            menuitem.setChecked(true);
            adView = findViewById(R.id.adView);}

        //The code to be executed in a background thread.
        @Override
        protected Void doInBackground(Void... params)
        {
           try
            {
                MobileAds.initialize(context);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.type);
                mVibrator  = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                editor = mySharedPreferences.edit();
                 adRequest = new AdRequest.Builder().build();
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                });

                Calendar c = Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_WEEK);
                String present_day="Monday";


                switch(day)
                {
                    case 1:
                        present_day="Sunday";
                        break;
                    case 2:
                        present_day="Monday";
                        break;
                    case 3:
                        present_day="Tuesday";
                        break;
                    case 4:
                        present_day="Wednesday";
                        break;
                    case 5:
                        present_day="Thursday";
                        break;
                    case 6:
                        present_day="Friday";
                        break;
                    case 7:
                        present_day="Saturday";
                        break;
                    default:
                        present_day="Sunday";
                        break;
                }
                dayy=present_day;


                //adding dummy data... but i want to read data from Database using getAllData() function in ZikarDb.java
                List zikar = new ArrayList();
                zikar=new DataProvider("",context).getZikar(present_day.toLowerCase());
//
                zikar_adapter = new ListHandler(context, zikar, zikar_list, 1,back,refresh);

                if(!mySharedPreferences.getBoolean("nav_demo",false))
                {

                    if(color==1)
                    {
                        new SimpleTooltip.Builder(context)
                                .anchorView(navigation)
                                .text("Click icons to Navigate Between Screens")
                                .backgroundColor(Color.rgb(17,126,237))
                                .arrowColor(Color.rgb(17,126,237))
                                .textColor(Color.WHITE)
                                .gravity(Gravity.TOP)
                                .animated(true)
                                .transparentOverlay(false)
                                .build()
                                .show();

                    }else
                    {
                        new SimpleTooltip.Builder(context)
                                .anchorView(navigation)
                                .text("Click icons to Navigate Between Screens")
                                .backgroundColor(Color.rgb(0,0,0))
                                .arrowColor(Color.WHITE)
                                .textColor(Color.WHITE)
                                .gravity(Gravity.TOP)
                                .animated(true)
                                .transparentOverlay(false)
                                .build()
                                .show();
                    }
                    editor.putBoolean("nav_demo",true);
                    editor.apply();
                }


                mOnNavigationItemSelectedListener
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
                            int long_gap = 2000;    // Length of Gap Between Words
                            long[] pattern = {
                                    0,  // Start immediately
                                    dot, short_gap, dot    // s

                            };

                            mVibrator.vibrate(pattern, -1);
                        }
                        switch (item.getItemId()) {
                            case R.id.navigation_home:

                                Intent intent = new Intent(getApplicationContext(), Home.class);
                                startActivity(intent);
                               overridePendingTransition(R.anim.goup, R.anim.godown);
                                return true;
                            case R.id.navigation_dua:

                                intent = new Intent(getApplicationContext(), DuaListActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.goup, R.anim.godown);
                                return true;
                            case R.id.navigation_kaba_compass:

                                intent = new Intent(getApplicationContext(), QiblaLocation.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.goup, R.anim.godown);

                                return true;
                            case R.id.navigation_settings:


                                intent = new Intent(getApplicationContext(), SettngsActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.goup, R.anim.godown);
                                return true;
                            case R.id.navigation_prayer_time:


                                intent = new Intent(getApplicationContext(), PrayerTime.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.goup, R.anim.godown);

                                return true;
                        }
                        return false;
                    }
                };


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            zikar_list.setLayoutManager(new LinearLayoutManager(context));
            zikar_list.setAdapter(zikar_adapter);
            adView.loadAd(adRequest);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navigation.setItemIconTintList(null);

        }
    }



}
