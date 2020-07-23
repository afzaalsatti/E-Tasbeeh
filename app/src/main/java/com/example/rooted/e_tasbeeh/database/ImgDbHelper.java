package com.example.rooted.e_tasbeeh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImgDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "tasbeeh.db";
    public static final String TASBEEH_TABLE_NAME = "imgtable";
    public static final String ZIKAR_COLUMN_ID = "id";
    public static final String Img_COLUMN_TOPIC = "topic";

    public static final String Img_COLUMN_link = "link";
    private HashMap hp;

    public ImgDbHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table imgtable " +
                        "( topic text ,link text primary key)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS imgtable");
        onCreate(db);
    }

    public boolean insertZikar (String topic,String link) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("topic", topic);
        contentValues.put("link", link);

        db.insert("imgtable", null, contentValues);
        return true;
    }

    public Cursor getData(String topic) {
        List array_list=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from imgtable where topic='"+topic+"'", null );
        return res;
//        res.moveToFirst();
//
//        while(res.isAfterLast() == false){
//            array_list.add(res.getString(res.getColumnIndex(ZIKAR_COLUMN_ZIKAR_DATA)));
//            res.moveToNext();
//        }
//        return array_list;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TASBEEH_TABLE_NAME);
        return numRows;
    }

    public boolean updateTASBEEH (Integer id,String topic, String link) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("topic", topic);
        contentValues.put("link", link);
        db.update("imgtable", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("imgtable",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public Cursor getAllZikar() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from imgtable", null );
        return res;
//        res.moveToFirst();
//
//        while(res.isAfterLast() == false){
//            array_list.add(res.getString(res.getColumnIndex(ZIKAR_COLUMN_ZIKAR_DATA)));
//            res.moveToNext();
//        }
//        return array_list;
    }
}
