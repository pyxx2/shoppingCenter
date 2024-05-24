package com.example.shoppingcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private MyDatabaseHelper mSQlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button regi=findViewById(R.id.yes_register);
        Button back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {//，不要注册，返回主页面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username=findViewById(R.id.edit_userName);
                EditText userpassword=findViewById(R.id.edit_password);
                EditText userpassword2=findViewById(R.id.edit_password2);
                String name = username.getText().toString().trim();
                String password = userpassword.getText().toString().trim();   //获取输入的用户名和密码
                String password2=userpassword2.getText().toString().trim();
                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)){
                    if(!password.equals(password2)){
                        Toast.makeText(Register.this,"两次密码不一致，注册失败",Toast.LENGTH_SHORT).show();
                    }else {
                        mSQlite.add(name,password);
                        Intent intent1 = new Intent(Register.this,MainActivity.class);
                        startActivity(intent1);
                        finish();
                        Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
                    }
                }else {Toast.makeText(Register.this,"信息不完备，注册失败",Toast.LENGTH_SHORT).show();}
            }
        });
        mSQlite = new MyDatabaseHelper(Register.this);

    }
}