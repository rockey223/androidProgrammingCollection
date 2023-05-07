package com.example.myapplication.dbHelper;




import android.content.ContentValues;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.myapplication.databaseAdapter.DbAdapter;
import com.example.myapplication.model.User;
import com.example.myapplication.params.Params;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {


public DbHelper(Context context){
    super(context, Params.DATABASE_NAME,null,Params.DATABASE_VERSION);
}
@Override
    public void onCreate(SQLiteDatabase db){
    String createQuery = "CREATE TABLE "+Params.TABLE_NAME + "(" + Params.ID + " INTEGER PRIMARY KEY,"+ Params.NAME + " TEXT," + Params.ADDRESS + " TEXT," + Params.PHONE +" TEXT)";
    Log.d("dbPrashant", "db created " + createQuery);
    db.execSQL(createQuery);
}
@Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    db.execSQL("DROP TABLE IF EXISTS "+ Params.TABLE_NAME );
    onCreate(db);
}


//adding user to database
public void addUser(User user){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();

    values.put(Params.NAME,user.getName());
    values.put(Params.ADDRESS,user.getAddress());
    values.put(Params.PHONE,user.getPhone());

    db.insert(Params.TABLE_NAME,null,values);
    Log.d("dbPrashant", "addUser: Sucess");
    db.close();


}

//getting all data from database
public List<User> getAllUser(){
    List<User> userList = new ArrayList<>();
    SQLiteDatabase db = this.getReadableDatabase();

//    query t5o get data from database
    String select = "SELECT * FROM "+ Params.TABLE_NAME;

    Cursor cursor = db.rawQuery(select,null);

//    loop
    if(cursor.moveToFirst()){
        do{
            User user = new User();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setName(cursor.getString(1));
            user.setAddress(cursor.getString(2));
            user.setPhone(cursor.getString(3));
            userList.add(user);
        }while(cursor.moveToNext());
    }
    return userList;


}


//updating data in database
public int updateUser(User user){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(Params.NAME,user.getName());
    values.put(Params.ADDRESS,user.getAddress());
    values.put(Params.PHONE,user.getPhone());

//    updating
    return db.update(Params.TABLE_NAME,values,Params.ID + "=?", new String[]{String.valueOf(user.getId())});

}

public void deleteUserById(int id){
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(Params.TABLE_NAME,Params.ID + "=?",new String[]{String.valueOf(id)});
    db.close();
}


public void deleteUserByName(String name){
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(Params.TABLE_NAME,Params.NAME + "=?",new String[]{String.valueOf(name)});
    db.close();
}

public int getCount(){
    String query ="SELECT * FROM " + Params.TABLE_NAME;
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.rawQuery(query,null);
    return cursor.getCount();


}


}
