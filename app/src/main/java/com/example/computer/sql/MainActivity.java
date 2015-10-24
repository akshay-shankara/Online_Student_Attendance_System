package com.example.computer.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    Button buttonIns, buttonView;
    TextView textData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new MyDBHandler(this, null, null, 1);

        textData = (TextView) findViewById(R.id.textData);
        buttonIns = (Button) findViewById(R.id.buttonIns);
        buttonView = (Button) findViewById(R.id.buttonView);

        buttonIns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Row Added", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        buttonView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String dbString = dbHandler.selectAll(MyDBHandler.TABLE_STUDENT);
                        textData.setText(dbString);
                    }
                }
        );
    }

}
