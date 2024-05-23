package com.example.shoppingcenter;

public class ItemData {
    private String description;
    private int imgId;
    private float price;


    public ItemData(String description, int imgId, float price) {
        this.description = description;
        this.imgId = imgId;
        this.price=price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
