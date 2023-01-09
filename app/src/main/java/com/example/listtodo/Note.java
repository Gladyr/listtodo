package com.example.listtodo;

public class Note {
    private int id;
    private String title;
    private String description;
    private String dateNow;
    private String dateDeadline;
    private String dateDone;

    public Note(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateNow = "dateNow";
        this.dateDeadline = "dateDeadline";
        this.dateDone = "dateDone";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDateNow() {
        return dateNow;
    }

    public String getDateDeadline() {
        return dateDeadline;
    }

    public String getDateDone() {
        return dateDone;
    }
}
