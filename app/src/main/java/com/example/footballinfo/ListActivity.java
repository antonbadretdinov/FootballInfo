package com.example.footballinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<MatchInfo> list = databaseHelper.selectAll();

        MatchesAdapter adapter = new MatchesAdapter();
        adapter.setList(list);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);


        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
