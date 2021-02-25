package com.example.footballinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button save = findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                MatchInfo matchInfo = new MatchInfo(1,"Liverpool","Leicester",5,1);
                databaseHelper.insert(matchInfo);
                finish();
            }
        });

        



        //        MatchInfo matchInfo = new MatchInfo(1,"Liverpool",
//                "Leicester",4,1);
//        databaseHelper.insert(matchInfo);
//        ArrayList<MatchInfo> list = databaseHelper.selectAll();
//        Log.d("","");
    }
}