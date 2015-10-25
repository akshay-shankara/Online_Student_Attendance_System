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
                        Student student = new Student();
                        student.setUsn("1RN13IS001");
                        String output = dbHandler.studentShortage(student);                //Gets the teachers who takes class for the student
                        textData.setText(output);
                    }
                }
        );

        buttonView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputText = input.getText().toString();
                        Student student = new Student();
                        student.setUsn(inputText);
                        String output = dbHandler.studentGetTotalClasses(student);                  //Gets the subject name it's total classes
                        textData.setText(output);
                    }
                }
        );
    }

}
