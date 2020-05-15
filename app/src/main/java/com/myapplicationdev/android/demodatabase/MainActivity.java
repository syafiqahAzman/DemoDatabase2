package com.myapplicationdev.android.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    TaskAdapter ta;
    ArrayList<Task> al;
    Button btnInsert, btnGetTasks;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tv = findViewById(R.id.tvResults);
        lv = findViewById(R.id.lv);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create DBHelper object, passing in the activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert task
                db.insertTask("Submit RJ", "25 Apr 2019");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create the DBHelper object passing in the
                // activity's context
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for(int i = 0; i < data.size(); i++){
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }

                tv.setText(txt);

                DBHelper db2 = new DBHelper(MainActivity.this);
                al = db2.getTasks();
                db2.close();

                ta = new TaskAdapter(MainActivity.this, R.layout.row, al);
                lv.setAdapter(ta);
            }
        });


    }
}
