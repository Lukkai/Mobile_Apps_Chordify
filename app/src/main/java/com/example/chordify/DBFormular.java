package com.example.chordify;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DBFormular extends MainActivity implements View.OnClickListener {

    public EditText editTextTitle;
    public EditText editTextAuthor;
    public EditText editTextText;
    public EditText editTextChords;
    public Button addBtn;
    public Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formular_layout);

        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextChords = findViewById(R.id.editTextChords);
        editTextText = findViewById(R.id.editTextText);
        editTextTitle = findViewById(R.id.editTextTitle);
        backBtn = findViewById(R.id.buttonBack);
        backBtn.setOnClickListener((View.OnClickListener) this);

        addBtn = findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicDB musicDB = new MusicDB(DBFormular.this);
                musicDB.addSong(editTextTitle.getText().toString().trim(), editTextAuthor.getText().toString().trim(), editTextText.toString().trim(), editTextChords.toString().trim());
            }
        });
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}   
