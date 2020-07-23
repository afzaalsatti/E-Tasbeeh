package com.example.rooted.e_tasbeeh.business_logic_layer;

import android.content.Context;

import com.example.rooted.e_tasbeeh.database.DbDuaHelper;

import java.util.ArrayList;

public class DuaContainer {

    Context context;
    ArrayList<String> dua;
    ArrayList<String> trans;
    ArrayList<ArrayList<String>> data;
    DbDuaHelper db;
    public DuaContainer(Context con)
    {
        this.context=con;
       db=new DbDuaHelper(context);
       try{
           db.createTable();
       }catch(Exception e)
       {

       }

    }
    public boolean readDataFromDB()
    {

        data=db.getAllDua();
        if(data!=null && !data.isEmpty())
        {
            dua=  data.get(0);
            trans=  data.get(1);
            return  true;

        }
else
    return  false;





    }

    public ArrayList<String> getDua()
    {
        if(dua!=null)
        {
            return dua;
        }
        return  null;
    }

    public ArrayList<String> getTrans() {
        if(trans!=null)
        {
            return trans;

        }
        return  null;

    }

    public boolean setData(String dua,String trans) {
        try
        {
            dua=dua.trim();
            trans=trans.trim();
            db.insertDua(dua,trans);


            return true;
        }catch(Exception e)
        {
            return  false;
        }

    }
}
