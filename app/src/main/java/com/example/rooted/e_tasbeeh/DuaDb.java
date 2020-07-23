package com.example.rooted.e_tasbeeh;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class DuaDb extends SQLiteOpenHelper {

    static final String table_name="DUATABLE";
    String col1="TOPIC";
    String col2="DUA";
    String col3="DISC";




    public DuaDb(@Nullable Context context) {
        super(context, table_name, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table="CREATE TABLE "+
                table_name+"( "+col1+"  varchar2(30) Primary Key ," +
                col2+" varchar(250) Primary Key ," +
               col3+ " varchar2(100) )"
                ;
        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // sqLiteDatabase.execSQL("Drop  TABLE  EXISTS"+table_name1);
        onCreate(sqLiteDatabase);

    }

    boolean addData(String topic,String dua,String disc)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TOPIC",topic);
        values.put("DUA",dua);
        values.put("DISC",disc);
        long res= db.insert(table_name,null,values);
        if(res==-1)
        {
            return false;
        }else
        {
            return true;
        }


    }


    Cursor getAllData(String topic)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+table_name,null);
        return data;


    }

}
