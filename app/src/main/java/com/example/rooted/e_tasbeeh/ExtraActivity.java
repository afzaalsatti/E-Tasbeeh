package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rooted.e_tasbeeh.business_logic_layer.DuaContainer;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class ExtraActivity extends AppCompatActivity {

    RecyclerView liked_dua;
    Context context;

    ImageView back;
    AdView adView;
    AdRequest adRequest;
    static int press=0;
    SharedPreferences mySharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySharedPreferences = getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
        setContentView(R.layout.activity_extra);
        back=findViewById(R.id.back);
        adView = findViewById(R.id.adView);
        if(mySharedPreferences.getBoolean("night",false))
        {

back.setImageResource(R.drawable.darkback);



        }else
        {

            back.setImageResource(R.drawable.new_back_button);


        }

         context=this;
        List dua,trans;
        adRequest = new AdRequest.Builder().build();

        liked_dua=findViewById(R.id.zikar_recycler);

        liked_dua.setHasFixedSize(true);
        liked_dua.setLayoutManager(new LinearLayoutManager(context));


        DuaContainer obj=new DuaContainer(context);
        back.setVisibility(View.VISIBLE);


        if(obj.readDataFromDB())
        {
            dua=obj.getDua();
            trans=obj.getTrans();

            loadFavDuaList(dua,trans);
        }

        else {


            Toast.makeText(context, "No Data Found", Toast.LENGTH_LONG).show();
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
             overridePendingTransition(R.anim.slide_from_right,R.anim.godown);
            }
        });
        adView.loadAd(adRequest);
    }
    public void loadFavDuaList(List dua,List trans)
    {
        liked_dua.setAdapter(new LoadZikarDua(context,dua,trans,3));
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


}
