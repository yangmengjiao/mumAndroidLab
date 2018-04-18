package edu.mum.lab4_2;

import java.io.Serializable;


class Product implements Serializable{
    public Product(String title, Float price, String color, String imageUrl, String itemId, String dec) {
        this.imageUrl = imageUrl;
        this.title = title;
        Color = color;
        this.price = price;
        this.dec = dec;
        this.itemId = itemId;
    }

    private String imageUrl;
    private String title;
    private String Color;
    private Float price;
    private String dec;
    private String itemId;


    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return Color;
    }

    public Float getPrice() {
        return price;
    }

    public String getDec() {
        return dec;
    }

    public String getItemId() {
        return itemId;
    }
}
