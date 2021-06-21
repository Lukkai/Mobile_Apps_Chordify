package com.example.chordify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{


    ArrayList song_id, song_title, song_author;
    Context context;
    CustomAdapter(Context context, ArrayList song_id, ArrayList song_title, ArrayList song_author){
        this.context = context;
        this.song_id = song_id;
        this.song_title = song_title;
        this.song_author = song_author;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.song_idText.setText(String.valueOf(song_id.get(position)));
        holder.song_titleText.setText(String.valueOf(song_title.get(position)));
        holder.song_authorText.setText(String.valueOf(song_author.get(position)));
    }

    @Override
    public int getItemCount() {
        return song_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView song_idText, song_titleText, song_authorText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            song_idText = itemView.findViewById(R.id.song_idText);
            song_titleText = itemView.findViewById(R.id.song_titleText);
            song_authorText = itemView.findViewById(R.id.song_authorText);
        }
    }
}
