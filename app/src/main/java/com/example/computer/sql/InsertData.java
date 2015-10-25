package com.example.computer.sql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class InsertData {

    public void insert(SQLiteDatabase db) {
        ContentValues cValues = new ContentValues();

        //DEPARTMENT TABLE
        cValues.put(MyDBHandler.COLUMN_BRANCH, "Computer Science");
        cValues.put(MyDBHandler.COLUMN_HODNAME, "Dr. G.T Raju");
        db.insert(MyDBHandler.TABLE_DEPARTMENT, null, cValues);

        cValues.put(MyDBHandler.COLUMN_BRANCH, "Information Science");
        cValues.put(MyDBHandler.COLUMN_HODNAME, "Dr. M.V Sudamani");
        db.insert(MyDBHandler.TABLE_DEPARTMENT, null, cValues);

        cValues.put(MyDBHandler.COLUMN_BRANCH, "Electronics & Communications");
        cValues.put(MyDBHandler.COLUMN_HODNAME, "Dr. Vipula Singh");
        db.insert(MyDBHandler.TABLE_DEPARTMENT, null, cValues);

        cValues.put(MyDBHandler.COLUMN_BRANCH, "Electrical & Electronics");
        cValues.put(MyDBHandler.COLUMN_HODNAME, "Dr. Sumathi S");
        db.insert(MyDBHandler.TABLE_DEPARTMENT, null, cValues);


        //TEACHER TABLE
        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 1);
        cValues.put(MyDBHandler.COLUMN_TEACHERNAME, "Leelavathi");
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        db.insert(MyDBHandler.TABLE_TEACHER, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 2);
        cValues.put(MyDBHandler.COLUMN_TEACHERNAME, "Navya");
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        db.insert(MyDBHandler.TABLE_TEACHER, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 3);
        cValues.put(MyDBHandler.COLUMN_TEACHERNAME, "Prakash");
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        db.insert(MyDBHandler.TABLE_TEACHER, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 4);
        cValues.put(MyDBHandler.COLUMN_TEACHERNAME, "Girijamma H.A");
        cValues.put(MyDBHandler.COLUMN_BRANCH, "CS");
        db.insert(MyDBHandler.TABLE_TEACHER, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 5);
        cValues.put(MyDBHandler.COLUMN_TEACHERNAME, "H.R Shashidhar");
        cValues.put(MyDBHandler.COLUMN_BRANCH, "CS");
        db.insert(MyDBHandler.TABLE_TEACHER, null, cValues);


        //SUBJECT TABLE
        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS51");
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, "Software Engineering");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS52");
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, "System Software");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS53");
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, "Operating Systems");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS54");
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, "DBMS");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS55");
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, "Computer Networks-1");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS56");
        cValues.put(MyDBHandler.COLUMN_SUBJECTNAME, "FLAT");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        db.insert(MyDBHandler.TABLE_SUBJECT, null, cValues);

        cValues.clear();


        //ATTENDANCE TABLE
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 1);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS51");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 50);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 3);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS52");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 50);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 3);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS53");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 50);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 2);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS54");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 50);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 1);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS55");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 50);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 1);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS56");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 50);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 1);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS55");
        cValues.put(MyDBHandler.COLUMN_SECTION, "B");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 38);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 3);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS51");
        cValues.put(MyDBHandler.COLUMN_SECTION, "B");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 39);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_TEACHERID, 3);
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_SUBJECTID, "10CS53");
        cValues.put(MyDBHandler.COLUMN_SECTION, "B");
        cValues.put(MyDBHandler.COLUMN_TOTAL, 32);
        db.insert(MyDBHandler.TABLE_ATTENDANCE, null, cValues);

        cValues.clear();


        //STUDENT TABLE
        cValues.put(MyDBHandler.COLUMN_USN, "1RN13IS001");
        cValues.put(MyDBHandler.COLUMN_NAME, "Abhay");
        cValues.put(MyDBHandler.COLUMN_PHONENO, "9900123456");
        cValues.put(MyDBHandler.COLUMN_EMAILID, "abhay@gmail.com");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_SUB1, 46);
        cValues.put(MyDBHandler.COLUMN_SUB2, 43);
        cValues.put(MyDBHandler.COLUMN_SUB3, 38);
        cValues.put(MyDBHandler.COLUMN_SUB4, 20);
        cValues.put(MyDBHandler.COLUMN_SUB5, 41);
        cValues.put(MyDBHandler.COLUMN_SUB6, 41);
        db.insert(MyDBHandler.TABLE_STUDENT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_USN, "1RN13IS062");
        cValues.put(MyDBHandler.COLUMN_NAME, "Rakshith");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        cValues.put(MyDBHandler.COLUMN_SECTION, "B");
        cValues.put(MyDBHandler.COLUMN_SUB1, 19);
        cValues.put(MyDBHandler.COLUMN_SUB2, 23);
        cValues.put(MyDBHandler.COLUMN_SUB3, 25);
        cValues.put(MyDBHandler.COLUMN_SUB4, 28);
        cValues.put(MyDBHandler.COLUMN_SUB5, 15);
        cValues.put(MyDBHandler.COLUMN_SUB6, 20);
        db.insert(MyDBHandler.TABLE_STUDENT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_USN, "1RN13IS003");
        cValues.put(MyDBHandler.COLUMN_NAME, "Abhijeet");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        cValues.put(MyDBHandler.COLUMN_SECTION, "A");
        cValues.put(MyDBHandler.COLUMN_SUB1, 14);
        cValues.put(MyDBHandler.COLUMN_SUB2, 11);
        cValues.put(MyDBHandler.COLUMN_SUB3, 17);
        cValues.put(MyDBHandler.COLUMN_SUB4, 22);
        cValues.put(MyDBHandler.COLUMN_SUB5, 29);
        cValues.put(MyDBHandler.COLUMN_SUB6, 15);
        db.insert(MyDBHandler.TABLE_STUDENT, null, cValues);

        cValues.clear();
        cValues.put(MyDBHandler.COLUMN_USN, "1RN13IS090");
        cValues.put(MyDBHandler.COLUMN_NAME, "Vignesh");
        cValues.put(MyDBHandler.COLUMN_SEMESTER, 5);
        cValues.put(MyDBHandler.COLUMN_BRANCH, "IS");
        cValues.put(MyDBHandler.COLUMN_SECTION, "B");
        cValues.put(MyDBHandler.COLUMN_SUB1, 21);
        cValues.put(MyDBHandler.COLUMN_SUB2, 25);
        cValues.put(MyDBHandler.COLUMN_SUB3, 14);
        cValues.put(MyDBHandler.COLUMN_SUB4, 30);
        cValues.put(MyDBHandler.COLUMN_SUB5, 10);
        cValues.put(MyDBHandler.COLUMN_SUB6, 31);
        db.insert(MyDBHandler.TABLE_STUDENT, null, cValues);
    }
}
