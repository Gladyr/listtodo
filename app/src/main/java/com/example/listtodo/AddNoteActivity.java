package com.example.listtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextDeadline;
    private Button buttonSave;

    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
    }
    private void initViews(){
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextDeadline = findViewById(R.id.editTextDateDadline);
        buttonSave = findViewById(R.id.buttonSave);
    }

    private void saveNote(){
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String dateDeadline =" new GregorianCalendar()";
        int id = dataBase.getNotes().size();
        Note note = new Note( id, title, description);
        dataBase.add(note);
        finish();
        //viewModel.saveNote(note);
    }

    public static Intent newIntent(Context context){
        return new Intent (context, AddNoteActivity.class);
    }
}