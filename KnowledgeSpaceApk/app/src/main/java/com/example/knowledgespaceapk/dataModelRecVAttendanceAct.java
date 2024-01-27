package com.example.knowledgespaceapk;

public class dataModelRecVAttendanceAct {
    private String subName,pName;
    private int subAttendance;

    public dataModelRecVAttendanceAct(String subName, String pName, int subAttendance) {
        this.subName = subName;
        this.pName = pName;
        this.subAttendance = subAttendance;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getSubAttendance() {
        return subAttendance;
    }

    public void setSubAttendance(int subAttendance) {
        this.subAttendance = subAttendance;
    }
}
