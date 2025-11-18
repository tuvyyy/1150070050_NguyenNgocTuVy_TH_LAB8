package com.example.a1150070050_nguyenngoctuvy_th_lab8;

public class Dish {
    private int imageResId;
    private String name;
    private String description;
    private double price;

    public Dish(int imageResId, String name, String description, double price) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
