package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class recycler_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Jhon","jhon@gmail.com",R.drawable.a));
        items.add(new Item("None","jhon@gmail.com",R.drawable.b));
        items.add(new Item("Mone","jhon@gmail.com",R.drawable.c));
        items.add(new Item("Vone","jhon@gmail.com",R.drawable.d));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.e));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.a));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.e));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.d));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.e));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.b));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.e));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.c));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.e));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.d));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.c));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.e));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.b));
        items.add(new Item("Done","jhon@gmail.com",R.drawable.a));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }


}