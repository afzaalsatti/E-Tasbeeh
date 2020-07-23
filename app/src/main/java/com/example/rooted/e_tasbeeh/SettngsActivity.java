package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;


import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class SettngsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    BottomNavigationView navigation;
    View layout;
    public RatingBar ratingbar;

    SeekBar seekbar,sound;

    TextView night,melodytext,vibrate,noti,soundtext, lblLicence;
ImageView back;
    CardView invite,feedback,developer,license,privacy;
    Switch switc,melody,vibrat,notify;
Button save,load;
TextView text;
EditText input;
    float bright;
    AudioManager audioManager;
int color=0;
int press=0;
    WindowManager.LayoutParams lp;


 float size=0;
 Context context=this;
    MediaPlayer mediaPlayer;
    SharedPreferences mySharedPreferences = null;
ScrollView scrollView;
    SharedPreferences.Editor editor = null;
    Vibrator mVibrator;
    TextView textstyle,feed,inv,dev;
TextView test;
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


                    Intent intent=new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);



                    return true;
                case R.id.navigation_dua:



                     intent=new Intent(getApplicationContext(),DuaListActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);


                    return true;
                case R.id.navigation_kaba_compass:

                    intent=new Intent(getApplicationContext(),QiblaLocation.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);
                    return true;
                case R.id.navigation_settings:





//
                    return true;
                case R.id.navigation_prayer_time:



//
                    intent=new Intent(getApplicationContext(),PrayerTime.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);



                    return true;
            }
            return false;
        }
    };
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySharedPreferences = getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);

        lp = getWindow().getAttributes();

        if(new SharedPrefsReader(mySharedPreferences).enableNight())
        {
            setContentView(R.layout.activity_settngs);
            navigation = findViewById(R.id.navigation);

            navigation.getMenu().getItem(4).setIcon(R.drawable.snd);
            color=2;


        }else
        {
            setContentView(R.layout.activity_settngs_light);
            navigation = findViewById(R.id.navigation);
            navigation.getMenu().getItem(4).setIcon(R.drawable.snl);
            color=1;
        }

        ratingbar = findViewById(R.id.ratingbar);

        license=findViewById(R.id.lic);
seekbar=findViewById(R.id.seekbar);
        lblLicence=findViewById(R.id.lblLicence);
        mVibrator  = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
       editor = mySharedPreferences.edit();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//       test=findViewById(R.id.textstyle);
//
//       textstyle=findViewById(R.id.textstyle);
         feed=findViewById(R.id.feed);
         inv=findViewById(R.id.inv);
         dev=findViewById(R.id.dev);
         night=findViewById(R.id.nightmode);
sound=findViewById(R.id.sound);
soundtext = findViewById(R.id.soundtext);
        melodytext=findViewById(R.id.melodytext);
//        brightness=findViewById(R.id.brightness);
        vibrate=findViewById(R.id.vibrate);
        noti=findViewById(R.id.noti);

        Menu menu = navigation.getMenu();
        MenuItem menuitem = menu.getItem(4);
        menuitem.setChecked(true);

        switc=findViewById(R.id.switc);
        melody=findViewById(R.id.melody);
        vibrat=findViewById(R.id.vibrat);
        notify=findViewById(R.id.notify);


        //spinner=findViewById(R.id.spinner2);

        invite=findViewById(R.id.invite);
        developer=findViewById(R.id.developer);
