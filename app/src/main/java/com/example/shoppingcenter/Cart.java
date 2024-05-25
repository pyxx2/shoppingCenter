package com.example.shoppingcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = new Intent();
        //取出来用户名
        String username=intent.getStringExtra("username");
        Button back=(Button)findViewById(R.id.backGoods);
        Button takeOrder=(Button)findViewById(R.id.goorder2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Cart.this,goods.class);
                startActivity(intent);
            }
        });
        takeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Cart.this,OrderSuccess.class);
                startActivity(intent);
            }
        });
    }
}