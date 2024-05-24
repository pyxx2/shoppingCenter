package com.example.shoppingcenter;

import javax.xml.namespace.QName;

public class cartGoods {
    private String name;//本次登录用户名
    private String goods_name;//商品名称
    private float goods_price;//商品价格
    private int goods_img;//商品图片

    public cartGoods(String name, String goods_name,float goods_price,int goods_img){
        super();
        this.name = name;
        this.goods_img = goods_img;
        this.goods_name=goods_name;
        this.goods_price=goods_price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(float goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(int goods_img) {
        this.goods_img = goods_img;
    }
}