privacy=findViewById(R.id.privacy);
        feedback=findViewById(R.id.feedback);
        scrollView=findViewById(R.id.scrollview);
        MobileAds.initialize(this);
        AdView adView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.type);

        sound.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        sound.setProgress(audioManager .getStreamVolume(AudioManager.STREAM_MUSIC));
        melody.setChecked(new SharedPrefsReader(mySharedPreferences).canPlaySound());
        notify.setChecked(new SharedPrefsReader(mySharedPreferences).cansendNotif());
        vibrat.setChecked(new SharedPrefsReader(mySharedPreferences).canVibrate());



        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent(getApplicationContext(),Licences.class));
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String text="<b>Privacy Policy</b><br>" +
        "we built the E-Zikr app as ad-supported app. This SERVICE is provided at no cost and is intended for use as is.<br>" +
        "This page is used to inform visitors regarding our policies with the collection, use, and disclosure of Personal Information if anyone decided to use our Service.\n" +
        "If you choose to use our Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that we collect is used for providing and improving the Service. we will not use or share your information with anyone except as described in this Privacy Policy.\n" +
        "The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at E-Zikr unless otherwise defined in this Privacy Policy.\n" +
        "<br><b>Information Collection and Use</b>\n" +
        "<br><b>CALENDAR:</b><br>calendar is used to get present time and date to provide services like loading data from from(storage) ,to provide automatic  day and night mode etc\n" +
        "<br><b>CAMERA:</b><br>camera is used to take Dua pictures and save them in storage\n" +
        "<br><b>LOCATION:</b><br>location is used to get longitude and latitude of user .. these are then sent to API to fetch prayer timings.\n" +
        "<br><b>STORAGE:</b><br>phone storage is used to store and retrieve duas and zikr\n" +
        "<br><b>List of third party service providers used by the app</b><br>" +
        "<br> <a href=http://www.google.com>Google Play Services</a> \n" +
        "•<br><a href=\"www.google.com\" >AdMob</a>" +
        "•<br><a href='www.google.com'>api.aladhan.com</a>\n" +
        "•<br><a href='www.google.com'>ummalqura-calendar</a>\n" +
        "•<br><a href='www.google.com'>Google QiblaFinder</a>\n" +
        "•<br><a href='www.google.com'>Volley(By Google)</a>\n" +
                "•<br><a href='www.google.com'>simple-tooltip(By com.github.douglasjunior:android-simple-tooltip)</a>\n" +
        "<br>" +
        "<b>Privacy:</b><br>" +
        "<b>Location:</b><br>" +
        "Approx. (network based)<br>" +
        "Precise(GPS based):<br> we really care about your privacy and security but to provide precise services and excellent user experience we are using your location to get prayer timings and show qibla locator ,prayer timings are fetched by using third party Api (api.aladhan.com) above but we don’t show your identity we don’t share your any other data to api ,we use google api volley to send and recieve data secuerly over internet you can visit and explore more about privacy and condition of that third parties\n" +
        "<br>" +
        "<b>Setting Alarm:</b><br>App is using phone`s clock to set alarms to provide prayer alarm service\n" +
        "<br>" +
        "<b>Device access:</b><br>" +
        "<b>Network Acess:</b><br> network access is used to check status of network to make your usage experience better ,also to send important notification to you to keep you updated,\n" +
        "<br><b>Reading and sending data to Internet:</b><br> App reads data from internet to show prayer timings and other services it also sends some data to internet e.g location (to who and why is mentioned above)\n" +
        "<br>" +
        "<br><b>Modify system settings:</b><br> App modify your phone settings(settings alarm, prevent from sleeping,vibration,media(audio player)) to provide features setting alarm, sending notification, playing sound on click, vibration on click\n" +

        "<br><b>JavaScript Enabled</b><br> Java Script is automatically enabled while finding Qibla Location(Using Google Qibla Finder) \n\n" +
        "<br><b>Security</b><br>" +
        "we value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and we cannot guarantee its absolute security.\n" +
        "<br>Links to Other Sites<br>" +
        "This Service may contain links to other sites(Qibla Locator). , you will be directed to that site. Note that these external sites are not operated by us Therefore, we strongly advise you to review the Privacy Policy of these websites. we have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.\n" +
        "<br><b>Children’s Privacy</b><br>" +
        "These services are completely suitable for children ,anyone under age 12 can use these services\n" +
        "<br><b>Changes to This Privacy Policy</b><br>" +
        "We may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. we will notify you of any changes by posting the new Privacy Policy on this page. These changes are effective immediately after they are posted on this page.\n" +
        "Contact Us<br>" +
        "If you have any questions or suggestions about our Privacy Policy, do not hesitate to contact us at<br> <font color='#117EED'>afzaalsatti74@gmail.com</font>.\n" +
        "\n";

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Privacy Policy (E-Zikr)");
                alertDialog.setMessage(Html.fromHtml(text));



                alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                alertDialog.show();
            }
        });
ratingbar.setRating(new SharedPrefsReader(mySharedPreferences).getRating());
        switc.setChecked(new SharedPrefsReader(mySharedPreferences).enableNight());

        Typeface typeface=new SharedPrefsReader(mySharedPreferences).getTextStyle(context);
      //
        //  textstyle.setTypeface(typeface);



//       // lblLicence.setTypeface(typeface);
//        feed.setTypeface(typeface);
//        inv.setTypeface(typeface);
//        dev.setTypeface(typeface);
//        night.setTypeface(typeface);
//        soundtext.setTypeface(typeface);
//        brightness.setTypeface(typeface);
//        noti.setTypeface(typeface);
//        vibrate.setTypeface(typeface);
//        melodytext.setTypeface(typeface);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.swipe_from_left,0);

            }
        });


seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        bright = progress / (float)255;
        lp.screenBrightness = bright;
        getWindow().setAttributes(lp);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {


    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }
});

        sound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                sound.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                sound.setProgress(audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC));


                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


        // Spinner Drop down elements
