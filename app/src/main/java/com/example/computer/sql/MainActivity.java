package com.example.computer.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    Button buttonIns, buttonView;
    TextView textData;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new MyDBHandler(this, null, null, 1);

        input = (EditText) findViewById(R.id.editText);
        textData = (TextView) findViewById(R.id.textData);
        buttonIns = (Button) findViewById(R.id.buttonIns);
        buttonView = (Button) findViewById(R.id.buttonView);

        buttonIns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputText = input.getText().toString();

                        Department department = new Department();

                        department.setBranch("IS");
                        String output = dbHandler.hodShortage(department);
                        textData.setText(output);
                    }
                }
        );

        buttonView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputText = input.getText().toString();
                        Teacher teacher = new Teacher();
                        Student student = new Student();
                        teacher.setTeacherid(4);
                        student.setUsn("1RN13IS001");
                        int a = dbHandler.teacherRemoveShortage(teacher,student,30);
                        String output = dbHandler.studentDetails(student);
                        textData.setText(output);
                    }
                }
        );
    }

}
