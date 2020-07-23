package com.example.rooted.e_tasbeeh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class ImageDb extends SQLiteOpenHelper {
    static final String table_name="IMAGEADD";
    String col1="TOPIC";
    String col2="LINK";


    public ImageDb(@Nullable Context context) {
        super(context, table_name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table="CREATE TABLE "+
                table_name+"( "+col1+"  varchar2(30) Primary Key ," +
                col2+" varchar(250) Primary Key)";
        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // sqLiteDatabase.execSQL("Drop  TABLE  EXISTS"+table_name1);
        onCreate(sqLiteDatabase);

    }

    boolean addData(String topic,String link)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TOPIC",topic);
        values.put("LINK",link);
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
        Cursor data=db.rawQuery("SELECT * FROM "+table_name+"Where DAY =\'"+topic+"\'",null);
        return data;


    }






}
