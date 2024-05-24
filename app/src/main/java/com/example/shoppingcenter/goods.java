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
    Float sumprice=0f;
    Float nowprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        Button button = (Button)findViewById(R.id.goorder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(goods.this,OrderSuccess.class);
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

        Intent intent=getIntent();
        Log.i(TAG, "onCreate: "+intent.getFloatExtra("price",0f));
        nowprice=intent.getFloatExtra("price",0f);
        if (null != savedInstanceState) {
            sumprice = savedInstanceState.getFloat("price1");
            sumprice=sumprice+nowprice;
            Log.i(TAG, "sumprice: "+sumprice);
            TextView sum=findViewById(R.id.textView4);
            sum.setText("合计："+sumprice);

        }
    }
    protected void  onSaveInstanceState(Bundle outState) {

        outState.putFloat("price1",sumprice);//暂时保存在price1
        super.onSaveInstanceState(outState);
    }
//    protected void onRestoreInstanceState(Bundle saveInstanceState) {
//        super.onRestoreInstanceState(saveInstanceState);
//        //Log.i(TAG, "sumprise: "+sumprice);
//        sumprice=saveInstanceState.getFloat("price1");//取出保存的数据重新加载
//        sumprice=sumprice+nowprice;
//        Log.i(TAG, "sumprice: "+sumprice);
//        TextView sum=findViewById(R.id.textView4);
//        sum.setText("合计："+sumprice);
//    }
}