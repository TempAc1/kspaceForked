package com.example.knowledgespaceapk.GroupAct.DiscussionPanel;

public class DataModelRecVDiscussionPanelF {
    String title,description;
    int resources;

    public DataModelRecVDiscussionPanelF() {
    }

    public DataModelRecVDiscussionPanelF(String title, String description, int resources) {
        this.title = title;
        this.description = description;
        this.resources = resources;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }
}
