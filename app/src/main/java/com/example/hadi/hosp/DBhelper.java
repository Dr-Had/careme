package com.example.hadi.hosp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by Hadi on 16/11/2017.
 */

public class DBhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "doclist.db";
    private static final String TABLE = "appolist";

    private static final String KEY_id = "id";
    private static final String KEY_dep = "department";
    private static final String KEY_doct = "doctor";
    private static final String KEY_day = "days";
    private static final String KEY_time = "times";

    public  String depart;
    public  String docto;
    public  String day;
    public  String time;

    SQLiteDatabase db;

    ArrayList<String> departlist = new ArrayList<String>();
    ArrayList<String> doctorlist = new ArrayList<String>();
    ArrayList<String> daylist = new ArrayList<String>();
    ArrayList<String> timelist = new ArrayList<String>();
    ArrayList<String> idlist = new ArrayList<String>();
    String x;

    public  DBhelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create="CREATE TABLE "+TABLE+" ("+KEY_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ KEY_dep+" TEXT,"+KEY_doct+ " TEXT,"+ KEY_day+" TEXT,"+KEY_time+"TEXT)";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+TABLE);
        onCreate(db);

    }

    public long insertdoc(String de, String dc, String da, String ti){
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_dep,de);
        cv.put(KEY_doct,dc);
        cv.put(KEY_day,da);
        cv.put(KEY_time,ti);

        long id=db.insert(TABLE,null,cv);

        return id;
    }

    public ArrayList<String> getDepartlist(){
        db=this.getReadableDatabase();
        String Query = "SELECT "+KEY_dep+" FROM "+TABLE;

        Cursor cursor = db.rawQuery(Query, null);
        if (cursor.moveToFirst()){
            do {
                x=cursor.getString(cursor.getColumnIndex(KEY_dep));
                departlist.add(x);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return departlist;
    }

    public ArrayList<String> getDoctorlist(){
        db=this.getReadableDatabase();
        String Query = "SELECT "+KEY_doct+" FROM "+TABLE;
        Cursor cursor = db.rawQuery(Query,null);

        if (cursor.moveToFirst()){
            do {
                x=cursor.getString(cursor.getColumnIndex(KEY_doct));
                doctorlist.add(x);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return doctorlist;
    }

    public ArrayList<String> getDaylist(){
        db=this.getReadableDatabase();
        String Query = "SELECT "+KEY_day+" FROM "+TABLE;
        Cursor cursor = db.rawQuery(Query,null);

        if (cursor.moveToFirst()){
            do {
                x=cursor.getString(cursor.getColumnIndex(KEY_day));
                daylist.add(x);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return daylist;
    }

    public ArrayList<String> getTimelist(){
        db=this.getReadableDatabase();
        String Query = "SELECT "+KEY_time+" FROM "+TABLE;
        Cursor cursor = db.rawQuery(Query,null);

        if (cursor.moveToFirst()){
            do {
                x=cursor.getString(cursor.getColumnIndex(KEY_time));
                timelist.add(x);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return timelist;
    }

    public ArrayList<String> getIdlist(){
        db=this.getReadableDatabase();
        String Query = "SELECT "+KEY_id+" FROM "+TABLE;
        Cursor cursor = db.rawQuery(Query,null);

        if (cursor.moveToFirst()){
            do {
                x=cursor.getString(cursor.getColumnIndex(KEY_id));
                idlist.add(x);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return idlist;
    }


}
