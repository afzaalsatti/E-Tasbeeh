package com.example.rooted.e_tasbeeh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tasbeeh.db";
    public static final String TASBEEH_TABLE_NAME = "zikar";
    public static final String ZIKAR_COLUMN_ID = "id";
    public static final String ZIKAR_COLUMN_days = "days";
    public static final String ZIKAR_COLUMN_ZIKAR_DATA = "zikar_data";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table zikar " +
                        "(id integer  , days text ,zikar_data text primary key)"
        );

//                db.execSQL(
//                "create table zikar " +
//                        "(id integer  , days text ,zikar_data text, PRIMARY KEY(days,zikar_data ))"


//        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS zikar");
        onCreate(db);
    }

    public boolean insertZikar (String day, String zikar_data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("days", day);
        contentValues.put("zikar_data", zikar_data);
        db.insert("zikar", null, contentValues);
        return true;
    }

    public List getData(String day) {
        List array_list=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from zikar where days='"+day+"'", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(ZIKAR_COLUMN_ZIKAR_DATA)));
            res.moveToNext();
        }
        return array_list;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TASBEEH_TABLE_NAME);
        return numRows;
    }

    public boolean updateTASBEEH (Integer id, String day, String zikar_data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("days", day);
        contentValues.put("zikar_data", zikar_data);
        db.update("zikar", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("zikar",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllZikar() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from zikar", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(ZIKAR_COLUMN_ZIKAR_DATA)));
            res.moveToNext();
        }
        return array_list;
    }
}