package com.val.ravencase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String database_name = "ravencase.db";
    public static final String table_name = "users";
    public static final String col1 = "ID";
    public static final String col2 = "USERNAME";
    public static final String col3 = "NAME";
    public static final String col4 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, NAME TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public void insertData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, user.username);
        contentValues.put(col3, user.name);
        contentValues.put(col4, user.password);
        long result = db.insert(table_name,null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resultset = db.rawQuery("select * from " + table_name,null);
        return resultset;
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_name, // Selecting Table
                new String[] {
                        col1, col2, col3, col4}, //Selecting columns want to query
                col2 + "=?",
                new String[] {
                        user.username
                }, //Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_name, // Selecting Table
                new String[]{col1, col2, col3, col4}, //Selecting columns want to query
                col2 + "=?",
                new String[]{username}, //Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }

}