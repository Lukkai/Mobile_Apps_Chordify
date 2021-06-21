package com.example.chordify;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DBVIew extends MainActivity implements View.OnClickListener {

    public RecyclerView recyclerView;
    FloatingActionButton backButton;
    CustomAdapter customAdapter;

    MusicDB musicDB;
    ArrayList<String> song_id, song_title ,song_author;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_layout);

        recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.floatingBackButton);
        backButton.setOnClickListener((View.OnClickListener) this);
        musicDB = new MusicDB(DBVIew.this);
        song_id = new ArrayList<>();
        song_title = new ArrayList<>();
        song_author = new ArrayList<>();

        displayData();
        customAdapter = new CustomAdapter(DBVIew.this, song_id, song_title, song_author);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DBVIew.this));

    }

    void displayData(){
        Cursor cursor = musicDB.getAllSongs();
        if(cursor.getCount() != 0){
            while(cursor.moveToNext()){
                song_id.add(cursor.getString(0));
                song_title.add(cursor.getString(0));
                song_author.add(cursor.getString(0));
            }

        }
    }
    @Override
    public void onClick(View v) {
        finish();
    }
}
