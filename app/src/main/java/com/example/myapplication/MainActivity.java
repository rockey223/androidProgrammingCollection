package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Button firstPagebtn;
    EditText firstTextBox;
    Button firstPageSubmitbtn,dialogBtn,gotoList,gotorecycler;
    TextView holdMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Just to go  to another page
//        firstPagebtn = findViewById(R.id.firstPagebtn);
//        firstPagebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this,SecondPage.class);
//                startActivity(i);
//            }
//        });

//        To send data from one page  to another
        firstPageSubmitbtn= findViewById(R.id.firstPageSubmitbtn);
        firstTextBox= findViewById(R.id.firstTextBox);
        holdMenu = findViewById(R.id.holdMenu);
        dialogBtn = findViewById(R.id.dialogBtn);
        gotoList=findViewById(R.id.gotoList);
        gotorecycler = findViewById(R.id.gotorecycler);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }


        });
//go to List view page
        gotoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,listview.class);

                startActivity(i);
            }
        });
//        Go to recycler view page
        gotorecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,recycler_view.class);

                startActivity(i);
            }
        });


//        to navigate to another page and pass value from text field
        firstPageSubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = firstTextBox.getText().toString();
                Intent i = new Intent(MainActivity.this,SecondPage.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });

        registerForContextMenu(holdMenu);



    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setMessage("Are you sure you want yo exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked No", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //for context menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Your Option");
        getMenuInflater().inflate(R.menu.contextmenu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.contextItem1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextItem2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}