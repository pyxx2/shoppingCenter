package com.example.shoppingcenter;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                EditText username=findViewById(R.id.userName);
                EditText userpassword=findViewById(R.id.password);
                String name = username.getText().toString().trim();
                String password = userpassword.getText().toString().trim();
                Log.i(TAG, "onClick: "+name);
                Log.i(TAG, "onClick: "+password);
                if (name.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this,"用户名或密码不能为空*****",Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<User> data = mSQlite.getAllDATA();
                    boolean userdata = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);   //可存储账号数量
                        if (name.equals(user.getName())) {
                            userdata = true;
                            break;
                        } else {
                            userdata = false;
                        }
                    }
                    if (userdata) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,goods.class);
                        //把用户名传到goods页面
                        intent.putExtra("username",name);
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