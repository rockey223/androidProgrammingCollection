package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.myapplication.databaseAdapter.DbAdapter;
import com.example.myapplication.dbHelper.DbHelper;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class displayAllUser extends AppCompatActivity {




    private RecyclerView databaseList;
    private com.example.myapplication.databaseAdapter.DbAdapter DbAdapter;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<User> userArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_user);


        databaseList = findViewById(R.id.databaseList);
        databaseList.setHasFixedSize(true);
        databaseList.setLayoutManager(new LinearLayoutManager(this));



        userArrayList = new ArrayList<>();

    DbHelper db = new DbHelper(displayAllUser.this);
        List<User> userList = db.getAllUser();
        for(User user: userList){

            Log.d("dbPrashant", "id: " + user.getId() +
                    "name: " + user.getName());
            userArrayList.add(user);

        }

        DbAdapter adapter = new DbAdapter(displayAllUser.this,userList);

        databaseList.setAdapter(adapter);


    }
}