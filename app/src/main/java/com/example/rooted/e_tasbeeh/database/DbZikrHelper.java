package com.example.rooted.e_tasbeeh.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbZikrHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "tasbeeh.db";
    public static final String TASBEEH_TABLE_NAME = "duatable";
    public static final String ZIKAR_COLUMN_ID = "id";
    public static final String Dua_COLUMN_TOPIC = "topic";
    public static final String Dua_COLUMN_DUA = "dua";

    private HashMap hp;
Context con;
    public DbZikrHelper(Context context) {

        super(context, DATABASE_NAME , null, 1);

        con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table duatable " +
                        "( topic text ,dua text primary key)"
        );
    }
public void createTable()
{
    SQLiteDatabase db=this.getWritableDatabase();
   db.execSQL(
            "create table duatable " +
                    "( topic text ,dua text primary key)"
    );












}





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS zikar");
        onCreate(db);
    }

    public boolean insertDua (String topic, String dua) {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("topic", topic);

            contentValues.put("dua", dua);
            db.insert("duatable", null, contentValues);
            return true;
        }catch(Exception exp)
        {
            return false;
        }

    }

    public ArrayList getData(String topic) {
        try
        {
            ArrayList array_list=new ArrayList();
            SQLiteDatabase db = this.getReadableDatabase();
            @SuppressLint("Recycle") Cursor res =  db.rawQuery( "select * from duatable where topic='"+topic+"'", null );


            res.moveToFirst();

            while(res.isAfterLast() == false){
                array_list.add(res.getString(res.getColumnIndex(Dua_COLUMN_DUA)));
                res.moveToNext();
            }
            return array_list;
        }catch(Exception e)
        {
            return  null;
        }

    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TASBEEH_TABLE_NAME);
        return numRows;
    }

    public boolean updateTASBEEH (Integer id,String topic, String dua) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("topic", topic);

        contentValues.put("dua", dua);
        db.update("duatable", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }


    public ArrayList<String[]> getAllDua() {
try
{
    ArrayList<String[]> array_list = new ArrayList();

    //hp = new HashMap();
    SQLiteDatabase db = this.getReadableDatabase();
    @SuppressLint("Recycle") Cursor res =  db.rawQuery( "select * from duatable", null );
    res.moveToFirst();
    String[] dua1=new String[res.getCount()];
    String[] dua2=new String[res.getCount()];
    int i=0;

    while(res.isAfterLast() == false){

        dua1[i]=res.getString(res.getColumnIndex(Dua_COLUMN_TOPIC));
        dua2[i]=res.getString(res.getColumnIndex(Dua_COLUMN_DUA));
        res.moveToNext();
    }
    array_list.add(dua1);
    array_list.add(dua2);
    return array_list;
} catch(Exception e)
{
    return null;
}


    }
    public ArrayList getAllDuaList() {

        try
        {
            ArrayList<String> array_list = new ArrayList();

            //hp = new HashMap();
            SQLiteDatabase db = this.getReadableDatabase();
            @SuppressLint("Recycle") Cursor res =  db.rawQuery( "select * from duatable", null );
            res.moveToFirst();

            int i=0;

            while(res.isAfterLast() == false){

                array_list.add(res.getString(res.getColumnIndex(Dua_COLUMN_TOPIC)));

                res.moveToNext();
            }

            return array_list;
        }catch(Exception e)
        {
            return null;
        }

    }
}
