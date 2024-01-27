package com.example.knowledgespaceapk;

public class dataModelRecVContactAct {

    private String contactName, contactNumber;
    private int img;

    public dataModelRecVContactAct(String contactName, String contactNumber, int img) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.img = img;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
