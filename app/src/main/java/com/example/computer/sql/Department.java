package com.example.computer.sql;


public class Department {

    private String branch, hodname;

    //Default Constructor
    public Department() {
    }


    //Constructor
    public Department(String branch, String hodname) {
        this.branch = branch;
        this.hodname = hodname;
    }


    //SETTERS
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setHodname(String hodname) {
        this.hodname = hodname;
    }


    //GETTERS
    public String getBranch() {
        return branch;
    }

    public String getHodname() {
        return hodname;
    }
}
