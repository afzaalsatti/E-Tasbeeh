package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.LocationManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.rooted.e_tasbeeh.calender.BasicActivityDecorated;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;


public class PrayerTime extends AppCompatActivity {
    TextView text;
    RequestQueue queue;
    Calendar c;
    int check=0;
    int flag;
int press=0;
    LayoutInflater li;
    View promptsView ;
    AlertDialog.Builder alertDialogBuilder;
    int mon = 0, year = 0, day = 0;
    double longitude, latitude;
    ImageView connection;
    BottomNavigationView navigation;
    Image img;
    ProgressBar loading;
    TextView fajartime, duhartime, ashrtime, maghribtime, eshatime;
    TextView fajr, duhar, ashr, maghrib, isha, t1, t2;
    Button retry;
    Toolbar toolbar;
    ImageView settings,back;
    //    LocationFinder locationTrack;
    SharedPreferences mySharedPreferences = null;
    SharedPreferences prayerSharedPreferences = null;
int color=0;

    Context context;
    SharedPreferences.Editor editor = null;
    boolean isWiFi = false;
    boolean isConnected = false;

    MediaPlayer mediaPlayer;
LinearLayout calender;

    Vibrator mVibrator;




    private String getDate() {
        c = Calendar.getInstance();
        mon = c.get(Calendar.MONTH);
        mon = mon + 1;
        year = c.get(Calendar.YEAR);
        return "" + c.get(Calendar.DAY_OF_MONTH) + "/" + mon + "/" + year;
    }

    void visibility() {
        fajartime.setVisibility(View.VISIBLE);
        duhartime.setVisibility(View.VISIBLE);
        ashrtime.setVisibility(View.VISIBLE);
        maghribtime.setVisibility(View.VISIBLE);
        eshatime.setVisibility(View.VISIBLE);

        fajr.setVisibility(View.VISIBLE);
        duhar.setVisibility(View.VISIBLE);
        ashr.setVisibility(View.VISIBLE);
        maghrib.setVisibility(View.VISIBLE);
        isha.setVisibility(View.VISIBLE);


    }

    private void getPrayerTimes() {

//        c = Calendar.getInstance();
//        mon = c.get(Calendar.MONTH);
//        mon = mon + 1;
//        year = c.get(Calendar.YEAR);
//
//
//        t1.setText(getDate());

        String url = "http://api.aladhan.com/v1/calendar?latitude=" + latitude +
                "&longitude=" + longitude +
                "&method=2&month=" + mon +
                "&year=" + year;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("data");
                    //month
                    JSONObject exact = array.getJSONObject(day-1);
                 //   Toast.makeText(context,"Date is :"+day,Toast.LENGTH_LONG).show();

                    JSONObject object = exact.getJSONObject("timings");
                    String ftimings = object.getString("Fajr");
                    String dtimings = object.getString("Dhuhr");
                    String atimings = object.getString("Asr");
                    String mtimings = object.getString("Maghrib");
                    String etimings = object.getString("Isha");

                    if (!(mySharedPreferences.getString("Date", "no").equals(getDate()))) {
                        editor.remove("Date");
                        editor.remove("Fajr");
                        editor.remove("Dhuhr");
                        editor.remove("Asr");
                        editor.remove("Maghrib");
                        editor.remove("Isha");
                        editor.apply();
                    }

                    editor.putString("Date", getDate());
                    editor.putString("Fajr", ftimings);
                    editor.putString("Dhuhr", dtimings);
                    editor.putString("Asr", atimings);
                    editor.putString("Maghrib", mtimings);
                    editor.putString("Isha", etimings);
                    editor.apply();

                    visibility();


                    fajartime.setText(ftimings);
                    duhartime.setText(dtimings);
                    ashrtime.setText(atimings);
                    maghribtime.setText(mtimings);
                    eshatime.setText(etimings);

                    loading.setVisibility(View.GONE);
                    t2.setText("Prayer Timings! ");


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "we are sorry! Try Again", Toast.LENGTH_SHORT).show();
                    t2.setText("Error in Updating Data! ");
                    retry.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.GONE);
                    //e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error.printStackTrace();
                Toast.makeText(getApplicationContext(), "we are sorry! Try Again", Toast.LENGTH_SHORT).show();
                t2.setText("Error in Fetching Data! ");
                retry.setVisibility(View.VISIBLE);
                loading.setVisibility(View.GONE);

            }
        });
        queue.add(request);
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


                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mySharedPreferences = getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);

        if(new SharedPrefsReader(mySharedPreferences).enableNight())
        {
            setContentView(R.layout.activity_prayer_time);
            navigation = findViewById(R.id.navigation);
            navigation.getMenu().getItem(3).setIcon(R.drawable.pnd);
            li = LayoutInflater.from(this);
            promptsView = li.inflate(R.layout.alarm_prompt_night, null);
            color=2;
        }else {
            setContentView(R.layout.activity_prayer_time_light);
            navigation = findViewById(R.id.navigation);
            navigation.getMenu().getItem(3).setIcon(R.drawable.pnl);
            li = LayoutInflater.from(this);
            promptsView = li.inflate(R.layout.alarm_prompt, null);
            color=1;
        }


        context = this;



         settings=findViewById(R.id.settings);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
        mVibrator  = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Menu menu = navigation.getMenu();
