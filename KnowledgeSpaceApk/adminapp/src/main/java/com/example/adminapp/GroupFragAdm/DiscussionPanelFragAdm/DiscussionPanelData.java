package com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm;

public class DiscussionPanelData {
    String title,description;
    int resources;

    public DiscussionPanelData() {
    }

    public DiscussionPanelData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public DiscussionPanelData(String title, String description, int resources) {
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
