package com.example.shoppingcenter;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class goods extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        String username=MainActivity.Name;
        Log.i(TAG, "goods 收到  name : "+username);

        Button button = (Button)findViewById(R.id.goorder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(goods.this,OrderSuccess.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.gocart);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                MainActivity.add_delete=false;//false为delete
                MainActivity.is_cart=true;
                intent.setClass(goods.this,Cart.class);
                startActivity(intent);
            }
        });

        ItemData[] itemData = new ItemData[] {
                new ItemData("苹果", R.drawable.p1,1f),
                new ItemData("香蕉", R.drawable.p2,3.8f),
                new ItemData("草莓", R.drawable.p3,8.9f),
                new ItemData("草莓", R.drawable.p4,7.8f),
                new ItemData("橙子", R.drawable.p5,45f),
                new ItemData("西瓜", R.drawable.p6,34f),
                new ItemData("菠萝", R.drawable.p7,6.7f),
                new ItemData("蓝莓", R.drawable.p8,0.9f),
                new ItemData("iphone15", R.drawable.p9,12345f),
                new ItemData("联想小新", R.drawable.p10,5678f),
                new ItemData("联想拯救者", R.drawable.p11,11000f),
        };
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(itemData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}