//        List<String> categories = new ArrayList<>();
//        categories.add("default");
//        categories.add("Style1");
//        categories.add("Style2");
//        categories.add("Style3");
//        categories.add("Style4");
//        categories.add("Style5");
//        categories.add("Style6");
//        categories.add("Style7");
//        categories.add("Style8");
//        categories.add("Style9");
//        categories.add("Style10");

        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
//        spinner.setOnItemSelectedListener(this);
//        int num=new SharedPrefsReader(mySharedPreferences).num;
//        if(num-1==-1)
//        {
//            spinner.setSelection(0);
//        }
//        else
//        {
//            spinner.setSelection(num-1);
//        }
//        if(mySharedPreferences.getBoolean("showSettingHint",true))
//        {
//
//            if(color==1)
//            {
//                new SimpleTooltip.Builder(context)
//                        .anchorView(spinner)
//                        .text("Try out Cool Fonts")
//                        .gravity(Gravity.START)
//                        .animated(true)
//                        .backgroundColor(Color.rgb(17,126,237))
//                        .arrowColor(Color.rgb(17,126,237))
//                        .textColor(Color.WHITE)
//                        .transparentOverlay(false)
//                        .build()
//                        .show();
//
//            }else
//            {
//                new SimpleTooltip.Builder(context)
//                        .anchorView(spinner)
//                        .text("Try out Cool Fonts")
//                        .gravity(Gravity.START)
//                        .animated(true)
//                        .backgroundColor(Color.rgb(0,0,0))
//                        .arrowColor(Color.WHITE)
//                        .textColor(Color.WHITE)
//                        .transparentOverlay(false)
//                        .build()
//                        .show();
//            }
//
//            SharedPreferences.Editor editor = mySharedPreferences.edit();
//            editor.putBoolean("showSettingHint",false);
//            editor.apply();
//        }
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
           // SharedPreferences.Editor editor=mySharedPreferences.edit();

            editor.putBoolean("nav_demo",true);
            editor.apply();
        }
        navigation.setItemIconTintList(null);
scrollView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(new SharedPrefsReader(mySharedPreferences).canPlaySound())
        {
            mediaPlayer.start();
        }
    }
});




        switc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("night",isChecked);
                editor.apply();

                switc.setChecked(isChecked);
               Intent intent=new Intent(context,SettngsActivity.class);
               startActivity(intent);
            }
        });

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                editor.putFloat("rating",rating);
                editor.apply();
            }
        });
        vibrat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("vibrate",isChecked);
                editor.apply();
                vibrat.setChecked(isChecked);
            }
        });
        notify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                   // Toast.makeText(context,"Notification Enabled",Toast.LENGTH_SHORT).show();
                }else
                {
                   // Toast.makeText(context,"Notification Disabled",Toast.LENGTH_SHORT).show();
                }

                editor.putBoolean("notification",isChecked);
                editor.apply();
            }
        });

        melody.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("tapsound",isChecked);
                editor.apply();
                melody.setChecked(isChecked);
            }
        });


        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TO = "afzaal.bsse3328@iiu.edu.pk";
                String CC = "";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
              //emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App Feedback");


                try {
                    startActivity(Intent.createChooser(emailIntent, "Send Feedback using"));


                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        invite.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Use Amazing App");
        share.putExtra(Intent.EXTRA_TEXT, "Earn Good Deeds by reciting zikar and Duas! \n Find Precise Prayer Timings And Qibla Location acoording to your location\n ");

        startActivity(Intent.createChooser(share, "Share with Friends!"));
    }
});
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Developed By !");
                alertDialog.setMessage("afzaal.bsse3328@iiu.edu.pk");

                alertDialog.setPositiveButton("Contact", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        String TO = "afzaal.bsse3328@iiu.edu.pk";
                        String CC = "";
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);

                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("text/plain");
                       // emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_CC, CC);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reference : App User");


                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send mail using"));


                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }

                        dialog.cancel();



                    }
                });

                alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                alertDialog.show();


                    }
                });
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



//        load.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//               String t= mySharedPreferences.getString("text","Dummy");
//               text.setText(t);
//
//            }
//        });











    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        String item = adapterView.getItemAtPosition(i).toString();

       editor.putString("style",item);
        editor.apply();
        Typeface typeface=new SharedPrefsReader(mySharedPreferences).getTextStyle(context);



//        lblLicence.setTypeface(typeface);
//        textstyle.setTypeface(typeface);
//
//        feed.setTypeface(typeface);
//        inv.setTypeface(typeface);
//        dev.setTypeface(typeface);
//
//        night.setTypeface(typeface);
//        soundtext.setTypeface(typeface);
//        brightness.setTypeface(typeface);
//        noti.setTypeface(typeface);
//        vibrate.setTypeface(typeface);
//        melodytext.setTypeface(typeface);


    }




    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
