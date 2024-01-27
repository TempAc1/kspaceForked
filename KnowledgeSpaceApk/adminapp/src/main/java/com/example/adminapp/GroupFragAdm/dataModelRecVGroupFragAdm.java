package com.example.adminapp.GroupFragAdm;

public class dataModelRecVGroupFragAdm {
    String groupName1,groupName2;
    int groupImg1,groupImg2;

    public dataModelRecVGroupFragAdm(String groupName1, String groupName2, int groupImg1, int groupImg2) {
        this.groupName1 = groupName1;
        this.groupName2 = groupName2;
        this.groupImg1 = groupImg1;
        this.groupImg2 = groupImg2;
    }

    public String getGroupName1() {
        return groupName1;
    }

    public void setGroupName1(String groupName1) {
        this.groupName1 = groupName1;
    }

    public String getGroupName2() {
        return groupName2;
    }

    public void setGroupName2(String groupName2) {
        this.groupName2 = groupName2;
    }

    public int getGroupImg1() {
        return groupImg1;
    }

    public void setGroupImg1(int groupImg1) {
        this.groupImg1 = groupImg1;
    }

    public int getGroupImg2() {
        return groupImg2;
    }

    public void setGroupImg2(int groupImg2) {
        this.groupImg2 = groupImg2;
    }
}

