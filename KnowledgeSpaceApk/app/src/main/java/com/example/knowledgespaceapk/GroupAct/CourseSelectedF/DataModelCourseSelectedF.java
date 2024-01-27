package com.example.knowledgespaceapk.GroupAct.CourseSelectedF;

public class DataModelCourseSelectedF {
    String chapterName;
    int totalNoOfModules;

    public DataModelCourseSelectedF() {
    }

    public DataModelCourseSelectedF(String chapterName, int totalNoOfModules) {
        this.chapterName = chapterName;
        this.totalNoOfModules = totalNoOfModules;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getTotalNoOfModules() {
        return totalNoOfModules;
    }

    public void setTotalNoOfModules(int totalNoOfModules) {
        this.totalNoOfModules = totalNoOfModules;
    }
}
