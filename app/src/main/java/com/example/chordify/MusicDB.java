package com.example.chordify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class MusicDB extends SQLiteOpenHelper {
    public static final String DATA_BASE_NAME = "MusicDatabase.db";
    public static final int DATA_BASE_VERSION = 1;
    private Context context;

    public static final String TABLE_NAME = "songs";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "song_title";
    public static final String COLUMN_AUTHOR = "song_author";
    public static final String COLUMN_TEXT = "song_text";
    public static final String COLUMN_CHORDS = "song_chords";

    public MusicDB(@Nullable Context context){
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_TITLE + " TEXT, " + COLUMN_AUTHOR + " TEXT, " + COLUMN_TEXT + " TEXT, " + COLUMN_CHORDS + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addSong(String title, String author, String text, String chords){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_TEXT, text);
        cv.put(COLUMN_CHORDS, chords);
       long result = db.insert(TABLE_NAME, null, cv);
    }

    Cursor getAllSongs() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
           cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
