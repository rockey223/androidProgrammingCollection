package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity {
Button secondPagebtn,Add,subtract;
TextView secondPageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        secondPagebtn= findViewById(R.id.secondPagebtn);
        secondPageText = findViewById(R.id.secondPageText);
        Add = findViewById(R.id.Add);
        subtract = findViewById(R.id.subtract);
//        To return to first Page
        secondPagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondPage.this,MainActivity.class);
                startActivity(i);
            }
        });
//        to get data from frist page
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        secondPageText.setText("Welcome: " + name);

//        load add fragment
       Add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               FragmentManager manager = getSupportFragmentManager();

               FragmentTransaction transaction = manager.beginTransaction();
               Fragment fragment = new Add();
               transaction.replace(R.id.fragContainer,fragment);
               transaction.commit();
               Toast.makeText(getApplicationContext(),"You just clicked Add Button",Toast.LENGTH_SHORT).show();
           }
       });
//       load subtract fragment
        subtract.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              FragmentManager manager = getSupportFragmentManager();
              FragmentTransaction transaction= manager.beginTransaction();
              Fragment fragment = new Sub();
              transaction.replace(R.id.fragContainer,fragment);
              transaction.commit();
               Toast.makeText(getApplicationContext(),"You just clicked Subtract Button",Toast.LENGTH_SHORT).show();

           }
       });


    }
}