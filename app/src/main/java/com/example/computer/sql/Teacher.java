package com.example.computer.sql;


public class Teacher {

    private int teacherid;
    private String teachername, branch;

    //Default Constructor
    public Teacher() {
    }

    //Constructor
    public Teacher(int _teacherid, String teachername, String branch) {
        this.teacherid = _teacherid;
        this.teachername = teachername;
        this.branch = branch;
    }


    //SETTERS
    public void set_teacherid(int _teacherid) {
        this.teacherid = _teacherid;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    //GETTERS
    public int get_teacherid() {
        return teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public String getBranch() {
        return branch;
    }
}
