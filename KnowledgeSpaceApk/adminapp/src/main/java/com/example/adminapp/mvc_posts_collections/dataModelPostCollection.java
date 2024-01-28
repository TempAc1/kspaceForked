package com.example.adminapp.mvc_posts_collections;

import com.google.firebase.Timestamp;

public class dataModelPostCollection {
    String postTitle, postDesc, postAttachments, postTimestamp, postAuthor, instituteID;


    public dataModelPostCollection(){
       //gffdfdfno-args constructor
    }
    public dataModelPostCollection(String postTitle, String postDesc, String postAttachments, String postTimestamp, String postAuthor, String instituteID) {
        this.postTitle = postTitle;
        this.postDesc = postDesc;
        this.postAttachments = postAttachments;
        this.postTimestamp = postTimestamp;
        this.postAuthor = postAuthor;
        this.instituteID = instituteID;
    }

    @Override
    public String toString(){

        return "DataModelPostCollection{" +
                "title='" + postTitle + '\'' +
                ", description='" + postDesc + '\'' +
                ", author='" + postAuthor + '\'' +
                ", attachments ='" + postAttachments + '\'' +
                ", timestamp ='" + postTimestamp + '\'' +
                ", instituteID ='" + instituteID + '\'' +
                '}';

    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getPostAttachments() {
        return postAttachments;
    }

    public void setPostAttachments(String postAttachments) {
        this.postAttachments = postAttachments;
    }

    public String getPostTimestamp() {
        return postTimestamp;
    }

    public void setPostTimestamp(String postTimestamp) {
        this.postTimestamp = postTimestamp;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }
}
