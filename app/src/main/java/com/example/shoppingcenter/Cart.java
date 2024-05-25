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

import java.util.ArrayList;
import java.util.Objects;

public class Cart extends AppCompatActivity {

    private MyDatabaseHelper mSQlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent =getIntent();
        //取出来用户名
        String username=intent.getStringExtra("username");
        ArrayList<ItemData> itemList = new ArrayList<>();
        mSQlite = new MyDatabaseHelper(this);
        ArrayList<cartGoods> data = mSQlite.getCART();
        for (int i = 0; i < data.size(); i++) {
            cartGoods goods = data.get(i);   //可存储账号数量
            if (goods.getUsername()!=null&&Objects.equals(username, goods.getUsername())) {
                //把商品信息取出来重新一条条加载到购物车页面中
                Log.i(TAG, "onCreate: "+i+"yyyyyyyyyyyyyyyy"+goods.getUsername());
                String goods_name=goods.getGoods_name();
                float goods_price=goods.getGoods_price();
                int goods_img=goods.getGoods_img();
                itemList.add(new ItemData(goods_name,goods_img,goods_price));
            }
        }
        ItemData[] itemData = new ItemData[itemList.size()];
        itemList.toArray(itemData);
        RecyclerView recyclerView = findViewById(R.id.recyclerview2);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(itemData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

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