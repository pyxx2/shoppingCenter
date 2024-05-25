package com.example.shoppingcenter;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class OrderSuccess extends AppCompatActivity {

    String username=MainActivity.Name;
    private MyDatabaseHelper mSQlite;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //实例化
        mSQlite = new MyDatabaseHelper(this);
        ArrayList<cartGoods> data = mSQlite.getCART();
        for (int i = 0; i < data.size(); i++) {
            mSQlite.deleteCart(username);
        }

        Button button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                MainActivity.add_delete=true;//true为add
                intent.setClass(OrderSuccess.this,goods.class);
                startActivity(intent);
            }
        });
    }

}
