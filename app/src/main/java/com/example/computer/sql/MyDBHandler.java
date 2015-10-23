package com.example.computer.sql;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "attendance.db";

    //Table Names
    public static final String TABLE_STUDENT = "student";
    public static final String TABLE_SUBJECT = "subject";
    public static final String TABLE_TEACHER = "teacher";
    public static final String TABLE__DEPARTMENT = "department";
    public static final String TABLE_ATTENDANCE = "attendance";

    //Student columns
    public static final String COLUMN_USN = "_usn";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONENO = "phoneno";
    public static final String COLUMN_EMAIL = "email";
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
    public static final String COLUMN_SUBJECTID = "_subjectid";
    public static final String COLUMN_SUBJECTNAME = "subjectname";

    //Teacher columns
    public static final String COLUMMN_TEACHERID = "_teacherid";
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
                "_usn INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "phoneno INTEGER," +
                "emailid TEXT," +
                "semester INTEGER NOT NULL," +
                "branch INTEGER NOT NULL," +
                "section INTEGER NOT NULL," +
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
                "_subjectid TEXT PRIMARY KEY," +
                "semester INTEGER NOT NULL," +
                "subjectname TEXT NOT NULL);";

        String teacherquery = "CREATE TABLE IF NOT EXISTS teacher (" +
                "_teacherid INTEGER PRIMARY KEY," +
                "teachername TEXT NOT NULL," +
                "subjectid TEXT NOT NULL," +
                "branch INTEGER NOT NULL," +
                "foreign key(subjectid) references subject(subjectid)," +
                "foreign key(branch) references department(branch));";

        String departmentquery = "CREATE TABLE IF NOT EXISTS department (" +
                "_branch INTEGER PRIMARY KEY," +
                "hodname TEXT NOT NULL);";

        String attendancequery = "CREATE TABLE IF NOT EXISTS attendance (" +
                "teacherid INTEGER NOT NULL," +
                "semester INTEGER NOT NULL," +
                "subjectid INTEGER NOT NULL," +
                "section TEXT NOT NULL," +
                "total INTEGER NOT NULL," +
                "primary key(semester,section)," +
                "foreign key(teacherid) references teacher(teacherid)," +
                "foreign key(subjectid) references subject(subjectid));";

        db.execSQL(departmentquery);
        db.execSQL(teacherquery);
        db.execSQL(subjectquery);
        db.execSQL(attendancequery);
        db.execSQL(studentquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE__DEPARTMENT);
        onCreate(db);
    }

    public void insertsubject(){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(COLUMN_SUBJECTID, "10CS30");
        cValues.put(COLUMN_SUBJECTNAME, "Flat");
        cValues.put(COLUMN_SEMESTER, 5);
        db.insert(TABLE_SUBJECT, null, cValues);
    }

    //Print Database as String
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_SUBJECT+";";
        String[] columns = {COLUMN_SUBJECTID, COLUMN_SUBJECTNAME,};

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            for (int i = 0; i < columns.length; i++) {
                if (c.getString(c.getColumnIndex(columns[i])) != null) {
                    dbString += c.getString(c.getColumnIndex(columns[i]));
                    dbString += " ";
                }
            }
            dbString += "\n";
            c.moveToNext();
        }
        return dbString;
    }

}
