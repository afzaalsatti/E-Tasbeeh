package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;

import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;

import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import android.widget.TextView;


import com.example.rooted.e_tasbeeh.business_logic_layer.DuaContainer;

import java.util.ArrayList;
import java.util.List;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class LoadZikarDua extends RecyclerView.Adapter<LoadZikarDua.viewHolder>{

    List engDua=new ArrayList<String>();
    List arabicDua=new ArrayList<String>();
    Context context;
    int layout;
    MediaPlayer mediaPlayer;
    SharedPreferences mySharedPreferences = null;
    android.support.v7.app.AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    View resetAlert;
    LayoutInflater li;
    ImageView resfresh;
    DuaContainer duaContainer;



    public LoadZikarDua(Context contex, List arabicDua , List engDua, int layout ) {
        this.arabicDua=arabicDua;
        this.engDua=engDua;
        this.context=contex;
        this.layout=layout;
        duaContainer=new DuaContainer(context);
        mediaPlayer = MediaPlayer.create(context, R.raw.type);
        mySharedPreferences =contex.getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);
        alertDialogBuilder = new AlertDialog.Builder(context);

 }
    public LoadZikarDua(Context contex, List arabicDua ,int layout ,ImageView ref) {
        this.arabicDua=arabicDua;
        this.context=contex;
        this.layout=layout;
        this.resfresh=ref;
        duaContainer=new DuaContainer(context);
        mediaPlayer = MediaPlayer.create(context, R.raw.type);
        mySharedPreferences =contex.getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);
        alertDialogBuilder = new AlertDialog.Builder(context);





    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=null;
        if(layout==1)
        {
            if(new SharedPrefsReader(mySharedPreferences).enableNight())
            {
                view =inflater.inflate(R.layout.activity_zikar_counter,parent,false);
            }else {
                view =inflater.inflate(R.layout.activity_zikar_counter_light,parent,false);
            }


        }
        else
        {
            if(new SharedPrefsReader(mySharedPreferences).enableNight())
            {
                view =inflater.inflate(R.layout.duas_recyclerview,parent,false);
            }else {
                view =inflater.inflate(R.layout.duas_recyclerview_light,parent,false);
            }
        }


        return new LoadZikarDua.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Typeface typeface=new SharedPrefsReader(mySharedPreferences).getTextStyle(context);

        if(layout==2 || layout==3)
        {
        viewHolder.text1.setText(Html.fromHtml((arabicDua.get(i).toString())));
        viewHolder.text2.setText(Html.fromHtml(engDua.get(i).toString()));
          //  viewHolder.text2.setTypeface(ResourcesCompat.getFont(context, R.font.arabic2));
           //viewHolder.text1.setTypeface(typeface);

        }
        else
        {


            viewHolder.zikar.setText(""+arabicDua.get(i));
            viewHolder.zikar.setTypeface(ResourcesCompat.getFont(context, R.font.arabic11));
        }


    }




    @Override
    public int getItemCount() {
        return arabicDua.size();
    }


     class viewHolder extends RecyclerView.ViewHolder
    {

        TextView text1,text2;

        ImageButton share,like;

        LinearLayout area;
        TextView zikar,counter_text;

        NumberPicker target;
        Button yes,no;


        TextView text;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            if(layout==3)
            {
                text1 = itemView.findViewById(R.id.arabic);
                text2 = itemView.findViewById(R.id.english);
                like = itemView.findViewById(R.id.likebutton);
                share = itemView.findViewById(R.id.sharebutton);
                like.setVisibility(View.INVISIBLE);
                share.setVisibility(View.INVISIBLE);
            }
            else
            if(layout==2) {
                text1 = itemView.findViewById(R.id.arabic);
                text2 = itemView.findViewById(R.id.english);
                like = itemView.findViewById(R.id.likebutton);
                share = itemView.findViewById(R.id.sharebutton);

                like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                        like.setImageResource(R.drawable.ic_favorite_black_24dp);
                        duaContainer.setData(text2.getText().toString(),text1.getText().toString());



                    }
                });
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent share = new Intent(android.content.Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                        // Add data to the intent, the receiving app will decide
                        // what to do with it.
                        share.putExtra(Intent.EXTRA_SUBJECT, "E-Zikar App");
                        share.putExtra(Intent.EXTRA_TEXT, "Shared From E-Zikar App Download now\n\n"+text1.getText()+"\n"+text2.getText());

                        context.startActivity(Intent.createChooser(share, "Share with Friends!"));
                    }
                });

            }
            else
                if(layout==1)
            {




                MainActivity obj=new MainActivity();
                String day= obj.dayy;



                area=itemView.findViewById(R.id.parent);
SharedPreferences.Editor editor=mySharedPreferences.edit();
                target=itemView.findViewById(R.id.number_picker);
                counter_text=itemView.findViewById(R.id.counter);


                if(!new SharedPrefsReader(mySharedPreferences).enableNight())
                {
                    if(!mySharedPreferences.getBoolean("area_hint",false))
                    {
                        new SimpleTooltip.Builder(context)
                                .anchorView(area)
                                .text("Tap on screen to count ")
                                .gravity(Gravity.CENTER)
                                .backgroundColor(Color.rgb(17,126,237))
                                .arrowColor(Color.rgb(17,126,237))
                                .textColor(Color.WHITE)
                                .animated(true)
                                .transparentOverlay(false)
                                .build()
                                .show();
                        editor.putBoolean("area_hint",true);
                        editor.apply();

                    }
                    new SimpleTooltip.Builder(context)
                            .anchorView(target)
                            .text("Scroll to set Target")
                            .gravity(Gravity.START)
                            .backgroundColor(Color.rgb(17,126,237))
                            .arrowColor(Color.rgb(17,126,237))
                            .textColor(Color.WHITE)
                            .animated(true)
                            .transparentOverlay(false)
                            .build()
                            .show();
                }
                else
                {
                    if(!mySharedPreferences.getBoolean("area_hint",false))
                    {
                        new SimpleTooltip.Builder(context)
                                .anchorView(area)
                                .text("Tap on screen to count ")
                                .gravity(Gravity.CENTER)
                                .backgroundColor(Color.rgb(0,0,0))
                                .arrowColor(Color.WHITE)
                                .textColor(Color.WHITE)
                                .animated(true)
                                .transparentOverlay(false)
                                .build()
                                .show();
                        editor.putBoolean("area_hint",true);
                        editor.apply();

                    }
                    new SimpleTooltip.Builder(context)
                            .anchorView(target)
                            .text("Scroll to set Target")
                            .gravity(Gravity.START)
                            .backgroundColor(Color.rgb(0,0,0))
                            .arrowColor(Color.WHITE)
                            .textColor(Color.WHITE)
                            .animated(true)
                            .transparentOverlay(false)
                            .build()
                            .show();
                }


                zikar=itemView.findViewById(R.id.zikar);
                zikar.setText("Arabic Zikar According to Day");
                counter_text.setText("0");


               zikar.setMovementMethod(new ScrollingMovementMethod());


                target.setMaxValue(10000);

                target.setMinValue(1);

                resfresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    li = LayoutInflater.from(context);
                    resetAlert = li.inflate(R.layout.alert, null);
                    yes=resetAlert.findViewById(R.id.button);
                    no=resetAlert.findViewById(R.id.button2);
                    if(new SharedPrefsReader(mySharedPreferences).enableNight())
                    {
                        Drawable buttonDrawable = yes.getBackground();
                        buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                        //the color is a direct color int and not a color resource
                        DrawableCompat.setTint(buttonDrawable, Color.BLACK);
                        yes.setBackground(buttonDrawable);

                        yes.setBackgroundResource(R.drawable.reset_button_background_light);

//                        no.setBackgroundColor(Color.BLACK);
                    }

                    alertDialogBuilder.setView(resetAlert);
                    yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter_text.setText("0");
                            alertDialog.dismiss();
                        }
                    });
                    no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if( alertDialog.isShowing())
                            {

                                alertDialog.dismiss();
                            }
                        }
                    });
                    alertDialogBuilder
                            .setCancelable(true);
