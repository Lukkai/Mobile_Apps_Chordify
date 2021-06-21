package com.example.chordify;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText textCords;
    Button btnMaps;
    Button btnDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCords = (EditText) findViewById(R.id.songText);

        Bundle myDataBundle = new Bundle();// create a Bundle (MAP) container to ship data
        btnMaps = (Button) findViewById(R.id.searchBtn);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.ultimate-guitar.com/search.php?search_type=title&value=" + textCords.getText().toString();
                // add <key,value> data items to the container
                myDataBundle.putString("song_history", textCords.getText().toString());
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
//            @Override
//            public void onClick(View v) {
//                String query = "https://www.ultimate-guitar.com/search.php?search_type=title&value=" + textCords.getText().toString();
//                // add <key,value> data items to the container
//                myDataBundle.putString("song_history", textCords.getText().toString());
//                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//                intent.putExtra(SearchManager.QUERY, query);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
//            }

        });

        btnDB = (Button) findViewById(R.id.historyBtn);
        btnDB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(MainActivity.this, DBVIew.class);
                    // attach the container to the intent
                myIntent.putExtras(myDataBundle);
                if (myIntent.resolveActivity(getPackageManager()) != null) {
                    // call Activity2, tell your local listener to wait a
                    // response sent to a listener known as 101
                    startActivityForResult(myIntent, 101);
               }
//                myDataBundle.clear();
            }
        });

    }


}


