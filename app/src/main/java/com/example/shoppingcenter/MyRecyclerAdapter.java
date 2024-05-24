package com.example.shoppingcenter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
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

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>  {

    private ItemData[] listdata;
    public MyRecyclerAdapter(ItemData[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


//        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = viewHolder.getAdapterPosition();
//                final ItemData itemData = listdata[position];
//                //Toast.makeText(view.getContext(),"Click: "+ itemData.getDescription(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MyRecyclerAdapter.this,goods.class);
//////将数据发送到intent中
//                intent.putExtra("price",price);
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//        });
        return viewHolder;
    }
    private static final int REQUEST_CODE = 1;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ItemData itemData = listdata[position];
        holder.textView.setText(itemData.getDescription());
        holder.imageView.setImageResource(itemData.getImgId());
        holder.price.setText(String.valueOf(itemData.getPrice()));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"Click: "+ itemData.getPrice(),Toast.LENGTH_SHORT).show();
                final float price=itemData.getPrice();
                Log.i(TAG, "onClick: "+price);
                Intent intent = new Intent(view.getContext(),goods.class);
                //将数据发送到intent中
                intent.putExtra("price",price);
                //打开新窗口
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
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
