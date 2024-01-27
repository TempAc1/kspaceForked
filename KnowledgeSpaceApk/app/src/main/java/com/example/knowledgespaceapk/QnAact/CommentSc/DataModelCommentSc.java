package com.example.knowledgespaceapk.QnAact.CommentSc;

public class DataModelCommentSc {
    String commentatorName,commentatorRemarks;

    public DataModelCommentSc(String commentatorName, String commentatorRemarks) {
        this.commentatorName = commentatorName;
        this.commentatorRemarks = commentatorRemarks;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName;
    }

    public String getCommentatorRemarks() {
        return commentatorRemarks;
    }

    public void setCommentatorRemarks(String commentatorRemarks) {
        this.commentatorRemarks = commentatorRemarks;
    }
}
