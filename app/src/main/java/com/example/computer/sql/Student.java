package com.example.computer.sql;


public class Student {

    private String _usn,name,branch,section,sub1,sub2,sub3,sub4,sub5,sub6;
    private int semester;

    //Default Constructor
    public Student(){}

    //Constructor
    public Student(String _usn, String name, String branch, String section, String sub1, String sub2, String sub4, String sub3, String sub6, String sub5, int semester) {
        this._usn = _usn;
        this.name = name;
        this.branch = branch;
        this.section = section;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub4 = sub4;
        this.sub3 = sub3;
        this.sub6 = sub6;
        this.sub5 = sub5;
        this.semester = semester;
    }


    //GETTERS
    public String get_usn() {
        return _usn;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getSection() {
        return section;
    }

    public String getSub1() {
        return sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public String getSub3() {
        return sub3;
    }

    public String getSub4() {
        return sub4;
    }

    public String getSub5() {
        return sub5;
    }

    public String getSub6() {
        return sub6;
    }

    public int getSemester() {
        return semester;
    }


    //SETTERS
    public void set_usn(String _usn) {
        this._usn = _usn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public void setSub3(String sub3) {
        this.sub3 = sub3;
    }

    public void setSub4(String sub4) {
        this.sub4 = sub4;
    }

    public void setSub5(String sub5) {
        this.sub5 = sub5;
    }

    public void setSub6(String sub6) {
        this.sub6 = sub6;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
