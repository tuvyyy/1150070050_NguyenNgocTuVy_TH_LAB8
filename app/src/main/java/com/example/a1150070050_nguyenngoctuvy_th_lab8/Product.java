package com.example.a1150070050_nguyenngoctuvy_th_lab8;

public class Product {
    private int imageResId;
    private String title;
    private String content;

    public Product(int imageResId, String title, String content) {
        this.imageResId = imageResId;
        this.title = title;
        this.content = content;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