back=findViewById(R.id.back);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        overridePendingTransition(R.anim.swipe_from_left,R.anim.godown);

    }
});

        MobileAds.initialize(context);





        MenuItem menuitem = menu.getItem(3);
        menuitem.setChecked(true);

        toolbar=findViewById(R.id.toolbar);
        calender=findViewById(R.id.calender);

        mediaPlayer = MediaPlayer.create(this, R.raw.type);


        t1 = findViewById(R.id.date);
        c = Calendar.getInstance();
        mon = c.get(Calendar.MONTH);
        mon = mon + 1;
        year = c.get(Calendar.YEAR);
        day = c.get(Calendar.DAY_OF_MONTH);


        t1.setText(getDate());
        t2 = findViewById(R.id.info);
        retry = findViewById(R.id.retry);
        loading = findViewById(R.id.loading);
        retry.setVisibility(View.GONE);

        t2.setText("Fetching Prayer Timings Please Wait");
        fajartime = findViewById(R.id.fajartime);
        duhartime = findViewById(R.id.duhartime);
        ashrtime = findViewById(R.id.ashrtime);
        maghribtime = findViewById(R.id.maghribtime);
        eshatime = findViewById(R.id.eshatime);
        fajr = findViewById(R.id.fajr);
        duhar = findViewById(R.id.dhuhr);
        ashr = findViewById(R.id.ashr);
        maghrib = findViewById(R.id.maghrib);
        isha = findViewById(R.id.esha);

        fajartime.setVisibility(View.INVISIBLE);
        duhartime.setVisibility(View.INVISIBLE);
        ashrtime.setVisibility(View.INVISIBLE);
        maghribtime.setVisibility(View.INVISIBLE);
        eshatime.setVisibility(View.INVISIBLE);

        fajr.setVisibility(View.INVISIBLE);
        duhar.setVisibility(View.INVISIBLE);
        ashr.setVisibility(View.INVISIBLE);
        maghrib.setVisibility(View.INVISIBLE);
        isha.setVisibility(View.INVISIBLE);
        prayerSharedPreferences = getSharedPreferences("Prayer PREFS", Activity.MODE_PRIVATE);

        editor = mySharedPreferences.edit();
       // Typeface typeface=new SharedPrefsReader(mySharedPreferences).getTextStyle(context);




        AdView adView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        if(mySharedPreferences.getBoolean("showPrayerTimeHint",true))
        {
            if(color==1)
            {
                new SimpleTooltip.Builder(context)
                        .anchorView(toolbar)
                        .text("Click to find More Options")
                        .gravity(Gravity.CENTER)
                        .arrowDirection(2)
                        .animated(true)
                        .backgroundColor(Color.rgb(17,126,237))
                        .arrowColor(Color.rgb(17,126,237))
                        .textColor(Color.WHITE)
                        .transparentOverlay(false)
                        .build()
                        .show();
                new SimpleTooltip.Builder(context)
                        .anchorView(calender)
                        .text("Click to see Islamic Calender")
                        .gravity(Gravity.END)
                        .animated(true)
                        .backgroundColor(Color.rgb(17,126,237))
                        .arrowColor(Color.rgb(17,126,237))
                        .textColor(Color.WHITE)
                        .transparentOverlay(false)
                        .build()
                        .show();
            }
            else
            {
                new SimpleTooltip.Builder(context)
                        .anchorView(toolbar)
                        .text("Click to find More Options")
                        .gravity(Gravity.CENTER)
                        .arrowDirection(2)
                        .animated(true)
                        .backgroundColor(Color.rgb(0,0,0))
                        .arrowColor(Color.WHITE)
                        .textColor(Color.WHITE)
                        .transparentOverlay(false)
                        .build()
                        .show();
                new SimpleTooltip.Builder(context)
                        .anchorView(calender)
                        .text("Click to see Islamic Calender")
                        .gravity(Gravity.END)
                        .animated(true)
                        .backgroundColor(Color.rgb(0,0,0))
                        .arrowColor(Color.WHITE)
                        .textColor(Color.WHITE)
                        .transparentOverlay(false)
                        .build()
                        .show();
            }

            SharedPreferences.Editor editor = mySharedPreferences.edit();
            editor.putBoolean("showPrayerTimeHint",false);
            editor.apply();
        }

