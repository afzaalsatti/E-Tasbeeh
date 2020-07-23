package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Licences extends AppCompatActivity {
    ImageView back;
    TextView license;
int press=0;
Context context;
RelativeLayout scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licences);
context=this;



scene=findViewById(R.id.scene);


        back=findViewById(R.id.back);
        license=findViewById(R.id.license);

       SharedPreferences mySharedPreferences = getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);

        if (new SharedPrefsReader(mySharedPreferences).enableNight()) {
            back.setImageResource(R.drawable.darkback);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), SettngsActivity.class));
            }
        });
   }

    @Override
    public void onBackPressed() {

            this.finish();



    }
}
