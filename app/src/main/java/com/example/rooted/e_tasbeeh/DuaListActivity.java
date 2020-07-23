package com.example.rooted.e_tasbeeh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Bitmap;

import android.graphics.Color;
import android.media.MediaPlayer;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.example.rooted.e_tasbeeh.database.DbZikrHelper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import java.util.List;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class DuaListActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    RecyclerView zikar_list;
    ListHandler zikar_adapter;
    Toolbar toolbar;

    public Context context=this;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    MediaPlayer mediaPlayer;
    SharedPreferences mySharedPreferences = null;
    LayoutInflater li;
    View promptsView ;
TextView title;
ImageView back,refresh;
    Vibrator mVibrator;
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
int color=0;
int press=0;
    List zikar;
    AdView adView;
    AdRequest adRequest;
    RecyclerView area;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

new LoadActivity().execute();

        Menu menu=navigation.getMenu();
        MenuItem menuitem= menu.getItem(1);
        menuitem.setChecked(true);
        navigation.setItemIconTintList(null);

//        zikar_list.setLayoutAnimation(animation(zikar_list));
//        zikar_list.getAdapter().notifyDataSetChanged();
//        zikar_list.scheduleLayoutAnimation();
    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");







        }

        Intent intent=new Intent(getApplicationContext(),DuaListActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.goup,R.anim.godown);
    }


    private void getZikar()
    {
         zikar=new ArrayList();
        try
        {
            DbZikrHelper db=new DbZikrHelper(context);
            ArrayList res= db.getAllDuaList();

            for(int i=0;i<res.size();i++)
            {
                if(!zikar.contains(res.get(i)))
                {
                    zikar.add(res.get(i));
                }

            }


        }catch(Exception exp)
        {


        }


        zikar.add("Daily Routine");
        zikar.add("Common Problems");
        zikar.add("After Prayers");
        zikar.add("Istikhara");
        zikar.add("Forgiveness");
        zikar.add("Protection");
        zikar.add("Get Amazing Rewards");
        zikar.add("Marriage Related");
        zikar.add("Journey");
        zikar.add("Mix Duas");
        zikar.add("Avoidance of Bad Habits");
        zikar.add("Curing Diseases");
        zikar.add("On Death");
        zikar.add("Good-Deeds");
        zikar.add("Recovery");
        zikar.add("Learinng");








    }


    public LayoutAnimationController animation(RecyclerView mainrecylerView)
    {
        Context context=mainrecylerView.getContext();
        LayoutAnimationController controller=AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);
        return controller;


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
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


    void setDua(String topic ,String dua)
    {
        try
        {

            DbZikrHelper db=new DbZikrHelper(context);
            try
            {
                db.createTable();

            }
            catch(Exception exp)
            {


            }
            boolean res=db.insertDua(topic,dua);
            if(res)
            {
                Toast.makeText(context,"Dua Added Succesfully ",Toast.LENGTH_SHORT).show();

            }else
            {
                Toast.makeText(context,"Something is not right ",Toast.LENGTH_SHORT).show();
            }


        }catch(Exception exp)
        {
            //Toast.makeText(context,"Something is not right ",Toast.LENGTH_SHORT).show();

        }





    }


    private class LoadActivity extends AsyncTask<Void,Void,Void>
    {
        @SuppressLint("InflateParams")
        @Override
        protected void onPreExecute() {
            mySharedPreferences = getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);
            if(new SharedPrefsReader(mySharedPreferences).enableNight())
            {
                setContentView(R.layout.activity_main);
                navigation = findViewById(R.id.navigation);
                navigation.getMenu().getItem(1).setIcon(R.drawable.dnd);
                color=2;


            }else
            {
                setContentView(R.layout.activity_mainlight);
                navigation = findViewById(R.id.navigation);
                navigation.getMenu().getItem(1).setIcon(R.drawable.dnl);
                color=1;
            }
area=findViewById(R.id.zikar_recycler);
            adView = findViewById(R.id.adView);
            back=findViewById(R.id.back);
            back.setVisibility(View.INVISIBLE);
            alertDialogBuilder = new AlertDialog.Builder(
                    context);
            alertDialogBuilder.setIcon(R.mipmap.logo_app_icon);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.type);


            title=findViewById(R.id.toolbar_title);
            zikar_list=findViewById(R.id.zikar_recycler);
            zikar_list.setHasFixedSize(true);
            zikar_list.setLayoutManager(new LinearLayoutManager(context));



            mVibrator  = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            li = LayoutInflater.from(context);
            promptsView = li.inflate(R.layout.dua_prompt, null);
            toolbar=findViewById(R.id.toolbar);
            toolbar.inflateMenu(R.menu.duamenu);
            title.setText("Duas");
            refresh=findViewById(R.id.refresh);
            refresh.setVisibility(View.INVISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            getZikar();
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), DuaListActivity.class);
                    startActivity(intent);

                }
            });
            adRequest = new AdRequest.Builder().build();
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
                        int long_gap = 1000;    // Length of Gap Between Words
                        long[] pattern = {
                                0,  // Start immediately
                                dot, short_gap, dot    // s

                        };

                        mVibrator.vibrate(pattern, -1);
                    }

                    switch (item.getItemId()) {
                        case R.id.navigation_home:


                            Intent intent=new Intent(getApplicationContext(),Home.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.goup,R.anim.godown);
                            return true;
                        case R.id.navigation_dua:



                            return true;
                        case R.id.navigation_kaba_compass:


                            intent = new Intent(getApplicationContext(), QiblaLocation.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.goup,R.anim.godown);
                            return true;
                        case R.id.navigation_settings:

                            intent=new Intent(getApplicationContext(),SettngsActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.goup,R.anim.godown);
                            return true;
                        case R.id.navigation_prayer_time:


                            intent = new Intent(getApplicationContext(), PrayerTime.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.goup,R.anim.godown);

                            return true;
                    }
                    return false;
                }
            };
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


                    new SimpleTooltip.Builder(context)
                            .anchorView(area)
                            .text("Click to See Duas")
                            .backgroundColor(Color.rgb(17,126,237))
                            .arrowColor(Color.rgb(17,126,237))
                            .textColor(Color.WHITE)
                            .gravity(Gravity.CENTER)
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


                    new SimpleTooltip.Builder(context)
                            .anchorView(area)
                            .text("CClick to See Duas")
                            .backgroundColor(Color.rgb(0,0,0))
                            .arrowColor(Color.WHITE)
                            .textColor(Color.WHITE)
                            .gravity(Gravity.CENTER)
                            .animated(true)
                            .transparentOverlay(false)
                            .build()
                            .show();
                }

                SharedPreferences.Editor editor=mySharedPreferences.edit();
                editor.putBoolean("nav_demo",true);
                editor.apply();
            }
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    if(new SharedPrefsReader(mySharedPreferences).canPlaySound())
                    {
                        if(mediaPlayer.isPlaying())
                        {
                            mediaPlayer.stop();
                        }
                        mediaPlayer.start();
                    }

                    if(item.getItemId()==R.id.adddua)
                    {


                        // set prompts.xml to alertdialog builder
                        alertDialogBuilder.setView(promptsView);
                        final EditText userInput = promptsView
                                .findViewById(R.id.p_topic);
                        final EditText userInputdua = promptsView
                                .findViewById(R.id.p_dua);
                        userInputdua.setVisibility(View.VISIBLE);
                        TextView t=promptsView.findViewById(R.id.d);
                        t.setVisibility(View.VISIBLE);



                        // set dialog message
                        alertDialogBuilder
                                .setCancelable(true)
                                .setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                // get user input and set it to result
                                                // edit text
//                                            Toast.makeText(context,userInput.getText()+"Dua Added ",Toast.LENGTH_SHORT).show();
//                                            Toast.makeText(context,userInputdua.getText()+"Dua Added ",Toast.LENGTH_SHORT).show();
                                                setDua(userInput.getText().toString() ,userInputdua.getText().toString());
                                                dialog.cancel();
                                                Intent intent=new Intent(getApplicationContext(),DuaListActivity.class);
                                                startActivity(intent);
                                                overridePendingTransition(R.anim.goup,R.anim.godown);


                                            }
                                        })
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                dialog.cancel();
                                                Intent intent=new Intent(getApplicationContext(),DuaListActivity.class);
                                                startActivity(intent);
                                                overridePendingTransition(R.anim.goup,R.anim.godown);

                                            }
                                        });

                        // create alert dialog
                        alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();
                    }
                    else if(item.getItemId()== R.id.addpic)
                    {



                        // set prompts.xml to alertdialog builder
                        alertDialogBuilder.setView(promptsView);
                        final EditText userInput = promptsView
                                .findViewById(R.id.p_topic);
                        final EditText userInputdua = promptsView
                                .findViewById(R.id.p_dua);
                        userInputdua.setVisibility(View.INVISIBLE);
                        TextView t=promptsView.findViewById(R.id.d);
                        t.setVisibility(View.INVISIBLE);



                        // set dialog message
                        alertDialogBuilder
                                .setCancelable(true)
                                .setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                // get user input and set it to result
                                                // edit text
                                                if(userInput.length()>4)
                                                {
                                                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                                                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

                                                        dialog.cancel();


                                                    }
                                                    else
                                                    {
                                                        Toast.makeText(context,"Camera not found",Toast.LENGTH_SHORT).show();
                                                        Intent intent=new Intent(getApplicationContext(),DuaListActivity.class);
                                                        startActivity(intent);
                                                        overridePendingTransition(R.anim.goup,R.anim.godown);

                                                    }
                                                }
                                                else{
                                                    Intent intent=new Intent(getApplicationContext(),DuaListActivity.class);
                                                    startActivity(intent);
                                                    overridePendingTransition(R.anim.goup,R.anim.godown);
                                                    Toast.makeText(context,"Please add Topic and try again",Toast.LENGTH_SHORT).show();

                                                }


                                            }
                                        })
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                dialog.cancel();
                                                Intent intent=new Intent(getApplicationContext(),DuaListActivity.class);
                                                startActivity(intent);
                                                overridePendingTransition(R.anim.goup,R.anim.godown);

                                            }
                                        });

                        // create alert dialog
                        alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();






                    }
                    else{
                        startActivity(new Intent(context,SearchDua.class));

                    }



                    return false;
                }
            });
            if(mySharedPreferences.getBoolean("showDuaListHint",true))
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
                }

                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putBoolean("showDuaListHint",false);
                editor.apply();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            zikar_adapter=new ListHandler(context,zikar,zikar_list,2,back,refresh);
            zikar_list.setAdapter(zikar_adapter);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            adView.loadAd(adRequest);
        }

    }

}
