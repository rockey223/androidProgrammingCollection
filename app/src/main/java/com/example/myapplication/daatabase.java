package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.dbHelper.DbHelper;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class daatabase extends AppCompatActivity {
Button addtodatabase,showfromdatabase;
    ListView databasecontainer;

    ArrayList<String> _name = new ArrayList<>();
    ArrayList<String> _id = new ArrayList<>();
    ArrayList<String> _address = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daatabase);

        addtodatabase = findViewById(R.id.addtodatabase);
        showfromdatabase = findViewById(R.id.showfromdatabase);

        DbHelper db = new DbHelper(daatabase.this);

//adding user in database
        User hari = new User();
        hari.setName("prashant");
        hari.setAddress("sunakothi");
        hari.setPhone("9864221478");

        db.addUser(hari);
        Log.d("dbPrashant", "onCreate: " + hari.getId());

//        updating data in database
        hari.setId(12);
        hari.setName("Ramlaal");
        db.updateUser(hari);
        int affectedRows = db.updateUser(hari);
        Log.d("dbPrashant", "updated: " + affectedRows);

//        deleting data from db
//        db.deleteUserById(11);
//        db.deleteUserByName("prashant");


//        getting all contact
        List<User> allUser = db.getAllUser();
        for(User user:allUser){

            Log.d("dbPrashant", "id: " + user.getId() +
                    "name: " + user.getName());

        }


//        count
        Log.d("dbPrashant", "total record: " + db.getCount());






    }
}