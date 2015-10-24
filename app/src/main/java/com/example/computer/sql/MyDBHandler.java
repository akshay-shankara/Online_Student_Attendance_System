package com.example.computer.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "attendance.db";

    //Table Names
    public static final String TABLE_STUDENT = "student";
    public static final String TABLE_SUBJECT = "subject";
    public static final String TABLE_TEACHER = "teacher";
    public static final String TABLE_DEPARTMENT = "department";
    public static final String TABLE_ATTENDANCE = "attendance";

    //Student columns
    public static final String COLUMN_USN = "usn";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONENO = "phoneno";
    public static final String COLUMN_EMAILID = "emailid";
    public static final String COLUMN_SECTION = "section";
    public static final String COLUMN_BRANCH = "branch";
    public static final String COLUMN_SEMESTER = "semester";
    public static final String COLUMN_SUB1 = "sub1";
    public static final String COLUMN_SUB2 = "sub2";
    public static final String COLUMN_SUB3 = "sub3";
    public static final String COLUMN_SUB4 = "sub4";
    public static final String COLUMN_SUB5 = "sub5";
    public static final String COLUMN_SUB6 = "sub6";

    //Subject columns
    public static final String COLUMN_SUBJECTID = "subjectid";
    public static final String COLUMN_SUBJECTNAME = "subjectname";

    //Teacher columns
    public static final String COLUMN_TEACHERID = "teacherid";
    public static final String COLUMN_TEACHERNAME = "teachername";

    //Department Columns
    public static final String COLUMN_HODNAME = "hodname";

    //Attendance Columns
    public static final String COLUMN_TOTAL = "total";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String studentquery = "CREATE TABLE IF NOT EXISTS student (" +
                "usn TEXT PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "phoneno TEXT," +
                "emailid TEXT," +
                "semester INTEGER NOT NULL," +
                "branch TEXT NOT NULL," +
                "section TEXT NOT NULL," +
                "sub1 INTEGER NOT NULL," +
                "sub2 INTEGER NOT NULL," +
                "sub3 INTEGER NOT NULL," +
                "sub4 INTEGER NOT NULL," +
                "sub5 INTEGER NOT NULL," +
                "sub6 INTEGER NOT NULL," +
                "foreign key(branch) references department(branch)," +
                "foreign key(section) references attendance(section)," +
                "foreign key(semester) references attendance(semester));";

        String subjectquery = "CREATE TABLE IF NOT EXISTS subject (" +
                "subjectid TEXT PRIMARY KEY," +
                "semester INTEGER NOT NULL," +
                "subjectname TEXT NOT NULL);";

        String teacherquery = "CREATE TABLE IF NOT EXISTS teacher (" +
                "teacherid INTEGER PRIMARY KEY," +
                "teachername TEXT NOT NULL," +
                "branch TEXT NOT NULL," +
                "foreign key(branch) references department(branch));";

        String departmentquery = "CREATE TABLE IF NOT EXISTS department (" +
                "branch TEXT PRIMARY KEY," +
                "hodname TEXT NOT NULL);";

        String attendancequery = "CREATE TABLE IF NOT EXISTS attendance (" +
                "teacherid INTEGER NOT NULL," +
                "semester INTEGER NOT NULL," +
                "subjectid INTEGER NOT NULL," +
                "section TEXT NOT NULL," +
                "total INTEGER NOT NULL," +
                "foreign key(teacherid) references teacher(teacherid)," +
                "foreign key(subjectid) references subject(subjectid));";

        db.execSQL(departmentquery);
        db.execSQL(teacherquery);
        db.execSQL(subjectquery);
        db.execSQL(attendancequery);
        db.execSQL(studentquery);

        //INSERT DATA
        InsertData ins = new InsertData();
        ins.insert(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENT);
        onCreate(db);
    }


    //BEGIN QUERIES


    //TO ADD A NEW STUDENT FROM USER
    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        student.studentDataInput(db);
    }

    //TO ADD A NEW TEACHER FROM USER
    public void insertTeacher(Teacher teacher) {
        SQLiteDatabase db = this.getWritableDatabase();
        teacher.teacherDataInput(db);
    }

    //TO ADD A NEW SUBJECT FROM USER
    public void insertSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        subject.subjectDataInput(db);
    }

    //TO ADD NEW DEPARTMENT FROM USER
    public void insertDepartment(Department department) {
        SQLiteDatabase db = this.getWritableDatabase();
        department.departmentDataInput(db);
    }

    //TO ADD A NEW ATTENDANCE FROM USER
    public void insertAttendance(Attendance attendance) {
        SQLiteDatabase db = this.getWritableDatabase();
        attendance.attendanceDataInput(db);
    }


    //**************************** STUDENT SECTION ****************************

    //View a particular student's details
    public String studentDetails(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_STUDENT +
                " WHERE usn = " + "\"" + student.getUsn() + "\" " +
                "order by usn;";

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //View Subjects with shortage (YET TO COMPLETE!!!)                                              INCOMPLETE!!!
    public String studentShortage(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT";                        //Complete the query

        /*      ### INSERT CODE HERE ###        */

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //Update contact details
    public String studentUpdate(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();

        cValues.put(COLUMN_EMAILID, student.getEmailid());
        cValues.put(COLUMN_PHONENO, student.getPhoneno());

        String where = "usn = " + "\"" + student.getUsn() + "\"";
        int check = db.update(TABLE_SUBJECT, cValues, where, null);

        //db.update RETURNS THE NUMBER OF COLUMNS UPDATED
        if (check == 1)
            return "UPDATE SUCCESSFUL";
        else
            return "UNSUCCESSFUL";
    }

    //Get teacher and subject details of ONE STUDENT
    public String studentGetTeacherDetails(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT su.subjectname,t.teachername FROM student s,subject su,teacher t,attendance at " +
                "WHERE s.usn = " + "\"" + student.getUsn() + "\"" + " and " +
                "s.semester = at.semester and " +
                "s.section = at.section and " +
                "at.subjectid = su.subjectid and " +
                "at.teacherid = t.teacherid;";

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //Get the subject names and the total number of classes conducted in it
    public String studentGetTotalClasses(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT su.subjectname,at.total FROM student s,attendance at,subject su " +
                "WHERE s.usn = " + "\"" + student.getUsn() + "\"" + " and " +
                "s.semester = at.semester and " +
                "s.section = at.section and " +
                "at.subjectid = su.subjectid;";

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }


    //**************************** TEACHER SECTION ****************************


    //Check the attendance of a class the teacher takes (YET TO COMPLETE!!!)                        INCOMPLETE!!!
    public String teacherGetAttendance(Teacher teacher) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT";                        //Complete the query

        /*      ### INSERT CODE HERE ###        */

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //TAKE ATTENDANCE (YET TO COMPLETE)                                                             INCOMPLETE!!!
    public String teacherTakeAttendance(Teacher teacher) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT";                        //Complete the query

        /*      ### INSERT CODE HERE ###        */

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //View students with shortage (YET TO COMPLETE!!!)                                              INCOMPLETE!!!
    public String teacherShortage(Teacher teacher) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT";                        //Complete the query

        /*      ### INSERT CODE HERE ###        */

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //REMOVE SHORTAGE of a particular student (YET TO COMPLETE!!!)                                  INCOMPLETE!!!
    public String teacherRemoveShortage(Teacher teacher, Student student) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "UPDATE";                        //Complete the query

        /*      ### INSERT CODE HERE ###        */

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }


    //**************************** HOD SECTION ****************************

    //Get the ATTENDANCE OF A CLASS in a branch
    public String hodGetAttendance(Department department) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT s.usn,s.name,s.semester,s.section,s.sub1,s.sub2,s.sub3,s.sub4,s.sub5,s.sub6 FROM student s,department d " +
                "WHERE s.branch = d.branch " +
                "d.branch = " + "\"" + department.getBranch() + "\" and " +
                "order by s.section;";

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //Get STUDENT CONTACT DETAILS
    public String hodGetContact(Department department, Student student) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT s.phoneno,s.emailid FROM student s,department d " +
                "WHERE s.usn = " + "\"" + student.getUsn() + "\" and " +
                "s.branch = d.branch and " +
                "d.branch = " + "\"" + department.getBranch() + "\";";
        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }

    //Get the DETAILS OF STUDENTS who have shortage (YET TO COMPLETE!!!)                            INCOMPLETE!!!
    public String hodGetShortage(Department department) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT";                        //Complete the query

        /*      ### INSERT CODE HERE ###        */

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }


    //SELECT ALL ROWS IN A TABLE
    public String selectAll(String tableName) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + tableName + ";";

        Cursor c = db.rawQuery(query, null);
        return databaseToString(c);
    }


    //To convert a TABLE acquired from a QUERY into a STRING
    public String databaseToString(Cursor c) {
        String dbString = "";

        c.moveToFirst();
        String[] columns = c.getColumnNames();
        while (!c.isAfterLast()) {
            for (int i = 0; i < c.getColumnCount(); i++) {
                if (c.getString(c.getColumnIndex(columns[i])) != null) {
                    dbString += c.getString(c.getColumnIndex(columns[i]));
                    dbString += " ";
                }
            }
            dbString += "\n";
            c.moveToNext();
        }
        c.close();
        return dbString;
    }

}
