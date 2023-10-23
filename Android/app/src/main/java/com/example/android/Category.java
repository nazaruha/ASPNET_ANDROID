package com.example.android;

public class Category {
    public int id;
    public String name, description, image;

    public Integer GetId() {
        return id;
    }
    public void SetId(int id) {
        this.id = id;
    }
    public String GetName() {
        return name;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public String GetDescription() {
        return description;
    }
    public void SetDescription(String description) {
        this.description = description;
    }
    public String GetImage() {
        return image;
    }
    public void SetImage(String image) {
        this.image = image;
    }
}
