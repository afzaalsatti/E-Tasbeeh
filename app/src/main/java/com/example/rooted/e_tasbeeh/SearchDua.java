package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.rooted.e_tasbeeh.database.DbZikrHelper;
import java.util.ArrayList;
import java.util.List;

public class SearchDua extends AppCompatActivity {
RecyclerView searchDua;
    LoadZikarDua zikar_adapter;
    List eng;
    String query;
    List arab;
    Context context;
    SearchView searchView;
    ImageView back;
    int press=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dua);
        eng=new ArrayList();
        arab=new ArrayList();


        context=this;

        back=findViewById(R.id.back);
        searchView=findViewById(R.id.search_bar);
        searchDua = findViewById(R.id.zikar_recycler);
        searchDua.setHasFixedSize(true);
        searchDua.setLayoutManager(new LinearLayoutManager(this));
        zikar_adapter = new LoadZikarDua(this, eng, arab, 2);
        searchDua.setAdapter(zikar_adapter);
        SharedPreferences mySharedPreferences = getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);

        if (new SharedPrefsReader(mySharedPreferences).enableNight()) {
            back.setImageResource(R.drawable.darkback);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), DuaListActivity.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Do whatever you need. This will be fired only when submitting.
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                 query=newText;


                        DataProvider obj=new DataProvider("",context);
                List<String[]> l=  new DbZikrHelper(context).getAllDua();
                List<String[]> list1=null;
                List<String[]> list2=null;
                        obj.getA();
                        List<List> allData=obj.getAllDua();
                        List d1=new ArrayList();
                        List d2=new ArrayList();
                        if(allData !=null)
                        {
                             list1=allData.get(0);
                             list2=allData.get(1);
                            if(l!=null)
                            {
                                list2.add(l.get(0));
                                list1.add(l.get(1));
                            }
                        }



                        try
                        {
if(list1 !=null && list2!=null)
{
    for(int i=0;i<list1.size();i++)
    {
        String[] sublist=list1.get(i);
        String[]sublist2=list2.get(i);


        for(int j=0;j<sublist2.length;j++)
        {

            if(sublist2[j] != null && sublist[j] !=null)
            {
                if(sublist2[j].toLowerCase().contains(query.toLowerCase())) {

                    d1.add(sublist[j]);
                    d2.add(sublist2[j]);

                }
            }


        }




    }

    if(!d1.isEmpty())
    {
        zikar_adapter = new LoadZikarDua(context, d1, d2, 2);
        searchDua.setAdapter(zikar_adapter);

    }
    else
    {
        Toast.makeText(context,"Try Exact Title or enter keywords like lost ,prayer etc",Toast.LENGTH_SHORT).show();
        zikar_adapter = new LoadZikarDua(context, eng, arab, 2);
        searchDua.setAdapter(zikar_adapter);
    }
}
else
{
    Toast.makeText(context,"No DataFound",Toast.LENGTH_SHORT).show();
    zikar_adapter = new LoadZikarDua(context, eng, arab, 2);
    searchDua.setAdapter(zikar_adapter);
}

                        }catch (Exception e)
                        {
                            Toast.makeText(context,"Try Exact Title or enter keywords like lost ,prayer etc",Toast.LENGTH_SHORT).show();

                        }





                return false;
            }
        });






    }

    @Override
    public void onBackPressed() {
       this.finish();

    }
}
