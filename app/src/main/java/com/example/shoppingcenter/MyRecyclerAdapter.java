package com.example.shoppingcenter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>  {

    private ItemData[] listdata;
    private MyDatabaseHelper mSQlite;
    private String username=MainActivity.Name;
    public MyRecyclerAdapter(ItemData[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }
    private static final int REQUEST_CODE = 1;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemData itemData = listdata[position];
        holder.textView.setText(itemData.getDescription());
        holder.imageView.setImageResource(itemData.getImgId());
        holder.price.setText(String.valueOf(itemData.getPrice()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化
                mSQlite=new MyDatabaseHelper(view.getContext());
                final String goods_name=itemData.getDescription();
                final int goods_img=itemData.getImgId();
                final float goods_price=itemData.getPrice();
                if(MainActivity.add_delete){//add
                    //Log.i(ContentValues.TAG, "adapter 收到  username : "+username);
                    mSQlite.add2(username,goods_name,goods_price,goods_img);
                }else {//delete
                    //删除数据库里面的数据
                     mSQlite.deleteSingleItem(username, goods_name);
                     holder.relativeLayout.animate()
                            .alpha(0.0f)
                            .setDuration(300)
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    // 动画完成后移除条目
                                    removeItem(holder.getAdapterPosition());
                                    Toast.makeText(view.getContext(), "已删除商品", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .start();
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return listdata.length;
    }
    public void removeItem(int position) {
        // 删除数据
        ArrayList<ItemData> list = new ArrayList<>(Arrays.asList(listdata));
        list.remove(position);
        listdata = list.toArray(new ItemData[0]);
        // 通知适配器条目被删除
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listdata.length);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView price;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
            this.price=(TextView) itemView.findViewById(R.id.price);
        }
    }
}