calender.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent intent=new Intent(context, BasicActivityDecorated.class);
        startActivity(intent);
////
//               Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
//            .putExtra(AlarmClock.EXTRA_MESSAGE,"E-TASBEEH")
//            .putExtra(AlarmClock.EXTRA_HOUR, 10)
//            .putExtra(AlarmClock.EXTRA_MINUTES, 00);
//    if (intent.resolveActivity(getPackageManager()) != null) {
//        startActivity(intent);
//    }



    }
});

settings.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        showSettingDialogue();


    }
});
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.ref)
                {
                    try {
                    Toast.makeText(getApplicationContext(),"Refreshing ",Toast.LENGTH_SHORT).show();
                    t2.setText("Refreshing...");
                    mon = c.get(Calendar.MONTH);
                    mon = mon + 1;
                    year = c.get(Calendar.YEAR);
                    t1.setText(getDate());
                    day = c.get(Calendar.DAY_OF_MONTH);
                    fajartime.setVisibility(View.INVISIBLE);
                    duhartime.setVisibility(View.INVISIBLE);
                    ashrtime.setVisibility(View.INVISIBLE);
                    maghribtime.setVisibility(View.INVISIBLE);
                    eshatime.setVisibility(View.INVISIBLE);
                    fajr.setVisibility(View.INVISIBLE);
                    duhar.setVisibility(View.INVISIBLE);
                    ashr.setVisibility(View.INVISIBLE);
                    maghrib.setVisibility(View.INVISIBLE);
                    isha.setVisibility(View.INVISIBLE);
                    retry.setVisibility(View.INVISIBLE);
                    loading.setVisibility(View.VISIBLE);

                        setTime();

                    }catch(Exception e)
                    {
                       // Toast.makeText(getApplicationContext(),"Error in Refreshing ",Toast.LENGTH_SHORT).show();


                    }


                }

                else{

                }

                return false;
            }
        });
        loadPreviousData();


        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
                t2.setText("Retrying...");
                retry.setVisibility(View.INVISIBLE);
                loading.setVisibility(View.VISIBLE);
                loadPreviousData();
            }
        });

    }

    private void loadPreviousData() {
        try {

            if (mySharedPreferences.getString("Date", "no").equals("no")) {

                setTime();

            } else if (!(mySharedPreferences.getString("Date", "no").equals(getDate()))) {

                setTime();

            } else {
               // Toast.makeText(getApplicationContext(), "Using Saved Data", Toast.LENGTH_SHORT).show();
                visibility();

                t1.setText(getDate());

                fajartime.setText(mySharedPreferences.getString("Fajr", "00:00"));
                duhartime.setText(mySharedPreferences.getString("Dhuhr", "00:00"));
                ashrtime.setText(mySharedPreferences.getString("Asr", "00:00"));
                maghribtime.setText(mySharedPreferences.getString("Maghrib", "00:00"));
                eshatime.setText(mySharedPreferences.getString("Isha", "00:00"));

                loading.setVisibility(View.INVISIBLE);
                t2.setText("Prayer Timings! ");

            }
        } catch (Exception exp) {
          //  Toast.makeText(getApplicationContext(), ""+exp, Toast.LENGTH_SHORT).show();

            t2.setText("Try Again !!!");
            retry.setVisibility(View.VISIBLE);
            loading.setVisibility(View.INVISIBLE);

        }

    }

