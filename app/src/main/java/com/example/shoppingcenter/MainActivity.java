package com.example.shoppingcenter;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper mSQlite;
    public static String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //按钮的跳转功能
        Button button = (Button)findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.login);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=0;
                EditText username=findViewById(R.id.userName);
                EditText userpassword=findViewById(R.id.password);
                String name = username.getText().toString().trim();
                String password = userpassword.getText().toString().trim();
                Log.i(TAG, "onClick: "+name);
                Log.i(TAG, "onClick: "+password);
                if (name.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<User> data = mSQlite.getAllDATA();
                    boolean userdata = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);   //可存储账号数量
                        if (name.equals(user.getName())) {
                            userdata = true;
                            Log.i(TAG, "main  name : "+user.getName());
                            break;
                        } else {
                            userdata = false;
                        }
                    }
                    if (userdata) {
                        Name=name;
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,goods.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mSQlite = new MyDatabaseHelper(MainActivity.this);
    }
}