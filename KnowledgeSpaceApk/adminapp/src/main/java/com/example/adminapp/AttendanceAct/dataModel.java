package com.example.adminapp.AttendanceAct;

public class dataModel {
    private int pImg;
    private String pName,pRollNo;

    public dataModel() {} //no-args constructor

    public dataModel(int pImg, String pName, String pRollNo) {
        this.pImg = pImg;
        this.pName = pName;
        this.pRollNo = pRollNo;
    }

    public int getpImg() {
        return pImg;
    }

    public void setpImg(int pImg) {
        this.pImg = pImg;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpRollNo() {
        return pRollNo;
    }

    public void setpRollNo(String pRollNo) {
        this.pRollNo = pRollNo;
    }
}