void showSettingDialogue()
{

      flag=0;
    alertDialogBuilder = new AlertDialog.Builder(context);
    alertDialogBuilder.setIcon(R.mipmap.logo_app_icon);

    alertDialogBuilder.setView(promptsView);
    final LinearLayout ref = promptsView.findViewById(R.id.ref);
    final Switch alarm = promptsView.findViewById(R.id.alarm);
    final Switch fajrr=promptsView.findViewById(R.id.fajar);

    final Switch duhrr=promptsView.findViewById(R.id.duhr);
    final Switch ashrr=promptsView.findViewById(R.id.ashr);
    final Switch maghribb=promptsView.findViewById(R.id.magrib);
    final Switch eshaa=promptsView.findViewById(R.id.eshaa);


    if(new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("fajrr").equals(getDate())) {
        fajrr.setChecked(true);

    }
    if(new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("duhrr").equals(getDate())) {
        duhrr.setChecked(true);

    }
    if(new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("ashrr").equals(getDate())) {
        ashrr.setChecked(true);

    }
    if(new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("maghribb").equals(getDate())) {
        maghribb.setChecked(true);

    }
    if(new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("eshaa").equals(getDate())) {
        eshaa.setChecked(true);

    }

    if(new SharedPrefsReader(mySharedPreferences).activatePrayerAlarm().equals(getDate()))
    {

        alarm.setChecked(true);
    }
    ref.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(alertDialogBuilder !=null)
            {


                try {
                    check=1;

                    Intent intent=new Intent(getApplicationContext(),PrayerTime.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Refreshing ",Toast.LENGTH_SHORT).show();
                    t2.setText("Refreshing...");
                    mon = c.get(Calendar.MONTH);
                    mon = mon + 1;
                    year = c.get(Calendar.YEAR);
                    t1.setText(getDate());
                    day = c.get(Calendar.DAY_OF_MONTH);
                    fajartime.setVisibility(View.INVISIBLE);
                    duhartime.setVisibility(View.INVISIBLE);
                    ashrtime.setVisibility(View.INVISIBLE);
                    maghribtime.setVisibility(View.INVISIBLE);
                    eshatime.setVisibility(View.INVISIBLE);
                    fajr.setVisibility(View.INVISIBLE);
                    duhar.setVisibility(View.INVISIBLE);
                    ashr.setVisibility(View.INVISIBLE);
                    maghrib.setVisibility(View.INVISIBLE);
                    isha.setVisibility(View.INVISIBLE);
                    retry.setVisibility(View.INVISIBLE);
                    loading.setVisibility(View.VISIBLE);

                    setTime();

                }catch(Exception e)
                {
                   // Toast.makeText(getApplicationContext(),"Error in Refreshing ",Toast.LENGTH_SHORT).show();


                }
            }
        }
    });

    alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(fajartime.getVisibility()==View.INVISIBLE)
                {
                    Toast.makeText(context,"Fetch Prayer times First",Toast.LENGTH_SHORT).show();
                    alarm.setChecked(false);
                }
                else
                {
                    fajrr.setChecked(true);
                    duhrr.setChecked(true);
                    ashrr.setChecked(true);
                    maghribb.setChecked(true);
                    eshaa.setChecked(true);
                }
            }
            else
            {
                if(fajrr.isChecked() && duhrr.isChecked() && ashrr.isChecked() && maghribb.isChecked() && eshaa.isChecked())
                {
                    fajrr.setChecked(false);
                    duhrr.setChecked(false);
                    ashrr.setChecked(false);
                    maghribb.setChecked(false);
                    eshaa.setChecked(false);
                }
            }

        }
    });


    fajrr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(fajartime.getVisibility()==View.INVISIBLE)
                {
                    Toast.makeText(context,"Fetch Prayer times First",Toast.LENGTH_SHORT).show();
                    fajrr.setChecked(false);
                }

            }

        }
    });

    duhrr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(fajartime.getVisibility()==View.INVISIBLE)
                {
                    Toast.makeText(context,"Fetch Prayer times First",Toast.LENGTH_SHORT).show();
                    duhrr.setChecked(false);
                }

            }

        }
    });
    ashrr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(fajartime.getVisibility()==View.INVISIBLE)
                {
                    Toast.makeText(context,"Fetch Prayer times First",Toast.LENGTH_SHORT).show();
                    ashrr.setChecked(false);
                }

            }

        }
    });

    maghribb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(fajartime.getVisibility()==View.INVISIBLE)
                {
                    Toast.makeText(context,"Fetch Prayer times First",Toast.LENGTH_SHORT).show();
                    maghribb.setChecked(false);
                }

            }

        }
    });
    eshaa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(fajartime.getVisibility()==View.INVISIBLE)
                {
                    Toast.makeText(context,"Fetch Prayer times First",Toast.LENGTH_SHORT).show();
                    eshaa.setChecked(false);
                }

            }

        }
    });

    // set dialog message
    alertDialogBuilder
            .setCancelable(true)
            .setPositiveButton("Save",
                    new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        public void onClick(DialogInterface dialog, int id) {
                            // get user input and set it to result
                            // edit text
//                                            Toast.makeText(context,userInput.getText()+"Dua Added ",Toast.LENGTH_SHORT).show();
//                                            Toast.makeText(context,userInputdua.getText()+"Dua Added ",Toast.LENGTH_SHORT).show();
                            if(check==0)
                            {



                                if(alarm.isChecked()) {

                                    if (!new SharedPrefsReader(mySharedPreferences).activatePrayerAlarm().equals(getDate())) {




                                        Intent[] intents=new Intent[6];
                                        intents[0]=new Intent(context,PrayerTime.class);
                                        int h= Integer.parseInt(fajartime.getText().toString().substring(0,2));
                                        int m= Integer.parseInt(fajartime.getText().toString().substring(2+1,5));


                                        intents[1]  = new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Fajr Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);

                                        h= Integer.parseInt(duhartime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(duhartime.getText().toString().substring(2+1,5));

                                        intents[2]= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Duhr Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);

                                        h= Integer.parseInt(ashrtime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(ashrtime.getText().toString().substring(2+1,5));

                                        intents[3]= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"ASHR Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);

                                        h= Integer.parseInt(maghribtime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(maghribtime.getText().toString().substring(2+1,5));

                                        intents[4]= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Magrib Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);

                                        h= Integer.parseInt(eshatime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(eshatime.getText().toString().substring(2+1,5));

                                        intents[5]= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Esha Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);



DataProvider obj=new DataProvider("",context);
obj.setIntents(intents);
obj.startThreadActivities();


                                        startActivities(intents);



                                        flag=1;
                                        editor.putString("prayerAlarmDay",getDate());
                                        editor.putString("fajrr",getDate());
                                        editor.putString("duhrr",getDate());
                                        editor.putString("ashrr",getDate());
                                        editor.putString("maghribb",getDate());
                                        editor.putString("eshaa",getDate());


                                        editor.apply();








                                    }
                                    else
                                    {
                                        Toast.makeText(context,"Alarm is already set",Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else
                                {
                                    int h,m;

                                    List<Intent> intents=new ArrayList();
                                    Intent i=new Intent(context,PrayerTime.class);
                                    intents.add(i);
                                    if(!new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("fajrr").equals(getDate()) && fajrr.isChecked() && !alarm.isChecked())
                                    {
                                        h= Integer.parseInt(fajartime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(fajartime.getText().toString().substring(2+1,5));


                                        Intent intent  = new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Fajr Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, 12)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, 10);
                                       intents.add(intent);
                                        flag=1;
                                        editor.putString("fajrr",getDate());
                                        editor.apply();
                                    }
                                    if(!new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("duhrr").equals(getDate()) && duhrr.isChecked() && !alarm.isChecked())
                                    {
                                        h= Integer.parseInt(duhartime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(duhartime.getText().toString().substring(2+1,5));


                                        Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Duhr Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, 3)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, 45);
                                        intents.add(intent);
                                        flag=1;
                                        editor.putString("duhrr",getDate());
                                        editor.apply();
                                    }
                                    if(!new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("ashrr").equals(getDate()) &&ashrr.isChecked() && !alarm.isChecked())
                                    {
                                        h= Integer.parseInt(ashrtime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(ashrtime.getText().toString().substring(2+1,5));

                                        Intent  intent= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"ASHR Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);
                                        intents.add(intent);
                                        flag=1;
                                        editor.putString("ashrr",getDate());
                                        editor.apply();
                                    }
                                    if(!new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("maghribb").equals(getDate()) &&maghribb.isChecked() && !alarm.isChecked())
                                    {
                                        h= Integer.parseInt(maghribtime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(maghribtime.getText().toString().substring(2+1,5));

                                        Intent  intent= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Magrib Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);
                                        intents.add(intent);
                                        flag=1;
                                        editor.putString("maghribb",getDate());
                                        editor.apply();

                                    }
                                    if(!new SharedPrefsReader(mySharedPreferences).PrayerTimeAlarm("eshaa").equals(getDate()) &&eshaa.isChecked() && !alarm.isChecked())
                                    {
                                        h= Integer.parseInt(eshatime.getText().toString().substring(0,2));
                                        m= Integer.parseInt(eshatime.getText().toString().substring(2+1,5));

                                        Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM)
                                                .putExtra(AlarmClock.EXTRA_MESSAGE,"Esha Prayer")
                                                .putExtra(AlarmClock.EXTRA_HOUR, h)
                                                .putExtra(AlarmClock.EXTRA_MINUTES, m);
                                        intents.add(intent);
                                        flag=1;
                                        editor.putString("eshaa",getDate());
                                        editor.apply();
                                    }
                                    Intent [] array= intents.toArray(new Intent[intents.size()]);
                                    startActivities(array);
                                }



                                dialog.cancel();
if(flag==0)
{
    Intent intent=new Intent(getApplicationContext(),PrayerTime.class);
                                   startActivity(intent);
}
//

                            }




                        }
                    })
            .setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        public void onClick(DialogInterface dialog, int id) {
                            if(check==0)
                            {
                              //  Toast.makeText(context,"Cancel ",Toast.LENGTH_LONG).show();

                                dialog.cancel();
                                Intent intent=new Intent(getApplicationContext(),PrayerTime.class);
                                startActivity(intent);

                            }

                        }
                    });




    alertDialogBuilder.show();

    if(!mySharedPreferences.getBoolean("nav_demo",false))
    {

        if(color==1)
        {
            new SimpleTooltip.Builder(this)
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
            new SimpleTooltip.Builder(this)
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

}
    void setTime() {

        if (isNetworkAvailable(getApplicationContext())) {


        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        if (isWiFi) {
           // Toast.makeText(getApplicationContext(), "Using Wifi", Toast.LENGTH_SHORT).show();
        }


//    locationTrack = new  LocationFinder(this,isWiFi);
//    longitude = locationTrack.getLongitude();
//    latitude = locationTrack.getLatitude();

        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            showSettingsAlert();
            Toast.makeText(getApplicationContext(), "Turn on loation ", Toast.LENGTH_SHORT).show();
            t2.setText("Turn on Location ");
            retry.setVisibility(View.VISIBLE);
            loading.setVisibility(View.INVISIBLE);
          //  showSettingsAlert();
        } else {
            SingleShotLocationProvider.requestSingleUpdate(this,
                    new SingleShotLocationProvider.LocationCallback() {
                        @Override
                        public void onNewLocationAvailable(SingleShotLocationProvider.GPSCoordinates location) {
                            Log.d("Location", "my location is " + location.toString());
                            longitude = location.longitude;
                            latitude = location.latitude;

                         //   Toast.makeText(context, "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();
//                            if (locationTrack.canGetLocation()) {

                          //  Toast.makeText(getApplicationContext(), day + "/" + "/" + mon + "/" + year, Toast.LENGTH_SHORT).show();
                            // Toast.makeText(context, "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();


                                if (longitude != 0.0 && latitude != 0.0) {

                                    queue = Volley.newRequestQueue(getApplicationContext());
                                    new Thread(
                                            new Runnable() {
                                                @Override
                                                public void run() {
                                                    try {

                                                        getPrayerTimes();
                                                    } catch (Exception e) {
                                                        t2.setText("Try Again !!!");
                                                        retry.setVisibility(View.VISIBLE);
                                                        loading.setVisibility(View.INVISIBLE);

                                                    }


                                                }
                                            }).start();

                                } else {


                                    t2.setText("Retry...");
                                    retry.setVisibility(View.VISIBLE);
                                    loading.setVisibility(View.INVISIBLE);

                                }



//                            } else {
//
//
//                                Toast.makeText(getApplicationContext(), "Turn on loation", Toast.LENGTH_SHORT).show();
//                                t2.setText("Turn on Location ");
//                                retry.setVisibility(View.VISIBLE);
//                                loading.setVisibility(View.INVISIBLE);
//                                showSettingsAlert();
//
//                            }
                        }
                    });
        }
        } else {
            Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();
            t2.setText("No Internet");
            loading.setVisibility(View.INVISIBLE);
            retry.setVisibility(View.VISIBLE);
        }

    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);


        alertDialog.setTitle("GPS is not Enabled!");

        alertDialog.setMessage("Do you want to turn on Location?");


        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);



            }
        });


        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        alertDialog.show();


    }

    public boolean isNetworkAvailable(Context context) {


        try {

            ConnectivityManager cm =
                    (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();


                if (activeNetwork != null) {

                    isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
                }
            }


            if (isConnected) {
                return true;
            } else if (isWiFi) {
                return true;
            } else
                return false;
        } catch (Exception e) {
            t2.setText("Try Again !!!" );
            retry.setVisibility(View.VISIBLE);
            loading.setVisibility(View.INVISIBLE);
            return false;
        }

    }
    @Override
    public void onBackPressed() {
        press++;
        if(press==1)
        {
            Toast.makeText(context,"press 1 more time to exit",Toast.LENGTH_SHORT).show();
        }
        else
        if(press==2)
        {

            finishAffinity();
            System.exit(0);
        }

    }

}

