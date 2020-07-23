package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    ImageView p1, p2, p3, p4, p5, p6;
    GridLayout grid;
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor editor = null;
    int t;
    int press=0;
    Intent mainIntent;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

new LoadViewTask().execute();



    }

    private void  buttonClicklickListener()
    {

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


    private class LoadViewTask extends AsyncTask<Void, Void, Void>
    {
        //Before running code in separate thread
        @Override
        protected void onPreExecute()
        {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mySharedPreferences = getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);


                    if (mySharedPreferences.getBoolean("night",false)) {
                        setContentView(R.layout.splashactivity2);
                    } else {
                        setContentView(R.layout.splashactivity2light);
                    }
                    p1 = findViewById(R.id.p1);
                    p2 = findViewById(R.id.p2);
                    p3 = findViewById(R.id.p3);
                    p4 = findViewById(R.id.p4);
                    p5 = findViewById(R.id.p5);
                    p6 = findViewById(R.id.p6);
                }
            });






        }

        //The code to be executed in a background thread.
        @Override
        protected Void doInBackground(Void... params)
        {


            /* This is just a code that delays the thread execution 4 times,
             * during 850 milliseconds and updates the current progress. This
             * is where the code that is going to be executed on a background
             * thread must be placed.
             */
            try
            {

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(Home.this, MainActivity.class);
                       startActivity(mainIntent);
                        overridePendingTransition(R.anim.goup,R.anim.godown);

                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(Home.this, DuaListActivity.class);
                      startActivity(mainIntent);
                        overridePendingTransition(R.anim.goup,R.anim.godown);

                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(context, QiblaLocation.class);
                      startActivity(mainIntent);
                        overridePendingTransition(R.anim.goup,R.anim.godown);

                    }
                });
                p4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            mainIntent = new Intent(Home.this, PrayerTime.class);

                            startActivity(mainIntent);
                            overridePendingTransition(R.anim.goup,R.anim.godown);

                        } catch (Exception e) {

                        }
                    }
                });
                p5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(Home.this, SettngsActivity.class);
                        startActivity(mainIntent);
                        overridePendingTransition(R.anim.goup,R.anim.godown);


                    }
                });

                p6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainIntent = new Intent(Home.this, ExtraActivity.class);
                        startActivity(mainIntent);
                        overridePendingTransition(R.anim.goup,R.anim.godown);

                    }
                });

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        //Update the progress


        //after executing the code in the thread
        @Override
        protected void onPostExecute(Void result)
        {


        }
    }
}