package com.example.rooted.e_tasbeeh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DbOperations {
    Context context;
    public DbOperations(Context con) {
        this.context=con;
    }

    public void addzikar() {
        final ZikarDb   db=new ZikarDb(context);
        db.addData("Monday", "اَللّٰهُمَّ ادْحَرْ عَنِّي مَرَدَةَ الْجِنِّ وَ الْإِنْسِ وَ الشَّيَاطِيْنِ وَ بَارِكْ لِي فِيْ بِنَائِي");



    }

    void loadZikar(RecyclerView r)
    {

       addzikar();

        List zikar = new ArrayList();
        for (int i = 0; i < 15; i++) {
            zikar.add("Zikar " + (i + 1));
        }
        ListHandler zikar_adapter=new ListHandler(context,zikar,r,1);
        r.setAdapter(zikar_adapter);


    }

}
