package com.example.computer.sql;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Student {

    private String usn, name, branch, section, sub1, sub2, sub3, sub4, sub5, sub6, phoneno, emailid;
    private int semester;

    //Default Constructor
    public Student() {
    }

    //Constructor


    public Student(String usn, String name, String branch, String section, String sub1, String sub2, String sub3, String sub4, String sub5, String sub6, String phoneno, String email, int semester) {
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.section = section;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.phoneno = phoneno;
        this.emailid = email;
        this.semester = semester;
    }

    //GETTERS
    public String getEmailid() {
        return emailid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getUsn() {
        return usn;
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
    public void setUsn(String usn) {
        this.usn = usn;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setEmail(String email) {
        this.emailid = email;
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

    //Insert Data
    public void studentDataInput (SQLiteDatabase db) {
        ContentValues cValues = new ContentValues();

        cValues.put(MyDBHandler.COLUMN_USN, getUsn());
        cValues.put(MyDBHandler.COLUMN_NAME, getName());
        cValues.put(MyDBHandler.COLUMN_PHONENO, getPhoneno());
        cValues.put(MyDBHandler.COLUMN_EMAILID, getEmailid());
        cValues.put(MyDBHandler.COLUMN_SEMESTER, getSemester());
        cValues.put(MyDBHandler.COLUMN_BRANCH, getBranch());
        cValues.put(MyDBHandler.COLUMN_SECTION, getSection());
        cValues.put(MyDBHandler.COLUMN_SUB1, getSub1());
        cValues.put(MyDBHandler.COLUMN_SUB2, getSub2());
        cValues.put(MyDBHandler.COLUMN_SUB3, getSub3());
        cValues.put(MyDBHandler.COLUMN_SUB4, getSub4());
        cValues.put(MyDBHandler.COLUMN_SUB5, getSub5());
        cValues.put(MyDBHandler.COLUMN_SUB6, getSub6());
        db.insert(MyDBHandler.TABLE_STUDENT, null, cValues);
    }
}
