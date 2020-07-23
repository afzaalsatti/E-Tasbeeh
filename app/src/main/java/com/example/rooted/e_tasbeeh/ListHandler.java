package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class ListHandler extends RecyclerView.Adapter<ListHandler.ViewHolder> {

    List zikar;
    Context context;
    RecyclerView r;
    int layout;
    MediaPlayer mediaPlayer;
    SharedPreferences mySharedPreferences = null;
ImageView back,refresh;
String zikr_text;


    public ListHandler(Context context, List zikar, RecyclerView r, int layout,ImageView back,ImageView ref) {
        this.zikar=zikar;
        this.context=context;
        this.r=r;
        this.layout=layout;
        this.refresh=ref;
     mediaPlayer = MediaPlayer.create(context, R.raw.type);
        mySharedPreferences =context.getSharedPreferences("Test PREFS",Activity.MODE_PRIVATE);
this.back=back;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =null;
        boolean nighttime=new SharedPrefsReader(mySharedPreferences).enableNight();
        if(layout==1)
        {
            if(!nighttime)
            {
                view =inflater.inflate(R.layout.daily_zikar_list_design_light,parent,false);
            }else {
                view =inflater.inflate(R.layout.daily_zikar_list_design_dark,parent,false);
            }
        }
        else
        {
            if(!nighttime)
            {
                view =inflater.inflate(R.layout.zikar_list_design_light,parent,false);

            }else {
                view =inflater.inflate(R.layout.zikar_list_design,parent,false);
            }
        }




        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       Typeface typeface=new SharedPrefsReader(mySharedPreferences).getTextStyle(context);

        viewHolder.text2.setText(""+zikar.get(i));
        viewHolder.text2.setVisibility(View.INVISIBLE);

        if(!(zikar.get(i).toString().length()>40))
        {
            viewHolder.text.setText(zikar.get(i).toString());
        }else
        {
            viewHolder.text.setText(""+zikar.get(i).toString().substring(0,40)+"....");
        }

      //  viewHolder.text.setTypeface(typeface);




    }

    @Override
    public int getItemCount() {
        return zikar.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder
    {


TextView text,text2;
CardView cv;
TextView number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            text=itemView.findViewById(R.id.recyclertext);
            text2=itemView.findViewById(R.id.recyclertext2);






            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   back.setVisibility(View.VISIBLE);
                    zikr_text=text2.getText().toString();
                    if(new SharedPrefsReader(mySharedPreferences).canPlaySound())
                    {
                        mediaPlayer.start();
                    }
                    String eng="English Description";
                    String arb="Arabic Dua";
                    if(layout==1)
                    {

                        refresh.setVisibility(View.VISIBLE);
                        List b=new ArrayList();
                       b.add(zikr_text);

                        r.setLayoutManager(new LinearLayoutManager(context));
                        LoadZikarDua adapter1=new LoadZikarDua(context,b,1,refresh);
                        r.setAdapter(adapter1);
                    }
                  else
                    {




                        String topic=zikr_text;
                        List a=new ArrayList();
                        List b=new ArrayList();

                        DataProvider obj=new DataProvider(text.getText().toString(),context);
                        a=obj.getA();
                        b=obj.getB();

//
                        r.setLayoutManager(new LinearLayoutManager(context));
                        LoadZikarDua adapter1=new LoadZikarDua(context,a,b,2);
                        r.setAdapter(adapter1);

                    }
                }
            });

        }
    }
}
