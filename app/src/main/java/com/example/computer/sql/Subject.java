package com.example.computer.sql;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Subject {
    private int semester;
    private String subjectid, subjectname;

    //Default Constructor
    public Subject() {
    }


    //Constructor
    public Subject(String subjectname, String subjectid, int semester) {
        this.subjectname = subjectname;
        this.subjectid = subjectid;
        this.semester = semester;
    }


    //SETTERS
    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }


    //GETTERS
    public int getSemester() {
        return semester;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    //Insert Data
    public void subjectDataInput (SQLiteDatabase db) {
        ContentValues cValues = new ContentValues();

        cValues.put(MyDBHandler.COLUMN_SUBJECTID, getSubjectid());
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, getSubjectname());
        cValues.put(MyDBHandler.COLUMN_SEMESTER, getSemester());
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);
    }
}
