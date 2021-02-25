package com.example.footballinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<MatchInfo> list = databaseHelper.selectAll();
        MatchesAdapter adapter = new MatchesAdapter();
        adapter.setList(list);
        //ListView listView = new ListView(R.id.);




        //        MatchInfo matchInfo = new MatchInfo(1,"Liverpool",
//                "Leicester",4,1);
//        databaseHelper.insert(matchInfo);
//        ArrayList<MatchInfo> list = databaseHelper.selectAll();
//        Log.d("","");
    }
}