package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class QiblaLocation extends AppCompatActivity {

    BottomNavigationView navigation;
    Toolbar toolbar;
    Button retry;
    WebView myWebView;
    ProgressDialog dialog;
    SharedPreferences mySharedPreferences = null;
    MediaPlayer mediaPlayer;
    Vibrator mVibrator;
    ImageView back;
    int color=0;
    int press=0;

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
                int dash = 200;     // Length of a Morse Code "dash" in milliseconds
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

                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);
                    navigation.setItemBackgroundResource(R.color.colorPrimary);


                    return true;
                case R.id.navigation_dua:



                     intent = new Intent(getApplicationContext(), DuaListActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);


                    return true;
                case R.id.navigation_kaba_compass:





                    return true;
                case R.id.navigation_settings:

                    intent = new Intent(getApplicationContext(), SettngsActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);

//
                    return true;
                case R.id.navigation_prayer_time:




                    intent = new Intent(getApplicationContext(), PrayerTime.class);
//                    intent.putExtra("longitude",longitude);
//                    intent.putExtra("latitude",latitude);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);



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
            setContentView(R.layout.activity_qibla_location);
            navigation = findViewById(R.id.navigation);
            navigation.getMenu().getItem(2).setIcon(R.drawable.cnd);
            color=2;
        }else {
            setContentView(R.layout.activity_qibla_location_light);
            navigation = findViewById(R.id.navigation);
            navigation.getMenu().getItem(2).setIcon(R.drawable.cnl);
            color=1;
        }
        myWebView = findViewById(R.id.webview);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mVibrator  = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        retry=findViewById(R.id.retry);
        retry.setVisibility(View.GONE);
        toolbar = findViewById(R.id.toolbar);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.type);

        Menu menu = navigation.getMenu();
        MenuItem menuitem = menu.getItem(2);
        menuitem.setChecked(true);

        MobileAds.initialize(this);
        AdView adView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.swipe_from_left,0);
            }
        });
       // myWebView.setWebViewClient(new CustomWebView());
        WebSettings settings=myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient() {

            // This method will be triggered when the Page Started Loading

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog = ProgressDialog.show(QiblaLocation.this, null,
                        "Please Wait...Qibla Locator is Loading...");
                dialog.setCancelable(true);
                super.onPageStarted(view, url, favicon);
            }

            // This method will be triggered when the Page loading is completed

            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
                super.onPageFinished(view, url);
            }

            // This method will be triggered when error page appear

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                dialog.dismiss();
                // You can redirect to your own page instead getting the default
                // error page
               // Toast.makeText(QiblaLocation.this,"UnExpected Error", Toast.LENGTH_LONG).show();
                loadUrl();
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        loadUrl();
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUrl();
            }
        });
        navigation.setItemIconTintList(null);
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
            SharedPreferences.Editor editor=mySharedPreferences.edit();

            editor.putBoolean("nav_demo",true);
            editor.apply();
        }

    }

    private class CustomWebView extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    private void loadUrl()
    {
        if(isNetworkAvailable(this))
        {
            myWebView.loadUrl("https://qiblafinder.withgoogle.com/intl/en");
            retry.setVisibility(View.GONE);

        }
        else
        {
            retry.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"we are sorry ! Try Again",Toast.LENGTH_LONG).show();
        }
    }
    public boolean isNetworkAvailable(Context context) {

        try {
            boolean isWiFi = false;
            boolean isConnected=false;
            ConnectivityManager cm =
                    (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

            if(cm!=null)
            {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();


                if(activeNetwork!=null)
                {
                    isWiFi= activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
                }}


            if(isConnected)
            {
                return true;
            }
            else if (isWiFi)
            {
                return true;
            }
            else
                return  false;
        }catch(Exception e)
        {

            return false;
        }

    }

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
}
