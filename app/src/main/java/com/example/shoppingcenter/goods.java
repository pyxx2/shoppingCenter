package com.example.shoppingcenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class goods extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ItemData[] itemData = new ItemData[] {
                new ItemData("苹果", R.drawable.p1),
                new ItemData("香蕉", R.drawable.p2),
                new ItemData("草莓", R.drawable.p3),
                new ItemData("草莓", R.drawable.p4),
                new ItemData("橙子", R.drawable.p5),
                new ItemData("西瓜", R.drawable.p6),
                new ItemData("菠萝", R.drawable.p7),
                new ItemData("蓝莓", R.drawable.p8),
                new ItemData("iphone15", R.drawable.p9),
                new ItemData("联想小新", R.drawable.p10),
                new ItemData("联想拯救者", R.drawable.p11),
        };
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(itemData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}