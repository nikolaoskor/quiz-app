package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class Top10Activity extends AppCompatActivity {
    private ListView listTop10;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);

        listTop10 = findViewById(R.id.listTop10);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listTop10.setAdapter(adapter);

        displayTop10();
    }

    private void displayTop10() {
        QuizDatabaseHelper dbHelper = new QuizDatabaseHelper(this);
        List<String> top10List = dbHelper.getTop10();

        if (!top10List.isEmpty()) {
            adapter.clear();
            adapter.addAll(top10List);
            adapter.notifyDataSetChanged();
        } else {

            TextView txtNoScores = findViewById(R.id.txtNoScores);
            txtNoScores.setVisibility(View.VISIBLE);
            listTop10.setVisibility(View.GONE);
        }
    }

    public void cleanupList(View view) {
        adapter.clear();
        TextView txtNoScores = findViewById(R.id.txtNoScores);
        txtNoScores.setVisibility(View.VISIBLE);
        listTop10.setVisibility(View.GONE);


        QuizDatabaseHelper dbHelper = new QuizDatabaseHelper(this);
        dbHelper.deleteAllScores();
    }


}




