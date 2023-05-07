package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.dbHelper.DbHelper;
import com.example.myapplication.model.User;


public class daatabase extends AppCompatActivity {
    Button addtodatabase,showfromdatabase;
    EditText inputName,inputAddress,inputPhone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daatabase);


        inputName = findViewById(R.id.inputName);
        inputAddress = findViewById(R.id.inputAddress);
        inputPhone = findViewById(R.id.inputPhone);
        addtodatabase = findViewById(R.id.addtodatabase);
        showfromdatabase = findViewById(R.id.showfromdatabase);

        DbHelper db = new DbHelper(daatabase.this);

//adding user in database
        addtodatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = inputName.getText().toString();
                String Address = inputAddress.getText().toString();
                String Phone = inputPhone.getText().toString();

                User add = new User();
                add.setName(Name);
                add.setAddress(Address);
                add.setPhone(Phone);


                db.addUser(add);
                inputName.setText("");
                        inputAddress.setText("");
                inputPhone.setText("");
                Toast.makeText(daatabase.this, "Data Added", Toast.LENGTH_SHORT).show();
            }
        });


//
//        updating data in database
//        hari.setId(12);
//        hari.setName("Ramlaal");
//        db.updateUser(hari);
//        int affectedRows = db.updateUser(hari);
//        Log.d("dbPrashant", "updated: " + affectedRows);

//        deleting data from db
//        db.deleteUserById(11);
//        db.deleteUserByName("prashant");


//        getting all contact

//        Log.d("dbPrashant", "onCreate: "+ userList);

//        using recycler view


        showfromdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(daatabase.this,displayAllUser.class);

                startActivity(i);
            }
        });


//        count
//        Log.d("dbPrashant", "total record: " + db.getCount());







    }
}