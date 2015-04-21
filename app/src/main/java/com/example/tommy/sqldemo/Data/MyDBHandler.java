package com.example.tommy.sqldemo.Data;

/**
 * Created by Tommy on 20/03/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "waxLogger.db";
    private static final String TABLE_KICKWAX = "kickwax";
    private static final String TABLE_GLIDEWAX = "glidewax";
    //Kickwax Table
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCER = "producer";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_COMMENT = "comment";

    public MyDBHandler(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_KICKWAX = "CREATE TABLE " + TABLE_KICKWAX  + "("
                + COLUMN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + COLUMN_PRODUCER + " STRING, "
                + COLUMN_NAME + " STRING, "
                + COLUMN_TYPE + " STRING, "
                + COLUMN_COMMENT + " STRING )";
        db.execSQL(CREATE_TABLE_KICKWAX);

        String CREATE_TABLE_GLIDEWAX = "CREATE TABLE " + TABLE_GLIDEWAX  + "("
                + COLUMN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + COLUMN_PRODUCER + " STRING, "
                + COLUMN_NAME + " STRING, "
                + COLUMN_TYPE + " STRING, "
                + COLUMN_COMMENT + " STRING )";
        db.execSQL(CREATE_TABLE_GLIDEWAX);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {

    }
    public void AddWax(KickWax kickWax){
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCER, kickWax.getProducer()); // get latitude
        values.put(COLUMN_NAME, kickWax.getName()); // get latitude
        values.put(COLUMN_TYPE, kickWax.getType()); // get latitude
        values.put(COLUMN_COMMENT, kickWax.getComment()); // get latitude


        // 3. insert
        db.insert(TABLE_KICKWAX, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();

    }
    public ArrayList<KickWax> getAllWaxes(){
        String query = "SELECT  * FROM " + TABLE_KICKWAX;
        ArrayList<KickWax> waxes = new ArrayList<KickWax>();
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        KickWax kickWax = null;
        if (cursor.moveToFirst()) {
            do {
                kickWax = new KickWax();
                kickWax.setID(Integer.parseInt(cursor.getString(0)));
                kickWax.setProducer(cursor.getString(1));
                kickWax.setName(cursor.getString(2));
                kickWax.setType(cursor.getString(3));
                kickWax.setComment(cursor.getString(4));


                // Add book to books
                waxes.add(kickWax);
            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", waxes.toString());

        // return books
        return waxes;

    }

    public void AddGlide(GlideWax glideWax){
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCER, glideWax.getProducer()); // get latitude
        values.put(COLUMN_NAME, glideWax.getName()); // get latitude
        values.put(COLUMN_TYPE, glideWax.getType()); // get latitude
        values.put(COLUMN_COMMENT, glideWax.getComment()); // get latitude


        // 3. insert
        db.insert(TABLE_GLIDEWAX, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();

    }
    public ArrayList<GlideWax> getAllGlides(){
        String query = "SELECT  * FROM " + TABLE_KICKWAX;
        ArrayList<GlideWax> waxes = new ArrayList<GlideWax>();
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        GlideWax glideWax = null;
        if (cursor.moveToFirst()) {
            do {
                glideWax = new GlideWax();
                glideWax.setID(Integer.parseInt(cursor.getString(0)));
                glideWax.setProducer(cursor.getString(1));
                glideWax.setName(cursor.getString(2));
                glideWax.setType(cursor.getString(3));
                glideWax.setComment(cursor.getString(4));


                // Add book to books
                waxes.add(glideWax);
            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", waxes.toString());

        // return books
        return waxes;

    }

    //public void ListAllWaxes()
    //public void UpdateWax()


}

