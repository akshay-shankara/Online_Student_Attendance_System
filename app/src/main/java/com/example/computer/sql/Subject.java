package com.example.computer.sql;


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
}
