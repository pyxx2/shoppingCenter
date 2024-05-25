package com.example.shoppingcenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public MyDatabaseHelper(Context context){
        super(context,"db_test",null,10);
        db=getReadableDatabase();
    }
    public void onCreate(SQLiteDatabase db) {
        //用于登陆的用户表
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT)");
        //用户的购物车表
        db.execSQL("CREATE TABLE IF NOT EXISTS usercart("+
                "goods_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"username TEXT,"+
                "goods_name TEXT,"+"goods_price REAL,"+"goods_img INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS usercart");
        onCreate(db);
    }
    public void add(String name,String password ){
        db.execSQL("INSERT INTO user(name,password)VALUES(?,?)",new Object[]{name,password});
    }
    public void add2(String username,String goods_name,float goods_price,int goods_img){
        db.execSQL("INSERT INTO usercart(username,goods_name,goods_price,goods_img)VALUES(?,?,?,?)",new Object[]{username,goods_name,goods_price,goods_img});
    }

    public ArrayList<User> getAllDATA(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("user",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new User(name,password));
        }
        return list;
    }

    public ArrayList<cartGoods> getCART(){
        ArrayList<cartGoods> list = new ArrayList<cartGoods>();
        Cursor cursor = db.query("usercart",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("username"));
            @SuppressLint("Range") String goods_name = cursor.getString(cursor.getColumnIndex("goods_name"));
            @SuppressLint("Range") float goods_price = cursor.getFloat(cursor.getColumnIndex("goods_price"));
            @SuppressLint("Range") int goods_img = cursor.getInt(cursor.getColumnIndex("goods_img"));
            list.add(new cartGoods(username,goods_name,goods_price,goods_img));
        }
        return list;
    }
}

