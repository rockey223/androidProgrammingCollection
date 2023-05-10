package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview extends AppCompatActivity {
    ListView listcontain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview3);

        listcontain=findViewById(R.id.listcontain);
        String names[] = {"Ram","Shyam","Hari","Krishna","SIta","Gita"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listviewlayout,R.id.listcontain,names);
        listcontain.setAdapter(adapter);


    }
}