package com.example.computer.sql;

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


    //ADD A NEW STUDENT
    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        student.studentDataInput(db);
    }

    //ADD A NEW TEACHER
    public void insertTeacher(Teacher teacher) {
        SQLiteDatabase db = this.getWritableDatabase();
        teacher.teacherDataInput(db);
    }

    //ADD A NEW SUBJECT
    public void insertSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        subject.subjectDataInput(db);
    }

    //ADD NEW DEPARTMENT
    public void insertDepartment(Department department) {
        SQLiteDatabase db = this.getWritableDatabase();
        department.departmentDataInput(db);
    }

    //ADD A NEW ATTENDANCE
    public void insertAttendance(Attendance attendance) {
        SQLiteDatabase db = this.getWritableDatabase();
        attendance.attendanceDataInput(db);
    }









    //SELECT ALL ROWS IN A TABLE
    public String selectAll(String tableName) {
        String dbString = "";
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + tableName + ";";

        Cursor c = db.rawQuery(query, null);
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
