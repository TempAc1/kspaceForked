package com.example.knowledgespaceapk.GroupAct;

public class dataModelRecVFragGroup {

    String groupName;
    int groupImg;

    public dataModelRecVFragGroup(String groupName, int groupImg) {
        this.groupName = groupName;
        this.groupImg = groupImg;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(int groupImg) {
        this.groupImg = groupImg;
    }
}
