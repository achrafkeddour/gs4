package com.example.livre_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    BaseSQLite db = new BaseSQLite(this);
    LivreOperations lvo = new LivreOperations(db);

    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list = (ListView) findViewById(R.id.listView);
        showData();
    }
    public void showData()
    {
        ArrayList<String> listData = lvo.getAllInformations();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);
        list.setAdapter(arrayAdapter);
    }
}
