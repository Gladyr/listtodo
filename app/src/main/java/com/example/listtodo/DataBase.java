package com.example.listtodo;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Note> notes = new ArrayList<>();

    private static DataBase instance = null;

    public static DataBase getInstance(){
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public DataBase() {
        for (int i=0; i<20; i++){
            Note note = new Note(i, "Note "+i, "description"+i);
            notes.add(note);
        }
    }

    public void add(Note note){
        notes.add(note);
    }
    public void remove(int id){
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(id);
            if (note.getId()==id){
                notes.remove(note);
            }
        }
    }

    public ArrayList<Note> getNotes(){
        return new ArrayList<>(notes);
    }
}
