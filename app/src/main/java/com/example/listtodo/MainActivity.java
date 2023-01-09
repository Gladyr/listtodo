package com.example.listtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayoutNotes;
    private FloatingActionButton buttonAdNote;

    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        buttonAdNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }

    private void initViews(){
        linearLayoutNotes=findViewById(R.id.linearLayoutNotes);
        buttonAdNote = findViewById(R.id.buttonAdNote);
    }

    private void showNotes(){
        linearLayoutNotes.removeAllViews();
        for (Note note: dataBase.getNotes()
             ) {
            View view = getLayoutInflater().inflate(R.layout.note_item, linearLayoutNotes,
                    false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dataBase.remove(note.getId());
                    showNotes();
                }
            });
            TextView textViewNote = view.findViewById(R.id.textViewNote);
            textViewNote.setText(note.getTitle());
            linearLayoutNotes.addView(view);
        }

    }
}