//                            .setPositiveButton("Yes",
//                                    new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog,int id) {
//                                            counter_text.setText("0");
//
//                                        }
//                                    })
//                            .setNegativeButton("No",
//                                    new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog,int id) {
//                                            dialog.cancel();
//
//
//                                        }
//                                    });

                    // create alert dialog
                    alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();


















                }
            });


                zikar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(new SharedPrefsReader(mySharedPreferences).canPlaySound())
                    {
                        mediaPlayer.start();
                    }

                    String text=counter_text.getText().toString();
                    if(Integer.parseInt(text)<target.getValue())
                    {
                        counter_text.setText(""+(Integer.parseInt(text)+1));
                    }
                    else
                    {
                        if(!new SharedPrefsReader(mySharedPreferences).enableNight())
                        {

                            new SimpleTooltip.Builder(context)
                                    .anchorView(target)
                                    .text("Set Higher Target ")
                                    .gravity(Gravity.START)
                                    .backgroundColor(Color.rgb(17,126,237))
                                    .arrowColor(Color.rgb(17,126,237))
                                    .textColor(Color.WHITE)
                                    .animated(true)
                                    .transparentOverlay(false)
                                    .build()
                                    .show();
                            new SimpleTooltip.Builder(context)
                                    .anchorView(resfresh)
                                    .text("or Reset counter")
                                    .gravity(Gravity.START)
                                    .backgroundColor(Color.rgb(17,126,237))
                                    .arrowColor(Color.rgb(17,126,237))
                                    .textColor(Color.WHITE)
                                    .animated(true)
                                    .transparentOverlay(false)
                                    .build()
                                    .show();
                        }
                        else
                        {
                            new SimpleTooltip.Builder(context)
                                    .anchorView(target)
                                    .text("Set Higher Target or Reset")
                                    .gravity(Gravity.START)
                                    .backgroundColor(Color.rgb(0,0,0))
                                    .arrowColor(Color.WHITE)
                                    .textColor(Color.WHITE)
                                    .animated(true)
                                    .transparentOverlay(false)
                                    .build()
                                    .show();

                            new SimpleTooltip.Builder(context)
                                    .anchorView(resfresh)
                                    .text("or Reset Counter")
                                    .gravity(Gravity.START)
                                    .backgroundColor(Color.rgb(0,0,0))
                                    .arrowColor(Color.WHITE)
                                    .textColor(Color.WHITE)
                                    .animated(true)
                                    .transparentOverlay(false)
                                    .build()
                                    .show();
                        }
                    }



                }
            });

                area.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(new SharedPrefsReader(mySharedPreferences).canPlaySound())
                        {
                            mediaPlayer.start();
                        }
                        String text=counter_text.getText().toString();
                        if(Integer.parseInt(text)<target.getValue())
                        {
                            counter_text.setText(""+(Integer.parseInt(text)+1));
                        }
                        else
                        {
                            if(!new SharedPrefsReader(mySharedPreferences).enableNight())
                            {
                                new SimpleTooltip.Builder(context)
                                        .anchorView(target)
                                        .text("Set Higher Target ")
                                        .gravity(Gravity.START)
                                        .backgroundColor(Color.rgb(17,126,237))
                                        .arrowColor(Color.rgb(17,126,237))
                                        .textColor(Color.WHITE)
                                        .animated(true)
                                        .transparentOverlay(false)
                                        .build()
                                        .show();
                                new SimpleTooltip.Builder(context)
                                        .anchorView(resfresh)
                                        .text("or Reset counter")
                                        .gravity(Gravity.START)
                                        .backgroundColor(Color.rgb(17,126,237))
                                        .arrowColor(Color.rgb(17,126,237))
                                        .textColor(Color.WHITE)
                                        .animated(true)
                                        .transparentOverlay(false)
                                        .build()
                                        .show();
                            }
                            else
                            {
                                new SimpleTooltip.Builder(context)
                                        .anchorView(target)
                                        .text("Set Higher Target or Reset")
                                        .gravity(Gravity.START)
                                        .backgroundColor(Color.rgb(0,0,0))
                                        .arrowColor(Color.WHITE)
                                        .textColor(Color.WHITE)
                                        .animated(true)
                                        .transparentOverlay(false)
                                        .build()
                                        .show();

                                new SimpleTooltip.Builder(context)
                                        .anchorView(resfresh)
                                        .text("or Reset Counter")
                                        .gravity(Gravity.START)
                                        .backgroundColor(Color.rgb(0,0,0))
                                        .arrowColor(Color.WHITE)
                                        .textColor(Color.WHITE)
                                        .animated(true)
                                        .transparentOverlay(false)
                                        .build()
                                        .show();
                            }
                        }



                    }
                });

            }



        }
    }
}
