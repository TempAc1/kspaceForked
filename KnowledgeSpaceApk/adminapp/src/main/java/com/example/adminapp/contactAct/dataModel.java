package com.example.adminapp.contactAct;

public class dataModel {
    private String contactName;
    private String number;
    private int img;

    public dataModel(){}//empty constructor

    public dataModel(String contactName, String number, int img) {
        this.contactName = contactName;
        this.number = number;
        this.img = img;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
