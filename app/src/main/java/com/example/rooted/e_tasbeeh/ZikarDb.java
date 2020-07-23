package com.example.rooted.e_tasbeeh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ZikarDb extends SQLiteOpenHelper {

    static final String table_name1="ZIKARTABLE";
    String col1="DAY";
    String col2="ZIKAR";



    public ZikarDb(@Nullable Context context) {
        super(context, table_name1, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table="CREATE TABLE "+
                table_name1+"( "+col1+"  varchar2(12) ," +
                col2+" varchar2(200) Primary key )";
        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       sqLiteDatabase.execSQL("Drop  TABLE   EXISTS"+table_name1);
        onCreate(sqLiteDatabase);

    }

    boolean addData(String day,String zikar)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col1,day);
        values.put(col2,zikar);
       long res= db.insert(table_name1,null,values);
       if(res==-1)
       {
           return false;
       }else
       {
           return true;
       }


    }


    Cursor getAllData(String day)
    {
       SQLiteDatabase db=this.getWritableDatabase();
       Cursor data=db.rawQuery("SELECT * FROM "+table_name1,null);
       if(data !=null)
       {
           List list=new ArrayList() ;
           while(data.moveToNext())
           {
               list.add(data.getString(1));
           }
       }
       return data;


    }

}
