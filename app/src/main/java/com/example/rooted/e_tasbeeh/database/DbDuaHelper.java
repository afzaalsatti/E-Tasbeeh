package com.example.rooted.e_tasbeeh.database;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DbDuaHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tasbeeh.db";
    public static final String TASBEEH_TABLE_NAME = "Dua";

    public static final String Dua_COLUMN_Dua= "arabic";
    public static final String Dua_COLUMN_Trans = "translation";
SharedPreferences mySharedPreferences;
    private HashMap hp;
    Context con;
    public DbDuaHelper(Context context) {

        super(context, DATABASE_NAME , null, 1);

        con=context;
        mySharedPreferences =con.getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table Dua " +
                        "( arabic text  primary key ,translation text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createTable()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(
                "create table Dua " +
                        "( arabic text  primary key ,translation text)"
        );












    }






    public boolean insertDua (String arabic, String trans) {
        try
        {


            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("arabic", arabic);

            contentValues.put("translation", trans);
            db.insert("Dua", null, contentValues);
            return true;
        }catch(Exception exp)
        {
            return false;
        }

    }


private String getFormattedDua(String str)
{
    int index=str.indexOf("\n");
    if(index!=-1)
    {
        if(!mySharedPreferences.getBoolean("night",false))
        {
            str="<font color='#000' ;size='10'>"+str.substring(0,index)+"</font><br>"+"\n\n"+str.substring((index)+1,str.length());
        }
        else
        {
            str="<font color='#E5E5E5' ;size='10'>"+str.substring(0,index)+"</font><br>"+"\n\n"+str.substring((index)+1,str.length());
        }


    }




return  str;

}

    public  ArrayList<ArrayList<String>> getAllDua() {

        ArrayList<ArrayList<String>> array_list = new ArrayList();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor res =  db.rawQuery( "select * from Dua", null );
        res.moveToFirst();
        ArrayList<String> dua1= new ArrayList<>();
        ArrayList<String> dua2= new ArrayList<>();
        int i=0;

        while(res.isAfterLast() == false){


            dua1.add(getFormattedDua(res.getString(res.getColumnIndex(Dua_COLUMN_Dua))));
            dua2.add(res.getString(res.getColumnIndex(Dua_COLUMN_Trans)));
            res.moveToNext();
        }
        Collections.reverse(dua1);
        Collections.reverse(dua2);
        array_list.add(dua2);
        array_list.add(dua1);

        return array_list;
    }


}
