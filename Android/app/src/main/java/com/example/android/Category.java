package com.example.android;

public class Category {
    public Integer Id;
    public String Name, Description, Image;

    public Integer GetId() {
        return Id;
    }
    public void SetId(Integer Id) {
        this.Id = Id;
    }
    public String GetName() {
        return Name;
    }
    public void SetName(String Name) {
        this.Name = Name;
    }
    public String GetDescription() {
        return Description;
    }
    public void SetDescription(String Description) {
        this.Description = Description;
    }
    public String GetImage() {
        return Image;
    }
    public void SetImage(String Image) {
        this.Image = Image;
    }
}
